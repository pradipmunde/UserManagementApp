package com.pradip.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySecurity {
	@Bean
	public UserDetailsService userDetailsservice(PasswordEncoder encoder) {
		UserDetails admin=User.
				withUsername("pradip")
			.password(encoder.encode("pradip"))
				.roles("admin")
				.build();
		System.out.println("This is pradip" + admin.getPassword());
		
		UserDetails simpleuser=User.
				withUsername("vedant")
				.password(encoder.encode("vedant"))
				.roles("simpleuser")
				.build();
		   return new InMemoryUserDetailsManager(admin,simpleuser);
		}

//		@Bean
//		public UserDetailsService userDetailsservice(PasswordEncoder encoder) {
//			UserDetails admin=User.
//					withUsername("Username")
//					.password(encoder.encode("password"))
//					.roles("admin")
//					.build();
//			System.out.println("This is pradip" + admin.getPassword());
//			
//			UserDetails simpleuser=User.
//					withUsername("vedant")
//					.password(encoder.encode("vedant"))
//					.roles("simpleuser")
//					.build();
//			
//		
//		return new UserInfoUserDetailsService();
//		
//	}
	
	@Bean
	public PasswordEncoder passwordencoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http.csrf().disable()
				.authorizeHttpRequests()
				.antMatchers("/createUser").permitAll()
				.and()
				.authorizeHttpRequests()
				.antMatchers("/login")
				.authenticated()
				.and()
				.exceptionHandling()
				//.and().formLogin()
				.and().build();
	}
	
	

}
