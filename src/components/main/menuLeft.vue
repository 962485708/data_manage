<template>
  <div class="manue">
    <div class="nav-menu">
      <el-row class="tac">
        <el-col :span="12">
          <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            :router=true >
            <el-menu-item index="1" :route="{path:'/main/integration'}">
              <span slot="title">异构数据集成</span>
            </el-menu-item>
            <el-submenu index="2">
              <template slot="title">
                <span>数据展现</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="2-1" :route="{path:'/main/details/market'}">销售部</el-menu-item>
                <el-menu-item index="2-2" :route="{path:'/main/details/develop'}">开发部</el-menu-item>
                <el-menu-item index="2-3" :route="{path:'/main/details/operation'}">运营部</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-menu-item index="3" :route="{path:'/main/analysis'}">
              <span slot="title">数据分析</span>
            </el-menu-item>
            <el-menu-item index="4" :route="{path:'/main/datawarn'}">
              <span slot="title">数据智能预警</span>
            </el-menu-item>
          </el-menu>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>
  .nav-menu,
  .el-menu-vertical-demo {
    width: 178px;
  }
  .nav-menu>>>.el-menu {
    background: none;
    border: none;
  }
  .nav-menu>>>.el-menu-item,
  .nav-menu>>>.el-submenu__title {
    color: #4F62C4;
    font-size: 2.5em;
    font-weight: 600;
    letter-spacing: 0.08em;
    padding: 30px 40px 30px 40px;
    display: flex;
    align-items: center;
    min-width: 0;
  }
  .nav-menu>>>.el-menu-item.is-active {
    background-color: #647BF7;
    color: #fff;
    border-radius: 5px;
  }
  .nav-menu>>>.el-menu-item-group .el-menu-item {
    font-weight: 500;
    margin: 10px 0 10px 0;
  }
  .nav-menu>>>.el-menu-item-group__title {
    padding: 0;
  }
</style>