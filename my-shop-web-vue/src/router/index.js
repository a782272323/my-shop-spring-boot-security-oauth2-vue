import Vue from 'vue'
import Router from "vue-router"
import Login from "../views/Login"
import Main from "../views/Main"
import UserProfile from '../views/user/Profile'
import UserList from '../views/user/List'
import NotFound from "../views/NotFound";

Vue.use(Router);

export default new Router({
  routes: [
    { // 登录页
      path: '/login', name: 'Login', component: Login
    },
    { // 首页
      path: '/main', name: 'Main', component: Main,
      children: [
        {path: '/user/profile/:id', name:'UserProfile', component: UserProfile},
        {path: '/user/list/:id', name:'UserList', props: true, component: UserList}
      ]
    },
    { // 重定向
      path: '/goHome', redirect: '/main'
    },
    // { // 错误页面提示
    //   path: '*', component: NotFound
    // }
  ]
});
