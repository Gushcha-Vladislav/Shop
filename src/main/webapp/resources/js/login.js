$(document).ready(function () {
    $.extend({
        getUrlVars: function () {
            var vars = [], hash;
            var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
            for (var i = 0; i < hashes.length; i++) {
                hash = hashes[i].split('=');
                vars.push(hash[0]);
                vars[hash[0]] = hash[1];
            }
            return vars;
        },
        getUrlVar: function (name) {
            return $.getUrlVars()[name];
        }
    });

    var byName = $.getUrlVar('error');
    if (byName !== undefined) {
        $('#error').html("<div class='alert alert-danger alert-dismissible'>" +
            "<button type='button' class='close' data-dismiss='alert' ><i class='fas fa-times'></i></button>" +
            "<h4>Incorrect password or email</h4></div>");
    }
});