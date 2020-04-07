<template>
  <el-form ref="studentForm" :model="studentForm" label-width="80px" style="width:300px;margin-left:40%">
    <el-form-item label="姓名">
      <el-input v-model="studentForm.name" style="width:240px;" ></el-input>
    </el-form-item>
    <el-form-item label="性别">
      <el-select v-model="studentForm.sex" placeholder="请选性别" style="width:240px;">
        <el-option label="男" value="男"></el-option>
        <el-option label="女" value="女"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="年龄">
      <el-input-number v-model="studentForm.age" style="width:240px;" ></el-input-number>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submit">提交</el-button>
      <el-button @click="jumpToList">返回</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
export default {
    data() {
    return {
      type: '',
      studentForm: {},
    }
  },    
  methods: {
    submit() {
      if(this.studentForm.uId != undefined){
        this.editStudent()
      } else {
        this.addStudent()
      }
    },
    addStudent() {
      this.$axios
        .post("api/test/addStudent", this.studentForm)
        .then(res => {
          alert("添加成功");
          this.studentForm = {}
          this.jumpToList()
        //   $router.go('/demo3/studentList')
      })
      .catch(err => {
        alert("添加失败");
        console.log(err);
      });
    },
    editStudent() {
      this.$axios
        .post('api/test/editStudent', this.studentForm)
        .then(res => {
          alert("修改成功");
          this.studentForm = {}
          this.jumpToList()
        })
        .catch(err => {
          alert("修改失败");
          console.log(err);
        })
    },
    getStudentById(id) {
      this.$axios
        .get('api/test/getStudentById?uId='+ id)
        .then(res => {
          this.studentForm = res.data
        })
        .catch(err => {
          alert("查询失败");
          console.log(err);
        })
    },
    jumpToList() {
      this.$router.push('/student/studentList')
    }
  },
  mounted() {
    if (this.$route.params.type == 'edit') {
      this.type = 'edit'
      this.getStudentById(this.$route.params.id)
    } else { 
      this.type = 'add'
    }
  }
}
</script>
<style scoped>
.add-box{
    padding-left:20px;
    padding-top:20px;
    display: inline;
}
</style>