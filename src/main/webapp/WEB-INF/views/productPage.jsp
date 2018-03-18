<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 01.03.2018
  Time: 6:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach var="product" items="${products}">
    <div class="col-xs-6 col-sm-4">
        <div class="thumbnail">
            <div class="caption text-center">
                <h5><a href="/catalog/${product.id}" >${product.nameProduct}</a></h5>
            </div>
            <img class="img-responsive" src="/resources/${product.image}"  alt="">
                <div class="caption">
                    <p>Цена : ${product.price}</p>
                    <button class="btn btn-success" data-toggle="modal" type="modal" data-target="#addToCart">Pay</button>
                </div>
        </div>
    </div>
</c:forEach>
