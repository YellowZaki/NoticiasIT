<!DOCTYPE html>
<?php
include "includes/checkLogged.php";
?>
<!-- Modificar cuenta -->
<?php
if (isset($_POST['ModificarCuenta'])) {
    $nombre_usuario = filter_input(INPUT_POST, 'nombre', FILTER_SANITIZE_STRING);
    $apellidos_usuario = filter_input(INPUT_POST, 'apellidos', FILTER_SANITIZE_STRING);
    $color_prim = filter_input(INPUT_POST, 'color_primario', FILTER_SANITIZE_STRING);
    $tema_osc = 0;
    if (isset($_POST['tema_oscuro'])) {
        $tema_osc = 1;
    }
    $mostrar_encab = 0;
    if (isset($_POST['mostrar_encabezado'])) {
        $mostrar_encab = 1;
    }
    $color_prim = filter_input(INPUT_POST, 'color_primario', FILTER_SANITIZE_STRING);
    insertar("UPDATE usuario SET nombre='$nombre_usuario', apellidos='$apellidos_usuario' WHERE email_usuario='$email'");
    insertar("UPDATE personalizacion SET color_primario='$color_prim', tema_oscuro='$tema_osc', mostrar_encabezado='$mostrar_encab' WHERE email_usuario='$email'");
}
?>

<!-- Eliminar cuenta -->
<?php
if (isset($_POST['EliminarCuenta'])) {
    insertar("DELETE FROM personalizacion WHERE `email_usuario`='$email'");
    insertar("DELETE FROM matriculado_en WHERE `email_usuario`='$email'");
    insertar("DELETE FROM resultadotests WHERE `email_usuario`='$email'");
    insertar("DELETE FROM usuario WHERE `email_usuario`='$email'");
    header('Location: logout.php');
}
?>     
<html lang="es">
    <head>
        <title>Editar la configuración</title>     
        <?php
        include "includes/headContent.php";
        ?>
        <style>
            .colorPickSelector {
                border-radius:5px;
                width:36px;
                height:36px;
                cursor:pointer;
                -webkit-transition:all linear .2s;
                -moz-transition:all linear .2s;
                -ms-transition:all linear .2s;
                -o-transition:all linear .2s;
                transition:all linear .2s;
            }

        </style>
    </head>
    <body>
        <?php
        include "includes/header.php";
        ?>
        <!-- Obtener Datos -->
        <?php
        $datos = listar("SELECT * FROM usuario WHERE email_usuario = '$email'")[0];
        $nombre_usuario = $datos['nombre'];
        $apellidos_usuario = $datos['apellidos'];
        $email_usuario = $datos['email_usuario'];
        ?>

        <!-- Mostrando los datos del usuario -->
        <div class="container upoboard-margin-navbar">
            <div class="row">
                <div class="col-md-12 d-flex flex-column justify-content-center">
                    <div class="col-lg-7 col-md-8 mx-auto">
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0">Datos personales</h3>
                            </div>
                            <div class="card-body">
                                <form class="needs-validation" action="#" method="post" novalidate>
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input required class="form-control" type="text" name="nombre" value="<?php echo $nombre_usuario; ?>">
                                    </div>

                                    <div class="form-group">
                                        <label for="apellidos">Apellidos</label>
                                        <input required class="form-control" type="text" name="apellidos" value="<?php echo $apellidos_usuario; ?>"ç>
                                    </div>

                                    <div class="form-group">
                                        <label for="correo">Correo</label>
                                        <input class="form-control" type="text" value="<?php echo $email_usuario; ?>" readonly>
                                    </div>



                                    <div class="custom-control custom-switch">
                                        <input type="checkbox" class="custom-control-input" id="mostrar_encabezado" name="mostrar_encabezado" <?php
                                        if ($mostrar_encabezado) {
                                            echo " checked";
                                        }
                                        ?>>    
                                        <label class="custom-control-label" for="mostrar_encabezado">Mostrar encabezado</label>
                                        <small  class="form-text text-muted">
                                            Cuando se oculta el encabezado, además la navegación queda fija arriba
                                        </small>
                                    </div>

                                    <div class="custom-control custom-switch mt-3">
                                        <input type="checkbox" class="custom-control-input form-check-input" id="tema_oscuro" name="tema_oscuro" <?php
                                        if ($tema_oscuro) {
                                            echo " checked";
                                        }
                                        ?>>
                                        <label class="custom-control-label" for="tema_oscuro">Tema oscuro</label>                                      
                                        <small  class="form-text text-muted">
                                            Da un descanso a tus ojos por la noche
                                        </small>
                                    </div>     
                                    <div class="form-group mt-3">
                                        <input type='hidden' name='color_primario' id='color_primario' value='<?php echo $color_primario ?>'>
                                        <label for="color_primario">Color primario</label>
                                        <div class="colorPickSelector"></div>
                                    </div>
                                    <div class="text-center mt-3">
                                        <button type='submit' class="btn btn-primary" name="ModificarCuenta">Guardar</button>
                                    </div>

                                    <div class="text-center mt-5">
                                        <button type='submit' class="btn btn-danger" name="EliminarCuenta">Eliminar cuenta</button>
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
