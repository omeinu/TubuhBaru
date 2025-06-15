<template>
  <canvas ref="canvas"></canvas>
</template>

<script setup>
import { onMounted, ref, watch } from 'vue'
import { useWeightStore } from '../stores/weightStore'
import { Chart } from 'chart.js/auto'
import { useI18n } from 'vue-i18n'

const canvas = ref(null)
const chart = ref(null)
const { t } = useI18n()
const { state, fetchWeights, addWeight: storeAddWeight } = useWeightStore()

const renderChart = () => {
  const labels = state.weights.map(w => new Date(w.recordedAt).toLocaleDateString())
  const data = state.weights.map(w => w.weight)

  if (chart.value) {
    chart.value.data.labels = labels
    chart.value.data.datasets[0].data = data
    chart.value.update()
  } else {
    chart.value = new Chart(canvas.value.getContext('2d'), {
      type: 'line',
      data: {
        labels,
        datasets: [
            {
              label: t('weightChartLabel'),
              data,
              borderColor: 'rgb(75, 192, 192)',
              fill: false,
              tension: 0.1
          }
        ]
      }
    })
  }
}

const refetch = async () => {
  await fetchWeights()
}

const connectStream = () => {
  const es = new EventSource('/api/weights/stream')
  es.onmessage = (e) => {
    const record = JSON.parse(e.data)
    addWeight(record)
  }
}

const addWeight = (record) => {
  storeAddWeight(record)
}

onMounted(() => {
  refetch()
  connectStream()
})

watch(
  () => state.weights,
  () => {
    renderChart()
  },
  { deep: true }
)

defineExpose({ refetch, addWeight })
</script>

