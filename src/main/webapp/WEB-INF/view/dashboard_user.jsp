<%-- 
    Document   : dashboard_user
    Created on : 14-01-2018, 10:19:01
    Author     : unknown
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Dashboard - Contact Application </title>
        <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css" />



    </head>
    <s:url var="url_bg" value="/static/images/bg.jpg"/>

    <body background="${url_bg}">
        <table border="1" width="80%" align="center">
            <tr>
                <td height="80px">

                    <jsp:include page="include/header.jsp" />
                </td>
            </tr>
            <tr>
                <td height="20px">
                    <!--                Menu-->
                    <jsp:include page="include/menu.jsp" />
                </td>
            </tr>
            <tr>
                <td height="350px">
                    <!--                Page Content Area-->
                    <h1>User Dashboard</h1>
                    TODO - User Option in this page
                </td>
            </tr>
            <tr>
                <td height="350px">
                    <!--                Footer-->
                    <jsp:include page="include/footer.jsp"/>
                    </td>
            </tr>
        </table>
    </body>
</html>
