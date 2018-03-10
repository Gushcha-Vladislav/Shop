<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 26.02.2018
  Time: 5:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div class="row">
        <div id="carousel" class="carousel slide col-sm-12">
            <ol class="carousel-indicators">
                <li class="active" data-target="#carousel" data-slide-to="0"></li>
                <li data-target="#carousel" data-slide-to="1"></li>
                <li data-target="#carousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img src="../../resource/image/banner1.jpg" alt="">
                </div>
                <div class="item">
                    <img src="../../resource/image/banner2.jpg" alt="">
                </div>
                <div class="item">
                    <img src="../../resource/image/banner3.jpg" alt="">
                </div>
            </div>
            <a href="#carousel" class="left carousel-control icon-slider" data-slide="prev">

            </a>
            <a href="#carousel" class="right carousel-control icon-slider " data-slide="next">

            </a>
        </div>
    </div>
</div>
