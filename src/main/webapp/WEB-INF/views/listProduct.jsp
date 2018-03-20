<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 26.02.2018
  Time: 4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="head.jsp"/>
<link rel="stylesheet" href="/resources/css/select.css" >
<link rel="stylesheet" href="/resources/css/product.css" >
<script src="/resources/js/catalog.js"></script>
<script src="/resources/js/productPage.js"></script>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-5 hidden-xs">
            <div class="breadcrumb">
                <li><a href="/catalog">Home</a></li>
                <li id="breadCrumb"><a href="/catalog">All categories</a></li>
            </div>
        </div>
        <div class="col-sm-4">
            <select class="sort" id="sortSelect">
                <option value="SortByPriceAscending">По возрастанию цены</option>
                <option value="SortByPriceDescending">По убыванию цены</option>
                <option value="SortByNameAscending">По названию, по алфавиту</option>
                <option value="SortByNameDescending">По названию, против алфавита</option>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
           <c:import url="category.jsp"/>
        </div>
        <div class="container col-sm-9">
            <div class="row">
                <div class="container-fluid">
                    <div class="row" id="listProducts">
                        <c:import url="productPage.jsp"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ANONYMOUS')">
    <div class="modal fade" id="addToCart">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button id="closeModal" class="close" type="button" data-dismiss="modal"><i class="fas fa-times"></i></button>
                    <div class="item-amount row">
                        <div class="col-xs-5 col-sm-12 pay">

                            <h4 class="btn-cart">Choose amount:</h4></div>
                        <div class="col-sm-4 col-xs-5 amount-button  pay">
                            <div  class="param" id="nameProduct"></div>
                            <div  class="param" id="image"></div>
                            <div class="param" id="priceProduct"></div>
                            <div  class="param" id="id"></div>
                            <div class="param" id="quantity"></div>
                            <button type="button" class="button-less" id="button-less"><i class="fa fa-minus"></i></button>
                            <input type="number" id="amount-number" name="amount" class="amount-number" value="0" disabled>
                            <button type="button" class="button-more" id="button-more"><i class="fa fa-plus"></i></button>
                        </div>
                        <div class="col-sm-4 col-xs-5  pay">Price :
                            <h4 class="btn-cart" id="totalPrice">0</h4></div>
                        <div class="col-sm-4  col-xs-5 pay text-center">
                            <a id="addToBasket" class="btn btn-success btn-cart" type="button"
                               >Add to basket</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</sec:authorize>