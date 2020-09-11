package com.dbtest.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.dbtest.db.dao.*;
 
@Service
public class DbService {
 
    @Autowired
    DbMapper dbMapper;
 
    /* select dual */
    public String getDual()throws Exception{
        return dbMapper.getDual();
    }
 
}