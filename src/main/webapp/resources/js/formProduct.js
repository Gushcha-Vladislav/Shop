$(document).ready(function () {
    $('.login-button').attr('disabled', 'disabled');
    $("#image").change(function () {
        if(this.files && this.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {

            $('#upload-image')
                .attr('src', e.target.result)
                .width(300)
                .height(300).css("display:block;");
        };
        reader.readAsDataURL(this.files[0]);
    }});
    $(".required").change(
        function () {
            if($("#nameProduct").val().length >= 3 && $("#nameProduct").val().length <=25 &&
                $("#price").val() >= 1 && $("#property").val().length >= 3 &&
                $("#property").val().length <= 10 && $("#description").val().length >= 3){
                $(".login-button").removeAttr('disabled');
            } else{
                $('.login-button').attr('disabled', 'disabled');
            }
        }
    );
});