<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row">
	<h1 class="btn-primary">
		<i class="fa fa-thumbs-up"></i> BEST 상품
	</h1>
	<div class="row">
		<div class="col-md-12">
			<div id="carousel-generic" class="carousel2 slide">
				<div class="carousel-inner">
					<div class="item active">
						<div class="row">
							<!-- 슬라이드 one -->
							<!-- <c:forEach var="book" items="${blist }" varStatus="i"> -->
							<div class="col-xs-3 col-md-3">
								<div class="thumbnail site">
									<a class="fancybox" rel="gallery1"
										href="javascript:goDetail('${book.bk_num }','${book.m_num_fk }')">
										<img
										src="${pageContext.request.contextPath}/images/mac1.png"
										style="width: 270px; height: 220px" alt="...">
									</a>
									<div class="caption">
										<span style="font-size: 20px"><b>aaa</b></span><br>
										<br> <span style="color: gray">bbb&nbsp;|&nbsp;ccc<br>
											<del>
												<fmt:formatNumber value="${book.bk_price}" pattern="###,###" />
												원
											</del>→
										</span> <span style="color: #F781BE"> <fmt:formatNumber
												value="${book.bk_saleprice}" pattern="###,###" />원&nbsp; <b>(-<fmt:formatNumber
													value="${book.percent }" pattern="###" />%)
										</b>
										</span>
									</div>
								</div>
							</div>
							<!-- col-md-3 end -->
							<div class="col-xs-3 col-md-3">
								<div class="thumbnail site">
									<a class="fancybox" rel="gallery1"
										href="javascript:goDetail('${book.bk_num }','${book.m_num_fk }')">
										<img
										src="${pageContext.request.contextPath}/images/mac2.png"
										style="width: 270px; height: 220px" alt="...">
									</a>
									<div class="caption">
										<span style="font-size: 20px"><b>aaa</b></span><br>
										<br> <span style="color: gray">bbb&nbsp;|&nbsp;ccc<br>
											<del>
												<fmt:formatNumber value="${book.bk_price}" pattern="###,###" />
												원
											</del>→
										</span> <span style="color: #F781BE"> <fmt:formatNumber
												value="${book.bk_saleprice}" pattern="###,###" />원&nbsp; <b>(-<fmt:formatNumber
													value="${book.percent }" pattern="###" />%)
										</b>
										</span>
									</div>
								</div>
							</div>
							<!-- col-md-3 end -->
							<div class="col-xs-3 col-md-3">
								<div class="thumbnail site">
									<a class="fancybox" rel="gallery1"
										href="javascript:goDetail('${book.bk_num }','${book.m_num_fk }')">
										<img
										src="${pageContext.request.contextPath}/images/mac3.png"
										style="width: 270px; height: 220px" alt="...">
									</a>
									<div class="caption">
										<span style="font-size: 20px"><b>aaa</b></span><br>
										<br> <span style="color: gray">bbb&nbsp;|&nbsp;ccc<br>
											<del>
												<fmt:formatNumber value="${book.bk_price}" pattern="###,###" />
												원
											</del>→
										</span> <span style="color: #F781BE"> <fmt:formatNumber
												value="${book.bk_saleprice}" pattern="###,###" />원&nbsp; <b>(-<fmt:formatNumber
													value="${book.percent }" pattern="###" />%)
										</b>
										</span>
									</div>
								</div>
							</div>
							<!-- col-md-3 end -->
							<div class="col-xs-3 col-md-3">
								<div class="thumbnail site">
									<a class="fancybox" rel="gallery1"
										href="javascript:goDetail('${book.bk_num }','${book.m_num_fk }')">
										<img
										src="${pageContext.request.contextPath}/images/note1.PNG"
										style="width: 270px; height: 220px" alt="...">
									</a>
									<div class="caption">
										<span style="font-size: 20px"><b>aaa</b></span><br>
										<br> <span style="color: gray">bbb&nbsp;|&nbsp;ccc<br>
											<del>
												<fmt:formatNumber value="${book.bk_price}" pattern="###,###" />
												원
											</del>→
										</span> <span style="color: #F781BE"> <fmt:formatNumber
												value="${book.bk_saleprice}" pattern="###,###" />원&nbsp; <b>(-<fmt:formatNumber
													value="${book.percent }" pattern="###" />%)
										</b>
										</span>
									</div>
								</div>
							</div>
							<!-- col-md-3 end -->
								

							</div>
							<!-- for row end -->
						</div>
						<!-- for item active end -->
						
						<div class="item">
						<div class="row">
							<!-- 슬라이드 one -->
							<!-- <c:forEach var="book" items="${blist }" varStatus="i"> -->
							<div class="col-xs-3 col-md-3">
								<div class="thumbnail site">
									<a class="fancybox" rel="gallery1"
										href="javascript:goDetail('${book.bk_num }','${book.m_num_fk }')">
										<img
										src="${pageContext.request.contextPath}/images/sam1.png"
										style="width: 270px; height: 220px" alt="...">
									</a>
									<div class="caption">
										<span style="font-size: 20px"><b>aaa</b></span><br>
										<br> <span style="color: gray">bbb&nbsp;|&nbsp;ccc<br>
											<del>
												<fmt:formatNumber value="${book.bk_price}" pattern="###,###" />
												원
											</del>→
										</span> <span style="color: #F781BE"> <fmt:formatNumber
												value="${book.bk_saleprice}" pattern="###,###" />원&nbsp; <b>(-<fmt:formatNumber
													value="${book.percent }" pattern="###" />%)
										</b>
										</span>
									</div>
								</div>
							</div>
							<!-- col-md-3 end -->
							<div class="col-xs-3 col-md-3">
								<div class="thumbnail site">
									<a class="fancybox" rel="gallery1"
										href="javascript:goDetail('${book.bk_num }','${book.m_num_fk }')">
										<img
										src="${pageContext.request.contextPath}/images/sam2.png"
										style="width: 270px; height: 220px" alt="...">
									</a>
									<div class="caption">
										<span style="font-size: 20px"><b>aaa</b></span><br>
										<br> <span style="color: gray">bbb&nbsp;|&nbsp;ccc<br>
											<del>
												<fmt:formatNumber value="${book.bk_price}" pattern="###,###" />
												원
											</del>→
										</span> <span style="color: #F781BE"> <fmt:formatNumber
												value="${book.bk_saleprice}" pattern="###,###" />원&nbsp; <b>(-<fmt:formatNumber
													value="${book.percent }" pattern="###" />%)
										</b>
										</span>
									</div>
								</div>
							</div>
							<!-- col-md-3 end -->
							<div class="col-xs-3 col-md-3">
								<div class="thumbnail site">
									<a class="fancybox" rel="gallery1"
										href="javascript:goDetail('${book.bk_num }','${book.m_num_fk }')">
										<img
										src="${pageContext.request.contextPath}/images/sam3.png"
										style="width: 270px; height: 220px" alt="...">
									</a>
									<div class="caption">
										<span style="font-size: 20px"><b>aaa</b></span><br>
										<br> <span style="color: gray">bbb&nbsp;|&nbsp;ccc<br>
											<del>
												<fmt:formatNumber value="${book.bk_price}" pattern="###,###" />
												원
											</del>→
										</span> <span style="color: #F781BE"> <fmt:formatNumber
												value="${book.bk_saleprice}" pattern="###,###" />원&nbsp; <b>(-<fmt:formatNumber
													value="${book.percent }" pattern="###" />%)
										</b>
										</span>
									</div>
								</div>
							</div>
							<!-- col-md-3 end -->
							<div class="col-xs-3 col-md-3">
								<div class="thumbnail site">
									<a class="fancybox" rel="gallery1"
										href="javascript:goDetail('${book.bk_num }','${book.m_num_fk }')">
										<img
										src="${pageContext.request.contextPath}/images/note3.PNG"
										style="width: 270px; height: 220px" alt="...">
									</a>
									<div class="caption">
										<span style="font-size: 20px"><b>aaa</b></span><br>
										<br> <span style="color: gray">bbb&nbsp;|&nbsp;ccc<br>
											<del>
												<fmt:formatNumber value="${book.bk_price}" pattern="###,###" />
												원
											</del>→
										</span> <span style="color: #F781BE"> <fmt:formatNumber
												value="${book.bk_saleprice}" pattern="###,###" />원&nbsp; <b>(-<fmt:formatNumber
													value="${book.percent }" pattern="###" />%)
										</b>
										</span>
									</div>
								</div>
							</div>
							<!-- col-md-3 end -->
								

							</div>
							<!-- for row end -->
						</div>
						<!-- for item  end -->
						
						
						
					</div>
					<!-- carousel inner -->
				</div>
				<!-- <div id="carousel-generic" class="carousel2 slide"> -->

				<!--캐러셀 스크립트  -->
				<script src="./js/jquery.fancybox.js"></script>
				<script>
					$('.carousel2').carousel({
						interval : 3000
					})
					//*  fancybox  실행 스크립트 */
					$(document).ready(function() {
						$(".fancybox").fancybox({
							openEffect : 'none',
							closeEffect : 'none'
						});
					});
				</script>
			</div>
		</div>