<template>
  <div id="app">
    <!-- 接收路由首页 -->
    <router-view v-wechat-title='$route.meta.title'/>
  </div>
</template>

<script>

export default {
  name: 'App',
    mounted() {
      window.addEventListener("unload",this.saveState);
    },
    methods:  {
      saveState: function () {
        sessionStorage.setItem("state",JSON.stringify(this.$store.state.User));
      }
    }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
