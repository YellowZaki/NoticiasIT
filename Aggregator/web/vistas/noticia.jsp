<%-- 
    Document   : noticia
    Created on : 01-may-2020, 16:09:52
    Author     : Alberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<div class="card rounded shadow shadow-sm">
    <div class="card-header">
        <div class="row">
            <div class="col">
                <h3 class="mb-0"><s:property value="noticia.titulo"/></h3> 
                <h6 style="font-size: 0.8rem;">por <s:property value="noticia.usuario.getUsuario()"/> (<s:date name="noticia.fechaPublicacion" format="dd/MM/yyyy" />)</h6>
            </div>

            <div class="mr-3">
                <!--                    session.usuario.getUsuario()-->



                <s:if test='#session.containsKey("usuario")'>




                    <s:if test="%{#session.usuario.getUsuario() == noticia.usuario.getUsuario()}">
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
                    </s:if>


            </div>        
        </div>
    </div>


    <div class="card-body">
        <s:property value="noticia.descripcion"/>
    </div>

    <div class="card-footer">
        <div class="row">
            <div class="col">
                <s:property value="noticia.comentarios.size()"/> <i class="fas fa-comment" style="color:#a9a9a9;"></i>
            </div>

            <div class="mr-3">
                <i class="fas fa-thumbs-up" style="color:#a9a9a9;" id="like">
                    <s:hidden id="idNoticia" value="%{noticia.idNoticia}" name="idNoticia"></s:hidden>
                    </i> 199 <i class="fas fa-thumbs-down" style="color:#a9a9a9;" id="dislike">
                    <s:hidden id="idNoticia" value="%{noticia.idNoticia}" name="idNoticia"></s:hidden>
                    </i>
                </div>
            </div>

        </div>
    <s:property value="idd"/>
</div>
<!--</div>-->
<!--</div>-->
<!--    </div>
</div>-->
