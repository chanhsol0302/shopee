package com.example.donhang.controller;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.donhang.dto.DonHangDTO;
import com.example.donhang.model.ChiTietDonHang;
import com.example.donhang.model.DonHang;
import com.example.donhang.service.DonHangService;

@RestController
@RequestMapping("api/donhang")
public class DonHangController {
	@Autowired 
	private DonHangService donhangService;
	
	@GetMapping("/userId/{userId}")
	public ResponseEntity<List<DonHang>> getDonHangByUserId(@PathVariable String userId) {
		List<DonHang> dsDonHang = donhangService.getByUserId(userId);
		if (Objects.isNull(dsDonHang) || dsDonHang.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dsDonHang, HttpStatus.OK);
	}
	
	@GetMapping("/chitietdonhang/{id}")
	public ResponseEntity<List<ChiTietDonHang>> getChiTietDonHangById(@PathVariable UUID id) {
		List<ChiTietDonHang> dsChiTietDonHang = donhangService.getById(id);
		if (Objects.isNull(dsChiTietDonHang) || dsChiTietDonHang.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dsChiTietDonHang, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDonHangById(@PathVariable UUID id) {
		donhangService.deleteById(id);
	}
	
	@PostMapping
	public ResponseEntity<DonHang> createDonHang(DonHangDTO donhang) {
		DonHang newDonHang = donhangService.createDonHang(donhang);
		return new ResponseEntity<>(newDonHang, HttpStatus.OK);
	}
}
