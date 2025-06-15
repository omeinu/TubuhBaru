import { reactive } from 'vue'
import axios from 'axios'

const state = reactive({
  weights: []
})

const fetchWeights = async () => {
  try {
    const res = await axios.get('/api/weights')
    state.weights = res.data
  } catch (err) {
    console.error('Failed to fetch weights', err)
  }
}

const addWeight = (record) => {
  state.weights.push(record)
}

export function useWeightStore() {
  return { state, fetchWeights, addWeight }
}
