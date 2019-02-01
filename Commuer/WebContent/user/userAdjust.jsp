<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/top.jsp"/>
<jsp:include page="/boardList.jsp"/>


<div class="container" align="center"> 
	<form id="userAdjustF" name="userAdjustF" action="userAdjust.do" method="POST" >
  <p></p>
	<div class="row" >
	  	<div class="col-md-8 col-md-offset-2">
		  	<table class="table table-borderless" id="userAdjust" >
			    <thead id="uaThead">
			      <tr>
			        <th width="20%" colspan="3"><h2>${currentUInfo.id} 님의 회원정보</h2></th>
			      </tr>
			    </thead>
			    <tbody id="uaTbody">
			      <tr>
			        <td width="10%">닉네임</td>
			        <td>
				       <input type="text" class="form-control" id="userNick" name="userNick" maxlength="29" value="${currentUInfo.nickname}">
			        </td>
			        <td width="20%"> 
			       		<button class="btn btn-outline-primary" type="button" onclick="nicknameCheck()">중복확인</button>
			        </td>
			      </tr>
			      <tr>
			        <td width="10%">비밀번호</td>
			        <td>
			        	<input type="password" class="form-control" id="userPwd" name="userPwd" maxlength="29">
			        </td>
			        <td width="20%"></td>
			      </tr>
			      <tr>
			        <td width="10%">비밀번호 확인</td>
			        <td>
			        	<input type="password" class="form-control" id="pwdCheck" name="pwdCheck" maxlength="29"> 
			        </td>
			        <td width="20%"></td>
			      </tr>
			      <tr>
			        <td width="10%">이메일</td>
			        <td>
				        <input type="email" class="form-control" id="userEmail" name="userEmail" maxlength="119" value="${currentUInfo.email}">
			        </td>
			        <td width="20%">
			        	<button class="btn btn-outline-primary" type="button" onclick="emailCheck()">중복확인</button>
			        </td>
			      </tr>
			      <tr>
			        <td width="10%">연락처</td>
			        <td>
				        <input type="tel" class="form-control" id="userTel" name="userTel" maxlength="11" value="${currentUInfo.tel}">
			        </td>
			        <td width="20%"> 
			        	<button class="btn btn-outline-primary" type="button" onclick="phCheck()">중복확인</button>
			        </td>
			      </tr>
			    </tbody>
			  </table>
	</div>
	  </div>
	 <p></p>
	  		<button class="btn btn-primary" type="button" onclick="adjustSub()">제출</button>
  </form>
</div>
<script type="text/javascript">
	
	var nickcheck=0;

	var adjustSub=function(){
		if(!userAdjustF.userNick.value){
			alert('닉네임을 입력해주세요');
			return;
		}
		if(!userAdjustF.userPwd.value){
			alert('비밀번호를 입력해주세요');
			return;
		}
		if(!userAdjustF.pwdCheck.value){
			alert('비밀번호를 확인해주세요');
			return;
		}
		if(!userAdjustF.userEmail.value){
			alert('이메일을 입력해주세요');
			return;
		}
		if(!userAdjustF.userTel.value){
			alert('연락처을 입력해주세요');
			return;
		}
		userAdjustF.submit();
	}
	
	var nicknameCheck=function(){
		var usernick=$("#userNick").val();
		if(usernick==null){
			alert('닉네임을 입력해주세요');
			return;
		}
		
	}

</script>
