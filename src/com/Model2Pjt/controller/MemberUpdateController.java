package com.Model2Pjt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model2Pjt.service.MemberService;
import com.Model2Pjt.vo.MemberVo;

public class MemberUpdateController implements Controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		
		if(password.isEmpty() || name.isEmpty() || email.isEmpty()) {
			req.setAttribute("error", "값을 전부 채워주세요");
			HttpUtil.forward(req, resp, "/memberUpdate.jsp");
			return;
		}
		
		MemberVo member = new MemberVo();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setEmail(email);
		member.setGender(gender);
		
		MemberService service = MemberService.getInstance();
		
		service.memberUpdate(member);
		
		req.setAttribute("id", id);
		
		HttpUtil.forward(req, resp, "/result/memberUpdateOutput.jsp");
	}
}
