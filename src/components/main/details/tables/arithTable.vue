<template>
  <div class="arith-table">
    <el-tabs type="border-card">
      <el-tab-pane label="直接输入">
        <el-input
          type="textarea"
          :autosize="{ minRows: 6, maxRows: 30}"
          placeholder="请输入内容"
          v-model="textarea">
        </el-input>
      </el-tab-pane>
      <el-tab-pane label="算法存储位置">
        <el-upload
          class="upload-demo"
          drag
          action="https://jsonplaceholder.typicode.com/posts/"
          multiple>
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
          <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  data() {
    return {
      textarea: ''
    }
  }
}
</script>

<style scoped>
  .arith-table {
    width: 68%;
    position: relative;
  }
  .arith-table>>>.el-tabs--border-card {
    border: none;
    box-shadow: none;
  }
  .arith-table>>>.el-textarea {
    overflow-y: scroll;
  }
  .arith-table>>>.el-tabs--border-card>.el-tabs__header {
    background-color: transparent;
    border: none;
  }
  .arith-table>>>.el-tabs--border-card>.el-tabs__header .el-tabs__item.is-active,
  .arith-table>>>.el-tabs--border-card>.el-tabs__header .el-tabs__item {
    color: #fff;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
    width: 125px;
    text-align: center;
  }
  .arith-table>>>.el-tabs--border-card>.el-tabs__header .el-tabs__item {
    background-color: #CDE0FF;
  }
  .arith-table>>>.el-tabs--border-card>.el-tabs__header .el-tabs__item.is-active {
    background-color: #A9CAFF;
  }
  .arith-table>>>.el-tabs__content {
    background-color: rgba(251, 252, 255);
  }
  .arith-table>>>#pane-1 {
    width: fit-content;
    margin: 0 auto;
    text-align: center;
  }
  .arith-table>>>.el-upload__tip {
    width: 400px;
  }
  
</style>