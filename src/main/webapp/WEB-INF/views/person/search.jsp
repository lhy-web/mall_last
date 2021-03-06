<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <title>个人信息-我的订单</title>
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/android-desktop.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Material Design Lite">
    <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#3372DF">
    <link rel="shortcut icon" href="images/favicon.png">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="https://cdn.bootcss.com/material-design-lite/1.3.0/material.cyan-light_blue.min.css" rel="stylesheet">
    <%-- <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/infostyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/person/list.js"></script>
    <script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sweetalert.css">
    <script src="${pageContext.request.contextPath}/js/distpicker.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.raty.js"></script>
    <style>
        #view-source {
            position: fixed;
            display: block;
            right: 0;
            bottom: 0;
            margin-right: 40px;
            margin-bottom: 40px;
            z-index: 900;
        }

        .templatemo-blue-button {
            background-color: #39ADB4;
            border: none;
            color: white;
        }

        .no-border {
            border: 0px solid transparent !important;
        }

        .bs-example {
            position: relative;
            padding: 45px 15px 15px;
            margin: 0 -15px 15px;
            border-color: #e5e5e5 #eee #eee;
            border-style: solid;
            border-width: 1px 0;
            -webkit-box-shadow: inset 0 3px 6px rgba(0, 0, 0, .05);
            box-shadow: inset 0 3px 6px rgba(0, 0, 0, .05);
        }

        .finish-btn {
            background-color: #e65b0e !important;
        }

        .font-color {
            color: #00BBD6;
        !important;
        }
    </style>
</head>
<body>

<%--修改商品信息模态框--%>
<!-- Modal -->
<div class="modal fade" id="evaluate" tabindex="-1" role="dialog" aria-labelledby="myModalLabelPsw">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabelPsw">商品评价</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="updatePsw-form" name="update-form" method="post">
                    <div class="form-group">
                        <label for="star" class="col-sm-2 control-label">商品评分</label>
                        <div class="col-sm-9">
                            <div id="star" data-num="3.5"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description" class="col-sm-2 control-label">详细描述</label>
                        <div class="col-sm-9">
                            <textarea class="form-control" rows="3" id="description"></textarea>
                        </div>
                    </div>


                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveEvaluate">保存</button>
            </div>
        </div>
    </div>
</div>

