package com.team3.pms.Dao.Member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.team3.pms.Controller.Member.form.MemberRegForm;
import com.team3.pms.VO.Member.CustomUser;
import com.team3.pms.VO.Member.MemberDto;
import com.team3.pms.VO.Member.ProjectListDto;
import com.team3.pms.VO.Member.RegSelectDto;
import com.team3.pms.VO.Member.RegTokenDto;

@Mapper
public interface MemberDao {
	
	public MemberDto getMemberByID(String id);

	public List<RegSelectDto> getDeptList();
	public List<RegSelectDto> getAuthList();
	public List<RegSelectDto> getPosList();
	
	//토큰 만들기
	public void insertRegToken(MemberRegForm regForm);
	public String getRegTokenID();
	public void updateRegTokenSha(@Param("sha")String sha, @Param("id")String id);
	
	//토큰 조회, 회원가입
	public RegTokenDto getRegTokenByID(String id);
	public void insertMember(MemberRegForm regForm);
	public String getEmpPK();
	public String getRegTokenID_bySha(String sha);
	
	//토큰 업데이트, ID 중복검사
	public void updateRegToken_expired(String id);
	public int checkID(String id); 
	
	//멤버 리스트 조회
	public List<MemberDto> getMemberList();
	public MemberDto getMemberByPK_Detailed(String pk);
	public List<ProjectListDto> getPersonalProjectListByPK(String pk);
}

