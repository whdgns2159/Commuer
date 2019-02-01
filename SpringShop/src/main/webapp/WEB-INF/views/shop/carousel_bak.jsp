<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.carousel-inner {
	width: 100%;
	max-height: 350px;
	margin: auto;
}
/* carousel fade effect */
.carousel .item {
	-webkit-transition: opacity 3s;
	-moz-transition: opacity 3s;
	-ms-transition: opacity 3s;
	-o-transition: opacity 3s;
	transition: opacity 3s;
}

.carousel .active.left {
	left: 0;
	opacity: 0;
	z-index: 2;
}

.carousel .next {
	left: 0;
	opacity: 1;
	z-index: 1;
}

/* end of carousel fade effect */
</style>

<div class="carousel slide" id="carousel-example"
	data-ride="carousel" data-interval="2000">
	<div class="carousel-inner">
		<div class="item active">
			<img  class="img-responsive"
				src="https://ununsplash.imgix.net/photo-1422479516648-9b1f0b6e8da8?w=1024&amp;q=50&amp;fm=jpg&amp;s=c5f2b3df2a4c71532b3b354b8766503c">
			<div class="carousel-caption">
				<h2>Title</h2>
				<p>Description</p>
			</div>
		</div>
		<!-- item add -->
		<div class="item">
			<img   class="img-responsive"
				src="images/main4.PNG">
			<div class="carousel-caption">
				<h2>Title</h2>
				<p>Description</p>
			</div>
		</div>
		<div class="item">
			<img   class="img-responsive"
				src="images/main3.PNG">
			<div class="carousel-caption">
				<h2>Title</h2>
				<p>Description</p>
			</div>
		</div>
		<div class="item">
			<img   class="img-responsive"
				src="images/main.PNG">
			<div class="carousel-caption">
				<h2>Title</h2>
				<p>Description</p>
			</div>
		</div>
		<div class="item">
			<img   class="img-responsive"
				src="images/main2.PNG">
			<div class="carousel-caption">
				<h2>Title</h2>
				<p>Description</p>
			</div>
		</div>
	</div>
	<a class="left carousel-control" href="#carousel-example"
		data-slide="prev"><i class="icon-prev  fa fa-angle-left"></i></a> <a
		class="right carousel-control" href="#carousel-example"
		data-slide="next"><i class="icon-next fa fa-angle-right"></i></a>
</div>
