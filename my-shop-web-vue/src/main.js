// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
// 入口函数
import Vue from 'vue'
import App from './App'
// 引入路由
import router from './router'
// 引入修改路由页面标题插件
import VueWechatTitle from 'vue-wechat-title'
// 引入 ElementUI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 引入 axios
import axios from 'axios'
// 原型链，反正配合引入axios使用就行了
Vue.prototype.axios = axios;
// 引入 vuex
import Vuex from 'vuex'
// 引入 store
import store from './store'

Vue.config.productionTip = false

// 使用 ElementUI
Vue.use(ElementUI);
// 使用 标题插件
Vue.use(VueWechatTitle);
// 使用 vuex
Vue.use(Vuex);

// 每次页面跳转都触发路由,验证是否有登录信息
router.beforeEach((to,from,next) => {
  console.log("触发路由");
  let isLogin = sessionStorage.getItem("isLogin");

  // 如果注销了登录信息，就跳转登录页面
  if (to.path == "/logout") {
    sessionStorage.clear();
    next({path: '/login'});
  }
  // 如果已经登录成功，则跳转到页面首页
  else if (to.path == "/login") {
    console.log("登录页");
    if (isLogin == "true") {
      console.log("已经登录");
      next({path: '/main'});
    }
  }
  // 没有登录
  else if (isLogin == null){
    console.log("没有登录");
    next({path: 'login'});
  }

next();
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>',
  // 自定义路由
  router,
  // store
  store,
  // ElementUI
  render: h => h(App)
});
