
<%@page import="java.awt.Color"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">    
<!--JQuery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!--Bootstrap JS-->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<!--Font awesome(iconos)-->
<!--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css">-->

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<!--JS y CSS propio-->
<script src="js/votosAjax.js"></script>
<link rel="stylesheet" href="css/gestorTareas.css">
<!-- PLugin JQUERY: Color picker-->
<script src="js/colorPick.min.js"></script>
<link rel="stylesheet" href="css/colorPick.css">
<!-- Plugin JQUERY: datepicker-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.es.min.js"></script>
<!-- Uso de plugins-->
<!--<script src="js/aggregator.js"></script>-->

<%!
    public static String darkenColor(String colorStr, int factor) {
        String colorStrr = colorStr;

        Color color = new Color(
                Integer.valueOf(colorStrr.substring(1, 3), 16),
                Integer.valueOf(colorStrr.substring(3, 5), 16),
                Integer.valueOf(colorStrr.substring(5, 7), 16));
        Color darkercolor = color;
        for (int i = 0; i < factor; i++) {
            darkercolor = color.darker();
        }
        return "rgb(" + darkercolor.getRed() + "," + darkercolor.getGreen() + "," + darkercolor.getBlue() + ")";
    }


%>

<%

    String color_primario = "#007bff";
    boolean tema_oscuro = false;
    boolean mostrar_encabezado = true;
    //Comprobar si la variable de sesion usuario está establecida y tomar su personalizacion
    if (false) {
        //$personalizacion = 
        //$color_primario = $personalizacion['color_primario'];
        //$tema_oscuro = $personalizacion['tema_oscuro'];
        //$mostrar_encabezado = $personalizacion['mostrar_encabezado'];
    }

//CAMBIO DE COLOR PRIMARIO
//función que oscurece un color
//public static String darken_color($rgb, $darker = 2) {
//    $hash = (strpos($rgb, '#') !== false) ? '#' : '';
//    $rgb = (strlen($rgb) == 7) ? str_replace('#', '', $rgb) : ((strlen($rgb) == 6) ? $rgb : false);
//    if (strlen($rgb) != 6)
//        return $hash . '000000';
//    $darker = ($darker > 1) ? $darker : 1;
//    list($R16, $G16, $B16) = str_split($rgb, 2);
//    $R = sprintf("%02X", floor(hexdec($R16) / $darker));
//    $G = sprintf("%02X", floor(hexdec($G16) / $darker));
//    $B = sprintf("%02X", floor(hexdec($B16) / $darker));
//    return $hash . $R . $G . $B;
//}
    String color_primario_oscuro = darkenColor(color_primario, 1);
    String color_primario_oscuroplus = darkenColor(color_primario, 1);
//$color_flechas = str_replace("#", "", $color_primario);
//MODO OSCURO
    if (tema_oscuro) {
%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/darkly/bootstrap.min.css">
<%
} else {
%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<%
    }


%>






<style>
    .btn-primary {
        background-color: <%=color_primario%>;
        border-color: <%=color_primario%>>;
    }
    .btn-primary:hover {
        background-color: <%=color_primario_oscuro%>;
        border-color: <%=color_primario_oscuro%>;
    }
    .btn-primary:active {
        background-color: <%=color_primario_oscuroplus%>!important;
        border-color: <%=color_primario_oscuroplus%>!important;
    }  
    .btn-primary:focus {
        background-color: <%=color_primario_oscuroplus%>!important;
        border-color: <%=color_primario_oscuroplus%>!important;
    }        

    .carousel-control-prev-icon {
        background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23<?php echo $color_flechas; ?>' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E");
    }

    .carousel-control-next-icon {
        background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23<?php echo $color_flechas; ?>' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E");
    }    

    .colorPickSelector {
        border-radius:5px;
        width:36px;
        height:36px;
        cursor:pointer;
        -webkit-transition:all linear .2s;
        -moz-transition:all linear .2s;
        -ms-transition:all linear .2s;
        -o-transition:all linear .2s;
        transition:all linear .2s;
    }
            
    .principal {
        background: <%=color_primario%>;
    }    

    .principal .formulario .boton {
        border: 1px solid <%=color_primario%>;
    }

    .principal .formulario input[type=text].error {
        border: 5px solid <%=color_primario%>;
    }

    .aggregator-margin-navbar {
        margin-bottom:50px;
        margin-top:

            <%
                if (mostrar_encabezado) {
            %>
            40px
            <%
            } else {
            %>
            105px
            <%
                }
            %>
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
