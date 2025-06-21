package com.example.donhang.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table("ChiTietDonHang")
public class ChiTietDonHang {
	@PrimaryKey
	private ChiTietDonHangKey key;
	
	@Column("soLuong")
	private Integer quantity;
	
	@Column("giaDonVi")
	private Double price;
}