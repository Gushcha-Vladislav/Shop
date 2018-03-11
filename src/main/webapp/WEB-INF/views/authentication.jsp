<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 26.02.2018
  Time: 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<link rel="stylesheet" href="../../resource/css/input.css" >
<c:import url="head.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-8 ">
            <div class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li id="breadCrumb"><a href="#">Authentication</a></li>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
            <%--//категории--%>
        </div>
        <div class="container col-sm-9">
            <div class="row">
                <div class="container-fluid">
                    <div class="row">
                        <div class="tabs">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#logIn" data-toggle="tab">Log In</a></li>
                                <li><a href="#checkIn" data-toggle="tab">Sign In</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="logIn">
                                    <div class="main-login main-center">
                                        <form class="" method="post" action="/j_spring_security_check">
                                            <c:import url="inputLogin.jsp"/>
                                            <div class="form-group ">
                                                <input type="submit" value="Login"
                                                       class="btn btn-primary btn-lg btn-block login-button">
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <div class="tab-pane fade in" id="checkIn">
                                    <div class="main-login main-center">
                                        <form class="" method="post" action="/signUp">
                                            <div class="form-group">
                                                <label for="name" class="cols-sm-2 control-label">Your Name</label>
                                                <div class="cols-sm-10">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-user fa" aria-hidden="true"></i>
                                                        </span>
                                                        <input type="text" class="form-control" name="name" id="name"
                                                               placeholder="Enter your Name" required maxlength="20"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="username" class="cols-sm-2 control-label">Your last
                                                    name</label>
                                                <div class="cols-sm-10">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-users fa" aria-hidden="true"></i>
                                                        </span>
                                                        <input type="text" class="form-control" name="lastName"
                                                               id="username" placeholder="Enter your lastName"
                                                               maxlength="20"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="birthday" class="cols-sm-2 control-label">Your
                                                    birthday</label>
                                                <div class="cols-sm-10">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="fas fa-birthday-cake" aria-hidden="true"></i>
                                                        </span>
                                                        <input type="date" class="form-control birthday" name="birthday"
                                                               id="birthday" placeholder="Enter your birthday"
                                                               required/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="phone" class="cols-sm-2 control-label">Your phone</label>
                                                <div class="cols-sm-10">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <i class="fas fa-phone" aria-hidden="true"></i>
                                                        </span>
                                                        <input type="tel" class="form-control" name="phone" id="phone"
                                                               placeholder="Enter phone" maxlength="20"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <c:import url="inputLogin.jsp"/>
                                            <c:import url="inputAddress.jsp"/>
                                            <div class="form-group ">
                                                <input type="submit" type="button" id="register" value="Register"
                                                       class="btn btn-primary btn-lg btn-block login-button">
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>