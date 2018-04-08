<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 04.04.2018
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="head.jsp"/>
<link rel="stylesheet" href="/resources/css/input.css">
<link rel="stylesheet" href="/resources/css/category.css">
<link rel="stylesheet" href="/resources/css/categoryManager.css">
<script src="/resources/js/categoryManager.js"></script>
<div class="container">
    <div class="row">
        <div class=" col-sm-12">
            <div class="breadcrumb">
                <li><a href="/account">${nameUser}</a></li>
                <li><a href="admin/categories">Catigories</a></li>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="col-xs-12">
                <h4 class="text-center titleLastName">
                    List of Categories
                </h4>
            </div>
            <div id="accordion" class="panel-group category">
                <c:forEach var="category" items="${categories}">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <div class="panel-title">
                                <div class="id param">0</div>
                                <div class="dlk-radio btn-group btn-group-justified">
                                    <div class="id param">${category.id}</div>
                                    <label class="btn btn-success status"><input  type="checkbox" <c:if test='${category.status eq true}'> checked</c:if> value="1"></i>
                                    </label>
                                    <a class="btn btn-success categoryChange"  style="width:10%"  href="#category${category.id}"
                                       data-parent="#accordion"
                                       data-toggle="collapse">${category.nameCategory}<i class="fas fa-caret-down"></i></a>
                                </div>
                            </div>
                        </div>
                        <div id="category${category.id}" class="panel-collapse collapse">
                            <div class="category">
                                <div class="id param">${category.id}</div>
                                <c:forEach var="item" items="${category.children}">
                                <div class="dlk-radio btn-group btn-group-justified">
                                    <div class="id param">${item.id}</div>
                                    <label class="btn btn-success status"><input type="checkbox"  <c:if test='${item.status eq true}'> checked</c:if>  value="1"></label>
                                    <a class="btn btn-success categoryChange" style="width : 10%" >${item.nameCategory}<i class="fas fa-caret-right"></i></a>
                                </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <div class="panel-title">
                            <div class="dlk-radio btn-group btn-group-justified">
                                <div class="id param">0</div>
                                <a class="btn btn-success new" >Add new category</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="col-xs-12">
                <h4 class="text-center titleLastName">
                    Change or Add Category
                </h4>
            </div>
            <form:form  id="signUp" method="POST" action="/admin/categories" modelAttribute="category">
                <div class="main-center">
                    <c:import url="inputCategory.jsp"/>
                    <div class="form-group ">
                        <input type="submit" id="register" value="Submit"
                               class="btn btn-primary btn-lg btn-block login-button">
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>
