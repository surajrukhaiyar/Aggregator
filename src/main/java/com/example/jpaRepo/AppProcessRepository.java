package com.example.jpaRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.AppProcess;

/**
 * Jan 18, 2019
 * @author suraj.r
 * 
 */
@Repository
public interface AppProcessRepository extends CrudRepository<AppProcess, Integer>{ 
	  AppProcess findByProcessId(String processId);
	  Iterable<AppProcess> findByUser(String name);
}