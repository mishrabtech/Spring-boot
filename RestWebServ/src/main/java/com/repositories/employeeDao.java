package com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Dao.Empdata;


@Repository
public interface employeeDao extends CrudRepository<Empdata, Integer>{
	
}
