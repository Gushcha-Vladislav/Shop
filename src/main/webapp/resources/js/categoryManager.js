$(document).ready(function () {
    $(".categoryChange").click(function () {
        var $input = $(this).parent().find('div.id.param');
        var $parent = $(this).parent().parent().find('div.id.param')[0];
        $("#nameCategory").val($(this).text());
        $("#id").val($input.html());
        $("#idParent").val($parent.val());
    });
    $(".new").click(function () {
        var $input = $(this).parent().find('div.id.param');
        $("#id").val($input.html());
    });
    $("#idParent").change(function() {
        var $input = $(this).parent().find('div.id.param');
        $.ajax({
            url: '/admin/categories/'+ $input.html(),
            type: 'GET'
        }).done( function (recourse) {
            if(!recourse) $("#messageParent").html("This category is at the top of the hierarchy.");
            else alert("Done");
        });
    });
    $(".status").click(function() {
        var $input = $(this).parent().find('div.id.param');
        $.ajax({
            url: '/admin/categories/status/'+ $input.html(),
            type: 'GET'
        }).done( function (recourse) {
            window.location="/admin/categories";
        });
    });
});