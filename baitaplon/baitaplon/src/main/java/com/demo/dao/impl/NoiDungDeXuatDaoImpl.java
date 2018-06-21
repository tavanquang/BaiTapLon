package com.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.NoiDungDeXuatDao;
import com.demo.dao.entity.TblNoiDungDeXuat;
import com.demo.dao.entity.TblPhieuDeXuat;

@Transactional
@Repository
public class NoiDungDeXuatDaoImpl implements NoiDungDeXuatDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void AddNoiDungDeXuat(TblNoiDungDeXuat noiDungDeXuat) {
		// TODO Auto-generated method stub
		entityManager.persist(noiDungDeXuat);
	}

	@Override
	public List<TblNoiDungDeXuat> getAllByIdPhieu(TblPhieuDeXuat phieuDeXuat) {
		String jql = "SELECT n FROM TblNoiDungDeXuat n where n.tblPhieuDeXuat = ?";
		return entityManager.createQuery(jql, TblNoiDungDeXuat.class).setParameter(1, phieuDeXuat).getResultList();

	}

}
