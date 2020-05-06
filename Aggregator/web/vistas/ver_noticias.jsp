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
                <div class="mr-auto"><h1>Últimas noticias</h1></div>


                <s:iterator value="noticias" var="noticia0">
                    <s:action name="NoticiaCard" ignoreContextParams="true" executeResult="true">
                        <s:param name="id"><s:property value="#noticia0.idNoticia" /></s:param>
                    </s:action>

                </s:iterator>



                <nav>
                    <ul class="pagination">

                        <s:if test="%{pag!=null}">
                            <s:if test="%{pag > 1}">Hello
                        <li class="page-item">
                            <a class="page-link" href="#" tabindex="-1">Página anterior</a>
                        </li>
                            </s:if>
                        </s:if>



                        <li class="page-item">
                            <a class="page-link" href="#">Página siguiente</a>
                        </li>
                    </ul>
                </nav>

            </div>

        </div>
    </body>
</html>
