<template>
    <div class="tag">
        <el-tag v-for="(tag, index) in getbreadcrumb" :key="tag" class="mx-1" closable :disable-transitions="false"
            @click="toupload(tag)" @close="handleClose(tag, index)"
            @contextmenu.prevent.native="openContextMenu($event)">
            {{ tag.title }}
        </el-tag>
    </div>


</template>

<script lang='ts' setup>
import { ElMessage, ElTag } from 'element-plus'
import { ref, computed, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useStore } from 'vuex'
import { Itable } from '../../store/type'
import 'element-plus/es/components/message/style/css';
import 'element-plus/es/components/tag/style/css';
const store = useStore();
const route = useRoute();
const router = useRouter();
const editableTabsValue = ref({ title: String, name: String })
const getbreadcrumb = computed(() => {
    return store.getters.getbreadcrumb;
})
/**
 * 删除事件
 * @param item 
 */
const handleClose = ((item: { name: string, title: string }, index: number) => {
    const length = store.state.breadcrumb.length - 1;
    if (item.name === 'home') {
        //当前页不可删除
        ElMessage.error('首页不可删除')
        return
    }
    if (index === length) {
        router.push({ name: store.state.breadcrumb[index - 1].name })
    } else {
        router.push({ name: store.state.breadcrumb[length].name })
    }
    store.commit('uninbreadcrumb', item)
})
/**
 * 点击跳转
 * @param item 
 */
const toupload = (item: { name: string, title: string }) => {
    router.push({ name: item.name })
}
/**
 * 刷新，本地缓存标签数据
 */
const refresh = () => {
    /**
     * 数据缓存
     */
    window.addEventListener("beforeunload", () => {
        sessionStorage.setItem('TABS_ROUTERS', JSON.stringify(getbreadcrumb.value))
    })
    /**
     * 数据获取
     */
    let session = sessionStorage.getItem('TABS_ROUTERS');
    if (session) {
        let TabItem = JSON.parse(session);
        TabItem.forEach((tab: object) => {
            store.commit('inbreadcrumb', tab)
        });
    }
}
/**
 * tab右键显示菜单列表
 */
const openContextMenu = (e: any) => {
    console.log(e.path)
}
/**
 * 页面初始化
 */
onMounted(() => {

    //获取TAB
    const getbreadcrumb = computed(() => {
        return store.state.breadcrumb;
    })
    // 刷新保存数据
    refresh();
})
</script>

<style lang='scss' scoped>
.tag{
    width: 100%;
}
.el-tag {
    margin: 10px 5px;
}
</style>