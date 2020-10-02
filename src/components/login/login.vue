<template>
  <div class="login">
    <div class="wrapper">
      <div class="sys-text">
        <div><span>系统名称</span></div>
        <div><span>XXXXX平台登录</span></div>
      </div>
      <div class="login-container">
        <el-form label-width="55px">
          <div class="input-box">
            <el-form-item label="" prop="ruleForm.username">
              <img src="../../assets/icon/login/用户名.png" alt="用户名" class="login-icon">
              <el-input v-model="ruleForm.username" auto-complete="off" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="" prop="ruleForm.password">
              <img src="../../assets/icon/login/密码.png" alt="密码" class="login-icon">
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
    </div>
  </div>
</template>

<script>
import {setCookie, getCookie, clearCookie} from "../../http/cookies"

  export default {
    name: "Login",
    data() {
        return {
          ruleForm: {
            username: '',
            password: '',
          },
          name: '18008297740',
          pass: 'zql137984562',
          rememberPassword: false,
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
        }else {
            console.log('cookie为空');
          }
      } catch (error) {
        console.log(error);
      }
    },
    methods : {
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
        if(this.name == this.ruleForm.username && this.pass == this.ruleForm.password) {
          this.$options.methods.rememberPass(rememberPassword, that.ruleForm.username, that.ruleForm.password)
          this.$router.push('/main')
        }else {
          this.$message.error('账号或密码错误，请核对后重新填写');
        }
      }
    }
  }
</script>

<style scoped>
  .login {
    background-image: url('../../assets/img/login/背面.png');
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
  .sys-text {
    padding: 3%;
    font-size: 4.5em;
    color: #5267E6;
    letter-spacing: 0.15em;
  }
  .sys-text div:nth-of-type(2) {
    margin-left: 10%;
  }
  .login-container {
    width: 40%;
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