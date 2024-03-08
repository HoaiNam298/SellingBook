package com.example.demo.Controller.Admin;

import java.util.List;

import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.PhanQuyenEntity;
import com.example.demo.Service.PhanQuyenService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

@Controller

public class DangNhap1Controller {

	@Autowired
	PhanQuyenService PQService;

	@GetMapping("/Admin/TaiKhoan/DangNhap")
	public String DangNhapGet(Model model,
			@CookieValue(value = "email", defaultValue = "", required = false) String email,
			@CookieValue(value = "matkhau", defaultValue = "", required = false) String matkhau) {

		model.addAttribute("email",email);
		model.addAttribute("matkhau",matkhau);
		
		System.out.println(email);

		return "Admin/TaiKhoan/DangNhap";
	}

	@PostMapping("/Admin/TaiKhoan/DangNhap1")
	public String DangNhapGet(Model model, HttpServletResponse response,
			@RequestParam(name = "rememberMe", required = false) boolean rememberMe,
			@RequestParam(name = "email") String email, @RequestParam(name = "matkhau") String matkhau) {
		
		if (email == null || email.equals("")) {
			return "redirect:/TrangChu/DangNhap";
		} 
		
		List<PhanQuyenEntity> PQEntity = PQService.findByEmail(email);
		
		for (PhanQuyenEntity PQ : PQEntity) {
			System.out.println(PQ.getId_pq());

			if (email.equals(PQ.getTaikhoan().getEmail()) && matkhau.equals(PQ.getTaikhoan().getMatkhau())) {
				
				Cookie ckiEmail = new Cookie("email", email);
				Cookie ckiMatKhau = new Cookie("matkhau", matkhau);
				int expiry = 0;
				if (rememberMe == true) {
					expiry = 10 * 24 * 60 * 60;
					System.out.println(expiry);
				}
				ckiEmail.setMaxAge(expiry);
				ckiMatKhau.setMaxAge(expiry);
				response.addCookie(ckiEmail);
				response.addCookie(ckiMatKhau);
				
				
				if (PQ.getVaitro().getId_vt()==3) {
					
					System.out.println("Dang Nhập Thành Công Trang Admin");
					return "redirect:/Admin/TrangChu";
				}
				if (PQ.getVaitro().getId_vt()==2) {
					System.out.println("Dang Nhập Thành Công Trang Nhân Viên");
					return "redirect:/Admin/TrangChu";
				}
				if (PQ.getVaitro().getId_vt()==1) {
					System.out.println("Dang Nhập Thành Công Trang Khách Hàng");
					return "redirect:/index";
				}

				
			}

		}

		return "redirect:/Admin/TaiKhoan/DangNhap";

	}


}
