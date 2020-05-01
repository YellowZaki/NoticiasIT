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
    $asignatura = "none";
}

?>

<html lang="es">
    <head>
        <title><?php echo "Página no encontrada"; ?></title>
        <?php
        include "includes/headContent.php";
        ?>
    </head>
    <body>
        <?php
        include "includes/header.php";
        ?>
        <div class="container upoboard-margin-navbar">
            <h1>Oops, página no encontrada</h1>
            <h4>Si no te has matriculado en ninguna asignatura, espera a que un profesor lo haga</h4>
        </div>

    </body>
</html>

