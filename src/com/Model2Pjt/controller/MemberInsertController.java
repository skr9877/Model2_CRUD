package com.Model2Pjt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model2Pjt.service.MemberService;
import com.Model2Pjt.vo.MemberVo;

public class MemberInsertController implements Controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 추출
		String id = req.getParameter("id");
		String password = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		
		// 유효성 체크
		if(id.isEmpty() || password.isEmpty() || name.isEmpty() || email.isEmpty() || gender.isEmpty()) {
			req.setAttribute("error", "항목을 전부 채워주세요");
			HttpUtil.forward(req, resp, "/memberInsert.jsp");	
			return;
		}
		
		// Vo에 데이터 바인딩
		MemberVo member = new MemberVo();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setEmail(email);
		member.setGender(gender);
		
		//Service 함수 호출
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		//Output View 페이지로 이동
		req.setAttribute("id", id);
		HttpUtil.forward(req, resp, "/result/memberInsertOutput.jsp");
	}
}
