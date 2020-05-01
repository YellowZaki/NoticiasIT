<?php

include "includes/checkLogged.php";
if ($perfil != "admin") {
    header('Location: pagina_no_encontrada.php');
}
if (isset($_GET['usuario']) && isset($_GET['perfil_usuario'])) {
    $email_usuario = filter_input(INPUT_GET, 'usuario', FILTER_SANITIZE_STRING);
    $perfil_usuario = filter_input(INPUT_GET, 'perfil_usuario', FILTER_SANITIZE_STRING);
    
    if($perfil_usuario != "profesor"){
        insertar("UPDATE usuario SET perfil = 'profesor' WHERE email_usuario = '$email_usuario'");
        insertar("DELETE FROM matriculado_en email_usuario = '$email_usuario'");        
    }
    insertar("INSERT INTO `matriculado_en` (`email_usuario`, `nombre_unico_asignatura`) VALUES ('$email_usuario', '$asignatura')");
    
    header("Location: listar_alumnos.php?asignatura=$asignatura");
    
}
else {
    header("Location: clases?asignatura=$asignatura.php");
}



?>