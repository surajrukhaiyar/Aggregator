package com.example.jpaRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Log;

/**
 * Jan 18, 2019
 * @author suraj.r
 * 
 */
@Repository
public interface LogRepository extends CrudRepository<Log, Integer>{
	  Iterable<Log> findByUser(String name);
}