<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp"/>
<jsp:include page="/boardList.jsp"/>

    <div class="container" style="margin-top:15px; width:1000px">
    	<form action="subArticle.do">
    		<input name="title" id="subject" placeholder="제목" type="text" class="art_title form-control">
    		<span class="placeholder_cont">내용</span>
    		<div class="art_content" contenteditable="true" id="content"></div>
    		<div class="art_result">
    			<button type="submit" class="btn btn-primary">등록</button>
    			<button type="button" class="btn btn-secondary">취소</button>
    		</div>
    	</form>
    </div>
    
    
<script type="text/javascript">
	$('.art_content').on('focus',function(){
		$('.placeholder_cont')
	});
</script>