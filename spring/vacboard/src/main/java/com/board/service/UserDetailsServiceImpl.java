package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import com.aboard.db.dto.EntityUser;
import com.aboard.db.repository.UserJpaRepository;
	@Component
	public class UserDetailsServiceImpl implements UserDetailsService {
		@Autowired
		private UserJpaRepository userRepository;

		@Override	
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			System.out.println("UserDetailsServiceImpl: " + username);
			EntityUser entityUser = userRepository.findByUserId(username);
			if (ObjectUtils.isEmpty(entityUser)) {
				throw new UsernameNotFoundException("Invalid username");
			}
			UserDetails user = User.withUsername(entityUser.getMemberid()).password(entityUser.getPassword())
					.username(entityUser.getMemberid()).authorities(AuthorityUtils.createAuthorityList("USER"))
					.roles("USER").build();
			return user;
		}
	}
