package com.sportyshoes.controllers.users;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
		@Autowired
		private AuthService authService;
		
		@PostMapping("/signIn")
		public Map<String, String> signIn(@RequestBody MultiValueMap<String, String> credentials) {
			Map<String, String> signInResponse = new HashMap<>();
		Boolean userAuthenticated = authService.signInUser(credentials.get("USER_NAME").get(0), credentials.get("PASSWORD").get(0));
			
			if(userAuthenticated) {
				signInResponse.put("status", "true");
				signInResponse.put("message", "Authentication success");	
			}else {
				
				signInResponse.put("status", "false");
				signInResponse.put("message", "Authentication not success");	
			}
			return signInResponse;
		}

}
