<template>
  <div class="main">
    <div class="wrapper">
      <!-- <bar-diagram/> -->
      <!-- <line-diagram/> -->
      <diagram/>
    </div>
  </div>
</template>

<script>
// import BarDiagram from '../components/main/barDiagram.vue'
// import LineDiagram from '../components/main/lineDiagram.vue'
import Diagram from '../components/main/diagram.vue'
export default {
  components: {
    // BarDiagram,
    // LineDiagram
    Diagram
  }
}
</script>

<style scoped>
  .main {
    min-width: 1200px;
    min-height: 650px;
    width: 100vw;
    height: 100vh;
    position: relative;
  }
</style>