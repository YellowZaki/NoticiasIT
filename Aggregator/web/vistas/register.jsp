<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Registrarse</title>
        <%@include file="includes/headContent.jsp"%>
        <s:head/>
        
        <style>
            ul {
                list-style: none;
                margin: 10px 0px;
                padding:7px;
                color: #D8000C;
                background-color: #FFD2D2;
                border: 1px solid red;
                border-radius: 5px;
            }
        </style>
    </head>
    <body>
        <div class="jumbotron text-center">
            <h1>AGGREGATOR</h1>
            <p>Agregador de noticias</p>
        </div>

        <div class="container upoboard-margin-navbar">
            <div class="row">
                <div class="col-md-12 d-flex flex-column justify-content-center">
                    <div class="col-lg-6 col-md-8 mx-auto">
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0">Registro</h3>
                            </div>
                            <div class="card-body">
                                <s:form action="registrar" theme="simple">
                                    <div class="form-group">
                                        <label>Nombre de usuario</label>
                                        <s:textfield name="usuario" cssClass="form-control"></s:textfield><s:fielderror fieldName="usuario"/>
                                        <s:if test="%{#session.get('errorUsuario') != null}">
                                            <span style="color:red"><s:property value="#session.get('errorUsuario')"></s:property></span>
                                        </s:if>
                                    </div>
                                    <div class="form-group">
                                        <label>Email</label>
                                        <s:textfield name="email" cssClass="form-control"></s:textfield> <s:fielderror fieldName="email"/>
                                        <s:if test="%{#session.get('errorEmail') != null}">
                                            <span style="color:red"><s:property value="#session.get('errorEmail')"></s:property></span>
                                        </s:if>
                                    </div>
                                    <div class="form-group">
                                        <label>Contraseña</label>
                                        <s:password name="clave" cssClass="form-control"></s:password><s:fielderror fieldName="clave"/>
                                    </div>
                                    
                                    <s:submit name="registrar" cssClass="btn btn-primary" value="Registrar"></s:submit>
                                </s:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>