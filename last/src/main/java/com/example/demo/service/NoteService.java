package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.NoteMapper;

@Service
@Transactional
public class NoteService {
	@Resource(name="com.example.demo.mapper.NoteMapper")
	@Autowired
	NoteMapper noteMapper;
}
