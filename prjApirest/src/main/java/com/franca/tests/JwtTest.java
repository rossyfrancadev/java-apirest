package com.franca.tests;

import com.franca.services.AuthService;

import io.jsonwebtoken.Claims;

public class JwtTest {

	static String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NjQ2OTk1NjQsImp0aSI6IjEiLCJzdWIiOiJ0ZXN0ZSIsImlzcyI6ImZyYW5jYS5jb20iLCJleHAiOjE1NjQ3MDMxNjR9.V_ieCjnbrKUE2iGRvU5HDxC_FE1kd0H5pbH3JWWTFAw";

	public static void main(String[] args) {
		Claims teste = AuthService.decodeJWT(jwt);
		System.out.println(teste);
	}
}
