package com.example.danhgia.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "DanhGia")
public class DanhGia {
	@Id
	private String id;
	
	@Field(name = "userID")
	private String userId;
	
	@Field(name = "sanphamID")
	private String sanphamId;
	
	private float diem;
	private String binhLuan;
	private List<String> hinhAnh;
	private List<String> video;
	private LocalDateTime thoiGian;
}