package com.example.donhang.model;

import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import lombok.Data;

@Data
@Table("DonHang")
public class DonHang {
	@PrimaryKey
	private UUID id;
	
	@Column("idNguoiDung")
	private String userId;
	
	@Column("idShop")
	private String shopId;
	
	@Column("ngayDat")
	private LocalDateTime date;
	
	@Column("tongGia")
	private double totalPrice;
	
	@Column("trangThai")
	private String status;
	
	@Column("diaChiNhan")
	private String address;
	
	@Column("hinhThucThanhToan")
	private String payment;
}