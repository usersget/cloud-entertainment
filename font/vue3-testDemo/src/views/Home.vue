<template>
<el-row>
    <el-col :span="13">
        <el-card>
            <TepVue></TepVue>
        </el-card>
    </el-col>
    <el-col :span="11">
        <el-card>
            <stackedLine></stackedLine>
        </el-card>
        <el-card>
            <Barchart></Barchart>
        </el-card>
    </el-col>
  </el-row>

</template>

<script lang='ts' setup>
import stackedLine from './components/Echarts/stackedLine.vue';
import Barchart from './components/Echarts/Barchart.vue';
import TepVue from './components/Echarts/Tep.vue';
</script>

<style lang='scss' scoped>
.el-card{
    margin-bottom: 10px;
    margin-left: 5px;
}

</style>