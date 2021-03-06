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
<script src="/resources/js/formAddress.js"></script>
<div class="container">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-9">
            <div class="breadcrumb">
                <li><a href="/account">${nameUser}</a></li>
                <li ><a href="/account/formAddress">Add address</a></li>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
            <%--категории--%>
        </div>
        <div class="container col-sm-9">
            <div class="row ">
                <div class="col-sm-12"> <h4 class="text-center titleName">Add new address</h4></div>
                <div class="col-sm-12">
                    <form:form  id="signUp" method="POST" action="/account/addresses" modelAttribute="address">
                        <div class="col-sm-offset-3 col-sm-6 main-center">
                            <c:import url="inputAddress.jsp"/>
                            <div class="form-group ">
                                <input type="submit" id="register" value="Add address"
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

