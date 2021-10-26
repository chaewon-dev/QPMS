package com.team3.pms.Dao.community;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.VO.community.Chat;
import com.team3.pms.VO.community.ChatList;
import com.team3.pms.VO.community.ChatLog;
import com.team3.pms.VO.community.ChatTitle;
import com.team3.pms.VO.community.EmpSch;

@Mapper
public interface ChatDao {
	// 사용자 정보
	EmpSch getEmp(String emp_cd_pk);
	// 채팅방 조회
	ArrayList<Chat> chatList(String loginUser);
	// 채팅방 제목
	String getTitle(Chat chat);
	// 사용자 검색
	ArrayList<EmpSch> empListByName(EmpSch sch);
	ArrayList<EmpSch> empListByDept(EmpSch sch);
	// 채팅 추가
	Chat checkDupl(String emp_cd_pk); // 개인 채팅 중복 확인
	void insertChatRoom(Chat chatRoom);
	void insertChatList(String emp_cd_pk);
	void insertTitle(ChatTitle title);
	// 최근 채팅방번호
	String recentChtr();
	// 채팅방 선택
	Chat enterChat(String chtr_cd_pk);
	// 채팅방 사용자 조회
	ArrayList<ChatList> chatUserList(String chtr_cd_pk);
	// 채팅방 사용자 수 확인
	int userCount(String chtr_cd_pk);
	// 채팅방 사용자 추가
	void addUser(Chat chat);
	// 채팅방 이름, 종류 변경
	void changeRoomKind(Chat chagedChat);
	// 채팅방 이름 변경(삭제)
	void updateRoomName(Chat update);
	void updateTitle(Chat update);
	// 채팅방 나가기
	void exitChat(ChatList chatListInfo);
	int chatListCount(String chtr_cd_pk);
	void deleteChat(String chtr_cd_pk);
	// 채팅 기록 불러오기
	ArrayList<ChatLog> readHistory(Chat chat);
	// 채팅 내역 저장
	void insertChatLog(ChatLog chatLog);
}
