package com.example.jpaRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Log;

@Repository
public interface LogRepository extends CrudRepository<Log, Integer>{
	  Iterable<Log> findByUser(String name);
}