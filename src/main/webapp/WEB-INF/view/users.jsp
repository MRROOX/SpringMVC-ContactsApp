<%-- 
    Document   : users
    Created on : 17-01-2018, 15:34:26
    Author     : unknown
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List- Contact Application </title>
        <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css" />
        <s:url var="url_jqlib" value="/static/js/jquery-3.2.1.min.js"/>
        <s:url var="url_servicesv1" value="/static/js/servicesv1.js"/>

        <script src="${url_jqlib}" ></script>
        <script src="${url_servicesv1}"></script>

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
                <td height="350px" valign="top">
                    <!--Page Content Area-->
                    <h3>User List</h3>
                    <table border="1">
                        <tr>
                            <td>SR</td>
                            <td>USER ID</td>
                            <td>NAME</td>
                            <td>PHONE</td>
                            <td>EMAIL</td>
                            <td>ADDRESS</td>
                            <td>USERNAME</td>
                            <td>STATUS</td>
                        </tr>
                        <c:forEach var="u" items="${usersList}" varStatus="st">
                            <tr>
                                <td>${st.count}</td>
                                <td>${u.userId}</td>
                                <td>${u.name}</td>
                                <td>${u.phone}</td>
                                <td>${u.email}</td>
                                <td>${u.address}</td>
                                <td>${u.loginName}</td>
                                <td>
                                    <select id="id_${u.userId}" onchange="changeStatus(${u.userId}, $(this).val())">
                                        <option value="1">Active</option>
                                        <option value="2">Block</option>
                                    </select>
                                    <script>
                                        $('#id_${u.userId}').val(${u.loginStatus});
                                    </script>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                </td>
            </tr>
            <tr>
                <td height="350px">
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</html>
