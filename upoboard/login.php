<?php
require_once 'bd.php';
session_start();

if (isset($_SESSION['logged']) && $_SESSION['logged'] == true) {
    header('Location: login.php');
    $perfil = $_SESSION['perfil'];
    //Llevarlo a la página principal de la primera asignatura que encuentre donde esté matriculado
    if ($_SESSION['perfil'] == "admin") {
        $asignaturas = listar("SELECT * FROM asignatura");
    } else {
        $asignaturas = listar("SELECT * FROM matriculado_en WHERE email_usuario='$email'");
    }
    if (count($asignaturas) == 0) {
        header('Location: pagina_no_encontrada.php');
    } else {
        $asignatura = $asignaturas[0]['nombre_unico_asignatura'];
        header("Location: clases.php?asignatura=$asignatura");
    }
}
?>

<?php
$user_o_pass_incorrecto = false;
if (isset($_POST['login'])) {
    $email_usuario = filter_input(INPUT_POST, 'email', FILTER_SANITIZE_STRING);
    $password = filter_input(INPUT_POST, 'pass', FILTER_SANITIZE_STRING);
    $filas = listar("SELECT * FROM usuario where email_usuario='$email_usuario'");
    //Existe el email?
    if (count($filas) == 1) {
        $hashedpassword = $filas[0]['pass'];
        if (password_verify($password, $hashedpassword)) {
            $_SESSION['email_usuario'] = $email_usuario;
            $_SESSION['perfil'] = $filas[0]['perfil'];
            $_SESSION['logged'] = true;

            //Llevarlo a la página principal de la primera asignatura que encuentre donde esté matriculado
            if ($_SESSION['perfil'] == "admin") {
                $asignaturas = listar("SELECT * FROM asignatura");
            } else {
                $asignaturas = listar("SELECT * FROM matriculado_en WHERE email_usuario='$email_usuario'");
            }
            if (count($asignaturas) == 0) {
                header('Location: pagina_no_encontrada.php');
            } else {
                $asignatura = $asignaturas[0]['nombre_unico_asignatura'];
                header("Location: clases.php?asignatura=$asignatura");
            }
        } else {
            $user_o_pass_incorrecto = true;
        }
    } else {
        $user_o_pass_incorrecto = true;
    }
}
?>  
<html lang="es">
    <head>
        <title>Login</title>
        <?php
        include "includes/headContent.php";
        ?>
    </head>
    <body>
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>UPOBOARD</h1>
            <p>El aula virtual de clases no presenciales</p>
        </div>
        <div class="container upoboard-margin-navbar">
            <div class="row">
                <div class="col-md-12 d-flex flex-column justify-content-center">
                    <div class="col-lg-6 col-md-8 mx-auto">
                        <?php
                        if ($user_o_pass_incorrecto) {
                            echo "<h4>Usuario/contraseña incorrectos</h4>";
                        }
                        ?>
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0">Login</h3>
                            </div>
                            <div class="card-body">
                                <form method="POST">
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input name="email" type="email" class="form-control" id="email" placeholder="Introduce email">
                                        <div class="invalid-feedback">
                                            Debes rellenar este campo
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="pass">Contraseña</label>
                                        <input name="pass" type="password" class="form-control" id="pass" placeholder="Introduce contraseña">
                                    </div>
                                    <div class="d-flex">
                                        <button name="login" type="submit" class="btn btn-primary">Entrar</button>
                                        <a href="register.php" class="btn btn-primary ml-auto">Registrarse</a>  
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

