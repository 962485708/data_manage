//验证ip
export const isValidIp = (rule, value, callback) => {
  const reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
  if (reg.test(value)) {
    callback();
  } else {
    return callback(new Error('输入格式不合法！'));
  }
}

//验证端口号
export const isPort = (rule, value, callback) => {
  if (!value) {
    return callback(new Error('输入不能为空'));
  }
  setTimeout(() => {
    if (value == '' || typeof(value) == undefined) {
      callback(new Error('请输入端口值'));
    } else {
      const re = /^([0-9]|[1-9]\d|[1-9]\d{2}|[1-9]\d{3}|[1-5]\d{4}|6[0-4]\d{3}|65[0-4]\d{2}|655[0-2]\d|6553[0-5])$/;
      const rsCheck = re.test(value);
      if (!rsCheck) {
        callback(new Error('请输入在[0-65535]之间的端口值'));
      } else {
        callback();
      }
    }
  }, 100);
}

//验证邮箱
export const isValidEmail = (rule, value, callback) => {
  const emailReg =/^(([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5}){1,25})$/
  setTimeout(() => {
    if (!emailReg.test(value)) {
      return callback(new Error('邮箱格式错误'))
    } else {
      callback()
    }
  }, 100)
}

export const isValidPassword = (rule, value, callback) => {
  if (value.length < 8) {
    callback(new Error('密码不能少于8位'))
  } else {
    callback()
  }
}