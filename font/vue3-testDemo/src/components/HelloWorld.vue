<script setup lang="ts">
import { emit } from 'process';
import { ref } from 'vue'
const emits = defineEmits(["parentClick"])
const pops = withDefaults(
  defineProps<{ 
    msg: string,
    agelist:Array<number> 
  
  }>(),{
    msg:"hello",
    agelist:()=>[1,2,3]
  } 
);
const emitsCliCK=()=>{
emits("parentClick","我是子组件");
}
</script>

<template>
  <button class="button" @click="emitsCliCK"> 子串父</button>
  <h1>{{ msg }}</h1>
    <p v-for="(item,index) in agelist" :key="index">{{index}}————{{item}}</p>

</template>

<style lang="less" scoped>
.button{
  color: aqua;
}
</style>
