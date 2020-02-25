<template>
  <div>
    <!-- 容器 -->
    <el-container style="height: 500px; border: 1px solid #eee">
      <!-- 左边侧边栏 -->
      <el-aside width="200px" style="background-color: rgb(238,241,246)">
        <!-- 侧边栏的导航，:default-openeds配置的是默认展开的导航里面的选项 -->
        <el-menu :default-openeds="['1']">
          <!-- 侧边栏的第一个导航 -->
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>用户管理</template>
            <!-- 导航一里面的选项 -->
            <el-menu-item-group>
              <!-- 插槽 -->
<!--              <template slot="title">分组一</template>-->
              <el-menu-item index="1-1"><router-link to="/user/list/2"> 用户列表</router-link> </el-menu-item>
              <el-menu-item index="1-2"><router-link to="/user/add/1"> 新增用户</router-link> </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <!-- 侧边栏的第二个导航 -->
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>商品管理 </template>
            <!-- 导航二里面的选项 -->
            <el-menu-item-group>
<!--              <template slot="title">分组一</template>-->
              <el-menu-item index="2-1">商品列表</el-menu-item>
              <el-menu-item index="2-2">新增商品</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <i class="el-icon-setting" style="marg-right: 15px;"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item><router-link to="/home"> 首页</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/logout"> 注销</router-link></el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>{{this.$store.getters.getUser.username}}</span>
        </el-header>

        <el-main>
          <!-- 路由 -->
          <router-view />
<!--          <el-table :data="tableData">-->
<!--            <el-table-column prop="date" label="日期" width="140"></el-table-column>-->
<!--            <el-table-column prop="name" label="姓名" width="120"></el-table-column>-->
<!--            <el-table-column prop="address" label="地址"></el-table-column>-->
<!--          </el-table>-->
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>

    export default {
        name: "Main",
        data()  {
            const item = {
                data: '2020-02-20',
                name: '梁鸿斌',
                address: '广东省湛江市麻章区'
            };
            return {
                tableData: Array(20).fill(item)
            }
        }
    };
</script>

<style scoped>
  .el-header  {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>
