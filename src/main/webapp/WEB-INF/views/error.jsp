<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 15.03.2018
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="head.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-9">
            <div class="breadcrumb">
                <li><a href="#">Message</a></li>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-sm-3">
        </div>
        <div class="container col-sm-9">
            <div class="row">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xs-12">
                            <h1>${message}</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
