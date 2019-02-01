<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/top"/>
<script type="text/javascript">

	var win=null;
	
	function checkId(uid){
		var len=uid.length;
		if(len<4||len>8){
			$('#msgId').text('*아이디는 4자 이상 8자 이내여야 해요').css('color','red');
			return;
		}else{
			$('#msgId').text("");
			//Ajax요청 보내서 아이디 중복체크 예정
			
		}
	}
	
	function idCheck(){
		var url='idCheck.jsp';
		//if(win==null){
			win = window.open(url,'idCheck',
					'width=400, height=400, left=100, top=100');		
		//}		
	}//-----------------------

	function check(){
		if(!mf.name.value){
			alert('이름을 입력하세요');
			mf.name.focus();
			return false;
		}
		if(!mf.userid.value){
			alert('아이디를 입력하세요');
			mf.userid.focus();
			return false;
		}
		if(!mf.pwd.value){
			alert('비밀번호를 입력하세요');
			mf.pwd.focus();
			return false;
		}
		if(mf.pwd.value != mf.pwd2.value){
			alert('비밀번호가 달라요');
			mf.pwd2.select();
			return false;
		}
		if(!mf.hp1.value||!mf.hp2.value||!mf.hp3.value){
			alert('연락처를 모두 입력하세요');
			mf.hp1.focus();
			return false;
		}
		if(!mf.addr1.value|| !mf.addr2.value){
			alert('주소를 모두 입력하세요');
			mf.addr2.focus();
			return false;
		}
		//아이디 형식체크, 비번 체크, 이메일 체크...
	
		return true;
	}
</script>
<div class="row">
<div class="text-center col-md-6 col-md-offset-3">
	<h1>Member Join</h1>
	<form name="mf" action="join" method="POST"
	 onsubmit="return check()">
		<table class="table">
			<tr>
				<th width="20%">이름</th>
				<td width="80%">
				<input type="text" name="name"
				 placeholder="이름을 입력하세요"
				  class="form-control">				
				</td>
			</tr>
			<tr>
				<th width="20%">
				아이디
				</th>
				<td width="80%">
				<div class="col-md-6" style="padding-left:0px">
					<input type="text" name="userid"
					 placeholder="아이디를 입력하세요"
					  class="form-control"
					onkeyup="checkId(this.value)">
					<span class="text-info"  id="msgId">
					*아이디는 4자 이상 영문자, 숫자만 가능</span>
   	 		 	</div>				 
				 <div class="col-md-2" style="padding-left:0px">
				 	  <button type="button"
				 	   onclick="idCheck()" class="btn btn-success">아이디 중복체크</button>
				 </div>
				  
				</td>
			</tr>
			<tr>
				<th width="20%">비밀번호</th>
				<td width="80%">
				<input type="password" name="pwd"
				 placeholder="비밀번호를 입력하세요"
				  class="form-control">
				  <span class="text-info">
				  *비밀번호는 4자이상 8자 이내여야 해요</span>
				</td>
			</tr>
			<tr>
				<th width="20%">비밀번호 확인</th>
				<td width="80%">
				<input type="password" name="pwd2"
				 placeholder="비밀번호를 다시 입력하세요"
				  class="form-control">
				</td>
			</tr>
			<tr>
				<th width="20%">이메일</th>
				<td width="80%">
				<input type="email" name="email"
				 placeholder="이메일을 입력하세요"
				  class="form-control">
				</td>
			</tr>
			<tr>
				<th width="20%">연락처</th>
				<td width="80%">
				<div class="col-md-2" style="padding-left:0px">
				<input type="text" name="hp1"
				maxlength="3"
				 class="form-control"
				placeholder="HP1">
				</div>
				
				<div class="col-md-2"  style="padding-left:0px">
				<input type="text" name="hp2"
				maxlength="4"
				 class="form-control"
				placeholder="HP2">
				</div>
				<div class="col-md-2"  style="padding-left:0px">
				<input type="text" name="hp3"
				maxlength="4"
				 class="form-control"
				placeholder="HP3">
				</div>
				
				</td>
			</tr>
			<tr>
				<th width="20%">
				우편번호
				</th>
				<td width="80%">
				<div class="col-md-6" style="padding-left:0px">
					<input type="text" name="zipcode"
					maxlength="5" readonly
					 placeholder="우편번호를 입력하세요"
					  class="form-control">
   	 		 	</div>				 
				 <div class="col-md-2" style="padding-left:0px">
				 	  <button type="button"
				 	   onclick="" class="btn btn-success">
				 	   우편번호 찾기</button>
				 </div>
				  
				</td>
			</tr>
			<tr>
				<th width="20%">주소</th>
				<td width="80%">
				<input type="text" name="addr1"
				placeholder="주소1을 입력하세요" 
				class="form-control">
				<p style="margin:10px"></p>
				<input type="text" name="addr2"
				placeholder="주소2를 입력하세요" 
				class="form-control">				
				</td>
			</tr>
			<tr>				
				<td colspan="2" class="text-center">
				<button type="submit" class="btn btn-info">회원가입</button>
				<button type="reset" class="btn btn-warning">다시쓰기</button>
				</td>
			</tr>
		</table>
	</form>
	
</div>
</div>
<c:import url="/foot"/>