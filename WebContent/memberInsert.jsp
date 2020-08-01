<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	${error}

	<form action="memberInsert.do" method="POST">
		ID : <input type="text" name="id" /><br /> 
		비밀번호 : <input type="password" name="pw" /><br /> 
		이름 : <input type="text" name="name" /><br /> 
		E-Mail : <input type="text" name="email" /><br />
		<div>
			성 별 : 남<input type="radio" value="male" name="gender" checked="checked" /> 
			             여<input type="radio" value="female" name="gender" />
		</div>
		<br />
		<br /> <input type="submit" value="가입" /><br /> <input type="reset" value="초기화" />
	</form>

</body>
</html>