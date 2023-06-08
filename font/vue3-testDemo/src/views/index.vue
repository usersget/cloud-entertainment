<template>
  <div class="common-layout">
    <el-container>
      <el-aside :style="'width:' + autoWidth">
        <Logo-bar :collapsed="collapsed" />
        <Menu-bar :collapsed="collapsed" />
      </el-aside>
      <el-container>
        <el-header>
          <!-- 水平方向布局 -->
          <el-row justify="space-evenly">
            <!-- 侧边栏按钮 -->
            <el-icon class="heard-icon" @click="() => (collapsed = !collapsed)">
              <component :is="collapsed ? Expand : Fold" />
            </el-icon>
          </el-row>
          <HeaderBar></HeaderBar>
        </el-header>
        <el-main>
          <breadcrumb></breadcrumb>
          <RouterView></RouterView>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script setup lang="ts">
import LogoBar from './components/LogoBar.vue';
import MenuBar from './components/MenuBar.vue';
import Breadcrumb from './components/Breadcrumb.vue'
import HeaderBar from './components/HeaderBar.vue';
import { Expand, Fold} from "@element-plus/icons-vue";
import { computed, ref } from "vue";
import { isMobile } from '../utils/isMobile';

const collapsed = ref<boolean>(false);
const autoWidth = computed(() => {
  if (collapsed.value && !isMobile()) {
    return "64px"
  } else if (collapsed.value && isMobile()) {
    return "0px"
  } else {
    return "200px"
  }
})

</script>

<style scoped lang="scss">
.common-layout {
  display: flex;
  height: 100vh;

  .el-aside {
    background-color: $menuBg;
    color: var(--el-text-color-primary);
    text-align: center;
    // line-height:200px;
    width: 200px;
    height: 100%;
    overflow: hidden;
  }

  .el-header {
    background-color: #b4c2d1;
    display: flex;
    flex-wrap: nowrap;
    align-items: center;
    justify-content: space-between;
    .heard-icon {
      font-size: 26px;
    }
    .el-breadcrumb{
      font-size: 16px;
      margin-left: 10px;
    }
  }

  .el-main {
    background-color: #8b989e;
    padding: 0;
  }
}
</style>