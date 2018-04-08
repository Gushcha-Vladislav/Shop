$(document).ready(function () {

    $('.orderStatus').change(function () {
        var $input = $(this).parent().parent().find('div.param');
        $.ajax({
            url: '/admin/orderStatus/' + $(this).val() + '/' + $input.html(),
            type: 'GET'
        }).done( function (response) {
            infoElement(response,"Change order status successes");
        });
    });
    $('.paymentStatus').change(function () {
        var $input = $(this).parent().parent().find('div.param');
        $.ajax({
            url: '/admin/paymentStatus/' + $(this).val() + '/' + $input.html(),
            type: 'GET'
        }).done( function (response) {
            infoElement(response,"Change payment status successes");
        });
    });
    function infoElement(response,message) {

        if(response ===true){
            $('.info').html(message);
        }else{
            $('.info').html("Oops, error");
        }
        $("#openInfo").trigger("click");
    }
});