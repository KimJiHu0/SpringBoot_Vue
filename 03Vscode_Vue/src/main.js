import Vue from 'vue'
import App from './App.vue'
// routes 폴더 밑에있는 것을 router로 사용하기 위해 호출합니다.
import router from './routes'

new Vue({
    render: h => h(App),
    // 라우터를 등록합니다.
    router
}).$mount('#app')