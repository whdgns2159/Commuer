<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
	String myctx=request.getContextPath();
%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link href="<%=myctx%>/css/style.css" rel="stylesheet" type="text/css">
	<meta charset="UTF-8">
<style>
#boardListNav>li>a{
		font-size: 1.3em;
		color : black;
		font-weight: bold;
	}
#boardListNav>li{
	padding-left: 10px;
	padding-right: 10px;
}
#cont{
			background-color:rgb(133,114,238);
	
}
a.navbar-brand{

	color: white;
}
a.nav-link{
	color: white;
}

#title{
	font-size:30pt;
}


</style>
</head>
<body>
<div class="container-fluid" id="cont">
	<nav class="navbar">
	  <div class="container">
		  <div class="navbar-header">
			  <a class="navbar-brand" href="<%=myctx %>/main.jsp" id="title">커뮤어</a>
		  </div>
		  <!-- form----------------------------------------------------------------- -->
	 	  <form class="navbar-form  navbar-left" action="/">
			  <div class="form-group">
				  <div class="input-group-sm">
				  	<input type="text" class="form-control form-control-sm" name="search">
				  </div>
			  </div>
			  <button type="submit" class="btn btn-default btn-sm">검색</button>
		  </form>
		
		  <!-- 로그인전 userinfo형태------------------------------------------------------------------- -->
		  <form class="navbar-form navbar-right" action="/">
			  <div class="form-group">
				  <div class="input-group-sm">
				  	<input type="text" class="form-control form-control-sm" name="id">
				  </div>
			  </div>
			  <div class="form-group">
				  <div class="input-group-sm">
				  	<input type="password" class="form-control form-control-sm" name="pwd">
				  </div>
			  </div>
			  <button type="submit" class="btn btn-default btn-sm">로그인</button>
		  </form>
		  
		  <div class="row"> 
		  	<a class="nav-link" href="<%=myctx%>/join.do">회원가입</a>
		  	<a class="nav-link" href="<%=myctx%>/findUser.jsp">아이디/비밀번호 찾기</a>
		  </div>
	  <!--------------------------------------------------------------------------------------- -->
	  </div>
	</nav>
</div>
</body>
</html>