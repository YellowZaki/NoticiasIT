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

                <s:action name="NoticiaCard" ignoreContextParams="true" executeResult="true">
                    <s:param name="id"><s:property value="noticia.idNoticia" /></s:param>
                </s:action>
                <div class="row">
                    <div class="col-md-12 d-flex flex-column justify-content-center">
                        <div class="col-lg-9 col-md-8 mx-auto"> 

                            <h2>Comentarios</h2>
                            <br>
                            <br>
                            <s:form action="nuevoComentario">
                                <s:textarea name="textoComentario" cols="40" rows="5"/>  
                                <s:hidden name="id_noticia" value="noticia.idNoticia"></s:hidden>
                                <s:submit value="Comentar" name="submit" />
                            </s:form>

                            <s:iterator value="noticia.comentarios" var="comentario">
                                <s:property value="comentario.texto" />
                            </s:iterator>      

                        </div>
                    </div>
                </div>


            </div>

        </div>
    </body>
</html>
