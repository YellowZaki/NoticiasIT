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
        <title><?php echo "Listado de usuarios"; ?></title>
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
                <div class="mr-auto"><h1>Usuarios</h1></div>
            </div>

            <table class="table table-responsive-sm">
                <thead>
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Perfil</th>
                        <th scope="col">Acción</th>
                    </tr>
                </thead>
                <tbody>

                    <?php
                    $valores = listar("SELECT * FROM usuario");
                    foreach ($valores as $valor) {
                        $nombre = $valor["nombre"];
                        $apellidos = $valor["apellidos"];
                        $email_usuario = $valor["email_usuario"];
                        $perfil_usuario = $valor["perfil"];
                        echo "                    <tr>
                        <th scope='row'>$nombre</th>
                        <td>$apellidos</td>"
                        . "<td>$perfil_usuario</td>";
                        if ($perfil == "admin") {
                            echo "";
                        }

                        echo "<td>";
                        if ($perfil == "admin" || $perfil == "profesor") {
                            $filas = listar("SELECT * FROM matriculado_en where nombre_unico_asignatura='$asignatura' AND email_usuario='$email_usuario'");
                            if (count($filas) == 0 && $perfil_usuario == "alumno") {
                                echo "<a href='matricular.php?asignatura=$asignatura&usuario=$email_usuario' class='btn btn-primary add-new'><i class='fa fa-plus'></i> Matricular</a>  ";
                            } else if (count($filas) == 1 && $perfil_usuario == "alumno") {
                                echo "<a href='ver_calificaciones.php?asignatura=$asignatura&usuario=$email_usuario' class='btn btn-primary add-new'><i class='fa fa-plus'></i> Ver calificaciones</a>  ";
                            }
                            if ((($perfil_usuario != "profesor" && $perfil_usuario != "admin") || ($perfil_usuario == "profesor" && count($filas) == 0)) && $perfil == "admin") {
                                echo "<a href='convertir_profesor.php?asignatura=$asignatura&usuario=$email_usuario&perfil_usuario=$perfil_usuario' class='btn btn-primary add-new'><i class='fa fa-plus'></i> Convertir a profesor</a>";
                            }
                        }
                        echo "</td>"
                        . "</tr>";
                    }
                    ?>
                </tbody>
            </table>
        </div>
    </body>
</html>

