$(document).ready(function () {
    jQuery(function($){
        $("#phone").mask("+7(999) 999-9999");
        $("#email").mask("[-._a-z0-9]+@(?:[a-z0-9][-a-z0-9]+\\.)+[a-z]{2,6}");
        });
});