<template>
  <div class="main">
    <tab-bar/>
    <div class="wrapper">
      <menu-left class="manual-left"/>
      <div class="menu-right">
        <router-view/>
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
    height: 900px;
    margin: auto;
    position: relative;
  }
  .wrapper {
    position: relative;
    height: 900px;
    width: 100%;
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
  }
  .menu-right {
    width: 100%;
    position: relative;
  }
</style>