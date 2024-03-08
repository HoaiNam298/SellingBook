package com.example.demo.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.PhanQuyenDao;
import com.example.demo.Entity.PhanQuyenEntity;
import com.example.demo.Service.PhanQuyenService;
import com.example.demo.Service.TaiKhoanService;
import com.example.demo.Service.VaiTroService;

@Service
public class PhanQuyenIMPL implements PhanQuyenService{

	@Autowired
	PhanQuyenDao PQDao;
	@Autowired
	TaiKhoanService TKService;
	@Autowired
	VaiTroService VTService;
	
	@Override
	public List<PhanQuyenEntity> findAll() {
		// TODO Auto-generated method stub
		return PQDao.findAll();
	}

	@Override
	public PhanQuyenEntity findById(String id) {
		// TODO Auto-generated method stub
		return PQDao.findById(id).get();
	}

	@Override
	public PhanQuyenEntity create(PhanQuyenEntity PQEntity) {
		
		TKService.create(PQEntity.getTaikhoan());
		VTService.create(PQEntity.getVaitro());
		
		return PQDao.save(PQEntity);
	}

	

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		PQDao.deleteById(id);
	}
	
	@Override
	public List<PhanQuyenEntity> findByEmail(String email) {
		
		return PQDao.findPQByEmail(email);
	}

	
}
