<template>
  <div class="setting">
    <div class="set-title">
      <span>请配置需要接入的数据库</span>
    </div>
    <div class="set-wrapper">
      <el-tabs type="border-card">
        <el-tab-pane label="数据库信息">
          <el-form :label-position="labelPosition" label-width="150px" :model="dbInfo" :rules="rules"  ref="dbInfo">
            <el-form-item label="数据库系统：" prop="systerm" :rules="[{ required: true, message: '请选择接入的数据库系统'},]">
              <el-select v-model="dbInfo.systerm" placeholder="数据库系统">
                <el-option label="MySQL" value="mysql"></el-option>
                <el-option label="Oracle" value="oracle"></el-option>
                <el-option label="influxdb" value="influxdb"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="IP地址 host：" prop="host">
              <el-input v-model="dbInfo.host"></el-input>
            </el-form-item>
            <el-form-item label="端口号 port：" prop="port">
              <el-input v-model="dbInfo.port"></el-input>
            </el-form-item>
            <el-form-item label="用户名 user：:" prop="user" :rules="[{ required: true, message: '用户名不能为空'}]">
              <el-input v-model="dbInfo.user"></el-input>
            </el-form-item>
            <el-form-item label="密码 password：" prop="password" :rules="[{ required: true, message: '密码不能为空'}]">
              <el-input v-model="dbInfo.password"></el-input>
            </el-form-item>
            <el-form-item label="数据库 database：" prop="database" :rules="[{ required: true, message: '数据库不能为空'}]">
              <el-input v-model="dbInfo.database"></el-input>
            </el-form-item>
            <el-form-item class="submit">
              <el-button type="primary" @click="submitForm('dbInfo')" :loading="loadingBtn">{{loadingBtn?'正在获取中':'获取数据表'}}</el-button>
              <el-button @click="resetForm('dbInfo')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-tab-pane>
        <div class="popover">
          <el-popover
            placement="top-start"
            width="200"
            trigger="hover"
            content="填写数据库相关信息，接入数据表，在<数据展现>中以图像形式展现">
            <el-button slot="reference"><img src="../../../assets/icon/main/question.png" alt="问题"></el-button>
          </el-popover>
        </div>
      </el-tabs>
    </div>
  </div>
</template>

<script>
import { isValidIp, isPort } from '../../../utils/validate'
import { postSettingForm } from '../../../network/postData'
export default {
  data() {
    return {
      loadingBtn: false,
      labelPosition: 'left',
      dbInfo: {
        systerm: '',
        host: '',
        port: '',
        user: '',
        password: '',
        database: ''
      },
      rules: {
        host: [
          { required: true, message: 'ip地址不能为空', trigger: 'blur' },
          { validator: isValidIp, trigger: 'blur' }
        ],
        port: [
          { required: true, message: '端口号不能为空', trigger: 'blur' },
          { validator: isPort, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitForm() {
      let dbInfo = this.dbInfo
      postSettingForm(dbInfo).then( res => {
        console.log(dbInfo)
      })
      if (dbInfo.systerm != '') {
        this.$message.success('正在获取数据表，请稍后…')
        this.loadingBtn = true
        postSettingForm(dbInfo).then(res => {
          console.log(res)
        })
      } else {
        this.$message.warning('数据信息不能为空')
        return false;
      }
    },
    resetForm(formName) {
      this[formName] = {};
    }
  }
}
</script>

<style scoped>
  .setting {
    padding: 0 50px;
  }
  .set-title {
    color: #4F62C4;
    font-size: 3em;
    font-weight: 600;
    margin: 20px 0;
  }
  .set-wrapper {
    width: 60%;
    margin: 0 auto;
  }
  .setting>>>.el-tabs__content {
    background-color: rgba(251, 252, 255);
  }
  .setting>>>.el-tabs--border-card>.el-tabs__header .el-tabs__item.is-active {
    background-color: #A9CAFF;
    color: #fff;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
  }
  .setting>>>.el-tabs--border-card {
    border: none;
    box-shadow: none;
  }
  .setting>>>.el-tabs--border-card>.el-tabs__header {
    background-color: transparent;
    border: none;
  }
  .setting>>>.el-form-item__label {
    font-size: 2.3em;
  }
  .setting>>>.el-form-item__content {
    width: 300px;
  }
  .setting>>>.el-form-item,
  .setting>>>.elform,
  .setting>>>.el-form--label-left,
  .setting>>>.el-tab-pane {
    width: fit-content;
  }
  .setting>>>.el-tab-pane {
    margin:0 auto;
  }
  .submit button {
    width: 150px;
    text-align: center;
  }
  .setting>>>.submit .el-form-item__content {
    display: flex;
    justify-content: space-around;
  }
  .set-wrapper>>>.popover .el-button {
    background: transparent;
    border: none;
    padding: 0;
    float: right;
  }
  .set-wrapper>>>.popover .el-button img {
    width: 20px;
  }
</style>
<style>
  .el-popover {
    font-size: 12px;
    line-height: 20px;
  }
</style>