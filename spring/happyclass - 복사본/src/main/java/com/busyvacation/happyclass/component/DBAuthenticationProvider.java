package com.busyvacation.happyclass.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import com.busyvacation.happyclass.db.service.UserDetailsServiceImpl;

public class DBAuthenticationProvider {
	@Component
	public class DBAuthenticationProvoder implements AuthenticationProvider {
		@Autowired
		private UserDetailsServiceImpl userDetailsService;

		@Override
		public Authentication authenticate(Authentication authentication) throws AuthenticationException {
			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
			String userId = (String) token.getPrincipal();
			String password = (String) token.getCredentials();
			UserDetails userDetails = null;
			if (!StringUtils.isEmpty(userId)) {
				userDetails = userDetailsService.loadUserByUsername(userId);
			}
			if (ObjectUtils.isEmpty(userDetails)) {
				throw new UsernameNotFoundException("Invalid userId");
			}
			if (!password.equals(userDetails.getPassword())) {
				throw new BadCredentialsException("Invalid password");
			}
			return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
		}

		@Override
		public boolean supports(Class<?> authentication) {
			return UsernamePasswordAuthenticationToken.class.equals(authentication);
		}
	}
}
