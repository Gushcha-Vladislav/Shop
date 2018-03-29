<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 11.03.2018
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="country" class="cols-sm-2 control-label">Country *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-globe"></i></span>
            <input type="text" class="form-control required" name="country" id="country"
                   placeholder="Enter country" maxlength="45"/>
            <h4><form:errors path="country" cssClass="error" /></h4>
        </div>
    </div>
</div>
<div class="form-group">
    <label for="city" class="cols-sm-2 control-label">City *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-university"></i></span>
            <input type="text" class="form-control required" name="city" id="city"
                   placeholder="Enter city" maxlength="45"  minlength="5"/>
        </div>
        <h4><form:errors path="city" cssClass="error" /></h4>
    </div>
</div>
<div class="form-group">
    <label for="postcode" class="cols-sm-2 control-label">Postcode</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="far fa-envelope"></i></span>
            <input type="text" class="form-control" name="postcode" id="postcode"
                   placeholder="Enter postcode" minlength="6"  maxlength="10"/>
        </div>
        <h4><form:errors path="postcode" cssClass="error" /></h4>
    </div>
</div>
<div class="form-group">
    <label for="street" class="cols-sm-2 control-label">Street *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-road"></i></span>
            <input type="text" class="form-control required" name="street" id="street" placeholder="Enter street"
                   maxlength="45" minlength="5"/>
        </div>
        <h4><form:errors path="street" cssClass="error" /></h4>
    </div>
</div>
<div class="form-group">
    <label for="house" class="cols-sm-2 control-label">House *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-home"></i></span>
            <input type="text" class="form-control required" name="house" id="house" placeholder="Enter house"
                   maxlength="5" minlength="1" />
        </div>
        <h4><form:errors path="house" cssClass="error" /></h4>
    </div>
</div>
<div class="form-group">
    <label for="apartment" class="cols-sm-2 control-label">Apartment</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-bed"></i></span>
            <input type="text" class="form-control" name="apartment" id="apartment"
                   placeholder="Enter apartment" minlength="1"  maxlength="5"/>
        </div>
        <h4><form:errors path="apartment" cssClass="error" /></h4>
    </div>
</div>
