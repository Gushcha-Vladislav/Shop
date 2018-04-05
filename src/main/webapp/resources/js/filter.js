$(document).ready(function () {
    $(".filter").click(function () {
        sendFilter($(this).parent().find('div.id.param').html(),-1)
    });
    $(".sort").change(function () {
        sendFilter(-1,$(this).val())
    });
    function sendFilter(idCategory, typeSort){
        $.ajax({
            url: '/filter',
            data:{'idCategory':idCategory, 'typeSort':typeSort
            },
            type: 'POST',
            success: function (response) {
                $('#listProducts')[0].innerHTML = response;
            }
        });

    }
});