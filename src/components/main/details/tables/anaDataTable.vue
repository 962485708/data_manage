<template>
  <div class="ana-data-table">
    <el-tabs type="border-card">
      <el-tab-pane label="数据存储位置">
        <el-upload
          drag
          action="https://jsonplaceholder.typicode.com/posts/"
          :on-success="handleSuccess"
          :limit="1">
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        </el-upload>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  data() {
    return {
      textarea: '',
      dataFile: ''
    }
  },
  methods: {
    handleSuccess(response, file, fileList) {
      let reader = new FileReader()
      reader.readAsDataURL(file.raw)
      reader.onload = function(event) {
        this.dataFile = event.target.result
      }
      console.log(this.dataFile)
    },
  }
}
</script>

<style scoped>
  .ana-data-table {
    width: 68%;
    position: relative;
  }
  .ana-data-table>>>.el-tabs--border-card {
    border: none;
    box-shadow: none;
  }
  .ana-data-table>>>.el-tabs--border-card>.el-tabs__header {
    background-color: transparent;
    border: none;
  }
  .ana-data-table>>>.el-tabs--border-card>.el-tabs__header .el-tabs__item.is-active{
    color: #fff;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
    width: 125px;
    text-align: center;
  }
  .ana-data-table>>>.el-tabs--border-card>.el-tabs__header .el-tabs__item {
    background-color: #CDE0FF;
  }
  .ana-data-table>>>.el-tabs--border-card>.el-tabs__header .el-tabs__item.is-active {
    background-color: #A9CAFF;
  }
  .ana-data-table>>>.el-tabs__content {
    background-color: rgba(251, 252, 255);
  }
  .ana-data-table>>>#pane-0 {
    width: fit-content;
    margin: 0 auto;
    text-align: center;
  }
  .ana-data-table>>>.el-upload__tip {
    width: 400px;
  }
</style>