$(document).ready(function() {
    $('.deleteItem').click(function () {
        var $input = $(this).parent().parent().find('input');
        $.ajax({
            url: '/account/addresses/'+$input.val(),
            type: 'POST'
        }).done(function (response) {
            $('#addressList').html(response);
        });
    });
});