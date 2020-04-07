<template>
  <div>
    <div class="top">
        <ul style="margin-top:5px;margin-left:0px;float:left;color:black;cursor:pointer;">
            <li class="menu-left" style=""><a @click="back()">返回</a> </li>
        </ul>

        <ul style="margin-top:0px;margin-right:0px;float:right;">
            <li class="menu-right"> 
            <el-button icon="el-icon-user-solid" circle @click="transshow()"></el-button>
            <div class="user" v-show="usershow">

              <ul style="cursor:pointer;">
                <li>开通vip</li>
                <li>个人设置</li>
                <li><a @click="loginout()"> 退出账户</a></li>
              </ul>
                      
            </div>
            </li>
            
            <li class="menu-right" style="margin-top:18px;"> 
              <el-badge :value="100" :max="99" class="item">
                <el-button icon="el-icon-message" circle type="primary"></el-button>
              </el-badge>
            </li>
              
        </ul>

    </div>

    <div class="mid">
      
      <div class="left">
          <ul>
            <li v-bind:class="{ active: scoreactive }">作业成绩</li>
          </ul>
      </div>

      <div class="right">

          <div class="title">
            <h3 class="fl" style="float:left;">平时作业</h3>
            <el-input v-model="checkname" class="fr" placeholder="姓名"  @keydown.enter.native="findbyname(checkname)" ></el-input>
          </div>
          
          <div class="list"> 
            
            <el-table :data="members"  stripe   height="550px">
              <el-table-column type="index" width="100"></el-table-column>
              <el-table-column prop="wid" label="作业序号" width="136"/>
              <el-table-column prop="title" label="作业题目" width="400"/>
              
              <el-table-column prop="score" label="分数" width="300"/>
            </el-table>
          </div>

      </div>

    </div>

  </div>
</template>
<script>
export default {
  data() {
    return {
      usershow:false,
      members: [],
      scoreactive:true,
      user:{},
      checkname:'',
    }
  },
  methods: {
    
    back(){
        this.$router.go(-1);
    },

    findbyname(checkname)
    {
         this.$axios
        .get('api/tea/findbyname?name='+checkname)
        .then(res => {
          this.members=res.data
      })
      .catch(err => {
        this.$message.error('查找失败');
        console.log(err);
      });
    },

    getscores(id){     
      this.$axios
        .get('api/stu/getscores?id='+id)
        .then(res => {
           this.members=res.data;
        })
        .catch(err => {
           this.$message.error('查找失败');
          console.log(err);
        })
    },

    loginout(){
         this.$router.push('/login_page')
    },

    transshow(){
       if(this.usershow)
            this.usershow=false;
        else
            this.usershow=true;
   },


  },
  mounted() {
       if (this.$route.params.id!=null) {   
        this.user.id=this.$route.params.id;
        this.getscores(this.$route.params.id);
         
    }
  }
}
</script>
<style scoped>
.add-box{
  float: right;
  margin-right: 200px;
}
.table-center {
  padding-left: 25%;
}
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
.mid{
    background: #FFF;
    border: 1px solid rgba(226,230,237,1);
    min-height: 600px;
    border-radius: 8px;
    position: relative;
    width:1224px;
    margin: auto;
    margin-top:30px;
}
.left{
    width: 286px;
    min-height: 300px;
    float:left;
    background: #FFF;
}
.right{
    width: 936px;
    border-left: 1px solid rgba(226,230,237,1);
    min-height: 600px;
    margin-left: -1px;
    float:left;
}
.left ul li{
  height: 55px;
    line-height: 55px;
    padding: 0 24px;
    cursor: pointer;
    font-weight: 500;
    color: rgba(59,61,69,1);
}
.left ul li.active{
    background: #32BAF0!important;
    color: #FFF;
}
.title{
    padding: 0 12px 0 25px;
    height: 55px;
    background: rgb(218, 227, 231);
    border-radius: 0 8px 0 0;
}
.fl{
    display: inline-block;
    height: 55px;
    line-height: 55px;
    font-weight: 500;
    color: rgba(59,61,69,1);
}
.fr{
    width:200px;
    margin-top:8px;
    height:30px;
    float:right;
}
</style>