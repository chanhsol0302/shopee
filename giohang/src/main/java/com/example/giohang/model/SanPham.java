package com.example.giohang.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class SanPham {
	@Field("idSanPham")
	private String id;

	private Integer soLuong;
	private double giaLucThem;
}