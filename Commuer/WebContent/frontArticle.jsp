<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container" style="margin-top:30px;">
	<div class="row" id="front_art">
		<div class="col-md-4" id="front_art_notice">
			<h3 style="position:absolute; left:50px; top:5px; background-color:white" >
				<a href="#" >notice</a>
			</h3>
			<br>
			<hr color="black">
			<table>
				<tr>
					<td width="90%" style="font-size:8pt">글제목</td>
					<td width="10%" style="font-size:8pt; ">게시일</td>
				</tr>
					<c:if test="${loginUser ne null}">
						<tr>
							<td></td>
							<td rowspan="2" style="text-align:right">
								<a href="#" onclick="WriteNotice.do" class="btn btn-primary">작성</a>
							</td>
						</tr>
					</c:if>
			</table>
		</div>
		<div class="col-md-4" id="front_art_hot">
			<h3 style="position:absolute; left:50px; top:5px; background-color:white">
				<a href="#" >hot</a>
			</h3>
			<br>
			<hr color="pink">
			<table>
				<tr>
					<td width="90%" style="font-size:8pt">글제목</td>
					<td width="10%" style="font-size:8pt">게시일</td>
				</tr>
			</table>
		</div>
		<div class="col-md-4" id="front_art_like">
			<h3 style="position:absolute; left:50px; top:5px; background-color:white">
				<a href="#" >like</a>
			</h3>
			<br>
			<hr color="pink">
			<table>
				<tr>
					<td width="90%" style="font-size:8pt">글제목</td>
					<td width="10%" style="font-size:8pt">게시일</td>
				</tr>
			</table>
		</div>
	</div>
</div>