<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title">订单管理</span>
            <div class="mdl-layout-spacer">


                           <a href="${pageContext.request.contextPath}/info/list/send">未发货</a>
                               <a href="${pageContext.request.contextPath}/info/list/receive">待收货</a>
                              <a href="${pageContext.request.contextPath}/info/list/complete">已完成</a>


            </div>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                <form class="navbar-form navbar-right" role="search" method="get"
                    action="${pageContext.request.contextPath}/info/search">
                  <div class="form-group">
                      <input type="text" class="form-control" placeholder="Search" name="keyword">
                  </div>
                  <button type="submit" class="btn btn-default">
                      <span class="glyphicon glyphicon-search" aria-label="搜索"></span>
                  </button>
              </form>
            </div>
        </div>
    </header>
    <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
        <header class="demo-drawer-header">
            <div class="demo-avatar-dropdown">
                <h1>山科商城</h1>
                <div class="mdl-layout-spacer"></div>
            </div>
        </header>
        <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/main"><i
                    class="mdl-color-text--blue-grey-400 material-icons" role="presentation">home</i>主页</a>
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/information"><i
                    class="mdl-color-text--blue-grey-400 material-icons" role="presentation">inbox</i>个人信息</a>
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/info/list/send"><i
                    class="mdl-color-text--blue-grey-400 material-icons" role="presentation">forum</i>订单管理</a>
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/info/address"><i
                    class="mdl-color-text--blue-grey-400 material-icons" role="presentation">local_offer</i>地址管理</a>
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/info/favorite"><i
                    class="mdl-color-text--blue-grey-400 material-icons" role="presentation">flag</i>我的收藏</a>
        </nav>
    </div>


    <main class="mdl-layout__content mdl-color--grey-100">
        <div class="mdl-grid demo-content" id="parent">
            <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
                <c:forEach items="${orderList.list}" var="order">

                        <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid"
                             name="parent">
                            <div class="tab-content col-lg-12">
                                <table class="table " cellpadding="6" cellspacing="1"><%--订单信息--%>
                                    <tbody>
                                    <td class="no-border col-lg-9">
                                        订单号：<i name="orderid">${order.id}</i>
                                        &nbsp;
                                        &nbsp;
                                        订单日期:
                                            ${order.orderTime.year+1900} 年
                                            ${order.orderTime.month+1} 月
                                            ${order.orderTime.date} 日
                                        &nbsp;
                                        收货地址:
                                            ${order.address.province}
                                            ${order.address.city}
                                            ${order.address.county}
                                    </td>
                                        <%--<td class="no-border col-lg-7">
                                            订单日期:
                                                ${order.ordertime.year+1900} 年
                                                ${order.ordertime.month+1} 月
                                                ${order.ordertime.date} 日
                                            &nbsp;
                                            收货地址:
                                                ${order.address.province}
                                                ${order.address.city}
                                                ${order.address.county}
                                        </td>--%>
                                    <td class="no-border col-lg-3">
                                        原价:${order.oldPrice} 现价:${order.newPrice}
                                    </td>
                                    </tbody>
                                </table>
                                <table class="table " cellpadding="6" cellspacing="1"><%--商品描述--%>
                                    <tbody>
                                    <tr>
                                        <td class="col-lg-1">
                                            商品号
                                        </td>
                                        <td class="col-lg-2">
                                            商品名称
                                        </td>
                                        <td class="col-lg-1">
                                            价格
                                        </td>
                                        <td class="col-lg-1">
                                            数量
                                        </td>
                                        <td class="col-lg-2">
                                            商品分类
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <c:forEach items="${order.orderItems}" var="orderItem">
                                    <table class="table table-bordered" cellpadding="6" cellspacing="1"><%--商品信息--%>

                                        <tbody>
                                        <tr>
                                            <td class="col-lg-1">
                                                    ${orderItem.goods.id}
                                            </td>
                                            <td class="col-lg-2">
                                                <a href="${pageContext.request.contextPath}/detail?goodsid=${orderItem.goods.id}">${orderItem.goods.goodsName}</a>
                                            </td>
                                            <td class="col-lg-1">
                                                    ${orderItem.goods.price}
                                            </td>
                                            <td class="col-lg-1">
                                                    ${orderItem.goods.num}
                                            </td>
                                            <td class="col-lg-2">
                                                    ${orderItem.goods.categoryName}
                                            </td>
                                            <c:if test="${order.isComplete}">
                                            <td class="col-lg-1">
                                                <button class="mdl-button mdl-js-button mdl-js-ripple-effect font-color"
                                                        name="evaluate"><h5>评价</h5></button>
                                            </td>
                                            </c:if>
                                        </tr>
                                        </tbody>
                                    </table>
                                </c:forEach>
                            </div>
                            <div class="mdl-card__actions mdl-card--border">
                            </div>
                            <c:if test="${order.isSend && !order.isReceive &&!order.isComplete}">
                            <div class="mdl-card__actions mdl-card--border">
                                <button class="templatemo-blue-button " name="finishList"><h5>完成订单</h5></button>
                            </div>
                        </div></c:if>
                    <c:if test="${order.isComplete}">
                    <div class="mdl-card__actions mdl-card--border">
                        <button class="templatemo-blue-button finish-btn" name="deleteList"><h5>删除订单</h5>
                        </button>
                    </div>
                    </c:if>


                </c:forEach>

            </div>
        </div>
    </main>
        <div class="row page-div">
            <div class="col-md-5 page-info">
                当前第${orderList.pageNum}页，共${orderList.pages}页，总共${orderList.size}条记录
            </div>
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination pagination-lg">

                        <c:if test="${orderList.hasPreviousPage}">
                            <li>
                                <a href="${pageContext.request.contextPath}/search?keyword=${keyword}&page=${orderList.prePage}"
                                   aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${!orderList.hasPreviousPage}">
                            <li class="disabled">
                                <a href="${pageContext.request.contextPath}/search?keyword=${keyword}&page=${orderList.prePage}"
                                   aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach items="${orderList.navigatepageNums}" var="pageNums">
                            <c:if test="${pageNums == orderList.pageNum}">
                                <li class="active">
                                        <a href="${pageContext.request.contextPath}/info/search?keyword=${keyword}&page=${pageNums}">${pageNums}</a>
                                </li>
                            </c:if>
                            <c:if test="${pageNums != orderList.pageNum}">
                                <li>

                                        <a href="${pageContext.request.contextPath}/info/search?keyword=${keyword}&page=${pageNums}">${pageNums}</a>


                                </li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${orderList.hasNextPage}">
                            <li>

                                    <a href="${pageContext.request.contextPath}/info/search?keyword=${keyword}&page=${orderList.nextPage}"
                                       aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>

                            </li>
                        </c:if>

                        <c:if test="${!orderList.hasNextPage}">
                            <li class="disabled">

                                    <a href="${pageContext.request.contextPath}/info/search?keyword=${keyword}&page=${orderList.nextPage}"
                                       aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>


                            </li>
                        </c:if>

                    </ul>
                </nav>
            </div>
        </div>

</div>

<%--<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>--%>
<script src="https://cdn.bootcss.com/material-design-lite/1.3.0/material.min.js"></script>
</body>
</html>
