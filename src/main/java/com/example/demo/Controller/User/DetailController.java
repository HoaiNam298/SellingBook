package com.example.demo.Controller.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Dao.SanPhamDao;
import com.example.demo.Entity.BinhLuanEntity;
import com.example.demo.Entity.SanPhamEntity;
import com.example.demo.Service.BinhLuanService;
import com.example.demo.Service.SanPhamService;

import jakarta.servlet.http.HttpServletRequest; 



@Controller
public class DetailController {

	@Autowired
	SanPhamService SPService;
	
	@Autowired
	SanPhamDao sanPhamDao;
	
	@Autowired 
	BinhLuanService binhLuanService;

	@RequestMapping("/detail")
	public String detail() {
		return "user/product/detail";
	}

	@GetMapping("/detail/{id_sp}")
	public String details(Model model, HttpServletRequest request, @PathVariable("id_sp") int id_sp,
						@RequestParam(name = "page") Optional<Integer> page) {
		SanPhamEntity item = sanPhamDao.findById(id_sp).get();
		model.addAttribute("request", request);
		model.addAttribute("item", item);
		model.addAttribute("comment", binhLuanService.findByIDSP(id_sp));
		return "user/product/detail";
	}
}
