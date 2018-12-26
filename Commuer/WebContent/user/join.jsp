<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/top.jsp"/>

<script type="text/javascript">

$(function(){
	/* $('#userInfo tr:odd').css('background','rgb(133, 114, 238)'); */
	$('#userInfo').css({
		'font-size':'12pt',
		'font-weight':'bold'
		
	});
	$('.btn-outline-primary').css('color','darkviolet');
});

</script>
<div class="container" align="center">
  <form action="" >
  <p></p>
	  <div class="row" >
	  	<div class="col-md-12">
		  	<table class="table table-borderless" id="userInfo" >
			    <thead>
			      <tr>
			        <th><h2>정보입력</h2></th>
			        <th></th>
			        
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			      	<td>아이디</td>
			        <td>
			          <div class="row">
				       		<div class="col"><input type="text" class="form-control" id="userId"></div>
				       		<div class="col"><button class="btn btn-outline-primary" type="button" onclick="idCheck()">중복확인</button></div>
				      </div>
			       	</td>
			      </tr>
			      <tr>
			        <td>닉네임</td>
			        <td>
				        <input type="text" id="userId">
				        <button class="btn btn-outline-primary" type="button" onclick="nicknameCheck()">중복확인</button>
			        </td>
			      </tr>
			      <tr>
			        <td>비밀번호</td>
			        <td>
			        	<input type="password" id="userPwd">
			        </td>
			      </tr>
			      <tr>
			        <td>비밀번호 확인</td>
			        <td>
			        	<input type="password" id="pwdCheck">
			        </td>
			      </tr>
			      <tr>
			        <td>이메일</td>
			        <td>
				        <input type="email" id="userId">
				        <button class="btn btn-outline-primary" type="button" onclick="emailCheck()">중복확인</button>
			        </td>
			      </tr>
			      <tr>
			        <td>연락처</td>
			        <td>
				        <input type="tel" id="userId">
				        <button class="btn btn-outline-primary" type="button" onclick="phCheck()">중복확인</button>
			        </td>
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