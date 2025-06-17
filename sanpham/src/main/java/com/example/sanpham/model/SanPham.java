package com.example.sanpham.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "SanPham")
public class SanPham {
	@Id
	private String id;
	
	private String tenSanPham;
    private String moTa;
    private double gia;
    private int soLuong;
    private List<String> hinhAnh;
    private String danhMuc;
    private String shopID;
    private double diemDanhGia;
    private Map<String, Object> thuocTinh;
}