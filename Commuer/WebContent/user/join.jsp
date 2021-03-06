<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/top.jsp"/>
<jsp:include page="/boardList.jsp"/>
<div class="container" align="center">
  <form name="userJoinF" action="joinEnd.do" method="POST">
  <p></p>
	  <div class="row" >
	  	<div class="col-md-8 col-md-offset-2">
		  	<table class="table table-borderless" id="userInfo" >
			    <thead>
			      <tr>
			        <th width="20%"><h2>정보입력</h2></th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			      	<td width="10%">아이디</td>
			        <td width="70%">
			       		<input type="text" class="form-control" id="userId" name="userId" maxlength="20" >
			       	</td>
			       	<td width="20%"><button class="btn btn-outline-primary" type="button" onclick="idCheck()">중복확인</button></td>
			      </tr>
			      <tr>
			        <td width="10%">닉네임</td>
			        <td width="70%">
				       <input type="text" class="form-control" id="userNick" name="userNick" maxlength="29" >
			        </td>
			        <td width="20%"> 
			       		<button class="btn btn-outline-primary" type="button" onclick="nicknameCheck()">중복확인</button>
			        </td>
			      </tr>
			      <tr>
			        <td width="10%">비밀번호</td>
			        <td width="70%">
			        	<input type="password" class="form-control" id="userPwd" name="userPwd" maxlength="29">
			        </td>
			        <td width="20%"></td>
			      </tr>
			      <tr>
			        <td width="10%">비밀번호 확인</td>
			        <td width="70%">
			        	<input type="password" class="form-control" id="pwdCheck" name="pwdCheck" maxlength="29">
			        </td>
			        <td width="20%"></td>
			      </tr>
			      <tr>
			        <td width="10%">이메일</td>
			        <td width="70%">
				        <input type="email" class="form-control" id="userEmail" name="userEmail" maxlength="119">
			        </td>
			        <td width="20%">
			        	<button class="btn btn-outline-primary" type="button" onclick="emailCheck()">중복확인</button>
			        </td>
			      </tr>
			      <tr>
			        <td width="10%">연락처</td>
			        <td width="70%">
				        <input type="tel" class="form-control" id="userTel" name="userTel" maxlength="11">
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
	  		<button class="btn btn-primary" type="button" onclick="joinSub()">제출</button>
	  	</div>
	  </div>
  </form>
</div>