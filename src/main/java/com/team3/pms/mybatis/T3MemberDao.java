package com.team3.pms.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface T3MemberDao {
	List<T3MemberDTO> list();

}
