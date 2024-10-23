package com.ipad.project.member;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ipad.project.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserDb create(String userId, String password, String userName, String phone, String email) {
		UserDb user = new UserDb();
		user.setUserId(userId);
		user.setPassword(passwordEncoder.encode(password));
		user.setUserName(userName);
		user.setPhone(phone);
		user.setEmail(email);
		this.userRepository.save(user);
		return user;

	}
	
	public UserDb getUser(String userId) {
		Optional<UserDb> userDb = this.userRepository.findByUserId(userId);
		if(userDb.isPresent()) {
			return userDb.get();
		}else {
			throw new DataNotFoundException("userDb not found");
		}
		
	}

}
