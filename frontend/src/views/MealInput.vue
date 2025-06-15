<template>
  <form @submit.prevent="submitMeal">
    <div>
      <label for="menuText">{{ $t('menuTextLabel') }}</label>
      <input id="menuText" v-model="menuText" required />
    </div>
    <button
      type="submit"
      :disabled="isSubmitting"
      @click="submitMeal"
    >
      {{ $t('submitButton') }}
    </button>
  </form>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const menuText = ref('')
const isSubmitting = ref(false)

const submitMeal = async () => {
  if (isSubmitting.value) return
  isSubmitting.value = true
  try {
    await axios.post('/api/meals', { menuText: menuText.value })
    console.log('アップロード成功')
    menuText.value = ''
  } catch (err) {
    console.error(err)
  } finally {
    isSubmitting.value = false
  }
}
</script>
