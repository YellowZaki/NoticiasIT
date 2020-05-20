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
            <div class="row mb-5">
                <div class="mr-auto"><h1>Últimas noticias</h1></div>
            </div>


            <div class="row">
                <div class="col-8">
                    <s:iterator value="noticias" var="noticia0">
                        <s:action name="NoticiaCard" ignoreContextParams="true" executeResult="true">
                            <s:param name="id"><s:property value="#noticia0.idNoticia" /></s:param>
                        </s:action>
                        <br>
                    </s:iterator>
                </div>
                <div class="col-1">
                    <!--                    Espacio vacio-->
                </div>   
                <div class="col-3">
                    <div class="btn-group-vertical" style="width: 100%;">
                        <s:iterator value="temas" var="tema">
                            <a style='background-image: url(<s:property value="#tema.getImagen()"></s:property>); height: 75px'  href='
                            <s:url action="ListaNoticias">
                                <s:param name="tema"><s:property value="#tema.getNombreTema()"/></s:param>
                            </s:url>
                              ' class="btn btn-secondary" role="button">
                               <s:property value="#tema.getNombreTema()"></s:property>
                           </a>
                        </s:iterator>
                    </div>
                </div>

            </div>


            <div class="row mt-5">
                <div class="col-8">
                    <nav>
                        <ul style="list-style: none;">
                            <div class="row">
                                <div class="col">
                                    <s:if test="%{pag!=null}">
                                        <s:if test="%{pag > 1}">
                                            <li class="page-item">
                                                <a class="page-link" href="
                                                   <s:url action="ListaNoticias">
                                                       <s:param name="pag">1</s:param>
                                                   </s:url>
                                                   " tabindex="-1">Página anterior</a>
                                            </li>
                                        </s:if>
                                    </s:if>

                                </div>
                                <div class="col"></div>
                                <div class="col"></div>
                                <div class="col">

                                    <li class="page-item float-right">
                                        <a class="page-link" href="
                                           <s:url action="ListaNoticias">
                                               <s:param name="pag">2</s:param>
                                           </s:url>

                                           ">Página siguiente</a>
                                    </li>

                                </div>
                            </div>


                        </ul>
                    </nav>    
                </div>

            </div>
            <s:if test="%{#session.usuario != null}">
                <a href="
               <s:url action="CrearEditarNoticia">
               </s:url>
               " class="btn btn-primary btn-circle btn-xl fixed-botton-btn" role="button"><i class="fas fa-pen"></i></a>
            </s:if>
            
               
               
        </div>
    </body>
</html>
