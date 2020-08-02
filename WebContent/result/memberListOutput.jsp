<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Model2Pjt.vo.MemberVo" %>

<!DOCTYPE html>
<html>
<head>
<title>회원 목록 보기</title>
</head>
<body>
	<% ArrayList<MemberVo> list = (ArrayList<MemberVo>)request.getAttribute("list");
		
	   if(!list.isEmpty()){ %>
	   	  
			<table border = "1">	
			<tr><th>ID</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>성별</th></tr>
			
			<% for(MemberVo member : list){ %>
			     <tr>
			     	 <td><%= member.getId() %></td>
			         <td><%= member.getPassword() %></td>
			         <td><%= member.getName() %></td>
			         <td><%= member.getEmail() %></td>
			         <td><%= member.getGender() %></td>
			    </tr>
			<% } %>
			
			</table>
	   <% }else{ 
	    	out.print("<h3> 등록된 회원 정보가 없습니다!</h3>");
	      }
	   %>
		
		
	<%@ include file="/result/home.jsp" %>
</body>
</html>