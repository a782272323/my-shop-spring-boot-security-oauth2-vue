<template>
  <div>
    <el-form ref="form" :model="form" :rules="rules" label-width="80px" class="login-box">
      <h1 class="login-title">欢迎登录</h1>
      <el-form-item label="账号" class="login-title" prop="username">
        <el-input v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" class="login-title" prop="password">
        <el-input type="password" v-model="form.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="login('form')">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

    export default {
        name: "Login",
        data()  {
            return {
                form: {
                    username: '',
                    password: ''
                },
                rules: {
                    username: [
                        {required: true, message: '请输入账号', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'}
                    ]
                }
            }
        },
        methods:  {
            login: function (formName) {
                this.$refs[formName].validate((valid) => {
                    // 验证成功跳转首页
                    if (valid)  {
                        sessionStorage.setItem("isLogin","true");
                        this.$store.dispatch("asyncUpdateUser",this.form);
                        this.$message({
                            showClose: false,
                            type: "success",
                            message: '登录成功！'
                        });
                        // 使用 vue-router 路由到指定页面，该方式称之为编程式导航
                        this.$router.push("/main");
                    }
                    // 登录验证失败
                    else {
                        this.$message({
                            // showClose 表示提示之后一段时间自动删除
                            showClose: false,
                            type: "error",
                            message: '请您输入账号密码'
                        });
                        console.log('error submit!');
                        return false;
                    }
                });


            }
        }
    }
</script>

<style scoped>
  .login-title  {
    text-align: center;
  }


  .login-box {
    // 兼容html的css样式，若不懂自行百度
    text-align: left;
    width: 400px;
    border: 1px solid #DCDFE6;
    margin: 0 auto;
    margin-top: 150px;
    padding: 20px 50px 20px 20px;
    border-radius: 5px;
    box-shadow: 0 0 20px;
  }
</style>
