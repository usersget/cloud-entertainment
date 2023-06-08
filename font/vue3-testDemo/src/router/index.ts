import { createRouter,createWebHashHistory,RouteRecordRaw } from "vue-router"

const routersl:Array<RouteRecordRaw>=[
    {
        path:'/',
        redirect:'/home',
        component:() =>import("@/views/index.vue"),
        children:[
            {
                path:'/home',
                name:"home",
                component:() => import("@/views/Home.vue")
            },
            {
                path:'mycard',
                name:"mycard",
                component:() =>import("@/views/MyCard.vue")
            },
            {
                path:'user',
                name:"user",
                component:() =>import("@/views/User.vue")
            },
            {
                path:'Music-Genre',
                name:"Music-Genre",
                component:() =>import("@/views/Music-Genre.vue")
            },
            {
                path:'Music-information',
                name:"Music-information",
                component:() =>import("@/views/Music-information.vue")
            },
            {
                path:'Music-album',
                name:"Music-album",
                component:() =>import("@/views/Music-album.vue")
            },
            {
                path:'fm-radio',
                name:"fm-radio",
                component:() =>import("@/views/Fm-radio.vue")
            },
            {
                path:'Music-forum',
                name:"Music-forum",
                component:() =>import("@/views/Music-forum.vue")
            },
            {
                path:'System-management',
                name:"System-management",
                component:() =>import("@/views/System-management.vue")
            },
            {
                path:'announcement',
                name:'announcement',
                component:() =>import("@/views/components/Announcement.vue")
            }
        ]
    },
    {
        path:'/login',
        name:"login",
        component:() =>import("@/views/Login.vue")
    },
    {
        path:'/reg',
        name:"reg",
        component:() =>import("@/views/Registered.vue")
    }
]

const router = createRouter({
    history:createWebHashHistory(),
    routes:routersl
})

export default router;