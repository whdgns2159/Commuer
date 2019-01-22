<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
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
<link href="../stylesheet/mycss" rel="stylesheet" type="text/css">
<style type="text/css">
fieldset.scheduler-border {
	border: solid 1px #DDD !important;
	padding: 0 10px 10px 10px;
	border-bottom: none;
	height: 80%;
	/* max-height: 550px; */
}

legend.scheduler-border {
	width: auto !important;
	border: none;
	font-size: 14px;
}
</style>
<title>Memo List</title>
</head>
<body>
	<h1>총 게시글 수: ${totalCount}</h1>
	<div align="center" id="memoTab" class="container">

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
		<div class="section">
			<div class="container">

				<div class="row">
					<c:forEach var="m" items="${memoList}" varStatus="st">

						<div class="col-md-4 col-xs-12 col-sm-6" id="m"
							style="margin-bottom: 35px">
							<fieldset class="scheduler-border">
								<legend class="scheduler-border">Have a Good Time</legend>
								<div style="min-height: 250px;">
									<img src="../images/${m.filename }" class="img-responsive">
								</div>
								<h2 style="min-height: 100px">${m.msg }</h2>
								<p>작성자:${m.name } 
								[<fmt:formatDate value="${m.wdate }" 
								pattern="yy/MM/dd hh:mm"/>]
								</p>
								<div class="col-md-12">
									<a href="delete?idx=${m.idx}"><i
										class="fa fa-2x fa-fw fa-trash-o"></i></a> <a
										href="edit?idx=${m.idx}"><i class="fa fa-2x fa-edit fa-fw"></i></a>
									<a><i class="fa fa-2x fa-fw fa-heart"></i></a> <a><i
										class="fa fa-2x fa-fw hub fa-thumbs-down"></i></a>
								</div>
							</fieldset>
						</div>
						<c:if test="${st.count mod 3==0 }">
						</div><!--row end  -->
						<div class='row'><!--새로운 행(row)시작  -->
						</c:if>
					</c:forEach>	

				</div>

			</div>
		</div>
		<!--  -->


		<div class="row text-center">
			<div>
				총 글수 : <span>${totalCount}</span>
				<ul class="pagination">
					<li><a href="#">Prev</a></li>
					<c:forEach var="i" begin="1" end="${pageCount}">
						<c:if test="${cpage eq i}">
							<c:set var="mycss" value="active"/>
						</c:if>
						<c:if test="${cpage ne i}">
							<c:set var="mycss" value=""/>
						</c:if>
						<li class='${mycss}'><a href="memos?cpage=${i}">${i}</a></li>
					</c:forEach>
					<li><a href="#">Next</a></li>
				</ul>
			</div>
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
	</div>
</body>
</html>