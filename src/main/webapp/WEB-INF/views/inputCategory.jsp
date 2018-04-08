<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 04.04.2018
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="nameCategory" class="cols-sm-2 control-label">Category Name *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-camera"></i></span>
            <input type="text" class="form-control" name="nameCategory" id="nameCategory"
                   placeholder="Enter name Category" minlength="3" maxlength="25"/>
        </div>
        <h4><form:errors path="nameCategory" cssClass="error" /></h4>
    </div>
</div>
<div class="form-group">
    <label for="idParent" class="cols-sm-2 control-label">Parent *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-list-ul"></i></span>
            <select class="sort pull-right" id="idParent" name="idParent">
                <option value="0">${category.nameCategory}</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.nameCategory}</option>
                </c:forEach>
            </select>
        </div>
        <h4 id="messageParent"><form:errors path="idParent" cssClass="error" /></h4>
    </div>
</div>
<div class="form-group param">
    <label for="id" class="cols-sm-2 control-label">Id</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fab fa-stack-overflow"></i></span>
            <input type="number" class="form-control required" name="id" id="id"
                   placeholder="Enter description" min="0" value="0"/>
        </div>
    </div>
</div>
