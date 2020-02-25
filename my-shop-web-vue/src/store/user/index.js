const User = {
  // 全局 state 对象，用于保存所有组件的公共数据,常量，设定了值就无法修改了
// 如果state存在就把json字符串转为state，否则创建一个新的state
  state : sessionStorage.getItem("state") ? JSON.parse(sessionStorage.getItem("state")) : {
    // 定义一个 user 对象
    // 在组件中是通过 this.$store.state.user 来获取
    user: {
      username: ""
    }
  },

// 实时监听 state 值的最新状态，注意这里的 getters 可以理解为计算属性(存储，并不是加减乘除的计算)
  getters: {
    // 在组件中是通过 this.$store.getters.getUser 来获取
    getUser(state)  {
      return state.user;
    }
  },

  // 定义改变 state 初始值的方法，这里是唯一可以改变 state 的地方，缺点是只能同步执行
  mutations: {
    // 在组件中是通过 this.$store.commit('updateUser', user); 来调用 mutations
    updateUser(state, user) {
      state.user = user;
    }
  },

  // 定义触发 mutations 里函数的方法，可以异步执行 mutations 里的函数
  actions: {
    // 在组件中是通过 this.$store.dispatch('asyncUpdateUser', user); 来调用 actions
    asyncUpdateUser(context, user) {
      // commit是把方法变成异步执行
      context.commit('updateUser',user);
    }
  },
}

export default User;
