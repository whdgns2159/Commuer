<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="table-responsive" id="rvTable">
	<table class="table table-hover">
		<thead>
			<tr>
				<th colspan="3">
				<h2>::상품평 목록::
					<button class="btn btn-info">리뷰갯수:
						<span class="badge">${rvCount}</span>
					</button>
				</h2>
				</th>
			</tr>
		</thead>
		<tbody id="rvBody">
		<c:forEach var="rv" items="${rvList}">
			<tr>
				<td width="15%">
				<!-- eq: equal 연산자. == 등가연산자와 동일 
					 ne: not equal 연산자 != 와 동일
				-->
				
					<img src="review_images/${rv.filename}"
					width="120px"
					 class="img img-thumbnail responsive">
				
				
				</td>
				<td width="60%">
					<h3>${rv.title}</h3>
					<p>${rv.content}</p>
				</td>
				<td width="25%">
					<span class="hidden-xs">평가점수:</span>
					<c:forEach begin="1" end="${rv.score}">
					<img src="review_images/star.PNG">
					</c:forEach>
					
					<br>
					<span class="hidden-xs">
					작성자:
					<b>
					${rv.name} [ ${rv.userid}]  
					</b>
					</span>
					 
					[${rv.indate}]<br>
					<!-- 로그인한 사람이 쓴 글이라면
					수정, 삭제 버튼 추가 ---------- -->
					<c:if test="${rv.midx_fk eq loginUser.idx}">
		<button type="button" onclick=""
		class="btn btn-info">수정</button>
		<button type="button" onclick="rvDel('${rv.ridx}')"
		class="btn btn-danger">삭제</button>
					</c:if>
					<!-- ---------------------------- -->	
				</td>
			</tr>
		</c:forEach>
		
	  <!-- 페이지 네비게이션----------- -->
	   <tr>
	   	<td colspan="3" class="text-center">
	   		
	   		
	   		<div class="col-md-6">
	   		<form name="findF" id="findF"
	   		 action="pdDetail.do">
	   		 <!-- hidden data------------ -->
	   		 <input type="hidden" name="pnum"	   		 
	   		  value="ㅁ">
	   		  <!-- ----------------------- -->
	   		<div class="col-md-3">
	   		<select name="findType" id="ftype"
	   		 class="form-control">
	   			<optgroup label="::검색유형::">
	   				<option value="1">제목</option>
	   				<option value="2">내용</option>	   				
	   			</optgroup>
	   		</select>
	   		</div>
	   		<div class="col-md-6">
	   		<input type="text" name="keyword" id="key"
	   		class="form-control" 
	   		placeholder="검색어를 입력하세요">
	   		</div>
	   		<div class="col-md-3">
	   		<button class="btn btn-primary"
	   		 id="btnFind">검색</button>
	   		 </div>
	   		</form>	   		
	   		</div>
	   		
	   		<div class="col-md-6">
	   		<ul class="pagination">
		   	<c:forEach var="i" begin="1" end="${rvPageCount}">
		   	
		   	<li <c:if test="${cpage eq i}">class='active'</c:if>>
		   	
<a href="prodDetail.do?pnum=${prod.pnum}&cpage=${i}#rvTable">${i}</a>
			</li>	
		   	</c:forEach>
		   	</ul>
		   		
			</div>
	   		
	   	</td>
	   </tr>
	   <!-- ----------------------------- -->
		
		
		</tbody>
	</table>
	
	
	<!-- 리뷰 삭제/수정 폼 시작--------------- -->
	<form name="rvF" id="rvF">
		<input type="text" name="ridx" id="ridx">
		<input type="text" name="pnum_fk" id="pnum_fk"
		 value="${prod.pnum}">
	</form>
	<!-- ----------------------------- -->
	
	<script type="text/javascript">
		var rvDel=function(num){
			$('#ridx').val(num);
			var yn=confirm(num+"번 글을 삭제할까요?");
			if(yn){
				$('#rvF').attr('action','user/reviewDel.do');
				$('#rvF').attr('method','post');
				$('#rvF').submit();
			}
		}
	
	</script>
</div>













