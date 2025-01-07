<template>
  <div class="product-view">
    <div class="card">
			<Galleria :value="images" :numVisible="5" containerStyle="max-width: 640px"
    :showThumbnails="false" :showIndicators="true" :changeItemOnIndicatorHover="true">
    <template #item="slotProps">
        <img :src="slotProps.item.itemImageSrc" :alt="slotProps.item.alt" style="width: 100%; display: block" />
    </template>
</Galleria>
				<Card>
        <template #title>{{ product?.nombre }}</template>
        <template #content>
          <p>{{ product?.descripcion }}</p>
          <p>Precio: {{ product?.precio }}$</p>
          <p>Stock: {{ product?.stock }} unidades</p>
        </template>
      </Card>
    <Panel header="Video de ejemplo">
      <video controls width="100%">
        <source src= "video" type="video/mp4" />
        Tu navegador no soporta el elemento <code>video</code>.
      </video>
    </Panel>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import { Card } from 'primevue';
import {Galleria} from 'primevue';
import ProductoComp from '@/components/ProductCard.vue'; 
import productoService from '@/services/producto.service';
import {Panel} from 'primevue';


const route = useRoute();
const nombre = route.params.nombre; // Obtiene el ID del producto de la URL

const product = ref(null);
const images = ref([
  {
    itemImageSrc: new URL('@/assets/galaxy-a55-5g-negro-v2-01_276x549.jpg', import.meta.url).href,
    thumbnailImageSrc: new URL('@/assets/galaxy-a55-5g-negro-v2-01_276x549.jpg', import.meta.url).href,
    alt: 'Imagen del producto',
    title: 'Producto'
  },
	{
    itemImageSrc: new URL('@/assets/2CC27509983.jpg', import.meta.url).href,
    thumbnailImageSrc: new URL('@/assets/2CC27509983.jpg', import.meta.url).href,
    alt: 'Imagen del producto',
    title: 'Producto'
  }
]);

const video = new URL('@/assets/Nuevos Galaxy A55 .mp4', import.meta.url).href


const responsiveOptions = ref([
    {
        breakpoint: '1300px',
        numVisible: 4
    },
    {
        breakpoint: '575px',
        numVisible: 1
    }])

async function fetchProductData() {
  try {
		console.log(nombre)
    const response = await productoService.findByNombre("Smartphone");
    product.value = response.data;
		console.log(response.data)
  } catch (error) {
    console.error(error);
  }
}

onMounted(() => {
  fetchProductData();
});
</script>

<style scoped>
.product-view {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
}

.view-title {
  margin-bottom: 20px;
  font-size: 24px;
  font-weight: bold;
}

.loading {
  font-size: 18px;
  color: #888;
}
</style>
