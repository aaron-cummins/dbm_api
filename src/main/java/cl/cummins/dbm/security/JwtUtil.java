package cl.cummins.dbm.security;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtUtil {
	private RSAPrivateKey privateKey;
	private RSAPublicKey publicKey;

	@Value("${dbm.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	@Value("${dbm.app.jwtRefreshExpirationMs}")
	private Long refreshTokenDurationMs;

	public JwtUtil(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}

	public String generateJwtToken(String subject){
		return JWT.create()
				.withSubject(subject)
				.withIssuedAt(new Date())
				.withExpiresAt(new Date((new Date()).getTime() + jwtExpirationMs))
				.sign(Algorithm.RSA256(publicKey, privateKey));
	}


	public String generateRefreshToken(String subject){
		return JWT.create()
				.withSubject(subject)
				.withIssuedAt(new Date())
				.withExpiresAt(null)
				.sign(Algorithm.RSA256(publicKey, privateKey));
	}


	public String encode(String subject) {
		return JWT.create()
				.withSubject(subject)
				.withExpiresAt(null)
				.sign(Algorithm.RSA256(publicKey, privateKey) );
	}

	public String encode(String subject, Date expire) {
		return JWT.create()
				.withSubject(subject)
				.withExpiresAt(expire)
				.sign(Algorithm.RSA256(publicKey, privateKey) );
	}

}
