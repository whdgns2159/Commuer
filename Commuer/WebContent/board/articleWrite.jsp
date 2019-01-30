<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp" />
<jsp:include page="/boardList.jsp" />

<div class="container" style="margin-top: 15px; width: 1000px">
	<form name="subArticleF" action="subArticle.do" method="get">
		<input name="subject" id="subject" placeholder="제목" type="text"	class="art_title form-control">
		<br>
		<textarea  name="content" id="content"  placeholder="본문" class="art_content"></textarea>
		<input type="hidden" id="tn" name="tn" value="${tn}"/><!-- 게시판번호 -->
		<div class="art_result">
			<a href="#" onclick="subArticle()" class="btn btn-primary">등록</a>
			<button type="button" class="btn btn-secondary"
				onclick="javascript:historty.back()">취소</button>
		</div>
	</form>
</div>

<script type="text/javascript">
	var subArticle = function() {
		subArticleF.submit();
	}
</script>