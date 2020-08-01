package com.Model2Pjt.service;

import com.Model2Pjt.dao.MemberDAO;
import com.Model2Pjt.vo.MemberVo;

public class MemberService {
	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getInstance();
	
	private void MemberService() { }
	
	public static MemberService getInstance() {
		return service;
	}
	
	public void memberInsert(MemberVo member) {
		// Dao 클라스 생성
		dao.memberInsert(member);
	}
	
	public void memberDelete(MemberVo member) {
		dao.memberDelete(member);
	}
	
	public MemberVo memberSearch(String id) {
		MemberVo member = dao.memberSearch(id);
		return member;
	}
}
