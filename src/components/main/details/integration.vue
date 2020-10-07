<template>
  <div class="integration">
    <div class="inte-title">
      <span>请配置需要继承的数据包或数据来源</span>
    </div>

    <div class="inte-wrapper clearfix">
      <div>
        <span>数据来源</span>
      </div>
      <tab-pane class="inte-form"/>
    </div>
    
  </div>
</template>

<script>
import tabPane from '../../../components/main/tabPane.vue'
export default {
  name: 'integration',
  components: {
    tabPane
  }
}
</script>

<style scoped>
  .integration {
    width: 100%;
  }
  .inte-title {
    color: #4F62C4;
    font-size: 3em;
    font-weight: 600;
    margin: 20px 30px 20px 30px;
  }
  .inte-form {
    position: absolute;
    top: 20%;
    left: 50%;
    transform: translate(-50%, -50%);
    overflow: auto;
    display: block;
  }
  .clearfix:after {
    clear:both;
    content:".";
    display:block;
    height: 0;
  }
  /* .inte-wrapper {
    display: flex;
  } */
</style>