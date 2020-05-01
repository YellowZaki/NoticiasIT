<%-- 
    Document   : register
    Created on : 01-may-2020, 13:41:12
    Author     : Alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Login</title>
        <%@include file="includes/headContent.jsp"%>
    </head>
    <body>
        <div class="jumbotron text-center">
            <h1>Aggregator</h1>
            <p>Mis cojones adobaos</p>
        </div>
        <div class="container aggregator-margin-navbar">
            <div class="row">
                <div class="col-md-12 d-flex flex-column justify-content-center">
                    <div class="col-lg-6 col-md-8 mx-auto">
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0">Login</h3>
                            </div>
                            <div class="card-body">
                                <s:form action="comprobarLogin">
                                    <div class="form-group">
                                        <label>Nombre de usuario</label>
                                        <s:textfield name="username" cssClass="form-control" theme="simple"></s:textfield>
                                        </div>
                                        <div class="form-group">
                                            <label>Contraseña</label>
                                        <s:password name="password" cssClass="form-control" theme="simple"></s:password>
                                        </div>
                                        <div class="d-flex">                                            
                                        <s:submit name="btnLogin" value="Entrar" cssClass="btn btn-primary" theme="simple"></s:submit>
                                        <a href="register.jsp" class="btn btn-primary ml-auto">Registrarse</a>                                        
                                    </div>                                
                                </s:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
