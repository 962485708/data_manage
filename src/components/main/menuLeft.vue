<template>
  <div class="manue">
    <div class="nav-menu">
      <el-row class="tac">
        <el-col :span="12">
          <el-menu
            :default-active="activeMenu"
            class="el-menu-vertical-demo"
            :router=true >
            <el-menu-item index="1" :route="{path:'/main/integration'}">
              <span slot="title">异构数据集成</span>
            </el-menu-item>
            <el-submenu index="2">
              <template slot="title">
                <span>数据展现</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="2-1" :route="{path:'/main/dataShow/sale'}">销售部</el-menu-item>
                <el-menu-item index="2-2" :route="{path:'/main/dataShow/develop'}">开发部</el-menu-item>
                <el-menu-item index="2-3" :route="{path:'/main/dataShow/operation'}">运营部</el-menu-item>
                <el-menu-item index="2-4" :route="{path:'/main/dataShow/account'}">财务部</el-menu-item>
                <el-menu-item index="2-5" :route="{path:'/main/dataShow/hr'}">人力资源部</el-menu-item>
                <el-menu-item index="2-6" :route="{path:'/main/dataShow/market'}">市场营销部</el-menu-item>
                <el-menu-item index="2-7" :route="{path:'/main/dataShow/security'}">保卫部</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-menu-item index="3" :route="{path:'/main/analysis'}">
              <span slot="title">数据分析</span>
            </el-menu-item>
            <el-menu-item index="4" :route="{path:'/main/datawarn'}">
              <span slot="title">数据智能预警</span>
            </el-menu-item>
            <el-menu-item index="5" :route="{path:'/main/setting'}">
              <span slot="title">设置</span>
            </el-menu-item>
          </el-menu>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeMenu: '1',
      navConfig: {
        'index': '2',
        'dataShow/sale': '2-1',
        'dataShow/develop': '2-2',
        'dataShow/operation': '2-3',
        'dataShow/account': '2-4',
        'dataShow/hr': '2-5',
        'dataShow/market': '2-6',
        'dataShow/security': '2-7',
        'integration': '1',
        'analysis': '3',
        'datawarn': '4',
        'setting': '5'
      },
    }
  },
  mounted() {
    //保证浏览器刷新后，之前选中的路由仍高亮
    var that = this
    var href = window.location.href
    href = href.split('/main/')[1]
    that.activeMenu = this.navConfig[href]
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
  .nav-menu>>>.el-menu-item-group {
    height: 300px;
    overflow-y: scroll;
  }
  .nav-menu>>>.el-menu-item-group__title {
    padding: 0;
  }
</style>