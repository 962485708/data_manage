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
            <el-form-item label="" prop="username">
              <img src="../../assets/icon/login/用户名.png" alt="用户名" class="login-icon">
              <el-input v-model="username" auto-complete="off" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="" prop="password">
              <img src="../../assets/icon/login/密码.png" alt="密码" class="login-icon">
              <el-input type="password" v-model="password" auto-complete="off" placeholder="请输入密码"></el-input>
            </el-form-item>
          </div>
          <div class="login-box">
            <el-form-item class="login-submit">
              <div class="remember-pass">
                <input type="checkbox" v-model="rememberPassword">
                <span>记住密码</span>
              </div>
              <el-button type="primary">登录</el-button>
            </el-form-item>
          </div>
          <!-- <div class="pop-err">
            <el-button :plain="true">错误</el-button>
          </div> -->
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Login",
    data() {
        return {
          username: '',
          password: '',
          rememberPassword: false,
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