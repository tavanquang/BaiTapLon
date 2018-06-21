package com.demo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.AdminDao;
import com.demo.dao.entity.TblAdmin;

@Transactional
@Repository
public class AdminDaoImpl implements AdminDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public TblAdmin getAdmin(String username) {
		return entityManager.find(TblAdmin.class, username);
	}

	
	
}
