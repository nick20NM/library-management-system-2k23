package com.alpha.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.lms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
