package com.example.giohang.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.giohang.model.GioHang;

@Repository
public interface GioHangRepository extends MongoRepository<GioHang, String> {
	Optional<GioHang> findByUserId(String userId);
}