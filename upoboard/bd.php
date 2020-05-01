<?php


function insertar($sentencia) {
    $con = mysqli_connect("localhost", "upoboard", "");
    if (!$con) {
        die();
        return false;
    }
    mysqli_set_charset($con, "utf8");   
    $db_selected = mysqli_select_db($con, "upoboard");
    if (!$db_selected) {
        die();
        return false;
    }      
    $result = mysqli_query($con, $sentencia);
    if (!$result) {
        return false;        
    }
    $rc = mysqli_affected_rows($con);
    if ($rc < 0) {
        return false; 
    }
    mysqli_close($con);
    return true;
}

function listar($sentencia) {
    $con = mysqli_connect("localhost", "upoboard", "");
    if (!$con) {
        die();
    }
    mysqli_set_charset($con, "utf8");
    $db_selected = mysqli_select_db($con, "upoboard");
    if (!$db_selected) {
        die();
    }     
    $filas = [];
    $result = mysqli_query($con, $sentencia); 
    if (!is_bool($result)) {
        
        while ($row = mysqli_fetch_array($result)) {
            
            $filas [] = $row;
            
        }   
        mysqli_free_result($result);       
    }
    mysqli_close($con);
    return $filas;
}

function insertarAndGetLastId($sentencia) {
    $con = mysqli_connect("localhost", "upoboard", "");
    if (!$con) {
        die();
        return false;
    }
    mysqli_set_charset($con, "utf8");   
    $db_selected = mysqli_select_db($con, "upoboard");
    if (!$db_selected) {
        die();
        return false;
    }      
    $result = mysqli_query($con, $sentencia);
    if (!$result) {
        return false;        
    }
    $last_id = mysqli_insert_id($con);
    
    mysqli_close($con);
    return $last_id;
}