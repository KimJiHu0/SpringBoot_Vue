// Vue를 사용하기 위해 호출
import Vue from 'vue';
// Router를 사용하기 위해 호출
import Router from 'vue-router';
// Section.vue를 사용하기 위해 호출
import Section from '../components/common/Section';
// List를 사용하기 위해 호출.
import List from '../components/board/List';

// Router을 사용하기 위해서 선언합니다.
Vue.use(Router);
export default new Router({
    // 라우터를 설정합니다.
    routes: [{
            // 경로가 "/" 이면,
            path: '/',
            // Section을 이름으로 설정
            // Section 컴포넌트를 등록합니다.
            component: Section
                // 그럼 "/" 경로로 들어오개 되면 router-view는 Section으로 보여집니다.
        },
        {
            // 경로가 /board/list로 들어오게되면
            path: '/board/list',
            // 이름은 List이고
            // 컴포넌트를 List로 등록합니다.
            component: List
                // 그럼 /board/list 로 들어오면 router-view는 List가 보여집니다.
        }
    ]
})