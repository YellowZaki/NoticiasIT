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
                <div class="col-9">
                    <div class="row">
                        <div class="col-md-12 d-flex flex-column justify-content-center">
                            <div class="col-lg-9 col-md-8 mx-auto"> 

                                <s:action name="NoticiaCard" ignoreContextParams="true" executeResult="true">
                                    <s:param name="id"><s:property value="noticia.idNoticia" /></s:param>
                                </s:action>

                            </div>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 d-flex flex-column justify-content-center">
                            <div class="col-lg-9 col-md-8 mx-auto"> 
                                <br>
                                <h2>Comentarios</h2>
                                <s:if test='#session.containsKey("usuario")'>
                                    <s:form action="nuevoComentario" style="width:100%;" theme="simple">
                                        <s:textarea name="textoComentario" cols="40" rows="5" style="width: 100%;"/> 
                                        <input type="hidden" name="id_noticia" value="<s:property value="noticia.idNoticia" />"/>

                                        <s:submit cssClass="btn btn-primary" value="Comentar" name="submit" />


                                    </s:form>                         
                                </s:if>


                                <br>


                                <div class="panel panel-default widget">

                                    <div class="panel-body">
                                        <ul class="list-group">




                                            <s:iterator value="noticia.comentarios" var="comentario">
                                                <li class="list-group-item">
                                                    <div class="row">
                                                        <div class="col-2">
                                                            <img style="border-radius: 50%;" src="image/avatar.jpg" class="img-circle img-responsive" alt="" />
                                                        </div>
                                                        <div class="col1">

                                                        </div>
                                                        <div class="col-4">
                                                            <div>
                                                                <br>
                                                                <div class="mic-info">
                                                                    Por: <a href="#"><s:property value="#comentario.usuario.usuario" /></a> el <s:date name="#comentario.fechaPublicacion" format="dd/MM/yyyy" />
                                                                </div>
                                                            </div>
                                                            <div class="comment-text">
                                                                <s:property value="#comentario.texto" />
                                                            </div>

                                                            <s:if test='#session.containsKey("usuario")'>
                                                                <s:if test="%{#session.usuario.getUsuario() == #comentario.usuario.getUsuario()}">
                                                                    <div class="action">
                                                                        <a href='
                                                                           <s:url action="EditarComentario">
                                                                               <s:param name="id_comentario"><s:property value="#comentario.idComentario"/></s:param>
                                                                           </s:url>

                                                                           '><i style='color:orange;' class='fas fa-edit'></i></a>

                                                                        <a href='
                                                                           <s:url action="borrarComentario">
                                                                               <s:param name="id_comentario"><s:property value="#comentario.idComentario"/></s:param>
                                                                           </s:url>

                                                                           '><i style='color:red;' class='fas fa-trash'></i></a>
                                                                    </div>                                                          

                                                                </s:if> 

                                                            </s:if> 



                                                        </div>
                                                    </div>
                                                </li>

                                            </s:iterator>    



                                        </ul>
                                    </div>
                                </div>            



                            </div>
                        </div>
                    </div>
                </div>
                <div class="">
                    <!--                    Espacio vacio-->
                </div>   
                <div class="col-3">
                    AQUI VAN LOS ANUNCIOS
                </div>

            </div> 




        </div>
    </body>
</html>
