package com.ipad.project.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserRepository extends JpaRepository<UserDb, Long> {
	
	Optional<UserDb> findByUserId(String userId);

}
