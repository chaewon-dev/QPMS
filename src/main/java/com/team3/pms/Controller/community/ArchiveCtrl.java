package com.team3.pms.Controller.community;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ArchiveCtrl {
	@Autowired
	private BbsService service;

	public String loginSuccess(Authentication auth ){
        CustomUser member = (CustomUser) auth.getPrincipal();
        String emp_cd_pk = member.getEmp_cd_pk();
        return emp_cd_pk;
        
	}
	
	// 자료실 리스트
	@RequestMapping("/community/archive")
	public String archiveMain(Model d) {
		d.addAttribute("archiveList", service.archiveList());
		return "community/archive";
	}

	// 자료실 상세
	@RequestMapping("/community/archive/detail")
	public String archiveDetail(@RequestParam("bbs_cd_pk") String bbs_cd_pk, Model d) {
		d.addAttribute("archive", service.bbsDetail(bbs_cd_pk));
		return "community/archiveDetail";
	}

	// 등록창 이동
	@GetMapping("/community/archive/insert")
	public String regForm2() {
		return "community/archiveForm";
	}

	// 자료실 등록
	@PostMapping("/community/archive/insert")
	public String archiveInsert(Authentication auth, Bbs insert) {
		String writer = loginSuccess(auth);
		insert.setEmp_cd_pk(writer);
		service.archiveInsert(insert);
		return "redirect:/community/archive";
	}

	// 자료실 수정폼
	@RequestMapping("/community/archive/updateForm")
	public String archiveUpdateForm(String bbs_cd_pk, Model d) {
		d.addAttribute("archive", service.bbsDetail(bbs_cd_pk));
		return "community/archiveUpdateForm";
	}

	// 자료실 수정
	@RequestMapping("/community/archive/update")
	public String archiveUpdate(Bbs update) {
		service.archiveUpdate(update);
		return "redirect:/community/archive/detail?bbs_cd_pk=" + update.getBbs_cd_pk();
	}

	// 자료실 삭제
	@RequestMapping("/community/archive/delete")
	public String archiveDelete(@RequestParam("bbs_cd_pk") String bbs_cd_pk) {
		service.bbsDelete(bbs_cd_pk);
		return "redirect:/community/archive";
	}
}
