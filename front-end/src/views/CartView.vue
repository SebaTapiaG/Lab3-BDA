<template>
	<div v-for="product in products" class="card">
		<Card>
			<template #title>{{ product[0] }}</template>
			<template #content>
				<p>Cantidad: {{ product[1] }} unidad(es)</p>
				<p>Precio: {{ product[2] }}$</p>
			</template>
		</Card>
	</div>
	<div class="text">
		<p>Costo total: {{ precio }}</p>
	</div>
	<div class="button">
		<Button @click="guardarOrden">Guardar orden</Button>
	</div>
	<div class="button">
		<Button @click="comprarOrden">Comprar orden</Button>
	</div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { Button, InputNumber, Card } from "primevue";
import { jwtDecode } from "jwt-decode";
import ordenService from '../services/orden.service';
import detalleOrdenService from '../services/detalleOrden.service';
import zonaService from "@/services/zona.service";
import L from 'leaflet';
import 'leaflet/dist/leaflet.css';

import 'leaflet-control-geocoder/dist/Control.Geocoder.css';
import 'leaflet-control-geocoder';
import axios from "axios";

const products = ref([]);
const precio = ref([]);
const zonasRestringidas = ref([]);
const values = new Array(products.length).fill(null);
var map;
var latitud;
var longitud;


onMounted(async () => {
	try {
		// Importar Leaflet y Geocoder desde la CDN
    const L = window.L;

		const misProductos = sessionStorage.getItem('carrito')
		products.value = misProductos ? JSON.parse(misProductos) : [];
		var price = 0;
		for (const product of products.value) {
			price += product[2]
		}
		precio.value = price;

		
		const response = await zonaService.getByEstado("Restringida")
		zonasRestringidas.value = response.data
		console.log(response.data)

		// 1️⃣ Inicializar el mapa
    map = L.map('map').setView([0, 0], 2); // Vista inicial (lat, lng, zoom)

    // 2️⃣ Agregar la capa de OpenStreetMap
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
    }).addTo(map);

    // 3️⃣ Agregar la barra de búsqueda (Leaflet Control Geocoder)
    const geocoder = L.Control.geocoder({
      defaultMarkGeocode: true
    }).addTo(map);

		function wktToLeafletCoordinates(wkt) {
    const coordinatesText = wkt.match(/\(\(([^)]+)\)\)/)[1]; // Extraer el texto entre (())
    const coordinatePairs = coordinatesText.split(','); // Separar las coordenadas
    const leafletCoordinates = coordinatePairs.map(pair => {
      const [lng, lat] = pair.trim().split(' ').map(Number);
      return [lat, lng]; // Leaflet usa [lat, lng]
    });
    return leafletCoordinates;
  }

  // 5️⃣ Mostrar cada polígono en el mapa
  zonasRestringidas.value.forEach(zona => {
    const polygonCoordinates = wktToLeafletCoordinates(zona.area); // Convertir WKT a coordenadas Leaflet
    const polygon = L.polygon(polygonCoordinates, {
      color: 'red',               // Color del borde
      fillColor: 'orange',        // Color de fondo
      fillOpacity: 0.5            // Opacidad del relleno
    }).addTo(map);

    // 6️⃣ Agregar un popup al hacer clic en el polígono
    polygon.bindPopup(`<b>${zona.nombre}</b><br>Estado: ${zona.estado}`);
  });

    // 4️⃣ Evento para manejar la acción de búsqueda
    geocoder.on('markgeocode', (e) => {
      const latlng = e.geocode.center; // Coordenadas de la dirección encontrada
      const popupContent = `Dirección encontrada: ${e.geocode.name}`;
			latitud = latlng.lat;
			longitud = latlng.lng;

      // Agregar un marcador en la ubicación encontrada
      L.marker(latlng).addTo(map)
        .bindPopup(popupContent)
        .openPopup();

      // Centrar el mapa en la ubicación encontrada
      map.setView(latlng, 16);
    });
	} catch (error) {
		console.error('Error fetching products:', error);
	}
});

async function guardarOrden() {
	const idUsuario = sessionStorage.getItem('userId');
	const carrito = JSON.parse(sessionStorage.getItem('carrito'));

	let productos = [];

	for (const item of carrito) {
    const nuevoProducto = {producto: item[0], cantidad: item[1], precio: item[2]  }
		productos.push(nuevoProducto)
  }

	if (true) {
		const fecha = new Date();
		const fechaISO = fecha.toISOString(); // Formato 'yyyy-MM-ddTHH:mm:ss.SSSZ'
		const fechaSinMilisegundos = fechaISO.split('.')[0];
		console.log(fechaSinMilisegundos);

		const orden = {
			fechaOrden: fechaSinMilisegundos,
			estado: "pendiente",
			emailCliente: idUsuario,
			total: precio.value,
			latitud: 0,
			longitud: 0,
			detalles: productos
		};

		try {
			// Crear la orden
			console.log(orden)
			const response = await ordenService.create(orden);			

			// Limpiar el carrito y recargar la página
			sessionStorage.setItem('carrito', []);
			alert("Orden creada correctamente");
			window.location.reload(); // Recargar la página

		} catch (error) {
			console.error("Error al crear la orden:", error.response?.data?.message || error.message);
			alert(`Error: ${error.response?.data?.message || 'No se pudo crear la orden'}`);
		}
	}
}

async function comprarOrden() {
	const idUsuario = sessionStorage.getItem('userId');
	const carrito = JSON.parse(sessionStorage.getItem('carrito'));

	let productos = [];

	for (const item of carrito) {
    const nuevoProducto = {producto: item[0], cantidad: item[1], precio: item[2] / item[1]  }
		productos.push(nuevoProducto)
  }

	if (true) {
		const fecha = new Date();
		const fechaISO = fecha.toISOString(); // Formato 'yyyy-MM-ddTHH:mm:ss.SSSZ'
		const fechaSinMilisegundos = fechaISO.split('.')[0];
		console.log(fechaSinMilisegundos);

		const orden = {
			fechaOrden: fechaSinMilisegundos,
			estado: "pagada",
			emailCliente: idUsuario,
			total: precio.value,
			latitud: 0,
			longitud: 0,
			detalles: productos
		};

		try {
			// Crear la orden
			console.log(orden)
			const response = await ordenService.create(orden);			

			// Limpiar el carrito y recargar la página
			sessionStorage.setItem('carrito', []);
			alert("Orden creada correctamente");
			window.location.reload(); // Recargar la página

		} catch (error) {
			console.error("Error al crear la orden:", error.response?.data?.message || error.message);
			alert(`Error: ${error.response?.data?.message || 'No se pudo crear la orden'}`);
		}
	}
}
async function verCoordenadas() {
	console.log(latitud, longitud)
}
</script>

<style scoped>
.map-container {
  width: 100%;
  height: 500px;
}

::v-deep(.leaflet-control-geocoder-form input) {
  color: black !important; 
  background-color: white !important; 
  border: 1px solid #ddd !important; 
  font-size: 16px !important; 
  padding: 10px !important; 
  width: auto !important; 
  visibility: visible !important; 
}

::v-deep(.leaflet-control-geocoder-form) {
  position: relative !important; 
  z-index: 10000 !important; 
}
</style>