<template>
    <div>
      <h1>게시판 수정하기</h1>
      <form @submit="updateData">
          <table border="1">
        <input type="hidden" v-model="boardno">
        <tr>
          <th>번호</th>
          <td>{{ boardno }}</td>
        </tr>
        <tr>
          <th>작성자</th>
          <td>
              <input type="text" v-model="boardwriter">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
              <input type="text" v-model="boardtitle">       
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea rows="10" cols="60" v-model="boardcontent"></textarea>
          </td>
        </tr>
        <tr>
          <th>작성날</th>
          <td>{{ $moment(boardregdate).format('YYYY-MM-DD') }}</td>
        </tr>
        <tr>
          <th colspan="2" align="right">
            <button>수정완료</button>
            <router-link tag="button" :to="{name: 'goDetail', params:{boardno: boardno}}">뒤로가기</router-link>
          </th>
        </tr>
      </table>
      </form>
  </div>
</template>

<script>
import axios from 'axios'

export default {
    computed: {
        boardno(){
            const boardno = this.$route.params.boardno
            return boardno
        }
    },
    data(){
        return {
            boardwriter: '',
            boardtitle: '',
            boardcontent: '',
            boardregdate: ''
        }
    },
    mounted() {
        const vm = this;
        axios.get("http://localhost:8787/detailData", {
            params: {
                boardno: vm.boardno
            }
        }).then(function(res){
            console.log(res.data)

            vm.boardwriter = res.data.boardwriter;
            vm.boardtitle = res.data.boardtitle;
            vm.boardcontent = res.data.boardcontent;
            vm.boardregdate = res.data.boardregdate;
        }).catch(function(err){
            console.log(" Error : " + err)
        })
    },
    methods: {
        updateData: function(){
            const vm = this;
            axios.get("http://localhost:8787/updateData",{
                params: {
                    boardno: vm.boardno,
                    boardwriter: vm.boardwriter,
                    boardtitle: vm.boardtitle,
                    boardcontent: vm.boardcontent
                }
            }).then(function(res){
                if(res.data.check == true){
                    location.href="/board/detail?boardno="+vm.boardno
                } else {
                    location.href="/board/update?boardno="+vm.boardno
                }
            }).catch(function(err){
                console.log("Error : " + err)
            })
        }
    }
}
</script>

<style>

</style>