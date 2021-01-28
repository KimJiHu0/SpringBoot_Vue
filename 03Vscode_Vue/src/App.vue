<template>
  <div id="app">
    <Header></Header>
    <!-- router-view는 router에서 해당 URL에 따라서 보여질 화면을 다르게하기 위해 선언했습니다. -->
    <router-view></router-view>
    <Footer></Footer>
  </div>
</template>

<script>
// Header와 Footer를 사용하기 위해 import from 으로 호출합니다.
import Header from './components/common/Header'
import Footer from './components/common/Footer'

export default {
  // 위에서 호출한 것들을 모두 컴포넌트로 등록합니다.
  components: {
    Header: Header,
    Footer: Footer
  }
}
</script>

<style>
html,body{padding:0; margin:0;}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin:0; padding:0;
}
</style>
