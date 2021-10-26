package com.team3.pms.Controller.community;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team3.pms.Service.community.ChatService;
import com.team3.pms.VO.Member.CustomUser;
import com.team3.pms.VO.community.Chat;
import com.team3.pms.VO.community.ChatList;

@Controller
public class ChatCtrl {
	@Autowired
	private ChatService service;

	// 사용자 리스트
	// http://localhost:3333/community/empList
	/*
	 * @RequestMapping("/community/empList") public String userListAjax(EmpSch sch,
	 * Model d) { d.addAttribute("empList", service.empList(sch)); return
	 * "community/chat2"; }
	 */

	public String loginSuccess(Authentication auth) {
		CustomUser member = (CustomUser) auth.getPrincipal();
		String emp_cd_pk = member.getEmp_cd_pk();
		return emp_cd_pk;
	}

	// 채팅메인
	// http://localhost:3333/community/chat
	@RequestMapping("/community/chat")
	public String chatDefault(Authentication auth, Model d) {
		String loginUser = loginSuccess(auth);
		d.addAttribute("roomList", service.chatList(loginUser));
		return "community/chat2";
	}

	// 채팅방 추가 @RequestParam(value = "emp_cd_pk") 
	@RequestMapping("/community/new")
	public String newGroup(@RequestParam("tmpList") ArrayList<String> empList, Authentication auth) {
		String loginUser = loginSuccess(auth);
		empList.add(loginUser);
		if (empList.size() == 2) {
			service.insertChatRoom("D", empList);
		} else {
			service.insertChatRoom("G", empList);
		}
		return "redirect:/community/chat";
	}

	// 채팅방 나가기
	@RequestMapping("/community/exitChat")
	public String exitChat(Authentication auth, String chtr_cd_pk) {
		String emp_cd_pk = loginSuccess(auth);
		service.exitChat(new ChatList(chtr_cd_pk, emp_cd_pk));
		return "redirect:/community/chat";
	}

	// 채팅방 사용자 추가
	@RequestMapping("/community/addUser")
	public String addUser(@RequestParam("tmpList") ArrayList<String> empList,
			@RequestParam("roomNum") String chtr_cd_pk) {
		service.addUser(chtr_cd_pk, empList);
		return "redirect:/community/chat";
	}

}
