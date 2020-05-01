var paginaActual = window.location.href;
//Solo interesa cerrar sesión si no está en login o registro
if (!paginaActual.includes("login.php") && !paginaActual.includes("register.php")) {
    var minutosInactividad = 10;

    var inactividad = 9999999999999999999;
    var expirada = false;
    //Cada vez que se mueve el ratón, se establece los ms de inactividad
    $(document).ready(function () {
        $(document).on("mousemove", function () {
            var d = new Date();
            inactividad = d.getTime();
        });
    });

    //Se ejecuta cada segundo
    setInterval(esInactivo, 1000);

    //Si lleva inactivo x minutos, cerrar sesión
    function esInactivo() {
        if (!expirada) {
            var d = new Date();
            var now = d.getTime();
            var tiempoInactivo = (now - inactividad);
            if (tiempoInactivo > minutosInactividad * 60000) {
                expirada = true;
                alert("Sesión expirada, vuelve a iniciar sesión");
                window.location.href = "logout.php";
            }
        }
    }
}