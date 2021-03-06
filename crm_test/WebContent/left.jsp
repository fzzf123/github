<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="${pageContext.request.contextPath}/bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet"/>
    <title></title>
    <link href="${pageContext.request.contextPath}/styles/Common.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/styles/Index.css" rel="stylesheet"/>

</head>
<body>
<div class="header">

    <img class="logo" src="${pageContext.request.contextPath}/images/logo.png"/>
    <label class="logo-title">客户关系管理系统</label>
    <ul class="inline">
        <li>
            <img src="${pageContext.request.contextPath}/images/32/client.png"/>&nbsp;&nbsp;欢迎您,${user.nickname } <font
                color="red">${sessionScope.user.nickname}</font>
        </li>
        <li class="dropdown">
            <a class="dropdown-toggle mymsg" data-toggle="dropdown" href="#"><img
                    src="${pageContext.request.contextPath}/images/32/166.png"/>&nbsp;&nbsp;修改个人信息<b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="#">修改密码</a></li>
            </ul>

        </li>
        <li>
            <img src="${pageContext.request.contextPath}/images/32/200.png"/>&nbsp;&nbsp;<a class="loginout"
                                                                                            href="${pageContext.request.contextPath}/logout.jsp">退出</a>
        </li>

    </ul>


</div>


<div class="nav">

    <ul class="breadcrumb">
        <li>
            <img src="${pageContext.request.contextPath}/images/32/5025_networking.png"/>
        </li>
        <li><a href="#">首页</a> <span class="divider">>></span></li>
        <li class="active"></li>
    </ul>
</div>


<div class="container-fluid content">
    <div class="row-fluid">
        <div class="span2 content-left">
            <div class="accordion">
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2"
                           href="#collapseOne">
                            <img class="left-icon"
                                 src="${pageContext.request.contextPath}/images/32/5026_settings.png"/><span
                                class="left-title">系统设置</span>
                        </a>
                    </div>
                    <%-- <div id="collapseOne" class="accordion-body collapse in">
                        <div class="accordion-inner">
                            <img class="left-icon-child" src="${pageContext.request.contextPath}/images/32/4992_user.png" /><span class="left-body"> 用户管理</span>
                        </div>
                    </div> --%>
                    <div id="collapseOne" class="accordion-body collapse in">
                        <div class="accordion-inner">
                            <a href="#">
                                <img class="left-icon-child"
                                     src="${pageContext.request.contextPath}/images/32/4957_customers.png"/><span
                                    class="left-body">客户管理</span></a>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div class="span10 content-right">
            <%--<iframe src="${pageContext.request.contextPath}/center.jsp" class="iframe"></iframe>--%>
            <iframe src="${pageContext.request.contextPath}/customerAction_list" class="iframe" name="iframe"></iframe>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<div class="foot"></div>
<script src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap2.3.2/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/scripts/Index.js"></script>
<div style="text-align:center;">
</div>

</body>
</html>