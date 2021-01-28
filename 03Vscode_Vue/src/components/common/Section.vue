<template>
  <!-- 기존에 App.vue에 존재하던 모든 것을을 옮겨왔습니다. -->
  <div id="app">
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>
    <ul>
      <li><a href="">Core Docs</a></li>
      <li><a href="">Forum</a></li>
      <li><a href="">Community Chat</a></li>
      <li><a href="">Twitter</a></li>
    </ul>
    <h2>Ecosystem</h2>
    <ul>
      <li><a href="">vue-router</a></li>
      <li><a href="">vuex</a></li>
      <li><a href="">vue-loader</a></li>
      <li><a href="">awesome-vue</a></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      msg: 'Vue.js의 세계에 오신 것을 환영합니다.'
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
