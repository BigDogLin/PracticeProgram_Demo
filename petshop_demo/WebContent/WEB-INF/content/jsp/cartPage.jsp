<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/cartPage.css"/>
</head>
<body>
	<div class="top">
		<div class="nav1">
			<div class="nav2">
				<ul style="float:left;">
					<li><a href="index">首页</a></li>
					<li><a href="#">其它</a></li>
				</ul>
				<ul style="float:right;">
					<li><a href="#"><span class="un">${sessionScope.user.name}</span></a></li>
					<li><a href="logout">账户注销</a></li>
					<li><a href="cart">购物车</a></li>
				</ul>
			</div>
		</div>
		
		<div class="slogan1">
			<div class="slogan2">
				<h1>橘Plus宠物日用店</h1>
				<form class="box" action="search">
					<input type="text" name="goodsKey" placeholder="商品名称"/>
					<button type="submit">搜索商品</button>
				</form>
			</div>
		</div>
	
		<div class="sort1">
			<div class="sort2">
				<ul class="c">
					<li><a href="${pageContext.request.contextPath}/goods?category=all">所有商品</a></li>
					<li><a href="${pageContext.request.contextPath}/goods?category=petfoods">宠物口粮</a></li>
					<li><a href="${pageContext.request.contextPath}/goods?category=petdaily">宠物日用</a></li>
					<li><a href="${pageContext.request.contextPath}/goods?category=pettoys">宠物玩具</a></li>
					<li><a href="${pageContext.request.contextPath}/goods?category=masterfoods">主人零食</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="cartTitle">
		<div class="cartTitle1">
			<div class="cartTitle2">
				<p>购物车：</p>
			</div>
		</div>
	</div>
	
	<div class="cart">
		<c:forEach items="${pageInfo.list}" var="cart">
		<div class="cart1">
			<div class="cart2">
				<ul class="introd">
					<li><img src="${pageContext.request.contextPath}/static/image/${cart.img}.jpg"></li>
					<li><p>${cart.name}</p></li>
					<li><p>${cart.introd}</p></li>
					<li><p>${cart.price}元</p></li>
					<li><p>数量:${cart.quantity}</p></li>
				</ul>
				<ul class="operation">
					<li><a href="#">增加</a></li>
					<li><a href="${pageContext.request.contextPath}/cart/deleteItem?goodsId=${cart.goodsId}">删除</a></li>
				</ul>
			</div>
		</div>
		</c:forEach>
		<div class="page">
				<div class="bar">
					<ul>
						<li class="item-prev"><a href="${pageContext.request.contextPath}/goods?category=${category}&pageNum=${pageInfo.prePage}">上一页</a></li>
						<c:forEach items="${pageInfo.navigatepageNums}" var="nav">
							<c:if test="${nav == pageInfo.pageNum}">
								<li class="item-active"><a href="${pageContext.request.contextPath}/goods?category=${category}&pageNum=${nav}">${nav}</a></li>
							</c:if>
							<c:if test="${nav != pageInfo.pageNum}">
								<li class="item"><a href="${pageContext.request.contextPath}/goods?category=${category}&pageNum=${nav}">${nav}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${pageInfo.navigateLastPage != pageInfo.pages}">
							<li class="item-dot">...</li>
						</c:if>	
						<c:if test="${pageInfo.hasNextPage}">
							<li class="item-next"><a href="${pageContext.request.contextPath}/goods?category=${category}&pageNum=${pageInfo.nextPage}">下一页</a></li>
						</c:if>
						<c:if test="${!pageInfo.hasNextPage}">
							<li class="item-next">下一页</li>
						</c:if>
					 
					</ul>
				</div>
		</div>
	</div>


</body>
</html>