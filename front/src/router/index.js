import Vue from 'vue'
import Router from 'vue-router'
import xcbc from '../../pages/xcbc.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'xcbc',
      component: xcbc
    },
  ]
})
