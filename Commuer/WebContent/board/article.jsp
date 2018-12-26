<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/top.jsp"/>
<jsp:include page="/boardList.jsp"/>
<style>
<!--
ul#reple{
	list-style: none;
	margin: 0em;
	padding: 0em;
}
div#repleInfo{
	font-weight: bold;
}
ul#reple li{
	list-style: none;
}
-->
</style>
<div class="container">
	<section>
		<hr color="red">
		<header>
			<div><h3><%-- ${글제목 } --%>a</h3></div>
			<div>
				<span><%-- ${날짜 } --%>a</span>
				<span><%-- ${조회수 } --%>a</span>
			</div>
		</header>
		<hr color="red">
		<div>
			<article>
				<%-- ${글} --%>
				aawdWdawdawdawdawdawdawdawdawd
				awdawdawdawdawdawdawdawda
				awdawdawdawdawdaw
				dawdawdawdawd
			</article>
		</div>
	</section>
	<hr color="red">
	<button class="btn btn-primary btn-sm" onclick="">공감</button>
	<hr color="red">
	<section>
		<div class="container-fluid">
		<div>
			<span>댓글수</span>
		</div>
			<ul id="reple">
			<%-- <c:if test="댓글이 있을때">
				<c:forEach var="i" items=""> --%>
					<li>
						<div id="repleInfo">
							<span><%-- ${작성자이름 } --%>a</span>
							<span><%-- ${댓글작성날짜 } --%>a</span>
						</div>
						<div>
							<span><%-- ${댓글 } --%>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</span>
						</div>
						<hr color="red">
					</li>
				<%-- </c:forEach>
			</c:if> --%>
			<%-- <c:if test="댓글이 없을때">
				<li></li>
			</c:if> --%>
			</ul>
		
		</div>
	</section>
	<div>
		<div class="input-group mb-3">
			  <input type="text" class="form-control" placeholder="Search">
			  <div class="input-group-append">
			    <button class="btn btn-success" type="submit">등록</button> 
			  </div>
			</div>
	</div>
</div>