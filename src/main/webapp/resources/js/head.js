$(document).ready(function () {
    countInBasket();
    $("#buttonBasketProducts").click(function () {
        basketView();
    });
});

function basketView() {
    $.ajax({
        url: '/basket',
        type: 'GET'
    }).done(
        function (response) {
            $('#basketProducts').html(response);
        }
    );
}

function countInBasket() {
    $.ajax({
        url: '/basket/count',
        type: 'GET'
    }).done(
        function (response) {
            $('#countProductInBasket').html(response);
        }
    );
}

function countItems() {
    $.ajax({
        url: '/basket/count/' + $('#id').html(),
        type: 'GET'
    }).done(function (response) {
        $('#amount-number').val(parseInt(response));
        $('#totalPrice').html(parseInt(response) * parseFloat($('#priceProduct').html()));
    });
}