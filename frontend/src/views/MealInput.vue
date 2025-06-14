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
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const menuText = ref('')
const imageFile = ref(null)

const onFileChange = (e) => {
  imageFile.value = e.target.files[0]
}

const submitMeal = async () => {
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
  } catch (err) {
    console.error(err)
  }
}
</script>
