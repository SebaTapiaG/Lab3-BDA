<template>
  <div>

    <!-- Mostrar Productos -->
    <div v-for="(product, index) in products" :key="product.id_producto" class="card">
      <Card>
        <template #title>{{ product.nombre }} ({{ product.estado }})</template>
        <template #content>
          <p>{{ product.descripcion }}</p>
          <p>Precio: {{ product.precio }}$</p>
          <p>Stock: {{ product.stock }} unidades</p>
          <span v-if="product.stock > 0">
            <div>
              <label for="cantidad">Cantidad: </label>
              <InputNumber v-model="values[index]" inputId="minmax" :min="0" :max="product.stock" fluid />
            </div>
            <br />
						<Button
              @click="verDetalles( product.nombre )">Ver Detalles</Button>
            <Button
              @click="agregarCarrito( product.nombre, values[index], product.precio, index)">Agregar
              al carrito</Button>
          </span>
        </template>
      </Card>
    </div>
  </div>
</template>


<script setup>
import { ref, onMounted } from "vue";
import { Button, InputNumber, Card } from "primevue";
import productoService from '../services/producto.service';
import router from "@/router";

// Categorías disponibles
const categories = ref([
  { id: 1, name: 'Electrónica' },
  { id: 2, name: 'Ropa' },
  { id: 3, name: 'Hogar' },
  { id: 4, name: 'Juguetes' },
  { id: 5, name: 'Deportes' }
]);

// Estado para los productos y la categoría seleccionada
const products = ref([]);
const values = ref([]);
const selectedCategory = ref('');

// Cargar productos cuando el componente se monte
onMounted(async () => {
  try {
    const response = await productoService.getAll();
    products.value = response.data; // Guardamos los productos iniciales
  } catch (error) {
    console.error('Error fetching products:', error);
  }
});

// Filtrar productos por categoría
const filtrarPorCategoria = async () => {
  if (selectedCategory.value) {
    try {
      // Llamada a la API para obtener productos filtrados por categoría
      const response = await productoService.findByCategoria(selectedCategory.value);
      products.value = response.data; // Actualizar los productos con los filtrados
    } catch (error) {
      console.error('Error fetching filtered products:', error);
    }
  } else {
    const response = await productoService.getAll();
    products.value = response.data;
  }
};

function agregarCarrito( producto, cantidad, precio, indice) {
  const nuevoProducto = [ producto, cantidad, cantidad * precio];
  const misProductos = sessionStorage.getItem('carrito');

  let productos = misProductos ? JSON.parse(misProductos) : [];

  let encontrado = false;
  for (const producto of productos) {
    if (producto[0] === nuevoProducto[0]) {
      producto[1] += cantidad;
      producto[2] += cantidad * precio;
      encontrado = true;
      break;
    }
  }

  if (!encontrado) {
    productos.push(nuevoProducto);
  }

  sessionStorage.setItem('carrito', JSON.stringify(productos));
}

function verDetalles(nombre) {
    router.push(`/producto/${nombre}`);
}

</script>


<style>
.card {
  margin-top: 1%;
}

select {
  padding: 8px 12px;
  font-size: 14px;
  border-radius: 5px;
  border: 1px solid #ccc;
  margin-right: 10px;
  transition: border-color 0.3s ease;
}

select:focus {
  border-color: #007ad9;
}
</style>