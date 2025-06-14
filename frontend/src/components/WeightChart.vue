<template>
  <canvas ref="canvas"></canvas>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { Chart, registerables } from 'chart.js';

const canvas = ref(null);

onMounted(async () => {
  const res = await fetch('/api/weights');
  const data = await res.json();

  Chart.register(...registerables);
  const ctx = canvas.value.getContext('2d');
  new Chart(ctx, {
    type: 'line',
    data: {
      labels: data.map(w => new Date(w.recordedAt).toLocaleDateString()),
      datasets: [{
        label: 'Weight',
        data: data.map(w => w.weight),
        borderColor: 'blue',
        tension: 0.3,
        fill: false
      }]
    },
    options: {
      responsive: true,
      scales: {
        x: {
          display: true
        },
        y: {
          display: true
        }
      }
    }
  });
});
</script>
