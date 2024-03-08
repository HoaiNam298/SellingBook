package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.TheLoaiEntity; 


public interface TheLoaiService {
	public List<TheLoaiEntity> findAll();

	public TheLoaiEntity findById(int id);


	public TheLoaiEntity create(TheLoaiEntity TLEntity);

	public TheLoaiEntity update(TheLoaiEntity TLEntity);

	public void delete(int id);
}
