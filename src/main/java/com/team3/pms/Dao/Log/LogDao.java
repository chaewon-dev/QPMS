package com.team3.pms.Dao.Log;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.VO.Log.LogDto;

@Mapper
public interface LogDao {
	
	public List<LogDto> getINFOcom();
	public List<LogDto> getERROR();
	public int getINFOcomTotal();
	public int getERRORTotal();
	
}
