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
            status-icon :rules="rules" label-width="90px"
                class="demo-ruleForm">
                <el-form-item label="用户姓名" prop="name">
                    <el-input placeholder="请输入您的名字" v-model="ruleForm.name" />
                </el-form-item>
                <el-form-item label="用户名" prop="username">
                    <el-input placeholder="请输入用户名" v-model="ruleForm.username" />
                </el-form-item>
                <el-form-item label="密 码" prop="password">
                    <el-input type="password" placeholder="请输入密码" show-password v-model="ruleForm.password" />
                </el-form-item>
                <el-form-item label="确认密码" prop="password1">
                    <el-input type="password" placeholder="请确认密码" show-password v-model="ruleForm.password1" />
                </el-form-item>
                <el-form-item label="用户邮箱" prop="email">
                    <el-input placeholder="请输入您的邮箱" v-model="ruleForm.email" />
                </el-form-item>
                <el-form-item class="submit">
      <el-button class="submit-button"  type="primary" @click="submitForm(ruleFormRef)"
        >注册</el-button
      >
      <el-button @click="regest(ruleFormRef)">去登陆</el-button>
    </el-form-item>
            </el-form>
        </el-card>
    </div>
</template>

<script lang='ts' setup>
import 'element-plus/es/components/input/style/css';
import { reactive, ref } from 'vue'
import { ElMessage,FormInstance, FormRules } from 'element-plus'
import {addUser} from '../api/user'
import router from '../router';
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
    name:'',
    username:'',
    password:'',
    password1:'',
    email:'',
})
/**
 * 验证邮箱
 * @param formEl 
 */
 const sendEmail=(rules:any,value: any, callback: any)=>{
    var regEmail = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    if (!value) {
    return callback(new Error('请输入您的邮箱'))
  }else{
    if (ruleForm.email != '' && !regEmail.test(ruleForm.email)) {
      callback(new Error('请注意邮箱格式'))
    }else{
        callback()
    }
  }

    
}
/**
 * 密码验证
 * @param rules 
 * @param value 
 * @param callback 
 */
const sendPassword=(rules:any,value: any, callback: any)=>{
  if(!value){
    return callback(new Error('请输入确认密码'))
  }else{
    if(ruleForm.password === ruleForm.password1){
     return callback()
    }else{
     return callback(new Error('两次密码不一致'))
    }
  }
  
}
/**
 * 普通校验
 */
const rules=reactive<FormRules>({
    name:[{ required: true, message: '请输入用户姓名', trigger: 'blur' },],
    username: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { min: 2, message: '用户名大于两个字符', trigger: 'blur' },
  ],
  password: [
    { required: true, message: '请输入用户密码', trigger: 'blur' },
    { min: 4, message: '密码最少四位', trigger: 'blur' },
  ],
  password1: [
    { required: true, message: '请输入确认密码', trigger: 'blur' },
    { validator:sendPassword, trigger: 'blur' },
  ],
  email:[
  { required: true, message: '请输入您的邮箱', trigger: 'blur' },
    {validator:sendEmail,trigger:'blur'}
]
})
/**
 * 注册按钮
 * @param formEl 
 */
const submitForm =async (formEl:FormInstance|undefined) => {
  if(!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid){
      addUser(ruleForm).then((data:any)=>{
        if(data.data.success){
          router.push('/login');
          ElMessage.success(data.data.message);
          return;
        }
        ElMessage.error(data.data.message);
      })
    }else{
      ElMessage.error('请正确输入注册信息')
      return
    }
  })
  console.log(formEl.isValidatable)
    
   
}
/**
 * 
 * @param formEl 去登陆按钮
 */
const regest = (formEl: FormInstance | undefined) => {
  router.push('/login')
 
  if (!formEl){  
    return
  } 
}
</script>

<style lang='scss' scoped>
.submit{
    margin-top: 30px !important;
    .submit-button{
         margin-right: 100px ;
    }
   
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
        height: 400px;
        position: absolute;
       background-color: rgba($color: #fff, $alpha: 0.9);
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        margin: auto;
        .card-header {
            text-align: center;
        }
    }
    .submit{
        margin-top: 15px;
    }
}

</style>