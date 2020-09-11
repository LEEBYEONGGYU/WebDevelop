package com.busyvacation.happyclass.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.busyvacation.happyclass.db.dto.EntityUser;

@Repository
public interface UserJpaRepository extends JpaRepository<EntityUser, String>{
	public EntityUser findByUserId(String userId);
}