<template>
          <div class="header-right">
        <span class="name">{{user.username}}</span>
    <el-dropdown trigger="click">
        <span class="el-dropdown-link">
           
            <img src="@/assets/001.webp" alt="" :title='user.sid>1?"管理员":"普通用户"'>
        </span>
        <template #dropdown>
            <el-dropdown-menu>
                <el-dropdown-item>个人中心</el-dropdown-item>
                <el-dropdown-item>
                    退出
                </el-dropdown-item>
            </el-dropdown-menu>
        </template>
    </el-dropdown>
    </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue';
import { Expand, Fold , ArrowRight} from "@element-plus/icons-vue";

const user ={
    username:"admin",
    sid:2
}


</script>

<style lang="scss" scoped>
.header-right{
    .name{
            font-size: 20px;
            margin-right: 10px;
            line-height: 60px;
        }

.el-dropdown{
    margin-right: 20px;
    .el-dropdown-link{
        display: flex;
        align-items: center;
      
        img{
            width: 55px;
            height: 55px;
            border-radius: 50%;
        }
    }
}
}
</style>