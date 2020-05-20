<%-- 
    Document   : ver_carpeta
    Created on : 19-may-2020, 18:35:58
    Author     : juani_000
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Pagina de prueba</title>
        <%@include file="includes/headContent.jsp"%>
        <%@include file="includes/checkLogin.jsp"%>
    </head>
    <body>
        <%@include file="includes/header.jsp"%>
        <div class="container aggregator-margin-navbar">
            <div class="row">
                <div class="mr-auto"><h1><s:property value="%{carpeta.getNombreCarpeta()}"/></h1></div>
                <div class="ml-auto">                    

                </div>
            </div>
            <table class="table table-responsive-sm">
                <thead>
                    <tr>
                        <th scope="col">Título de la noticia</th>
                        <th scope="col">Acción</th>
                    </tr>
                </thead>
                <tbody>                    
                    <s:iterator value="noticias" var="noticia">
                        <tr>
                            <td><a href='
                                   <s:url action="VerNoticia">
                                       <s:param name="id"><s:property value="%{#noticia.idNoticia}"/></s:param>
                                   </s:url>

                                   '><s:property value="%{#noticia.titulo}"/></a></td>
                            <td>
                                <a href='
                                   <s:url action="BorrarNoticiaDeCarpeta">
                                       <s:param name="id_noticia"><s:property value="%{#noticia.idNoticia}"/></s:param>
                                       <s:param name="id_carpeta"><s:property value="%{carpeta.getIdCarpeta().toString()}"/></s:param>
                                       <s:param name="nombre_usuario"><s:property value="%{#session.usuario.getUsuario()}"/></s:param>
                                   </s:url>
                                   ' class='btn btn-primary add-new'><i class='fa fa-minus'></i> Quitar de esta carpeta</a>                                   
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>
    </body>
</html>
