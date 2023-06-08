<template>
    <!-- 修改 -->
<el-dialog
    v-model="centerDialogVisible"
    title="修改信息"
    width="30%"
    align-center
    :scroll-to-error="true"
    :inline="true"
  >
  <el-form :model="form" label-width="120px">
    <el-form-item label="用户头像">
        <el-upload
            class="avatar-uploader"
            action=""
            :show-file-list="true"
            :on-success="handleAvatarSuccess"
        >
            <img v-if="form.imageUrl" :src="form.imageUrl" class="avatar" />
            <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
        </el-upload>
    </el-form-item>
    <el-form-item label="用户名">
      <el-input v-model="form.name" />
    </el-form-item>
    <el-form-item label="用户所在地">
      <el-input v-model="form.name" />
    </el-form-item>
    <el-form-item label="邮箱">
      <el-input v-model="form.name" />
    </el-form-item>
    <el-form-item label="用户权限">
      <el-select v-model="form.usersid">
          <el-option label="普通用户" value="0" />
          <el-option label="管理员用户" value="1"/>
        </el-select>
    </el-form-item>
    
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Create</el-button>
      <el-button @click="remSumbit">Cancel</el-button>
    </el-form-item>
  </el-form>
  </el-dialog>

<!-- 列表 -->
 <el-table :data="tableData" style="width: 98%;height: 550px;margin: 0 10px;">
    <el-table-column label="注册日期" prop="date" />
    <el-table-column label="用户头像" prop="imageUrl">
      <template v-slot="scope">
        <el-image style="width: 100px; height: 100px" :src="scope.row.imageUrl"/>
      </template>
    </el-table-column>
    <el-table-column label="用户名" prop="name" />
    <el-table-column label="用户姓名" prop="name" />
    <el-table-column label="邮箱" prop="address" />
    <el-table-column label="注册城市" prop="name" />
    <el-table-column label="用户权限" prop="usersid">
        <template v-slot="scoped">
            <span>{{ scoped.row.usersid>0?"管理员用户":"普通用户" }}</span>
        </template>
    </el-table-column>
    <el-table-column :align="right">
      <template #header>
        <el-input v-model="search" size="small" placeholder="依据用户名搜索" />
      </template>
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
  <el-pagination background small layout="prev, pager, next" :total="1000" />
</template>

<script lang='ts' setup>
import 'element-plus/es/components/form-item/style/css'
import 'element-plus/es/components/form/style/css'
import 'element-plus/es/components/upload/style/css'
import 'element-plus/es/components/table/style/css'
import 'element-plus/es/components/cascader/style/css'
import 'element-plus/es/components/pagination/style/css'
import 'element-plus/es/components/dialog/style/css'
import { ElTable, ElTableColumn, ElInput, ElButton, ElPagination, ElDialog } from 'element-plus';
import { computed, reactive,ref } from 'vue'
const right =ref('right');
const search = ref('')

const centerDialogVisible = ref(false)

const handleEdit = (index: number, row: any) => {
    centerDialogVisible.value = true
    form.imageUrl=row.imageUrl;
    form.name=row.name;
    form.usersid = row.usersid
}
const handleDelete = (index: number, row: any) => {
  console.log(index, row)
}

const tableData =reactive([
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
    imageUrl:'http://127.0.0.1:8888/src/assets/001.webp',
    usersid:"1",
  },
  {
    date: '2016-05-02',
    name: 'John',
    address: 'No. 189, Grove St, Los Angeles',
    imageUrl:'http://127.0.0.1:8888/src/assets/001.webp',
    usersid:"1",
  },
  {
    date: '2016-05-04',
    name: 'Morgan',
    imageUrl:'http://127.0.0.1:8888/src/assets/001.webp',
    address: 'No. 189, Grove St, Los Angeles',
    usersid:"0",
  },
  {
    date: '2016-05-01',
    name: 'Jessy',
    address: 'No. 189, Grove St, Los Angeles',
    imageUrl:'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
    usersid:"1",
  },
])
/**
 * form表单
 */
 const form = reactive({
  name: '',
  usersid:0,
  imageUrl:''
})
const options = [
    {
        value: 0,
        label: '普通用户',
    },
    {
        value: 1,
        label: '管理员用户',
    }
]
const onSubmit = () => {
    centerDialogVisible.value = false
  console.log('submit!')
}
const remSumbit = () =>{
    centerDialogVisible.value = false
}

/**
 * 头像上传
 */
const handleAvatarSuccess = () =>{
    console.log("上传成功")
}
const beforeAvatarUpload = () =>{
    
    console.log("上传成功之前")
}
</script>

<style lang='scss' scoped>
.el-image{
    width: 60px !important;
    height: 60px !important;
}
.el-pagination{
    position: absolute;
    right: 15px;
    margin-top: 10px;
}
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: #f5f7fa;
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}
.el-cascader-menu__wrap{
    height: 75px !important;
}
</style>