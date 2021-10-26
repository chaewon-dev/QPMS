package com.team3.pms.Service.Member;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.pms.Controller.Member.form.MemberRegForm;
import com.team3.pms.Dao.Member.MemberDao;
import com.team3.pms.VO.Member.MemberDto;
import com.team3.pms.VO.Member.ProjectListDto;
import com.team3.pms.VO.Member.RegSelectDto;
import com.team3.pms.VO.Member.RegTokenDto;

@Service
public class MemberService {
	@Autowired
	private MemberDao mDao;
	
	SHA256 sha256 = new SHA256();

	//회원가입 토큰 집어넣고 id 반환
	public String setRegToken(String email, String name, int auth, int dept, int pos ) throws NoSuchAlgorithmException {
		MemberRegForm regForm = new MemberRegForm(auth, dept, pos, name, email);
		mDao.insertRegToken(regForm);
		
		//생성된 토큰의 id
		String resultId=mDao.getRegTokenID();
		
		//SHA256으로 암호화된 id
		String sha="";
		if(Integer.parseInt(resultId)>0) {
			sha=sha256.encrypt(resultId);
		}
		mDao.updateRegTokenSha(sha, resultId);
		System.out.println("sha: "+sha);
		System.out.println("id: "+resultId);
		
        System.out.println(sha);
        
        
		
		return sha;
	}
	// 토큰 정보 가져오기
	public RegTokenDto getRegTokenByID(String sha) throws NoSuchAlgorithmException {
        String id = mDao.getRegTokenID_bySha(sha);
        System.out.println("sha: "+sha);
		System.out.println("id: "+id);
		
        RegTokenDto token = new RegTokenDto();
        if(sha.equals(sha256.encrypt(id))) {
        	token = mDao.getRegTokenByID(id);
        }
        
		return token;
	}
	//회원가입 정보 입력 후 최근 pk 반환
	public String insertMember(MemberRegForm regForm) {
		mDao.insertMember(regForm);
		return mDao.getEmpPK();
	}
	public void updateRegToken_expired(String sha) throws NoSuchAlgorithmException {
		String id = mDao.getRegTokenID_bySha(sha);
		mDao.updateRegToken_expired(id);
	}
	//회원등급, 부서, 직책 리스트 가져오기
	public List<RegSelectDto> getDeptList(){
		return mDao.getDeptList();
	}
	public List<RegSelectDto> getAuthList(){
		return mDao.getAuthList();
	}
	public List<RegSelectDto> getPosList(){
		return mDao.getPosList();
	}
	//아이디 중복 갯수
	public int checkID(String id) {
		return mDao.checkID(id);
	}
	//멤버 리스트 조회
	public List<MemberDto> getMemberList(){
		return mDao.getMemberList();
	}
	//멤버 상세 조회
	public MemberDto getMemberByPK_Detailed(String pk) {
		return mDao.getMemberByPK_Detailed(pk);
	}
	//개인별 참여 프로젝트 조회
	public List<ProjectListDto> getPersonalProjectListByPK(String pk){
		return mDao.getPersonalProjectListByPK(pk);
	}
}
