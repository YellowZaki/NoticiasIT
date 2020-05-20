<%-- 
    Document   : perfil
    Created on : 18-may-2020, 18:11:33
    Author     : Andrés Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Perfil</title>  
        <%@include file="includes/headContent.jsp"%>
        
    </head>
    <body>
        <%@include file="includes/header.jsp"%>
        <div class="container aggregator-margin-navbar">
            <div class="row">
                <div class="mr-auto">

                </div>
                <div class="col-md-12 d-flex flex-column justify-content-center">
                    <div class="col-lg-7 col-md-8 mx-auto">
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0">Datos personales</h3>
                            </div>
                            <div class="card-body">
                                <s:form cssClass="needs-validation" theme="simple" action="modificarUsuario">
                                    <div class="form-group">
                                        <label for="nombre">Nombre de usuario: </label>
                                        <s:textfield value="%{#session.usuario.getUsuario()}" theme="simple" cssClass="form-control" name="nombre" disabled="true"></s:textfield>
                                        </div>

                                        <div class="form-group">
                                            <label for="correo">Correo: </label>
                                        <s:textfield value="%{#session.usuario.getEmail()}" theme="simple" cssClass="form-control" name="email"></s:textfield>
                                        <s:fielderror fieldName="email"/>
                                    </div>

                                    <div class="custom-control custom-switch">
                                        <s:set var="mostrarEncabezadoValue">false</s:set>
                                        <s:if test="%{#session.usuario.personalizacion.mostrarEncabezado == 1}">
                                            <s:set var="mostrarEncabezadoValue">true</s:set>
                                        </s:if>
                                        <s:checkbox name="mostrarEncabezado" id="mostrarEncabezado" cssClass="custom-control-input" theme="simple" value="#mostrarEncabezadoValue"></s:checkbox>

                                            <label class="custom-control-label" for="mostrarEncabezado">Mostrar encabezado</label>
                                            <small  class="form-text text-muted">
                                                Cuando se oculta el encabezado, además la navegación queda fija arriba
                                            </small>
                                        </div>

                                        <div class="custom-control custom-switch mt-3">
                                        <s:set var="temaOscuroValue">false</s:set>
                                        <s:if test="%{#session.usuario.personalizacion.modoOscuro == 1}">
                                            <s:set var="temaOscuroValue">true</s:set>
                                        </s:if>
                                        <s:checkbox name="temaOscuro" id="temaOscuro" cssClass="custom-control-input form-check-input" value="#temaOscuroValue"></s:checkbox>
                                            <label class="custom-control-label" for="temaOscuro">Tema oscuro</label>                                      
                                            <small  class="form-text text-muted">
                                                Da un descanso a tus ojos por la noche
                                            </small>
                                        </div>     
                                        <div class="form-group mt-3">
                                        <s:hidden name="color_primario" id="color_primario" value="%{#session.get('usuario').getPersonalizacion().getColorPrimario()}"></s:hidden>
                                            <label for="color_primario">Color primario</label>
                                            <div class="colorPickSelector"></div>
                                        </div>
                                        <div class="text-center mt-3">
                                        <s:submit cssClass="btn btn-primary" name="modificarCuenta" value="Guardar" theme="simple"></s:submit>
                                        </div>

                                        <div class="text-center mt-5">
                                        <s:submit cssClass="btn btn-danger" name="modificarCuenta" value="Eliminar cuenta" theme="simple"></s:submit>
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
