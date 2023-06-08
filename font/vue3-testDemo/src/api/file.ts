import http from '../utils/file';

export const updatannor=(data:any)=>{
    return http.post('/annor',data)
}