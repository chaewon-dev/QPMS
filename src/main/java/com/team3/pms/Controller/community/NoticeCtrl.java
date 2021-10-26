package com.team3.pms.Controller.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team3.pms.Service.community.BbsService;
import com.team3.pms.VO.Member.CustomUser;
import com.team3.pms.VO.community.Bbs;

@Controller
public class NoticeCtrl {
	@Autowired
	private BbsService service;
	
	public String loginSuccess(Authentication auth ){
        CustomUser member = (CustomUser) auth.getPrincipal();
        String emp_cd_pk = member.getEmp_cd_pk();
        return emp_cd_pk;
        
	}
	

	// 공지사항 리스트
	@RequestMapping("/community/notice")
	public String noticeMain(Model d) {
		d.addAttribute("noticeList", service.noticeList());
		return "community/notice";
	}

	// 공지사항 상세
	@RequestMapping("/community/notice/detail")
	public String noticeDetail(@RequestParam("bbs_cd_pk") String bbs_cd_pk, Model d) {
		d.addAttribute("notice", service.bbsDetail(bbs_cd_pk));
		return "community/noticeDetail";
	}

	// 등록창 이동
	@GetMapping("/community/notice/insert")
	public String regForm() {
		return "community/noticeForm";
	}

	// 공지사항 등록
	@PostMapping("/community/notice/insert")
	public String noticeInsert(Authentication auth, Bbs insert) {
		String writer = loginSuccess(auth);
		insert.setEmp_cd_pk(writer);
		service.noticeInsert(insert);
		return "redirect:/community/notice";
	}

	// 공지사항 수정폼
	@RequestMapping("/community/notice/updateForm")
	public String noticeUpdateForm(String bbs_cd_pk, Model d) {
		d.addAttribute("notice", service.bbsDetail(bbs_cd_pk));
		return "community/noticeUpdateForm";
	}

	// 공지사항 수정
	@RequestMapping("/community/notice/update")
	public String noticeUpdate(Bbs update) {
		service.noticeUpdate(update);
		return "redirect:/community/notice/detail?bbs_cd_pk=" + update.getBbs_cd_pk();
	}

	// 공지사항 삭제
	@RequestMapping("/community/notice/delete")
	public String noticeDelete(@RequestParam("bbs_cd_pk") String bbs_cd_pk) {
		service.bbsDelete(bbs_cd_pk);
		return "redirect:/community/notice";
	}

	// 다운로드
	@RequestMapping("/download")
	public ResponseEntity<Resource> download(@RequestParam("bfile_cd_pk") String bfile_cd_pk) {
		String orgFileName = service.getFileDetail(bfile_cd_pk).getOrg_nm();
		String savedFileName = service.getFileDetail(bfile_cd_pk).getBfile_nm();
		Resource file = service.loadAsResource(savedFileName);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+orgFileName+"\"").body(file);
	}
}
