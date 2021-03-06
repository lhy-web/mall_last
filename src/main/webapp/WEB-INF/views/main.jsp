<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>山科商城</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sort.js"></script>
    <script src="${pageContext.request.contextPath}/js/holder.js"></script>

    <script>

    </script>
    <style type="text/css">
        .button {
            clear: both;
            margin: 10px auto;
            text-align: center;
            font-size: 20px;
            padding: 10px 0;
            line-height: 25px;
            color: #666;
            border-top: #ddd 1px solid;
        }

        .button a {
            margin: 0 7px;
            color: #666;
        }

        .button a:hover {
            color: #000;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div id="main" class="container">

    <div id="header">
        <%@ include file="header.jsp" %>

        <!-- 旋转图 -->
        <div class="header-bottom">
            <div class="sort">
                <div class="sort-channel">
                    <ul class="sort-channel-list list-group">
                        <c:forEach items="${categories}" var="a">
                            <li class="list-group-item"><a href="${pageContext.request.contextPath}/category?cate=${a.cateName}">${a.cateName}</a>
                        </c:forEach>

                    </ul>
                </div>
            </div>
            <div id="mycarousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/image/4.jpg" alt="">
                    </div>

                    <div class="item">
                        <img src="${pageContext.request.contextPath}/image/3.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/image/5.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/image/6.jpg" alt="">
                    </div>
                </div>

                <ol class="carousel-indicators">
                    <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#mycarousel" data-slide-to="1"></li>
                    <li data-target="#mycarousel" data-slide-to="2"></li>
                    <li data-target="#mycarousel" data-slide-to="3"></li>
                </ol>

                <a class="left carousel-control" href="#mycarousel" role="button"
                   data-slide="prev" style="display: none;"> <span
                        class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a> <a class="right carousel-control" href="#mycarousel" role="button"
                        data-slide="next" style="display: none;"> <span
                    class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
            </div>
            <div class="clear-float"></div>
        </div>
    </div>
    <div class="content">
        <c:if test="${! empty hotGoods}">
            <div class="module">
                <div class="hd">
                    <h2>热销产品</h2>
                    <hr>
                </div>
                <div class="bd">
                    <div class="data">
                        <ul>
                            <c:forEach items="${hotGoods}" var="goods">
                                <li class="data-item-li">
                                    <div class="to-big">
                                        <a href="${pageContext.request.contextPath}/detail?goodsid=${goods.id}"><img
                                                src="${pageContext.request.contextPath}/image/${goods.imagePaths[0].path}"
                                                alt=""
                                                width="200" height="200"/>
                                        </a>
                                    </div>
                                    <p class="text-right">
                                        <a href="${pageContext.request.contextPath}/detail?goodsid=${goods.id}">${goods.goodsName}</a>
                                    </p>
                                    <div class="text-right">
                                        <b>￥${goods.price}</b>
                                    </div>
                                    <div>
                                        <c:if test="${goods.fav}">
                                            <button
                                                    class="like-button glyphicon glyphicon-heart btn btn-default"
                                                    data-id="${goods.id}"
                                                    style="display: none;"></button>
                                        </c:if>
                                        <c:if test="${!goods.fav}">
                                            <button
                                                    class="like-button glyphicon glyphicon-heart-empty btn btn-default"
                                                    data-id="${goods.id}"
                                                    style="display: none;"></button>
                                        </c:if>
                                        <!-- <button class="like-button1 glyphicon glyphicon-heart-empty btn btn-default "></button> -->
                                    </div>
                                </li>
                            </c:forEach>


                            <div class="clear-float" style="clear: both;"></div>
                        </ul>
                    </div>
                </div>
            </div>
        </c:if>
        <c:forEach items="${categories}" var="category">
            <c:if test="${! empty category.goods}">
                <div class="module">
                    <div class="hd">
                        <h2>${category.cateName}</h2>
                        <hr>
                    </div>

                    <div class="bd">
                        <div class="data">
                            <ul>
                                <c:forEach items="${category.goods}" var="goods">
                                    <li class="data-item-li">
                                        <div class="to-big">
                                            <a href="${pageContext.request.contextPath}/detail?goodsid=${goods.id}"><img
                                                    src="${pageContext.request.contextPath}/image/${goods.imagePaths[0].path}"
                                                    alt=""
                                                    width="200" height="200"/>
                                            </a>
                                        </div>
                                        <p class="text-right">
                                            <a href="${pageContext.request.contextPath}/detail?goodsid=${goods.id}">${goods.goodsName}</a>
                                        </p>
                                        <div class="text-right">
                                            <b>￥${goods.price}</b>
                                        </div>
                                        <div>
                                            <c:if test="${goods.fav}">
                                                <button
                                                        class="like-button glyphicon glyphicon-heart btn btn-default"
                                                        data-id="${goods.id}"
                                                        style="display: none;"></button>
                                            </c:if>
                                            <c:if test="${!goods.fav}">
                                                <button
                                                        class="like-button glyphicon glyphicon-heart-empty btn btn-default"
                                                        data-id="${goods.id}"
                                                        style="display: none;"></button>
                                            </c:if>
                                            <!-- <button class="like-button1 glyphicon glyphicon-heart-empty btn btn-default "></button> -->
                                        </div>
                                    </li>
                                </c:forEach>


                                <div class="clear-float" style="clear: both;"></div>
                            </ul>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>


    </div>
</div>
</body>
</html>


