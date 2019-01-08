<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp"/>
<jsp:include page="/boardList.jsp"/>

    <div class="container" style="margin-top:15px; width:1000px">
    	<form name="subArticleF" action="subArticle.do" method="get">
    		<input name="subject" id="subject" placeholder="제목" type="text" class="art_title form-control">
    		<span class="placeholder_cont" >내용</span>
    		<div class="art_content" contenteditable="true" id="div_content"></div>
    		<div class="art_result">
    			<a href="#" onclick="subArticle()" class="btn btn-primary">등록</a>
    			<button type="button" class="btn btn-secondary">취소</button>
    		</div>
    		<textarea name="content" id="content" style="display: none"></textarea>
    		<input type="hidden" id="tn" name="tn" value="${tn}"/>
    	</form>
    </div>
    
    
<script type="text/javascript">
	var subArticle=function(){
		$('#content').val($('#div_content').text());
		subArticleF.submit();
	}
</script>