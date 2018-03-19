$(document).ready(function () {

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

    function getQuantityInStockById() {
        $.ajax({
            url: '/catalog/' + $('#id').html()+"/quantity",
            type: 'POST'
        }).done(
            function (response) {
                $("#quantity").html(response);
            });
    }

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
                if(response==true) {
                    countInBasket();
                    getQuantityInStockById();
                    $("#closeModal").trigger("click");
                }else{
                    alert("This product has expired");
                }
            });
    });

    $('#vk').click(function () {
        var url = 'http://vkontakte.ru/share.php?';
        url += 'url=' + document.location.href;
        url += '&title=' + $('#nameProduct').html();
        url += '&description=' + $('#nameProduct').html();
        url += '&image='+ encodeURIComponent(window.location.hostname+"resources/"+$('#image').html());
        url += '&noparse=true';
        popup(url);
    });

    $('#fb').click(function () {
        var url = 'http://www.facebook.com/sharer.php?s=100';
        url += '&p[title]=' + $('#nameProduct').html();
        url += '&p[summary]=' + $('#nameProduct').html();
        url += '&p[url]=' + document.location.href;
        url += '&p[images][0]=' + encodeURIComponent(window.location.hostname+"resources/"+$('#image').html());
        Share.popup(url);
    });

    $('#mailRu').click(function () {
        var url = 'http://connect.mail.ru/share?';
        url += 'url=' + document.location.href;
        url += '&title=' + $('#nameProduct').html();
        url += '&description=' + $('#nameProduct').html();
        url += '&imageurl=' + encodeURIComponent(window.location.hostname+"resources/"+$('#image').html());
        Share.popup(url)
    });

    $('#twitter').click(function () {
        var url = 'http://twitter.com/share?';
        url += 'text=' + $('#nameProduct').html();
        url += '&url=' + document.location.href;
        url += '&counturl=' + document.location.href;
        Share.popup(url);
    });

    $('#ok').click(function () {
        var url = 'http://www.odnoklassniki.ru/dk?st.cmd=addShare&st.s=1';
        url += '&st.comments=' + $('#nameProduct').html();
        url += '&st._surl=' + document.location.href;
        Share.popup(url);
    });

    function popup(url) {
        window.open(url, '', 'toolbar=0,status=0,width=626,height=436');
    }
});
