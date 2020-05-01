<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">    
<!--JQuery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!--Bootstrap JS-->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<!--Font awesome(iconos)-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css">
<!--JS y CSS propio-->
<script src="js/anadirVideosTests.js"></script>
<script src="js/gestorTareas.js"></script>
<script src="js/inactividad.js"></script>
<link rel="stylesheet" href="css/gestorTareas.css">
<!-- PLugin JQUERY: Color picker-->
<script src="js/colorPick.min.js"></script>
<link rel="stylesheet" href="css/colorPick.css">
<!-- Plugin JQUERY: datepicker-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.es.min.js"></script>
<!-- Uso de plugins-->
<script src="js/upoboard.js"></script>

<?php
//PERSONALIZACION

if (isset($email)) {
    $personalizacion = listar("SELECT * FROM personalizacion WHERE email_usuario='$email'")[0];
    $color_primario = $personalizacion['color_primario'];
    $tema_oscuro = $personalizacion['tema_oscuro'];
    $mostrar_encabezado = $personalizacion['mostrar_encabezado'];
} else {
    $color_primario = "#007bff";
    $tema_oscuro = false;
    $mostrar_encabezado = true;
}

//MODO OSCURO
if ($tema_oscuro) {
    ?>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/darkly/bootstrap.min.css">
    <?php
} else {
    ?>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <?php
}

//CAMBIO DE COLOR PRIMARIO
//función que oscurece un color
function darken_color($rgb, $darker = 2) {
    $hash = (strpos($rgb, '#') !== false) ? '#' : '';
    $rgb = (strlen($rgb) == 7) ? str_replace('#', '', $rgb) : ((strlen($rgb) == 6) ? $rgb : false);
    if (strlen($rgb) != 6)
        return $hash . '000000';
    $darker = ($darker > 1) ? $darker : 1;
    list($R16, $G16, $B16) = str_split($rgb, 2);
    $R = sprintf("%02X", floor(hexdec($R16) / $darker));
    $G = sprintf("%02X", floor(hexdec($G16) / $darker));
    $B = sprintf("%02X", floor(hexdec($B16) / $darker));
    return $hash . $R . $G . $B;
}

$color_primario_oscuro = darken_color($color_primario, 1.2);
$color_primario_oscuroplus = darken_color($color_primario, 1.5);
$color_flechas = str_replace("#", "", $color_primario);
?>
<style>
    .btn-primary {
        background-color: <?php echo $color_primario; ?>;
        border-color: <?php echo $color_primario; ?>;
    }
    .btn-primary:hover {
        background-color: <?php echo $color_primario_oscuro; ?>;
        border-color: <?php echo $color_primario_oscuro; ?>;
    }
    .btn-primary:active {
        background-color: <?php echo $color_primario_oscuroplus; ?>!important;
        border-color: <?php echo $color_primario_oscuroplus; ?>!important;
    }  
    .btn-primary:focus {
        background-color: <?php echo $color_primario_oscuroplus; ?>!important;
        border-color: <?php echo $color_primario_oscuroplus; ?>!important;
    }        

    .carousel-control-prev-icon {
        background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23<?php echo $color_flechas; ?>' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E");
    }

    .carousel-control-next-icon {
        background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23<?php echo $color_flechas; ?>' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E");
    }    

    .principal {
        background: <?php echo $color_primario; ?>;
    }    

    .principal .formulario .boton {
        border: 1px solid <?php echo $color_primario; ?>;
    }

    .principal .formulario input[type=text].error {
        border: 5px solid <?php echo $color_primario_oscuro; ?>;
    }

    .upoboard-margin-navbar {
        margin-bottom:50px;
        margin-top:<?php
        if ($mostrar_encabezado) {
            echo "40px";
        } else {
            echo "105px";
        };
        ?>;
    }



    .btn-circle.btn-xl {
        width: 55px;
        height: 55px;
        padding: 10px 16px;
        border-radius: 35px;
        font-size: 20px;
        line-height: 1.33;
    }

    .btn-circle {
        width: 30px;
        height: 30px;
        padding: 6px 0px;
        border-radius: 15px;
        text-align: center;
        font-size: 12px;
        line-height: 1.42857;
    }
    
    .fixed-botton-btn {
        bottom: 45px;
        right: 24px;
        position: fixed;
        z-index: 997;
    }


</style>