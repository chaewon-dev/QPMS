package com.team3.pms.Controller.MyPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team3.pms.Service.MyPage.MyProductService;
import com.team3.pms.VO.Member.CustomUser;
import com.team3.pms.VO.MyPage.Product;




@Controller
public class MyProductController {
	
	@Autowired
	MyProductService service;
	
	// MY 산출물 리스트
	@RequestMapping("/productList")
	public String productList(Product sch, Authentication auth, Model d){
    	CustomUser member = (CustomUser) auth.getPrincipal();
		d.addAttribute("projectList", service.getProjectNm());
		d.addAttribute("categoryList", service.getCategoryNm());
		d.addAttribute("productList", 
				service.getProductList(member.getEmp_cd_pk()));
		return "MyPage/productList";
	}	
	
	// MY산출물 등록

	@RequestMapping("/insertProduct")
	public String productInsert(@RequestParam MultipartFile file,
			Product ins, Authentication auth, Model d) throws IOException {
		
		File convertFile = new File("uploads/"+file.getOriginalFilename());
		convertFile.createNewFile();
		
		try (FileOutputStream fout = new FileOutputStream(convertFile))	{
			fout.write(file.getBytes());
		}
		catch (Exception exe) {
			exe.printStackTrace();
		}

		Map<String, Object> insobj = new HashMap <String, Object>();
    	CustomUser member = (CustomUser) auth.getPrincipal();
    	insobj.put("project_pk", ins.getProject_pk());
    	insobj.put("project_pk", ins.getProject_nm());
    	insobj.put("task_pk", ins.getTask_pk());
    	insobj.put("task_pk", ins.getTask_nm());
    	insobj.put("prod_category_cd", ins.getProd_category_cd());
    	insobj.put("prod_classify_cd", ins.getProd_classify_cd());
    	insobj.put("prod_detail", ins.getProd_detail());
    	insobj.put("attach_nm", file.getOriginalFilename());
    	insobj.put("uploaded_from", member.getEmp_cd_pk());
    	service.insertProduct(insobj);
    	return "redirect:/productList";
    }
	
	
	@RequestMapping("/prodDownload")
	public void prodDownload(@RequestParam("fname") String fname, Model d, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		File file = new File("uploads/"+fname);
		System.out.println("## viewer오신 것을 환영합니다##");
		System.out.println("전체파일명:"+file.getPath());
		System.out.println("파일명:"+file.getName());
		System.out.println("파일길이:"+(int)file.length());
		// 2. 다운로드 처리를 위한 response 객체 설정..
		//		1) 파일다운을 처리하기 위한 contentType설정.
		response.setContentType("application/download; charset=UTF-8");
		//		2) 파일의 길이와 파일명 설정.
		response.setContentLength((int)file.length());
		//         - 한글파일명을 위한 encoding처리..
		fname = URLEncoder.encode(fname,"utf-8").replaceAll("\\+", " ");
		//  3. Header 정보 설정..
		// filename="파일명"
		response.setHeader("Content-Disposition",
				"attachment;filename=\""+fname+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		//  4. 파일을 InputStream으로 전환하여 response의 OutStream에 탑재
		//     하여 전송..
		FileInputStream fis = new FileInputStream(file);
		
		OutputStream out = response.getOutputStream();
		//     	1) FileCopyUils의 copy 메서드를 통해서 전달.
		FileCopyUtils.copy(fis, out);
		//		2) 전송 완료 처리..
		out.flush();
		
	}
	
	// MY 산출물 수정
	@RequestMapping("/productUpdate")
	public String productUpdate(Product upt) {
		service.productUpdate(upt);
    	return "redirect:/productList";
	}		
	// MY 산출물 삭제
	@RequestMapping("/productDelete")
	public String productDelete(@RequestParam("prod_cd_pk") String prod_cd_pk) {
		service.productDelete(prod_cd_pk);
    	return "redirect:/productList";
	}
	
	
	
}
