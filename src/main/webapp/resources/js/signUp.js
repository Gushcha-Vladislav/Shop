$(document).ready(function () {
    validEmail();
    $(function($){
        $("#phone").mask("+7(999) 999-9999");
        });
    $(".required").keyup(
        function () {
            if($("#email").val().length >= 3 && $("#password").val().length >= 3
            && $("#country").val().length >= 2 && $("#city").val().length >= 2
                && $("#street").val().length >= 2 && $("#house").val().length >= 1
                && $("#nameUser").val().length >= 3){
                $(".login-button").removeAttr('disabled');
            } else{
                $('.login-button').attr('disabled', 'disabled');
            }
            validEmail();
            validPhone();
        }
    )
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
            error(recourse,"phone")
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
            error(recourse,"email")
        });
    }
});