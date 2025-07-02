import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import Profile from '../views/Profile.vue'

Vue.use(Router)

export default new Router({
    mode:'history',
    routes:[
        {path:'/',name:'Home',component:Home},
        {path:'/login',name:'Login',component:Login},
        {path:'/register',name:'Register',component:Register},
        {path:'/profile',name:'Profile',component:Profile},
        //后续有模块再补充
    ]
})