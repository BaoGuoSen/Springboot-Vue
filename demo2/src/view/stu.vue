<template>
    <div>

         <div class="top">
            <ul style="margin-top:5px;margin-left:0px;float:left;">
                <li class="menu-left"><img src="../image/title.png" style="width:106px;height:28px;float:right;"></li>
                <li class="menu-left" style="width:106px;height:28px;"><a  class="active">课堂</a></li>
                <li class="menu-left" style="width:106px;height:28px;"><a  >精品专区</a></li>
                <li class="menu-left" style="width:106px;height:28px;"><a  >我的精品</a></li>
            </ul>

            <ul style="margin-top:0px;margin-right:0px;float:right;">
                <li class="menu-right" style="color:black;margin-top:25px;">{{this.user.username}}</li>
                <li class="menu-right"> 
                    <el-button icon="el-icon-user-solid" circle @click="transshow()"></el-button>
                    <div class="user" v-show="usershow">

                       <ul style="cursor:pointer;">
                           <li>开通vip</li>
                           <li>个人设置</li>
                           <li><a @click="loginout()">退出账户</a></li>
                       </ul>

                    </div>
                </li>
            
            <li class="menu-right" style="margin-top:5px;"> 
                <el-badge :value="100" :max="99" class="item">
                    <el-button icon="el-icon-message" circle type="primary"></el-button>
                </el-badge>
            </li>
              
            </ul>

        </div>

        <div class="mid">
            <p style="float:left;margin-top:30px;">全部课程</p>
             <span style="float:right;margin-top:30px;padding-right:122px;">
                <span class="guidang" @click="guidangclick()">归档管理</span>
                <el-button icon="el-icon-circle-plus-outline"  type="primary" @click="joinclick()">创建课程</el-button>
            </span>
        </div>
        
        <div class="down">
            <!-- 课程循环 -->
            <div style="width: 270px;margin-left:60.7px;margin-top:30px;float:left;" v-for="course  in courses" :key="course.cflag" v-show="course.state">
            <el-card :body-style="{ padding: '0px' }">
                <div :style="background" class="img">
                    <span class="span">
                        <strong style="position: relative;left:15px;top:20px;"><a style="cursor:pointer;" @click="jumptowork(course.cflag)">{{course.cname}}</a></strong>
                        <span style="position: relative;left:-73px;top:50px;">117030801,02</span>
                        <p style="position: relative;left:-58px;top:70px;font-size:12px;">加课码:{{course.cflag}}</p>
                        
                    </span>
                </div>
                
                <div class="cardmid">
                    <span style="float:left;padding:14px;">
                        <p class="zuoye">近期作业</p>
                        <ul >
                            <li>zuoye1</li>
                            <li>zuoye2</li>
                        </ul>
                    </span>
                </div>

                <div class="carddown">
                    <span style="float:left;position:relative;top:5px;left:10px;">
                        <img style="width: 20px;height: 20px;" src="../image/title.png">
                        <span >{{course.teacher}}</span>
                        <span style="margin-left:120px;">
                            <a style="font-size:12px;cursor:pointer;" @click="deleteclick(course.cflag)">退课</a>
                            <el-dropdown >
                                <span class="el-dropdown-link" style="font-size:12px;">更多</span>
                                    <el-dropdown-menu slot="dropdown">
                                        
                                        <el-dropdown-item ><a @click="deleteclick(course.cflag)">退课</a></el-dropdown-item>
                                        <el-dropdown-item><a @click="guidang(course.cflag)">归档</a></el-dropdown-item>
                                    </el-dropdown-menu>
                            </el-dropdown>
                        </span>

                    </span>
                        
                </div>
            </el-card>
            </div>

           <!-- 添加课程 -->
            <div style="width: 270px;padding: 0 4%;margin-top:30px;float:left;">
            <el-card :body-style="{ padding: '0px' }">
                <div :style="background" class="img">
                    
                </div>
                
                <div class="cardmid">
                    <span style="position:relative;top:80px;left:-20px;">
                    <el-button style="position:relative;top:-40px;left:60px;" @click="joinclick()">+</el-button>
                    <a style="width:30px;height:30px;cursor:pointer;" @click="joinclick()">加入课程</a>
                    </span>
                </div>

                <div class="carddown">
                </div>
            </el-card>
            </div>

        </div>

         <!-- 添加框 -->
       <el-dialog title="加入课程" :visible.sync="joinshow" style="width:1000px;margin:auto;">
            <el-form :model="c_stu">
                <el-form-item label="课程码:" style="margin:auto;">
                    <el-input v-model="c_stu.cflag" style="width:300px;" placeholder="请输入要加入课程的课程码"></el-input>
                </el-form-item>
            </el-form>
            
            <div slot="footer" class="dialog-footer">
                <el-button @click="joinshow = false">取 消</el-button>
                <el-button type="primary"  @click="joincourse()">加入</el-button>
            </div>
        </el-dialog>

         <!-- 归档页面 -->
       <el-dialog title="归档管理" :visible.sync="guidangshow">
           <div style="height:400px;">
               <!-- 归档课程 -->
               <div class="gd" :style="background" v-for="course in courses" :key="course.cflag" v-show="!course.state">
                    
                    <strong style="float:left;margin-left:20px;margin-top:20px;"><a style="cursor:pointer;font-size:20px;color:white" @click="jumptowork(course.cflag)">{{course.cname}}</a></strong>
                    <span style="float:left;margin-left:-82px;margin-top:70px;color:white;">
                        <span>老师:&nbsp;{{course.teacher}}</span>
                        <el-dropdown style="position:relative;left:160px;">
                                <span class="el-dropdown-link" style="font-size:30px;color:white;">...</span>
                                    <el-dropdown-menu slot="dropdown">
                                        <el-dropdown-item ><a @click="deletecourse(course.cflag)">退课</a></el-dropdown-item>
                                        <el-dropdown-item><a @click="recover(course.cflag)">恢复</a></el-dropdown-item>
                                    </el-dropdown-menu>
                            </el-dropdown>
                    </span>
               </div>
           </div> 
       </el-dialog>

    </div>
