
<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 02.04.2018
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/resources/css/input.css">
<c:import url="head.jsp"/>
<script src="/webjars/jquery-maskedinput/1.4.0/jquery.maskedinput.min.js"></script>
<div class="container">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-9">
            <div class="breadcrumb">
                <li><a href="/catalog">Product</a></li>
                <li id="breadCrumb"><a href="/signUp">Add product</a></li>
            </div>
        </div>
    </div>
    <div class="row ">
        <div class="col-sm-12"> <h4 class="text-center">Add new product</h4></div>
        <div class="col-sm-12">
            <div class="col-sm-offset-3 col-sm-6 main-center">
                <form:form  action="/admin/product" method="POST" enctype="multipart/form-data">
                <c:import url="inputProduct.jsp"/>
                <div class="form-group ">
                    <input type="submit" id="register" value="AddNewProduct"
                           class="btn btn-primary btn-lg btn-block login-button">
                </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>
