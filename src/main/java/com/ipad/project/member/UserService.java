package com.ipad.project.member;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

}
