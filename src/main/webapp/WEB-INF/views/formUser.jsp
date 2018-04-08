<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 18.03.2018
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/resources/css/input.css">
<c:import url="head.jsp"/>
<script src="/webjars/jquery-maskedinput/1.4.0/jquery.maskedinput.min.js"></script>
<script src="/resources/js/formUser.js"></script>
<div class="container">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-9">
            <div class="breadcrumb">
                <li><a href="/catalog">Home</a></li>
                <li id="breadCrumb"><a href="/signUp">Registration</a></li>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
            <%--категории--%>
        </div>
        <div class="container col-sm-9">
            <div class="row ">
                <div class="col-sm-12 titleName"><h4>Registration</h4></div>
                <div class="col-sm-12">
                    <form:form  id="signUp" method="POST" action="/signUp" modelAttribute="userDto">
                        <div class="col-sm-offset-3 col-sm-6 main-center">
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
    </div>
</div>
<c:import url="footer.jsp"/>
