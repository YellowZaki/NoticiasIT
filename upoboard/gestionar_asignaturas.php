<?php
include "includes/checkLogged.php";
if ($perfil != "admin") {
    header("Location: clases?asignatura=$asignatura.php");
}
?>

<html lang="es">
    <head>
        <title><?php echo "Gestión de asignaturas"; ?></title>
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
                <div class="mr-auto"><h1>Asignaturas</h1></div>
                <div class="ml-auto">
                    <?php echo "<a href='editar_anadir_asignatura.php?asignatura=$asignatura' class='btn btn-primary add-new'><i class='fa fa-plus'></i> Añadir</a>" ?>
                </div>
            </div>
            <table class="table table-responsive-sm">
                <thead>
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Nombre único</th>
                        <th scope="col">Acción</th>
                    </tr>
                </thead>
                <tbody>                   
                    <?php
                    $valores = listar("SELECT * FROM asignatura");
                    foreach ($valores as $valor) {
                        $nombre = $valor["nombre"];
                        $nombre_uniq = $valor["nombre_unico_asignatura"];
                        echo "                    <tr>
                        <th scope='row'>$nombre</th>
                        <td>$nombre_uniq</td>
                        <td>
                            <a href='editar_anadir_asignatura.php?asignatura=$asignatura&editar_asignatura=$nombre_uniq'><i style='color:orange;' class='fas fa-edit'></i></a>
                            <a href='borrar_asignatura.php?asignatura=$asignatura&editar_asignatura=$nombre_uniq'><i style='color:red;' class='fas fa-trash'></i></a>                            
                        </td>
                    </tr>";
                    }
                    ?>
                   
                </tbody>
            </table>
        </div>
    </body>
</html>

