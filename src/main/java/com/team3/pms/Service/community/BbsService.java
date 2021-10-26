package com.team3.pms.Service.community;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team3.pms.Dao.community.BbsDao;
import com.team3.pms.VO.community.Bbs;
import com.team3.pms.VO.community.Bfile;

@Service
public class BbsService {
	@Autowired
	private BbsDao dao;
	@Value("${file.upload}")
	private String myPath;

	// 공지사항 리스트 조회
	public ArrayList<Bbs> noticeList() {
		return dao.noticeList();
	}

	/*
	 * public ArrayList<Bbs> noticeList(Bbs sch) { if(sch.getBbs_title()==null) {
	 * sch.setBbs_title(""); } return dao.noticeList(sch); }
	 */

	// 상세 조회
	public Bbs bbsDetail(String bbs_cd_pk) {
		dao.hitUpdate(bbs_cd_pk);
		Bbs bbs = dao.bbsDetail(bbs_cd_pk);
		if (dao.getFile(bbs_cd_pk) != null) {
			bbs.setBfile_nm(dao.getFile(bbs_cd_pk));
			bbs.setBfile_cd_pk(dao.getFileNum(bbs_cd_pk));
		}
		return bbs;
	}

	// 공지사항 등록
	public void noticeInsert(Bbs insert) {
		insert.setBbs_kind("N");
		dao.noticeInsert(insert);
		fileInsert(insert.getReport());
		System.out.println("제목:" + insert.getBbs_title());
		System.out.println("첨부파일:" + insert.getReport().getOriginalFilename());
	}

	// 글 삭제
	public void bbsDelete(String bbs_cd_pk) {
		dao.bbsDelete(bbs_cd_pk);
	}

	// 파일 삭제
	public void fileDelete(String bfile_cd_pk) {
		dao.fileDelete(bfile_cd_pk);
	}

	// 공지사항 수정
	public void noticeUpdate(Bbs update) {
		dao.noticeUpdate(update);
		MultipartFile report = update.getReport();
		if(report!=null) {
			String orgName = report.getOriginalFilename();
			if(!orgName.equals("")) updateFile(update.getBbs_cd_pk(),report);
		}
	}

	// 자료실 조회
	public ArrayList<Bbs> archiveList() {
		return dao.archiveList();
	}

	// 자료실 등록
	public void archiveInsert(Bbs insert) {
		insert.setBbs_kind("A");
		dao.noticeInsert(insert);
		dao.archiveInsert(insert);
		fileInsert(insert.getReport());
		System.out.println("제목:" + insert.getBbs_title());
		System.out.println("첨부파일:" + insert.getReport().getOriginalFilename());
	}

	// 자료실 수정
	public void archiveUpdate(Bbs update) {
		dao.archiveUpdate(update);
		MultipartFile report = update.getReport();
		if(report!=null) {
			String orgName = report.getOriginalFilename();
			if(!orgName.equals("")) updateFile(update.getBbs_cd_pk(),report);
		}
	}
	
	// 파일 수정
	public void updateFile(String bbs_cd_pk, @RequestParam MultipartFile file) {
		String tmpUpload = myPath;
		String fileName = file.getOriginalFilename();
		String savedName = UUID.randomUUID().toString() + "_" + fileName;
		File savedFile = new File(tmpUpload + savedName);
		try (FileOutputStream fout = new FileOutputStream(savedFile)){
			fout.write(file.getBytes());
			//savedFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Bfile bfile = new Bfile(bbs_cd_pk, fileName, savedName);
		dao.updateFile(bfile);
	}

	// 파일 상세 조회
	public Bfile getFileDetail(String bfile_cd_pk) {
		return dao.getFileDetail(bfile_cd_pk);
	}

	// 파일 업로드
	public void fileInsert(@RequestParam MultipartFile file) {
		String tmpUpload = myPath;
		if (file != null && !file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			String savedName = UUID.randomUUID().toString() + "_" + fileName;
			System.out.println("받은 파일:" + fileName);
			File savedFile = new File(tmpUpload + savedName);
			try (FileOutputStream fout = new FileOutputStream(savedFile)){
				fout.write(file.getBytes());
				//savedFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Bfile bfile = new Bfile(fileName, savedName);
			System.out.println("bfile내용:" + bfile.getBfile_nm());
			dao.fileInsert(bfile);
		}
	}

	// 파일 다운로드
	public Path load(String fileName) {
		String uploadPath = myPath;
		return Paths.get(uploadPath).resolve(fileName);
	}

	// 리소스
	public Resource loadAsResource(String fileName) {
		Path file = load(fileName);
		Resource resource = null;
		try {
			resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("파일을 찾을 수 없습니다");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return resource;
	}

}
