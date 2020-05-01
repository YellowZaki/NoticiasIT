<?php
include "includes/checkLogged.php";

//Si no es admin, comprobar que el alumno/profesor este matriculado/imparta clases en la asignatura
if ($perfil != "admin") {
    $filas = listar("SELECT * FROM matriculado_en where nombre_unico_asignatura='$asignatura' AND email_usuario='$email'");
    if (count($filas) == 0) {
        header('Location: pagina_no_encontrada.php');
    }
}

$nombre_asignatura = listar("SELECT * FROM asignatura where nombre_unico_asignatura='$asignatura'")[0]['nombre'];
?>

<html lang="es">
    <head>
        <title><?php echo $nombre_asignatura . " - Clases"; ?></title>
        <?php
        include "includes/headContent.php";
        ?>
    </head>
    <body>
        <?php
        include "includes/header.php";
        ?>
        <div class="container upoboard-margin-navbar" >
            <h1>Clases virtuales</h1>
            <table class="table table-responsive-sm">
                <thead>
                    <tr>
                        <th scope="col">Clase</th>
                        <th scope="col">Fecha publicación</th>
                        <th scope="col">Fecha entrega de tests</th>
                        <th scope="col">Número de vídeos</th>
                    </tr>
                </thead>
                <tbody>            
                    <?php
                    $hoy = date("Y-m-d"); 
                    $clases = listar("SELECT * FROM clase where nombre_unico_asignatura='$asignatura' AND fecha_publicacion <= '$hoy' ORDER BY fecha_publicacion DESC");
                    foreach ($clases as $clase) {
                        $id_clase= $clase['id_clase'];
                        $descripcion = $clase['descripcion'];
                        $fecha_publicacion = $clase['fecha_publicacion'];
                        $date = strtotime($fecha_publicacion);
                        $fecha_publicacion = date("d-m-Y", $date);
                        $fecha_entrega = $clase['fecha_entrega'];
                        $date = strtotime($fecha_entrega);
                        $fecha_entrega = date("d-m-Y", $date);
                        $numero_videos = count(explode(";*;", $clase['videos']));
                        echo "
                        <tr>
                            <th scope='row'><a href='ver_clase.php?asignatura=$asignatura&clase=$id_clase'>$descripcion</a></th>
                            <td>$fecha_publicacion</td>
                            <td>$fecha_entrega</td>
                            <td>$numero_videos</td>
                         </tr>";
                    }
                    ?>

                </tbody>
            </table>

        </div>

    </body>
</html>

