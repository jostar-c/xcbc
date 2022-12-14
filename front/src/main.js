// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import globalvariable from '../global_variable.js'
import globalfunc from '../global_func'
import ElementUI from 'element-ui'
import axios from 'axios'
import VueAxios from 'vue-axios'


import 'element-ui/lib/theme-chalk/index.css'

Vue.use(ElementUI)

Vue.config.productionTip = false
Vue.prototype.global = globalvariable
Vue.use(globalfunc)
Vue.use(VueAxios, axios)
Vue.prototype.$axios = axios;



/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
