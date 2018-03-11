<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 11.03.2018
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="logInEmail" class="cols-sm-2 control-label">Your email</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
            <input type="text" class="form-control" name="email" id="logInEmail"
                   placeholder="Enter your Email" required maxlength="45"
                   pattern="[-._a-z0-9]+@(?:[a-z0-9][-a-z0-9]+\.)+[a-z]{2,6}"/>
        </div>
    </div>
</div>
<div class="form-group">
    <label for="logInPassword" class="cols-sm-2 control-label">Your password</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon">
                <i class="fa fa-lock fa-lg" aria-hidden="true"></i>
            </span>
            <input type="password" class="form-control" name="password"
                   id="logInPassword" placeholder="Enter your Password"/>
        </div>
    </div>
</div>