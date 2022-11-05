package com.DemoSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DemoSpring.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT e FROM User e WHERE e.username=?1")
	User getUser(String name);
}
