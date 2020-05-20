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

        <s:if test="%{noticia!=null}">
            <title>Editar noticia</title>
            <s:if test="%{noticia.getUsuario()!= session.usuario.getUsuario().getUsuario()}">
                <%
                    response.sendRedirect(request.getContextPath() + "/paginaNoEncontrada.jsp");
                %>
            </s:if>
        </s:if>
        <s:else>
            <title>Crear noticia</title>
        </s:else>
        <%@include file="includes/headContent.jsp"%>
        <%@include file="includes/checkLogin.jsp"%>
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
                                <s:form theme="simple" action="CrearEditarNoticiaSubmit" cssClass="needs-validation">

                                    <s:if test="%{noticia!=null}">
                                        <s:hidden name="id" value="%{noticia.getIdNoticia()}"/>
                                    </s:if>

                                    <div class="form-group">
                                        <label for="titulo">Título</label>
                                        <s:if test="%{noticia!=null}">
                                            <s:textfield cssClass="form-control" name="titulo" value="%{noticia.getTitulo()}" />
                                        </s:if>
                                        <s:else>
                                            <s:textfield cssClass="form-control" name="titulo"/>
                                        </s:else>
                                        <s:fielderror fieldName="titulo"/>
                                    </div>


                                    <div class="form-group">
                                        <label for="descripcion">Descripción</label>
                                        <s:if test="%{noticia!=null}">
                                            <s:textfield cssClass="form-control" name="descripcion" value="%{noticia.getDescripcion()}" />
                                            <s:fielderror fieldName="descripcion"/>
                                        </s:if>
                                        <s:else>
                                            <s:textfield cssClass="form-control" name="descripcion"/>
                                            <s:fielderror fieldName="descripcion"/>
                                        </s:else>
                                        
                                    </div> 


                                    <div class="form-group">
                                        <label for="fuente">Fuente</label>
                                        <s:if test="%{noticia!=null}">
                                            <s:textfield cssClass="form-control" name="fuente" value="%{noticia.getFuente()}" />
                                        </s:if>
                                        <s:else>
                                            <s:textfield cssClass="form-control" name="fuente"/>
                                        </s:else>
                                        <s:fielderror fieldName="fuente"/>
                                    </div>



                                    <div class="form-group">
                                        <s:select cssClass="btn btn-primary dropdown-toggle" theme="simple" name="temaNoticia" list="temas" listValue="nombreTema"  listKey="nombreTema"></s:select>
                                        </div>

                                        <div class="form-group">
                                            <div class="d-flex">
                                            <s:submit name="altaNoticia" cssClass="btn btn-primary ml-auto" theme="simple" value="Confirmar"/>
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
