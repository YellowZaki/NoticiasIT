<%-- 
    Document   : checkUsuarioAdmin
    Created on : 06-may-2020, 12:21:09
    Author     : hecto
--%>

<%@page import="pojos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if ( usuario == null) {
            response.sendRedirect(request.getContextPath() + "/PaginaNoEncontrada");
        }
    %>
</html>
