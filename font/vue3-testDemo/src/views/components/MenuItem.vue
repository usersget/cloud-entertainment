<template>
<template v-for="(item,index) in MenuData" :key="index">
    <!-- 有子菜单 -->
      <el-sub-menu  v-if="item.children && item.children.length>0" :index="item.meta.title">
        <template #title>
          <el-icon>
            <component :is="item.meta?.icon" />
          </el-icon>
          <span>{{item.meta.title}}</span>
        </template>
        <menu-item :MenuData="item.children"></menu-item>
      </el-sub-menu>
      <!-- 没有子菜单 -->
      <el-menu-item v-else  :index="item.meta.title" @click="toPath(item.name,item.meta.title)">
      <el-icon>
        <component :is="item.meta?.icon" />
      </el-icon>
      <template #title>{{item.meta.title}}</template>
    </el-menu-item>
    </template>

</template>

<script lang='ts' setup>
import 'element-plus/es/components/sub-menu/style/css'
import 'element-plus/es/components/menu-item/style/css'
import {useRouter,useRoute} from 'vue-router';
import { computed } from 'vue';
import {useStore} from 'vuex'
defineProps(['MenuData']);
const router =useRouter();
const route =useRoute();
const store =useStore();

const inbreadcrumb = (item: { name: string; title: string; })=>{
    store.commit('inbreadcrumb',item)
}
const toPath = (item:string,title:string)=>{
  if(item !== route.name){
    router.push(item)
    let routes={
      name:"",
      title:""
    }
    routes.name=item;
    routes.title = title;
    inbreadcrumb(routes)
  }
  
}
</script>

<style lang='scss' scoped>
.el-menu-item{
    background-color: $menuBg;
  }
.el-sub-menu{
  .el-menu-item{
    background-color:$subMenuBg;
  }
}  
</style>