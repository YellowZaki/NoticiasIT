<?php
include "includes/checkLogged.php";
if ($perfil != "admin") {
    header('Location: pagina_no_encontrada.php');
}
if (isset($_GET['editar_asignatura'])) {
    $editar_asignatura = filter_input(INPUT_GET, 'editar_asignatura', FILTER_SANITIZE_STRING);
    insertar("DELETE FROM asignatura WHERE nombre_unico_asignatura = '$editar_asignatura'");
}
header('Location: gestionar_asignaturas.php');
?>