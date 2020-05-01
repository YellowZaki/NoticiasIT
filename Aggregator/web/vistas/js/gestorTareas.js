$(document).ready(function () {
    //Abrir tareas
    $("#abrirTareasModel").on("click", function () {
        $("#tareasModal").fadeIn();
        $("#tareasModal").addClass("show");
        $("body").addClass("modal-open");

        var modal_backdrop = $("<div>");
        modal_backdrop.addClass("modal-backdrop");
        modal_backdrop.addClass("show");
        modal_backdrop.hide();
        $("body").append(modal_backdrop);
        modal_backdrop.fadeIn();
    });
    //Cerrar tareas
    $("#cerrarTareasModel").on("click", function () {
        $("#tareasModal").fadeOut();
        $("#tareasModal").removeClass("show");
        $("body").removeClass("modal-open");

        $(".modal-backdrop").fadeOut({done: function () {
                $(this).remove();
            }});
    });



});


$(document).ready(function () {
    // Variables //
    var lista = document.getElementById("lista");
    var tareaInput = document.getElementById("tareaInput");
    var btnNuevaTarea = document.getElementById("btn-agregar");

    // Funciones //
    var eliminarTarea = function () {
        this.parentNode.removeChild(this);
        actualizarCookie();
    };    
    
    var agregarTarea = function (event, tareaText) {
        var tarea = tareaText;
        if (typeof tarea === "undefined") {
            tarea = tareaInput.value;
        }

        var nuevaTarea = document.createElement("li");
        var enlace = document.createElement("a");
        var contenido = document.createTextNode(tarea);

        if (tarea === "") {
            tareaInput.setAttribute("placeholder", "Añade una tarea válida");
            tareaInput.className = "error";
            return false;
        }
        // Agregamos el contenido al enlace
        enlace.appendChild(contenido);

        // Le establecemos un atributo href
        enlace.setAttribute("href", "#");

        // Agregamos el enlace a nuevaTarea
        nuevaTarea.appendChild(enlace);

        // Agregar la nuevaTarea a la lista
        lista.appendChild(nuevaTarea);

        // Limpiamos el input
        tareaInput.value = "";

        //Adjuntar evento de eliminar
        nuevaTarea.addEventListener("click", eliminarTarea);
        
        //Actualizamos el contenido de la cookie
        actualizarCookie();
    };

    var comprobarInput = function () {
        tareaInput.className = "";
        tareaInput.setAttribute("placeholder", "Añade una tarea");
    };


    // Eventos //

    // Agregar tarea
    btnNuevaTarea.addEventListener("click", agregarTarea);

    // Comprobar inputs
    tareaInput.addEventListener("click", comprobarInput);


    //Recoger los textos de las tareas y guardarlos en la cookie tareas con el separador "/*/"
    function actualizarCookie() {
        var arrayTareas = [];
        for (var i = 0; i <= lista.children.length - 1; i++) {
            arrayTareas.push(lista.children[i].firstChild.text);
        }
        var tareas = arrayTareas.join("/*/")
        setCookie("tareas", tareas);
    }

    //CARGAR TAREAS AL ABRIR PAGINA A PARTIR DE LA COOKIE
    var tareas = getCookie("tareas");
    if (tareas != null) {
        var arrayTareas = tareas.split("/*/");
        var lista = document.getElementById("lista");
        for (var i = 0; i < arrayTareas.length; i++) {
            var tarea = arrayTareas[i];
            agregarTarea("event", tarea);
        }
    }

});


//Utilidades
function setCookie(name, value, days) {
    var expires = "";
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        expires = "; expires=" + date.toUTCString();
    }
    document.cookie = name + "=" + (value || "") + expires + "; path=/";
}
function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ')
            c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0)
            return c.substring(nameEQ.length, c.length);
    }
    return null;
}