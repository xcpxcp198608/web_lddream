<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>EDIT</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <!--
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <script type="application/javascript" language="JavaScript" src="js/base.js"/>
    <link rel="shortcut icon" href="img/xxx.ico">
    -->

</head>

<body style="margin: 0px; padding: 0px">
    <div id="header" style="background-color: black; width: 100%; height: 60px" >
                <span style="width: 100%; font-size: 25px; font-family: Arial;
                text-align: center; line-height: 60px; color: lightyellow; display: block">LDDream</span>
    </div><br/><br/>
    <div style="width: 90%; margin: auto" align="center">
        <s:form action="/lddream/image/update" method="post" enctype="multipart/form-data">
            <input type="file" name="file">
            <input type="hidden" name="id" value="${imageInfo.id}">
            <input type="submit">
        </s:form>
    </div>
    <div style="width: 90%; margin: auto" align="center">
        <img src="${imageInfo.url}" alt="img" style="align-self: center; width: 600px">
    </div>
</body>
</html>
