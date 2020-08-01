<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>멤버 검색</title>
</head>
<body>
<form action="memberSearch.do" method="GET">
	ID : <input type = "text" name ="id"/> <br/>
		 <input type = "hidden" name = "job" value = "search"/>
	<input type = "submit" value ="검색">
</form>
</body>
</html>