<%--
  Created by IntelliJ IDEA.
  User: gusch
  Date: 11.03.2018
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-sm-6">
        <div class="form-group">
            <label for="country" class="cols-sm-2 control-label">Your country</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fas fa-globe"></i></span>
                    <input type="text" class="form-control required" name="country" id="country"
                           placeholder="Enter your country" required maxlength="45"/>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="form-group">
            <label for="city" class="cols-sm-2 control-label">Your city</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fas fa-university"></i></span>
                    <input type="text" class="form-control required" name="city" id="city"
                           placeholder="Enter your city" maxlength="45"  minlength="5"  required/>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="form-group">
            <label for="postcode" class="cols-sm-2 control-label">Your postcode</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon"><i class="far fa-envelope"></i></span>
                    <input type="text" class="form-control" name="postcode" id="postcode"
                           placeholder="Enter your postcode" minlength="6"  maxlength="10"/>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="form-group">
            <label for="street" class="cols-sm-2 control-label">Your street</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fas fa-road"></i></span>
                    <input type="text" class="form-control required" name="street" id="street" placeholder="Enter your street"
                           maxlength="45" minlength="5"  required/>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="form-group">
            <label for="house" class="cols-sm-2 control-label">Your house</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fas fa-home"></i></span>
                    <input type="text" class="form-control required" name="house" id="house" placeholder="Enter your house"
                           required maxlength="5" minlength="1" />
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="form-group">
            <label for="apartment" class="cols-sm-2 control-label">Your apartment</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fas fa-bed"></i></span>
                    <input type="text" class="form-control" name="apartment" id="apartment"
                           placeholder="Enter your apartment" minlength="1"  maxlength="5"/>
                </div>
            </div>
        </div>
    </div>
</div>
