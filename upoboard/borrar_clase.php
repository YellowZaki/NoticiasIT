<?php

include "includes/checkLogged.php";
//Intenta acceder alumno, echarlo
if ($perfil == "alumno") {
    header("Location: clases?asignatura=$asignatura.php");
}
//No se incluye clase de parámetro?, fuera
if (!isset($_GET['clase'])) {
    header("Location: clases?asignatura=$asignatura.php");
}

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
        header("Location: clases?asignatura=$asignatura.php");
    }
}

//Borrar clase y sus tests
insertar("DELETE FROM test WHERE id_clase='$id_clase'");
insertar("DELETE FROM clase WHERE id_clase='$id_clase'");
insertar("DELETE FROM resultadotests WHERE id_clase='$id_clase'");
header('Location: gestionar_clases.php?asignatura=' . $asignatura);
?>