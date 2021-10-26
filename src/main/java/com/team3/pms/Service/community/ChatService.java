package com.team3.pms.Service.community;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.pms.Dao.community.ChatDao;
import com.team3.pms.VO.community.Chat;
import com.team3.pms.VO.community.ChatList;
import com.team3.pms.VO.community.ChatLog;
import com.team3.pms.VO.community.ChatTitle;
import com.team3.pms.VO.community.EmpSch;

@Service
public class ChatService {
	@Autowired
	private ChatDao dao;
	
	// 채팅방 조회
	public ArrayList<Chat> chatList(String loginUser){
		ArrayList<Chat> list = dao.chatList(loginUser);
		// 개인 설정 제목으로 set하여 return
		for(Chat chat : list) {
			String chtr_cd_pk = chat.getChtr_cd_pk();
			String savedTitle = dao.getTitle(new Chat(chtr_cd_pk, loginUser));
			chat.setChtr_nm(savedTitle);
		}
		return list;
	}
	
	// 사용자 조회(이름, 부서 필터)
	public ArrayList<EmpSch> empList(String filter, EmpSch sch) {
		if(filter.equals("emp_name")) {
			if(sch.getEmp_name()==null) {
				sch.setEmp_name("");
			}
			return dao.empListByName(sch);
		} else {
			if(sch.getDept_name()==null) {
				sch.setDept_name("");
			}
			return dao.empListByDept(sch);
		}
	}
	
	// 채팅방(대화) 추가
	public void insertChatRoom(String kind, ArrayList<String> empList) {
		Chat chatRoom = new Chat();
		EmpSch emp = dao.getEmp(empList.get(0));
		chatRoom.setChtr_kind(kind);
		if(kind.equals("G")) { //그룹채팅
			String title = emp.getEmp_name()+"("+emp.getDept_name()+")외 다수";
			chatRoom.setChtr_nm(title);
			dao.insertChatRoom(chatRoom);
			//채팅방 기본 정보 입력 후 사용자 정보 저장, 채팅방이름 디폴트 설정
			String chtr_cd_pk = dao.recentChtr();
			for(String emp_cd_pk : empList) {
				dao.insertChatList(emp_cd_pk);
				dao.insertTitle(new ChatTitle(chtr_cd_pk,title, emp_cd_pk));
			}
		} else { //개인 채팅
			Chat dupl = dao.checkDupl(emp.getEmp_cd_pk());
			// 중복아닌 경우에만 추가
			if(dupl==null) {
				EmpSch emp2 = dao.getEmp(empList.get(1));
				String title = emp.getEmp_name()+"("+emp.getDept_name()+"), "
				+emp2.getEmp_name()+"("+emp2.getDept_name()+")";
				chatRoom.setChtr_nm(title);
				dao.insertChatRoom(chatRoom);
				//채팅방 기본 정보 입력 후 사용자 정보 저장, 채팅방이름 디폴트 설정
				String chtr_cd_pk = dao.recentChtr();
				for(String emp_cd_pk : empList) {
					dao.insertChatList(emp_cd_pk);
					dao.insertTitle(new ChatTitle(chtr_cd_pk,title, emp_cd_pk));
				}
			} else {
				System.out.println("중복!!");
			}
		}
	}
	// 그룹 참여자 추가
	public void insertChatList(ArrayList<String> empList) {
		for(String emp_cd_pk : empList) {
			dao.insertChatList(emp_cd_pk);
		}
	}
	
	// 채팅방 선택
	public Chat enterChat(String loginUser, String chtr_cd_pk) {
		Chat chat = dao.enterChat(chtr_cd_pk);
		chat.setChtr_nm(dao.getTitle(new Chat(chtr_cd_pk, loginUser)));
		return chat;
	}
	// 채팅방 사용자 조회
	public ArrayList<ChatList> chatUserList(String chtr_cd_pk){
		return dao.chatUserList(chtr_cd_pk);
	}
	// 채팅방 사용자 추가
	public void addUser(String chtr_cd_pk, ArrayList<String> userList) {
		int userCount = dao.userCount(chtr_cd_pk); //기존 채팅방 인원
		Chat orgChat = dao.enterChat(chtr_cd_pk); //기존 채팅방 정보
		//orgChat.setChtr_cd_pk(chtr_cd_pk);
		if(userCount<=2) {
			for(String user : userList) {
				orgChat.setEmp_cd_pk(user);
				dao.addUser(orgChat);
				dao.insertTitle(new ChatTitle(chtr_cd_pk, orgChat.getChtr_nm(),user));
			}
			//orgChat.setChtr_nm(userList.get(0).getEmp_name()+" 외 다수");
			orgChat.setChtr_kind("G");
			System.out.println("이름:"+orgChat.getChtr_nm()+", 번호:"+orgChat.getChtr_cd_pk()+",종류:"+orgChat.getChtr_kind());
			dao.changeRoomKind(orgChat);
		}else {
			for(String user : userList) {
				orgChat.setEmp_cd_pk(user);
				dao.addUser(orgChat);
				dao.insertTitle(new ChatTitle(chtr_cd_pk, orgChat.getChtr_nm(),user));
			}
			//orgChat.setChtr_nm(userList.get(0).getEmp_name()+" 외 "+(userCount+userList.size()-1)+"명");
		}
		//return orgChat;
	}
	
	// 채팅방 이름 변경
	public Chat updateTitle(String loginUser, Chat update) {
		update.setEmp_cd_pk(loginUser);
		dao.updateTitle(update);
		// 개인 설정 제목으로 조회
		String roomNum = update.getChtr_cd_pk();
		Chat chat = dao.enterChat(roomNum);
		String title = dao.getTitle(new Chat(roomNum, loginUser));
		chat.setChtr_nm(title);
		return chat;
	}
	
	// 대화 나가기
	public void exitChat(ChatList exit) {
		dao.exitChat(exit);
		String chtr_cd_pk = exit.getChtr_cd_pk();
		int rest = dao.chatListCount(chtr_cd_pk);
		if(rest==0) {
			dao.deleteChat(chtr_cd_pk);
		}
	}
	
	// 대화 기록 불러오기
	public ArrayList<ChatLog> readHistory(Chat chat){
		ArrayList<ChatLog> log = dao.readHistory(chat);
		for(ChatLog cl : log) {
			String emp_cd_pk = cl.getClog_sender();
			if(emp_cd_pk.equals("absent")) {
				continue;
			} else {
				EmpSch emp = dao.getEmp(emp_cd_pk);
				if(emp!=null) {
					String emp_name = emp.getEmp_name();
					String dept_name = emp.getDept_name();
					cl.setEmp_name(emp_name);
					cl.setDept_name(dept_name);
				}
			}
		}
		return log;
	}
	// 대화 내역 저장
	public void insertChagLog(ChatLog chatLog) {
		dao.insertChatLog(chatLog);
	}

}
