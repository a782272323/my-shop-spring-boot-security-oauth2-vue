import Vue from 'vue' // 导入vue
import Vuex from 'vuex' // 导入vuex
import User from './user'
// 使用vuex
Vue.use(Vuex);

export default new Vuex.Store({
  modules:  {
    User
  }
})

