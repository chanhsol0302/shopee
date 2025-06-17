package com.example.sanpham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sanpham.model.SanPham;
import com.example.sanpham.service.SanPhamService;

@RestController
@RequestMapping("/api/sanpham")
public class SanPhamController {
	@Autowired
	private SanPhamService sanphamService;
	
	@GetMapping
	public ResponseEntity<List<SanPham>> getAllSanPham() {
		List<SanPham> ds = sanphamService.getAllSanPham();
		return new ResponseEntity<>(ds, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SanPham> getSanPhamById(@PathVariable String id) {
		SanPham sp = sanphamService.getSanPhamById(id);
		return new ResponseEntity<>(sp, HttpStatus.OK);
	}
	
	@GetMapping("/searchTenSanPham")
	public ResponseEntity<List<SanPham>> searchByTenSanPham(@RequestParam String tenSanPham) {
		List<SanPham> ds = sanphamService.searchByTenSanPham(tenSanPham);
		if (ds.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<>(ds, HttpStatus.OK);
	}
	
	@GetMapping("/filterByDanhMuc")
	public ResponseEntity<List<SanPham>> filterByDanhMuc(@RequestParam String danhMuc) {
		List<SanPham> ds = sanphamService.filterByDanhMuc(danhMuc);
		if (ds.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ds, HttpStatus.OK);
	}
	
	@GetMapping("/filterByGia")
	public ResponseEntity<List<SanPham>> filterByGia(@RequestParam double minGia, @RequestParam double maxGia) {
		List<SanPham> ds = sanphamService.filterByGia(minGia, maxGia);
		if (ds.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ds, HttpStatus.OK);
	}
	
	@GetMapping("/filterByDiemDanhGia")
	public ResponseEntity<List<SanPham>> filterByDiemDanhGia(@RequestParam double diemDanhGia) {
		List<SanPham> ds = sanphamService.filterByDiemDanhGia(diemDanhGia);
		if (ds.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ds, HttpStatus.OK);
	}
}	 