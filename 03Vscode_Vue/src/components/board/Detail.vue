<template>
  <div>
      <h1>게시판 자세히보기</h1>
      <p>전달받은 파람 : {{ boardno }}</p>
      <table border="1">
        <tr>
          <th>번호</th>
          <td>{{ boardno }}</td>
        </tr>
        <tr>
          <th>작성자</th>
          <td>{{ boardwriter }}</td>
        </tr>
        <tr>
          <th>제목</th>
          <td>{{ boardtitle }}</td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea readonly="readonly" rows="10" cols="60" v-model="boardcontent"></textarea>
          </td>
        </tr>
        <tr>
          <th>작성날</th>
          <td>{{ $moment(boardregdate).format('YYYY-MM-DD') }}</td>
        </tr>
        <tr>
          <th colspan="2" align="right">
            <router-link tag="button" :to="{name: 'Update', params:{boardno: boardno}}">수정하기</router-link>
            <button @click="deleteData">삭제하기</button>
            <router-link to="/board/list" tag="button">뒤로가기</router-link>
          </th>
        </tr>
      </table>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data(){
    return{
      boardwriter: '',
      boardtitle: '',
      boardcontent: '',
      boardregdate: ''
    }
  },
  mounted: function(){
    const vm = this;
    axios.get("http://localhost:8787/detailData", {
      // 넘겨줄 파라미터 설정
      params: {
        boardno: vm.boardno
      }
    }).then(function(res){
      console.log(res.data);

      // 어차피 boardno는 파라미터로 전달받은 것이 있기 때문에 굳이 설정해주지 않았습니다.
      // 위해서 computed라는 속성을 이용해서 boardno라는 변수에 값을 담았기 떄문에,
      // 출력하는데에 지장이 없습니다.
      // 그래서 나머지인 작성자, 제목, 내용, 날짜만 담아서
      // 위에서 선언한 data()안에 변수들에게 값을 담아주었습니다.
      vm.boardwriter = res.data.boardwriter;
      vm.boardtitle = res.data.boardtitle;
      vm.boardcontent = res.data.boardcontent;
      vm.boardregdate = res.data.boardregdate;
    }).catch(function(err){
      console.log(" Error : " + err)
    })
  },
  methods: {
    deleteData: function(){
      const vm = this;

      axios.get("http://localhost:8787/deleteData", {
        params: {
          boardno: vm.boardno
        }
      }).then(function(res){
        if(res.data.check == true){
          location.href="/"
        }
      }).catch(function(err){
        console.log(" Error : " + err)
      })
    }
  },
  // JavaScript에서 window.onload 속성과 비슷하다고 생각하면 좋을 것 같습니다.
  // methods 속성은 메소드를 정의하는 함수이지만, computed는 영어 단어 뜻 그대로
  // " 이미 계산된 것 "을 의미합니다.
  // 이 페이지가 켜지지마자 아래와 같이 출력되는 것입니다.
  computed: {
    boardno(){
      // index.js에서는 /board/detail 이라는 URL과 /:boardno 를 통해서 boardno라는 이름으로
      // 해당 글에 대한 번호를 함께 보내주었습니다.
      // 그럼 {boardno: 11} 이런 식으로 params가 전달되게 되죠.
      // 전체적으로 보자면 /board/detail?boardno=11 이라는 값을 전달한 것입니다.
      // route라는 속성을 이용해서 이전 페이지에서 전달한 params 중에서 boardno를 추출합니다.
      // 만약 11번 글을 클릭했다면 그의 boardno인 11이라는 값을 return하게 됩니다.
      // HTML코드에서 {{ boarno }}를 작성한 순간 11이라는 값을 추출할 수 있습니다.

      // 만일 return this.$route.params 까지만 작성했다면 {boardno:11} 이라는 값을 그대로 출력하게 되고
      // 여기서 정말 boardno에 대한 값만 원한다면 return this.$route.params.boardno 라느 작성한다면
      // 11이라는 값만 추출할 수 있습니다.

      // router와 route의 차이를 알아보도록 하겠습니다.
      // router는 우리가 index.js에서 실제로 선언한 path, 혹은 mode: history 등등의 선언값들을 의미합니다.
      // 즉, index.js에서 new Router({})를 통해 선언한 설정, 속성을 의미합니다.
      // route는 현재 들어온 router. 즉, 방금 요청된 URL에서 어떤 path 속성과 어떤 parameter가 전달됐는지
      // 등에 대한 현재 URL에 대한 값들을 의미합니다.
      const boardno = this.$route.params.boardno;
      return boardno
    }
  }
}
</script>

<style>

</style>