</template>
<script>
export default {
    data() {
    return {
        background: {
          backgroundImage: "url(" + require("../image/login.jpg") + ") ",
          backgroundPosition: "center center",
          backgroundRepeat: "no-repeat",
          backgroundSize: "cover",
        },
        usershow:false,
        joinshow:false,
        courses:[],
        user:{},
        c_stu:{},
        guidangshow:false,
        allcourses:[],
    }
  },    
  methods: {

      recover(cflag){
         this.$axios
        .get('api/tea/recover?cflag='+ cflag+"&&state="+true)
        .then(res => {
           this.getallcourse(this.user.uid);
            this.$message({
          showClose: true,
          message: '恢复成功',
          type: 'success'
        });
          
        })
        .catch(err => {
          this.$message.error('恢复失败');
          console.log(err);
        })
    },

    guidangclick()
    {
        this.guidangshow=true;
    },

    guidang(cflag) {
      this.$axios
        .get('api/tea/guidang?cflag='+ cflag+"&&state="+false)
        .then(res => {
            this.getallcourse(this.user.uid);
            this.$message({
          showClose: true,
          message: '归档成功',
          type: 'success'
        });
          
        })
        .catch(err => {
         this.$message.error('归档失败');
          console.log(err);
        })
    },
    
   transshow(){
       if(this.usershow)
            this.usershow=false;
        else
            this.usershow=true;
   },
   joinclick()
   {
       this.joinshow=true;
   },
   joincourse() {
       
       for(var i=0;i<this.allcourses.length;i++)
       {
           if(this.c_stu.cflag==this.allcourses[i].cflag)
                {
                    this.joinshow=false;
                    this.$axios
                    .post("api/stu/joincourse", this.c_stu)
                    .then(res => {
                    this.getallcourse(this.user.uid);
                    
                        this.getallcourse(this.user.uid);
                        this.$message({
                        showClose: true,
                        message: '加课成功',
                        type: 'success'
                        });
                    })
                    .catch(err => {
                    this.$message.error('加课失败');
                    console.log(err);
                    });
                }    
       }
       if(this.joinshow)
        {
            this.$message.error('该课程不存在');
        }
    },

    findcourses() {
      this.$axios
        .get('api/stu/findcourses')
        .then(res => {
        
          this.allcourses= res.data

        })
        .catch(err => {
          this.$message.error('查询失败');
          console.log(err);
        })
    },

    getallcourse(id) {
      this.$axios
        .get('api/stu/getallcourse?id='+ id)
        .then(res => {
           
          this.courses= res.data

        })
        .catch(err => {
         this.$message.error('查询失败');
          console.log(err);
        })
    },
    deleteclick(cflag)
    {
        this.c_stu.cflag=cflag;
        this.deletecourse();
    },
    deletecourse() {
      this.$axios
        .post("api/stu/deletecourse", this.c_stu)
        .then(res => {
        this.getallcourse(this.c_stu.uid);
                        this.$message({
                        showClose: true,
                        message: '退课成功',
                        type: 'success'
                        });
          
      })
      .catch(err => {
        this.$message.error('退课失败');
        console.log(err);
      });
    },

    jumptowork(cflag) {
      this.$router.push({name: 'work', params: {id:this.user.uid,username:this.user.username,cflag:cflag}})
    },

    
    loginout(){
         this.$router.push('/login_page')
    },
  },
    
  mounted() {
   if (this.$route.params.id!=null) {
       this.c_stu.uid=this.$route.params.id;
       this.user.uid=this.$route.params.id;
       this.user.username=this.$route.params.username;
        this.getallcourse(this.$route.params.id);
        this.findcourses();
        }
    }
}
</script>
<style scoped>
.top{
    z-index: 2;
    padding: 0 4%;
    box-sizing: border-box;
    box-shadow: 0 0 10px #ccc;
    width: 100%;
    height: 72px;
}
li,ul{
    list-style: none;
}
a{
    text-decoration: none;
}
.menu-left{
    margin: 18px;
    float: left;
    color: #FFF;
    position: relative;
    height: 27px;
    line-height: 27px;
}
.menu-right{
    margin: 18px;
    float: right;
    color: #FFF;
    position: relative;
    height: 27px;
    line-height: 27px;
}
.menu-left a{
    padding-bottom: 22px;
    padding-left: 15px;
    padding-right: 15px;
    font-size: 16px;
    color: #3B3D45;
}
.menu-right a{
    padding-bottom: 22px;
    padding-left: 15px;
    padding-right: 15px;
    font-size: 16px;
    color: #3B3D45;
}
.menu-left a.active{
    border-bottom: 4px solid #2C58AB;
    border-left: 2px solid transparent;
    border-right: 2px solid transparent;
}
.user{
    position: absolute;
    width: 160px;
    padding: 8px 0;
    left: -110px;
    top: 45px;
    text-align: center;
    z-index: 10;
    background: #FFF;
    box-shadow: 0 0 20px rgba(0,0,0,.35);
}
.user ul li{
    line-height: 40px;
    font-size: 14px;
    color: rgb(45, 45, 45);
}
.mid{
    width: 100%;
    height: 72px;
    position: relative;
    box-shadow: 0 1px 0 0 rgba(226,230,237,1);
    padding: 0 4%;
}
.down{
    width: 100%;
    position: relative;
    
}
.img{
    width: 270px;
    height: 120px;
   
}
.span{
    color: aliceblue;
    font-size: 20px;
    float: left;
}
.zuoye{
    font-size: 12px;
    font-family: PingFangSC-Medium;
    font-weight: 500;
    color: rgba(95,99,104,1);
}
.cardmid{
    width: 270px;
    height: 100px;
}
.cardmid ul li{
    height: 30px;
    line-height: 30px;
    width: 100%;
    overflow: hidden;
}
.carddown{
    width: 270px;
    height: 50px;
}
.add{
    width: 295px;
    height: 210px;
    position: fixed;
    left: 40%;
    top: 35%;
    background:rgb(230, 172, 172);
    border: 0;
}
.addtop{
    color: #a9a9a9;
    font-size: 18px;
    border-bottom: 1px solid #ececec;
    height: 66px;
    line-height: 66px;
    padding-left: 28px;
}
.caozuo{
    position:relative;
    top:40px;
    left:120px;
    width: 128px;   
    padding: 5px 0;
    border: 1px solid #dcdcdc;
    background: #FFF;
    height: 60px;
}
.el-dropdown-link {
    cursor: pointer;
    
  }
.el-icon-arrow-down {
    font-size: 12px;
  }
.item{
    margin-top: 10px;
  margin-right: 40px;
}
.guidang{
    font-size: 14px;
    color: #78787a;
    line-height: 16px;
    height: 16px;
    cursor: pointer;
    margin-right:20px;
}
.gd{
    
    float:left;
    width:300px;
    height: 110px;
    margin-left:40px;
    margin-top:20px;
}
</style>