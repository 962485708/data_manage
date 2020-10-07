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
      component:()=>import('../views/login.vue')
    },
    {
      name:'main',
      path:'/main',
      component:()=>import('../views/main.vue'),
      children:[
        {
          name:'integration',
          path:'integration',
          component:()=>import('../components/main/details/integration.vue'),
        },
        {
          name:'market',
          path:'details/market',
          component:()=>import('../components/main/details/dataShow/market.vue'),
        },
        {
          name:'develop',
          path:'details/develop',
          component:()=>import('../components/main/details/dataShow/develop.vue'),
        },
        {
          name:'operation',
          path:'details/operation',
          component:()=>import('../components/main/details/dataShow/operation.vue'),
        },
        {
          name:'analysis',
          path:'analysis',
          component:()=>import('../components/main/details/analysis.vue'),
        },
        {
          name:'datawarn',
          path:'datawarn',
          component:()=>import('../components/main/details/dataWarn.vue'),
        },
      ]
    }
  ]
  const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
  })

export default router