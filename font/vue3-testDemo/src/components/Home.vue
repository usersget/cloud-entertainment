<script setup lang="ts">
import { computed } from 'vue';
import {useStore} from 'vuex'
const store =useStore();

const count =computed(()=>{
    return store.state.count;
})
const intercount = ()=>{
    store.commit('increment')
}
</script>

<template>
    <h1>home</h1>
    <button @click="intercount">{{count}}</button>
    <el-button  @click="intercount">{{count}}------el</el-button>
</template>