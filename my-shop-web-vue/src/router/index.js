import Vue from 'vue'
import Router from  'vue-router'

// 首页
import Main from '@/views/Main'
// 登录页
import Login from '@/views/Login'

// 用户列表页
import UserList from '@/views/user/List';
// 新增用户列
import UserAdd from '@/views/user/Add';

// 404页面
import NotFount from '@/views/404';

Vue.use(Router)

// 路由配置
export default new Router({
  routes:[
    // 登录
    {
      name: 'Login', path: '/login', component: Login, meta: {title: '登录'}
    },
    // 登录
    // {
    //   name: 'Login', path: '/', component: Login, meta: {title: '登录'}
    // },
    // 首页
    {
      name: 'Main', path: '/main', component: Main, meta: {title: '首页'},
      // 配置嵌套路由
      children: [
        { // 用户列表
          name: 'UserList', path: '/user/list/:id', component: UserList, props: true, meta: {title: '用户列表'}
        },
        { // 新增用户
          name: 'UserAdd', path: '/user/add/:id', component: UserAdd, meta: {title: '新增用户'}
        }
      ]
    },
    //重定向到首页
    {
      path: '/home',
      redirect: '/main'
    },
    // 404页面
    // {
    //   path: '*',
    //   component: NotFount
    // }
  ]
})
