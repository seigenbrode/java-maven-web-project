<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
