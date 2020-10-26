package co.com.coomeva.coben.security;

public class Constants {

	// Spring Security

	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT

	public static final String ISSUER_INFO = "https://zathuracode.org";
	public static final String SUPER_SECRET_KEY = "z4tur4c0dv92020isth3b3stcodeg3n3ratorintheworldofj4v4v0rtex2020";
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

}
