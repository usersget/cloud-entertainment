import http from '../utils/music';

export const getType=()=>{
    return http.get('/music/musictype')
}
export const getSinger=()=>{
    return http.get('/music/musicsinger')
}

export const getTypelist=(data:any)=>{
    return http.post('/music/musicTypeList',data)
}