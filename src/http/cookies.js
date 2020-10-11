import {Decrypt, Encrypt} from "../common/login/crypto"

//设置cookies并加密
export const setCookie = (username, password, exdays) => {
  let encryptUser = Encrypt(username)
  let enctyptPass = Encrypt(password)

  var exdate = new Date(); //获取时间
  exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays); //保存的天数
  //字符串拼接cookie
  window.document.cookie = "username" + "==" + encryptUser + ";path=/;expires=" + exdate.toGMTString();
  window.document.cookie = "password" + "==" + enctyptPass + ";path=/;expires=" + exdate.toGMTString();
}

//获取cookies并解密
export const getCookie = () => {
  if (document.cookie.length > 0) {
    var arr = document.cookie.split(';')
    var userArr = arr[0].split('==') //根据==切割
    var passArr = arr[1].split('==') //根据==切割
    //判断查找相对应的值
    const info = {
      'username': Decrypt(userArr[1]),
      'password': Decrypt(passArr[1])
    }
    return info
  }
}
//清除cookies
export const clearCookie = () => {
  setCookie('', '', -1)
}

