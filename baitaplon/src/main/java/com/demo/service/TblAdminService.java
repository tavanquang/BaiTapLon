package com.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.demo.dao.entity.TblAdmin;
import com.demo.repository.TblAdminDTO;

public interface TblAdminService extends CrudRepository<TblAdmin, String>{
	
	TblAdmin findByUsername(String userName);

}
