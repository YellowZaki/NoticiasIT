<%-- 
    Document   : crear_noticia
    Created on : 01-may-2020, 16:19:03
    Author     : hecto
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="pojos.Noticia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="includes/headContent.jsp"%>
<%    String titulo = "Crear Noticia";
    String idNoticia = (String) session.getAttribute("idNoticia");
    Noticia noticia = null;
    if (idNoticia != null) {
        titulo = "Editar Noticia";
        //noticia =  NoticiaDAO.getNoticia(idNoticia);
    }%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title><%=titulo%></title>
    </head>
    <body>
        <div class="container upoboard-margin-navbar">
            <div class="row">
                <div class="col-md-12 d-flex flex-column justify-content-center">
                    <div class="col-lg-9 col-md-8 mx-auto">                           
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0"><%=titulo%></h3>
                            </div>
                            <div class="card-body">
                                <s:form action="crear_editar_noticia" cssClass="needs-validation" method="POST" novalidate>
                                    <div class="form-group">
                                        <label for="titulo">Título</label>
                                        <s:textfield required cssClass="form-control" name="titulo" 
                                        <%if (idNoticia != null) {%>  
                                        value="<%= noticia.getTitulo()%>"
                                        <%}%>
                                                     />
                                        </div>

                                        <div class="form-group">
                                            <label for="descripcion">Descripción</label>
                                        <s:textarea required class="form-control" name='descripcion' rows="10" <%if (idNoticia != null) {%>  
                                                value="<%= noticia.getDescripcion()%>"
                                                <%}%>
                                                    />   
                                                </div>  
                                                <div class="form-group">
                                                    <label for="fuente">Fuente</label>
                                                    <s:textfield required cssClass="form-control" name="fuente" 
                                                    <%if (idNoticia != null) {%>  
                                                    value="<%= noticia.getFuente()%>"
                                                    <%}%>
                                                                 />
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
