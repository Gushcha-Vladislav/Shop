<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 05.03.2018
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:forEach var="order" items="${orders}">
<div  class="col-xs-12 thumbnail">
    <div class="col-sm-4">
        <h4 class="pull-left">Order № ${order.id}</h4>
        <h4 class="pull-left">Date № ${order.dateOrder}</h4>
    </div>
    <div class="col-sm-8 col-xs-12">
        <h4 class="pull-right">${order.address}</h4>
        <h4 class="text-right pull-right">Address: </h4>
    </div>
    <sec:authorize access="hasRole('ROLE_USER')">
        <div class="col-sm-6">
            <h4>Order status: ${order.orderStatus}</h4>
        </div>
        <div class="col-sm-6">
            <h4>Payment status: ${order.delivery}</h4>
        </div>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="col-sm-2 col-xs-6">Id user :${order.user.id}</div>
        <div class="col-sm-5 col-xs-12">
            <label for="orderStatus" class="pull-right">Order status :</label>
            <select class="sort  pull-right" id="orderStatus">
                <option value="AWAITING_PAYMENT"
                        <c:if test="${order.orderStatus eq 'Awaiting payment'}">selected</c:if> >Awaiting
                    payment
                </option>
                <option value="AWAITING_SHIPMENT"
                        <c:if test="${order.orderStatus eq 'Awaiting shipment'}">selected</c:if>>Awaiting
                    shipment
                </option>
                <option value="SHIPPED"
                        <c:if test="${order.orderStatus eq 'Shipped'}">selected</c:if>>Shipped
                </option>
                <option value="DELIVERED"
                        <c:if test="${order.orderStatus eq 'Delivered'}">selected</c:if>>Delivered
                </option>
                <option value="DONE"
                        <c:if test="${order.orderStatus eq 'Done'}">selected</c:if>>Done
                </option>
            </select>
        </div>
        <div class="col-sm-5 col-xs-12">
            <label for="paymentType" class="pull-right">Payment status: </label>
            <select class="sort  pull-right" id="paymentType">
                <option value="AWAITING_PAYMENT"
                        <c:if test="${order.orderStatus eq 'Awaiting payment'}">selected</c:if> >Awaiting
                    payment
                </option>
                <option value="PAID" <c:if test="${order.orderStatus eq 'Paid'}">selected</c:if>>Paid
                </option>
            </select>
        </div>
    </sec:authorize>
    <c:forEach var="itemInOrder" items="${order.products}">
        <div class="col-xs-12 col-sm-4">
            <div class="col-xs-12">
                <a href="/catalog/${itemInOrder.product.id}">${itemInOrder.product.nameProduct}</a>
            </div>
            <div class="col-xs-12">
                <img src="/resources/${itemInOrder.product.image}"
                     class="img-responsive img-circle img-thumbnail">
            </div>
            <div class="col-sm-12">
                <h4 class="pull-right">Amount:&nbsp;&nbsp;</h4>
                <h4 class="pull-right">${itemInOrder.amount}</h4>
            </div>
        </div>
    </c:forEach>
    <sec:authorize access="hasRole('ROLE_USER')">
        <div class="col-xs-6">
            <a href="/order/repeat/${order.id}" class="btn btn-success">Repeat</a>
        </div>
    </sec:authorize>
    <div class="col-xs-6">
        <h4>Total price: ${order.orderPrice}</h4>
    </div>
</div>
</c:forEach>