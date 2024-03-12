package com.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	 Optional<Users> findByUsername(String username);
}