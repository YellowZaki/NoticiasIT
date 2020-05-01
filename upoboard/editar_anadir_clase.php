<?php
include "includes/checkLogged.php";
$modo = "";
if ($perfil == "alumno") {
    header("Location: clases?asignatura=$asignatura.php");
}
if (!isset($asignatura) && !isset($_GET['clase'])) {
    header("Location: clases?asignatura=$asignatura.php");
}
if (isset($_GET['clase'])) {
    $id_clase = filter_input(INPUT_GET, 'clase', FILTER_SANITIZE_STRING);
    $filas = listar("SELECT * FROM clase where id_clase='$id_clase'");
    //Existe clase?
    if (count($filas) == 0) {
        header("Location: clases?asignatura=$asignatura.php");
    }
    //A qué asignatura pertenece la clase?
    $asignatura = $filas[0]['nombre_unico_asignatura'];
    $modo = "editar";
} else {
    if (isset($asignatura)) {
        //El profesor tiene permisos en esta asignatura?
        if ($perfil != "admin") {
            $filas = listar("SELECT * FROM matriculado_en where nombre_unico_asignatura='$asignatura' AND email_usuario='$email'");
            if (count($filas) == 0) {
                header("Location: clases?asignatura=$asignatura.php");
            }
        }
        $modo = "anadir";
    } else {
        header("Location: clases?asignatura=$asignatura.php");
    }
}
?>
<?php
if (isset($_POST['editar'])) {
    $fecha_publicacion = filter_input(INPUT_POST, 'fecha-publicacion', FILTER_SANITIZE_STRING);
    $fecha_entrega = filter_input(INPUT_POST, 'fecha-entrega', FILTER_SANITIZE_STRING);
    $descripcion = filter_input(INPUT_POST, 'descripcion', FILTER_SANITIZE_STRING);
    $contador = filter_input(INPUT_POST, 'contador', FILTER_SANITIZE_NUMBER_INT);
    //Convertimos al formato de Mysql
    $date = strtotime($fecha_publicacion);
    $fecha_publicacion = date("Y-m-d", $date);
    $date = strtotime($fecha_entrega);
    $fecha_entrega = date("Y-m-d", $date);

    $contadorVideos = filter_input(INPUT_POST, 'contadorVideos', FILTER_SANITIZE_NUMBER_INT);
    $videos_array = [];
    for ($i = 0; $i < $contadorVideos; $i++) {
        if (isset($_POST['video-' . $i])) {
            $video = filter_input(INPUT_POST, 'video-' . $i, FILTER_SANITIZE_STRING);
            $videos_array [] = $video;
        }
    }
    $videos = implode(";*;", $videos_array);
    //Insertamos/Actualizamos los datos que no tienen que ver con los tests...
    if ($modo == "editar") {
        insertar("UPDATE clase SET descripcion='$descripcion',fecha_publicacion='$fecha_publicacion',fecha_entrega='$fecha_entrega',videos='$videos' WHERE id_clase = '$id_clase'");
    } else {
        $id_clase = insertarAndGetLastId("INSERT INTO `clase` (`fecha_publicacion`, `fecha_entrega`, `descripcion`, `videos`, `nombre_unico_asignatura`) VALUES ('$fecha_publicacion', '$fecha_entrega', '$descripcion', '$videos', '$asignatura')");
    }

    //Insertamos los datos de los tests
    insertar("DELETE FROM test WHERE id_clase='$id_clase'");
    for ($i = 0; $i < $contador; $i++) {
        if (isset($_POST['pregunta-' . $i])) {
            //Procesar test
            $pregunta_test = filter_input(INPUT_POST, 'pregunta-' . $i, FILTER_SANITIZE_STRING);
            $respuesta0 = filter_input(INPUT_POST, 'respuesta-' . $i . '-0', FILTER_SANITIZE_STRING);
            $respuesta1 = filter_input(INPUT_POST, 'respuesta-' . $i . '-1', FILTER_SANITIZE_STRING);
            $respuesta2 = filter_input(INPUT_POST, 'respuesta-' . $i . '-2', FILTER_SANITIZE_STRING);
            $respuesta3 = filter_input(INPUT_POST, 'respuesta-' . $i . '-3', FILTER_SANITIZE_STRING);
            $array_respuestas = [];
            $array_respuestas [] = $respuesta0;
            $array_respuestas [] = $respuesta1;
            $array_respuestas [] = $respuesta2;
            $array_respuestas [] = $respuesta3;
            $respuestas = implode(";*;", $array_respuestas);
            $respuesta_correcta = filter_input(INPUT_POST, 'correcta-' . $i, FILTER_SANITIZE_NUMBER_INT);
            insertar("INSERT INTO `test` (`respuestas`, `respuesta_correcta`, `pregunta`, `id_clase`) VALUES ('$respuestas', '$respuesta_correcta', '$pregunta_test', '$id_clase')");
        }
    }
    header('Location: gestionar_clases.php?asignatura=' . $asignatura);
}
?>

