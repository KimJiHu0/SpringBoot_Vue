<template>
  <div>
      <h1>글작성</h1>
      
      <table class="boardinsert" border="1">
          <tr>
              <th>작성자</th>
              <td>
                  <input class="content" type="text" v-model="boardwriter">
              </td>
          </tr>
          <tr>
              <th>제목</th>
              <td>
                  <input class="content" type="text" v-model="boardtitle">
              </td>
          </tr>
          <tr>
              <th>내용</th>
              <td>
                  <textarea class="boardcontent" rows="10" cols="60" v-model="boardcontent"></textarea>
              </td>
          </tr>
          <tr>
              <td colspan="3" align="right">
                  <button @click="insertData">글작성</button>
                  <!-- router-link 속성 중 tag속성은 해당 태그의 종류를 바꿔줍니다. -->
                  <router-link tag="button" to="/board/list">돌아가기</router-link>
              </td>
          </tr>
      </table>
  </div>
</template>

<script>
// axios를 사용하기 위한 호출입니다.
import axios from 'axios'

export default {
    data(){
        return {
            boardwriter: '',
            boardtitle: '',
            boardcontent: ''
        }
    },
    methods: {
        insertData: function(){
            const vm = this;
            console.log(vm.boardwriter);
            console.log(vm.boardtitle);
            console.log(vm.boardcontent);
            // 작성자, 제목, 내용을 하나라도 입력하지 않으면 비동기 통신이 불가능합니다.
            if(vm.boardwriter == '' || vm.boardtitle == '' || vm.boardcontent == ''){
                alert("작성자, 제목, 내용을 모두 입력하셔야 합니다.");
            } else {
                // 비동기 통신을 실행합니다.
                // 연결할 url은 http://localhost:8787/insertData 입니다.
                axios.get('http://localhost:8787/insertData', {
                    headers: {
                        // 위의 URL에 접근을 허용합니다.
                        'Access-Control-Allow-Origin': '*',
                        'Content-Type': 'application/json; charset = utf-8'
                    },
                    // 보내는 파라미터를 정의합니다.
                    params: {
                        // boardwriter, boardtitle, boardcontent라는 변수에
                        // v-model로 값을 넣은 것을 담아줍니다.
                        boardwriter: vm.boardwriter,
                        boardtitle: vm.boardtitle,
                        // 비동기 통신 시에 특수문자가 들어가게되면 인코딩을 해줍니다.
                        boardcontent: encodeURIComponent(vm.boardcontent)
                    }
                // 비동기 통신에 성공했습니다.
                }).then(function(res){
                    // Back-end에서 Map에 check라는 이름으로 값을 담았습니다.
                    // insert에 성공했다면 true, 실패했다면 false입니다.
                    console.log(res.data.check);
                    // 만일 res의 data중 check의 값이 true라면 성공했다는 의미입니다.
                    if(res.data.check == true){
                        alert("글이 작성되었습니다.");
                        // 글 작성에 성공하고, 게시판으로 돌아가는게 문제입니다.
                        // 아직 해결하지 못했습니다.
                    // 그게 아닐 경우엔 실패한 경우입니다.
                    } else {
                        alert("글 작성에 실패했습니다.");
                    }
                }).catch(function(err){
                    console.log("Error : " + err)
                })
            }
        }
    }
}
</script>

<style>
    .content{
        width: 95%;
        border: none;
    }
    .boardcontent{
        width: 99%;
        resize: none;
    }
    .boardinsert{
        width: 700px;
        margin-left: 28%;
    }
</style>