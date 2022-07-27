<%--◆メイン画面を出力するビュー◆--%>

<%--pageディレクティブ：JSPファイルにおける様々な設定--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--ユーザー情報を取得（model.User）・つぶやきの取得（model.Mutter）--%>
<%@ page import="model.User"%>
<%@ page import="model.Mutter"%>

<%--投稿されたつぶやき一覧を取得するためListインタフェースをimport--%>
<%@ page import="java.util.List"%>

<%--スクリプトレット：JSPファイルにJavaコードを埋め込む --%>
<%
//サーブレットクラスLoginでセッションスコープに保存したユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");

//アプリケーションスコープに保存されたユーザー情報を取得
List<Mutter> mutterList = (List<Mutter>) request.getAttribute("mutterList");

//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p><%=loginUser.getName() %>さん、ログイン中</p>

<a href="/dokoTsubuMysql/Logout">ログアウト</a>
<p><a href="/dokoTsubuMysql/Main">更新</a></p>

<form action="/dokoTsubuMysql/Search" method="get">
<input type="text" name="keyword">
<input type="submit" value="検索"><br>
</form>

<form action="/dokoTsubuMysql/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>

<%if(errorMsg !=null) {%>
<p><%=errorMsg %></p>
<%} %>

<% for(Mutter mutter : mutterList){ %>
	<p><%=mutter.getUserName() %>:<%=mutter.getText() %></p>
	<a href="/dokoTsubuMysql/UpdateMutter?id=<%=mutter.getId()%>">編集</a>
	<a href="/dokoTsubuMysql/DeleteMutter?id=<%=mutter.getId()%>">削除</a>
<%} %>
</body>
</html>