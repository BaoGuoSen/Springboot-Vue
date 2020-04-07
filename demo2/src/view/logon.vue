<template>
<div  :style="note" class="login">
  
  <div class="divcenter">
    <br>
    <h1 style="float:left;margin-left:50px;">注册账号</h1>
    
    <span style="float:left;margin-left:50px;margin-top:20px;color:#707070">请选择您在日常教学中的实际身份</span>

    <div class="choose">
      <a href="/#/login_logontea" >我是老师/助教</a>
      <a style="margin-top:50px;" href="/#/login_logonstu">我是学生</a>
    </div>
    <br>
    <a href="/#/login_page" style="text-decoration:none;float:right;margin-right:40px;">
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
    
    }
  },    
  methods: {
    submit() {
      this.login();
    },
    
     jumpToList() {
      this.$router.push('/homePage')
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
.choose{
  margin-top: 130px;
  margin-left: 15px;
}
.choose a{
  text-decoration: none;
    display: block;
    width: 300px;
    font-size: 16px;
    color: #fff;
    height: 50px;
    line-height: 50px;
    text-align: center;
    background: #32BAF0;
    border-radius: 4px;
    margin-left: 40px;
    position: relative;
}
</style>