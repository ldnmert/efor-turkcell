package com.turkcellperf.auth;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;

@Component
public class JWTUtil implements Serializable {

	@Serial
	private static final long serialVersionUID = -2550185165626007488L;

	@Value("${jwt.accessToken.expirationMs}")
	private Long accessTokenExpirationMs;

	public String generateToken(UserDetails userDetails) {
		String[] claims = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList()).toArray(new String[0]);

		return doGenerateToken(claims[0], userDetails.getUsername(), accessTokenExpirationMs);
	}

	private String doGenerateToken(String claims, String subject, Long expirationMs) {
		try {
			return JWT.create().withSubject(subject).withExpiresAt(new Date(System.currentTimeMillis() + expirationMs))
					.withClaim("roleName", claims).sign(HMAC512("EAXCF"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}