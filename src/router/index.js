import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

  const routes = [
    {
      path: '/',
      redirect: '/login'
    },
    {
      name:'login',
      path:'/login',
      component:()=>import('../components/login/login.vue')
    },
    {
      name:'register',
      path:'/register',
      component:()=>import('../components/login/register.vue')
    },
  ]

  const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
  })

export default router