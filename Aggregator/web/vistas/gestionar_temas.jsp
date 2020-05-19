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
        <title>Pagina de prueba</title>
        <%@include file="includes/headContent.jsp"%>
    </head>
    <body>
        <%@include file="includes/checkUsuarioAdmin.jsp"%>
        <%@include file="includes/header.jsp"%>
        <div class="container aggregator-margin-navbar">
            <div class="row">
                <div class="mr-auto"><h1>Temas</h1></div>
                <div class="ml-auto">                    
                    <a href='
                       <s:url action="CrearEditarTema">
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
                    <<s:iterator value="temas" var="tema">
                        <tr>
                            <td><s:property value="%{#tema.getNombreTema()}"/></td>
                            <td>
                                <a href='
                                   <s:url action="CrearEditarTema">
                                       <s:param name="temaCrearEditar"><s:property value="%{#tema.getNombreTema()}"/></s:param>
                                   </s:url>
                                   '><i style='color:orange;' class='fas fa-edit'></i></a>
                                <a href='
                                   <s:url action="BorrarTema">
                                       <s:param name="temaBorrar"><s:property value="%{#tema.getNombreTema()}"/></s:param>
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
