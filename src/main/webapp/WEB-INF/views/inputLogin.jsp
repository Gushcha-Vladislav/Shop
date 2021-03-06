
<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 11.03.2018
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="form-group">
    <label for="email" class="cols-sm-2 control-label">Email *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
            <input type="text" class="form-control required" name="email" id="email"
                   placeholder="Enter email" maxlength="45"
                   pattern="[-._a-z0-9]+@(?:[a-z0-9][-a-z0-9]+\.)+[a-z]{2,6}"/>
        </div>
        <span class="errorSpan"><form:errors path="email" cssClass="error" /></span>
    </div>
</div>
<div class="form-group">
    <label for="password" class="cols-sm-2 control-label">Password *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon">
                <i class="fa fa-lock fa-lg" aria-hidden="true"></i>
            </span>
            <input type="password" class="form-control required" name="password"
                   id="password" placeholder="Enter password"/>
        </div>
        <span class="errorSpan"><form:errors path="password" cssClass="error" /></span>
    </div>
</div>