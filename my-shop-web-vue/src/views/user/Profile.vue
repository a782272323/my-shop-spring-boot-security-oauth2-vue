<template>
    <div>
      个人信息
      {{$route.params.id}}
    </div>
</template>

<script>

    export default {
        name: "Profile",
        beforeRouteEnter: (to, from, next) => {
            console.log("准备进入个人信息页");
            next(vm => {
                vm.getData();
            });
        },
        beforeRouteLeave: (to, from, next) => {
            console.log("准备离开个人信息页");
            next();
        },
        methods:  {
            getData: function () {
                this.axios({
                    methods: 'get',
                    url: 'http://localhost:4444/static/data.json'
                }).then(response => {
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
