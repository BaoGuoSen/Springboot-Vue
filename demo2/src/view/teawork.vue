<template>
    <div>

        <div class="top">
            <ul style="margin-top:5px;margin-left:0px;float:left;">
                <li class="menu-left" >
                    <a  style=" cursor: pointer;" @click="returnclick()">课堂></a>
                    <span style="margin-left:-10px;color:black;">{{this.course.cname}} &nbsp;117030801,02</span>
                </li>
            </ul>

            <ul style="margin-top:5px;margin-right:0px;float:right;">
                <li class="menu-right"> 
                    <el-button icon="el-icon-user-solid" circle @click="transshow()"></el-button>
                    <div class="user" v-show="usershow">

                       <ul>
                           <li>开通vip</li>
                           <li>个人设置</li>
                           <li @click="loginout()" style="cursor: pointer;">退出账户</li>
                       </ul>

                    </div>
                </li>

            <li class="menu-right"> <el-button icon="el-icon-message" circle type="primary"></el-button></li>
            </ul>

        </div>

        <div :style="background" class="bgd">
            <h1 style="color:white;float:left;font-size:36px;">{{this.course.cname}} &nbsp;117030801,02</h1>
            <div style="position:relative;left:-390px;top:80px;">
                <div class="inline">
                    <span>加课码:{{this.course.cflag}}</span>&emsp;
                    <span><a @click="jumptolist()">同学:{{this.mates}}</a></span>&emsp;&emsp;
                    <span><a @click="jumptoteascore()">成绩</a></span>
                </div>
            </div>
        </div>

        <div class="title">
            <a class="active">作业</a>
            <a >话题</a>
            <a >资料</a>
            <a >测试</a>
        </div>

        <div style="margin:auto;width:1224px;height:30px;margin-top:20px;">
            <el-button style="float:left;" plain type="primary" @click="addworkclick()">发布个人作业</el-button>
        </div>

        <!-- 作业div -->
        <div class="work" v-for="work in works" :key="work.wid">
            <div> 
                <el-dropdown style="float:right;margin-right:20px;">

                    <span class="el-dropdown-link" style="font-size:30px;">...</span>
                    <el-dropdown-menu slot="dropdown">                                       
                        <el-dropdown-item ><a @click="deletework(work.wid)">删除</a></el-dropdown-item>
                        <el-dropdown-item><a @click="updateclick(work.wid)">编辑</a></el-dropdown-item>
                    </el-dropdown-menu>

                </el-dropdown>
            </div>
            <div style="padding: 0 20px 0 40px;margin-top:30px;" >
                <span class="gerenzuoye">个人作业 {{work.date}}</span>
                <br><br>
                <h2 style="float:left;"><a @click="jumptocorrect(work.wid)">{{work.title}}</a></h2>
                <br><br>
                <span style="float:left;">{{work.content}}</span>
                <br><br>
                <span style="margin-right: 20px;color: #A0A0A0;">
                    <span style="float:left;">截止日期：{{work.deadline}}</span>
                   
                </span>
                
            </div>
        </div>

         <!-- 发布作业 -->
        <el-dialog title="发布作业" :visible.sync="addworkshow" style="width:1000px;margin:auto;">
            <el-form :model="newwork">

                <el-form-item label="作业名称:" style="margin:auto;">
                    <el-input v-model="newwork.title" style="width:300px;" placeholder="请输入作业名称"></el-input>
                </el-form-item>

                <el-form-item label="作业描述:" style="margin:auto;margin-top:10px;">
                    <el-input v-model="newwork.content" type="textarea" style="width:300px;" autosize placeholder="请输入内容" ></el-input>
                </el-form-item>

                <el-form-item label="发布时间:" style="margin:auto;margin-top:10px;">
                    <el-date-picker v-model="newwork.date" type="datetime" style="width:300px;"
                    value-format="yyyy-MM-dd HH:mm:ss"
                     placeholder="选择发布时间"></el-date-picker>
                </el-form-item>
                
                 <el-form-item label="截止日期:" style="margin:auto;margin-top:10px;">
                    <el-date-picker v-model="newwork.deadline" type="datetime" 
                    value-format="yyyy-MM-dd HH:mm:ss"
                    style="width:300px;" placeholder="选择截止日期"></el-date-picker>
                </el-form-item>

            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button @click="addworkshow = false">取 消</el-button>
                <el-button type="primary"  @click="addwork()">发布</el-button>
            </div>
        </el-dialog>


         <!-- 编辑作业 -->
        <el-dialog title="编辑作业" :visible.sync="changeshow" style="width:1000px;margin:auto;">
            <el-form :model="updatework">

                <el-form-item label="作业名称:" style="margin:auto;">
                    <el-input v-model="updatework.title" style="width:300px;" placeholder="请输入修改后的作业名称"></el-input>
                </el-form-item>

                <el-form-item label="作业描述:" style="margin:auto;margin-top:10px;">
                    <el-input v-model="updatework.content" type="textarea" style="width:300px;" autosize placeholder="请输入修改后的内容" ></el-input>
                </el-form-item>

                <el-form-item label="发布时间:" style="margin:auto;margin-top:10px;">
                    <el-date-picker v-model="updatework.date" type="datetime" style="width:300px;" placeholder="更改发布时间"></el-date-picker>
                </el-form-item>
                
                 <el-form-item label="截止日期:" style="margin:auto;margin-top:10px;">
                    <el-date-picker v-model="updatework.deadline" type="datetime" style="width:300px;" placeholder="更改截止日期"></el-date-picker>
                </el-form-item>

            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button @click="changeshow = false">取 消</el-button>
                <el-button type="primary"  @click="updatework1()">修改</el-button>
            </div>
        </el-dialog>

    </div>

