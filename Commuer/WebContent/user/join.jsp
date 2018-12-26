<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/top.jsp"/>

<script type="text/javascript">

$(function(){
	$('#userInfo tr:odd').css('background','rgb(244, 196, 253)');
	$('#userInfo').css({
		'font-size':'12pt',
		'font-weight':'bold'
	});
});

</script>
<div class="container" align="center">
  <form action="" >
  <p></p>
	  <div class="row" align="center">
	  	<div class="col-md-9">
		  	<table class="table" id="userInfo" >
			    <thead>
			      <tr>
			        <th><h2>정보입력</h2></th>
			        <th></th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td >아이디</td>
			        <td><input type="text" id="userId"></td>
			        <td><button class="btn btn-outline-primary" type="button" onclick="idCheck()">중복확인</button></td>
			      </tr>
			      <tr>
			        <td>닉네임</td>
			        <td><input type="text" id="userId"></td>
			        <td></td>
			      </tr>
			      <tr>
			        <td>비밀번호</td>
			        <td><input type="password" id="userPwd"></td>
			        <td></td>
			      </tr>
			      <tr>
			        <td>비밀번호 확인</td>
			        <td><input type="password" id="pwdCheck"></td>
			        <td></td>
			      </tr>
			      <tr>
			        <td>이메일</td>
			        <td><input type="email" id="userId"></td>
			        <td><button class="btn btn-outline-primary" type="button" onclick="emailCheck()">중복확인</button></td>
			      </tr>
			      <tr>
			        <td>연락처</td>
			        <td><input type="tel" id="userId"></td>
			        <td><button class="btn btn-outline-primary" type="button" onclick="phCheck()">중복확인</button></td>
			      </tr>
			    </tbody>
			  </table>
		  </div>
	  </div>
	  <div class="row">
	  	<div class="col-md-12">
	  		<button class="btn btn-primary">제출</button>
	  	</div>
	  </div>
  </form>
</div>