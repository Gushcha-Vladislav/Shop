$(document).ready(function() {
    countInBasket();

    $('.deleteItem').click(function () {
        var $input = $(this).parent().parent().find('div.param.idBasket');
        $.ajax({
            url: '/basket/delete/'+ $input.html(),
            type: 'POST'
        }).done( function () {
            basketView();
        });
    });

    $('#clearBasket').click(function () {
        $.ajax({
            url: '/basket/delete',
            type: 'POST'
        }).done( function () {
            basketView();
            });
    });
});