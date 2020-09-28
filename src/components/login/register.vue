<template>
  <div>
    <div>
      <input type="text" placeholder="请输入您的手机号码" v-model="phoneNum"/>
    </div>
    <div>
      <input type="password" placeholder="请输入密码" @blur="codeWarining" v-model="userCode"/>
      <span>以字母开头，长度在6-18之间，只能包含字母数字和下划线</span>
    </div>
    <div>
      <input type="password" placeholder="请再次输入密码" @blur="codeIsMatch" v-model="reUserCode"/>
    </div>
    <div>
      <input type="text" placeholder="请输入验证码" v-model="verifyNum"/>
      <input type="button" value="发送验证码" class="verify_code" @click="sendVerifyNum" v-model="btnContent" :disabled="time>0"/>
    </div>
    <div>
      <button @click.stop="submit">确认</button>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Register",
    data() {
        return {
          phoneNum: '',
          userCode: '',
          reUserCode: '',
          verifyNum: '',
          btnContent:"获取验证码",
          time: 0, //发送验证码间隔时间
        }
      },
    methods: {
      //密码规范
      codeWarining() {
        const codeReg = /^[a-zA-Z]\w{5,17}$/; //以字母开头，长度在6-18之间，只能包含字母数字和下划线
        const userCode = this.userCode;
        if(!codeReg.test(userCode)) {
          console.log('密码不符合规范')
        }
      },
      codeIsMatch() {
        if(this.userCode != this.reUserCode) {
          console.log('请输入相同的密码')
        }
      },
      //发送验证码
      sendVerifyNum() {
        const phoneReg = 11 && /^((13|14|15|17|18)[0-9]{1}\d{8})$/;
        const phoneNum = this.phoneNum;

        //验证手机号是否为空
        if (phoneNum === '') {
          console.log('手机号不能为空');
          return;
        }else if (!phoneReg.test(phoneNum)) {
          console.log("请输入正确的手机号");
          return;
        }else {
          this.time = 5;
          this.timer()
        }
      },
      //发送验证码倒计时
      timer() {
        if(--this.time > 0){
          this.btnContent = this.time+"s后重新获取";
          this.disabled = true;
          var timer = setTimeout(this.timer,1000);
        }else if(this.time === 0){
          this.btnContent = "获取验证码";
          clearTimeout(timer);
          this.disabled = false;
        }
      },
      submit() {
        // getStu(this.ruleForm.username, this.ruleForm.pass).then(res => {
        //   if(res.data === 'RIGHT'){
        //     this.$options.methods.saveInfo(this.rememberPassword, this.ruleForm.username, this.ruleForm.pass, this.$options.methods.SetCookie);
        //     this.$router.push('/manage/siginDetail');
        //   }else {
        //     this.$message.error('账号或密码错误，请核对后重新填写');
        //   }
        // }).catch(err => {
        //   console.log(err)
        // })
        this.$router.push('./Login').catch(() => {})
      }
    }
  }
</script>

<style scoped>

</style>