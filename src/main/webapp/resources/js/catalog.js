function loadInModal(id,name, price, image,quantity){
    $('#id').html(id);
    $('#nameProduct').html(name);
    $('#priceProduct').html(price);
    $('#image').html( image);
    $('#quantity').html(quantity);
    countItems();
}
