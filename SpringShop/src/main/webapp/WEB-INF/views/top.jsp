<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<% 
	String myctx=request.getContextPath();
%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="<%=myctx%>/css/index.css" rel="stylesheet" type="text/css">

<style type="text/css">
	.carousel-inner{
		width:100%;
		max-height:350px;
		margin:auto;
	}

</style>

</head>
<body>

	<div class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-ex-collapse">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=myctx%>/mall.do"><span>Brand</span></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="<%=myctx%>/mall.do">Home</a></li>
					
			<!-- requestScope.message
				sessionScope.loginUser
			 -->					
			<c:if test="${loginUser == null }">					
				<li><a href="<%=myctx%>/login.do">Login</a></li>
			</c:if>
			<c:if test="${loginUser != null }">
				<li class="bg-info"><a>${loginUser.userid}님 로그인 중...</a></li>
				<li><a href="<%=myctx%>/logout.do">Logout</a></li>
			</c:if>
					
					<li><a href="<%=myctx%>/user/cartList.do">Cart</a></li>
					<li><a href="<%=myctx%>/board/list">Board</a></li>
				</ul>
			</div>
		</div>
	</div>    
    