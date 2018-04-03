
<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 02.04.2018
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/resources/js/imputProduct.js"></script>
<div class="form-group">
    <div class="image-slider">
        <img id="upload-image param" src="/resources/images/item2.jpg" alt="Item">
    </div>
    <label for="image" class="cols-sm-2 control-label">Image *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-bed"></i></span>
            <input type="file" class="form-control" accept="image/jpeg, image/png, image/gif" name="image" id="image"
                   placeholder="Enter image"/>
        </div>
        <h4><form:errors path="image" cssClass="error" /></h4>
    </div>
</div>
<div class="form-group">
    <label for="nameProduct" class="cols-sm-2 control-label">Name product *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-globe"></i></span>
            <input type="text" class="form-control required" name="nameProduct" id="nameProduct"
                   placeholder="Enter name product" maxlength="45"/>
            <h4><form:errors path="nameProduct" cssClass="error" /></h4>
        </div>
    </div>
</div>
<div class="form-group">
    <label for="category" class="cols-sm-2 control-label">Category *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-university"></i></span>
            <select class="sort pull-right" id="category" name="idCategory">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.nameCategory}</option>
                </c:forEach>
            </select>
        </div>
        <h4><form:errors path="idCategory" cssClass="error" /></h4>
    </div>
</div>
<div class="form-group">
    <label for="price" class="cols-sm-2 control-label">Price *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="far fa-envelope"></i></span>
            <input type="number" class="form-control" name="price" id="price"
                   placeholder="Enter price" minlength="6"  maxlength="10"/>
        </div>
        <h4><form:errors path="price" cssClass="error" /></h4>
    </div>
</div>
<div class="form-group">
    <label for="brand" class="cols-sm-2 control-label">Brand</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-road"></i></span>
            <input type="text" class="form-control required" name="brand" id="brand" placeholder="Enter brand"
                   maxlength="45" minlength="5"/>
        </div>
        <h4><form:errors path="brand" cssClass="error" /></h4>
    </div>
</div>
<div class="form-group">
    <label for="property" class="cols-sm-2 control-label">Property *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-home"></i></span>
            <input type="text" class="form-control required" name="property" id="property" placeholder="Enter property"
                   maxlength="10" minlength="3" />
        </div>
        <h4><form:errors path="property" cssClass="error" /></h4>
    </div>
</div>
<div class="form-group">
    <label for="description" class="cols-sm-2 control-label">Description *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-bed"></i></span>
            <textarea type="text" class="form-control" name="description" id="description"
                      placeholder="Enter description"></textarea>
        </div>
        <h4><form:errors path="description" cssClass="error" /></h4>
    </div>
</div>
<div class="form-group">
    <label for="quantityInStock" class="cols-sm-2 control-label">Quantity in stock *</label>
    <div class="cols-sm-10">
        <div class="input-group">
            <span class="input-group-addon"><i class="fas fa-bed"></i></span>
            <input type="number" class="form-control" name="quantityInStock" id="quantityInStock"
                      placeholder="Enter description"/>
        </div>
        <h4><form:errors path="quantityInStock" cssClass="error" /></h4>
    </div>
</div>