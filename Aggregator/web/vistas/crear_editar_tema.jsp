
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

        <s:if test="%{tema0!=null}">
            <title>Editar tema</title>
        </s:if>
        <s:else>
            <title>Crear tema</title>
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

                                    <s:if test="%{tema0!=null}">
                                        Editando tema...
                                    </s:if>
                                    <s:else>
                                        Crear tema
                                    </s:else>


                                </h3>
                            </div>

                            <div class="card-body">
                                <s:form theme="simple" action="crearEditarTemaSubmit" cssClass="needs-validation" method="POST">

                                    <div class="form-group">
                                        <s:if test="%{tema0!=null}">
                                            <label for="nombreOriginal">Nombre</label>
                                            <s:textfield cssClass="form-control" name="nombreOriginal" value="%{tema0.getNombreTema()}" disabled="true" />
                                        </s:if>
                                        <s:else>
                                            <label for="nombre">Nombre</label>
                                            <s:textfield cssClass="form-control" name="nombre"/>
                                        </s:else>
                                        <s:fielderror fieldName="nombre"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="imagen">Banner</label>
                                        <s:if test="%{tema0!=null}">
                                            <s:textfield cssClass="form-control" name="imagen" value="%{tema0.getImagen()}" />
                                            <s:hidden name="actualizar" value="actualizar"/>

                                        </s:if>
                                        <s:else>
                                            <s:textfield cssClass="form-control" name="imagen"/>
                                        </s:else>
                                            <s:fielderror fieldName="imagen"/>
                                    </div> 

                                    <s:if test="%{tema0!=null}">
                                        <s:hidden name="temaOriginal" value="%{tema0.getNombreTema()}" />
                                    </s:if>


                                    <div class="form-group">
                                        <div class="d-flex">
                                            <s:submit name="altaTema" cssClass="btn btn-primary ml-auto" theme="simple" value="Confirmar"/>
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
