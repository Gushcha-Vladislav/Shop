<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 05.03.2018
  Time: 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="address" items="${user.addresses}">
    <div class="form-group">
        <div class="cols-sm-9">
            <div class="input-group">
                <input type="number" class="param" value="${address.id}"/>
                <input type="text" class="form-control"
                       value="${address.country} ${address.city} ( ${address.postcode} ) ${address.street} ${address.house} ${address.apartment}"
                       disabled/>
                <a  class="input-group-addon deleteItem"><i
                        class="fas fa-trash-alt"></i></a>
            </div>
        </div>
    </div>
</c:forEach>
