package com.mtbcraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RepairController {
		// 정비 메인
		@RequestMapping(value = "/repair", method = RequestMethod.GET)
		public String repair (int result) {
			return "/repair";
		}

		// 정비 가이드
		@RequestMapping(value = "/repair/guide", method = RequestMethod.GET)
		public String guide (int result) {
			return "/repair/guide";
		}

		// 정비소 검색
		@RequestMapping(value = "/repair/search", method = RequestMethod.GET)
		public String repairSearch (int result, String zipcode) {
			return "/repair/search";
		}

		// 일반 회원 정비 신청
		@RequestMapping(value = "/repair/service/apply", method = RequestMethod.GET)
		public String repairApplyGet (int result) {
			return "/repair/service/apply";
		}

		// 일반 회원 정비 신청
		@RequestMapping(value = "/repair/service/apply", method = RequestMethod.POST)
		public String repairApplyPost (int result, int RA_type, String RA_content, String RA_date) {
			return "/repair/service/apply";
		}
		
		// 일반 회원 QnA
		@RequestMapping(value = "/repair/service/qna", method = RequestMethod.GET)
		public String repairQnaGet (int result) {
			return "/repair/service/qna";
		}
		
		// 일반 회원 QnA
		@RequestMapping(value = "/repair/service/qna", method = RequestMethod.POST)
		public String repairQnaPost (int result, String QA_title, String QA_content) {
			return "/repair/service/qna";
			}

		// 정비소 회원 정비 신청
		@RequestMapping(value = "/repair/service/s/apply", method = RequestMethod.GET)
		public String s_repairApplyGet (int result) {
			return "/repair/service/s/apply";
			}
		
		// 정비소 회원 정비 신청
		@RequestMapping(value = "/repair/service/s/apply", method = RequestMethod.PUT)
		public String s_repairApplyPut (int result, int RA_num) {
			return "/repair/service/s/apply";
			}
		
		// 정비소 회원 QnA
		@RequestMapping(value = "/repair/service/s/qna", method = RequestMethod.GET)
		public String s_repairQnaGet (int result) {
			return "/repair/service/s/qna";
			}
		
		// 정비소 회원 QnA
		@RequestMapping(value = "/repair/service/s/qna", method = RequestMethod.PUT)
		public String s_repairQnaPut (int result, int QA_num, String QA_answer) {
			return "/repair/service/s/qna";
			}
		
		// 정비 후기
		@RequestMapping(value = "/repair/review", method = RequestMethod.GET)
		public String repairReviewGet (int result) {
			return "/repair/review";
		}
		
		// 정비 후기
		@RequestMapping(value = "/repair/review", method = RequestMethod.PUT)
		public String repairReviewPut (int result, int RA_num, String RA_answer) {
			return "/repair/review";
			}
	}