$(document).ready(function(){
    $('.pay').click(function () {
        if($('#selectPaymentType').val() === "CARD"){
            $('#CARD').trigger("click");
        }
        if($('#selectPaymentType').val() === "CASH"){
            window.location='/order/pay?idAddress='+$('#selectForAddress').val()+'&paymentType='+$('#selectPaymentType').val();
        }

    });
    $('.pay').change(function (){
        if($('#selectForAddress').val() === "newAddress") {
            window.location='/account/addresses';
        }
    });
});