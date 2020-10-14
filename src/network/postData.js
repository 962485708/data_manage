import {postData} from "./request";

//注册
export const postRegUserInfo = (userMail, userName, userPassword) => {
  return postData({
    url: 'user/create',
    params: {
      userMail,
      userName,
      userPassword
    }
  })
}
//登录
export const postLoginUserInfo = (userMail, userPassword) => {
  return postData({
    url: 'user/login',
    params: {
      userMail,
      userPassword
    }
  })
}
export const postParamForm = (form) => {
  return postData({
    url: 'api/',
    params: {
      
    },
    data: form
  })
}
//提交setting表单
export const postSettingForm = (form) => {
  return postData({
    url: 'api/',
    params: {
      
    },
    data: form
  })
}