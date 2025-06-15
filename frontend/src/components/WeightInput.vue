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
import { useWeightStore } from '../stores/weightStore'

const emit = defineEmits(['submitted'])
const { addWeight } = useWeightStore()

const weight = ref('')

const submitWeight = async () => {
  try {
    const res = await axios.post('/api/weights', {
      weight: parseFloat(weight.value),
      recordedAt: new Date().toISOString()
    })
    addWeight(res.data)
    weight.value = ''
    emit('submitted', res.data)
  } catch (err) {
    console.error('Failed to register weight', err)
  }
}
</script>
