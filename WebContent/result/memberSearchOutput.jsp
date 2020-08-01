<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 조회</title>
</head>
<body>
	<%
		String req = (String)request.getAttribute("result");
	
		if(req != null){
			out.print(req + "<p>");
		}
		else{
	%>
			<h3>
				ID : ${member.id} <br/>
				비밀번호 : ${member.password} <br/>
				이름 : ${member.name} <br/>
				이메일 : ${member.email} <br/>
				성별 : ${member.gender} <br/>
			</h3>
	<% } %>
	<br/>
	<%@ include file="/result/home.jsp" %>
</body>
</html>