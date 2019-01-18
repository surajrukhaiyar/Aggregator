package com.example.jpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Users;

/**
 * Jan 18, 2019
 * @author suraj.r
 * 
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	Users findByName(String username);
}
