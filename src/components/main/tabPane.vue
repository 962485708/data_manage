<template>
  <div class="tab-pane">
    <el-tabs type="border-card" class="el-tabs">
      <el-tab-pane label="数据存储位置">
        <el-form :model="dynamicValidateForm" ref="dynamicValidateForm" label-width="100px" class="demo-dynamic">
          <el-form-item
            v-for="(formItem, index) in dynamicValidateForm.formItems"
            :label="'数据来源' + (index + 1)"
            :key="formItem.key"
            :rules="{
              required: true, message: '文件不能为空', trigger: 'blur'
            }">
            <el-upload
              class="file-upload"
              action="https://jsonplaceholder.typicode.com/posts/"
              :on-success="handleSuccess"
              :on-remove="handleRemove"
              :limit="1">
              <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
            <el-button @click.prevent="removeFile(formItem, index)">删除</el-button>
          </el-form-item>
        </el-form>
        <div class="add-file" ref="addfile" @click="addFile">
          <img src="../../assets/icon/main/plus.png" alt="增加数据来源">
          <span>增加数据来源</span>
        </div>
      </el-tab-pane>
    </el-tabs>
    <div class="submit">
      <el-button type="primary" @click="submitForm('dynamicValidateForm')">提交</el-button>
      <el-button type="primary" ref="download" :loading="loadingBtn">{{loadingBtn?'正在集成中':'下载集成数据包'}}</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'tabPane',
  data() {
    return {
      fileList: [],
      loadingBtn: false,
      dynamicValidateForm: {
        formItems: [{
          value: ''
        }],
      },
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if(this.fileList.length > 0) {
            this.$message.success('正在集成，请稍后…');
            this.loadingBtn = true
          } else {
            this.$message.warning('文件不能为空')
          }
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    removeFile(item, index) {
      this.fileList.pop(index)
      console.log(this.fileList)
      var _index = this.dynamicValidateForm.formItems.indexOf(item)
      if (_index !== -1) {
        this.dynamicValidateForm.formItems.splice(_index, 1)
      }
    },
    addFile() {
      this.dynamicValidateForm.formItems.push({
        value: '',
        key: Date.now()
      });
      if(this.dynamicValidateForm.formItems.length === 3) {
        this.$refs.addfile.style.display = 'none'
      }
    },
    handleRemove(file, fileList) {
      this.fileList = fileList
    },
    handleSuccess(response, file, fileList) {
      this.fileList.push({
        name: file.name,
        url: file.response
      });
    },
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
  .file-upload {
    display: flex;
    width: fit-content;
  }
  .tab-pane>>>.el-form-item__content {
    display: flex;
    position: relative;
  }
  .tab-pane>>>.el-button--default {
    position: absolute;
    right: 30px;
    top: 0;
  }
  .tab-pane>>>.el-upload-list {
    margin-left: 30px;
    width: 250px;
  }
  .tab-pane>>>.el-upload-list__item-name {
    width: 160px;
    margin-left: 20px;
  }
  .submit {
    margin-top: 30px;
    display: flex;
    justify-content: space-around;
  }
  .submit button {
    width: 150px;
  }
</style>