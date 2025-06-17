package com.example.sanpham.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sanpham.model.SanPham;

@Repository
public interface SanPhamRepository extends MongoRepository<SanPham, String> {
	List<SanPham> findByTenSanPhamContainingIgnoreCase(String tenSanPham);
	
	List<SanPham> findByDanhMuc(String danhMuc);
	
	List<SanPham> findByGiaBetween(double minGia, double maxGia);
	
	List<SanPham> findByDiemDanhGiaGreaterThanEqual(double diemDanhGia);
}