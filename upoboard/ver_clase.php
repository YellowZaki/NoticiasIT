<?php
include "includes/checkLogged.php";
if (!isset($asignatura) && !isset($_GET['clase'])) {
    header("Location: clases?asignatura=$asignatura.php");
}
if (isset($_GET['clase'])) {
    $id_clase = filter_input(INPUT_GET, 'clase', FILTER_SANITIZE_STRING);
    $filas = listar("SELECT * FROM clase where id_clase='$id_clase'");
    if (count($filas) == 0) {
        header('Location: pagina_no_encontrada.php');
    }
    //A qué asignatura pertenece la clase?
    $asignatura = $filas[0]['nombre_unico_asignatura'];
    //Profesor/alumno tiene permisos en la asignatura?
    if ($perfil != "admin") {
        $filas = listar("SELECT * FROM matriculado_en where nombre_unico_asignatura='$asignatura' AND email_usuario='$email'");
        if (count($filas) == 0) {
            header('Location: pagina_no_encontrada.php');
        }
    }
} else {
    header("Location: clases.php?asignatura=$asignatura");
}

$nombre_asignatura = listar("SELECT * FROM asignatura where nombre_unico_asignatura='$asignatura'")[0]['nombre'];
?>
<?php
if (isset($_POST['enviar'])) {
    $filas = listar("SELECT * FROM resultadotests WHERE id_clase='$id_clase' AND email_usuario='$email'");
    //Si el usuario aún no ha realizado los tests
    if (count($filas) == 0) {
        $tests_clase = listar("SELECT * FROM test WHERE id_clase='$id_clase'");
        $divisor = 0;
        $nota = 0;
        foreach ($tests_clase as $test_clase) {
            $id_test = $test_clase['id_test'];
            $respuesta_correcta = $test_clase['respuesta_correcta'];
            if (isset($_POST['respuesta-' . $id_test])) {
                $respuesta_elegida = filter_input(INPUT_POST, 'respuesta-' . $id_test, FILTER_SANITIZE_NUMBER_INT);
                if ($respuesta_elegida == $respuesta_correcta) {
                    $nota = $nota + 10;
                }
            } else {
                //ERROR GRAVE, usuario ha modificado la página?
                header('Location: pagina_no_encontrada.php');
            }
            $divisor++;
        }
        //Si no habia que hacer ningun test, solo por haber visto los vídeos tiene un 10
        if ($divisor == 0) {
            $nota_final = 10;
        } else {
            $nota_final = $nota / $divisor;
        }
        insertar("INSERT INTO `resultadotests` (`nota`, `id_clase`, `email_usuario`) VALUES ('$nota_final', '$id_clase', '$email')");
    }
}
$datosClase = listar("SELECT * FROM clase WHERE id_clase='$id_clase'")[0];
?>

<html lang="es">
    <head>
        <title><?php echo "Clase de " . $nombre_asignatura; ?></title>
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
            $fecha_publicacion = $datosClase['fecha_publicacion'];
            $fecha_entrega = $datosClase['fecha_entrega'];
            $date = strtotime($fecha_publicacion);
            $fecha_publicacion = date("d-m-Y", $date);
            echo "<h2>Clase del $fecha_publicacion - $nombre_asignatura</h2>";
            $descripcion = $datosClase['descripcion'];
            echo "<small>$descripcion</small>";
            ?>

            <div id="carousel_videos" class='carousel slide mt-7' data-ride="false" data-interval="false">
                <div class="carousel-inner">
                    <?php
                    $videos = $datosClase['videos'];
                    $videos = explode(";*;", $videos);
                    $active = " active";
                    foreach ($videos as $video) {
                        $video = str_replace("watch?v=", "/embed/", $video);
                        echo "
                    <div class='carousel-item$active'>
                        <div class='embed-responsive embed-responsive-16by9'>
                            <iframe class='embed-responsive-item' src='$video' allowfullscreen></iframe>
                        </div>
                    </div>";
                        $active = "";
                    }
                    ?>
                </div>
                <!-- Left and right controls -->
                <a class="carousel-control-prev" href="#carousel_videos" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#carousel_videos" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
            <br>
            <?php
            $filas = listar("SELECT * FROM resultadotests WHERE id_clase='$id_clase' AND email_usuario='$email'");
            //Usuario aún no ha hecho test
            if (count($filas) == 0) {
                $hoy = date("Y-m-d");
                if ($hoy <= $fecha_entrega) {
                    ?>
                    <hr>
                    <form action="#" class="needs-validation" method="POST" novalidate>
                        <div id="carousel_test" class="carousel slide" data-ride="false" data-interval="false">
                            <div class="carousel-inner" style="width: 70%;margin: auto;">
                                <?php
                                $datosTests = listar("SELECT * FROM test WHERE id_clase='$id_clase'");
                                $active = " active";
                                $contador = 0;
                                foreach ($datosTests as $test) {
                                    $id_test = $test['id_test'];
                                    $pregunta = $test['pregunta'];
                                    $respuestas = $test['respuestas'];
                                    echo "
                        <div class='carousel-item$active'>
                            <div class='card rounded shadow shadow-sm mt-4' style=''>
                                <div class='card-header'>
                                    <div class='row p-2'>
                                        <h4 class='col-md-12'>
                                            $pregunta
                                        </h4>
                                    </div>
                                </div>
                                <div class='card-body'>";
                                    $respuestas = explode(";*;", $respuestas);
                                    for ($i = 0; $i < 4; $i++) {
                                        $respuesta = $respuestas[$i];
                                        echo "
                                <div class='col form-group mb-0 p-2 form-row form-check form-check-inline'>
                                    <div class='col-md-11'>
                                        $respuesta
                                    </div>
                                    <input name='respuesta-$id_test' value='$i' class='form-check-input col-md-1 mr-auto' type='radio' required='required'>
                                </div>";
                                    }
                                    echo "
                        </div>
                            </div>
                        </div>";
                                    $active = "";
                                    $contador++;
                                }
                                echo "<input contador='$contador' type='hidden'>";
                                ?>
                            </div>
                            <!-- Left and right controls -->
                            <a class="carousel-control-prev" href="#carousel_test" data-slide="prev">
                                <span class="carousel-control-prev-icon"></span>
                            </a>
                            <a class="carousel-control-next" href="#carousel_test" data-slide="next">
                                <span class="carousel-control-next-icon"></span>
                            </a>
                        </div>
                        <div class="text-center mt-4">
                            <button name="enviar" type="submit" class="btn btn-primary">Enviar tests</button>
                        </div>
                    </form>


                    <?php
                    //Llegó tarde a completar el test
                } else {
                    ?>
                    <div class="alert alert-danger" role="alert">
                        <h4 class="alert-heading">:(</h4>
                        <p>Llegaste tarde para completar los tests.</p>
                    </div>
                    <?php
                }

                //Usuario ha completado los tests
            } else {
                ?>
                <div class="alert alert-success" role="alert">
                    <h4 class="alert-heading">¡Hecho!</h4>
                    <p>Has completado todos los tests de esta clase. Puedes ver los resultados en la sección Mis calificaciones</p>
                </div>

                <?php
            }
            ?>
        </div>
    </body>
</html>
