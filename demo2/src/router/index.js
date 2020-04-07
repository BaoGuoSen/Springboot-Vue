import Vue from 'vue'
import App from '../App'
import Router from 'vue-router'
import studentlist from '@/view/studentlist'

import HelloWorld from '@/components/HelloWorld'
import login  from '@/view/login'
import homePage from '@/view/homePage'
import logon from '@/view/logon'

import logontea from '@/view/logontea'
import logonstu from '@/view/logonstu'
import tea from '@/view/tea'
import stu from '@/view/stu'
import work from '@/view/work'
import teawork from '@/view/teawork'
import correctwork from '@/view/correctwork'
import score from '@/view/score'
import teascore from '@/view/teascore'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login_page',
    },
    {
      path: '/login_page',
      name: 'login',
      component: login,
    },
    {
      path: '/login_logon',
      name: 'logon',
      component: logon,
    },
   
    {
      path: '/login_logontea',
      name: 'logontea',
      component: logontea,
    },
    {
      path: '/login_logonstu',
      name: 'logonstu',
      component: logonstu,
    },
    {
      path: '/studentlist/:cflag',
      name: 'studentlist',
      component: studentlist,
    },
    {
      path:'/student/:id/:username',
      name:'student',
      component:stu,
    },
    {
      path:'/teacher/:id/:username',
      name:'teacher',
      component:tea,
    },
    {
      path:'/classwork/:id/:username/:cflag',
      name:'work',
      component:work,
    },
    {
      path:'/teaclasswork/:id/:username/:cflag',
      name:'teawork',
      component:teawork,
    },
    {
      path:'/correctwork/:wid/:cflag',
      name:'correctwork',
      component:correctwork,
    },
    {
      path:'/score/:id',
      name:'score',
      component:score,
    },
    {
      path:'/teascore/:cflag',
      name:'teascore',
      component:teascore,
    },
  ]
})
