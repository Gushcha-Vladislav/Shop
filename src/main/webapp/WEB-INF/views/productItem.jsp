<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 01.03.2018
  Time: 6:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach var="product" items="${products}">
    <div class="col-xs-6 col-lg-4">
        <div class="thumbnail">
            <div class="caption text-center">
                <h5><a href="/catalog/${product.id}" class="titleLastName">${product.nameProduct}</a></h5>
            </div>
            <input class="param" value="${product.id}">
            <img class="img-responsive" src="/resources/${product.image}"  alt="">
            <div class="caption">
                <p>Price : ${product.price}</p>

                <sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ANONYMOUS')">
                <c:if test="${product.quantityInStock > 0}">
                <a  class="btn btn-success payCatalog" data-toggle="modal" type="modal" data-target="#addToCart"
                        onclick="loadInModal('${product.id}','${product.nameProduct}','${product.price}','${product.image}','${product.quantityInStock}')">Add a item</a>
                </c:if>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="/admin/catalog/${product.id}" class="btn btn-success">Change product</a>
                </sec:authorize>
            </div>
        </div>
    </div>
</c:forEach>
