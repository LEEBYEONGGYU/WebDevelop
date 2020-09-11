//package com.mtbcraft.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class MypageController {
//		// 일반 회원 마이페이지 메인
//		@RequestMapping(value = "/mypage/member", method = RequestMethod.POST)
//		public String mypageMember (int result) {
//			return "/mypage/member";
//			}
//		
//		// 일반 회원 정보 변경
//		@RequestMapping(value = "/mypage/member/change", method = RequestMethod.GET)
//		public String memberChangeGet (int result) {
//			return "/mypage/member/change";
//			}
//		
//		// 일반 회원 정보 변경 비밀번호 확인
//		@RequestMapping(value = "/mypage/member/pw_check", method = RequestMethod.POST)
//		public String memberPwCheck (int result, String U_pw) {
//			return "/mypage/member/pw_check";
//			}		
//		
//		// 일반 회원 정보 변경 
//		@RequestMapping(value = "/mypage/member/change", method = RequestMethod.PUT)
//		public String memberChangePUT (int result, String U_pw, String U_nickname, String U_phone, String U_addr, String U_addr2, String U_image) {
//			return "/mypage/member/change";
//			}				
//		
//		// 일반 회원 탈퇴
//		@RequestMapping(value = "/mypage/member/delete", method = RequestMethod.GET)
//		public String memberDeleteGet (int result) {
//			return "/mypage/member/delete";
//			}		
//		
//		// 일반 회원 탈퇴
//		@RequestMapping(value = "/mypage/member/delete", method = RequestMethod.DELETE)
//		public String memberDelete (int result, String U_pw) {
//			return "/mypage/member/delete";
//			}
//		
//		// 주행 기록
//		@RequestMapping(value = "/mypage/member/record", method = RequestMethod.POST)
//		public String memberRecord (int result) {
//			return "/mypage/member/record";
//			}	
//		
//		// 주행 기록
//		@RequestMapping(value = "/mypage/member/record", method = RequestMethod.POST)
//		public String memberRecord (int result, int RR_num) {
//			return "/mypage/member/record";
//			}	
//		
//		// 코스 스크랩
//		@RequestMapping(value = "/mypage/member/scrap", method = RequestMethod.POST)
//		public String memberScrap (int result) {
//			return "/mypage/member/scrap";
//			}	
//
//		// 코스 스크랩
//		@RequestMapping(value = "/mypage/member/scrap", method = RequestMethod.POST)
//		public String memberScrap (int result, int SS_course) {
//			return "/mypage/member/scrap";
//			}	
//		
//		// 획득 배지
//		@RequestMapping(value = "/mypage/member/badge", method = RequestMethod.POST)
//		public String memberBadge (int result) {
//			return "/mypage/member/badge";
//			}	
//		
//		// 획득 배지
//		@RequestMapping(value = "/mypage/member/badge", method = RequestMethod.PUT)
//		public String memberBadge (int result, String U_badge) {
//			return "/mypage/member/badge";
//			}	
//		
//		// 획득 배지
//		@RequestMapping(value = "/mypage/member/badge", method = RequestMethod.POST)
//		public String memberBadge (int result, int BG_num, int MS_num, int M_num) {
//			return "/mypage/member/badge";
//			}			
//
//		// 작성 게시글
//		@RequestMapping(value = "/mypage/member/board", method = RequestMethod.POST)
//		public String memberBoardPost (int result) {
//			return "/mypage/member/board";
//			}	
//		
//		// 작성 게시글
//		@RequestMapping(value = "/mypage/member/board", method = RequestMethod.GET)
//		public String memberBoardGet (int result, int B_num) {
//			return "/mypage/member/board";
//			}	
//		
//		// 작성 댓글
//		@RequestMapping(value = "/mypage/member/comment", method = RequestMethod.POST)
//		public String memberCommentPost (int result) {
//			return "/mypage/member/comment";
//			}	
//		
//		// 작성 댓글
//		@RequestMapping(value = "/mypage/member/comment", method = RequestMethod.GET)
//		public String memberCommentGet (int result, String CO_board) {
//			return "/mypage/member/comment";
//			}			
//
//		// 작성 리뷰
//		@RequestMapping(value = "/mypage/member/review", method = RequestMethod.POST)
//		public String memberReviewPost (int result) {
//			return "/mypage/member/review";
//		}
//			
//		// 작성 리뷰
//		@RequestMapping(value = "/mypage/member/review", method = RequestMethod.GET)
//		public String memberReviewGet (int result, int CR_num) {
//			return "/mypage/member/review";	
//		}
//		// 정비 신청 이력
//		@RequestMapping(value = "/mypage/member/apply", method = RequestMethod.POST)
//		public String memberApply (int result) {
//			return "/mypage/member/apply";	
//			}	
//		
//		// 정비 신청 이력
//		@RequestMapping(value = "/mypage/member/apply", method = RequestMethod.POST)
//		public String memberApply (int result, int RA_num) {
//			return "/mypage/member/apply";	
//			}	
//		
//		// 일반 회원 정비 qna
//		@RequestMapping(value = "/mypage/member/qa", method = RequestMethod.POST)
//		public String memberQna (int result) {
//			return "/mypage/member/qa";
//			}
//			
//		// 일반 회원 정비 qna
//		@RequestMapping(value = "/mypage/member/qa", method = RequestMethod.POST)
//		public String memberQna (int result, int QA_num) {
//			return "/mypage/member/qa";			
//			}
//		
//		// 정비소 회원 마이 페이지 메인
//		@RequestMapping(value = "/mypage/shop", method = RequestMethod.POST)
//		public String mypageShop (int result) {
//			return "/mypage/shop";
//			}
//		
//		// 정비소 회원 리뷰
//		@RequestMapping(value = "/mypage/shop/review", method = RequestMethod.GET)
//		public String s_memberReview (int result) {
//			return "/mypage/shop/review";
//			}
//		
//		// 정비소 회원 정보 변경
//		@RequestMapping(value = "/mypage/shop/change", method = RequestMethod.GET)
//		public String s_memberChangeGet (int result) {
//			return "/mypage/shop/change";
//			}
//		
//		// 정비소 회원 비밀번호 확인
//		@RequestMapping(value = "/mypage/shop/pw_check", method = RequestMethod.POST)
//		public String s_memberPwCheck (int result, String RS_pw) {
//			return "/mypage/shop/pw_check";
//			}
//		
//		// 정비소 회원 정보 변경
//		@RequestMapping(value = "/mypage/shop/change", method = RequestMethod.PUT)
//		public String s_memberChangePut (int result, String RS_pw, String RS_name, String RS_phone, String RS_addr, String RS_addr2, String RS_holiday) {
//			return "/mypage/shop/change";
//			}	
//		
//		// 정비소 회원 탈퇴
//		@RequestMapping(value = "/mypage/shop/delete", method = RequestMethod.GET)
//		public String s_memberDeleteGet (int result) {
//			return "/mypage/shop/delete";
//			}			
//
//		// 정비소 회원 탈퇴
//		@RequestMapping(value = "/mypage/shop/delete", method = RequestMethod.DELETE)
//		public String s_memberDelete (int result, String RS_pw) {
//			return "/mypage/shop/delete";
//			}		
//		
//		// 정비소 회원 정비 이력
//		@RequestMapping(value = "/mypage/shop/apply", method = RequestMethod.POST)
//		public String s_memberApply (int result) {
//			return "/mypage/shop/apply";
//			}
//		
//		// 정비소 회원 정비 이력
//		@RequestMapping(value = "/mypage/shop/apply", method = RequestMethod.POST)
//		public String s_memberApply (int result, int RA_num) {
//			return "/mypage/shop/apply";
//			}		
//		
//		// 정비소 회원 QnA
//		@RequestMapping(value = "/mypage/shop/qa", method = RequestMethod.POST)
//		public String s_memberQna (int result) {
//			return "/mypage/shop/qa";
//			}
//		
//		// 정비소 회원 QnA
//		@RequestMapping(value = "/mypage/shop/qa", method = RequestMethod.POST)
//		public String s_memberQna (int result, int QA_num) {
//			return "/mypage/shop/qa";
//			}
//		}
