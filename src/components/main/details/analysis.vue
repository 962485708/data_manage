<template>
  <div class="analysis">
    <div class="analysis-title">
      <span>请配置需要继承的数据包或数据来源</span>
    </div>
    <div class="analysis-wrapper">
      <div class="analysis-wrapper-text">
        <span>*</span>
        <span>数据来源</span>
      </div>
      <inte-table class="analysis-form"/>
    </div>
  </div>
</template>

<script>
import inteTable from '../../../components/main/details/tables/inteTable.vue'
export default {
  name: 'analysis',
  components: {
    inteTable
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
  .analysis-wrapper {
    display: flex;
    margin-top: 20px;
  }
  .analysis-wrapper-text {
    margin: 0 40px;
    padding-top: 40px;
  }
  .analysis-wrapper-text span {
    color: #3A4891;
    font-size: 2.5em;
    font-weight: 600;
  }
  .analysis-wrapper-text span:first-of-type{
    color: red;
  }
</style>