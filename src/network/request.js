import axios from 'axios'

export function request(config) {
  const instance=axios.create({
    baseURL:'',
    method:'get'
  });

  return instance(config)
}

export function postData(config) { 
  const instance2=axios.create({
    method:'post'
    });
  return instance2(config)
}