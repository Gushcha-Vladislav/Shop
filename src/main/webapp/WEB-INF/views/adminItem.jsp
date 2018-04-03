
<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 29.03.2018
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach var="admin" items="${admins}">
    <div class="col-xs-12 thumbnail">
        <div class="param">${admin.id}</div>
        <h5 class="col-sm-6 pull-left">Name: ${admin.nameUser}</h5>
        <h5 class="col-sm-6 pull-left">Birthday: ${admin.birthday}</h5>
        <h5 class="col-sm-12 pull-left">Email: ${admin.email}</h5>
        <a  class="btn btn-success deleteAdmin">Delete admin</a>
    </div>
</c:forEach>
