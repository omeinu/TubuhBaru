<template>
  <div>
    <label for="lang-select">Language:</label>
    <select id="lang-select" v-model="locale">
      <option value="en">English</option>
      <option value="ja">日本語</option>
      <option value="id">Bahasa Indonesia</option>
    </select>
  </div>
  <h1>{{ $t('title') }}</h1>
  <WeightInput @submitted="onWeightAdded" />
  <WeightChart ref="chart" />
  <MealInput />
  <MealList />
</template>

<script setup>
import MealInput from './components/MealInput.vue'
import MealList from './components/MealList.vue'
import WeightInput from './components/WeightInput.vue'
import WeightChart from './components/WeightChart.vue'
import { useI18n } from 'vue-i18n'
import { ref } from 'vue'

const { locale } = useI18n()
const chart = ref(null)

const onWeightAdded = (record) => {
  chart.value?.addWeight(record)
}
</script>

