<?php
if ($mostrar_encabezado) {
    ?>
    <div class="jumbotron text-center" style="margin-bottom:-20px">
        <h1>AGGREGATOR</h1>
        <p>Lo agrega TORR</p>
    </div>
    <?php
}
?>

<nav class="navbar navbar-expand-md bg-dark navbar-dark justify-content-center <?php
if (!$mostrar_encabezado) {
    echo " fixed-top";
};
?>">

    <div class="container">
        <?php
        if ($asignatura != "none") {
            ?>
            <div class="dropdown mr-auto">
                <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <?php
                    $nombre_asignatura = listar("SELECT * FROM asignatura WHERE nombre_unico_asignatura='$asignatura'")[0]['nombre'];
                    echo $nombre_asignatura;
                    ?>
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <?php
                    if ($perfil != "admin") {
                        $asignaturas = listar("SELECT * FROM asignatura NATURAL JOIN matriculado_en WHERE email_usuario='$email' AND nombre_unico_asignatura!='$asignatura'");
                    } else {
                        $asignaturas = listar("SELECT * FROM asignatura WHERE nombre_unico_asignatura!='$asignatura'");
                    }

                    foreach ($asignaturas as $asig) {
                        $nombre_asig = $asig['nombre'];
                        $nombre_unic_asig = $asig['nombre_unico_asignatura'];
                        $uri_parts = explode('?', $_SERVER['REQUEST_URI'], 2);

                        echo "<a class='dropdown-item' href='$uri_parts[0]?asignatura=$nombre_unic_asig'>$nombre_asig</a>";
                    }
                    ?>
                </div>
            </div>
            <?php
        }
        ?>


        <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#prueba" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse ml-5" id="prueba">

            <ul class="navbar-nav mx-auto">
                <li class="nav-item">
                    <?php
                    echo "<a class='nav-link' href='clases.php?asignatura=$asignatura'>Clases</a>";
                    ?>

                </li>
                <li class="nav-item">
                    <?php
                    echo "<a class='nav-link' href='ver_calificaciones.php?asignatura=$asignatura&usuario=$email'>Mis calificaciones</a>";
                    ?>
                </li>
                <?php
                if (($perfil == "admin" || $perfil == "profesor")) {
                    echo "                                    <li class='nav-item'>
                    <a class='nav-link' href='gestionar_clases.php?asignatura=$asignatura'>Gestionar clases</a>
                </li>";
                    echo "                                    <li class='nav-item'>
                    <a class='nav-link' href='listar_alumnos.php?asignatura=$asignatura'>Gestionar usuarios</a>
                </li>";
                }

                if ($perfil == "admin") {
                    echo "                                    <li class='nav-item'>
                    <a class='nav-link' href='gestionar_asignaturas.php?asignatura=$asignatura'>Gestionar asignaturas</a>
                </li>";
                }
                ?>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="config.php<?php echo "?asignatura=$asignatura"; ?>"><i class="fa fa-cog"></i></a> </li>
                <li class="nav-item"><a class="nav-link" href="logout.php"><i class="fas fa-sign-out-alt"></i></a> </li>

            </ul>
        </div>
    </div>
</nav>


<div class="modal" id="tareasModal" tabindex="-1">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-body" style="padding:0">
                <button id="cerrarTareasModel" type="button" class="close">
                    <span>&times;</span>
                </button>
                <div class="principal">
                    <div class="wrap">
                        <form class="formulario" action="">
                            <input type="text" id="tareaInput" placeholder="Añadir Tarea">
                            <input type="button" class="boton" id="btn-agregar" value="+ Añadir tarea">
                        </form>
                    </div>
                </div>

                <div class="tareas">
                    <div class="wrap">
                        <ul class="lista" id="lista">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<button id="abrirTareasModel" type="button" class="btn btn-primary btn-circle btn-xl fixed-botton-btn"><i class="fas fa-pen"></i></button>