$(document).ready(function () {

    countItems();
    getQuantityInStockById();

    $('#vk').click(function () {
        var url = 'http://vkontakte.ru/share.php?';
        url += 'url=' + document.location.href;
        url += '&title=' + $('#name').html();
        url += '&description=' + $('#name').html();
        url += '&image='+ encodeURIComponent(window.location.hostname+"resources/"+$('#image').html());
        url += '&noparse=true';
        popup(url);
    });

    $('#fb').click(function () {
        var url = 'http://www.facebook.com/sharer.php?s=100';
        url += '&p[title]=' + $('#name').html();
        url += '&p[summary]=' + $('#name').html();
        url += '&p[url]=' + document.location.href;
        url += '&p[images][0]=' + encodeURIComponent(window.location.hostname+"resources/"+$('#image').html());
        popup(url);
    });

    $('#mailRu').click(function () {
        var url = 'http://connect.mail.ru/share?';
        url += 'url=' + document.location.href;
        url += '&title=' + $('#name').html();
        url += '&description=' + $('#name').html();
        url += '&imageurl=' + encodeURIComponent(window.location.hostname+"resources/"+$('#image').html());
       popup(url)
    });

    $('#twitter').click(function () {
        var url = 'http://twitter.com/share?';
        url += 'text=' + $('#name').html();
        url += '&url=' + document.location.href;
        url += '&counturl=' + document.location.href;
        popup(url);
    });

    $('#ok').click(function () {
        var url = 'http://www.odnoklassniki.ru/dk?st.cmd=addShare&st.s=1';
        url += '&st.comments=' + $('#name').html();
        url += '&st._surl=' + document.location.href;
        popup(url);
    });

    function popup(url) {
        window.open(url, '', 'toolbar=0,status=0,width=626,height=436');
    }

});
function getQuantityInStockById() {
    $.ajax({
        url: '/catalog/' + $('#id').html()+"/quantity",
        type: 'GET'
    }).done(
        function (response) {
            $("#quantity").html(response);
        });
}