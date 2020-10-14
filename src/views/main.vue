<template>
  <div class="main">
    <tab-bar/>
    <div class="wrapper">
      <menu-left class="manual-left"/>
      <div class="menu-right">
        <keep-alive>
          <router-view/>
        </keep-alive>
      </div>
    </div>
  </div>
</template>

<script>
import tabBar from '../components/main/tabBar.vue'
import menuLeft from '../components/main/menuLeft.vue'
export default {
  components: {
    tabBar,
    menuLeft,
  },
}
</script>

<style scoped>
  .main {
    min-width: 1200px;
    min-height: 650px;
    width: 1200px;
    margin: auto;
    padding-bottom: 50px;
    position: relative;
  }
  .wrapper {
    position: relative;
    width: 100%;
    min-height: 100vh;
    margin-top: 60px;
    display: flex;
  }
  .wrapper:after {
    content: '';
    display: block;
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    right: 0;
    left: 0;
    bottom: 0;
    background: url('../assets/img/main/底色.jpg') repeat-y;
    background-size: contain;
    opacity: 0.3;
    z-index: -1;
  }
  .manual-left {
    width: 178px;
    position: fixed;
    top: 60px;
    z-index: 99;
    height: fit-content;
  }
  .menu-right {
    width: 100%;
    position: relative;
    margin-left: 178px;
  }
</style>