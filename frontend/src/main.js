import { createApp } from 'vue'
import { createI18n } from 'vue-i18n'
import App from './App.vue'
import en from './locales/en.json'
import ja from './locales/ja.json'
import id from './locales/id.json'

const i18n = createI18n({
  legacy: false,
  locale: 'en',
  messages: { en, ja, id }
})

createApp(App).use(i18n).mount('#app')
