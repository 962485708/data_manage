import Vue from 'vue'
import App from './App.vue'
import router from './router'

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

new Vue({
  router,
  render: h => h(App),
  data:{
    eventBus:new Vue()
  },
}).$mount('#app')