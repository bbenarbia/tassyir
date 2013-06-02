
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<jsp:include page="./../common/head.jsp"/>
<script type="text/javascript">
$(function(){
	$('#carousel1').infiniteCarousel();
});
</script>

<style type="text/css">
#carousel1 {
	width:400px;
	height:250px;
	overflow:scroll;
	border:2px solid #999;
}
.textholder {
	text-align:left;
	font-size:small;
	padding:6px;
	-moz-border-radius: 6px 6px 0 0;
	-webkit-border-top-left-radius: 6px;	
	-webkit-border-top-right-radius: 6px;
}
</style>

</head>

<body>
<div id="carousel1">
	<ul>
		<li>
		<img alt="" src='<c:url value="/resources/graphics/caroussel/img-11.jpg"/>' width="400" height="250" /><p>This carousel 
		has padding applied to it so you can see hints for the previous and 
		next images.</p>
		</li>
		<li>

		<img alt="" src='<c:url value="/resources/graphics/caroussel/img-12.jpg"/>' width="400" height="250" /><p>Many of the images used in the demos come from
		<a href="#">Mike Swanson's excellent wallpaper images</a> page.</p>
		</li>
		<li>
		<img alt="" src='<c:url value="/resources/graphics/caroussel/img-13.jpg"/>' width="400" height="250" /></li>
		<li>
		<img alt="" src='<c:url value="/resources/graphics/caroussel/img-14.jpg"/>' width="400" height="250" /><p>The images to the left and right of this one have no caption.</p>

		</li>
	</ul>
</div>
</body>

</html>
