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
      meta: { requireAuth: true },
      component:()=>import('../views/main.vue'),
      children:[
        {
          name:'integration',
          path:'integration',
          meta: { requireAuth: true },
          component:()=>import('../components/main/details/integration.vue'),
        },
        {
          name:'analysis',
          path:'analysis',
          meta: { requireAuth: true },
          component:()=>import('../components/main/details/analysis.vue'),
        },
        //dataShow
        {
          name:'market',
          path:'dataShow/market',
          meta: { requireAuth: true },
          component:()=>import('../components/main/details/dataShow/market.vue'),
        },
        {
          name:'develop',
          path:'dataShow/develop',
          meta: { requireAuth: true },
          component:()=>import('../components/main/details/dataShow/develop.vue'),
        },
        {
          name:'sale',
          path:'dataShow/sale',
          meta: { requireAuth: true },
          component:()=>import('../components/main/details/dataShow/sale.vue'),
        },
        {
          name:'security',
          path:'dataShow/security',
          meta: { requireAuth: true },
          component:()=>import('../components/main/details/dataShow/security.vue'),
        },
        {
          name:'account',
          path:'dataShow/account',
          meta: { requireAuth: true },
          component:()=>import('../components/main/details/dataShow/account.vue'),
        },
        {
          name:'operation',
          path:'dataShow/operation',
          meta: { requireAuth: true },
          component:()=>import('../components/main/details/dataShow/operation.vue'),
        },
        {
          name:'hr',
          path:'dataShow/hr',
          meta: { requireAuth: true },
          component:()=>import('../components/main/details/dataShow/hr.vue'),
        },
        {
          name:'datawarn',
          path:'datawarn',
          meta: { requireAuth: true },
          component:()=>import('../components/main/details/dataWarn.vue'),
        },
        {
          name:'setting',
          path:'setting',
          meta: { requireAuth: true },
          component:()=>import('../components/main/details/setting.vue')
        },
      ]
    }
  ]
  const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
  })

  router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requireAuth)){  // 判断该路由是否需要登录权限
      if(to.path === '/login') {
        next();
      } else {
        let token = sessionStorage.getItem('token');
        if(token === null || token === '') {
          next('/login');
        }else {
          next();
        }
      }
    }else {
      next();
    }
  });

export default router