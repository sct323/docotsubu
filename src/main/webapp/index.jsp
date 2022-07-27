<%--◆トップ画面を出力するビュー◆--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>

<body>
<h1>どこつぶへようこそ</h1>
<h2>ログイン</h2>


<%--ログインを押すと、LoginサーブレットクラスのdoPostメソッドに処理が移る --%>>
<form action="/dokoTsubuMysql/Login" method="post">
ユーザー名：<input type="text" name="name"><br>
パスワード名：<input type="password" name="pass"><br>
<input type="submit" value="ログイン"><br>
</form>


<%--新規登録リンクを押すと、UserRegisterサーブレットクラスのdoPostメソッドに処理が移る --%>
<h2>新規登録</h2>
<a href="/dokoTsubuMysql/UserRegister">新規登録はこちら</a>
</body>
</html>