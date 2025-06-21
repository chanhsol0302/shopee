package com.example.donhang.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.donhang.model.DonHang;

@Repository
public interface DonHangRepository extends CassandraRepository<DonHang, UUID> {

	List<DonHang> findByUserId(String userId);
	
}