<?php
include "includes/checkLogged.php";
if ($perfil == "alumno") {
    header("Location: clases.php?asignatura=$asignatura");
}

//Si el profesor no puede dar clases en la asignatura
if ($perfil != "admin") {
    $filas = listar("SELECT * FROM matriculado_en where nombre_unico_asignatura='$asignatura' AND email_usuario='$email'");
    if (count($filas) == 0) {
        header("Location: clases.php?asignatura=$asignatura");
    }
}
$nombre_asignatura = listar("SELECT * FROM asignatura where nombre_unico_asignatura='$asignatura'")[0]['nombre'];
?>

<html lang="es">
    <head>
        <title><?php echo "Gestión de clases - $nombre_asignatura"; ?></title>
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
                <div class="mr-auto"><h1>Clases</h1></div>
                <div class="ml-auto">
                    <?php echo "<a href='editar_anadir_clase.php?asignatura=$asignatura' class='btn btn-primary add-new'><i class='fa fa-plus'></i> Añadir</a>" ?>
                    
                </div>
            </div>

            <table class="table table-responsive-sm">
                <thead>
                    <tr>
                        <th scope="col">Descripción</th>
                        <th scope="col">Fecha publicación</th>
                        <th scope="col">Fecha entrega</th>
                        <th scope="col">Acción</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <?php
                    $valores = listar("SELECT * FROM clase WHERE nombre_unico_asignatura='$asignatura'");
                    foreach ($valores as $valor) {
                        $id_clase = $valor["id_clase"];
                        $fecha_publicacion = $valor["fecha_publicacion"];
                        $fecha_entrega = $valor["fecha_entrega"];
                        $descripcion = $valor["descripcion"];
                        echo "                    <tr>
                        <th scope='row'>$descripcion</th>
                        <td>$fecha_publicacion</td>
                        <td>$fecha_entrega</td>
                        <td>
                            <a href='editar_anadir_clase.php?asignatura=$asignatura&clase=$id_clase'><i style='color:orange;' class='fas fa-edit'></i></a>
                            <a href='borrar_clase.php?asignatura=$asignatura&clase=$id_clase'><i style='color:red;' class='fas fa-trash'></i></a>                            
                        </td>
                    </tr>";
                    }
                    ?>                 
                </tbody>
            </table>
        </div>
    </body>
</html>

