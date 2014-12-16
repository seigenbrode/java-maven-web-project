<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.box {
	width:1200px;
	margin:0 auto;
}
.box_img {
	width:280px;
}
.dish__wrap {
	
}
.item{
		width:290px;
		float:left;
		margin-right:5px;
	
}

.more {
	margin:0 auto;
	clear:both;
	width:1200px;
	height:60px;
	text-align:center;
	display:block;
	border:1px solid silver;
	margin-top:100px;
	
}
.more a {
	display: inline-block;
margin-top: 2%;
}
a {
	text-decoration: none
}
</style>
</head>
<body>
<div class="box">

<c:forEach items="${foodlist}" var="food">
        <div id="item" class="item">
		
            <div class="dish__wrap">
              <div class="pic">
                <a href="#">
                  <img class="box_img" src="/food/static${food.pic}" alt="${food.dish}" class="img-responsive">
                </a>
               
               
              </div>
              <div class="recipe__title">
                <a class="no_click" href="#">${food.dish}</a>
              </div>
              
            </div>
        </div> 
	</c:forEach>	
		
</div>
<div class="more">
	 <a class="more_a" href="#" onclick="more()">
          查看更多
        </a>
	
	</div>
<script src="/food//static/js/jquery-1.7.1.min.js"></script>

<script>

var page = 1;

function more() {
 page = page + 1;
 var 	html =$.ajax({url:"/food/ajax?page=" + page ,async:false});
  $(".box").append(html.responseText);
}

</script>


</body>
</body>
</html>