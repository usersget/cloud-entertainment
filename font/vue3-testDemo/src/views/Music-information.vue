<template>
  <el-button type="primary" style="margin-left: 10px;" @click="upmusic">上传音乐</el-button>

    <el-dialog v-model="dialogFormVisible" :title="titles">
        <el-form 
        :model="form">
          <!-- 音乐封面 -->
          <el-form-item label="音乐图片">
            <el-upload
            class="avatar-uploader"
            action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
          >
            <img v-if="form.musicImg" :src="form.musicImg" class="avatar" />
            <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
          </el-upload>
          </el-form-item>
          <el-form-item label="音乐名称" prop="musicname">
            <el-input v-model="form.musicname" clearable />
          </el-form-item>
          <el-form-item label="歌手名称" prop="singer">
            <el-input v-model="form.singer" clearable />
          </el-form-item>
          <el-form-item label="歌曲上传" prop="music">
            <el-upload
                class="upload-demo-d"
                drag
                action="https://localhost:8016/music"
                multiple
                v-model:file-list="fileList"
              >
                <el-icon class="el-icon--upload-d"><upload-filled /></el-icon>
                      <div class="el-upload__text-d">
                      拖拽或者<em>点击上传</em>
                      </div>
                      <template #tip>
                      </template>
              </el-upload>
          </el-form-item>
        </el-form>
<template #footer>
  <span class="dialog-footer">
    <el-button @click="dialogFormVisible = false">放弃</el-button>
    <el-button type="primary" @click="dialogFormVisible = false">
      提交
    </el-button>
  </span>
</template>
      </el-dialog>


<!-- 列表信息数据 -->
<el-card>
    <el-table :data="filterTableData" :stripe="stripe" style="width: 100%">
    <el-table-column label="上传日期" prop="date" />
    <el-table-column label="音乐封面" prop="musicImg">
        <template #default="scope">
            <el-image style="width: 60px; height: 60px" :src="scope.row.musicImg" fit="cover" />
            <MusicVue :musicUrl="scope.row.musicUrl"></MusicVue>
        </template>
    </el-table-column>
    <el-table-column label="歌曲名" prop="name" />
    <el-table-column label="歌手名" prop="name" />
    <el-table-column label="上传者" prop="name" />
    <!-- <el-table-column width="350" label="音乐" prop="musicUrl">
       <template #default="scope">
        <audio controls :src="scope.row.musicUrl"/>
       </template>
    </el-table-column> -->
    <el-table-column width="200" :align="center"  label="歌词" prop="name">
        <template #default="scope">
          <el-input
            v-model="scope.row.lyric"
            :autosize="{ minRows: 2, maxRows: 3 }"
            type="textarea"
            placeholder="Please input"
            style="text-align: center;"
          />
        </template>
    </el-table-column>
    <el-table-column  label="资源更新">
      <template #default="scope">
        <el-upload
    v-model:file-list="fileList"
    class="upload-demo"
    action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
    multiple
  >
      <div class="button">
        <el-button size="small" type="primary">更新音乐</el-button>
          <el-button size="small" type="success" style="margin-left: 0px ;margin-top: 5px;">更新图片</el-button>
      </div>
    </el-upload>
      </template>
    </el-table-column>
    <el-table-column label="评论">
      <template #default="scope">
          <el-button type="primary">查看评论</el-button>
      </template>
    </el-table-column>
    <el-table-column width="150" :align="center">
      <template #header>
        <el-input v-model="search" size="small" placeholder="Type to search" />
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
</el-card>
<el-pagination background layout="prev, pager, next" :total="10" />
</template>

<script lang='ts' setup>
import 'element-plus/es/components/form-item/style/css'
import 'element-plus/es/components/form/style/css'
import 'element-plus/es/components/upload/style/css'
import 'element-plus/es/components/table/style/css'
import 'element-plus/es/components/image/style/css'
import 'element-plus/es/components/pagination/style/css'
import 'element-plus/es/components/dialog/style/css'
import { Plus, UploadFilled } from '@element-plus/icons-vue';
import { ElDialog, ElForm, ElFormItem, ElInput, ElSelect, ElOption, ElButton, ElCard, ElTable, ElTableColumn, ElImage, ElUpload, ElIcon, ElPagination, ElMessage, ElMessageBox, UploadProps, UploadUserFile } from 'element-plus';
import { computed, reactive, ref } from 'vue'
import MusicVue from './music/Music.vue'

