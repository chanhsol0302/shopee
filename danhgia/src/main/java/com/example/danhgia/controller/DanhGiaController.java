package com.example.danhgia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.danhgia.dto.DanhGiaDTO;
import com.example.danhgia.model.DanhGia;
import com.example.danhgia.service.DanhGiaService;

@RestController
@RequestMapping("api/danhgia")
@CrossOrigin(origins = "*")
public class DanhGiaController {
	@Autowired
	private DanhGiaService danhgiaService;
	
	@GetMapping("/{sanphamId}")
	public ResponseEntity<List<DanhGia>> getDanhGiaBySanphamId(@PathVariable String sanphamId) {
		List<DanhGia> dsDanhGia = danhgiaService.getDanhGiaBySanphamId(sanphamId);
		if (dsDanhGia.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dsDanhGia, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<DanhGia> addDanhGia(@RequestBody DanhGiaDTO danhgia) {
		DanhGia newDanhgia = danhgiaService.addDanhGia(danhgia);
		return new ResponseEntity<>(newDanhgia, HttpStatus.OK);
	}
	
	@DeleteMapping
	public void deleteDanhGia(@RequestParam String userId, @RequestParam String sanphamId) {
		danhgiaService.deleteDanhGia(userId, sanphamId);
	}
}