<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>メインページ</h2>
<form action="Certification" method="POST">
  <div class="form-group">
ユーザーID：
<input type="text" name="id"><br/>

</div>

  <div class="form-group">
パスワード：
<input type="password" name="pw">

</div>

<input type="submit" value="送信" class="btn btn-primary"/>
<input type="reset" value="リセット" class="btn btn-primary" />

</form>

</body>
</html>