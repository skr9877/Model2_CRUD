<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 정보 변경</title>
</head>
<body>
<form action="memberUpdate.do" method="GET">
	# 변경할 ID<br/>
	ID : <input type="text" name="id" /><br /> <br/>
	
	# 변경할 정보<br/>
	비밀번호 : <input type="password" name="pw" /><br /> 
	E-Mail : <input type="text" name="email" /><br />
	<input type = "submit" value ="변경">
</form>
</body>
</html>