package com.java.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	
	Optional<User> findByEmail(String email);

    Optional<User> findByuserNameOrEmail(String userName, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByuserName(String userName);

    Boolean existsByuserName(String userName);

    Boolean existsByEmail(String email);
	
}
