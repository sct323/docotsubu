<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String) request.getAttribute("id");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>つぶやきの編集</h1>
<form action="/dokoTsubuMysql/UpdateMutter" method=post>
<input type="hidden" name= "id" value=<%=id%>>
<input type="text" name="text">
<input type="submit" value="編集"><br>
</form>
</body>
</html>