<html lang="es">
    <head>
        <title><?php echo "Editar/Añadir clase"; ?></title>
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
                                <h3 class="mb-0"><?php
                                    if ($modo == "editar") {
                                        echo "Editar clase";
                                        $datosClase = listar("SELECT * FROM clase WHERE id_clase = '$id_clase'")[0];
                                    } else {
                                        echo "Crear clase";
                                    }
                                    ?></h3>
                            </div>
                            <div class="card-body">
                                <form action="#" class="needs-validation" method="POST" novalidate>
                                    <div class='row'>
                                        <div class="form-group col">
                                            <label for="fecha-publicacion">Fecha de publicación</label>
                                            <input required name="fecha-publicacion" type="text" class="form-control datepicker" id="fecha-publicacion" 
                                            <?php
                                            if ($modo == "editar") {
                                                $fecha_publicacion = $datosClase["fecha_publicacion"];
                                                $date = strtotime($fecha_publicacion);
                                                $fecha_publicacion_format = date("d-m-Y", $date);
                                                echo " value='$fecha_publicacion_format'";
                                            }
                                            ?>
                                                   >
                                            <small class="form-text text-muted">
                                                A partir de qué fecha estará disponible para los alumnos
                                            </small>
                                            <div class="invalid-feedback">
                                                Debes rellenar este campo
                                            </div>
                                        </div>
                                        <div class="form-group col">
                                            <label for="fecha-entrega">Fecha límite entrega de tests</label>
                                            <input required name="fecha-entrega" type="text" class="form-control datepicker" id="fecha-entrega"

                                                   <?php
                                                   if ($modo == "editar") {
                                                       $fecha_entrega = $datosClase["fecha_entrega"];
                                                       $date = strtotime($fecha_entrega);
                                                       $fecha_entrega_format = date("d-m-Y", $date);
                                                       echo " value='$fecha_entrega_format'";
                                                   }
                                                   ?>>
                                            <div class="invalid-feedback">Debes rellenar este campo</div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="descripcion">Descripción</label>
                                        <textarea required class="form-control" id="descripcion" name='descripcion' rows="3"><?php
                                            if ($modo == "editar") {
                                                $descripcion = $datosClase["descripcion"];
                                                echo $descripcion;
                                            }
                                            ?></textarea>
                                    </div>  
                                    <div id="videos_clase">
                                        <label for="fecha-entrega">Vídeos</label>
                                        <div class="form-group form-inline">
                                            <input required name="video-0" type="url" class="form-control col-md-11" placeholder='https://www.youtube.com/watch?v=yeaHCauqIwM' 
                                            <?php
                                            if ($modo == "editar") {
                                                $videos = $datosClase["videos"];
                                                $videos = explode(";*;", $videos);
                                                $primervideo = $videos[0];
                                                echo " value='$primervideo'";
                                            }
                                            $contadorVideos = 1;
                                            ?>>
                                        </div>
                                        <?php
                                        if ($modo == "editar") {
                                            $videos = $datosClase["videos"];
                                            $videos = explode(";*;", $videos);

                                            foreach ($videos as $video) {
                                                if ($contadorVideos != 1) {
                                                    echo "
                                        <div class='form-group form-inline'>
                                            <input value='$video' required name='video-$contadorVideos' type='url' class='form-control col-md-11' placeholder='https://www.youtube.com/watch?v=yeaHCauqIwM'>
                                            <i style='color:red;' class='eliminarVideo col-md-1 fas fa-trash'></i> 
                                        </div>";
                                                }
                                                $contadorVideos++;
                                            }
                                        }
                                        ?>                                        
                                    </div>
                                    <div class="text-center">
                                        <a id='anadirVideo' class="btn btn-primary add-new" style='color:white;'><i class="fa fa-plus"></i> Añadir vídeo</a>
                                    </div>                                    

                                    <div id="tests">
                                        <label>Tests</label>
                                        <?php
                                        if ($modo == "editar") {
                                            $datosTests = listar("SELECT * FROM test where id_clase='$id_clase'");
                                            $contador = 0;
                                            foreach ($datosTests as $datoTest) {
                                                $pregunta = $datoTest['pregunta'];

                                                echo "
                                      <div class='card rounded shadow shadow-sm'>
                                        <div class='card-header'>
                                            <div class='row p-2'>
                                                <input value='$pregunta' name='pregunta-$contador' class='form-control col-md-11 ' required type='text' placeholder='Pregunta'>
                                                <i style='color:red;' class='eliminarTest col-md-1 mt-2 fas fa-trash'></i> 
                                            </div>
                                        </div>
                                        <div class='card-body'>";
                                                $respuestas = $datoTest['respuestas'];
                                                $respuestas = explode(";*;", $respuestas);
                                                $respuesta_correcta = $datoTest['respuesta_correcta'];
                                                for ($i = 0; $i < 4; $i++) {
                                                    $respuesta = $respuestas[$i];
                                                    $checked = "";
                                                    if ($i == $respuesta_correcta) {
                                                        $checked = "checked";
                                                    }
                                                    echo "
                                            <div class='col form-group mb-0 p-2 form-row form-check form-check-inline'>
                                                <input value='$respuesta' name='respuesta-$contador-$i' class='form-control col-md-11' required type='text'>
                                                <input $checked class='form-check-input col-md-1 mr-auto' type='radio' name='correcta-$contador' value='$i' required>
                                            </div> ";
                                                }

                                                echo "</div>                               
                                    </div>";
                                                $contador++;
                                            }
                                        }
                                        ?>
                                    </div>
                                    <div class="text-center mt-3">
                                        <a id='anadirTest' class="btn btn-primary add-new" style='color:white;'><i class="fa fa-plus"></i> Añadir test</a>
                                    </div>
                                    <br>
                                    <?php
                                    if (!isset($contador)) {
                                        $contador = 0;
                                    }
                                    if (!isset($contadorVideos)) {
                                        $contadorVideos = 1;
                                    }
                                    echo "<input type='hidden' id='contadorTest' name='contador' value='$contador'>";
                                    echo "<input type='hidden' id='contadorVideos' name='contadorVideos' value='$contadorVideos'>";
                                    ?>
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

