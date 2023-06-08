<template>
<div id="stackedLine" style="width:100%;height:200px;"></div>
</template>

<script lang='ts' setup>
import * as echarts from 'echarts';
import { onMounted } from 'vue';
type EChartsOption = echarts.EChartsOption;


var option: EChartsOption;

const Line = ()=>{
    var chartDom = document.getElementById('stackedLine')!;
var myChart = echarts.init(chartDom);
option = {
  title: {
    text: '本周热歌'
    
  },
  tooltip: {
    trigger: 'axis'
  },
  // legend: {
  //   data: ['Email', 'Union Ads', 'Video Ads', 'Direct', 'Search Engine']
  // },
  grid: {
    top:'20%',
    left: '3%',
    right: '4%',
    bottom: '0%',
    containLabel: true
  },
  toolbox: {
    feature: {
      saveAsImage: {}
    }
  },
  xAxis: {
    type: 'category',
    boundaryGap: false,
    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      name: 'Email',
      type: 'line',
      stack: 'Total',
      data: [120, 132, 101, 134, 90, 230, 210]
    },
    {
      name: 'Union Ads',
      type: 'line',
      stack: 'Total',
      data: [220, 182, 191, 234, 290, 330, 310]
    },
    {
      name: 'Video Ads',
      type: 'line',
      stack: 'Total',
      data: [150, 232, 201, 154, 190, 330, 410]
    },
    {
      name: 'Direct',
      type: 'line',
      stack: 'Total',
      data: [320, 332, 301, 334, 390, 330, 320]
    },
    {
      name: 'Search Engine',
      type: 'line',
      stack: 'Total',
      data: [820, 932, 901, 934, 1290, 1330, 1320]
    }
  ]
};

option && myChart.setOption(option);
}


onMounted(()=>{
    Line();
})
</script>

<style lang='scss' scoped>

</style>