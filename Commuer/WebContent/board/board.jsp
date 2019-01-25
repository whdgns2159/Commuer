<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/top.jsp" />
<jsp:include page="/boardList.jsp" />

<div class="container">
	<div>
		<h2>
			${tName}
			<!-- 즐겨찾기(북마크) 버튼 구현 -->
			<c:if test="${loginUser ne null }">
				<c:if test="${BM eq null}">
					<a href="bookmark.do?tn=${tn}"><img src="images\beforeBM.png"
						width="20px" height="20px"></a>
				</c:if>
				<c:if test="${BM eq tn}">
					<a href="delBookmark.do?tn=${tn}"><img src="images\afterBM.png"
						width="20px" height="20px"></a>
				</c:if>
			</c:if>
		</h2>
	</div>
	<div class="table-responsive">
		<table class="table">
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
			<c:if test="${BS eq null}">
				<c:if test="${BT eq null or empty BT}">
					<!-- 게시판이 비어있을때 표시하는 내용 -->
					<tr>
						<td colspan="4"><b>데이터가 없습니다.</b></td>
					</tr>
				</c:if>
				<c:if test="${BT ne null}">
					<c:forEach var="i" items="${BT}">
						<tr onclick="article_link('${i.num}','${tn}')">
							<td width="5%">${i.num}</td>
							<td width="65%"><a href="#"><c:out value="${i.subject}"></c:out></a></td>
							<td width="10%">
							<fmt:formatDate value="${i.date}" pattern="yyyy-MM-dd"/></td>
							<td width="10%">${i.hits}</td>
							<td width="10%">${i.likes}</td>
						</tr>
					</c:forEach>
				</c:if>
			</c:if>
			<c:if test="${BS ne null}">
				<c:if test="${BS eq null or empty BS}">
					<!-- 게시판이 비어있을때 표시하는 내용 -->
					<tr>
						<td colspan="4"><b>데이터가 없습니다.</b></td>
					</tr>
				</c:if>
				<c:if test="${BS ne null}">
					<c:forEach var="i" items="${BS}">
						<tr onclick="article_link('${i.num}','${tn}')">
							<td width="5%">${i.num}</td>
							<td width="65%"><a href="#">${i.subject}</a></td>
							<td width="10%"><fmt:formatDate value="${i.date}"
									pattern="yyyy-MM-dd" /></td>
							<td width="10%">${i.hits}</td>
							<td width="10%">${i.likes}</td>
						</tr>
					</c:forEach>
				</c:if>
			</c:if>
			</tbody>
		</table>

	</div>
	<!-- .table-responsive -->
	<div class="row">
		<div class="col-md-7">
			<ul class="pagination">
				<c:forEach var="i" begin="1" end="${pageCount}" step="1">
					<c:if test="${i eq cpage }">
						<li class="page-item active"><a class="page-link"
							href="board.do?tn=${tn }&cpage=${i}">${i }</a></li>
					</c:if>
					<c:if test="${i ne cpage }">
						<li class="page-item"><a class="page-link"
							href="board.do?tn=${tn }&cpage=${i}">${i }</a></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		<div class="col-md-5">

			<!-- 게시글 선택시 파라미터 넘김 -->

			<form name="art_info" action="article.do">
				<input type="hidden" name="tn"> 
				<input type="hidden" name="num">
			</form>
			<!-- 키워드검색input -->
			<nav class="navbar">
				<form class="navbar-form" action="keywordSearch.do">
					<div class="form-group">
						<div class="input-group-sm">
							<input name="keyword" type="text" class="form-control form-control-sm"> 
							<input type="hidden" name="tn" value="${tn}" class="form-control">
						</div>
					</div>
					<button type="submit" class="btn btn-default btn-sm">검색</button>
				</form>

				<c:if test="${loginUser ne null }">
					<div class="art_write">
						<a href="articleWrite.do?tn=${tn}" class="btn btn-primary">글쓰기</a>
					</div>
				</c:if>
			</nav>
		</div>
		<!-- col -->
	</div>
	<!-- -->


</div>
<!-- container -->
<script>
	var article_link = function(num, tn) {
		art_info.tn.value = tn;
		art_info.num.value = num;
		art_info.submit();
	}
</script>