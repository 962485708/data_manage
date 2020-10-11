<template>
  <div class="data-warn">
    <div class="data-title">
      <span>监控参数配置</span>
    </div>
    <warn-table/>
  </div>
</template>

<script>
import warnTable from '../../../components/main/details/tables/warnTable.vue'
export default {
  components: {
    warnTable
  }
}
</script>

<style>
  .data-warn {
    width: 100%;
  }
  .data-title {
    color: #4F62C4;
    font-size: 3em;
    font-weight: 600;
    margin: 20px 0;
    padding-left: 50px;
  }
</style>