$(document).ready(function() {
    $("#buttonAdd2Cart").on("click", function(evt) {
        addToCart();
    });
});

function addToCart() {
    quantity = $("#quantity" + productId).val();
    url = contextPath + "cart/add/" + productId + "/" + quantity;

    $.ajax({ //Asynchronous Javascript and XML — «асинхронный JavaScript и XML») — подход к построению интерактивных пользовательских интерфейсов веб-приложений, заключающийся в «фоновом» обмене данными браузера с веб-сервером
        type: "POST",
        url: url,
        beforeSend: function(xhr) { //XMLHttpRequest (или, как его кратко называют, «XHR») даёт возможность из JavaScript делать HTTP-запросы к серверу без перезагрузки страницы
            xhr.setRequestHeader(csrfHeaderName, csrfValue);
        }
    }).done(function(response) {
        showModalDialog("Shopping Cart", response);
    }).fail(function() {
        showErrorModal("Error while adding product to shopping cart.");
    });
}