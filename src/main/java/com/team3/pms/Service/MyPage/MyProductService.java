package com.team3.pms.Service.MyPage;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.pms.Dao.MyPage.MyPageRestDao;
import com.team3.pms.VO.MyPage.Product;

@Service
public class MyProductService {
	
	@Autowired(required=false)
	public MyPageRestDao dao;

	// MY산출물 리스트 조회
	public ArrayList <Product> getProductList (String emp_cd_pk) {
		return dao.getProductList(emp_cd_pk);
	}
	// 테스크 이름 리스트
	public ArrayList <Product> getTaskNm(String project_pk) {
		return dao.getTaskNm(project_pk);
	}
	// 프로젝트 이름 리스트
	public ArrayList <String> getProjectNm() {
		return dao.getProjectNm();
	}
	// 산출물 카테고리 이름 리스트
	public ArrayList <String> getCategoryNm() {
		return dao.getCategoryNm();
	}
	
	// MY산출물 상세정보 조회
	public ArrayList<Product> getproductDetail (String prod_cd_pk) {
		return dao.getproductDetail(prod_cd_pk);
	}
	
	// MY산출물등록
	public void insertProduct(Map<String, Object> insobj) {	
		dao.insertProduct(insobj);
		dao.insertAttachment(insobj);
	};
		
	public void productUpdate(Product upt) {
		dao.productUpdate(upt);
	};
	
	public void productDelete(String prod_cd_pk) {
		dao.productDelete(prod_cd_pk);
	};
}
