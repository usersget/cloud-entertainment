<template>
<div id="barchart" style="width:100%;height:300px;"></div>
</template>

<script lang='ts' setup>
import * as echarts from 'echarts';
import { onMounted } from 'vue';

type EChartsOption = echarts.EChartsOption;
var option: EChartsOption;

const getBarchart =() =>{
    var chartDom = document.getElementById('barchart')!;
var myChart = echarts.init(chartDom);
    option = {
        title: {
            text: '类型排名'
            },
            tooltip: {
                trigger: 'axis'
            },
  xAxis: {
    type: 'category',
    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
  },
  yAxis: {
    type: 'value'
  },
  toolbox: {
    feature: {
      saveAsImage: {}
    }
  },
  series: [
    {
      data: [120, 200, 150, 80, 70, 110, 130],
      type: 'bar',
      showBackground: true,
      backgroundStyle: {
        color: 'rgba(180, 180, 180, 0.2)'
      }
    }
  ]
};
option && myChart.setOption(option);
}


onMounted(()=>{
    getBarchart();
})
</script>

<style lang='scss' scoped>

</style>