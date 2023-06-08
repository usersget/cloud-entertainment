<template>
  <el-menu :collapse-transition="false" default-active="0" active-text-color="#409EFF" text-color="#fff" class="el-menusd" :style="collapsed?'width:64px':'width:200px'" :collapse="collapsed">
      <menu-item :MenuData="MenuData.list"></menu-item>
  </el-menu>
</template>
  
<script lang="ts" setup>
import 'element-plus/es/components/menu/style/css'
import MenuItem from './MenuItem.vue'
import { onMounted, reactive, ref } from 'vue'
import {getMenu} from '../../api/app'
import { ElMenu } from 'element-plus';
import {useRoute} from 'vue-router'
const route = useRoute();
/* 
*组件传值
*/
defineProps({
  collapsed: {
    type: Boolean
  }
})

/* 
*菜单数据
*/
const MenuData = reactive({
list: [] as any[]
});
/**
 * 获取菜单数据
 */
const getMenus =()=>{
  getMenu(1).then((data:any)=>{
    data.data.data.forEach(function(path:any){
        MenuData.list.push(path)
    });
   
  })
}

const active =ref("4");
/**
 * 生命周期钩子函数
 */
onMounted(()=>{
  getMenus();
})
</script>
  
<style lang="scss">
.el-menusd {
  width: 200px;
  min-height: 400px;
  height: 100vh;
  background-color: $menuBg !important;
  color: white;
  border: none;
  
}

</style>
  