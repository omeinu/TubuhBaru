<template>
  <canvas ref="canvas"></canvas>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import axios from 'axios'
import { Chart } from 'chart.js/auto'
import { useI18n } from 'vue-i18n'

const canvas = ref(null)
const chart = ref(null)
const { t } = useI18n()

const fetchWeights = async () => {
  const res = await axios.get('/api/weights')
  return res.data
}

const renderChart = async () => {
  const weights = await fetchWeights()
  const labels = weights.map(w => new Date(w.recordedAt).toLocaleDateString())
  const data = weights.map(w => w.weight)

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

onMounted(renderChart)

defineExpose({ renderChart })
</script>

