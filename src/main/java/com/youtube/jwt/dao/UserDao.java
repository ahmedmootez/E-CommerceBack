package com.youtube.jwt.dao;

import com.youtube.jwt.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao extends JpaRepository<User, String> {
	//Optional<User> findById(String username);
	Optional<User> findByEmail(String email);
	 @Transactional
	    @Modifying
	    @Query("UPDATE User a " +
	            "SET a.enabled = TRUE WHERE a.email = ?1")
	    int enableAppUser(String email);
}
