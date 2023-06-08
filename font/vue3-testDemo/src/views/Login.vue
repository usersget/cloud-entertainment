<template>
    <div class="login">
        <el-card class="box-card">
            <template #header>
                <div class="card-header">
                    <span>音乐后台管理系统</span>
                </div>
            </template>
            <el-form ref="ruleFormRef" :model="ruleForm"
            :show-message="true"
            label-position="left"
            status-icon :rules="rules" label-width="70px"
                class="demo-ruleForm">
                
                <el-form-item label="用户名" prop="username">
                    <el-input placeholder="请输入用户名" v-model="ruleForm.username" />
                </el-form-item>
                <el-form-item label="密 码" prop="password">
                    <el-input type="password" placeholder="请输入密码" show-password v-model="ruleForm.password" />
                </el-form-item>
                <el-form-item label="验证码" prop="kapt">
                    <el-input style="width: 120px;" placeholder="请输入验证码" v-model="ruleForm.kapt" />
                    <img class="capt" :src="imgurl.url" alt="" srcset="">
                </el-form-item>
                <el-form-item>
      <el-button class="submit" type="primary" @click="submitForm(ruleFormRef)"
        >登录</el-button
      >
      <el-button @click="regest(ruleFormRef)">注册</el-button>
    </el-form-item>
            </el-form>
        </el-card>
    </div>
</template>

<script lang='ts' setup>
import 'element-plus/es/components/message/style/css';
import 'element-plus/es/components/input/style/css';
import 'element-plus/es/components/form-item/style/css';
import 'element-plus/es/components/form/style/css';
import 'element-plus/es/components/card/style/css';
import 'element-plus/es/components/button/style/css';
import {getCapt, putUser} from '../api/user'
import { onMounted, reactive, ref } from 'vue'
import { useRoute } from 'vue-router';
import { ElMessage,ElButton, ElCard, ElForm, ElFormItem, ElInput, FormInstance, FormRules } from 'element-plus'
import router from '../router';
const route =useRoute()
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
    username:'',
    password:'',
    kaptid:'',
    kapt:''
})
const rules=reactive<FormRules>({
    username: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { min: 2, message: '用户名大于两个字符', trigger: 'blur' },
  ],
  password: [
    { required: true, message: '请输入用户密码', trigger: 'blur' },
    { min: 4, message: '密码最少四位', trigger: 'blur' },
  ],
  kapt:[
  { required: true, message: '请输入用户密码', trigger: 'blur' },
  ]
})
const imgurl = reactive({
    url:"",
    code:""
})
const getcaptImg =()=>{
    getCapt().then((data:any)=>{
        imgurl.url=data.data.base64
        imgurl.code=data.data.code
    })
}
/**
 * 登录按钮
 * @param formEl ref数据校验
 */
const submitForm = async (formEl:FormInstance|undefined) => {
    if(!formEl) return;
let userdata={
    user:ruleForm,
    code:imgurl.code
}
    await formEl.validate((valid, fields) => {
        if(valid){
            putUser(userdata).then((data)=>{
                if(data.data.success){
                    ElMessage.success('登陆成功')
                    console.log(data)
                router.push({path:'/home'})
                }else{
                    ElMessage.error(data.data.message)
                }
             })
        }
    })
   
    
}
/**
 * 注册按钮
 * @param formEl 
 */
const regest = (formEl: FormInstance | undefined) => {
  router.push('/reg')
  if (!formEl) return
  formEl.resetFields()
}
/**
 * 生命周期钩子
 */
onMounted(()=>{
    getcaptImg();
    // window.location.reload();
})
</script>

<style lang='scss' scoped>
.submit{
    margin-right: 100px ;
}
.login {
    margin: 0;
    padding: 0;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background: url('../assets/1.jpg') no-repeat;
    background-position: center center;
    background-attachment: fixed;
    background-size: 100% 100%;
    .box-card {
        width: 400px;
        height: 300px;
        position: absolute;
       background-color: rgba($color: #fff, $alpha: 0.9);
        // top: 50%;
        // left: 50%;
        // margin-top: -150px;
        // margin-left: -200px;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        margin: auto;
        .card-header {
            text-align: center;
        }
    }
    .capt{
        margin-left: 10px;
        border: 1px solid #dcdfe6;
    }
}
</style>