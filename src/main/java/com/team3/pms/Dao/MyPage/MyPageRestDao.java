package com.team3.pms.Dao.MyPage;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.VO.MyPage.*;

@Mapper
public interface MyPageRestDao {
	
	// MY산출물 리스트
	ArrayList <Product> getProductList (String emp_cd_pk);
	
	// select 선택목록
	ArrayList <Product> getTaskNm(String project_pk);
	ArrayList <String> getProjectNm();
	ArrayList <String> getCategoryNm();

	// MY테스크 상세정보 조회
	ArrayList <Product> getproductDetail (String prod_cd_pk);
	
	// MY산출물 등록
	public void insertProduct(Map<String, Object> insobj);
	
	// MY산출물 첨부파일 등록
	public void insertAttachment(Map<String, Object> insobj);

	// MY산출물 업데이트 
	public void productUpdate(Product upt);
	
	public void productDelete(String prod_cd_pk);

}
