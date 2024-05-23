import { createRouter, createWebHistory } from 'vue-router'
import People from '../views/People.vue'
import PeopleDetail from '../views/PeopleDetail.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'People',
      component: People
    },
    {
      path: '/people/:id',
      name: 'PeopleDetail',
      component: PeopleDetail
    }
  ]
})

export default router
