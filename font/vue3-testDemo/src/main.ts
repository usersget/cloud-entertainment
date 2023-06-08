import { createApp } from 'vue'
import './style.css'
import 'element-plus/es/components/message/index'
import App from './App.vue'
import router from './router'
import {store} from './store'
import * as ElIocns from '@element-plus/icons'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'


const app =createApp(App)
for(const name in ElIocns){
    app.component(name,(ElIocns as any)[name])
}

app.use(router)
app.use(store)
app.use(ElementPlus)

app.mount('#app');