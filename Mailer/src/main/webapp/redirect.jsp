<%-- 
    Document   : redirect
    Created on : Apr 20, 2016, 2:09:05 PM
    Author     : CodeFire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setStatus(301);
    response.setHeader("Location", "index.html");
    response.setHeader("Connection", "close");
%>
