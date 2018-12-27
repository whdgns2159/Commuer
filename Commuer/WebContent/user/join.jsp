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
	/* $('tr').firstchild().css('text-align','right'); */
});


	var idCheck=function(){
		var url='idCheck.jsp';
		win = window.open(url, 'idCheck','width=400, height=400, left=100, top=100]');
	}
	
	var nicknameCheck=function(){
		var url='nicknameCheck.jsp';
		win = window.open(url, 'idCheck','width=400, height=400, left=100, top=100]');
	}
	
</script>
<div class="container" align="center">
  <form action="../joinEnd.do" method="POST">
  <p></p>
	  <div class="row" >
	  	<div class="col-md-10">
		  	<table class="table table-borderless" id="userInfo" >
			    <thead>
			      <tr>
			        <th width="20%"><h2>정보입력</h2></th>
			        <th></th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			      	<td width="10%">아이디</td>
			        <td width="70%">
			       		<input type="text" class="form-control" id="userId" name="userId">
			       	</td>
			       	<td width="20%"><button class="btn btn-outline-primary" type="button" onclick="idCheck()">중복확인</button></td>
			      </tr>
			      <tr>
			        <td width="10%">닉네임</td>
			        <td>
				       <input type="text" class="form-control" id="userNick" name="userNick">
			        </td>
			        <td width="20%"> 
			       		<button class="btn btn-outline-primary" type="button" onclick="nicknameCheck()">중복확인</button>
			        </td>
			      </tr>
			      <tr>
			        <td width="10%">비밀번호</td>
			        <td>
			        	<input type="password" class="form-control" id="userPwd" name="userPwd">
			        </td>
			        <td width="20%"></td>
			      </tr>
			      <tr>
			        <td width="10%">비밀번호 확인</td>
			        <td>
			        	<input type="password" class="form-control" id="pwdCheck" name="pwdCheck">
			        </td>
			        <td width="20%"></td>
			      </tr>
			      <tr>
			        <td width="10%">이메일</td>
			        <td>
				        <input type="email" class="form-control" id="userEmail" name="userEmail">
			        </td>
			        <td width="20%">
			        	<button class="btn btn-outline-primary" type="button" onclick="emailCheck()">중복확인</button>
			        </td>
			      </tr>
			      <tr>
			        <td width="10%">연락처</td>
			        <td>
				        <input type="tel" class="form-control" id="userTel" name="userTel">
			        </td>
			        <td width="20%"> 
			        	<button class="btn btn-outline-primary" type="button" onclick="phCheck()">중복확인</button>
			        </td>
			      </tr>
			    </tbody>
			  </table>
		  </div>
	  </div>
	  <div class="row">
	  	<div class="col-md-12">
	  		<button class="btn btn-primary" type="submit">제출</button>
	  	</div>
	  </div>
  </form>
</div>