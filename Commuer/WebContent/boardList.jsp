<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="margin-top:20px">
	<div class="navbar" style="background:light; align:center">
			<%-- <c:if test="">
				<c:forEach var="board" items="#" varStatus="listStatus"> --%>
					<ul class="nav" id="boardListNav" style="padding:auto">
						<li class="nav-item"><a class="nav-link" href="board.do?tn=1">인기게시판</a></li>
						<li class="nav-item"><a class="nav-link" href="board.do?tn=2">자유게시판</a></li>
						<li class="nav-item"><a class="nav-link" href="board.do?tn=3">유머</a></li>
						<li class="nav-item"><a class="nav-link" href="#">음악</a></li>
						<li class="nav-item"><a class="nav-link" href="#">연예</a></li>
					</ul>
				<%-- </c:forEach>
			</c:if> --%>
		
	</div>
</div>