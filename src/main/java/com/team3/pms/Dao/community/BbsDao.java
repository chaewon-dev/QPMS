package com.team3.pms.Dao.community;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.VO.community.Bbs;
import com.team3.pms.VO.community.Bfile;

@Mapper
public interface BbsDao {
	//ArrayList<Bbs> noticeList(Bbs sch);
	// 공지사항 조회
	ArrayList<Bbs> noticeList();
	Bbs bbsDetail(String bbs_cd_pk);
	void hitUpdate(String bbs_cd_pk);
	// 공지사항 등록
	void noticeInsert(Bbs insert);
	// 공지사항 수정
	void noticeUpdate(Bbs update);
	// 공지사항 삭제
	void bbsDelete(String bbs_cd_pk);
	// 자료실 조회
	ArrayList<Bbs> archiveList();
	// 자료실 등록
	void archiveInsert(Bbs insert);
	// 자료실 수정
	void archiveUpdate(Bbs update);

	// 파일 조회
	String getFile(String bbs_cd_pk);
	// 파일 번호 조회
	String getFileNum(String bbs_cd_pk);
	// 파일 상세 조회
	Bfile getFileDetail(String bfile_cd_pk);
	// 파일 등록
	void fileInsert(Bfile insert);
	// 파일 삭제
	void fileDelete(String bfile_cd_pk);
	// 파일 수정
	void updateFile(Bfile update);

	
}
