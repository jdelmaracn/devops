package com.accenture.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.ws.entity.order;

@Repository
public interface OrderRepository extends JpaRepository<order, Integer>{

	@Override
	List<order> findAll() ;
	
	
	
	
}
