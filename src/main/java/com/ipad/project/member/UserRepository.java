package com.ipad.project.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDb, Long> {

}
