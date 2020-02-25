<template>
    <div>
      用户列表
      {{id}}
    </div>
</template>

<script>

    export default {
        props: ["id"],
        name: "list",
        // 进入前
        beforeRouteEnter(to,from,next)  {
            console.log("页面进入前")
            next(vm => {
                vm.getData();
            }); // 可以支持回调
        },
        // 进入后
        beforeRouteLeave(to,from,next)  {
            console.log("页面离开前")
            next();
        },
        methods:  {
            getData: function () {
                this.axios({
                    type: 'get',
                    url: 'http://localhost:1235/static/data.json'
                }).then(response => { // 链式编程的用法
                    console.log(response);
                }).catch(error => {
                    console.log(error);
                });
            }
        }
    }
</script>

<style scoped>

</style>
