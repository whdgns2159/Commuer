<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>

<title>::FILE::</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<div class="text-center">
			<h1>File Upload</h1>
			<%
				/*파일 업로드시 주의사항
					[1] method는 POST로 지정한다.
					[2] POST방식일 경우, 인코딩 타입(enctype)이 2종류인데
						<1> application/x-www-form-urlencoded [디폴트]
						<2> multipart/form-data
						
						이 중  multipart/form-data 로 지정해야 첨부파일 데이터가 서버와 함께 전송된다.
						<1>번으로 설정되면 첨부파일만 전송된다.
				*/
			%>
			<form name="f" method="post" enctype="multipart/form-data"
				action="fileUp">
				<table class="table">
					<tr>
						<th>올린이</th>
						<td><input type="text" name="name" class="form-control">
						</td>
					</tr>
					<tr>
						<th>파일첨부</th>
						<td><input type="file" name="filename" class="form-control">
						</td>
					</tr>
					<tr>
						<td>
							<button class="btn btn-success">upload</button>
						</td>

					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>