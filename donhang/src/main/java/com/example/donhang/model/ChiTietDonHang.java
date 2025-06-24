package com.example.donhang.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table("chitietdonhang")
public class ChiTietDonHang {
	@PrimaryKey
	private ChiTietDonHangKey key;
	
	@Column("soluong")
	private Integer quantity;
	
	@Column("giadonvi")
	private Double price;
}