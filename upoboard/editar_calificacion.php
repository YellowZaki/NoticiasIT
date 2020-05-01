<?php
include "includes/checkLogged.php";
$modo = "";
if ($perfil == "alumno") {
    header('Location: pagina_no_encontrada.php');
}
if (!isset($_GET['clase']) || !isset($_GET['usuario'])) {
    header("Location: clases?asignatura=$asignatura.php");
} else {
    $usuario = filter_input(INPUT_GET, 'usuario', FILTER_SANITIZE_STRING);
    $id_clase = filter_input(INPUT_GET, 'clase', FILTER_SANITIZE_STRING);
    $filas = listar("SELECT * FROM clase where id_clase='$id_clase'");
    if (count($filas) == 0) {
        header('Location: pagina_no_encontrada.php');
    }
    //A qué asignatura pertenece la clase?
    $asignatura = $filas[0]['nombre_unico_asignatura'];
    $modo = "editar";
    //El profesor tiene permisos en esta asignatura?
    if ($perfil != "admin") {
        $filas = listar("SELECT * FROM matriculado_en where nombre_unico_asignatura='$asignatura' AND email_usuario='$email'");
        if (count($filas) == 0) {
            header("Location: clases?asignatura=$asignatura.php");
        }
    }
}
?>
<?php
if (isset($_POST['editar'])) {
    $nota = filter_input(INPUT_POST, 'nota', FILTER_SANITIZE_NUMBER_FLOAT);
    if ($nota > 0 && $nota < 10) {
        //Actualizamos los datos
        insertar("UPDATE resultadotests SET nota='$nota' WHERE id_clase = '$id_clase' AND email_usuario = '$usuario'");
    }
    header("Location: ver_calificaciones.php?asignatura=$asignatura&usuario=$usuario");
}
?>
<html lang="es">
    <head>
        <title><?php echo "Editar calificación"; ?></title>
        <?php
        include "includes/headContent.php";
        ?>
    </head>
    <body>
        <?php
        include "includes/header.php";
        ?>
        <div class="container upoboard-margin-navbar">

            <div class="row">
                <div class="col-md-12 d-flex flex-column justify-content-center">
                    <div class="col-lg-9 col-md-8 mx-auto">
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0">Editar calificación</h3>
                            </div>
                            <div class="card-body">
                                <form action="#" class="needs-validation" method="POST" novalidate>
                                    <div class="form-group">
                                        <label for="fecha-publicacion">Nota de usuario</label>
                                        <input required name="nota" min="0" max="10" type="number" class="form-control"
                                        <?php
                                        $nota = listar("SELECT * FROM resultadotests WHERE email_usuario='$usuario' AND id_clase='$id_clase'")[0]['nota'];
                                        echo " value='$nota'";
                                        ?>
                                               >
                                        <div class="invalid-feedback">
                                            Debes rellenar este campo
                                        </div>
                                    </div>
                                    <button name="editar" type="submit" class="btn btn-primary">Guardar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </body>
</html>