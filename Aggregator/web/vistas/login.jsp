<%-- 
    Document   : register
    Created on : 01-may-2020, 13:41:12
    Author     : Alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Login</title>
        <%@include file="includes/headContent.jsp"%>
    </head>
    <body>
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>aggregator</h1>
            <p>El aula virtual de clases no presenciales</p>
        </div>
        <div class="container aggregator-margin-navbar">
            <div class="row">
                <div class="col-md-12 d-flex flex-column justify-content-center">
                    <div class="col-lg-6 col-md-8 mx-auto">
                        <?php
                        if ($user_o_pass_incorrecto) {
                            echo "<h4>Usuario/contraseña incorrectos</h4>";
                        }
                        ?>
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0">Login</h3>
                            </div>
                            <div class="card-body">
                                <form method="POST">
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input name="email" type="email" class="form-control" id="email" placeholder="Introduce email">
                                        <div class="invalid-feedback">
                                            Debes rellenar este campo
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="pass">Contraseña</label>
                                        <input name="pass" type="password" class="form-control" id="pass" placeholder="Introduce contraseña">
                                    </div>
                                    <div class="d-flex">
                                        <button name="login" type="submit" class="btn btn-primary">Entrar</button>
                                        <a href="register.php" class="btn btn-primary ml-auto">Registrarse</a>  
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
