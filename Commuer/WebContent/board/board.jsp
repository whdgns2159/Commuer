<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/top.jsp"/>
<jsp:include page="/boardList.jsp"/>

<div class="container">
	<div >
		<h1>
			${tn}
		</h1>
	</div>
	<div class="table">
		<table>
			<thead>
				<tr>
					<td width="5%">#</td>
					<td width="65%">제목</td>
					<td width="10%">날짜</td>
					<td width="10%">조회수</td>
					<td width="10%">공감수</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${BT eq null or empty BT}"><!-- 게시판이 비어있을때 표시하는 내용 -->
					<tr>
						<td colspan="4">
							<b>데이터가 없습니다.</b>
						</td>
					</tr>
				</c:if>
				<c:if test="${BT ne null}">
					<c:forEach var="i" items="${BT}">
						<tr>
							<td width="5%">${i.num}</td>
							<td width="65%">${i.subject}</td>
							<td width="10%">${i.date}</td>
							<td width="10%">${i.hits}</td>
							<td width="10%">${i.likes}</td>
						</tr>
					</c:forEach>
				</c:if>
				<%-- <tr>
					<td colspan="2" class="text-center">
						 <ul class="pagination">
							<c:forEach var="i" begin="1" end="${pageCount}" step="1">
								<c:if test="${i eq cpage }">
									<li class="page-item active" >
										<a class="page-link" href="#">a</a>
									</li>
								</c:if>
								<c:if test="${i ne cpage }">
									<li class="page-item" >
										<a class="page-link" href="#">a</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</td>
					<td colspan="2" class="text-right">
						<button class="btn btn-danger">
							총 게시글 수: 
							<span class="badge badge-light">${totalCount}</span>
						</button>
					</td>
				</tr> --%>
			</tbody>
		</table>
		<div class="art_write" style="text-align:right">
			<button class="btn btn-primary" type="button" onclick=”location.src=’articleWrite.jsp'”>글쓰기</button>
		</div>
	</div>
</div>

<script>
	
</script>