package com.example.giohang.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "GioHang")
public class GioHang {
	@Id
	private String id;
	
	@Field("userID")
	private String userId;
	
	private LocalDateTime ngayCapNhat;
	
	@Field("sanPham")
	private List<SanPham> sanpham = new ArrayList<>();

}