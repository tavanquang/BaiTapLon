package com.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.PhieuDeXuatDao;
import com.demo.dao.entity.TblPhieuDeXuat;

@Transactional
@Repository
public class PhieuDeXuatDaoImpl implements PhieuDeXuatDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<TblPhieuDeXuat> getAll() {
		// TODO Auto-generated method stub
		String jql = "SELECT p FROM TblPhieuDeXuat p";
		return entityManager.createQuery(jql, TblPhieuDeXuat.class).getResultList();
	}

	@Override
	public TblPhieuDeXuat AddPhieuDeXuat(TblPhieuDeXuat phieuDeXuat) {
		// TODO Auto-generated method stub
		entityManager.persist(phieuDeXuat);
		entityManager.flush();
		return phieuDeXuat;
	}

	@Override
	public TblPhieuDeXuat getPhieuDeXuat(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(TblPhieuDeXuat.class, id);
	}

	@Override
	public void ChuyenTrangThaiPhieuDeXuat(TblPhieuDeXuat phieuDeXuat) {
		// TODO Auto-generated method stub
		entityManager.merge(phieuDeXuat);
	}

	@Override
	public List<TblPhieuDeXuat> getAllByTrangThai(int trangThai) {
		String jql = "SELECT p FROM TblPhieuDeXuat p";
		return entityManager.createQuery(jql, TblPhieuDeXuat.class).setParameter(1, trangThai).getResultList();
	
	}

}
