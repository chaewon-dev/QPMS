package com.team3.pms.Dao.MyPage;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.VO.MyPage.Calendar;

@Mapper
public interface MyCalendarDao {
	public ArrayList<Calendar> calList(String emp_cd_pk);
	public void insertCalendar(Map<String, Object> ins);
	public void uptCalendar(Calendar upt);
	public void delCalendar(int id);	
}
