<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��� ����</title>
</head>
<body>
	${error}

	<form action="memberDelete.do" method="POST">
		ID : <input type = "text" name ="id"/> 
	<input type = "submit" value ="����">
</form>
</body>
</html>