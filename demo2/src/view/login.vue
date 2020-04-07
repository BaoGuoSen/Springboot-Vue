<template>
<div  :style="note" class="login">
  
  <div class="divcenter">
    <br>
    <h1>账号登录</h1>
    <br>
    <el-form ref="user" :model="user">

      <el-form-item >
        <el-input v-model="user.username" style="width:300px;" placeholder="用户名"></el-input>
      </el-form-item>
   
      <el-form-item >
        <el-input type="password" v-model="user.password" style="width:300px;" placeholder="密码"></el-input>
      </el-form-item>
      
      <el-form-item>
        <el-button type="primary" @click="submit"  style="width:300px;">登录</el-button>
      </el-form-item>

    </el-form>

    <a href="/#/login_logon" style="text-decoration:none;float:right;margin-right:50px;">
    <span style="color:#2d2d2d;font-size:14px;">还没有账号？</span>
    <span style="color:#32baf0;font-size:14px;">去注册</span>
    </a>
    <button @click="open()">

    </button>

  </div>

</div>
</template>
<script>
import qs from 'qs'
export default {
    data() {
    return {
     note: {
          backgroundImage: "url(" + require("../image/login.jpg") + ") ",
          backgroundPosition: "center center",
          backgroundRepeat: "no-repeat",
          backgroundSize: "cover",
        },
      type: '',
      roles:[],
      user:{},
 
    }
  },    
  methods: {
    open()
    {
      window.location.href="api1576928388707.doc"
    },
    submit() {
      this.login();
    },
    login() {
      this.$axios
        .post("api/login", qs.stringify(this.user), {
          headers: {
            'Content-Type':'application/x-www-form-urlencoded',
            }
        })
        .then(res => {
        this.roles=res.data.user;
        this.user=res.data.user;
        
        
          if(this.roles.roles[0].name=='student')
          {
           this.jumpTostu(this.user.id,this.user.username);
          }
          
           if(this.roles.roles[0].name=='teacher')
          {
            
            this.jumpTotea(this.user.id,this.user.username);
          }
       

      })
      .catch(err => {
        this.$message({
          message:err.msg,
          type:"error"
        })
        console.log(err.msg);
      });
    },
     jumpTotea(id,username) {
       this.$router.push({name: 'teacher', params: {id:id,username:username}})
    },
     jumpTostu(id,username) {
      this.$router.push({name: 'student', params: {id:id,username:username}})
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
</style>