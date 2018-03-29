$(document).ready(function() {
    $('#deleteAdmin').click(function () {
        var $input = $(this).parent().find('div.param');
        $.ajax({
            url: 'superAdmin/manager/delete/'+$input.html(),
            type: 'POST'
        }).done( function (response) {
            $('#adminList').html(response);
        });
    });
});
