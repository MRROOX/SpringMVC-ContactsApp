<%-- 
    Document   : test
    Created on : 17-01-2018, 17:05:18
    Author     : unknown
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:url var="url_jqlib" value="/static/js/jquery-3.2.1.min.js"/>
        <script src="${url_jqlib}" ></script>
        <script>
            $(document).ready(function(){
                //alert('JQuery is ready and integrated');
                $("#id_get_time").click(function(){
                   // alert('Button clicked...');
                   $.ajax({
                       url : 'get_time',
                       success : function(data){
                           $("#id_time").html(data);
                       }
                   });
                });
            });
        </script>
    </head>
    <body>
        <h1>Ajax Test Page</h1>
        <button id="id_get_time">Get Server Time</button> <br/>
        <p id="id_time"></p>
        
    </body>
</html>
