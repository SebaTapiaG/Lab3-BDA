<template>
    <div class="select-tarjeta">
      <h2>Selecciona una tarjeta para el pago</h2>
      <div v-if="tarjetas.length">
        <ul>
          <li v-for="tarjeta in tarjetas" :key="tarjeta.numero">
            <label>
              <input 
                type="radio" 
                name="tarjeta" 
                :value="tarjeta.numero" 
                v-model="tarjetaSeleccionada" 
              />
              {{ tarjeta.numero }} - {{ tarjeta.nombre }}
            </label>
          </li>
        </ul>
      </div>
      <div v-else>
        <p>No tienes tarjetas registradas. Agrega una para continuar.</p>
      </div>
  
      <div class="actions">
        <Button @click="mostrarFormulario = true">Añadir tarjeta</Button>
        <Button :disabled="!tarjetaSeleccionada" @click="confirmarPago">Confirmar</Button>
      </div>
  
      <!-- Modal para añadir tarjeta -->
      <Dialog v-model:visible="mostrarFormulario" header="Añadir Tarjeta" modal>
        <AddTarjeta @close="mostrarFormulario = false" />
      </Dialog>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import clienteService from '@/services/client.service';
  import { Button, Dialog } from 'primevue';
  import AddTarjeta from '@/views/AddTarjeta.vue';
  
  const tarjetas = ref([]);
  const tarjetaSeleccionada = ref(null);
  const mostrarFormulario = ref(false);
  const email = sessionStorage.getItem('userId');
  
  onMounted(async () => {
    try {
      const response = await clienteService.getTarjetas(email);
      tarjetas.value = response.data;
    } catch (error) {
      console.error("Error al obtener las tarjetas:", error);
      alert("No se pudieron cargar las tarjetas.");
    }
  });
  
  function confirmarPago() {
    if (tarjetaSeleccionada.value) {
      alert(`Tarjeta seleccionada: ${tarjetaSeleccionada.value}`);
      // Lógica para confirmar el pago.
    }
  }
  </script>
  