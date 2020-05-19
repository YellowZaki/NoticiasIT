<%-- 
    Document   : editar_comentario
    Created on : 19-may-2020, 17:31:10
    Author     : Alberto
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
        <div class="container aggregator-margin-navbar row d-flex justify-content-center">
            <div class="col-md-2"> 
                <s:form action="EditarComentarioSubmit">
                    <textarea name="textoComentario" cols="40" rows="5"><s:property value="comentario.texto" /></textarea>
                    <input type="hidden" name="id_comentario" value="<s:property value="comentario.idComentario" />"/>
                    
                  <s:submit cssClass="btn btn-primary" value="Actualizar comentario" name="submit" />
                </s:form>   
            </div>

        </div>
    </body>
</html>