<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="board.controller.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/top.jsp" />
<jsp:include page="/boardList.jsp" />

<div class="container" style="width: 100%">


	<section>
		<hr color="red">
		<header>
			<div>
				<h3>${GA.subject}</h3>
			</div>
			<div class="row">
				<div class="col text-left">
					<span>작성자: ${GA.id}</span>
				</div>
				<div class="col text-right">
					<span>작성일: <fmt:formatDate value="${GA.date}"
							pattern="yyyy-MM-dd" /></span><span>조회수: ${GA.hits}</span>
				</div>
			</div>
		</header>
		<hr color="red">
		<div>
			<article>${GA.content}</article>
		</div>
	</section>
	<hr color="red">
	<div class="row">
		<div class="col-md-10">
			<button class="btn btn-primary btn-sm" onclick="">공감</button>
		</div>
		<!-- 게시글의 id와 세션의 id가 갖다면 -->
		<c:if test="${GA.id eq userid }">
			<div class="col-md-2" >
				<a href="editArticle.do?tn=${tn}&num=${num}" class="btn btn-info btn-sm" style="color: white" >글수정</a>
				<a href="delArticle.do?tn=${tn}&num=${num}&id=${GA.id}" 
				class="btn btn-danger btn-sm" style="color: white" >글삭제</a>
			</div>
		</c:if>
	</div>
	<hr color="red">

	
</div>
<!-- container  -->


