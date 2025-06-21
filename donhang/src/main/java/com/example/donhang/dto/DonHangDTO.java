package com.example.donhang.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class DonHangDTO {
	private String userId;
	private String shopId;
	private LocalDateTime date;
	private double totalPrice;
	private String status;
	private String address;
	private String payment;
	private List<SanPhamDTO> productList;
}