<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 26.02.2018
  Time: 4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <%--<noscript>--%>
        <%--<style>html{display:none;}</style>--%>
        <%--<meta http-equiv="refresh" content="0.0;url=/javascript/disabled">--%>
    <%--</noscript>--%>
    <script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <link href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/webjars/font-awesome/4.7.0/css/font-awesome.min.css"  rel="stylesheet"/>
    <script src="/resources/js/fontawesome-all.min.js"></script>
    <link href="/resources/css/head.css" rel="stylesheet"/>
    <script src="/resources/js/head.js"></script>
</head>
<body>
<div class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="row menu">
            <div class="col-xs-2">
                <sec:authorize access="hasRole('ROLE_ANONYMOUS') or hasRole('ROLE_USER')">
                    <a class="text-left logo" href="/catalog">SchoolShop</a>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <a class="text-left" href="/admin/order">
                        <i class="fas fa-people-carry fa-lg menu-icon fa-fw"></i>Orders</a>
                </sec:authorize>
            </div>
            <div class="col-xs-3 dropdown text-center">
                <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="menu-icon fas fa-user fa-lg"></i>Profile<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/login">Sign In</a></li>
                        <li><a href="/signUp">Sign Up</a></li>
                    </ul>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown"><i
                            class="menu-icon fas fa-user fa-lg"></i>${nameUser}<b
                            class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/account">Profile</a></li>
                        <li class="divider"></li>
                        <li><a href="/account/password">Update password</a></li>
                        <li><a href="/account/addresses">Update addresses</a></li>
                        <li><a href="/account/order">History orders</a></li>
                        <li class="divider"></li>
                        <li><a href="/j_spring_security_logout">Log out</a></li>
                    </ul>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="menu-icon fas fa-user fa-lg"></i>${nameUser}
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/account">Profile</a></li>
                        <li class="divider"></li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_SUPER_ADMIN')">
                            <li><a href="/superAdmin/manager">List admins</a></li>
                            <li class="divider"></li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li><a href="/admin/order">Orders</a></li>
                        <li><a href="/admin/statistics">Statistics</a></li>
                        <li class="divider"></li>
                        <li><a href="/j_spring_security_logout">Log out</a></li>
                    </ul>
                </sec:authorize>
            </div>
            <sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ANONYMOUS')">
                <div class="col-xs-3 text-center">
                    <a href="/order"><i class="fab fa-amazon-pay fa-lg menu-icon fa-fw"></i>Order</a></div>
                <div class="col-xs-3 text-center">
                    <a id ="buttonBasketProducts" data-toggle="modal" type="modal" data-target="#basketProducts">
                        <i class="fas fa-shopping-basket fa-lg menu-icon fa-fw"></i>Basket
                        <span class="badge" id="countProductInBasket"></span>
                    </a>
                </div>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <div class="col-xs-2 dropdown text-center">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fas fa-archive fa-lg menu-icon fa-fw"></i>
                        Product<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/admin/product">Add product</a></li>
                        <li><a href="/admin/catalog">Change products</a></li>
                    </ul>
                </div>
                <div class="col-xs-2 dropdown text-center">
                    <a href="/admin/categories" ><i class="fas fa-list  fa-lg menu-icon fa-fw" ></i>Category</a>
                </div>
                <div class="col-xs-2 dropdown text-center">
                    <a href="/admin/statistics">
                        <i class="fas fa-table fa-lg menu-icon fa-fw"></i>Statistics</a>
                </div>
            </sec:authorize>
        </div>
    </div>
</div>
<sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ANONYMOUS')">
    <div class="modal fade" id="basketProducts">

    </div>
    <c:import url="slider.jsp"/>
    <br>
</sec:authorize>