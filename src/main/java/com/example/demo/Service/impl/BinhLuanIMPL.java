package com.example.demo.Service.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.BinhLuanDao;
import com.example.demo.Entity.BinhLuanEntity;
import com.example.demo.Service.BinhLuanService;
import com.example.demo.Service.SanPhamService;
import com.example.demo.Service.TaiKhoanService;
import com.example.demo.Service.TheLoaiService; 

@Service
public class BinhLuanIMPL implements BinhLuanService{
	@Autowired
	BinhLuanDao BLDao;
	
	@Autowired
	TaiKhoanService TKService;
	
	@Autowired
	SanPhamService SPService;
	
	@Autowired
	TheLoaiService TLService;
	
	

	@Override
	public List<BinhLuanEntity> findAll() {
		// TODO Auto-generated method stub
		return BLDao.findAll();
	}

	@Override
	public BinhLuanEntity findById(String id) {
		// TODO Auto-generated method stub
		return BLDao.findById(id).get();
	}

	@Override
	public BinhLuanEntity create(BinhLuanEntity BLEntity) throws Exception {
		
//		TaiKhoanEntity TKEntity = new TaiKhoanEntity();
//		TKEntity.setEmail(BLEntity.getTaikhoan().getEmail());
//		TKEntity.setMatkhau(BLEntity.getTaikhoan().getMatkhau());
//		TKEntity.setHovaten(BLEntity.getTaikhoan().getHovaten());
//		TKEntity.setAnh(BLEntity.getTaikhoan().getAnh());
//		TKEntity.setDiachi(BLEntity.getTaikhoan().getDiachi());
//		TKService.create(TKEntity);
		
//		SanPhamEntity SPEntity = new SanPhamEntity();
//		SPEntity.setId_sp(BLEntity.getSanpham().getId_sp());
//		SPEntity.setGia(BLEntity.getSanpham().getGia());
//		SPEntity.setTen(BLEntity.getSanpham().getTen());
////		Ngay
//		try {
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//			String formattedDateAsString = dateFormat.format(BLEntity.getSanpham().getNgayxuatban()); 
//			Date formattedDateAsDate = dateFormat.parse(formattedDateAsString);
//			SPEntity.setNgayxuatban(formattedDateAsDate);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
////		EndNgay
//		SPEntity.setAnh(BLEntity.getSanpham().getAnh());
//		SPEntity.setSoluongsp(BLEntity.getSanpham().getSoluongsp());
//		System.out.println(SPEntity.getNgayxuatban());
//		TheLoaiEntity TLEntity = new TheLoaiEntity();
//		TLEntity.setId_tl(BLEntity.getSanpham().getTheloai().getId_tl());
//		TLEntity.setTentheloai(BLEntity.getSanpham().getTheloai().getTentheloai());
//		SPEntity.setTheloai(TLEntity);
		
		BLEntity.setTaikhoan(BLEntity.getTaikhoan());
		BLEntity.setSanpham(BLEntity.getSanpham());
		
		return BLDao.save(BLEntity);
	}


	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		BLDao.deleteById(id);
	}

	@Override
	public Page<BinhLuanEntity> findAllCmt(Integer page, Integer limit) {
		Pageable pageable = PageRequest.of(page, limit);
		return BLDao.findAll(pageable);
	}

	@Override
	public List<BinhLuanEntity> findByIDSP(int id_sp) {
		// TODO Auto-generated method stub
		return BLDao.findByIDSp(id_sp);
	}
}
