package com.example.danhgia.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.danhgia.dto.DanhGiaDTO;
import com.example.danhgia.model.DanhGia;
import com.example.danhgia.repository.DanhGiaRepository;

@Service
public class DanhGiaService {
	@Autowired
	private DanhGiaRepository danhgiaRepo;
	
	public List<DanhGia> getDanhGiaBySanphamId(String sanphamId) {
		return danhgiaRepo.findBySanphamId(sanphamId);
	}
	
	public DanhGia addDanhGia(DanhGiaDTO danhgia) {
		DanhGia newDanhGia = new DanhGia();
		newDanhGia.setUserId(danhgia.getUserId());
		newDanhGia.setSanphamId(danhgia.getSanphamId());
		newDanhGia.setDiem(danhgia.getDiem());
		newDanhGia.setBinhLuan(danhgia.getBinhLuan());
		newDanhGia.setThoiGian(LocalDateTime.now());
		danhgiaRepo.save(newDanhGia);
		return newDanhGia;
	}
	
	public void deleteDanhGia(String userId, String sanphamId) {
		Optional<DanhGia> danhGia = danhgiaRepo.findByUserIdAndSanphamId(userId, sanphamId);
		if (danhGia.isPresent()) {
			danhgiaRepo.deleteByUserIdAndSanphamId(userId, sanphamId);
		}
		else
		{
			throw new RuntimeException("Không tìm được đánh giá của người dùng " + userId + " về sản phẩm " + sanphamId);
		}
	}
}