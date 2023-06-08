import http  from "../utils/user";

/**
 * 验证码
 */
export const getCapt = () =>{
    return http.get('/user/captage')
}

/**
 * 登录
 */
export const putUser = (data:any)=>{
    return http.post('/user/login',data)
}
export const addUser = (data:any)=>{
    return http.post('/user/reg',data)
}