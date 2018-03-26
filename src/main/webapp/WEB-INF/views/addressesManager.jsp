<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 05.03.2018
  Time: 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp"/>
<link rel="stylesheet" href="/resources/css/input.css">
<script src="/resources/js/address.js"></script>
<div class="container">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-9">
            <div class="breadcrumb">
                <li><a href="/catalog">Home</a></li>
                <li><a href="/account">User Name</a></li>
                <li><a href="/account/addresses">Address manager</a></li>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
            <%--<c:import url="category.jsp"/>--%>
        </div>
        <div class="container col-sm-9">
            <div class="row">
                <div class="container-fluid">
                    <div class="row ">
                        <div class="col-xs-12">
                            <h2 class="text-center">
                                Address manager
                            </h2>
                        </div>
                        <div class="col-xs-12" id="addressList">
                            <c:import url="addressItem.jsp"/>
                        </div>
                        <div class="col-xs-12">
                            <a class="btn btn-success btn-block" href="/account/formAddress">Add address</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>
