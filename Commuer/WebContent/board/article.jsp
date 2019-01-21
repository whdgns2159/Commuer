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
				<a href="#" class="btn btn-info btn-sm" style="color: white" >글수정</a>
				<a href="delArticle.do?tn=${tn}&num=${num}&id=${GA.id}" 
				class="btn btn-danger btn-sm" style="color: white" >글삭제</a>
			</div>
		</c:if>
	</div>
	<hr color="red">
	<section>
		<div class="container-fluid">
			<div>
				<span>댓글수: ${totalReply}</span>
			</div>
			
			<ul id="reply" style="list-style: none; padding-left: 0px">
				<!-- 리플이 있을때 -->
				<c:if test="${reply ne null}">
					<c:forEach var="i" items="${reply}">
						<li>
							<div id="repleInfo">
								<span>${i.id}</span> <span> <fmt:formatDate
										value="${i.wdate}" pattern="MM-dd" />
								</span>
							</div>
							<div>
								<span>${i.content}</span>
							</div>
							<hr color="red">
						</li>
					</c:forEach>
				</c:if>
				<!-- 리플이 없을때 -->
				<c:if test="${reply eq null }">
					<li></li>
				</c:if>
			</ul>

		</div>
	</section>
	<div class="input-group mb-3">
		<form action="subReply.do" method="get">
			<input type="text" class="form-control" placeholder="Search"
				name="content"> <input type="hidden" name="tn"
				value="${tn}" /> <input type="hidden" name="num" value="${num}" />
			<div class="input-group-append">
				<button class="btn btn-success" type="submit">등록</button>
				<!-- 댓글등록 -->
			</div>
		</form>
	</div>
</div>
<!-- container  -->


