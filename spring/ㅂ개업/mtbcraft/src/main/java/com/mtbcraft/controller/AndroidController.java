package com.mtbcraft.controller;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mtbcraft.dto.RidingRecord;
import com.mtbcraft.service.AndroidService;
import com.mtbcraft.service.MemberService;

@Controller
public class AndroidController {

	@Autowired
	MemberService memberService;

	@Autowired
	AndroidService androidService;

	// 주행기록 등록(안드로이드)
	@RequestMapping(value = "/api/upload")
	@ResponseBody
	public Map<String, String> insertriding(HttpServletRequest request) throws Exception {
		RidingRecord record = new RidingRecord();

		// 현재날짜 timestamp
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// formatter.setTimeZone(TimeZone.getTimeZone("GMT+09"));
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		record.setRr_rider(request.getParameter("rr_rider"));
		record.setRr_date(ts);
		record.setRr_distance(Integer.parseInt(request.getParameter("rr_distance")));
		record.setRr_topspeed(Integer.parseInt(request.getParameter("rr_topspeed")));
		record.setRr_avgspeed(Integer.parseInt(request.getParameter("rr_avgspeed")));
		record.setRr_high(Integer.parseInt(request.getParameter("rr_high")));
		record.setRr_gpx(request.getParameter("rr_gpx"));
		record.setRr_open(Integer.parseInt(request.getParameter("rr_open")));
		record.setRr_breaktime(Integer.parseInt(request.getParameter("rr_breaktime")));
		record.setRr_time(Integer.parseInt(request.getParameter("rr_time")));
		record.setRr_area(request.getParameter("rr_area"));

		androidService.insertRecord(record);
		// 안드로이드로부터 받은 데이터
		System.out.println("rr_rider " + request.getParameter("rr_rider")); // 회원아이디
		System.out.println("rr_distance " + request.getParameter("rr_distance")); // 오늘날짜
		System.out.println("rr_topspeed " + request.getParameter("rr_topspeed")); // 소요시간
		System.out.println("rr_avgspeed " + request.getParameter("rr_avgspeed")); // 이동거리
		System.out.println("rr_high " + request.getParameter("rr_high")); // 최대속도
		System.out.println("rr_gpx " + request.getParameter("rr_gpx")); // 평균속도
		System.out.println("rr_open " + request.getParameter("rr_open")); // 획득고도
		System.out.println("rr_breaktime " + request.getParameter("rr_breaktime")); // gpx
		System.out.println("rr_time " + request.getParameter("rr_time")); // 공개여부
		System.out.println("rr_area " + request.getParameter("rr_area")); // 획득고도

		// 안드로이드에게 전달하는 데이터
		Map<String, String> result = new HashMap<String, String>();
		result.put("data1", request.getParameter("rr_rider"));
		result.put("data2", request.getParameter("rr_distance"));
		result.put("data3", request.getParameter("rr_topspeed"));
		result.put("data4", request.getParameter("rr_avgspeed"));
		result.put("data5", request.getParameter("rr_high"));
		result.put("data6", request.getParameter("rr_gpx"));
		result.put("data7", request.getParameter("rr_open"));
		result.put("data8", request.getParameter("rr_breaktime"));
		result.put("data9", request.getParameter("rr_time"));
		result.put("data10", request.getParameter("rr_area"));

		return result;
	}

	// 주행기록 가져오기
	@RequestMapping(value = "/api/get/{rr_rider}")
	public @ResponseBody List<RidingRecord> getRidingRecord(@PathVariable String rr_rider) throws Exception {
		return memberService.getRidingRecord(rr_rider);
	}

	// 주행기록 가져오기
	@RequestMapping(value = { "/api/get/{rr_rider}/{rr_num}" })
	public @ResponseBody List<RidingRecord> getRidingRecordDetail(@PathVariable(value = "rr_rider") String rr_rider,
			@PathVariable(value = "rr_num") String rr_num) throws Exception {
		System.out.println(memberService.getRidingRecord(rr_rider));
		return memberService.getRidingRecordDetail(rr_rider, rr_num);
	}
	
	@RequestMapping(value="/android/fileUpload", method=RequestMethod.POST)
	public String upload(HttpServletRequest request, MultipartFile file1){
		try{
			String path = "";
			String fileName="";
				
			if(!file1.isEmpty()){ //첨부파일이 존재?
				fileName=file1.getOriginalFilename();
				try{
					//디렉토리 생성
					new File(path).mkdir();
					//지정된 업로드 경로로 저장됨
					file1.transferTo(new File("/"+ fileName));
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/android/index";
	}
	
	@RequestMapping("/android/index")
	public String testIndex() {
		return "index";
	}
}
