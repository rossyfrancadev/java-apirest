package com.franca.services;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import com.franca.models.Session;

import io.jsonwebtoken.*;

public class AuthService {

	private static final String ISSUER = "franca.com";
	private static final String SECRET_KEY = "yQXBwTmFtZUhlcmUiLCJhdWQi@^($%*$%OiJOb3RSZWFsbHlJbXB";
	private static final Long DURACAO_WEB = 1000L * 60 * 60; // 1 HORA

	public static String createJWT(Session session) {

		SignatureAlgorithm signature = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signature.getJcaName());

		JwtBuilder builder = Jwts.builder().setIssuedAt(now).setSubject(session.getName()).setIssuer("")
				.signWith(signature, signingKey);

		return builder.compact();
	}

	public static Claims decodeJWT(String jwt) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.parseClaimsJws(jwt)
				.getBody();
		return claims;
	}
}
