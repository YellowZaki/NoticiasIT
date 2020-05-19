
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
                                <s:form action="crearEditarTemaSubmit" cssClass="needs-validation" method="POST">


                                    <s:if test="%{tema0!=null}">
                                        <label for="nombreOriginal">Nombre</label>
                                        <input type="text" required class="form-control" name="nombreOriginal" value="<s:property value="tema0.getNombreTema()"/>" disabled />
                                    </s:if>
                                    <s:else>
                                        <label for="nombre">Nombre</label>
                                        <input type="text" required class="form-control" name="nombre"/>
                                    </s:else>

                                    <div class="form-group">
                                        <label for="imagen">Banner</label>
                                        <s:if test="%{tema0!=null}">
                                            <input type="text" required class="form-control" name="imagen" value="<s:property value="tema0.getImagen()"/>" />
                                            <input type="hidden" name="actualizar" value="actualizar"/>

                                        </s:if>
                                        <s:else>
                                            <input type="text" required class="form-control" name="imagen"/>
                                        </s:else>  
                                    </div> 

                                    <s:if test="%{tema0!=null}">
                                        <input type="hidden" name="temaOriginal" value="<s:property value="tema0.getNombreTema()"/>" />
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
