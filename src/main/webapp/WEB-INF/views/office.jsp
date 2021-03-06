<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 05.03.2018
  Time: 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:import url="head.jsp"/>
<script src="/resources/js/formUser.js"></script>
<script src="/resources/js/account.js"></script>
<div class="container">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-9">
            <div class="breadcrumb">
                <li><a href="/account">Profile</a></li>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
            <%--<c:import url="filterCategory.jsp"/>--%>
        </div>
        <div class="container col-sm-9">
            <div class="row ">
                <div class="col-xs-12"><h2 class="text-center titleName">Profile</h2></div>
                <div class="col-sm-12">
                    <form:form  action="/account/change" modelAttribute="user" method="POST">
                        <div class="col-sm-6 col-sm-offset-3">
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">Your name</label>
                                <div class="cols-sm-9">
                                    <div class="input-group account">
                                        <span class="input-group-addon"><i class="fa fa-user fa"></i></span>
                                        <input type="text" class="form-control" name="nameUser" id="name" value="${user.nameUser}"
                                               disabled required maxlength="20"/>
                                        <a class="input-group-addon  changeUser">
                                            <i class="fas fa-pencil-alt"></i>
                                        </a>
                                    </div>
                                    <h4><form:errors path="nameUser" cssClass="error" /></h4>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastName" class="cols-sm-2 control-label">Your last name</label>
                                <div class="cols-sm-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-users fa"></i></span>
                                        <input type="text" class="form-control" id="lastName"  name="lastNameUser"
                                               value="${user.lastNameUser}" disabled maxlength="20"/>
                                        <a class="input-group-addon  changeUser">
                                            <i class="fas fa-pencil-alt"></i>
                                        </a>
                                        <h4><form:errors path="lastNameUser" cssClass="error" /></h4>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="cols-sm-2 control-label">Your Email</label>
                                <div class="cols-sm-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-envelope fa"></i></span>
                                        <input type="text" class="form-control" id="email" value="${user.email}" disabled/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="birthday" class="cols-sm-2 control-label">Your birthday</label>
                                <div class="cols-sm-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fas fa-birthday-cake"></i></span>
                                        <input type="date" class="form-control" id="birthday" value="${user.birthday}" disabled/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="phone" class="cols-sm-2 control-label">Your phone</label>
                                <div class="cols-sm-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fas fa-phone"></i></span>
                                        <input type="text" class="form-control" id="phone" value="${user.phone}"
                                               maxlength="20"   name="phone" disabled/>
                                        <a class="input-group-addon  changeUser"><i class="fas fa-pencil-alt"></i></a>
                                        <h4><form:errors path="lastNameUser" cssClass="error" /></h4>
                                    </div>
                                </div>
                            </div>
                            <sec:authorize access="hasRole('ROLE_USER')">
                            <div class="form-group">
                                <label for="birthday" class="cols-sm-2 control-label">Your addresses</label>
                                <div class="cols-sm-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fas fa-list"></i></span>
                                        <select class="form-control" id="addresses">
                                            <c:forEach var="address" items="${user.addresses}">
                                                <option value="${address.id}">${address.country},&nbsp;${address.city},&&nbsp;${address.street},&nbsp;${address.house}</option>
                                            </c:forEach>
                                            <option value="newAddress">Add new Address</option>
                                        </select>
                                        <a class="input-group-addon" href="/account/addresses"><i
                                                class="fas fa-pencil-alt"></i></a>
                                    </div>
                                </div>
                            </div>
                            </sec:authorize>
                            <div class="form-group">
                                <label class="cols-sm-2 control-label"></label>
                                <div class="cols-sm-9">
                                    <button type="submit" class="btn btn-success btn-block" id="saveChange">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>

