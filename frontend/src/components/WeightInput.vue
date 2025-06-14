<template>
  <form @submit.prevent="submitWeight">
    <label for="weight">{{ $t('weightLabel') }}</label>
    <input id="weight" type="number" step="0.1" v-model="weight" required />
    <button type="submit">{{ $t('saveButton') }}</button>
  </form>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const weight = ref('')

const submitWeight = async () => {
  await axios.post('/api/weights', {
    weight: parseFloat(weight.value),
    recordedAt: new Date().toISOString()
  })
  weight.value = ''
}
</script>
