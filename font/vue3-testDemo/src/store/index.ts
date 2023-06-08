import { createStore } from "vuex"
import { Itable } from "./type"
 
interface State {
    breadcrumb:Array<Itable>,
}

export const  store = createStore<State>({
    state() {
        return{
            breadcrumb:[
                    {
                        title:'首页',
                        name:'home'
                    }
                 ]
        }
    },
    /**
     * 方法
     */
    mutations:{
        /**
         * breadcrumb添加
         * @param state 
         * @param val 
         */
        inbreadcrumb(state,val:{name:string,title:string}){
            if(val.name !== "home"){
                const index =state.breadcrumb.findIndex(item => item.name === val.name);
                if(index ===-1){
                    state.breadcrumb.push(val)
                }
            }
        },
        /**
         * 删除breadcrumb
         * @param state 
         * @param item 
         */
        uninbreadcrumb(state,item:{name:string,title:string}){
            const index = state.breadcrumb.findIndex(val =>val.name === item.name )
        state.breadcrumb.splice(index,1);
        }  
    },
    /**
     * 获取数据
     */
    getters:{
        /**
         * 返回breadcrumb数组集合
         */
        getbreadcrumb(state:State){
            return state.breadcrumb;
        }
    }
})