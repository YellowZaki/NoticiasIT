<?php
include "includes/checkLogged.php";
if ($perfil != "admin" || $perfil != "profesor") {
    header("Location: clases.php?asignatura=$asignatura");
}
if (isset($_GET['usuario'])) {
    $email_usuario = filter_input(INPUT_GET, 'usuario', FILTER_SANITIZE_STRING);
    insertar("INSERT INTO `matriculado_en` (`email_usuario`, `nombre_unico_asignatura`) VALUES ('$email_usuario', '$asignatura')");
}

header("Location: listar_alumnos.php?asignatura=$asignatura");
?>