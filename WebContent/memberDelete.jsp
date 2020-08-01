<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>멤버 삭제</title>
</head>
<body>
	${error}

	<form action="memberDelete.do" method="POST">
		ID : <input type = "text" name ="id"/> 
	<input type = "submit" value ="삭제">
</form>
</body>
</html>