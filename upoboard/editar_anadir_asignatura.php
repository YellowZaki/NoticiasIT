<?php
include "includes/checkLogged.php";
$modo = "";
if ($perfil != "admin") {
    hheader("Location: clases?asignatura=$asignatura.php");
}
if (isset($_GET['editar_asignatura'])) {
    $editar_asignatura = filter_input(INPUT_GET, 'editar_asignatura', FILTER_SANITIZE_STRING);
    $filas = listar("SELECT * FROM asignatura where nombre_unico_asignatura='$editar_asignatura'");
    //Existe asignatura?
    if (count($filas) == 0) {
        header("Location: gestionar_asignaturas?asignatura=$asignatura.php");
    }
    $modo = "editar";
} else {
    $modo = "anadir";
}
?>
<?php
$nombre_unico_cogido = false;
if (isset($_POST['editar'])) {
    $nombre_asignatura = filter_input(INPUT_POST, 'nombre-asignatura', FILTER_SANITIZE_STRING);
    $nombre_unico = filter_input(INPUT_POST, 'nombre-unico', FILTER_SANITIZE_STRING);
    if ($modo == "editar") {
        insertar("UPDATE asignatura SET nombre = '$nombre_asignatura' WHERE nombre_unico_asignatura = '$nombre_unico'");
        header("Location: gestionar_asignaturas.php?asignatura=$asignatura");
    } else {
        $nombre_unico = strtolower(trim($nombre_unico));
        $result = insertar("INSERT INTO `asignatura` (`nombre`, `nombre_unico_asignatura`) VALUES ('$nombre_asignatura', '$nombre_unico')");
        if (!$result) {
            $nombre_unico_cogido = true;
        } else {
            header("Location: gestionar_asignaturas.php?asignatura=$asignatura");
        }
    }
}
?> 

<html lang="es">
    <head>
        <title><?php echo "Editar/Añadir asignatura"; ?></title>
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
                    <div class="col-lg-6 col-md-8 mx-auto">
                        <?php
                        if ($nombre_unico_cogido) {
                            echo "<h4 style='color:red'>Ya hay una asignatura con ese nombre único</h4>";
                        }
                        ?>
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0"><?php
                                    if ($modo == "editar") {
                                        echo "Editar asignatura";
                                        $datosAsignatura = listar("SELECT * FROM asignatura WHERE nombre_unico_asignatura = '$editar_asignatura'")[0];
                                    } else {
                                        echo "Crear asignatura";
                                    }
                                    ?></h3>
                            </div>
                            <div class="card-body">
                                <form action="#" class="needs-validation" method="POST" novalidate>
                                    <div class="form-group">
                                        <label for="nombre-asignatura">Nombre</label>
                                        <input required name="nombre-asignatura" type="text" class="form-control" id="nombre-asignatura" placeholder="Introduce nombre" <?php
                                        if ($modo == "editar") {
                                            $nombre = $datosAsignatura["nombre"];
                                            echo " value='$nombre'";
                                        }
                                        ?>>
                                        <div class="invalid-feedback">
                                            Debes rellenar este campo
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="nombre-unico">Nombre único</label>
                                        <input required name="nombre-unico" type="text" class="form-control" id="nombre-unico" placeholder="Introduce nombre único" <?php
                                        if ($modo == "editar") {
                                            $nombre_uniq = $datosAsignatura["nombre_unico_asignatura"];
                                            echo " value='$nombre_uniq' readonly";
                                        }
                                        ?>>
                                        <div class="invalid-feedback">Debes rellenar este campo</div>
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

