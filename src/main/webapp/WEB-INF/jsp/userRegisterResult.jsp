<%--◆ログイン結果画面を出力するビュー◆ --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--modelパッケージのUserクラスをインポート --%>
<%@ page import="model.User"%>
<%
//セッションスコープからの情報を取得＝User.javaから情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶ新規作成</h1>
<%if(loginUser != null) {%>
	<p>新規登録に成功しました</p>
	<!-- セッションスコープ（User.java）から情報を取得しているのでgetter利用可能 -->
	<p>ようこそ<%=loginUser.getName() %>さん</p>
	<!--リンクをクリックしたらmain.jspへ  -->
	<a href="/dokoTsubuMysql/Main">つぶやき投稿・閲覧へ</a>
<%}else{ %>
	<p>ログインに失敗しました</p>
	<p>下記のリンクから再登録をお願いします</p>
	<!--リンクをクリックしたらindex.jspへ-->
	<a href="/dokoTsubuMysql/UserRegister">新規登録画面へ</a>
<%} %>
</body>
</html>