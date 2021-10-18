
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>saludo</title>
    </head>
    <body>
        <h1>Hola ${usuarioBean.nombre} </h1>
        
        <h3> El usuario ${requestScope.existe} </h3>
    </body>
</html>
