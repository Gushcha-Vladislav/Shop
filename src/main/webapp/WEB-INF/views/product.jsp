<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 26.02.2018
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="head.jsp"/>
<script src="/resources/js/product.js"></script>
<link rel="stylesheet" href="/resources/css/product.css">
<script src="/resources/js/productPage.js"></script>
<div class="container">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-9">
            <div class="breadcrumb">
                <li><a href="/catalog">Home</a></li>
                <li><a >${product.category.nameCategory}</a></li>
                <li><a href="/catalog/${product.id}">${product.nameProduct}</a></li>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
            <%--<c:import url="filterCategory.jsp"/>--%>
        </div>
        <div class="container col-sm-9">
            <div class="row">
                <div class="col-xs-12 text-center">
                    <h4 class="text-center titleName" id="name">${product.nameProduct}</h4>
                </div>
                <div class="col-sm-6">
                    <img src="/resources/${product.image}" alt="" class="img-responsive">
                </div>
                <div class="col-sm-6 row">
                    <sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ANONYMOUS')">
                    <div class="param" id="id">${product.id}</div>
                    <div class="param" id="image">${product.image}</div>
                    <div class="col-xs-12">Brand : ${product.brand}</div>
                    <div class="col-xs-12">Property : ${product.property}</div>
                    <div class="col-xs-12 pull-left">Price: <div id="priceProduct">${product.price}</div></div>
                    <div class="col-xs-12 pull-left">Quantity in stock: <div id="quantity">${product.quantityInStock}</div> </div>
                    <div class="col-xs-12">Ingredients : ${product.description}</div>
                    <div class="col-xs-12">
                        <button class="btn btn-success" data-toggle="modal" type="modal" data-target="#addToCart">
                            Add to basket
                        </button>
                    </div>
                    <a class="btn" id="vk"><i class="fab fa-vk fa-3x"></i></a>
                    <a class="btn" id="fb"><i class="fab fa-facebook fa-3x"></i></a>
                    <a class="btn" id="mailRu"><i class="fas fa-at fa-3x"></i></a>
                    <a class="btn" id="ok"><i class="fab fa-odnoklassniki-square fa-3x"></i></a>
                    <a class="btn" id="twitter"><i class="fab fa-twitter-square fa-3x"></i></a>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <form:form  action="/admin/catalog/change" method="POST" modelAttribute="productDto">
                         <input class="param" name="id" value="${product.id}"/>
                         <div class="form-group">
                            <label for="nameProduct" class="cols-sm-2 control-label">Name product *</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fas fa-cart-plus"></i></span>
                                    <input type="text" class="form-control required" name="nameProduct" id="nameProduct"
                                           value="${product.nameProduct}" maxlength="25" minlength="3"/>
                                    <h4><form:errors path="nameProduct" cssClass="error" /></h4>
                                </div>
                            </div>
                         </div>
                        <div class="form-group">
                            <label for="price" class="cols-sm-2 control-label">Price *</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fas fa-ruble-sign"></i></span>
                                    <input type="number" class="form-control required" name="price" id="price"
                                           placeholder="Enter price" min="1" value="${product.price}"/>
                                </div>
                                <h4><form:errors path="price" cssClass="error" /></h4>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="category" class="cols-sm-2 control-label">Category *</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fas fa-list-ul"></i></span>
                                    <select class="sort pull-right" id="category" name="idCategory">
                                        <c:forEach var="category" items="${categories}">
                                            <option value="${category.id}"
                                                    <c:if test="${product.category.nameCategory eq category.nameCategory}">
                                                        selected
                                                    </c:if>
                                            >${category.nameCategory}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <h4><form:errors path="idCategory" cssClass="error" /></h4>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="brand" class="cols-sm-2 control-label">Brand</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fas fa-sign"></i></span>
                                    <input type="text" class="form-control" name="brand" id="brand" placeholder="Enter brand"
                                           maxlength="40" value="${product.brand}"/>
                                </div>
                                <h4><form:errors path="brand" cssClass="error" /></h4>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="property" class="cols-sm-2 control-label">Property *</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fas fa-weight"></i></span>
                                    <input type="text" class="form-control required" name="property" id="property" placeholder="Enter property"
                                           maxlength="10" minlength="3"  value="${product.property}"/>
                                </div>
                                <h4><form:errors path="property" cssClass="error" /></h4>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="cols-sm-2 control-label">Description *</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fas fa-weight"></i></span>
                                    <textarea type="text" class="form-control required" name="description" id="description"
                                              placeholder="Enter description">${product.description}</textarea>
                                </div>
                                <h4><form:errors path="description" cssClass="error" /></h4>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="quantityInStock" class="cols-sm-2 control-label">Quantity in stock *</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fab fa-stack-overflow"></i></span>
                                    <input type="number" class="form-control required" name="quantityInStock" id="quantityInStock"
                                           placeholder="Enter description" min="0" value="${product.quantityInStock}"/>
                                </div>
                                <h4><form:errors path="quantityInStock" cssClass="error" /></h4>
                            </div>
                        </div>
                        <div class="form-group ">
                            <input type="submit" id="register" value="Change"
                                   class="btn btn-primary btn-lg btn-block login-button">
                        </div>
                        </form:form>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</div>
<sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ANONYMOUS')">
<div class="modal fade" id="addToCart">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal" id="closeModal"><i class="fas fa-times"></i></button>
                <h4 class="text-center titleName">Product purchase</h4>
            </div>
            <div class="modal-body">
                <div class="item-amount row">
                    <div class="col-xs-5 col-sm-12 pay"><h4 class="btn-cart">Choose amount:</h4></div>
                    <div class="col-sm-4 col-xs-5 amount-button  pay">
                        <button type="button" class="button-less" id="button-less"><i class="fa fa-minus"></i></button>
                        <input type="number" id="amount-number" name="amount" class="amount-number" value="0" disabled>
                        <button type="button" class="button-more" id="button-more"><i class="fa fa-plus"></i></button>
                    </div>
                    <div class="col-sm-4 col-xs-5  pay">Цена :
                        <h4 class="btn-cart" id="totalPrice">0</h4></div>
                    <div class="col-sm-4  col-xs-5 pay text-center">
                        <a class="btn btn-success btn-cart" type="button" id="addToBasket">Add to bag</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</sec:authorize>
<c:import url="footer.jsp"/>