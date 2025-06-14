<template>
  <form @submit.prevent="submitWeight">
    <div>
      <label for="weight">Weight:</label>
      <input id="weight" type="number" step="0.1" v-model.number="weight" required />
    </div>
    <div>
      <label for="recordedAt">Recorded At:</label>
      <input id="recordedAt" type="datetime-local" v-model="recordedAt" required />
    </div>
    <button type="submit">Submit</button>
  </form>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const weight = ref(0)
const recordedAt = ref('')

const submitWeight = async () => {
  try {
    await axios.post('/api/weights', {
      weight: weight.value,
      recordedAt: recordedAt.value
    })
    console.log('weight saved')
  } catch (err) {
    console.error(err)
  }
}
</script>
