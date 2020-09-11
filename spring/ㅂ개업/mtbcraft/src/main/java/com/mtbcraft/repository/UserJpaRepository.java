package com.mtbcraft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtbcraft.dto.Login;


@Repository
public interface UserJpaRepository extends JpaRepository<Login, String>{
	public Login findByUserId(String userId);
}