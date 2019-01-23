<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!doctype html>
<html>

<head>

<title>::MEMO::</title>
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
		<!-- ----------------------------------------- -->
		<div class="navbar navbar-default navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#navbar-ex-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"><span>Brand</span></a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-ex-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">Contacts</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- ------------------------------------  -->
		<form role="form" name="frm" method="post"
		 action="input" enctype="multipart/form-data"> 
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<a href="#"><img
						src="https://ununsplash.imgix.net/reserve/r0r252VR6WqPRsxngGUE_telefoon%20politie.jpg?w=1024&amp;q=50&amp;fm=jpg&amp;s=30a261ce928af70d4f9a3fe0cf394bc3"
						class="img-responsive"></a>
					<div class="carousel-caption">

						<h2>
							<i class="fa fa-fw fa-lg fa-pagelines"></i>따뜻한 말 한마디!.
						</h2>
						<p>행복을 가져오는 씨앗입니다</p>
						<a class="btn btn-warning"
						 href="memos">메모 목록 가기</a>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-8 col-md-offset-2">



					<h1 class="text text-center">:::Spring's 한줄 메모장:::</h1>
					<div></div>
					<label for="name"> 작 성 자 : </label> <input type="text" name="name"
						id="name" class="form-control" /> <label for="msg"> 메모내용:
					</label> <input type="text" name="msg" id="msg" class="form-control" />
					<div></div>	
						<table class="table table-responsive">
							<tr>
								<td class="text-center"><a><i class="fa fa-5x fa-fw fa-file-image-o"></i></a></td>
								<td><input type="file" name="mfile" id="filename"
									class="form-control">
								</td>
						</table> 
					<%-- 	<c:import url="/fileup"/> --%>

										<p></p>

				</div>
			</div>

			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<button type="submit" class="btn btn-success">
						<i class="fa fa-edit fa-fw fa-lg"></i> Submit
					</button>
					<a href="memos" class="btn btn-danger"> <i
						class="fa fa-align-justify fa-fw fa-lg"></i> 글목록
					</a>
				</div>
				<div class="col-md-2"></div>

			</div>
			<div class="section">
			<div class="container">
				<div class="row text-center">
					<div class="col-xs-2 col-xs-offset-2 text-center">
						<a href="memos"><i class="fa fa-3x fa-align-justify fa-fw"></i></a>
					</div>
					<div class="col-xs-2">
						<a href="input"><i class="-square fa fa-3x fa-fw fa-pencil"></i></a>
					</div>
					<div class="col-xs-2">
						<a><i class="fa fa-3x fa-facebook fa-fw"></i></a>
					</div>
					<div class="col-xs-2 text-center">
						<a><i class="fa fa-3x fa-fw fa-github"></i></a>
					</div>
				</div>
			</div>

		</div>
		</form>
	</div>
</body>

</html>
    