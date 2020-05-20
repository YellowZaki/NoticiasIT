<%@page import="pojos.Usuario"%>
<%@page import="dao.noticiaDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="pojos.Noticia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html>
<html lang="es">
    <head>

        <s:if test="%{anuncio!=null}">
            <title>Editar anuncio</title>
        </s:if>
        <s:else>
            <title>Crear anuncio</title>
        </s:else>

        <%@include file="includes/checkUsuarioAdmin.jsp"%>
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

                                    <s:if test="%{anuncio!=null}">
                                        Editando anuncio...
                                    </s:if>
                                    <s:else>
                                        Crear anuncio
                                    </s:else>


                                </h3>
                            </div>

                            <div class="card-body">
                                <s:form action="crearEditarAnuncioSubmit" cssClass="needs-validation" method="POST">
                                    
                                    <div class="form-group">
                                        <s:if test="%{anuncio!=null}">
                                            <label for="link">Link</label>
                                            <input type="text" required class="form-control" value="<s:property value="%{anuncio.getLink()}"/>" disabled />
                                            <s:hidden name="link" value="%{anuncio.getLink()}"/>
                                        </s:if>
                                        <s:else>
                                            <label for="link">Link</label>
                                            <input type="text" required class="form-control" name="link"/>
                                        </s:else>
                                        <s:fielderror fieldName="link"/>
                                    </div>
                                    
                                    <div class="form-group">
                                        <s:if test="%{anuncio!=null}">
                                            <label for="titulo">Titulo</label>
                                            <input type="text" required class="form-control" name="titulo" value="<s:property value="anuncio.getTitulo()"/>"/>
                                        </s:if>
                                        <s:else>
                                            <label for="titulo">Titulo</label>
                                            <input type="text" required class="form-control" name="titulo"/>
                                        </s:else>
                                            <s:fielderror fieldName="titulo"/>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="imagen">Imagen</label>
                                        <s:if test="%{anuncio!=null}">
                                            <input type="text" required class="form-control" name="imagen" value="<s:property value="anuncio.getImagen()"/>" />
                                            <input type="hidden" name="actualizar" value="actualizar"/>

                                        </s:if>
                                        <s:else>
                                            <input type="text" required class="form-control" name="imagen"/>
                                        </s:else>
                                        <s:fielderror fieldName="imagen"/>
                                    </div> 
                                    
                                    <div class="form-group">
                                        <s:select cssClass="btn btn-primary dropdown-toggle" theme="simple" name="temaAnuncio" list="temas" listValue="nombreTema"  listKey="nombreTema"></s:select>
                                    </div>


                                    <div class="form-group">
                                        <div class="d-flex">
                                            <input type="submit" name="altaAnuncio" class="btn btn-primary ml-auto" theme="simple" value="Confirmar"/>
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
