$(document).ready(function () {
    $('.login-button').attr('disabled', 'disabled');
    $(function($){
        $("#phone").mask("+7(999) 999-9999");
        });
    $(".required").change(
        function () {
            if($("#email").val().length >= 3
                && $("#nameUser").val().length >= 3){
                $(".login-button").removeAttr('disabled');
            } else{
                $('.login-button').attr('disabled', 'disabled');
            }
            validEmail();
            validPhone();
        }
    );
    function error(recourse,error){
        if(recourse === false){
            $('.login-button').attr('disabled', 'disabled');
        }
    }
    function validPhone() {
        $.ajax({
            url: '/signUp/phone',
            type: 'POST',
            data: {
                "phone" : $("#phone").val()
            }
        }).
        done(function(recourse) {
            error(recourse,"phone");
            $("#validPhone").html("Error, this email is in the database");
        });
    }
    function validEmail() {
        $.ajax({
            url: '/signUp/email',
            type: 'POST',
            data: {
                "email" : $("#email").val()
            }
        }).
        done(function(recourse) {
            error(recourse,"email");
            $("#validEmail").html("Error, this email is in the database");
        });
    }
});