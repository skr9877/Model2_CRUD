package com.Model2Pjt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model2Pjt.service.MemberService;
import com.Model2Pjt.vo.MemberVo;

public class MemberDeleteController implements Controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		if(id.isEmpty()) {
			req.setAttribute("error", "삭제할 ID를 입력해주세요");
			HttpUtil.forward(req, resp, "/memberDelete.jsp");	
			return;
		}
		
		MemberVo member = new MemberVo();
		member.setId(id);
		
		MemberService service = MemberService.getInstance();
		service.memberDelete(member);
		
		req.setAttribute("id", member.getId());
		HttpUtil.forward(req, resp, "/result/memberDeleteOutput.jsp");
	}
}
