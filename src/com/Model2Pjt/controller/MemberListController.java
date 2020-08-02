package com.Model2Pjt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model2Pjt.service.MemberService;
import com.Model2Pjt.vo.MemberVo;

public class MemberListController implements Controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
		ArrayList<MemberVo> list = service.memberList();
		
		req.setAttribute("list", list);
		HttpUtil.forward(req, resp, "/result/memberListOutput.jsp");
	}
}
