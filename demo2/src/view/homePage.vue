<template>
  <el-container style="height:100%">
    <el-aside width="200px" class="left">
      <left></left>
    </el-aside>
    <el-container>
      <el-header height="80px" class="header">
        <mainHead></mainHead>
      </el-header>
      <el-main class="main">
        <main-body></main-body>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import mainHead from '@/view/mainHead.vue'
import mainBody from '@/view/mainBody.vue'
import left from '@/view/left.vue'
export default {
  name: 'homePage',
  components: {
    mainHead,
    mainBody,
    left
  },
  data () {
    return {
    }
  }
}
</script>

<style>
* {
  margin:0;
  padding:0;
}
html, body {
  height: 100%
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height:100%;
  width:100%;
}
.left {
  height: 100%;
  background: #e7e7e7;
}
.header {
  height: 10%;
  background: #e9e9e9
}
.main {
  height:90%;
  background: #f9f9f9
}

</style>