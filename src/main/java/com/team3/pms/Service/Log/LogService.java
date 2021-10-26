package com.team3.pms.Service.Log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.pms.Dao.Log.LogDao;
import com.team3.pms.VO.Log.LogDto;

@Service
public class LogService {
	
	@Autowired
	private LogDao lDao;

	public List<LogDto> getINFOcom(){
		return lDao.getINFOcom();
	}
	public List<LogDto> getERROR(){
		return lDao.getERROR();
	}
	
	public int getINFOcomTotal() {
		return lDao.getINFOcomTotal();
	}
	public int getERRORTotal() {
		return lDao.getERRORTotal();
	}
}
