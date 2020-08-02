<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "com.Model2Pjt.vo.MemberVo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 정보 변경</title>
</head>
<body>
	${error}
	<form action="memberSearch.do" method="POST">
		# 찾을 ID<br/>
		ID : <input type="text" name="id" /><br />
			 <input type="hidden" name = "job" value = "update"/>
		PASSWORD : <input type="password" name = "pw"/><br/>
		<input type = "submit" value ="검색">
	</form>
	
 	<% MemberVo member = (MemberVo) request.getAttribute("member");
 	   if(member != null){ %>
 		   <h3>회원 정보 수정</h3>
 		   <form action="memberUpdate.do" method="POST">
			    ID : <input readonly type="text" name="id" value="${member.id}"/><br/>
				비밀번호 : <input type="password" name="pw" value = "${member.password}" /><br /> 
				이름 : <input type="text" name="name" value = "${member.name}"/><br /> 
				E-Mail : <input type="text" name="email" value = "${member.email}"/><br />
				성별 : <input readonly type="text" name="gender" value = "${member.gender}"/><br />
				<input type = "submit" value ="수정">
 		   </form>
 	<% }else{ %>
		${result}
	<% } %>
	
</body>
</html>