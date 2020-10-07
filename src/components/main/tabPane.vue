<template>
  <div class="tab-pane">
    <el-tabs type="border-card" class="el-tabs">
      <el-tab-pane label="数据存储位置">
        <el-form :model="dynamicValidateForm" ref="dynamicValidateForm" label-width="100px" class="demo-dynamic">
          <el-form-item
            v-for="(file, index) in dynamicValidateForm.files"
            :label="'数据来源' + (index + 1)"
            :key="file.key"
            :rules="{
              required: true, message: '文件不能为空', trigger: 'blur'
            }">
            <el-upload
              class="file-upload"
              action="https://jsonplaceholder.typicode.com/posts/"
              :limit="1">
              <el-button size="small" type="primary">点击上传</el-button>
              <el-button @click.prevent="removeFile(file)">删除</el-button>
            </el-upload>
          </el-form-item>
        </el-form>
        <div class="add-file" @click="addFile">
          <img src="../../assets/icon/main/plus.png" alt="增加数据来源">
          <span>增加数据来源</span>
        </div>
      </el-tab-pane>
    </el-tabs>
    <el-button type="primary" @click="submitForm('dynamicValidateForm')">提交</el-button>
  </div>
</template>

<script>
export default {
  name: 'tabPane',
  data() {
    return {
      dynamicValidateForm: {
        files: [{
          value: ''
        }],
      }
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    removeFile(item) {
      var index = this.dynamicValidateForm.files.indexOf(item)
      if (index !== -1) {
        this.dynamicValidateForm.files.splice(index, 1)
      }
    },
    addFile() {
      this.dynamicValidateForm.files.push({
        value: '',
        key: Date.now()
      });
    }
  }
}
</script>

<style scoped>
  .tab-pane {
    width: 68%;
  }
  .tab-pane>>>.el-tabs--border-card {
    border: none;
    box-shadow: none;
  }
  .tab-pane>>>.el-tabs--border-card>.el-tabs__header {
    background-color: transparent;
    border: none;
  }
  .tab-pane>>>.el-button+.el-button,
  .tab-pane>>>.el-button--primary {
    line-height: 20px;
    background-color: #409EFF;
    border: 1px solid #409EFF;
    color: #fff;
    padding: 8px 15px 8px 15px;
    margin-right: 10px;
  }
  .tab-pane>>>.el-button--primary {
    margin-left: 30px;
  }
  .add-file {
    display: flex;
    align-items: center;
    font-size: 2em;
    letter-spacing: 0.1em;
    font-weight: 600;
    cursor: pointer;
  }
  .add-file img{
    width: 25px;
  }
  .tab-pane>>>.el-tabs__content {
    background-color: rgba(251, 252, 255);
  }
  .tab-pane>>>.el-tabs--border-card>.el-tabs__header .el-tabs__item.is-active {
    background-color: #A9CAFF;
    color: #fff;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
  }
  .tab-pane>>>.file-upload {
    display: flex;
  }
  .tab-pane>>>.el-upload-list {
    margin-left: 30px;
  }
  .tab-pane>>>.el-upload-list__item-name {
    width: 250px;
    margin-left: 20px;
  }
</style>