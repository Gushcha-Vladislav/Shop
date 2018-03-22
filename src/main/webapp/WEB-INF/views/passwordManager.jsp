<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 05.03.2018
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-9 hidden-xs">
            <div class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li><a href="/account">User Name</a></li>
                <li><a href="/account/password">Change password</a></li>
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
                                Change password
                            </h2>
                        </div>
                        <form action=/account/password" class="text-center"  method="post" >
                            <div class="col-sm-6  col-sm-offset-3">
                                <div class="form-group">
                                    <label for="oldPassword" class="cols-sm-2 control-label">Old password</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i
                                                    class="fas fa-university"></i></span>
                                            <input type="password" class="form-control" name="oldPassword"
                                                   id="oldPassword" placeholder="Enter old password"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-sm-offset-3">
                                <div class="form-group">
                                    <label for="newPassword" class="cols-sm-2 control-label">New password</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i
                                                    class="far fa-envelope"></i></span>
                                            <input type="password" class="form-control" name="newPassword"
                                                   id="newPassword" placeholder="Enter new password"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-sm-offset-3">
                                <div class="form-group">
                                    <input type="submit" id="changePassword" value="Change password"
                                           class="btn btn-primary btn-lg btn-block login-button">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>

