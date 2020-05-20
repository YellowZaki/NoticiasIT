



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
                    <h5>Parece que no tienes permisos para acceder a esta página</h5>
                    <h6>Puede ser que tengas que loguearte antes de poder realizar esta acción.</h6>
                </div>
            </div>
            <div class="row">
                <div class="d-flex ml-auto">
                    <a href="

                       <s:url action="ListaNoticias">
                           <s:param name="pag">1</s:param>
                       </s:url>

                       ">
                        <button class="btn btn-primary">Volver</button>

                    </a>
                </div>
            </div>
        </div>
    </body>
</html>