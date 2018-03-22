$(document).ready(function(){
    $('.pay').click(function () {
        if($('#selectPaymentType').val() === "CARD"){
            $('#CARD').trigger("click");
        }
        if($('#selectPaymentType').val() === "CASH"){
            window.location='/order/pay?idAddress='+$('#selectForAddress').val().serialize()+'&paymentType='+$('#selectPaymentType').val();
        }

    });
});