package top.xeonwang.tmxk.util;

import java.util.Date;
import java.util.HashMap;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class Token {
	private static final long EXPIRE_TIME = 1000*60*15;
	private static final String TOKEN_SECRET = "tmxk_2020";
	public static enum TokenStatus{
		VALIAD, EXPIRE, INVALID;
	}
	public static String sign(String username,String userid, String usertype) {
		
		Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
		
		Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
		HashMap<String, Object> header = new HashMap<String, Object>(2);
		header.put("type","jwt");
		header.put("algorithm","hs256");
		return JWT.create()
				.withHeader(header)
				.withClaim("username", username)
				.withClaim("userid", userid)
				.withClaim("usertype", usertype)
				.withExpiresAt(date)
				.sign(algorithm);
	}
	public static TokenStatus verity(String token) {
		try {
			Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
			JWTVerifier verfier = JWT.require(algorithm).build();
			DecodedJWT jwt =verfier.verify(token);
			System.out.println(jwt.getHeader());
			return TokenStatus.VALIAD;
		}catch(IllegalArgumentException e){
			return TokenStatus.INVALID;
		}catch(InvalidClaimException e){
			return TokenStatus.EXPIRE;
		}catch(JWTVerificationException e) {
			return TokenStatus.INVALID;
		}
	}
}
