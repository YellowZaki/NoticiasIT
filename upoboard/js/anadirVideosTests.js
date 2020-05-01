$(document).ready(function () {
    //Botón de añadir test
    $("#anadirTest").on("click", function (event) {
        var contador = $("#contadorTest").val();
        var testCard = $("<div>")
        testCard.addClass("card");
        testCard.addClass("rounded");
        testCard.addClass("shadow");
        testCard.addClass("shadow-sm");
        testCard.addClass("mt-4");
        var cardHeader = $("<div>")
        cardHeader.addClass("card-header");
        var divRow0 = $("<div>")
        divRow0.addClass("row");
        divRow0.addClass("p-2");
        var inputTitulo = $("<input>")
        inputTitulo.addClass("form-control");
        inputTitulo.addClass("col-md-11");
        inputTitulo.attr("required", "");
        inputTitulo.attr("type", "text");
        inputTitulo.attr("placeholder", "Pregunta");
        inputTitulo.attr("name", "pregunta-" + contador);
        var iconoBorrar = $("<i>");
        iconoBorrar.css("color", "red");
        iconoBorrar.addClass("eliminarTest");
        iconoBorrar.addClass("col-md-1");
        iconoBorrar.addClass("mt-2");
        iconoBorrar.addClass("fa");
        iconoBorrar.addClass("fas fa-trash");
        divRow0.append(inputTitulo);
        divRow0.append(iconoBorrar);
        cardHeader.append(divRow0);
        testCard.append(cardHeader);
        var cardBody = $("<div>")
        cardBody.addClass("card-body");

        for (var i = 0; i < 4; i++) {
            var divRespuestas = $("<div>")
            divRespuestas.addClass("col");
            divRespuestas.addClass("form-group");
            divRespuestas.addClass("mb-0");
            divRespuestas.addClass("p-2");
            divRespuestas.addClass("form-row");
            divRespuestas.addClass("form-check");
            divRespuestas.addClass("form-check-inline");

            var inputRespuesta = $("<input>")
            inputRespuesta.addClass("form-control");
            inputRespuesta.addClass("col-md-11");
            inputRespuesta.attr("name", "respuesta-" + contador + "-" + i);
            inputRespuesta.attr("required", "");
            inputRespuesta.attr("type", "text");

            var inputCorrecta = $("<input>")
            inputCorrecta.addClass("form-check-input");
            inputCorrecta.addClass("col-md-1");
            inputCorrecta.addClass("mr-auto");
            inputCorrecta.attr("type", "radio");
            inputCorrecta.attr("name", "correcta-" + contador);
            inputCorrecta.attr("value", i);
            inputCorrecta.attr("required", "");

            divRespuestas.append(inputRespuesta);
            divRespuestas.append(inputCorrecta);
            cardBody.append(divRespuestas);
        }
        testCard.append(cardBody);
        $("#tests").append(testCard);
        testCard.hide();
        testCard.fadeIn();
        contador++;
        $("#contadorTest").val(contador);
    });

    //Botón de eliminar test
    $(document).on("click", ".eliminarTest", function (event) {
        $(this).parent().parent().parent().fadeOut({done: function () {
                $(this).remove();
            }});
    });
});

//Añadir/eliminar vídeos
$(document).ready(function () {
    //Botón de añadir vídeo
    $("#anadirVideo").on("click", function (event) {
        var contador = $("#contadorVideos").val();
        var video = $("<div>");
        video.addClass("form-group");
        video.addClass("form-inline");
        var input = $("<input>");
        input.addClass("form-control");
        input.addClass("col-md-11");
        input.attr("required", "");
        input.attr("type", "url");
        input.attr("placeholder", "https://www.youtube.com/watch?v=yeaHCauqIwM");
        input.attr("name", "video-" + contador);
        var iconoBorrar = $("<i>");
        iconoBorrar.css("color", "red");
        iconoBorrar.addClass("eliminarVideo");
        iconoBorrar.addClass("col-md-1");
        iconoBorrar.addClass("fa");
        iconoBorrar.addClass("fas fa-trash");
        video.append(input);
        video.append(iconoBorrar);
        $("#videos_clase").append(video);
        video.hide();
        video.fadeIn();
        contador++;
        $("#contadorVideos").val(contador);
    });
    //Botón de eliminar video
    $(document).on("click", ".eliminarVideo", function (event) {
        $(this).parent().fadeOut({done: function () {
                $(this).remove();
            }});
    });
});