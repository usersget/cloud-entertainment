import http  from "../utils/user";

export const getMenu=(parmid:number)=>{
    return http.get('/user/menu/'+parmid)
}