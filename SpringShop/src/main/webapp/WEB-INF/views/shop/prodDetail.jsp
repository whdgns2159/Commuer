<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/top.jsp" /> 

<script type="text/javascript" src="js/jquery.magnifier.js">
</script>
   
<div class="section">
<div align="center" class="row">
<c:if test="${prod eq null }">
	<h2>해당 상품은 존재하지 않아요</h2>
</c:if>
<c:if test="${prod ne null }">
<div class="col-md-10 col-md-offset-1 table-responsive">
	<table class="table">
	<thead>
	<tr>
		<th colspan="2"><h3>상품 정보</h3></th>
	</tr>
	</thead>
	<tbody>
		<tr>
			<td align="center" width="50%">
		<%-- <a href="javascript:openPop('${prod.pimage1}')"> --%>
		<img src="product_images/${prod.pimage1}"
				class="img img-responsive img-thumbnail magnify"
				data-magnifyby="2" data-magnifyduration="300"
				 style="width: 70%;">
		<!-- </a> -->	
			</td>
			<td align="center"  width="50%">
	<h4><span class="label label-danger">
	${prod.pspec}</span></h4>
	
			
			상품번호: ${prod.pnum}  <br>
			상품이름: ${prod.pname} <br>
			정가:<del>
				<fmt:formatNumber value="${prod.price}"
				 pattern="###,###" />
				</del>원<br>
			판매가:<span style="color:red;font-weight:bold">
				<fmt:formatNumber value="${prod.saleprice}"
				 pattern="###,###" />
			</span>원<br>
	할인율:<span style="color:red">${prod.percent}%</span><br>
			POINT:<b style="color:green">[${prod.point}]</b>POINT<br>
			<!-- form시작---------- -->
			<form name="frm" id="frm" method="POST">
			<!-- 상품번호를 hidden으로 넘기자------ -->
			<input type="hidden" name="pnum" value="${prod.pnum}">
			<!-- -------------------------------- -->				
			<label for="oqty">상품갯수</label>
			<input type="number"
			name="oqty" id="oqty" min="1" max="50" size="2" value="1">
			
			</form>				
			<!-- form end------------ -->	
			<button type="button" onclick="goCart(${prod.pnum})"
			 class="btn btn-primary">장바구니</button>
			<button type="button" onclick="goOrder(${prod.pnum})" 
			class="btn btn-warning">주문하기</button>
			<button type="button" onclick="goWish(${prod.pnum})" 
			class="btn btn-danger">위시리시트</button>
			</td>
		</tr>
		<tr style="border:0">
			<td align="center">
				<img src="product_images/${prod.pimage2}"
				 class="img img-responsive img-thumbnail"  style="width: 70%;">
			</td>
			<td align="center">
				<img src="product_images/${prod.pimage3}"
				class="img img-responsive img-thumbnail"  style="width: 70%;">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<p>상품설명</p>
				<pre>${prod.pcontents}</pre>
			</td>
		</tr>
	</tbody>
</table>
<c:if test="${loginUser eq null}">
	<button class="btn btn-success"
	 data-target="#myModal" data-toggle="modal">상품평쓰기</button>
	 <span class="text-danger"><b>로그인해야 이용가능합니다.</b></span>
</c:if>
<c:if test="${loginUser ne null}"><!--로그인했다면  -->
<!-- 리뷰 글쓰기 include--------------- -->
<c:import url="reviewWrite.jsp"/>
<!-- --------------------------------- -->
</c:if>

<!-- 리뷰 목록 보여주기------------------ -->
<c:import url="reviewList.jsp"/>
<!-- ---------------------------------- -->

</div><!-- container end -->
</c:if>
</div>
</div><!-- section end -->


<script type="text/javascript">
	/*팝업창으로 상세 이미지를 보여주는 함수 */
	var openPop=function(pimg){
		//var  url="product_images/large/"+pimg
		var  url="product_images/"+pimg;
		//alert(url);
		var imgObj=new Image();
		imgObj.src=url;
		//팝업창의 폭=(원래이미지 폭 +80)px
		var w=imgObj.width+80;
		var h=imgObj.height+80;
		
		win=window.open(url,"imgView",
				"width="+w+", height="+h+", left=100");
	}//----------------------------
	
	var goCart=function(pnum){
		frm.action="user/cartAdd.do";
		//frm.method="GET";
		frm.submit();
	}//----------------------------
	
	var goOrder=function(pnum){
		frm.action="user/order.do";
		//frm.method="GET";
		frm.submit();
	}//----------------------------
	
</script>


<jsp:include page="/foot.jsp" />







