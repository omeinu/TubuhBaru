<template>
  <form @submit.prevent="submitMeal">
    <div>
      <label for="menuText">{{ $t('menuTextLabel') }}</label>
      <input id="menuText" v-model="menuText" required />
    </div>
    <div>
      <label for="image">{{ $t('imageLabel') }}</label>
      <input id="image" type="file" @change="onFileChange" required />
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
const imageFile = ref(null)
const isSubmitting = ref(false)

const onFileChange = (e) => {
  imageFile.value = e.target.files[0]
}

const submitMeal = async () => {
  if (isSubmitting.value) return
  isSubmitting.value = true
  const formData = new FormData()
  formData.append('menuText', menuText.value)
  if (imageFile.value) {
    formData.append('image', imageFile.value)
  }
  try {
    await axios.post('/api/meals', formData, {
      headers: { 'Content-Type': 'multipart/form-data' }
    })
    console.log('アップロード成功')
    menuText.value = ''
    imageFile.value = null
  } catch (err) {
    console.error(err)
  } finally {
    isSubmitting.value = false
  }
}
</script>
