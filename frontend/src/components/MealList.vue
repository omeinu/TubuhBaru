<template>
  <div>
      <div v-for="meal in meals" :key="meal.id" class="meal-card">
        <h3>{{ meal.menuText }}</h3>
        <p>{{ meal.aiComment }}</p>
        <small>{{ formatDate(meal.createdAt) }}</small>
      </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const meals = ref([])

const fetchMeals = async () => {
  const res = await axios.get('/api/meals')
  meals.value = res.data
}

onMounted(fetchMeals)

const formatDate = (d) => new Date(d).toLocaleString()
</script>

<style scoped>
.meal-card {
  border: 1px solid #ccc;
  padding: 1rem;
  margin-bottom: 1rem;
}
</style>

