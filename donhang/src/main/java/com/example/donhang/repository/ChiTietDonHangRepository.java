package com.example.donhang.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.donhang.model.ChiTietDonHang;
import com.example.donhang.model.ChiTietDonHangKey;

@Repository
public interface ChiTietDonHangRepository extends CassandraRepository<ChiTietDonHang, ChiTietDonHangKey> {
	
	List<ChiTietDonHang> findByKeyId(UUID Id);
}