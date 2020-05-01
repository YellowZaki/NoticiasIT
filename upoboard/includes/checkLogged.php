<?php

require_once 'bd.php';
session_start();

if (!isset($_SESSION['logged'])) {
    header('Location: login.php');
} else {
    $perfil = "alumno";
    if ($_SESSION['perfil'] == 'alumno') {
        $perfil = "alumno";
    } else if ($_SESSION['perfil'] == 'profesor') {
        $perfil = "profesor";
    } else if ($_SESSION['perfil'] == 'admin') {
        $perfil = "admin";
    } else {
        header('Location: logout.php');
    }
    $email = $_SESSION['email_usuario'];
}

//Establecer $asignatura
if (isset($_GET['asignatura'])) {
    $asignatura = filter_input(INPUT_GET, 'asignatura', FILTER_SANITIZE_STRING);
    //Comprobar que la asignatura a la que se intenta acceder existe
    $filas = listar("SELECT * FROM asignatura where nombre_unico_asignatura='$asignatura'");
    if (count($filas) == 0) {
        //Intentar arreglar
        $filas = listar("SELECT * FROM asignatura");
        if (count($filas) == 0) {
            header('Location: pagina_no_encontrada.php');
        } else {
            if ($perfil == "admin") {
                $asignatura = $filas[0]['nombre_unico_asignatura'];
            } else {
                $filas = listar("SELECT * FROM matriculado_en WHERE email_usuario='$email'");
                if (count($filas) == 0) {
                    header('Location: pagina_no_encontrada.php');
                } else {
                    $asignatura = $filas[0]['nombre_unico_asignatura'];
                }
            }
        }
    }
} else {
    //Intentar arreglar
    $filas = listar("SELECT * FROM asignatura");
    if (count($filas) == 0) {
        header('Location: pagina_no_encontrada.php');
    } else {
        if ($perfil == "admin") {
            $asignatura = $filas[0]['nombre_unico_asignatura'];
        } else {
            $filas = listar("SELECT * FROM matriculado_en WHERE email_usuario='$email'");
            if (count($filas) == 0) {
                header('Location: pagina_no_encontrada.php');
            } else {
                $asignatura = $filas[0]['nombre_unico_asignatura'];
            }
        }
    }
}


