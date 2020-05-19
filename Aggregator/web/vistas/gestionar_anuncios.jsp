<%-- 
    Document   : gestionar_temas
    Created on : 08-may-2020, 23:35:23
    Author     : hecto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Gestión Anuncios</title>
        <%@include file="includes/headContent.jsp"%>
    </head>
    <body>
        <%@include file="includes/checkUsuarioAdmin.jsp"%>
        <%@include file="includes/header.jsp"%>
        <div class="container aggregator-margin-navbar">
            <div class="row">
                <div class="mr-auto"><h1>Anuncios</h1></div>
                <div class="ml-auto">                    
                    <a href='
                       <s:url action="CrearEditarAnuncio">
                       </s:url>
                       ' class='btn btn-primary add-new'><i class='fa fa-plus'></i> Añadir</a>
                </div>
            </div>
            <table class="table table-responsive-sm">
                <thead>
                    <tr>
                        <th scope="col">Link</th>
                        <th scope="col">Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="anuncios" var="anuncio">
                        <tr>
                            <td><s:property value="%{#anuncio.getLink()}"/></td>
                            <td>
                                <a href='
                                   <s:url action="CrearEditarAnuncio">
                                       <s:param name="anuncioCrearEditar"><s:property value="%{#anuncio.getLink()}"/></s:param>
                                   </s:url>
                                   '><i style='color:orange;' class='fas fa-edit'></i></a>
                                <a href='
                                   <s:url action="BorrarAnuncio">
                                       <s:param name="anuncioBorrar"><s:property value="%{#anuncio.getLink()}"/></s:param>
                                       <s:param name="noValidar"><s:property value="noValidar"/></s:param>
                                   </s:url>
                                   '><i style='color:red;' class='fas fa-trash'></i></a>                            

                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>
    </body>
</html>
