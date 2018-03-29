$(document).ready(function () {

    $('#orderStatus').change(function () {
        var $input = $(this).parent().find('div.param');
        $.ajax({
            url: '/admin/orderStatus/' + $("#orderStatus").val() + '/' + $input.html(),
            type: 'GET'
        }).done( function (response) {
            infoElement(response,"Change order status successes");
        });
    });
    $('#paymentStatus').change(function () {
        var $input = $(this).parent().find('div.param');
        $.ajax({
            url: '/admin/paymentStatus/' + $("#paymentStatus").val() + '/' + $input.html(),
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