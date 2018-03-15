<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 26.02.2018
  Time: 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<link rel="stylesheet" href="../../resource/css/basket.css" >
<script src="../../resource/js/basket.js"></script>
<div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-header">
            <button class="close" type="button" data-dismiss="modal"><i class="fas fa-times"></i></button>
            <h4 class="modal-title text-center">Basket</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <c:forEach var="item" items="${bag}">
                    <div class="col-xs-12 thumbnail">
                        <div>${item.id}</div>
                        <div class="col-sm-5 col-xs-10"><a>${item.nameProduct}</a></div>
                        <div class="col-xs-2 visible-xs text-right"><a><i class="fas fa-times"></i></a></div>
                        <div class="col-sm-3 col-xs-6 ">
                            <div class="number " onselectstart="return false" onmousedown="return false">
                                <a class="minus"><i class="fas fa-times"></i></a>
                                <input type="text" class="basket" value="${item.count}" size="5" disabled/>
                                <a class="plus"><i class="fas fa-times"></i></a>
                            </div>
                        </div>
                        <div class="col-sm-3 col-xs-6"><c:out value="${item.price*item.count}"/></div>
                        <div class="col-sm-1 text-right hidden-xs"><a><i class="fas fa-times"></i></a></div>
                    </div>
                </c:forEach>
                <div class="col-xs-6 text-left">
                    <a href="#" class="btn btn-success ">Order</a>
                </div>
                <div class="col-xs-6 text-right">
                    <a href="#" class="btn btn-success ">Clear</a>
                </div>
            </div>
        </div>
    </div>
</div>