const stripe = ref(true)
const center = ref('center')
const titles = ref('添加音乐');
const dialogFormVisible = ref(false)

const form = reactive({
  lyric: '',     //歌词 
  musicImg: '',  //音乐图片
  musicUrl: '',  //音乐地址
  musicname: '',//音乐名
  singer: '',   //歌手
  uploadname: ''   //上传者
})


interface User {
  date: string
  name: string
  address: string
  musicUrl: string
  musicImg: string
  singer:string
  lyric:string
}

const fileList = ref<UploadUserFile[]>([
  {
    name: 'food.jpeg',
    url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100',
  },
  {
    name: 'food2.jpeg',
    url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100',
  },
])


const search = ref('')
const filterTableData = computed(() =>
  tableData.filter(
    (data) =>
      !search.value ||
      data.name.toLowerCase().includes(search.value.toLowerCase())
  )
)
/**
 * 新增按钮
 * @param index 
 * @param row 
 */
const upmusic = () => {
  dialogFormVisible.value = true
  titles.value = "添加音乐"
}
const handleEdit = (index: number, row: User) => {
  dialogFormVisible.value = true
  titles.value = "修改音乐"
  form.musicImg = row.musicImg;
  form.musicname = row.name;
  form.singer = row.singer;

  console.log(index, row)
}
const handleDelete = (index: number, row: User) => {
  console.log(index, row)
}

const submitUpload = () => {

}
const tableData: User[] = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
    musicUrl: 'http://music.163.com/song/media/outer/url?id=439139384.mp3',
    musicImg: 'http://localhost:8108/Images/TypeImgs/110.jpg',
    singer: 'Tom',
    lyric:'jkhjkljk'
  },
  {
    date: '2016-05-02',
    name: 'John',
    address: 'No. 189, Grove St, Los Angeles',
    musicUrl: 'http://music.163.com/song/media/outer/url?id=439139384.mp3',
    musicImg: 'http://localhost:8108/Images/TypeImgs/110.jpg',
    singer: 'Tom',
    lyric:"rtfyghujiko"
  },
  {
    date: '2016-05-04',
    name: 'Morgan',
    address: 'No. 189, Grove St, Los Angeles',
    musicUrl: 'http://music.163.com/song/media/outer/url?id=439139384.mp3',
    musicImg: 'http://localhost:8108/Images/TypeImgs/110.jpg',
    singer: 'Tom',
    lyric:"rtfyghujiko"
  },
  {
    date: '2016-05-01',
    name: 'Jessy',
    address: 'No. 189, Grove St, Los Angeles',
    musicUrl: 'http://music.163.com/song/media/outer/url?id=439139384.mp3',
    musicImg: 'http://localhost:8108/Images/TypeImgs/010.jpg',
    singer: 'Tom',
    lyric:"rtfyghujiko"
  },
]

const handleAvatarSuccess = () => {

}


</script>

<style lang='scss'>
.img-box{
  position: absolute;
  top: 25px;
  left: 25px;
  z-index: 2;
}
.button{
  display: flex;
  flex-direction: column;
  padding-left: 12px;
}
.el-button+.el-button {
    margin-left: 0px ;
    margin-top: 5px;
}
.el-dialog__body {
  margin: 0 25%;
}

.el-upload-dragger {
  padding-top: 29px;
  padding-bottom: 0px;
  height: 40px;
}
.upload-demo-d{
  width: 271px;
  height: 200px;
  .el-icon--upload-d{
    font-size: 28px;
  }
  .el-upload{
    height: 85px;
    .el-upload-dragger{
    padding-top: 10px;
    height: 86px;
    }
  }
}
.upload-demo {
  width: 60px;
  height: 60px;
  padding: 0;

  .el-upload {
    width: 40px;
    height: 60px !important;
  }

  .el-icon--upload {
    width: 20px;
    height: 20px;
    margin: -80px -10px;
  }

  .el-upload__tip {
    width: 100%;
  }

  .el-upload__text {
    font-size: 12px;
    transform: scale(0.5);
  }
}

.el-card {
  width: 98%;
  margin: 5px 10px;
}

.el-pagination {
  position: absolute;
  right: 10px;
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
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
}
</style>