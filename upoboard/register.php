<?php
require_once 'bd.php';
?>
<?php
$email_ya_registrado = false;
if (isset($_POST['registrar'])) {
    $email = filter_input(INPUT_POST, 'email', FILTER_SANITIZE_STRING);
    $password = filter_input(INPUT_POST, 'pass', FILTER_SANITIZE_STRING);
    $name = filter_input(INPUT_POST, 'name', FILTER_SANITIZE_STRING);
    $surname = filter_input(INPUT_POST, 'surname', FILTER_SANITIZE_STRING);
    $password = password_hash($password, PASSWORD_DEFAULT);
    $result = insertar("INSERT INTO `usuario` (`email_usuario`, `pass`, `nombre`, `apellidos`, `perfil`) VALUES ('$email', '$password', '$name', '$surname', 'alumno');");
    if (!$result) {
        $email_ya_registrado = true;
    } else {
        //Se crea la configuracion
        insertar("INSERT INTO `personalizacion` (`color_primario`, `mostrar_encabezado`, `tema_oscuro`, `email_usuario`) VALUES ('#007bff', '1', '0', '$email')");
        header('Location: login.php');
    }
}
?>  
<html lang="es">
    <head>
        <title>Registrarse</title>
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
                        if ($email_ya_registrado) {
                            echo "<h4 style='color:red'>Ya hay una cuenta registrada con ese email</h4>";
                        }
                        ?>
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0">Registro</h3>
                            </div>
                            <div class="card-body">
                                <form action="#" class="needs-validation" method="POST" novalidate>
                                    <div class="form-group">
                                        <label for="name">Nombre</label>
                                        <input required name="name" type="text" class="form-control" id="name" placeholder="Introduce nombre">
                                        <div class="invalid-feedback">
                                            Debes rellenar este campo
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="surname">Apellidos</label>
                                        <input required name="surname" type="text" class="form-control" id="surname" placeholder="Introduce apellidos">
                                        <div class="invalid-feedback">Debes rellenar este campo</div>
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input required name="email" type="email" class="form-control" id="email" placeholder="Introduce email">
                                        <div class="invalid-feedback">Debes rellenar este campo con un email válido</div>
                                    </div>
                                    <div class="form-group">
                                        <label for="pass">Contraseña</label>
                                        <input required name="pass" type="password" class="form-control" id="pass" placeholder="Introduce contraseña">
                                        <div class="invalid-feedback">Debes rellenar este campo</div>
                                    </div>
                                    <button name="registrar" type="submit" class="btn btn-primary">Registrarse</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

