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
                    <span><a @click="jumptolist()"> 同学:{{this.mates}}</a></span>&emsp;&emsp;
                    <span><a @click="jumptoscore()">成绩</a></span>
                </div>
            </div>
        </div>

        <div class="title">
            <a class="active">作业</a>
            <a >话题</a>
            <a >资料</a>
            <a >测试</a>
        </div>


        <!-- 作业div -->
        <div class="work" v-for="work in works" :key="work.wid">
            <div style="padding: 0 20px 0 40px;margin-top:30px;" >
                <span class="gerenzuoye">个人作业 {{work.date}}</span>
                <br><br>
                <h2 style="float:left;">{{work.title}}</h2>
                <br><br>
                <span style="float:left;">{{work.content}}</span>
                <br><br>
                <span style="margin-right: 20px;color: #A0A0A0;">
                    <span style="float:left;">截止日期：{{work.deadline}}</span>
                    <el-button type="primary" plain style="float:right;" @click="upworkclick(work.wid)">上传作业</el-button>
                </span>
                
            </div>
        </div>

         <!-- 上传作业 -->
       <el-dialog title="上传作业" :visible.sync="upworkshow" style="width:1000px;margin:auto;">
            <el-upload
                class="upload-demo"
                action="api/file/upload"

                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :on-success="handleAvatarSuccess"
                :before-remove="beforeRemove"
                multiple
                :limit="1"
                :on-exceed="handleExceed">
                <el-button size="small" type="primary">点击上传</el-button>
  
            </el-upload>

            <div slot="footer" class="dialog-footer">
                <el-button @click="upworkshow = false">取 消</el-button>
                <el-button type="primary"  @click="uploadwork()">上传</el-button>
            </div>
        </el-dialog>

    </div>

</template>
<script>
export default {
    data() {
    return {
        background: {
          backgroundImage: "url(" + require("../image/bgd.jpg") + ") ",
          backgroundPosition: "center center",
          backgroundRepeat: "no-repeat",
          backgroundSize: "cover",
        },
        upworkshow:false,
       usershow:false,
       user:{},
       course:{},
       mates:'',
       works:{},
       upwork:{},
        FileUrl: '',
        filelist:{},
        
    }
  },    
  methods: {
    jumptoscore() {
      this.$router.push({name: 'score', params: {id:this.user.uid}})
    },

    jumptolist() {
      this.$router.push({name: 'studentlist', params: {cflag:this.course.cflag}})
    },

    returnclick()
      {
          this.$router.push('/student/'+this.user.uid+'/'+this.user.username);
      },

    transshow(){
       if(this.usershow)
            this.usershow=false;
        else
            this.usershow=true;
   },

    upworkclick(wid)
    {
        this.upworkshow=true;
        this.upwork.id=this.user.uid;
        this.upwork.username=this.user.username;
        this.upwork.wid=wid;
    },

    getcoursebyflag(cflag) {
      this.$axios
        .get('api/stu/getcoursebyflag?cflag='+ cflag)
        .then(res => {            
          this.course=res.data;
        })
        .catch(err => {
          this.$message.error('查询失败');
          console.log(err);
        })
    },
    
    getcoursemates(cflag){
        this.$axios
        .get('api/stu/getcoursemates?cflag='+ cflag)
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
        .get('api/stu/getallwork?cflag='+ cflag)
        .then(res => {
          this.works=res.data;
        })
        .catch(err => {
          this.$message.error('查询作业失败');
          console.log(err);
        })
    },
     loginout(){
         this.$router.push('/login_page')
    },

     handleAvatarSuccess(res, file) {
        this.FileUrl = res[0];
        console.log("?1")
         console.log(res)
        console.log(this.FileUrl)
        this.upwork.fileurl=this.FileUrl;
    },
    uploadwork() {
      this.$axios
        .post("api/stu/uploadwork", this.upwork)
        .then(res => {
            this.upworkshow=false;
          this.$message({
          showClose: true,
          message: '上传成功',
          type: 'success'
        });
      })
      .catch(err => {
        this.$message.error('上传失败');
        console.log(err);
      });
    },
    handleRemove(file, fileList) {
        console.log(file, fileList);
    },
    handlePreview(file) {
        
        console.log(file);
    },
    handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
    }

  },
  mounted() {
   if (this.$route.params.id!=null) {
        this.user.username=this.$route.params.username;
         this.user.uid=this.$route.params.id;
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

</style>