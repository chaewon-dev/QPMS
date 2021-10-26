package com.team3.pms.Controller.community;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.pms.Service.ResourcePage.ResourceService;
import com.team3.pms.Service.community.BbsService;
import com.team3.pms.Service.community.ChatService;
import com.team3.pms.VO.Member.CustomUser;
import com.team3.pms.VO.community.Chat;
import com.team3.pms.VO.community.ChatList;
import com.team3.pms.VO.community.ChatLog;
import com.team3.pms.VO.community.ChatTitle;
import com.team3.pms.VO.community.EmpSch;
import com.team3.pms.VO.resource.RscStateForm;

@RestController
public class RestCtrl {
	@Autowired
	private ChatService cservice;
	@Autowired
	private BbsService bservice;
	@Autowired
	private ResourceService rservice;
	@Autowired
	private SimpMessagingTemplate simpMessage;

	/* ------채팅------- */
	// broker
	@MessageMapping("/broadcast")
	public void send(Chat message) {
		String chtr_cd_pk = message.getChtr_cd_pk();
		String url = "/sub/chat/room/" + chtr_cd_pk;
		simpMessage.convertAndSend(url, message);
	}

	// 로그인 사용자 확인
	public String loginSuccess(Authentication auth) {
		CustomUser member = (CustomUser) auth.getPrincipal();
		String emp_cd_pk = member.getEmp_cd_pk();
		return emp_cd_pk;
	}

	// 채팅 사용자 리스트
	// http://localhost:3333/community/empList
	@RequestMapping("/community/empList")
	public ArrayList<EmpSch> empList(String filter, EmpSch sch) {
		return cservice.empList(filter, sch);
	}

	// 채팅방 선택
	// http://localhost:3333/community/chatRoom
	@RequestMapping("/community/chatRoom")
	public Chat enterChat(Authentication auth, String chtr_cd_pk) {
		String loginUser = loginSuccess(auth);
		return cservice.enterChat(loginUser, chtr_cd_pk);
	}

	// 채팅방 사용자 조회
	// http://localhost:3333/community/chatRoom
	@RequestMapping("/community/chatUserList")
	public ArrayList<ChatList> chatUserList(String chtr_cd_pk) {
		return cservice.chatUserList(chtr_cd_pk);
	}

	// 채팅방 이름 변경
	@RequestMapping("/community/updateTitle")
	public Chat updateTitle(Authentication auth, Chat title) {
		String loginUser = loginSuccess(auth);
		return cservice.updateTitle(loginUser, title);
	}

	// 채팅방 나간 사용자 메시지 전송
	@RequestMapping("/community/noticeExitChat")
	public void noticeExitChat(String chtr_cd_pk) {
		//나간 후 chatlist에 사용자 남아있는 경우에 메시지 전송(ㅇㅇㅇ님이 나갔습니다.)
	}
	
	// http://localhost:3333/community/readHistory
	// 채팅 내역 불러오기
	@RequestMapping("/community/readHistory")
	public ArrayList<ChatLog> readHistory(Chat chat){
		return cservice.readHistory(chat);
	}
	
	// 채팅 내역 저장
	@RequestMapping("/community/insertChatLog")
	public void insertChagLog(ChatLog chatLog) {
		cservice.insertChagLog(chatLog);
	}
	
	/* ------ 공지사항, 자료실 ------- */
	// 파일삭제
	@RequestMapping("/fileDelete")
	public void fileDelete(String bfile_cd_pk) {
		bservice.fileDelete(bfile_cd_pk);
	}

	/* ------ 리소스 배정현황 ------- */
	// 배정현황
	// http://localhost:3333/rscStateList
	@RequestMapping("/rscStateList")
	public ArrayList<RscStateForm> resourceStateList() {
		return rservice.resourceStateList();
	}

	// 배정현황 필터
	// http://localhost:3333/filteredList
	@RequestMapping("/filteredList")
	public ArrayList<RscStateForm> filteredList(String project_pk) {
		return rservice.filteredList(project_pk);
	}
}
