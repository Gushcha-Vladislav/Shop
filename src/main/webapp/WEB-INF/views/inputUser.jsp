<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 22.03.2018
  Time: 1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="form-group">
    <label for="nameUser" class="cols-sm-2 control-label">Your Name</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon">
                <i class="fa fa-user fa" aria-hidden="true"></i>
            </span>
            <input type="text" class="form-control required" name="nameUser" id="nameUser"
                   placeholder="Enter your Name" required minlength="3" maxlength="20"/>
        </div>
        <h4><form:errors path="nameUser" cssClass="error" /></h4>
    </div>

</div>
<div class="form-group">
    <label for="lastNameUser" class="cols-sm-2 control-label">Your last
        name</label>
    <div class="cols-sm-10">
        <div class="input-group">
                                <span class="input-group-addon">
                                    <i class="fa fa-users fa" aria-hidden="true"></i>
                                </span>
            <input type="text" class="form-control" name="lastNameUser"
                   id="lastNameUser" placeholder="Enter your lastName" minlength="3"
                   maxlength="20"/>
        </div>
        <h4><form:errors path="lastNameUser" cssClass="error" /></h4>
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
            <input type="date" class="form-control birthday required" name="birthday"
                   id="birthday" placeholder="Enter your birthday"
                   required/>
        </div>
        <h4><form:errors path="birthday" cssClass="error" /></h4>
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
        <h4><form:errors path="phone" cssClass="error" /></h4>
    </div>
</div>
<c:import url="inputLogin.jsp"/>
