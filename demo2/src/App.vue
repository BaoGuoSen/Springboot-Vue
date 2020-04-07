<template>
  <div id="app">
    <!-- <main-head class='header'></main-head>
    <left class='left'></left>
    <main-body class='main'></main-body> -->
    <router-view/>
  </div>
</template>

<script>
import mainHead from '@/view/mainHead.vue'
import mainBody from '@/view/mainBody.vue'
import left from '@/view/left.vue'
export default {
  name: 'App',
  components: {
    mainHead,
    mainBody,
    left
  },
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
