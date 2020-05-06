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
        <title>Pagina de prueba</title>
        <%@include file="includes/headContent.jsp"%>
    </head>
    <body>
        <%@include file="includes/header.jsp"%>
        <div class="container aggregator-margin-navbar">
            <div class="row">
                <div class="mr-auto"><h1>Carpetas</h1></div>
                <div class="ml-auto">                    
                    <a href='
                       <s:url action="EditarAnadirCarpeta">
                       </s:url>
                       ' class='btn btn-primary add-new'><i class='fa fa-plus'></i> Añadir</a>
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
                            <td><s:property value="%{#carpeta.getNombreCarpeta()}"/></td>
                            <td><s:if test="%{noticia!=null}">
                                    <s:form action="AnadirNoticiaACarpeta">
                                        <s:submit name="btnAsocial" value="Añadir a esta carpeta" cssClass='btn btn-primary add-new'></s:submit>
                                        <s:hidden name="id_noticia" value="%{noticia.getIdNoticia()}"></s:hidden>
                                        <s:hidden name="nombre_carpeta" value="%{#carpeta.getNombreCarpeta()}"></s:hidden>
                                        <s:hidden name="nombre_usuario" value="%{#session.usuario.getUsuario()}"></s:hidden>
                                    </s:form>                                    
                                </s:if>
                                <s:else>
                                    <a href='
                                       <s:url action="EditarAnadirCarpeta">
                                           <s:param name="nombre_carpeta"><s:property value="%{#carpeta.getNombreCarpeta()}"/></s:param>
                                           <s:param name="nombre_usuario"><s:property value="%{#session.usuario.getUsuario()}"/></s:param>
                                       </s:url>
                                       '><i style='color:orange;' class='fas fa-edit'></i></a>
                                    <a href='
                                       <s:url action="BorrarCarpeta">
                                           <s:param name="nombre_carpeta"><s:property value="%{#carpeta.getNombreCarpeta()}"/></s:param>
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
