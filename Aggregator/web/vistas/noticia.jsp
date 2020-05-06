<%-- 
    Document   : noticia
    Created on : 01-may-2020, 16:09:52
    Author     : Alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<div class="container aggregator-margin-navbar">

    <div class="row">
        <div class="col-md-12 d-flex flex-column justify-content-center">
            <div class="col-lg-9 col-md-8 mx-auto">                           
                <div class="card rounded shadow shadow-sm">
                    <div class="card-header">
                        <h3 class="mb-0"><s:property value="noticia.titulo"/></h3>
                        <!--                    session.usuario.getUsuario()-->
                        <s:if test="%{'admin' == noticia.usuario.getUsuario()}">
                            <a href='
                               <s:url action="CrearEditarNoticia">
                                   <s:param name="id"><s:property value="noticia.idNoticia"/></s:param>
                               </s:url>

                               '><i style='color:orange;' class='fas fa-edit'></i></a>

                            <a href='
                               <s:url action="BorrarNoticia">
                                   <s:param name="id"><s:property value="noticia.idNoticia"/></s:param>
                               </s:url>

                               '><i style='color:red;' class='fas fa-trash'></i></a>
                              
                        </s:if>
                        <a href='
                               <s:url action="GestionarCarpetas">
                                   <s:param name="id"><s:property value="noticia.idNoticia"/></s:param>
                               </s:url>

                               '><i style='color:darkgrey;' class='fas fa-folder-plus'></i></a>
                    </div>


                    <div class="card-body">
                        <s:property value="noticia.descripcion"/>
                    </div>

                    <div class="card-footer">
                        <div class="row">
                            <div class="col">
                                <s:property value="noticia.comentarios.size()"/> <i class="fas fa-comment" style="color:#a9a9a9;"></i>
                            </div>

                            <div class="float-right mr-3">
                                <i class="fas fa-thumbs-up" style="color:#e85454;"></i> 199 <i class="fas fa-thumbs-down" style="color:#4498ef;"></i>
                            </div>
                        </div>

                    </div>
                    <s:property value="idd"/>
                </div>
            </div>
        </div>
    </div>
</div>