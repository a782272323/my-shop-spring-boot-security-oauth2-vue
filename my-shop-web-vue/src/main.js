// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from "./router"
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueRouter from 'vue-router'
import axios from 'axios'
import Vuex from 'vuex'
import store from './store'


Vue.config.productionTip = false;
Vue.use(VueRouter);
Vue.use(ElementUI);
Vue.prototype.axios = axios;
Vue.use(Vuex);


router.beforeEach((to, from, next) => {
  // 获取用户登录状态
  let isLogin = sessionStorage.getItem("isLogin");
  // 注销
  if (to.path == '/logout') {
    // 清空
    sessionStorage.clear();
    // 跳转登录
    next({path: '/login'});
  }
  // 如果请求的是登录页
  else if (to.path == '/login') {
    if (isLogin != null) {
      // 跳转登录页
      next({path: '/main'});
    }
  }
  // 如果为非登录状态
  else if (isLogin == null) {
    // 跳转到登录页
    next({path: '/login'});
  }
  // 下一个路由
  next();

});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  // components: { App },
  // template: '<App/>',
  // 配置路由
  router,
  store,
  // ElementUI,
  render: h => h(App)
});

