import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import store from './store/store'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import ECharts from 'vue-echarts';
import 'echarts/lib/chart/bar';
import 'echarts/lib/chart/line';
import 'echarts/lib/chart/scatter';
import 'echarts/lib/component/tooltip';

Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.component('v-chart', ECharts)

axios.defaults.headers.common['Authorization'] = store.state.token
axios.defaults.crossDomain = true;

new Vue({
  router,
  store,
  render: h => h(App),
  data:{
    eventBus:new Vue()
  },
}).$mount('#app')

axios.interceptors.request.use(config => {
  //判断是否存在token，如果存在将每个页面header都添加token
    if(store.state.token){
      config.headers['Authorization']=store.state.token.token
      // config.headers['Authorization']=store.state.token
      console.log(config);
    }
    return config;
  }, error => {
    return Promise.reject(error);
  });
  
// http response 拦截器
axios.interceptors.response.use(
  response => {
    return response;
  },
  error => {
    if (error.response) {
      switch (error.response.status) {
        case 401:
          this.$store.commit('del_token');
          router.replace({
            path: '/login',
            query: {redirect: router.currentRoute.fullPath}//登录成功后跳入浏览的当前页面
          })
      }
    }
    return Promise.reject(error.response.data)
  });