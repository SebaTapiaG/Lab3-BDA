<template>
	<div v-for="(order, index) in orders" class="card" :key="order.id_orden">
		<Card>
			<template #title>Información de la orden: {{ order.id_orden }}</template>
			<template #content>
				<p>Fecha: {{ order.fechaOrden }}</p>
				<p>Estado: {{ order.estado }}</p>
				
				<h3>Detalles:</h3>
				<div v-for="(detalle, index) in order.detalles" :key="detalle.id">
					<strong>- Producto: {{ detalle.producto }} -</strong>
					<p>Cantidad: {{ detalle.cantidad }}</p>
					<p>Costo unitario: {{ detalle.precio }}$</p>
				</div>
				<p>Costo total de la orden: {{ order.total }}$</p>
				<span v-if="order.estado === 'pendiente'">
					<Button @click="pagarOrden(index)">Pagar</Button>
				</span>
			</template>
		</Card>
	</div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { Button, InputNumber, Card } from "primevue";
import { jwtDecode } from "jwt-decode";
import ordenService from '../services/orden.service';

const orders = ref([]);

onMounted(async () => {
	try {
		const id = sessionStorage.getItem('userId')
		const response = await ordenService.findByCliente(id);
		orders.value = response.data
		console.log(response.data)
	} catch (error) {
		console.error('Error fetching products:', error);
	}
});

async function pagarOrden(index) {
	const order = orders.value[index]
	console.log(order)
	const newOrder = {
		id_orden: order.id_orden,
		fecha_orden: order.fecha_orden,
		estado: "pagada",
		id_cliente: order.id_cliente,
		total: order.total
	}

	try {
		console.log(newOrder)
		const response = await ordenService.updateOrder(newOrder);
		if (response.data.estado === "fallida") {
			window.alert("No se puede realizar esta compra, por lo tanto se eliminara la orden")
			window.location.reload()
		}

	} catch (error) {
		console.log(error)
	}

	function verDetalles(orden){
		return
	}


}

</script>