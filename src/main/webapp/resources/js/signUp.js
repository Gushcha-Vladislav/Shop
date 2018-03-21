$(document).ready(function () {
    $(function($){
        $("#phone").mask("+7(999) 999-9999");
        });
    $(".required").keyup(
        function () {
            if($("#email").val() > 5 && $("#password").val() > 3 && $("#country").val() > 5
                && $("#city").val() > 5 && $("#street").val() > 5 && $("#house").val() > 5
                && $("#nameUser").val() > 5){
                $(".login-button").removeAttr('disabled');
            } else{
                $('.login-button').attr('disabled', 'disabled');
            }
        }
    )
    $("#email").change(
        function() {
            $.ajax({
                url: '/signUp/email',
                type: 'POST',
                data: {
                    "email" : $("#email").val()
            }
        }).
            done(function(recourse) {
                error(recourse,"phone")
            });
        }
    );
    $("#email").change(
        function() {
            $.ajax({
                url: '/signUp/phone',
                type: 'POST',
                data: {
                    "phone" : $("#phone").val()
                }
            }).
            done(function(recourse) {
                error(recourse,"phone")
            });
        }
    );
    function error(recourse,error){
        if(recourse === false){
            $('.login-button').attr('disabled', 'disabled');
            alert("Error" + error);
        }
    }
});