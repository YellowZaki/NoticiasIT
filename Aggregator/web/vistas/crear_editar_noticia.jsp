<%@page import="dao.noticiaDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="pojos.Noticia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html>
<html lang="es">
    <head>

        <s:if test="%{noticia!=null}">
            <title>Editar noticia</title>
        </s:if>
        <s:else>
            <title>Crear noticia</title>
        </s:else>
        <%@include file="includes/headContent.jsp"%>
    </head>
    <body>
        <%@include file="includes/header.jsp"%>
        <div class="container aggregator-margin-navbar">
            <div class="row">
                <div class="col-md-12 d-flex flex-column justify-content-center">
                    <div class="col-lg-9 col-md-8 mx-auto">                           
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0">

                                    <s:if test="%{noticia!=null}">
                                        Editando noticia...
                                    </s:if>
                                    <s:else>
                                        Crear noticia
                                    </s:else>


                                </h3>
                            </div>
                            <div class="card-body">
                                <s:form action="crearEditarNoticia" cssClass="needs-validation" method="POST">

                                    <label for="titulo">Título</label>
                                    <s:if test="%{noticia!=null}">
                                        <input required class="form-control" name="titulo" value="<s:property value="noticia.getTitulo()"/>" />
                                    </s:if>
                                    <s:else>
                                        <input required class="form-control" name="titulo"/>
                                    </s:else>

                                    <div class="form-group">
                                        <label for="descripcion">Descripción</label>
                                        <s:if test="%{noticia!=null}">
                                            <input required class="form-control" name="descripcion" value="<s:property value="noticia.getDescripcion()"/>" />
                                        </s:if>
                                        <s:else>
                                            <input required class="form-control" name="descripcion"/>
                                        </s:else>  
                                    </div> 

                                    <div class="form-group">
                                        <label for="fuente">Fuente</label>
                                        <s:if test="%{noticia!=null}">
                                            <input required class="form-control" name="fuente" value="<s:property value="noticia.getFuente()"/>" />
                                        </s:if>
                                        <s:else>
                                            <input required class="form-control" name="fuente"/>
                                        </s:else>
                                    </div>

                                    <div class="form-group">
                                        <div class="d-flex">
                                            <input type="submit" name="altaNoticia" class="btn btn-primary ml-auto" theme="simple" value="Confirmar"/>
                                        </div>
                                    </div>
                                </s:form>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
