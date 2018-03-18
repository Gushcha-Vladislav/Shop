<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 26.02.2018
  Time: 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/resources/css/category.css">
<div id="accordion" class="panel-group category">
    <c:forEach var="category" items="${categories}">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="btn btn-block btn-success" href="#category<c:out value="${category.id}" />"
                       data-parent="#accordion"
                       data-toggle="collapse">
                            ${category.nameCategory} <i class="fas fa-caret-down"></i></a>
                </h4>
            </div>
            <div id="category<c:out value="${category.id}"/>" class="panel-collapse collapse">
                <div class="category">
                    <c:forEach var="item" items="${category.children}">
                        <c:if test="${item.status eq true}">
                            <a class="btn btn-success btn-block" onclick="">${item.nameCategory}
                                <i class="fas fa-caret-right"></i>
                            </a>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
    </c:forEach>
</div>