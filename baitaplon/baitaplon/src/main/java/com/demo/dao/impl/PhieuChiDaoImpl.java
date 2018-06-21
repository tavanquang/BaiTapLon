package com.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.PhieuChiDao;
import com.demo.dao.entity.TblPhieuChi;

@Transactional
@Repository
public class PhieuChiDaoImpl implements PhieuChiDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<TblPhieuChi> getAll() {
		String jql = "SELECT p FROM TblPhieuChi p";
		return entityManager.createQuery(jql, TblPhieuChi.class).getResultList();
	}

	@Override
	public void AddPhieuChi(TblPhieuChi phieuChi) {
		// TODO Auto-generated method stub
		entityManager.persist(phieuChi);
	}

	@Override
	public TblPhieuChi getPhieuChi(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(TblPhieuChi.class, id);
	}

	@Override
	public List<TblPhieuChi> getAllByTrangThai(int trangThai) {
		String jql = "SELECT p FROM TblPhieuChi p where p.trangThai = ?";
		return entityManager.createQuery(jql, TblPhieuChi.class).setParameter(1, trangThai).getResultList();

	}

	@Override
	public void ChuyenTrangThaiPhieuChi(TblPhieuChi phieuChi) {
		// TODO Auto-generated method stub
		entityManager.merge(phieuChi);
	}

}
