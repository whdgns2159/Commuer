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
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link href="<%=myctx%>/css/style.css" rel="stylesheet" type="text/css">
	<link href="<%=myctx%>/css/top.css" rel="stylesheet" type="text/css">
	<meta charset="UTF-8">


<script type="text/javascript" src="<%=myctx%>/js/userLogin.js"></script>
<script type="text/javascript" src="<%=myctx%>/js/userJoin.js"></script>

</head>
<body>
<div class="container-fluid" id="cont">
	<nav class="navbar">
	  <div class="container">
		  <div class="navbar-header mr-auto" >
			  <a class="navbar-brand" href="<%=myctx %>/main.do" id="title">커뮤어</a>
		  </div>
		  <!-- form----------------------------------------------------------------- -->
	 	 <!--  <form class="navbar-form  navbar-left" method="get" action="board.do">
			  <div class="form-group">
				  <div class="input-group-sm">
				  	<input name="searchResult" type="text" class="form-control form-control-sm" name="search">
				  </div>
			  </div>
			  <button type="submit" class="btn btn-default btn-sm">검색</button>
		  </form>
		 -->
		  <!-- 로그인전 ------------------------------------------------------------------------ -->
		  <c:if test="${loginUser eq null}">
		  
		  <form class="navbar-form navbar-right ml-auto" name="loginF" action="<%=myctx %>/login.do">
			  <div class="row"> 
			  <div class="form-group">
				  <div class="input-group-sm">
				  	<input type="text" class="form-control form-control-sm" name="id" placeholder="id">
				  </div>
			  </div>
			  <div class="form-group">
				  <div class="input-group-sm">
				  	<input type="password" class="form-control form-control-sm" name="pwd" placeholder="password">
				  </div>
			  </div>
			  <button type="button" class="btn btn-default btn-sm" onclick="loginCheck()">로그인</button>
		  
		  	<a class="nav-link" href="<%=myctx%>/join.do">회원가입</a>
		  	<a class="nav-link" href="#" onclick="findUser()">아이디/비밀번호 찾기</a>
		  </div>
		  </form>
		  </c:if>
	  <!---------------------------------------------------------------------------------------- -->
	  <!-- 로그인 후 userinfo상태-------------------------------------------------------------- -->
	  	  <c:if test="${loginUser ne null}">
	  	  	<div id="afterLogin">
	  	  		<ul class="ConnectedUser">
		  	  		<li><strong>${loginUser.nickname }</strong></li>
		  	  		<li><a  href="<%=myctx %>/logout.do">로그아웃</a></li>
		  	  		<li><a >내가쓴글</a></li>
		  	  		<li><a  href="<%=myctx %>/topUserAdjust.do">회원수정</a></li>
	  	  		</ul>
	  	  	</div>
	  	  </c:if>
	  <!-- ------------------------------------------------------------------------------------- -->
	  </div>
	</nav>
</div>
</body>
<script type="text/javascript">
	var findUser=function(){
		window.open("");
		return;
	}

</script>
</html>