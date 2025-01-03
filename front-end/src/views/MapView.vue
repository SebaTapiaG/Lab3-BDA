<template>
  <div class="map-container">
    <div>
      <h2>Calcula el punto medio entre dos clientes</h2>
      <div class="inputs">
        <!-- Seleccionar cliente 1 -->
        <label for="client1">Cliente 1:</label>
        <select v-model="client1Id" id="client1">
          <option disabled value="">Selecciona un cliente</option>
          <option v-for="cliente in clientes" :key="cliente.id_cliente" :value="cliente.id_cliente">
            {{ cliente.nombre }} - {{ cliente.telefono }}
          </option>
        </select>

        <!-- Seleccionar cliente 2 -->
        <label for="client2">Cliente 2:</label>
        <select v-model="client2Id" id="client2">
          <option disabled value="">Selecciona un cliente</option>
          <option v-for="cliente in clientes" :key="cliente.id_cliente" :value="cliente.id_cliente">
            {{ cliente.nombre }} - {{ cliente.telefono }}
          </option>
        </select>

        <button @click="fetchMidpoint">Calcular Punto Medio</button>
      </div>
    </div>

    <!-- Mapa -->
    <div id="map" style="height: 500px;"></div>
  </div>
</template>

<script>
import L from 'leaflet';
import clientService from '../services/client.service';
import ubicacionIcon from '@/assets/ubicacion.png';
import ubicacionPuntoMedio from '@/assets/ubicacion_pm.png';

export default {
  name: 'MapView',
  data() {
    return {
      clientes: [],
      client1Id: null,
      client2Id: null,
      map: null,
      midpointMarker: null,
      client1Marker: null,
      client2Marker: null,
      client1Icon: L.icon({
        iconUrl: ubicacionIcon,
        iconSize: [48, 48],
        iconAnchor: [16, 32],
        popupAnchor: [0, -32],
      }),
      client2Icon: L.icon({
        iconUrl: ubicacionIcon,
        iconSize: [48, 48],
        iconAnchor: [16, 32],
        popupAnchor: [0, -32],
      }),
      puntoMedioIcon: L.icon({
        iconUrl: ubicacionPuntoMedio,
        iconSize: [48, 48],
        iconAnchor: [16, 32],
        popupAnchor: [0, -32],
      }),
    };
  },
  methods: {
    async fetchClientes() {
      try {
        const response = await clientService.getAll();
        this.clientes = response.data;
      } catch (error) {
        console.error('Error al obtener la lista de clientes:', error);
        alert('No se pudo obtener la lista de clientes.');
      }
    },
    async fetchMidpoint() {
      try {
        if (!this.client1Id || !this.client2Id) {
          alert('Por favor, selecciona ambos clientes.');
          return;
        }

        const client1Response = await clientService.get(this.client1Id);
        const client2Response = await clientService.get(this.client2Id);

        const client1 = client1Response.data;
        const client2 = client2Response.data;

        const client1Coords = [client1.latitud, client1.longitud];
        const client2Coords = [client2.latitud, client2.longitud];

        if (!this.client1Marker) {
          this.client1Marker = L.marker(client1Coords, { icon: this.client1Icon })
            .addTo(this.map)
            .bindPopup(`<b>${client1.nombre}</b>`)
            .openPopup();
        } else {
          this.client1Marker.setLatLng(client1Coords).setPopupContent(`<b>${client1.nombre}</b>`).openPopup();
        }

        if (!this.client2Marker) {
          this.client2Marker = L.marker(client2Coords, { icon: this.client2Icon })
            .addTo(this.map)
            .bindPopup(`<b>${client2.nombre}</b>`)
            .openPopup();
        } else {
          this.client2Marker.setLatLng(client2Coords).setPopupContent(`<b>${client2.nombre}</b>`).openPopup();
        }

        const puntoMedioWKT = await clientService.puntoMedio(this.client1Id, this.client2Id);
        if (!puntoMedioWKT) {
          alert('No se encontró el punto medio.');
          return;
        }

        const coordinates = puntoMedioWKT
          .replace('POINT(', '')
          .replace(')', '')
          .split(' ')
          .map(coord => parseFloat(coord));
        const [lng, lat] = coordinates;

        if (!this.midpointMarker) {
          this.midpointMarker = L.marker([lat, lng], { icon: this.puntoMedioIcon })
            .addTo(this.map)
            .bindPopup('<b>Punto Medio</b>')
            .openPopup();
        } else {
          this.midpointMarker.setLatLng([lat, lng]).setPopupContent('<b>Punto Medio</b>').openPopup();
        }

        const bounds = L.latLngBounds([client1Coords, client2Coords, [lat, lng]]);
        this.map.fitBounds(bounds);
      } catch (error) {
        console.error('Error al obtener el punto medio:', error);
        alert('Ocurrió un error al calcular el punto medio.');
      }
    },
  },
  mounted() {
    this.map = L.map('map').setView([0, 0], 2);
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
    }).addTo(this.map);
    this.fetchClientes();
  },
};
</script>

<style>
.map-container {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}

h2 {
  text-align: center;
  margin-bottom: 1rem;
}

.inputs {
  margin-bottom: 1rem;
}

#map {
  width: 80%;
  border: 1px solid #ccc;
}
</style>
