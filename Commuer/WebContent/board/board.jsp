<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
							<td width="65%" ><a  href="#" onclick="article_link('${i.num}','${tn}')">${i.subject}</a></td>
							<td width="10%">
								<fmt:formatDate value="${i.date}" pattern="yyyy-MM-dd"/>
							</td>
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
		
	</div><!-- 테이블 div------------------------------------------------------ -->
	
	
	<form name="art_info" action="article.do">
		<input type="hidden" name="tn">
		<input type="hidden" name="num">
	</form>
	
	<c:if test="${loginUser ne null }">
	<div class="row">
		<div class="art_write" style="text-align:right">
			<a href="board/articleWrite.jsp?tn=${tn}&num=${num}" class="btn btn-primary">글쓰기</a>
		</div>
	</div>
	</c:if>
	
</div><!-- container -->
<script>
	
	
	var article_link=function(num, tn){
		art_info.tn.value=tn;
		art_info.num.value=num;
		art_info.submit();
	}
</script>