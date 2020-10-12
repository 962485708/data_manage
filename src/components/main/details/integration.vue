<template>
  <div class="integration">
    <div class="inte-title">
      <span>请上传需要集成的JSON文件</span>
    </div>
    <div class="inte-wrapper">
      <div class="inte-wrapper-text">
        <span>*</span>
        <span>数据来源</span>
      </div>
      <inte-table class="inte-form"/>
    </div>
    <div>
      
    </div>
  </div>
</template>

<script>
import inteTable from '../../../components/main/details/tables/inteTable.vue'
export default {
  name: 'integration',
  components: {
    inteTable
  }
}
</script>

<style scoped>
  .integration {
    width: 100%;
    padding: 0 50px;
  }
  .inte-title {
    color: #4F62C4;
    font-size: 3em;
    font-weight: 600;
    margin: 20px 0;
  }
  .inte-form {
    overflow: auto;
  }
  .clearfix:after {
    clear:both;
    content:".";
    display:block;
    height: 0;
  }
  .inte-wrapper {
    display: flex;
    margin-top: 20px;
  }
  .inte-wrapper-text {
    margin: 0 40px;
    padding-top: 40px;
  }
  .inte-wrapper-text span {
    color: #3A4891;
    font-size: 2.5em;
    font-weight: 600;
  }
  .inte-wrapper-text span:first-of-type{
    color: red;
  }
</style>