package com.Model2Pjt.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	String charset = null;
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		charset = sc.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberList.do", new MemberListController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		String url = req.getRequestURI(); // 예상 값 : /Model2Pjt/*.jsp
		String contextPath = req.getContextPath(); // 예상 값 :  /Model2Pjt
		String path = url.substring(contextPath.length()); 
		
		Controller subController = list.get(path);
		subController.execute(req, resp);
	}
	
}
