<template>
  <div>
    <h1>게시판 리스트</h1>
    <table class="list" border="1">
        <col width="50">
        <col width="150">
        <col width="200">
        <col width="200">
        <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>날짜</th>
        </tr>
        <!-- 만일 글이 없을 때에는 작성된 글이 없습니다. 를 출력하고 싶은데, v-for과 v-if는 같이 쓸 수 없다네요. -->
        <tr v-for="list in lists" :key="list.boardno">
            <td>{{ list.boardno }}</td>
            <td>{{ list.boardwriter }}</td>
            <!-- <td><router-link to="/board/detail" >{{ list.boardtitle }}</router-link></td> -->
            <td>{{ list.boardtitle }}</td>
            <td>{{ $moment(list.boardregdate).format('YYYY-MM-DD') }}</td>
        </tr>
        <tr>
            <td colspan="4" align="right">
                <!-- router-link를 사용해서 URL을 이동할건데 TAG는 button으로 지정했습니다. -->
                <router-link tag="button" to="/board/insert">글작성</router-link>
            </td>
        </tr>
    </table>
  </div>
</template>

<script>

// axios를 사용하기 위해서 호출
import axios from 'axios';

export default {
    data(){
        return {
            lists: []
        }
    },
    // 라이프 사이클 단계로 el 속성에서 지정한 DOM 요소에 인스턴스가 부착된 후 호출되는 단계로
    // template 속성에 정의한 DOM에 접근할 수 있어 제어하는 로직을 수행하기 좋은 단계입니다.
    mounted(){
        // var vm = this; 로 사용하도 되지만 그렇지 않은 이유는
        // var는 전역변수를 의미하고 const는 지역변수를 의미하기 때문입니다.
        // 즉, var vm 으로 사용했다면 다른 곳에서 언제든지 사용이 가능하기 때문에
        // 이를 막기 위헤서 사용하지 않았고, 해당 메소드 내에서만 사용하기 위해서
        // const를 사용했습니다.
        // 최근 자바스크립트에서는 var보다는 let과 const 사용을 권장하고 있습니다.
        const vm = this;

        // axios로 비동기 통신을 진행합니다.
        // 주소는 http://localhost:8787/getData입니다.
        // 이는 Spring Boot에서 구동을 할 때 실행되는 URL입니다.
        // 또한 Spring Boot Controller에는 getData라는 URL을 받아서 GetMapping을 통해서
        // DB의 데이터를 JSON형태로 돌려냅니다.
        axios.get('http://localhost:8787/getData', {
            // 비동기 통신을 설정할 수 있는 option입니다.
            // JAVA에서 AJAX통신을 하는 것과 비슷하게 돌아갑니다.
            headers: {
                // 어디서든지 접근이 가능하도록 만들어주는데, 이는 별로 좋지 못한 방법입니다.
                // 해당 url만 작성을 해야할 경우가 생깁니다. 저는 그냥 테스트이기 때문에 접근을 허용합니다.
                'Access-Control-Allow-Origin': '*',
                // 받는 값의 타입과 utf를 지정합니다.
                'Content-Type': 'application/json; charset = utf-8'
            }
        }).then(function(res){
            // 비동기 통신이 성공한다면 then으로 들어오고, 
            console.log(res.data)
            // 위에서 선언된 lists라는 배열에 res.data를 담아줍니다.
            vm.lists = res.data
            
        }).catch(function(error){
            // 실패한다면 catch로 들어옵니다.
            console.log(" Error : " + error)
        })
    }
}
</script>

<style>
    .list{
        margin-left: 30%;
    }
</style>