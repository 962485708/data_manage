<template>
  <div class="login">
    <div class="wrapper">
      <div class="sys-text">
        <div><img src="../assets/icon/logo.png" alt=""></div>
      </div>
      <el-tabs v-model="activeName" stretch>
        <el-tab-pane label="登录" name="first">
          <div class="login-container">
            <el-form label-width="55px" :rules="rules" :model="ruleForm" ref="ruleForm">
              <div class="input-box">
                <el-form-item label="" prop="username">
                  <img src="../assets/icon/login/用户名.png" alt="用户名" class="login-icon">
                  <el-input v-model="ruleForm.username" auto-complete="off" placeholder="请输入邮箱"></el-input>
                </el-form-item>
                <el-form-item label="" prop="password" >
                  <img src="../assets/icon/login/密码.png" alt="密码" class="login-icon">
                  <el-input type="password" v-model="ruleForm.password" auto-complete="off" placeholder="请输入密码"></el-input>
                </el-form-item>
              </div>
              <div class="login-box">
                <el-form-item class="login-submit">
                  <div class="remember-pass">
                    <input type="checkbox" v-model="rememberPassword" @click="doRememberPassword">
                    <span>记住密码</span>
                  </div>
                  <el-button type="primary" @click="doLogin">登录</el-button>
                </el-form-item>
              </div>
            </el-form>
          </div>
        </el-tab-pane>
        <el-tab-pane label="注册" name="second">
          <div class="login-container">
            <el-form label-width="55px" :rules="rules" :model="RegForm" ref="RegForm">
              <div class="input-box">
                <el-form-item label="" prop="email">
                  <img src="../assets/icon/login/邮箱.png" alt="邮箱" class="login-icon">
                  <el-input v-model="RegForm.email" auto-complete="off" placeholder="请输入邮箱"></el-input>
                </el-form-item>
                <el-form-item label="" prop="username">
                  <img src="../assets/icon/login/用户名.png" alt="用户名" class="login-icon">
                  <el-input v-model="RegForm.username" auto-complete="off" placeholder="请输入用户名"></el-input>
                </el-form-item>
                <el-form-item label="" prop="password">
                  <img src="../assets/icon/login/密码.png" alt="密码" class="login-icon">
                  <el-input type="password" v-model="RegForm.password" auto-complete="off" placeholder="请输入密码"></el-input>
                </el-form-item>
              </div>
              <div class="login-box">
                <el-form-item class="login-submit">
                  <el-button type="primary" @click="doRegister">注册</el-button>
                </el-form-item>
              </div>
            </el-form>
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
import { setCookie, getCookie, clearCookie } from "../http/cookies"
import { isValidEmail, isValidPassword } from "../utils/validate"
import { postRegUserInfo, postLoginUserInfo } from "../network/postData"
import { mapMutations } from 'vuex';

  export default {
    name: "Login",
    data() {
        return {
          activeName: 'first',
          ruleForm: {
            username: '',
            password: ''
          },
          RegForm: {
            username: '',
            pass: '',
            email: ''
          },
          rememberPassword: false,
          rules: {
            username: [
              { required: true, message: '账号不能为空', trigger: 'blur' },
            ],
            pass: [
                {validator: isValidPassword, trigger: 'blur'}
            ],
            email: [
              { required: true, message: '邮箱不能为空', trigger: 'blur' },
              { validator: isValidEmail, trigger: 'blur' }
            ],
          }
        }
      },
    mounted() {
      let self = this
      // 在页面加载时从cookie获取登录信息
      var info = getCookie()
      // 如果存在赋值给表单，并且将记住密码勾选
      try {
        if (info != undefined) {
          if (info.username || info.username.length > 0) {
            self.ruleForm.username = info.username
            self.ruleForm.password = info.password
            self.rememberPassword = true
          } 
        }
      } catch (error) {
        console.log(error);
      }
    },
    methods : {
      ...mapMutations(['setToken']),
      doRememberPassword() {
        let mySelf = this;
        let rememberStatus = mySelf.rememberPassword;
        mySelf.rememberPassword = !rememberStatus;
      },
      rememberPass(rememberPassword, username, password) {
        if (rememberPassword === true) {
          //判断用户是否勾选了记住密码选项rememberPassword，传入保存的账号username，密码password，天数3
          setCookie(username, password, 7)
        } else {
          clearCookie()
        }
      },

      doLogin() {
        let that = this
        let rememberPassword = this.rememberPassword
        postLoginUserInfo(that.ruleForm.username, that.ruleForm.password).then(res => {
          if(res.data['code']==200){
            sessionStorage.clear()
            that.token = res.data.data;
            that.setToken({token: that.token});
            this.$message.success('登录成功')
            that.$options.methods.rememberPass(rememberPassword, that.ruleForm.username, that.ruleForm.password)
            if(this.$store.state.token) {
                this.$router.push('/main/integration');
              } else {
                this.$router.replace('/login');
              }
          }else{
            this.$message.warning('用户名或者密码错误')
          }
        }).catch(error => {
          console.log(error)
        })
      },
      doRegister() {
        let RegForm = this.RegForm
        postRegUserInfo(RegForm.email, RegForm.username, RegForm.password).then(res => {
          if(res.data.message === "重复的数据") {
            this.$message.error('该邮箱号已注册')
            return false
          } else {
            this.$message.success('注册成功')
          }
        }).catch(error => {
          console.log(error)
        })
      }
    }
  }
</script>

<style scoped>
  .login {
    background-image: url('../assets/img/login/背面.png');
    background-size: 100% 100%;
    min-width: 1200px;
    min-height: 650px;
    width: 100vw;
    height: 100vh;
    position: relative;
  }
  .wrapper {
    width: 61%;
    height: 55%;
    transform: translate(-50%, -50%);
    position: absolute;
    left: 50%;
    top: 50%;
    border-radius: 4.28rem;
    box-sizing: border-box;
    overflow: hidden;
    display: flex;
    flex-direction: column;
  }
  .wrapper >>> .el-tabs {
    width: 400px;
  }
  .sys-text {
    padding: 2% 3% 0 3%;
    font-family: sans-serif;
    font-size: 4.5em;
    color: #5267E6;
    letter-spacing: 0.15em;
  }
  .sys-text img {
    width: 110px;
  }
  .login-container {
    margin-top: 10px;
    width: 320px;
    background-color: none;
  }
  .login-icon {
    width: 25px;
    height: 25px;
  }
  .input-box>>>.el-form-item__content {
    display: flex;
    align-items: center;
    justify-items: center;
  }
  .login-container>>>.el-input__inner {
    border: 1px solid #91D1FF;
    border-radius: 15px;
    height: 40px;
    line-height: 40px;
    margin-left: 20px;
    width: 90%;
  }
  .login-submit>>>.el-button--primary {
    font-size: 1.4em;
    font-weight: 500;
    text-align: center;
    background-color: rgba(0, 0, 255, 62%);
    border-color: rgb(43, 43, 243);
    box-sizing: border-box;
    border-radius: 30px;
    padding: 3% 35% 3% 35%;
  }
  .login-box>>>.el-form-item__content {
    margin-left: 100px!important;
  }
  .remember-pass {
    padding: 0 0 5% 0;
  }
  .login-box>>>.el-form-item {
    margin: 0;
  }
</style>
<style>
  
</style>