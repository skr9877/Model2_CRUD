package com.Model2Pjt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model2Pjt.service.MemberService;
import com.Model2Pjt.vo.MemberVo;

public class MemberSearchController implements Controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		String path = null;
		
		if(job.equals("search")) {
			path = "/memberSearch.jsp";
		}
		
		if(id.isEmpty()) {
			req.setAttribute("error", "ID�� �Է����ֽñ� �ٶ��ϴ�!");
			HttpUtil.forward(req, resp, path);
			return;
		}
		
		MemberService service = MemberService.getInstance();
		MemberVo member = service.memberSearch(id);
		
		// Output
		if(member == null) req.setAttribute("result", "�˻��� ������ �����ϴ�!");
		req.setAttribute("member", member);
		if(job.equals("search")) path = "/result/memberSearchOutput.jsp";
		HttpUtil.forward(req, resp, path);
	}
}
