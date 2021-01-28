// Vue를 사용하기 위해 호출
import Vue from 'vue';
// Router를 사용하기 위해 호출
import Router from 'vue-router';
// Moment를 사용하기 위해 호출
import VueMoment from 'vue-moment'
// Section.vue를 사용하기 위해 호출
import Section from '../components/common/Section';
// List를 사용하기 위해 호출.
import List from '../components/board/List';
// Insert를 사용하기 위해 호출.
import Insert from '../components/board/Insert';
// Detail을 사용하기 위해 호출.
import Detail from '../components/board/Detail';
// Update를 사용하기 위해 호출.
import Update from '../components/board/Update';

// Router을 사용하기 위해서 선언합니다.
Vue.use(Router);
// Moment를 사용하기 위해서 선언합니다.
Vue.use(VueMoment);

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
        },
        {
            // 경로가 /board/insert로 들어오게 되면,
            path: '/board/insert',
            // Insert라는 컴포넌트를 App.vue에 있는 router-view에 보여지게 됩니다.
            component: Insert
        },
        {
            // List.vue에서 제목을 클릭하게 되면 name: goDetail이라는 이름으로 전달됩니다.
            // 이는 아래의 속성인 name: goDetail과 연결됩니다.
            // 그럼 지정한 path로 RL을 요청하게 됩니다.
            // /board/detail이라는 URL로 가는데 parameter를 함께 보내기 위해서
            // 마지막이 /:boardno 를 작성합니다.
            // 이 의미는 boardno라는 이름의 파라미터를 보내겠다는 의미입니다.
            // 이전 List.vue에서 params라는 속성을 이용해 boarno: list.boardno를 보내주었습니다.
            // 이제 Detail.vue 컴포넌트로 가보도록 하겠습니다.
            path: '/board/detail/:boardno',
            name: "goDetail",
            component: Detail
        },
        {
            path: '/board/update/:boardno',
            name: 'Update',
            component: Update
        }
    ]
})