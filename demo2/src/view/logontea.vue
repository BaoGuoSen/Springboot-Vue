<template>
<div  :style="note" class="login">
  
  <div class="divcenter">

    <div class="top">

        <a class="return" href="/login_page#/login_logon"> </a>
        <h1 style="float:left;line-height:40px;">老师/助教注册</h1>

    </div>
    
    <div class="middle">
        
        <el-form ref="teacherForm" :model="teacherForm"  >

            <el-form-item >
                <el-input v-model="teacherForm.id" style="width:300px;" placeholder="id"></el-input>
            </el-form-item>

            <el-form-item >
                <el-input v-model="teacherForm.username" style="width:300px;" placeholder="用户名"></el-input>
            </el-form-item>
            
            <el-form-item >
                <el-input v-model="teacherForm.password" style="width:300px;" placeholder="密码"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submit" style="width:300px;">注册为老师/助教</el-button>
            </el-form-item>

         </el-form>

    </div>
    <a href="/#/login_page" style="text-decoration:none;float:right;margin-right:45px;">
    <span style="color:#2d2d2d;font-size:14px;">已有账号？</span>
    <span style="color:#32baf0;font-size:14px;">去登录</span>
    </a>

  </div>

</div>
</template>
<script>
import qs from 'qs'
export default {
    data() {
    return {
     note: {
          backgroundImage: "url(" + require("../image/logon1.jpg") + ") ",
          backgroundPosition: "center center",
          backgroundRepeat: "no-repeat",
          backgroundSize: "cover",
        },
      type: '',
      teacherForm: {},
    
    }
  },    
  methods: {
    submit() {
      this.addStudent();
    },
    addStudent() {
      this.$axios
        .post("api/logon/addTeacher", this.teacherForm)
        .then(res => {
          alert("添加成功");
          this.teacherForm = {}
          this.jumpToList()
        //   $router.go('/demo3/studentList')
      })
      .catch(err => {
        alert("添加失败");
        console.log(err);
      });
    },
     jumpToList() {
      this.$router.push('/login_page')
    }
  },
}
</script>
<style scoped>
.add-box{
    padding-left:20px;
    padding-top:20px;
    display: inline;
}
.login{
  width:100%;
  height:100%;
}
.divcenter{
  position: relative;
  top:100px;
  margin: 0 auto;
  width: 400px;
  height: 450px;
  background: white;
  border: 20px;
}
.return{
    width: 40px;
    height: 40px;
    background: url(../image/return.png) no-repeat;
    display: inline-block;
    margin-right:22px;
    float: left;
}
.top{
    height: 60px;
    padding-top:30px;
    padding-left:30px;
}
.middle{
    margin-top: 25px;
    
}
</style>