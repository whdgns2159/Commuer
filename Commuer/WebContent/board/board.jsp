<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/top.jsp"/>
<jsp:include page="/boardList.jsp"/>

<div class="container">
	<div >
		<h1>
			게시판이름
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
				<c:if test="${게시판DB eq null or empty 게시판DB}"><!-- 게시판이 비어있을때 표시하는 내용 -->
					<tr>
						<td colspan="4">
							<b>데이터가 없습니다.</b>
						</td>
					</tr>
				</c:if>
				<c:if test="">
					<c:forEach var="" items="">
						<tr>
							<td width="5%">${인덱스}</td>
							<td width="65%">${제목 }</td>
							<td width="10%">${날짜 }</td>
							<td width="10%">${조회수 }</td>
							<td width="10%">${공감수 }</td>
						</tr>
					</c:forEach>
				</c:if>
				<tr>
					<td colspan="2" class="text-center">
						<!-- begin: 시작값
								end: 끝값
								step: 증가치 (디폴트:1)
						 -->
						 <!-- 페이지 네비게이션 시작 -->
						 <ul class="pagination">
							<c:forEach var="i" begin="1" end="${pageCount}" step="1">
								
								<c:if test="${i eq cpage }"><!-- 현재페이지 일 경우 -->
									<li class="page-item active" ><!-- active클래스를 넣어주면 현재페이지는 다른색으로 표시됨 -->
										<a class="page-link" href="#">a</a>
									</li>
								</c:if>
								<c:if test="${i ne cpage }"><!-- 현재 보고있는 페이지가 아닐경우 -->
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
				</tr>
			</tbody>
		</table>
	</div>
</div>