<template>
  <div class="data-warn">
    <div class="warn-wrapper">
      <el-form :model="paramForm" ref="paramForm" label-width="100px">
        <el-form-item>
          <div class="param-title">
            <span>参数名称</span>
            <span>参数值</span>
          </div>
        </el-form-item>
        <el-form-item
          v-for="(param, index) in paramForm.params"
          :label="'参数' + (index + 1)"
          :key="param.key">
          <div class="param-input">
            <el-input v-model="param.name"></el-input>
            <img src="../../../../assets/icon/main/equal.png" alt="">
            <el-input v-model="param.data"></el-input>
          </div>
          <div class="param-remove">
            <el-button @click.prevent="removeParam(param)">删除</el-button>
          </div>
        </el-form-item>
        <el-form-item>
          <div class="add-param" ref="addparam" @click="addParam">
            <img src="../../../../assets/icon/main/plus.png" alt="增加数据来源">
            <span>增加数据来源</span>
          </div>
        </el-form-item>
      </el-form>
    </div>
    <div class="submit">
      <el-button type="primary" @click="submitForm()">提交参数</el-button>
    </div>
  </div>
</template>

<script>
export { postParamForm } from '../../../../network/postData'
export default {
  data() {
      return {
        paramForm: {
          params: [{
            name: '',
            data: ''
          }],
        }
      };
    },
    methods: {
      submitForm() {
        let paramForm = this.paramForm
        if (paramForm.params[0].name != '') {
          postParamForm(paramForm).then( res => {
            console.log(res)
          })
          alert('submit!');
        } else {
          this.$message.warning('参数列表不能为空')
          return false;
        }
      },
      removeParam(item) {
        var index = this.paramForm.params.indexOf(item)
        if (index !== -1) {
          this.paramForm.params.splice(index, 1)
        }
      },
      addParam() {
        this.paramForm.params.push({
          value: '',
          key: Date.now()
        });
      }
    }
}
</script>

<style scoped>
  .warn-wrapper {
    background-color: rgba(251, 252, 255);
    width: fit-content;
    margin: 0 auto;
  }
  .warn-wrapper>>>.el-form-item__content {
    display: flex;
    align-items: center;
  }
  .warn-wrapper>>>.el-form-item__label,
  .param-title {
    text-align: center;
    padding: 0;
    color: #3AABEB;
    font-weight: 600;
    letter-spacing: 1px;
    font-size: 16px;
  }
  .param-title {
    display: flex;
    justify-content: space-between;
    width: 470px;
  }
  .param-title span:nth-of-type(1) {
    margin-left: 66px;
  }
  .param-title span:nth-of-type(2) {
    margin-right: 75px;
  }
  .warn-wrapper>>>.el-input {
    width: 200px;
  }
  .param-input {
    display: flex;
    align-items: center;
  }
  .param-remove {
    width: 130px;
    text-align: center;
  }
  .param-input img {
    width: 30px;
    margin: 0 20px;
  }
  .add-param {
    display: flex;
    align-items: center;
    font-size: 14px;
    letter-spacing: 1px;
    font-weight: 600;
    cursor: pointer;
  }
  .add-param img{
    width: 25px;
  }
  .submit>>>.el-button--primary {
    display: table;
    margin: 0 auto;
    width: 150px;
  }
</style>