package com.team3.pms.Service.MyPage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.pms.Dao.MyPage.MyCalendarDao;
import com.team3.pms.VO.MyPage.Calendar;

@Service
public class MyCalendarService {
	
		@Autowired
		private MyCalendarDao dao;
		
		public List<Calendar> calList(String emp_cd_pk){
			return dao.calList(emp_cd_pk);
		}
		public void insertCalendar(Map<String, Object> ins) {
			dao.insertCalendar(ins);
		}
		public void uptCalendar(Calendar upt) {
			dao.uptCalendar(upt);
		}
		public void delCalendar(int id) {
			dao.delCalendar(id);
		}	

}
