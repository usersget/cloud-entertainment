<template>
<div id="Teapchart" style="width:700px;height:550px;"></div>
</template>

<script lang='ts' setup>
import { onMounted } from 'vue';
import * as echarts from 'echarts';
import axios from 'axios'


var ROOT_PATH = 'https://geo.datav.aliyun.com/areas_v3/bound/100000_full.json';
type EChartsOption = echarts.EChartsOption;
var option: EChartsOption;
const getTeap=()=>{
    var chartDom = document.getElementById('Teapchart')!;
var myChart = echarts.init(chartDom);


myChart.showLoading();
axios.get('/json/china.json').then((geoJson:any)=>{
    console.log(geoJson)
    myChart.hideLoading();

echarts.registerMap('CHINA', geoJson.data);

myChart.setOption(
  (option = {
    title: {
      text: '全国用户分布图',
      subtext: '移动端统计',
    //   sublink:
    //     'http://zh.wikipedia.org/wiki/%E9%A6%99%E6%B8%AF%E8%A1%8C%E6%94%BF%E5%8D%80%E5%8A%83#cite_note-12'
    },
    tooltip: {
      trigger: 'item',
      formatter: '{b}<br/>注册用户{c} 人'
    },
    toolbox: {
      show: true,
      orient: 'vertical',
      left: 'right',
      top: 'center',
      feature: {
        dataView: { readOnly: false },
        restore: {},
        saveAsImage: {}
      }
    },
    visualMap: {
      min: 800,
      max: 50000,
      text: ['High', 'Low'],
      realtime: false,
      calculable: true,
      inRange: {
        color: ['lightskyblue', 'yellow', 'orangered']
      }
    },
    series: [
      {
        name: '中国地图',
        type: 'map',
        map: 'CHINA',
        // label: {
        //   show: true
        // },
        data: [
          { name: '甘肃省', value: 20057.34 },
          { name: '陕西省', value: 15477.48 },
          { name: '内蒙古自治区', value: 31686.1 },
          { name: '黑龙江省', value: 6992.6 },
          { name: '吉林省', value: 44045.49 },
          { name: '辽宁省', value: 40689.64 },
          { name: '北京市', value: 37659.78 },
          { name: '河北省', value: 45180.97 },
          { name: '新疆维吾尔自治区', value: 55204.26 },
          { name: '青海省', value: 21900.9 },
          { name: '西藏自治区', value: 4918.26 },
          { name: '四川省', value: 5881.84 },
          { name: '海南省', value: 4178.01 },
          { name: '云南省', value: 2227.92 },
          { name: '贵州省', value: 2180.98 },
          { name: '重庆市', value: 9172.94 },
          { name: '湖南省', value: 3368 },
          { name: '江西省', value: 806.98 },
          { name: '福建省', value: 807.98 },
          { name: '河南省', value: 806.98 },
          { name: '山东省', value: 806.98 },
          { name: '安徽省', value: 806.98 },
          { name: '江苏省', value: 806.98 },
          { name: '上海市', value: 806.98 },
          { name: '浙江省', value: 806.98 },
          { name: '山西省', value: 806.98 },
          { name: '宁夏回族自治区', value: 806.98 },
          { name: '湖北省', value: 806.98 },
          { name: '广西壮族自治区', value: 806.98 },
          { name: '广东省', value: 806.98 },
          { name: '台湾省', value: 806.98 },
        ],
      }
    ]
  })
);
})
option && myChart.setOption(option);
}
onMounted(()=>{
    getTeap();
})
</script>

<style lang='scss' scoped>

</style>