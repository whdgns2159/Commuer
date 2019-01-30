<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="/top" />
<%
	String ctx=request.getContextPath();
%>
<script type="text/javascript">
	var check=function(){
		if(!sf.findType.value){
			alert('검색 유형을 선택하세요');
			sf.findType.focus();
			return false;
		}
		
		if(!sf.findKeyword.value){
			alert('검색어를 입력하세요');
			sf.findKeyword.focus();
			return false;
		}
		sf.submit();
	}
</script>
<%-- ${boardList} --%>
<div class="section">
<div class="row">
	<div align="center" id="bbs" class="col-md-8 col-md-offset-2">
	<h1>Spring Board</h1>
	<p>
		<a href="<%=ctx%>/board/input#bbs">글쓰기</a>| <a
			href="<%=ctx%>/board/list#bbs">글목록</a>
		<p>
		<div class="section">
		<div class="row">
			<!-- 검색 폼 시작--------------------- -->
			<form name="sf" action="find"  onsubmit="return check()">
			<div class="col-md-2">
				<select name="findType" class="form-control">
					<option value="">::검색 유형::</option>
					<option value="1">글제목</option>
					<option value="2">작성자</option>
					<option value="3">글내용</option>
				</select>
			</div>
			<div class="col-md-7">
				<input type="text" name="findKeyword" class="form-control"
				placeholder="검색어를 입력하세요">
			</div>
			<div class="col-md-1">
				<button type="button" onclick="check()" class="btn btn-warning">검색</button>
			</div>	
			</form>
			<!-- 검색 폼 끝---------------------- -->
			
			<!-- 페이지 사이즈 폼 시작-------------- -->
			<form name="pf" id="pf" action="list">
				
				<div class="col-md-2">
				<select name="pageSize" class="form-control" onchange="submit()">
					<option value="">:::페이지 사이즈:::</option>
					<c:forEach var="ps" begin="5" end="20" step="5">
						<option value="${ps}">페이지 사이즈 ${ps}개</option>
					</c:forEach>
				</select>
				</div>
			</form>
		</div>
		</div>
		<table class="table table-condensed table-striped">
			<tr>
				<th width="10%">글번호</th>
				<th width="40%">제목</th>
				<th width="20%">글쓴이</th>
				<th width="20%">날짜</th>
				<th width="10%">조회수</th>
			</tr>
			<!-- ---------------------------- -->
				<c:if test="${boardList eq null or empty boardList }">
				<tr>
					<td colspan="5"><b>게시글이 없습니다.</b></td>
				</tr>
				</c:if>
			<c:if test="${boardList ne null and not empty boardList }">
				<c:forEach var="board" items="${boardList}">
				<tr>
					<td>
						<c:out value="${board.idx}"/>
					</td>
					<td align="left">
					<a href="view?idx=${board.idx}">					
						<c:out value="${board.subject}"/>
						&nbsp;&nbsp;&nbsp;
						<c:if test="${board.isFile>0 }">
							<img alt="" src="../images/file.PNG">
						</c:if>
						<!-- 24시간 이내에 작성한 글 이다. -->
						<c:if test="${board.newImg<1 }">
							<span class="label label-info">new</span>
						</c:if>											
					</a></td>
					<td>
						<c:out value="${board.name}"/>
					</td>
					<td>	
						<fmt:formatDate
						 value="${board.wdate}"
						 pattern="yyyy-MM-dd"/>	
						
					</td>
					<td>
						<c:out value="${board.readnum}"/>
					</td>
				</tr>
				</c:forEach>
				</c:if>
			<!-- pagination ----------------------------- -->
			<tr>
				<td colspan="3" class="text-center">
				  <ul class="pagination">	
				  <!-- 이전 5개 -->
				  <c:if test="${paging.prevBlock>0 }">
				  	<li><a href="list?cpage=${paging.prevBlock }&pageSize=${paging.pageSize}">Prev</a></li>
				  </c:if>
					<c:forEach var="i" begin="${paging.prevBlock+1 }" end="${paging.nextBlock-1}">
						<c:if test="${i<=paging.pageCount }">
							<li <c:if test="${i eq paging.cpage }">class="active"</c:if>>
								<a href="list?cpage=${i}&pageSize=${paging.pageSize}">${i}</a>
							</li>
						</c:if>	
					</c:forEach>
					<!-- 이후 5개 -->
				  <c:if test="${paging.nextBlock<=paging.pageCount }">
				  	<li><a href="list?cpage=${paging.nextBlock }&pageSize=${paging.pageSize}">Next</a></li>
				  </c:if>
				 </ul>
									 
				</td>
				<td colspan="2">총게시물수:
				<span class="text-danger" style="font-weight:bold">
				${paging.totalCount} 개</span> 
				<br>
				 <span  class="text-danger" style="font-weight:bold" >${paging.cpage }</span>
				 /${paging.pageCount} pages
				</td>
			</tr>
			
		</table>
		
	</div>
</div>	
<c:import url="/foot" />