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
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-9 hidden-xs">
            <div class="breadcrumb">
                <li><a href="/Home">Home</a></li>
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
                            <buuton class="btn btn-success btn-block" data-toggle="modal" type="modal"
                                    data-target="#addAddress" >Add address</buuton>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="addAddress">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal"><i class="fas fa-times"></i></button>
                <h4 class="modal-title text-center">Add address</h4>
            </div>
            <div class="modal-body">
                <div class="tab-pane fade in" id="checkIn">
                    <div class="main-login main-center">
                        <form class="" method="post" action="/account/addresses">
                            <c:import url="inputAddress.jsp"/>
                            <div class="form-group ">
                                <input type="submit" type="button" id="register"
                                       class="btn btn-primary btn-lg btn-block login-button"
                                       value="AddElement">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>
