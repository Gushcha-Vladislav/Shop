$(document).ready(function(){
    $('.payCard').attr('disabled', 'disabled');
    $("#numberCard").mask("9999 9999 9999 9999");
    $('.pay').click(function () {
        if($('#selectPaymentType').val() === "CARD"){
            $('#cardOpen').trigger("click");
        }
        if($('#selectPaymentType').val() === "CASH"){
            window.location='/order/pay?idAddress='+$('#selectForAddress').val()+'&paymentType='+$('#selectPaymentType').val();
        }

    });
    $('input').change(function () {
        if($('#cvc2').val().length === 3 && $('#exp').val().length === 2 && $('#exp-year').val().length === 2
            && $('#exp').val() <= 31 && $('#exp').val() > 0){
            $(".payCard").removeAttr('disabled');
        }else{
            $('.payCard').attr('disabled', 'disabled');
        }
       });
    $('.payCard').click(function () {
        window.location='/order/pay?idAddress='+$('#selectForAddress').val()+'&paymentType='+$('#selectPaymentType').val();
    });
    $('#selectPaymentType').change(function() {
        if($('#selectForAddress').val() === "newAddress"){
            window.location="account/formAddress"
        }
    });
});