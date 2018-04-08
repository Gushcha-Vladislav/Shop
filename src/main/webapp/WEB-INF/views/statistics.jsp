<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 29.03.2018
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp"/>
<link rel="stylesheet" href="/resources/css/statistics.css">
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="breadcrumb">
                <li><a href="/account">${nameUser}</a></li>
                <li><a href="/catalog">Statistics</a></li>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 block">
            <div class="title">Top 10 Products</div>
            <c:forEach var="product" items="${topProducts}" varStatus="status">
                <div class="statistic-item col-lg-12">
                    <div class="top-number">#${status.index + 1}</div>
                    <div class="product col-lg-12">
                        <div class="col-lg-2 image">
                            <img src="/resources/${product.image}" alt="item">
                        </div>
                        <div class="col-lg-10 product-info">
                            <div class="col-lg-8 main-info">
                                <div class="name">
                                    <a href="/catalog/${product.id}">${product.nameProduct}</a>
                                </div>
                                <div class="sales">
                                    Sales: ${product.numberOfSales}
                                </div>
                            </div>
                            <div class="col-lg-4 cost-info">
                                <i class="fas fa-ruble-sign"></i>&nbsp;&nbsp;${product.price}
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="col-lg-4 block">
            <div class="title">Top 5 Users</div>
            <c:forEach var="user" items="${topUsers}" varStatus="status">
                <div class="statistic-item col-lg-12">
                    <div class="top-number">#${status.index + 1}</div>
                    <div class="account-info">
                        <div class="name">
                                ${user.nameUser} ${user.lastNameUser}
                        </div>
                        <div class="email">
                                ${user.email}
                        </div>
                        <div class="birthday">
                                ${user.birthday}
                        </div>
                        <div class="phone">
                                ${user.phone}
                        </div>
                    </div>
                    <div class="account-footer col-lg-12">
                        <div class="total-cash col-lg-7">
                            Total cash: <i class="fas fa-ruble-sign"></i>&nbsp;&nbsp;${user.statisticTopUser.price}
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="col-lg-4 block">
            <div class="title">Income Statistics</div>
            <div class="statistic-item col-lg-12">
                <div class="income income-for-week col-lg-12">
                    <div class="header col-lg-8">
                        For the last week:
                    </div>
                    <div class="amount col-lg-4">
                        <i class="fas fa-ruble-sign"></i>&nbsp;&nbsp;${incomePerWeek}
                    </div>
                </div>
                <div class="income income-for-month col-lg-12">
                    <div class="header col-lg-8">
                        For the last month:
                    </div>
                    <div class="amount col-lg-4">
                        <i class="fas fa-ruble-sign"></i>&nbsp;&nbsp;${incomePerMonth}
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-12">
        <div class="pdf">
            <a href="/admin/statistics/download/pdf" target="_blank" class="btn btn-success">Download PDF</a>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>