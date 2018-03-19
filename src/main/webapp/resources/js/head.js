$( document ).ready(function() {
    countInBasket();
    $("#buttonBasketProducts").click(function(){
        $.ajax({
            url: '/basket',
            type: 'GET'
        }).done(
            function (response) {
                $('#basketProducts').html(response);
            }
        );
    });
});

function countInBasket(){
    $.ajax({
        url: '/basket/count',
        type: 'GET'
    }).done(
        function (response) {
            $('#countProductInBasket').html(response);
        }
    );
}