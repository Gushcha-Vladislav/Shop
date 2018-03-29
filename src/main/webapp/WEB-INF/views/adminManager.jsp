<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 29.03.2018
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/resources/css/input.css">
<c:import url="head.jsp"/>
<script src="/resources/js/adminManager.js"></script>
<script src="/webjars/jquery-maskedinput/1.4.0/jquery.maskedinput.min.js"></script>
<script src="/resources/js/formUser.js"></script>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="breadcrumb">
                <li><a href="/account">Super admin</a></li>
                <li id="breadCrumb"><a href="/superAdmin/manager">List admins</a></li>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6" id="adminList">
            <c:import url="adminItem.jsp"/>
        </div>
        <div class="col-lg-6">
            <form:form  id="signUp" method="POST" action="${pageContext.request.contextPath}/superAdmin/manager" modelAttribute="user">
            <div class="main-center">
                <c:import url="inputUser.jsp"/>
                <div class="form-group ">
                    <input type="submit" id="register" value="Register"
                           class="btn btn-primary btn-lg btn-block login-button">
                </div>
            </div>
            </form:form>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>
