$(document).ready(function () {
    $('.login-button').attr('disabled', 'disabled');
    $(".required").change(
        function () {
            if($("#house").val().length >= 1 && $("#house").val().length <= 5 &&
                $("#street").val().length >= 3 && $("#street").val().length <= 45 &&
                $("#city").val().length >= 3 && $("#city").val().length <= 45 &&
                $("#country").val().length >= 3 && $("#country").val().length <= 45){
                $(".login-button").removeAttr('disabled');
            } else{
                $('.login-button').attr('disabled', 'disabled');
            }
        }
    );
});