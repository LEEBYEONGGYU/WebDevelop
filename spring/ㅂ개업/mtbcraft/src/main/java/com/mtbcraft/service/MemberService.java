package com.mtbcraft.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mtbcraft.dto.Course;
import com.mtbcraft.dto.DangerousArea;
import com.mtbcraft.dto.Login;
import com.mtbcraft.dto.Member;
import com.mtbcraft.dto.No_Danger;
import com.mtbcraft.dto.RidingRecord;
import com.mtbcraft.mapper.MemberMapper;


@Service
@Transactional
public class MemberService {
	@Resource(name="com.mtbcraft.mapper")
	@Autowired
	private MemberMapper memberMapper;
	
	
	public String memberInsert(Member member) throws Exception {
		return memberMapper.memberInsert(member);
	}
	
	public String memberLogin(Login login) throws Exception {
		return memberMapper.memberLogin(login);
	}
	
	public List<RidingRecord> getRidingRecord(String rr_rider) throws Exception {
		return memberMapper.getRidingRecord(rr_rider);
	}
	
	public List<RidingRecord> getRidingRecordDetail(String rr_rider, String rr_num) throws Exception {
		return memberMapper.getRidingRecordDetail(rr_rider, rr_num);
	}
	public void updateRidingRecord(int rr_num, int rr_open) throws Exception{
		memberMapper.updateRidingRecord(rr_num, rr_open);
	}
	
	public List<Course> getCourse() throws Exception{
		return memberMapper.getCourse();
	}
	
	public List<Course> getScrapCourse(String rr_rider) throws Exception{
		return memberMapper.getScrapCourse(rr_rider);
	}
	public void postScrapCourse(String ss_rider, int ss_course){
		memberMapper.postScrapCourse(ss_rider, ss_course);
	}
	public void deleteScrapCourse(String ss_rider, int ss_course) throws Exception{
		memberMapper.deleteScrapCourse(ss_rider, ss_course);
	}
	
	public List<DangerousArea> getDangerousArea() throws Exception{
		return memberMapper.getDangerousArea();
	}
	
	public List<DangerousArea> getUserDangerousArea(String rr_rider) throws Exception{
		return memberMapper.getUserDangerousArea(rr_rider);
	}
	
	public void postDangerousArea(DangerousArea da) throws Exception {
		memberMapper.postDangerousArea(da);
	}
	public void deleteDangerousArea(int da_num) throws Exception{
		memberMapper.deleteDangerousArea(da_num);
	}
	
	public void postNoDanger(No_Danger nd) throws Exception{
		memberMapper.postNoDanger(nd);
	}
}
