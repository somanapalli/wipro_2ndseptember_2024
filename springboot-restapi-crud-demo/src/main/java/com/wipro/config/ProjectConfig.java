package com.wipro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class ProjectConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		//http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());
		//http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
		//http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		
		http.authorizeHttpRequests((requests) ->
		requests.requestMatchers("/mybalance","/myaccount").authenticated()
		        .requestMatchers("/api/employees","/home").permitAll()
				);
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();
	}
}
