<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <jsp:include page="/WEB-INF/views/top.jsp"/> --%>
<c:import url="/top"/>

<script type="text/javascript">
	$(function() {
		$('#btnWrite').click(function() {
			if (!$('#subject').val()) {
				alert('글제목을 입력하세요');
				$('#subject').focus();
				return;
			}
			if (!$('#name').val()) {
				alert('글쓴이를 입력하세요');
				$('#name').focus();
				return;
			}

			if (!$('#bpwd').val()) {
				alert('비밀번호를 입력하세요');
				$('#bpwd').focus();
				return;
			}

			$('#bf').submit();
		});
	});
</script>

<%
	String ctx = request.getContextPath();
%>
<div class="section">
	<div class="row">
		<div align="center" id="bbs" class="col-md-8 col-md-offset-2">
			<h1>Spring Board Edit</h1>
			<p>
				<a href="<%=ctx%>/board#bbs">글쓰기</a>| <a
					href="<%=ctx%>/boardList#bbs">글목록</a>
			<p>
				<!--파일 업로드시
	method: POST
	enctype: multipart/form-data  -->
			<form name="bf" id="bf" role="form" action="input" method="POST"
				enctype="multipart/form-data">
				<!--
				@PostMapping일때 mode값에 따라
				 원본글쓰기mode는 write, 원본글수정은 Edit, 답변글쓰기 mode는 rewrite로 감 -->
				<input type="hidden" name="mode" value="Edit">
				<!-- ------------------------------------------ -->
				<table class="table table-bordered">
					<tr>
						<td style="width: 20%"><b>글번호</b></td>
						<td style="width: 80%"><input type="text" name="idx"
							value='<c:out value="${board.idx}"/>' id="subject"
							class="form-control"></td>
					</tr>
					<tr>
						<td style="width: 20%"><b>제목</b></td>
						<td style="width: 80%"><input type="text" name="subject"
							value="${board.subject }" id="name" class="form-control">
						</td>
					</tr>
					<tr>
						<td style="width: 20%"><b>글쓴이</b></td>
						<td style="width: 80%"><input type="text" name="name"
							value="${board.name }" id="name" class="form-control"></td>
					</tr>
					<tr>
						<td style="width: 20%"><b>글내용</b></td>
						<td style="width: 80%"><textarea name="content" id="content"
								rows="10" cols="50" class="form-control">${board.content }</textarea>
						</td>
					</tr>
					<tr>
						<td style="width: 20%"><b>비밀번호</b></td>
						<td style="width: 80%">
							<div class="col-md-5">
								<input type="password" name="pwd" id="bpwd" class="form-control">
							</div>
						</td>
					</tr>
					<tr>
						<td style="width: 20%"><b>첨부파일</b></td>
						<td style="width: 80%">${board.originFilename }
						<!-- hidden으로 첨부했던 파일명을 넘기자------------------------------------------------------- -->
							<input type="hidden" name="old_file" value="${board.filename }">
							<input type="hidden" name="old_origin" value="${board.originFilename }"> 
							<!--  예전파일은 새로운 첨부파일이 있다면 삭제처리------------------------------------------------------- -->
							<input type="file" name="mfilename" id="filename" class="form-control"></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="button" id="btnWrite" class="btn btn-success">글수정</button>
							<button type="reset" id="btnReset" class="btn btn-warning">다시쓰기</button>
						</td>
					</tr>

				</table>


			</form>
		</div>
	</div>
</div>
<c:import url="/foot.do" />
<%-- <jsp:include page="/WEB-INF/views/foot.jsp"/> --%>











