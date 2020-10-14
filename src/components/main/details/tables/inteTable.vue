<template>
  <div class="tab-pane">
    <el-tabs type="border-card" class="el-tabs" v-loading.fullscreen.lock="fullscreenLoading">
      <el-tab-pane label="数据存储位置">
        <el-form :model="fileForm" ref="fileForm" label-width="100px">
          <el-form-item
            v-for="(formItem, index) in fileForm.formItems"
            :label="'数据来源' + (index + 1)"
            :key="formItem.key">
            <el-upload
              class="file-upload"
              action="https://jsonplaceholder.typicode.com/posts/"
              accept=".json"
              :on-success="handleSuccess"
              :on-remove="handleRemove"
              :limit="1">
              <el-button size="small" type="primary">点击上传</el-button>
              <el-select v-model="values[index]" placeholder="请选择">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                  :disabled="item.disabled">
                </el-option>
              </el-select>
            </el-upload>
            <el-button @click.prevent="removeFile(formItem, index)">删除</el-button>
          </el-form-item>
        </el-form>
        <div class="add-file" ref="addfile" @click="addFile()">
          <img src="../../../../assets/icon/main/plus.png" alt="增加数据来源">
          <span>增加数据来源</span>
        </div>
      </el-tab-pane>
    </el-tabs>
    <div class="submit">
      <el-button type="primary" @click="submitForm()">提交</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'inteTable',
  data() {
    return {
      options: [{
          value: '销售部',
          label: '销售部'
        }, {
          value: '开发部',
          label: '开发部',
        }, {
          value: '运营部',
          label: '运营部'
        }, {
          value: '财务部',
          label: '财务部'
        }, {
          value: '人力资源部',
          label: '人力资源部'
        }, {
          value: '市场营销部',
          label: '市场营销部'
        }, {
          value: '保卫部',
          label: '保卫部'
        }],
      values: ['', '', '', '', '', '', ''],
      fileList: [],
      fileForm: {
        formItems: [{
          value: ''
        }],
      },
      fullscreenLoading: false
    }
  },
  methods: {
    submitForm() {
      if (this.fileForm.formItems) {
        let length = this.fileList.length
        let fileList = this.fileList
        let fileReaderArr = []
        let values = this.values
        if(length > 0) {
          for(let i=0; i<length; i++) {
            let reader = new FileReader()
            reader.readAsDataURL(fileList[i].raw)
            reader.onload = function(event) {
              fileReaderArr.push({file:event.target.result.slice(29), department: values[i]})
            }
          }
            console.log(values)
            console.log(fileReaderArr)
            this.$message.success('正在集成，请稍后…');
            // this.fullscreenLoading = true
        } else {
          this.$message.warning('文件不能为空')
        }
      } else {
        console.log('error submit!!');
        return false;
      }
    },
    removeFile(item, index) {
      this.fileList.pop(index)
      let _index = this.fileForm.formItems.indexOf(item)
      if (_index !== -1) {
        this.fileForm.formItems.splice(_index, 1)//数组自动向前补齐
      }
      if(this.fileForm.formItems.length < 7) {
        this.$refs.addfile.style.display = 'flex'
      }
      let index_ = this.values.indexOf(this.values[index])
      if(index_ !== -1) {
        this.values.splice(index_, 1)
      }
      this.options[index].disabled = false
    },
    addFile() {
      this.fileForm.formItems.push({
        value: '',
        key: Date.now()
      });
      if(this.fileForm.formItems.length === 7) {
        this.$refs.addfile.style.display = 'none'
      }
      let options = this.options
      let values = this.values
      let length = this.values.length
      while (length-- && !values[length]);//获取value中非空元素的最大索引
      
      let index = options.findIndex(item => {
        return item.value === values[length]
      })
      console.log(index)
      if(index > -1) {
        options[index].disabled = true
      }
    },
    handleRemove(file, fileList) {
      this.fileList = fileList
    },
    handleSuccess(response, file, fileList) {
      this.fileList.push(file);
    },
  }
}
</script>

<style scoped>
  .tab-pane {
    width: 68%;
    position: relative;
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
    font-size: 14px;
    letter-spacing: 1px;
    font-weight: 600;
    cursor: pointer;
    width: fit-content;
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
  .tab-pane>>>.el-input {
    width: 100px;
  }
  .tab-pane>>>.el-form-item__label {
    text-align: center;
    padding: 0;
    color: #3AABEB;
    font-weight: 600;
    letter-spacing: 1px;
    font-size: 16px;
  }
  .tab-pane>>>.el-form-item__content {
    display: flex;
    position: relative;
  }
  .tab-pane>>>.el-button--default {
    position: absolute;
    right: 30px;
  }
  .tab-pane>>>.el-upload-list {
    margin-left: 18px;
    width: 200px;
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