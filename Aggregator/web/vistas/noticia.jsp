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
                        <h3 class="mb-0">titulo</h3>
                    </div>
                    <div class="card-body">
                        Body
                    </div>

                    <s:property value="idd"/>
                </div>
            </div>
        </div>
    </div>
</div>