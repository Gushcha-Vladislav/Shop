$(document).ready(function () {
    $('#addToBasket').click(function () {
        $.ajax({
            url: '/basket/add/' + $('#id').html(),
            type: 'POST',
            data: {
                'nameProduct': $('#nameProduct').html(),
                'price': $('#priceProduct').html(),
                'amount': $('#amount-number').val().toString(),
                'image': $('#image').html()
            }
        }).done(
            function (response) {
                if (response == true) {
                    countInBasket();
                    $("#closeModal").trigger("click");
                    getQuantityInStockById();
                } else {
                    alert("This product has expired");
                }
            });
    });

    $('#button-less').click(function () {
        if (parseInt($('#amount-number').val()) > 0) {
            $('#amount-number').val(parseInt($('#amount-number').val()) - 1);
            $('#totalPrice').html((parseFloat($('#priceProduct').html()) * parseInt($('#amount-number').val())));
        }
    });

    $('#button-more').click(function () {
        if (parseInt($('#amount-number').val()) < parseInt($('#quantity').html())) {
            $('#amount-number').val(parseInt($('#amount-number').val()) + 1);
            $('#totalPrice').html(parseFloat($('#priceProduct').html()) * parseInt($('#amount-number').val()));

        }
    });
});


