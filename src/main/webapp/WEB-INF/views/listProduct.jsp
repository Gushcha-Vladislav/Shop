<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 26.02.2018
  Time: 4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/resources/css/select.css" >
<c:import url="head.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-5 hidden-xs">
            <div class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li id="breadCrumb"><a href="#">All categories</a></li>
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
