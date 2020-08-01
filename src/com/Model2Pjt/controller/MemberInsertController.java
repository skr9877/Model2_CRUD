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
		// �Ķ���� ����
		String id = req.getParameter("id");
		String password = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		
		// ��ȿ�� üũ
		if(id.isEmpty() || password.isEmpty() || name.isEmpty() || email.isEmpty() || gender.isEmpty()) {
			req.setAttribute("error", "�׸��� ���� ä���ּ���");
			HttpUtil.forward(req, resp, "/memberInsert.jsp");	
			return;
		}
		
		// Vo�� ������ ���ε�
		MemberVo member = new MemberVo();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setEmail(email);
		member.setGender(gender);
		
		//Service �Լ� ȣ��
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		//Output View �������� �̵�
		req.setAttribute("id", id);
		HttpUtil.forward(req, resp, "/result/memberInsertOutput.jsp");
	}
}
