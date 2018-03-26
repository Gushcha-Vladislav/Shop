<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 18.03.2018
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/resources/css/input.css">
<c:import url="head.jsp"/>
<script src="/resources/js/login.js"></script>
<div class="container">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-9">
            <div class="breadcrumb">
                <li><a href="/catalog">Home</a></li>
                <li id="breadCrumb"><a href="/login">Authentication</a></li>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
            <%--категории--%>
        </div>
        <div class="col-sm-8">
            <div class="row">
                <div class="main-login">
                    <form class="" method="post" action="/addAddress">
                        <div class="col-sm-offset-3 col-sm-6 main-center">
                            <div id="error"></div>
                            <c:import url="inputLogin.jsp"/>
                            <div class="form-group ">
                                <input type="submit" value="Login"
                                       class="btn btn-primary btn-lg btn-block login-button">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>
