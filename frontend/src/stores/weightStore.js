import { ref } from 'vue'
import axios from 'axios'

const weights = ref([])

const fetchWeights = async () => {
  try {
    const res = await axios.get('/api/weights')
    weights.value = res.data
  } catch (err) {
    console.error('Failed to fetch weights', err)
  }
}

const addWeight = (record) => {
  weights.value.push(record)
}

export function useWeightStore() {
  return { weights, fetchWeights, addWeight }
}
