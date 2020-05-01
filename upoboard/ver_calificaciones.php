<?php
include "includes/checkLogged.php";
if (!isset($asignatura)) {
    header("Location: clases?asignatura=$asignatura.php");
}
//Profesor/Alumno puede ver esa asignatura?
if ($perfil != "admin") {
    $filas = listar("SELECT * FROM matriculado_en where nombre_unico_asignatura='$asignatura' AND email_usuario='$email'");
    if (count($filas) == 0) {
        header('Location: pagina_no_encontrada.php');
    }
}

if (isset($_GET['usuario'])) {
    $usuario = filter_input(INPUT_GET, 'usuario', FILTER_SANITIZE_STRING);
    //No permitir que alumno pueda ver calificaciones de otros
    if ($perfil == "alumno") {
        $usuario = $email;
    }
} else {
    header("Location: ver_calificaciones.php?asignatura=$asignatura&usuario=$email");
}

$nombre_asignatura = listar("SELECT * FROM asignatura where nombre_unico_asignatura='$asignatura'")[0]['nombre'];
?>

<html lang="es">
    <head>
        <title><?php echo "Calificaciones de " . $nombre_asignatura; ?></title>
        <?php
        include "includes/headContent.php";
        ?>
    </head>
    <body>
        <?php
        include "includes/header.php";
        ?>
        <div class="container upoboard-margin-navbar">
            <?php
            echo "<h2>Calificaciones de $nombre_asignatura</h2>";
            ?>
            <table class="table table-responsive-sm">
                <thead>
                    <tr>
                        <th scope="col">Nota</th>
                        <th scope="col">Descripción</th>
                        <th scope="col">Fecha entrega</th>
                        <?php
                        if ($perfil != "alumno") {
                            echo "<th scope='col'>Acción</th>";
                        }
                        ?>

                    </tr>
                </thead>
                <tbody>
                    <?php
                    $hoy = date("Y-m-d");
                    $clases = listar("SELECT * FROM clase where nombre_unico_asignatura='$asignatura' AND fecha_publicacion <= '$hoy' ORDER BY fecha_entrega DESC");
                    $index = 0;
                    foreach ($clases as $clase) {
                        $fecha_entrega = $clase['fecha_entrega'];
                        $descripcion = $clase['descripcion'];
                        $id_clase = $clase['id_clase'];
                        $nota = listar("SELECT * FROM resultadotests WHERE email_usuario='$usuario' AND id_clase='$id_clase'");
                        if (count($nota) > 0) {
                            $nota = $nota[0]['nota'];
                        } else {
                            if ($hoy > $fecha_entrega) {
                                $nota = "0 (No entregado)";
                            } else {
                                $nota = "Aún no entregado";
                            }
                        }
                        echo "<tr> <th scope='row'>$nota</th>
                        <td>$descripcion</td>
                        <td>$fecha_entrega</td>";
                        if ($perfil != "alumno") {
                            $acciones = "";
                            if ($nota == "0 (No entregado)" || $nota == "Aún no entregado") {
                                $acciones = "No disponible (no entregado/atrasado)";
                            } else {
                                $acciones = "                            <a href='editar_calificacion.php?asignatura=$asignatura&clase=$id_clase&usuario=$usuario'><i style='color:orange;' class='fas fa-edit'></i></a>
                            <a href='borrar_calificacion.php?asignatura=$asignatura&clase=$id_clase&usuario=$usuario'><i style='color:red;' class='fas fa-trash'></i></a>   ";
                            }

                            echo "<td>
                         $acciones
                        </td>";
                        }
                        echo "</tr>";
                    }
                    ?>
                </tbody>
            </table>             
        </div>
    </body>
</html>

