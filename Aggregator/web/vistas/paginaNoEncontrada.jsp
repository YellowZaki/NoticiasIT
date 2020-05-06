



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
                <div class="mr-auto">
                    <h1>Página no encontrada</h1>
                    <h5>Parece que no tienes permisos para acceder a esta página </h5>
                </div>
            </div>
            <div class="form-group">
                <div class="d-flex">
                    <input type="submit" name="altaNoticia" class="btn btn-primary ml-auto" theme="simple" value="Confirmar"/>
                </div>
            </div>
        </div>
    </body>
</html>