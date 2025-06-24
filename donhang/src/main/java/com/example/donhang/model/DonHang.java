package com.example.donhang.model;

import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import lombok.Data;

@Data
@Table("donhang")
public class DonHang {
	@PrimaryKey
	private UUID iddonhang;
	
	@Column("idnguoidung")
	private String userId;
	
	@Column("idshop")
	private String shopId;
	
	@Column("ngaydat")
	private LocalDateTime date;
	
	@Column("tonggia")
	private double totalPrice;
	
	@Column("trangthai")
	private String status;
	
	@Column("diachinhan")
	private String address;
	
	@Column("hinhthucthanhtoan")
	private String payment;
}