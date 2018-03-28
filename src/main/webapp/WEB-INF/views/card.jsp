<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 28.03.2018
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/resources/css/card.css">
<div class="container-fluid">
    <div class="row">
        <div class="container-cards">
            <div class="container-card container-card-front">
                <div class="card-front">
                    <label class="card-front-label" for="numberCard">Card number </label>
                    <input class="card-front-input" type="text" name="CARD" id="numberCard" maxlength="19"  required placeholder="1234 5678 9876 5432">

                    <label class="card-front-label" for="cardholder">Name on card </label>
                    <input class="card-front-input" id="cardholder" name="CARDHOLDER" type="text" style="text-transform:uppercase"  required pattern="[A-Za-z]* [A-Za-z]*" maxlength="26" placeholder="IVAN IVANOV">
                    <div>
                        <label class="card-front-label" for="exp">Valid thru: </label>
                        <div class="card-front-select">
                            <input id="exp" type="text"  required pattern="([0-2][1-9]|10|20|30|31)" name="EXP" maxlength="2">
                            <span>/</span>
                            <input id="exp-year" type="text"  required pattern="([0-9][0-9])" name="EXP_YEAR" maxlength="2">
                        </div>
                    </div>

                    <div class="card-front-logo">
                        <img class="card-type mastercard" src="resources/image/card/master.png">
                        <img class="card-type maestro" src="resources/image/card/maestro.png">
                        <img class="card-type visa" src="resources/image/card/visa.png">
                        <img class="card-type mir" src="resources/image/card/mir.png">
                    </div>
                </div>
            </div>
            <div class="container-card container-card-back">
                <div class="card-back">
                    <div class="card-back-stripe"></div>
                    <label for="cvc2" class="card-back-label">CVV2</label>
                    <div class="card-back-code">
                        <input id="cvc2" name="cvc2" type="password"  pattern="[0-9]{3}"  maxlength="3" placeholder="•••"  required>
                    </div>
                </div>
            </div>
        </div>
        <div><a class="btn btn-success payCard">Pay</a></div>
    </div>
</div>
