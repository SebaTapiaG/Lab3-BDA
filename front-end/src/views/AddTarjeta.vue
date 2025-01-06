<template>
    <div class="add-tarjeta">
      <h2>Añadir Tarjeta</h2>
      <form @submit.prevent="guardarTarjeta">
        <fieldset>
          <legend>Información de la Tarjeta</legend>
          <label>
            Número de Tarjeta:
            <input 
              v-model="tarjeta.numero" 
              type="text" 
              maxlength="16" 
              placeholder="1234 5678 9012 3456" 
              required 
            />
          </label>
          <label>
            CVV:
            <input 
              v-model="tarjeta.cvv" 
              type="text" 
              maxlength="3" 
              placeholder="123" 
              required 
            />
          </label>
          <label>
            Fecha de Vencimiento:
            <div class="fecha-vencimiento">
              <select v-model="mesSeleccionado" required>
                <option disabled value="">Mes</option>
                <option v-for="mes in meses" :key="mes" :value="mes">
                  {{ mes }}
                </option>
              </select>
              <select v-model="añoSeleccionado" required>
                <option disabled value="">Año</option>
                <option v-for="año in años" :key="año" :value="año">
                  {{ año }}
                </option>
              </select>
            </div>
          </label>
          <label>
            <input v-model="tarjeta.esCredito" type="checkbox" />
            Es una tarjeta de crédito
          </label>
        </fieldset>
        <Button type="submit">Guardar</Button>
      </form>
    </div>
  </template>
  
  <script setup>
  import { ref, computed } from 'vue';
  import clienteService from '@/services/client.service';
  
  // Datos de la tarjeta
  const tarjeta = ref({
    numero: '',
    nombre: '',
    cvv: '',
    fechaVencimiento: '',
    esCredito: false,
  });
  
  // Obtener usuario
  const email = sessionStorage.getItem('userId');
  
  // Opciones de mes y año
  const meses = ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'];
  const años = Array.from({ length: 10 }, (_, i) => (new Date().getFullYear() + i).toString().slice(-2));
  
  // Selecciones del usuario
  const mesSeleccionado = ref('');
  const añoSeleccionado = ref('');
  
  // Guardar tarjeta
  async function guardarTarjeta() {
    try {
      // Validaciones básicas
      if (!/^\d{16}$/.test(tarjeta.value.numero)) {
        alert("El número de tarjeta debe tener 16 dígitos.");
        return;
      }
      if (!/^\d{3}$/.test(tarjeta.value.cvv)) {
        alert("El CVV debe ser un número de 3 dígitos.");
        return;
      }
  
      // Formatear la fecha de vencimiento
      if (!mesSeleccionado.value || !añoSeleccionado.value) {
        alert("Por favor selecciona mes y año de vencimiento.");
        return;
      }
      tarjeta.value.fechaVencimiento = `${mesSeleccionado.value}/${añoSeleccionado.value}`;
  
      // Llamar al servicio para guardar
      await clienteService.addTarjeta(email, tarjeta.value);
      alert("Tarjeta añadida correctamente");
  
      // Limpiar el formulario
      tarjeta.value = { numero: '', nombre: '', cvv: '', fechaVencimiento: '', esCredito: false };
      mesSeleccionado.value = '';
      añoSeleccionado.value = '';
    } catch (error) {
      console.error("Error al añadir la tarjeta:", error);
      alert("No se pudo añadir la tarjeta.");
    }
  }
  </script>
  
  <style scoped>
  .add-tarjeta {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  .add-tarjeta h2 {
    text-align: center;
    margin-bottom: 20px;
  }
  .add-tarjeta form label {
    display: flex;
    flex-direction: column;
    margin-bottom: 15px;
  }
  .add-tarjeta form input,
  .add-tarjeta form select {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
  }
  .fecha-vencimiento {
    display: flex;
    gap: 10px;
  }
  .add-tarjeta form Button {
    width: 100%;
    padding: 10px;
    font-size: 16px;
    background-color: #4caf50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  .add-tarjeta form Button:hover {
    background-color: #45a049;
  }
  </style>
  