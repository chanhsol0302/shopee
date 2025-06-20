package com.example.danhgia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.danhgia.model.DanhGia;

@Repository
public interface DanhGiaRepository extends MongoRepository<DanhGia, String> {
	List<DanhGia> findBySanphamId(String sanphamId);

	Optional<DanhGia> findByUserIdAndSanphamId(String userId, String sanphamId);
	void deleteByUserIdAndSanphamId(String userId, String sanphamId);
}