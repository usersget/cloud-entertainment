<template>
<el-card>
  <div class="header_card">
    <el-form  :model="form">
      <el-row>
    <el-col :span="16">
      <el-form-item label="歌手">
      <el-select v-model="form.singer" @change="Submitsinger" clearable  placeholder="依据您选择的歌手排序">
        <el-option style="max-height: 136px;" v-for='(item,index) in singers' :label="item.singerName" :value="item.singerId" />
      </el-select>
    </el-form-item>
    </el-col>
    <el-col :span="6">
      <el-form-item label="类型">
      <el-select v-model="form.Type" @change="Submitsinger" clearable  placeholder="依据您选择的类型排序">
        <el-option style="max-height: 136px;" v-for='(item,index) in Types'  :label="item.type" :value="item.typeid" />
      </el-select>
    </el-form-item>
    </el-col>
    <!-- <el-col :span="2">
      <el-button type="success" @click="SubList">确认</el-button>
    </el-col> -->
  </el-row>
    </el-form>
  </div>
    <el-table :data="tableData" style="width: 100%">
    <el-table-column label="音乐名称" width="180" prop="musicName">
      <template #default="scope">
        <div style="display: flex; align-items: center">
          <span style="margin-left: 10px">{{ scope.row.musicName }}</span>
        </div>
      </template>
    </el-table-column>
    <el-table-column label="音乐图片" width="100" prop="musicImg">
      <template #default="scope">
        <div style="display: flex; align-items: center;">
          <el-image style=" height: 100%;" :src="scope.row.musicImg">
        <template #placeholder>
          <div class="image-slot">Loading<span class="dot">...</span></div>
        </template>
      </el-image>
        </div>
      </template>
    </el-table-column>
    <el-table-column label="类型名称" width="180" prop="type.type">
      <template #default="scope">
        <el-popover effect="light" trigger="hover" placement="top" width="auto">
          <template #default>
            <div>类型名称: {{ scope.row.type.type }}</div>
            <div>歌手: {{ scope.row.type.typeid }}</div>
          </template>
          <template #reference>
            <el-tag>{{ scope.row.type.type }}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column label="类型描述" prop="type.typeDescription">
      <template #default="scope">
        <span>{{ scope.row.type.typeDescription }}</span>
    </template>
    </el-table-column>
    <el-table-column label="操作">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
          >修改</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>
</el-card>
<el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
       background 
       layout="prev, pager, next" 
       :total="Page.total" 
       :page-size="Page.pagesize"
       :current-page="Page.pageindex"/>
</template>

<script lang='ts' setup>
import { Timer } from '@element-plus/icons-vue'
import { ElCard, ElForm, ElFormItem, ElSelect, ElOption, ElTable, ElTableColumn, ElIcon, ElImage, ElPopover, ElTag, ElButton, ElPagination, ElCol, ElRow } from 'element-plus';
import { el } from 'element-plus/es/locale';
import { onMounted, reactive, ref } from 'vue';
import {getType,getSinger,getTypelist} from '../api/music'

const form = reactive({
singer:0,
Type:0
})
const Page= reactive({
  pageindex:1,
  pagesize:7,
  total:30,
})
let singers = reactive([
{
  singerName:'请选择',
  singerId:0
}
])
let Types = reactive([
  {
    type:'请选择',
    typeid:0
  }
])
interface User {
  musicId:number
  musicName: string
  type:{
    type:string
    typeDescription:string
    typeImg:string
    typeid:number
  }
  musicImg:string
}

const handleEdit = (index: number, row: User) => {
  console.log(index, row)
}
const handleDelete = (index: number, row: User) => {
  console.log(index, row)
}

let tableData=reactive([]as any[]) 
const getTypeone=()=>{
  getType().then((data:any)=>{
    Types=data.data.data;
  })
}

const getSingers=()=>{
  getSinger().then((data:any)=>{
    singers=data.data.data;
  })
}

const handleSizeChange = (val: number) => {
  console.log(`${val} items per page`)
}
const handleCurrentChange = (val: number) => {
  if(val!=Page.pageindex){
    Page.pageindex=val;
    console.log(val)
    getlist();
  }else{
    return;
  }
  
}
const Pagedata = reactive({
  pageIndex:1,
    pageSize:7,
    singerId:0,
    typeid:0
})

const getlist = ()=>{
  Pagedata.pageIndex=Page.pageindex;
  Pagedata.pageSize = Page.pagesize;
  if(form.singer != 0){
    Pagedata.singerId = form.singer;
  }
  if(form.Type != 0){
    Pagedata.typeid = form.Type;
  }
  getTypelist(Pagedata).then((data:any)=>{
    if(data.data.success){
      tableData.length = 0;
      if(data.data.data !=null){
        tableData.values=data.data.data
          for(let i=0;i<data.data.data.length;i++){
          console.log(data.data.data[i])
          tableData.push(data.data.data[i])
          }
       }
    }else{
      tableData.length=0;
    }
  })
}

const Submitsinger = (val:any)=>{
  getlist();
}

onMounted(()=>{
  getTypeone();
  getSingers();
  getlist();
})
</script>

<style lang='scss'>
.el-card{
    margin: 5px 10px;
    height: 550px;
}
.el-pagination{
    position: absolute;
    right: 10px;
}
.el-select-dropdown__wrap {
    max-height: 136px;
}
</style>