<template>
  <div>
    <div>
      <el-form label-width="55px">
      <el-form-item label="" prop="username">
        <el-input v-model="phoneNum" auto-complete="off">
          <i slot="prefix" class="el-input__icon el-icon-user-solid"></i>
        </el-input>
      </el-form-item>
      <el-form-item label="" prop="pass">
        <el-input type="password" v-model="userCode" auto-complete="off">
          <i slot="prefix" class="el-input__icon el-icon-lock"></i>
        </el-input>
      </el-form-item>

      <el-form-item>
        <div class="remember-left">
          <input type="checkbox" v-model="rememberPassword">
          <span class="remember-notice">记住我</span>
          <span class="remember-warn">不是自己的电脑不要勾选此项</span>
        </div>
        <el-button type="primary">登录</el-button>
        <el-button type="primary" @click="doLogin">注册</el-button>
      </el-form-item>

      <div class="pop-err">
        <el-button :plain="true">错误</el-button>
      </div>
      </el-form>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Login",
    data() {
        return {
          phoneNum: '',
          userCode: '',
          rememberPassword: false,
        }
      },
    methods: {
      doLogin() {
        this.$router.push('/register').catch(() => {})
      }
    }
  }
</script>

<style scoped>

</style>