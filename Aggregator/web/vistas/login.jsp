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
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>aggregator</h1>
            <p>El aula virtual de clases no presenciales</p>
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
                                        <s:textfield name="username" label="Nombre de usuario" cssClass="form-control" theme="simple"></s:textfield>
                                        </div>
                                        <div class="form-group">
                                        <s:password name="password" label="Contraseña" cssClass="form-control" theme="simple"></s:password>
                                        </div>
                                        <div class="d-flex">                                            
                                        <s:submit name="btnLogin" value="Entrar" cssClass="btn btn-primary" theme="simple"></s:submit>
                                        <s:form action="/register.jsp">
                                            <s:submit name="btnRegistro" value="Registrarse" cssClass="btn btn-primary ml-auto" theme="simple"></s:submit>
                                        </s:form>
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