</template>
<script>
export default {
    data() {
    return {
        background: {
          backgroundImage: "url(" + require("../image/bgd2.jpg") + ") ",
          backgroundPosition: "center center",
          backgroundRepeat: "no-repeat",
          backgroundSize: "cover",
        },
        addworkshow:false,
       usershow:false,
       changeshow:false,
       user:{},
       course:{},
       mates:'',
       works:{},
       newwork:{},
       updatework:{},
    }
  },    
  methods: {
    jumptoteascore() {
      this.$router.push({name: 'teascore', params: {cflag:this.course.cflag}})
    }, 

    jumptocorrect(wid) {
      this.$router.push({name: 'correctwork', params: {wid:wid,cflag:this.course.cflag}})
    },

    jumptolist() {
      this.$router.push({name: 'studentlist', params: {cflag:this.course.cflag}})
    },

      updateclick(wid){  
       
        this.changeshow=true;
         this.updatework.wid=wid;
    },

    updatework1() {
    
      this.$axios
        
        .post("api/tea/updatework", this.updatework)
        .then(res => {
            this.changeshow = false;
            this.getallwork(this.course.cflag);
            alert("修改成功"); this.$message({
            showClose: true,
            message: '修改成功',
            type: 'success'
        });
      })
      .catch(err => {
        this.$message.error('修改失败');
        console.log(err);
      });
    },

    returnclick()
      {
          this.$router.push('/teacher/'+this.user.uid+'/'+this.user.username);
      },

    transshow(){
       if(this.usershow)
            this.usershow=false;
        else
            this.usershow=true;
   },

    getcoursebyflag(cflag) {
      this.$axios
        .get('api/tea/getcoursebyflag?cflag='+ cflag)
        .then(res => {
            
          this.course=res.data;
        })
        .catch(err => {
          alert("查询失败");
          console.log(err);
        })
    },
    
    getcoursemates(cflag){
        this.$axios
        .get('api/tea/getcoursemates?cflag='+ cflag)
        .then(res => {
          this.mates=res.data;
        })
        .catch(err => {
         this.$message.error('查询同学失败');
          console.log(err);
        })
    },

    getallwork(cflag){
        this.$axios
        .get('api/tea/getallwork?cflag='+ cflag)
        .then(res => {
          this.works=res.data;
        })
        .catch(err => {
          alert("查询作业失败");
          console.log(err);
        })
    },

    addworkclick()
    {
        this.addworkshow=true;
    },

    addwork() {
      this.$axios
        .post("api/tea/addwork", this.newwork)
        .then(res => {

        this.getallwork(this.newwork.cflag);
        this.addworkshow=false;

            this.$message({
          showClose: true,
          message: '发布成功',
          type: 'success'
         });
          
      })
      .catch(err => {
        this.$message.error('发布失败');
        console.log(err);
      });
    },

    loginout(){
         this.$router.push('/login_page')
    },

    deletework(wid) {
      this.$axios
        .get('api/tea/deletework?wid='+ wid)
        .then(res => {
            this.getallwork(this.course.cflag);
             this.$message({
            showClose: true,
            message: '删除成功',
            type: 'success'
            });
        })
        .catch(err => {
          this.$message.error('删除失败');
          console.log(err);
        })
    },

  

  },
  mounted() {
   if (this.$route.params.id!=null) {
        this.user.username=this.$route.params.username;
         this.user.uid=this.$route.params.id;
         this.newwork.cflag=this.$route.params.cflag;
         this.getcoursebyflag(this.$route.params.cflag);
         this.getcoursemates(this.$route.params.cflag);
         this.getallwork(this.$route.params.cflag);
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
.bgd{
    width:1224px;
    height: 200px;
    margin:auto;
    padding: 48px 0 0 40px;
    margin-top:40px;
    box-sizing: border-box;
}
.inline{
    text-align: center;
    color: #fff;
    background: rgba(255,255,255,.4);
    border-radius: 2px;
    float: left;
    height: 24px;
    line-height: 24px;
    padding: 0 5px;
}
.title{
  
    width: 1224px;
    height: 72px;
    margin:auto;
    background: rgba(241,243,244,1);
    border-radius: 0 0 8px 8px;
}
.title a.active{
    border-bottom: 4px solid #2C58AB;
    border-left: 2px solid transparent;
    border-right: 2px solid transparent;
    font-size: 16px;
    font-weight: 500;
    color: rgba(59,61,69,1);

}
.title a{
    min-width: 80px;
    height: 67px;
    position: relative;
    padding-left: 10px;
    padding-right: 10px;
    margin-left: 20px;
    font-size: 16px;
    font-weight: 400;
    color: rgba(95,99,104,1);
    line-height: 70px;
    display: inline-block;
    float:left;
    cursor: pointer;    
}
a{
    cursor: pointer;
}
.work{
    position: relative;
    width: 1224px;
    height: 190px;
    margin:auto;
    border: 1px solid #E2E6ED;
    border-radius: 8px;
    
    margin-top:30px;
}
.gerenzuoye{
    color: #5F6368;
    background: #F1F3F4;
    padding: 3px 5px;
    border-radius: 2px;
    float:left;
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
</style>