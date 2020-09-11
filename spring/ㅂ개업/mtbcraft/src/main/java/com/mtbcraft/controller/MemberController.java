package com.mtbcraft.controller;
import java.io.File;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.mtbcraft.dto.Member;
import com.mtbcraft.service.AndroidService;
import com.mtbcraft.service.MemberService;
@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	AndroidService androidService;


	// 회원가입 종류 선택
	@RequestMapping(value = "/member/join_select", method = RequestMethod.GET)
	public String join_select() {
		return "/member/join_select";
	}

	// 일반회원가입
	@RequestMapping("/member/general_join")
	public String general_join() {
		return "/member/general_join";
	}
	
	// 아이디 중복 체크
		@RequestMapping(value = "/member/id_check", method = RequestMethod.POST)
		public String idCheck(int result, String userid) {
			return "/member/id_check";
		}

		// 도로명 주소 찾기
		@RequestMapping(value = "/member/address_find", method = RequestMethod.GET)
		public String addressFind(int result) {
			return "/member/address_find";
		}
	
	// 일반회원가입 처리
	@RequestMapping(value = "/member/general_join", method = RequestMethod.POST)
	public String joinPOST(HttpServletRequest request, @RequestParam("userphoto") MultipartFile profile) throws Exception{
		
		//파일명
        String originalFile = profile.getOriginalFilename();
        //파일명 중 확장자만 추출                                                //lastIndexOf(".") - 뒤에 있는 . 의 index번호
        String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
        //업무에서 사용하는 리눅스, UNIX는 한글지원이 안 되는 운영체제 
        //파일업로드시 파일명은 ASCII코드로 저장되므로, 한글명으로 저장 필요
        //UUID클래스 - (특수문자를 포함한)문자를 랜덤으로 생성                    "-"라면 생략으로 대체
        String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
        String filePath =  request.getSession().getServletContext().getRealPath("/upload");
        //파일을 저장하기 위한 파일 객체 생성
        File file = new File(filePath + storedFileName);
        
        //파일 저장
        profile.transferTo(file);
        
		Member member  = new Member();
		member.setR_id(request.getParameter("userid"));
		member.setR_pw(request.getParameter("userpw"));
		member.setR_name(request.getParameter("username"));
		member.setR_nickname(request.getParameter("usernickname"));
		member.setR_birth(request.getParameter("userbirth"));
		member.setR_phone(request.getParameter("userphone"));
		member.setR_gender(request.getParameter("usergender"));
		member.setR_image(originalFile);
		member.setR_addr(request.getParameter("useraddr"));
		member.setR_addr2(request.getParameter("useraddr2"));
		member.setR_type(request.getParameter("usertype"));
	
		return "redirect:/";
	}


	// 정비소 회원가입
		@RequestMapping(value = "/member/bikecenter", method = RequestMethod.GET)
		public String bikeJoinGet(int result) {
			return "/member/bikecenter";
		}

		// 정비소 회원가입
		@RequestMapping(value = "/member/bikecenter", method = RequestMethod.POST)
		public String bikeJoinPost(HttpServletRequest request, @RequestParam("userphoto") MultipartFile profile) {
			/* 바꿔야됨 
			//파일명
	        String originalFile = profile.getOriginalFilename();
	        //파일명 중 확장자만 추출                                                //lastIndexOf(".") - 뒤에 있는 . 의 index번호
	        String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
	        //업무에서 사용하는 리눅스, UNIX는 한글지원이 안 되는 운영체제 
	        //파일업로드시 파일명은 ASCII코드로 저장되므로, 한글명으로 저장 필요
	        //UUID클래스 - (특수문자를 포함한)문자를 랜덤으로 생성                    "-"라면 생략으로 대체
	        String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
	        String filePath =  request.getSession().getServletContext().getRealPath("/upload");
	        //파일을 저장하기 위한 파일 객체 생성
	        File file = new File(filePath + storedFileName);
	        
	        //파일 저장
	        profile.transferTo(file);
	        
			Member member  = new Member();
			member.setR_id(request.getParameter("userid"));
			member.setR_pw(request.getParameter("userpw"));
			member.setR_name(request.getParameter("username"));
			member.setR_nickname(request.getParameter("usernickname"));
			member.setR_birth(request.getParameter("userbirth"));
			member.setR_phone(request.getParameter("userphone"));
			member.setR_gender(request.getParameter("usergender"));
			member.setR_image(originalFile);
			member.setR_addr(request.getParameter("useraddr"));
			member.setR_addr2(request.getParameter("useraddr2"));
			member.setR_type(request.getParameter("usertype"));*/
			return "redirect:/";
		}

	// 로그인폼
	@RequestMapping("/login")
	public String loginPost() throws Exception {
		return "/login";
	}
	

}