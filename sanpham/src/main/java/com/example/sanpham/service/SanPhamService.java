package com.example.sanpham.service;

import org.springframework.stereotype.Service;

import com.example.sanpham.model.SanPham;
import com.example.sanpham.repository.SanPhamRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class SanPhamService {
	@Autowired
	private SanPhamRepository sanphamRepo;
	
	public List<SanPham> getAllSanPham() {
		return sanphamRepo.findAll();
	}
	
	public SanPham getSanPhamById(String id) {
		return sanphamRepo.findById(id)
				.orElseThrow(() -> new RuntimeException(
						"No SanPham is found for ID: " + id));
	}
	
	public List<SanPham> searchByTenSanPham(String tenSanPham) {
		 return sanphamRepo.findByTenSanPhamContainingIgnoreCase(tenSanPham);
	}
	
	public List<SanPham> filterByDanhMuc(String danhMuc) {
		return sanphamRepo.findByDanhMuc(danhMuc);
	}
	
	public List<SanPham> filterByGia(double minGia, double maxGia) {
		return sanphamRepo.findByGiaBetween(minGia, maxGia);
	}
	
	public List<SanPham> filterByDiemDanhGia(double diemDanhGia) {
		return sanphamRepo.findByDiemDanhGiaGreaterThanEqual(diemDanhGia);
	}
}