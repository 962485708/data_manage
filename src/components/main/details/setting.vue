<template>
  <div class="setting">
    <div class="set-title">
      <span>请配置需要接入的数据库</span>
    </div>
    <div class="set-wrapper">
      <div class="access-card">
        <el-form :model="databasesForm"  label-width="100px">
          <el-form-item
            v-for="(db, index) in databasesForm.databases"
            :label="'数据库' + (index + 1)"
            :key="db.key">
            <button class="access-db" @click.prevent="accessDb(index)">
              <div>数据库系统：{{db.systerm}}</div>
              <div>IP地址：{{db.host}}</div>
              <div>端口号：{{db.port}}</div>
              <div>用户名：{{db.user}}</div>
              <div>数据库：{{db.database}}</div>
            </button>
          </el-form-item>
          <el-form-item>
            <el-button @click="addDb()">新建数据库</el-button>
          </el-form-item>
        </el-form>
      </div>
      <div ref="dbcard" class="db-card">
        <el-tabs type="border-card" >
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
                <el-button type="primary" @click="submitForm('dbInfo')" :loading="loadingBtn">{{loadingBtn?'正在建立中':'确认新建'}}</el-button>
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
  </div>
</template>

<script>
import { isValidIp, isPort } from '../../../utils/validate'
import { postSettingForm } from '../../../network/postData'
import store from '../../../store/store'
export default {
  data() {
    return {
      loadingBtn: false,
      labelPosition: 'left',
      indexDd: 0,
      dbInfo: {//填写的数据库信息
        systerm: '',
        host: '',
        port: '',
        user: '',
        password: '',
        database: ''
      },
      databasesForm: {//数据库列表
        databases:[{
          systerm: 'MySQL',
          host: '1.1.1.1',
          port: '3000',
          user: 'lalisa',
          password: '12345678',
          database: 'departments'
        }]
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
    addDb() {
      this.$refs.dbcard.style.display = 'block'
    },
    accessDb(index) {
      if(index == 0) {
        this.$message.warning('您正在当前数据库，该数据库为默认数据库')
        return false
      } else {
          this.$confirm('是否确认切换数据库', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          store.state.currentDb = this.databasesForm.databases[index]
          console.log(store.state.currentDb)
          this.$message({
            type: 'success',
            message: '切换成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消切换'
          });          
        });
      }
    },
    submitForm() {
      let dbInfo = this.dbInfo
      if (dbInfo.systerm != '') {
        this.$message.success('已提交数据库')
        this.databasesForm.databases.push({
          system: dbInfo.systerm,
          host: dbInfo.host,
          port: dbInfo.port,
          user: dbInfo.user,
          password: dbInfo.password,
          database: dbInfo.database,
          key: Date.now()
        });
        this.loadingBtn = true
        // postSettingForm(dbInfo).then(res => {
        //   console.log(res)
        //   this.loadingBtn = false
        //   this.$refs.dbcard.style.display = 'none'
        // })
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
    width: 100%;
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
  .access-db {
    background-color: rgba(251, 252, 255);
    border: none;
    padding: 25px;
    border-radius: 10px;
    letter-spacing: 1px;
    text-align: left;
    outline:none;
    cursor: pointer;
    box-shadow: 3px 3px 3px rgb(216, 215, 215)
  }
  .access-db:hover {
    background-color: #647BF7;
    color: #fff;
  }
  .access-card>>>.el-form-item__label {
    text-align: center;
    padding: 0;
    color: #3AABEB;
    font-weight: 600;
    letter-spacing: 1px;
    font-size: 16px;
    line-height: 142px;
  }
  .db-card {
    display: none;
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