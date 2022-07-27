<%--◆ログイン結果画面を出力するビュー◆ --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--User情報を取得するためにmodelパッケージのUserクラスをインポート --%>
<%@ page import="model.User"%>

<%
//LoginサーブレットクラスのdoPostメソッドで保存したセッションスコープを取得
User loginUser = (User) session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>

<body>
<h1>どこつぶログイン</h1>
<!-- if文でログイン -->
<%if(loginUser != null) {%>
	<p>ログインに成功しました</p>
	<!-- セッションスコープ（User.java）から情報を取得しているのでgetter利用可能 -->
	<p>ようこそ<%=loginUser.getName() %>さん</p>
	<!--リンクをクリックしたらmain.jspへ  -->
	<a href="/dokoTsubuMysql/Main">つぶやき投稿・閲覧へ</a>
<%}else{ %>
	<p>ログインに失敗しました</p>
	<!--リンクをクリックしたらindex.jspへ-->
	<a href="/dokoTsubuMysql/">TOPへ</a>
<%} %>
</body>

</html>