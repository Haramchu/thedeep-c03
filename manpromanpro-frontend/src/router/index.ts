import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ProyekView from '../views/ProyekView.vue'
import CreateProyekView from '../views/CreateProyekView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
      {
          path: '/',
          name: 'home',
          component: HomeView
      },
      {
          path: '/proyek',
          name: 'proyek',
          component: ProyekView,
      },
      {
          path: '/proyek/add',
          name: 'tambah_proyek',
          component: CreateProyekView
      }
  ]
})

export default router
