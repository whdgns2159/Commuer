<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/top"/>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<h1 class="text-center text-primary">글 ${mode }</h1>
			<form action="passwd" name="f" method="POST">
				<input type="hidden" name="idx" value="${idx }">
				<input type="hidden" name="mode" value="${mode }">
				<h3>글 비밀번호: </h3>
				<input type="password" name="pwd" class="form-control" placeholder="PASSWORD">
				<button type="button" onclick="send()" class="btn btn-primary">확인</button>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
<!--

//-->
	function send(){
		if(!f.pwd.value){
			alert("비밀번호를 입력하세요");
			f.pwd.focus();
			return;
		}
		
		<c:if test="${mode eq 'Edit'}">
			f.action="edit";
			f.submit();
		</c:if>
		
		<c:if test="${mode eq 'Delete'}">
		f.action="delete";
		f.submit();
		</c:if>
	}
</script>
<c:import url="/foot"/>