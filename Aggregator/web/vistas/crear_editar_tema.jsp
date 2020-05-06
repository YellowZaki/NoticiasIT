
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

        <s:if test="%{tema!=null}">
            <title>Editar noticia</title>
        </s:if>
        <s:else>
            <title>Crear noticia</title>
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

                                    <s:if test="%{tema!=null}">
                                        Editando tema...
                                    </s:if>
                                    <s:else>
                                        Crear tema
                                    </s:else>


                                </h3>
                            </div>
                            <div class="card-body">
                                <s:form action="crearEditarTema" cssClass="needs-validation" method="POST">

                                    <label for="nombre">Nombre</label>
                                    <s:if test="%{tema!=null}">
                                        <input type="text" required class="form-control" name="nombre" value="<s:property value="tema.getNombreTema()"/>" />
                                    </s:if>
                                    <s:else>
                                        <input type="text" required class="form-control" name="nombre"/>
                                    </s:else>

                                    <div class="form-group">
                                        <label for="imagen">Banner</label>
                                        <s:if test="%{tema!=null}">
                                            <input type="text" required class="form-control" name="imagen" value="<s:property value="tema.getImagen()"/>" />
                                        </s:if>
                                        <s:else>
                                            <input type="text" required class="form-control" name="imagen"/>
                                        </s:else>  
                                    </div> 
                                        
                                    <s:if test="%{tema!=null}">
                                        <input type="hidden" name="temaOriginal" value="<s:property value="tema.getNombreTema()"/>" />
                                    </s:if>


                                    <div class="form-group">
                                        <div class="d-flex">
                                            <input type="submit" name="altaTema" class="btn btn-primary ml-auto" theme="simple" value="Confirmar"/>
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
