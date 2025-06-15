<template>
  <form @submit.prevent="submitMeal">
    <div>
      <label for="menuText">{{ $t('menuTextLabel') }}</label>
      <input id="menuText" v-model="menuText" required />
    </div>
    <button type="submit">{{ $t('submitButton') }}</button>
  </form>
  <p v-if="message">{{ message }}</p>
</template>

<script setup>
import { ref } from 'vue'

const menuText = ref('')
const message = ref('')

const submitMeal = async () => {
  const res = await fetch('/api/meals', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ menuText: menuText.value })
  })
  const data = await res.json()
  // display the AI generated comment returned by the backend
  message.value = data.aiComment
  menuText.value = ''
}
</script>
