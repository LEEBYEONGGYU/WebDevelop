package com.mtbcraft.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mtbcraft.mapper.AndroidMapper;
import com.mtbcraft.dto.RidingRecord;


@Service
@Transactional
public class AndroidService {

	@Autowired
	private AndroidMapper androidMapper;
	
	public String insertRecord(RidingRecord record) throws Exception{
		return androidMapper.insertRecord(record);
	}

	public String readRecord(String rr_rider) throws Exception{
		return androidMapper.readRecord(rr_rider);
		
	}
	
}
