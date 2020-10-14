<template>
  <div class="develop">
    <diagram :diagramdata="diagramdata"/>
  </div>
</template>

<script>
import Diagram from '../../diagram.vue'
export default {
  components: {
    Diagram
  },
  
}
</script>

<style>
  .develop {
    width: 100%;
  }
</style>