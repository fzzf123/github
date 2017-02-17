<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  session.removeAttribute("user");  //清空Session变量
  response.sendRedirect("login.jsp");
%>