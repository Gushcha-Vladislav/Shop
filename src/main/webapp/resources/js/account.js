$(document).ready(function() {
    $(".changeUser").click(function () {
        var name = $(this).parent().parent().find('input.form-control').attr("id");
        $('#' + name)[0].disabled = false;
        $('#' + name)[0].placeholder =n;
        $('#' + name).val("");
        if(name==="phone"){
            $("#phone").mask("+7(999) 999-9999");
        }
    });
    $('#addresses').change(function() {
        if($('#addresses').val() === "newAddress"){
            window.location="/account/formAddress"
        }
    });
});