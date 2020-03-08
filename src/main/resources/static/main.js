'use strict';

function createOrder() {
    var orderSummary = $("#order-summary").val();

    var request = {
        type: "POST",
        url: "/createOrder",
        headers: {
            'Accept': 'application/json;charset=UTF-8',
            'Content-Type': 'application/json;charset=UTF-8'
        },
        data: JSON.stringify({
            name: orderSummary
        })
    };
    $.ajax(request)
        .done(function () {
            alert("Order created");
        })
        .fail(function (response) {
            alert("Error: " + response.responseJSON.message);
        });
}