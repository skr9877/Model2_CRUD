<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>삭제 완료</title>
</head>
<body>
	<h3>${id} 님  회원정보 변경이 완료 되었습니다!</h3>
	변경된 비밀번호 : ${password} <br/>
	변경된 이메일 : ${email} <br/>
	<%@ include file="/result/home.jsp" %>
</body>
</html>