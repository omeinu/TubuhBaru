<template>
  <form @submit.prevent="submitMeal">
    <div>
      <label for="menuText">Menu Text:</label>
      <input id="menuText" v-model="menuText" required />
    </div>
    <div>
      <label for="image">Image:</label>
      <input id="image" type="file" @change="onFileChange" required />
    </div>
    <button type="submit">Submit</button>
  </form>
  <p v-if="message">{{ message }}</p>
</template>

<script setup>
import { ref } from 'vue'

const menuText = ref('')
const file = ref(null)
const message = ref('')

const onFileChange = (e) => {
  file.value = e.target.files[0]
}

const submitMeal = async () => {
  const formData = new FormData()
  formData.append('menuText', menuText.value)
  formData.append('image', file.value)
  const res = await fetch('/api/meals', {
    method: 'POST',
    body: formData
  })
  const data = await res.json()
  message.value = data.message
}
</script>
