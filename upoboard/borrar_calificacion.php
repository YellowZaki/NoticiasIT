<?php

include "includes/checkLogged.php";
$modo = "";
//Intenta acceder alumno, echarlo
if ($perfil == "alumno") {
    header("Location: clases?asignatura=$asignatura.php");
}
//No se incluye clase de parámetro?, fuera
if (!isset($_GET['clase']) || !isset($_GET['usuario'])) {
    header("Location: clases?asignatura=$asignatura.php");
}
$usuario = filter_input(INPUT_GET, 'usuario', FILTER_SANITIZE_STRING);
$id_clase = filter_input(INPUT_GET, 'clase', FILTER_SANITIZE_STRING);
$filas = listar("SELECT * FROM clase where id_clase='$id_clase'");
//No existe la clase?, fuera
if (count($filas) == 0) {
    header("Location: clases?asignatura=$asignatura.php");
}
//A qué asignatura pertenece la clase?
$asignatura = $filas[0]['nombre_unico_asignatura'];

//El profesor tiene permisos en esta asignatura?
if ($perfil != "admin") {
    $filas = listar("SELECT * FROM matriculado_en where nombre_unico_asignatura='$asignatura' AND email_usuario='$email'");
    if (count($filas) == 0) {
        //No tiene permisos
        header("Location: clases?asignatura=$asignatura.php");
    }
}

//Borrar clase y sus tests
insertar("DELETE FROM resultadotests WHERE id_clase='$id_clase' AND email_usuario='$usuario'");
header('Location: ver_calificaciones.php?asignatura=' . $asignatura);
?>