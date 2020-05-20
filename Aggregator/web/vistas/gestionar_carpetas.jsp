<%-- 
    Document   : gestionar_carpetas
    Created on : 06-may-2020, 11:58:52
    Author     : juani_000
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Gestión Carpetas</title>
        <%@include file="includes/headContent.jsp"%>
    </head>
    <body>
        <%@include file="includes/header.jsp"%>
        <div class="container aggregator-margin-navbar">
            <div class="row">
                <div class="mr-auto"><h1>Carpetas</h1></div>
                <div class="ml-auto">
                    <s:if test="%{noticia==null}">
                        <a href='
                           <s:url action="EditarAnadirCarpeta">
                           </s:url>
                           ' class='btn btn-primary add-new'><i class='fa fa-plus'></i> Nueva carpeta</a>
                    </s:if>
                </div>
            </div>
            <table class="table table-responsive-sm">
                <thead>
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="%{#session.usuario.getCarpetas()}" var="carpeta">
                        <tr>
                            <td><a href='
                                   <s:url action="VerCarpeta">
                                       <s:param name="id_carpeta"><s:property value="%{#carpeta.getIdCarpeta().toString()}"/></s:param>
                                       <s:param name="nombre_usuario"><s:property value="%{#session.usuario.getUsuario()}"/></s:param>
                                   </s:url>
                                   '><s:property value="%{#carpeta.getNombreCarpeta()}"/></a>
                            </td>
                            <td><s:if test="%{noticia!=null}">
                                    <a href='
                                       <s:url action="AnadirNoticiaACarpeta">
                                           <s:param name="id_noticia"><s:property value="%{noticia.idNoticia}"/></s:param>
                                           <s:param name="id_carpeta"><s:property value="%{#carpeta.getIdCarpeta().toString()}"/></s:param>
                                           <s:param name="nombre_usuario"><s:property value="%{#session.usuario.getUsuario()}"/></s:param>
                                       </s:url>
                                       ' class='btn btn-primary add-new'><i class='fa fa-plus'></i> Añadir a esta carpeta</a>                                    
                                </s:if>
                                <s:else>
                                    <a href='
                                       <s:url action="EditarAnadirCarpeta">
                                           <s:param name="id_carpeta"><s:property value="%{#carpeta.getIdCarpeta().toString()}"/></s:param>
                                           <s:param name="nombre_usuario"><s:property value="%{#session.usuario.getUsuario()}"/></s:param>
                                       </s:url>
                                       '><i style='color:orange;' class='fas fa-edit'></i></a>
                                    <a href='
                                       <s:url action="BorrarCarpeta">
                                           <s:param name="id_carpeta"><s:property value="%{#carpeta.getIdCarpeta().toString()}"/></s:param>
                                           <s:param name="nombre_usuario"><s:property value="%{#session.usuario.getUsuario()}"/></s:param>
                                       </s:url>
                                       '><i style='color:red;' class='fas fa-trash'></i></a>                            

                                </s:else></td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>
    </body>
</html>
