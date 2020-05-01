<!--NO MODIFICAR ESTO, COPIAR PEGAR DE AQUI
NO MODIFICAR ESTO, COPIAR PEGAR DE AQUI
NO MODIFICAR ESTO, COPIAR PEGAR DE AQUI
NO MODIFICAR ESTO, COPIAR PEGAR DE AQUI
NO MODIFICAR ESTO, COPIAR PEGAR DE AQUI
NO MODIFICAR ESTO, COPIAR PEGAR DE AQUI-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Pagina de prueba</title>
        <%@include file="includes/headContent.jsp"%>
    </head>
    <body>

        <div class="container aggregator-margin-navbar">
            Aqui va el contenido
            <div class="row">
                <div class="mr-auto"><h1>Header de prueba</h1></div>
            </div>
            
            
            
            <s:action name="NoticiaCard" flush="true" executeResult="true" ignoreContextParams="true">

                <s:param name="id" value="test">test</s:param>
            </s:action>
            
        </div>
    </body>
</html>
