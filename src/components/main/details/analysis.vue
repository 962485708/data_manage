<template>
  <div class="analysis">
    <div class="analysis-title">
      <span>请配置需要分析的数据、算法来源</span>
    </div>
    <div class="ana-data-wrapper">
      <div class="ana-data-wrapper-text">
        <span>*</span>
        <span>数据来源</span>
      </div>
      <ana-data-table class="analysis-form"/>
    </div>
    <div class="ana-arith-wrapper">
      <div class="ana-arith-wrapper-text">
        <span>*</span>
        <span>算法来源</span>
      </div>
      <arith-table class="analysis-form"/>
    </div>
  </div>
</template>

<script>
import anaDataTable from '../../../components/main/details/tables/anaDataTable.vue'
import arithTable from '../../../components/main/details/tables/arithTable.vue'
export default {
  name: 'analysis',
  components: {
    anaDataTable,
    arithTable
  }
}
</script>

<style scoped>
  .analysis {
    width: 100%;
    padding: 0 50px;
  }
  .analysis-title {
    color: #4F62C4;
    font-size: 3em;
    font-weight: 600;
    margin: 20px 0;
  }
  .analysis-form {
    overflow: auto;
  }
  .clearfix:after {
    clear:both;
    content:".";
    display:block;
    height: 0;
  }
  .ana-arith-wrapper,
  .ana-data-wrapper {
    display: flex;
    margin-top: 20px;
  }
  .ana-arith-wrapper-text,
  .ana-data-wrapper-text {
    margin: 0 40px;
    padding-top: 40px;
  }
  .ana-arith-wrapper-text span,
  .ana-data-wrapper-text span {
    color: #3A4891;
    font-size: 2.5em;
    font-weight: 600;
  }
  .ana-arith-wrapper-text span:first-of-type,
  .ana-data-wrapper-text span:first-of-type{
    color: red;
  }
</style>