<%-- 
    Document   : editar_anadir_carpeta
    Created on : 06-may-2020, 11:59:12
    Author     : juani_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Pagina de prueba</title>
        <%@include file="includes/headContent.jsp"%>
        <style>
            .errorMessage {
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
        <%@include file="includes/header.jsp"%>
        <div class="container aggregator-margin-navbar">
            <div class="row">
                <div class="col-md-12 d-flex flex-column justify-content-center">
                    <div class="col-lg-9 col-md-8 mx-auto">                           
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0">

                                    <s:if test="%{carpeta!=null}">
                                        Editando carpeta...
                                    </s:if>
                                    <s:else>
                                        Crear carpeta
                                    </s:else>


                                </h3>
                            </div>
                            <div class="card-body">
                                <s:form action="CrearEditarCarpetaSubmit" cssClass="needs-validation" method="POST">

                                    <label for="titulo">Título</label>
                                    <s:if test="%{carpeta!=null}">
                                        <input required class="form-control" name="nombre" value="<s:property value="carpeta.getNombreCarpeta()"/>" />
                                    </s:if>
                                    <s:else>
                                        <!--<input required class="form-control" name="nombre"/>-->
                                        <s:textfield name="nombre" cssClass="form-control" theme="simple"></s:textfield>
                                        <s:fielderror fieldName="nombre"/>
                                    </s:else>                                 
                                                                     
                                     <s:if test="%{carpeta!=null}">
                                        <input type="hidden" name="nombreOriginal" value="<s:property value="carpeta.getNombreCarpeta()"/>" />
                                    </s:if>
                                        <s:hidden name="nombre_usuario" value="%{#session.usuario.getUsuario()}"></s:hidden>
                                        <s:hidden name="id_carpeta" value="%{carpeta.getIdCarpeta().toString()}"></s:hidden>
                                        <s:hidden name="validar" value="true"></s:hidden>
                                    <div class="form-group">
                                        <div class="d-flex">
                                            <input type="submit" name="altaCarpeta" class="btn btn-primary ml-auto" theme="simple" value="Confirmar"/>
                                        </div>
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
