//package com.turkcellperf.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import com.turkcellperf.service.AgentDetailServiceImpl;
//
//@Configuration
//@EnableWebSecurity
//public class SecurtiyConfig2 {
//
//	private final BCryptPasswordEncoder bCryptPasswordEncoder;
//	private final AgentDetailServiceImpl agentService;
//	
//	@Autowired
//	   public SecurtiyConfig2(BCryptPasswordEncoder bCryptPasswordEncoder, AgentDetailServiceImpl agentService) {
//		
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//		this.agentService = agentService;
//	}
//	@Bean
//	    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//
//
//	        httpSecurity
//	                .cors(Customizer.withDefaults())
//	                .csrf(AbstractHttpConfigurer::disable)
//	                .authorizeHttpRequests(auth -> auth
//	                        .requestMatchers(HttpMethod.GET, "/login").permitAll()
//	                        .requestMatchers(HttpMethod.GET, "/rest/aaa").permitAll()
//	         
//	     
//	  
//	                        .anyRequest().authenticated()
//	                );
//	            
//
//	        return httpSecurity.build();
//	    }
//	    @Autowired
//	    void registerProvider(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(agentService).passwordEncoder(bCryptPasswordEncoder);
//	    }
//
//	    @Bean
//	    CorsConfigurationSource corsConfigurationSource() {
//	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//	        return source;
//	    }
//}
