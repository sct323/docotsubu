<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ新規登録</title>
</head>
<body>
<h1>どこつぶ新規登録</h1>
<form action="/dokoTsubuMysql/UserRegister" method="post">
ユーザー名：<input type="text" name="name"><br>
パスワード名：<input type="password" name="pass"><br>
<input type="submit" value="登録"><br>

</form>

</body>
</html>