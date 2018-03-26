<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 26.03.2018
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/resources/css/input.css">
<c:import url="head.jsp"/>
<script src="/webjars/jquery-maskedinput/1.4.0/jquery.maskedinput.min.js"></script>
<script src="/resources/js/signUp.js"></script>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-8">
            <div class="breadcrumb">
                <li><a href="/catalog">Home</a></li>
                <li id="breadCrumb"><a href="/signUp">Authentication</a></li>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
            <%--категории--%>
        </div>
        <div class="col-sm-8">
            <div class="row ">
                <div class="col-sm-12"> <h4>Add new address</h4></div>
                <div class="col-sm-12 main-center">
                    <form:form  id="signUp" method="POST" action="${pageContext.request.contextPath}/account/addresses" modelAttribute="address">
                        <c:import url="inputAddress.jsp"/>
                        <div class="form-group ">
                            <input type="submit" id="register" value="AddNewAddress"
                                   class="btn btn-primary btn-lg btn-block login-button">
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>

