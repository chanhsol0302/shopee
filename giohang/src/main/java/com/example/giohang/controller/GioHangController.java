package com.example.giohang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.giohang.model.GioHang;
import com.example.giohang.model.SanPham;
import com.example.giohang.service.GioHangService;

@RestController
@RequestMapping("/api/giohang")
public class GioHangController {
	@Autowired
	private GioHangService giohangService;
	
	@GetMapping("/userId/{userId}")
	public ResponseEntity<GioHang> getGioHangByUserId(@PathVariable String userId) {
		GioHang gh = giohangService.getGioHangByUserId(userId);
		return new ResponseEntity<>(gh, HttpStatus.OK);
	}
	
	@PutMapping("/addSanPham/{userId}")
	public ResponseEntity<GioHang> addSanPhamToGioHang(@PathVariable String userId, @RequestBody SanPham sanpham) {
		GioHang gh = giohangService.addSanPhamToGioHang(userId, sanpham);
		return new ResponseEntity<>(gh, HttpStatus.OK);
	}
	
	@DeleteMapping("/removeSanPham")
	public ResponseEntity<GioHang> removeSanPhamFromGioHang(@RequestParam String userId, @RequestParam String productId) {
		GioHang gh = giohangService.removeSanPhamFromGioHang(userId, productId);
		return new ResponseEntity<>(gh, HttpStatus.OK);
	}
}	 