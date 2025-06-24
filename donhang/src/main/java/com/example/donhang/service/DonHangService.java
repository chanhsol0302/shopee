package com.example.donhang.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.donhang.dto.DonHangDTO;
import com.example.donhang.dto.SanPhamDTO;
import com.example.donhang.model.ChiTietDonHang;
import com.example.donhang.model.ChiTietDonHangKey;
import com.example.donhang.model.DonHang;
import com.example.donhang.repository.ChiTietDonHangRepository;
import com.example.donhang.repository.DonHangRepository;

@Service
public class DonHangService {
	@Autowired
	private DonHangRepository donhangRepo;
	
	@Autowired
	private ChiTietDonHangRepository chitietdonhangRepo;
	
	public List<DonHang> getByUserId(String userId) {
		List<DonHang> dsDonHang = donhangRepo.findByIdnguoidung(userId);
		return dsDonHang;
	}
	
	public List<ChiTietDonHang> getById(UUID Id) {
		List<ChiTietDonHang> dsChiTietDonHang = chitietdonhangRepo.findByKeyId(Id);
		return dsChiTietDonHang;
	}
	
	public void deleteById(UUID id) {
		List<ChiTietDonHang> chiTietList = chitietdonhangRepo.findByKeyId(id);
        if (!chiTietList.isEmpty()) {
            chitietdonhangRepo.deleteAll(chiTietList);
            System.out.println("Đã xóa " + chiTietList.size() + " chi tiết đơn hàng cho đơn hàng ID: " + id);
        } else {
            System.out.println("Không tìm thấy chi tiết đơn hàng nào cho đơn hàng ID: " + id);
        }
        donhangRepo.deleteById(id);
        System.out.println("Đã xóa đơn hàng với ID: " + id);
	}
	
	public DonHang createDonHang(DonHangDTO donhang) {
		DonHang newDonHang = new DonHang();
		newDonHang.setIddonhang(UUID.randomUUID());
		newDonHang.setUserId(donhang.getUserId());
		newDonHang.setShopId(donhang.getShopId());
		newDonHang.setDate(donhang.getDate());
		newDonHang.setTotalPrice(donhang.getTotalPrice());
		newDonHang.setStatus(donhang.getStatus());
		newDonHang.setAddress(donhang.getAddress());
		newDonHang.setPayment(donhang.getPayment());
		donhangRepo.save(newDonHang);
		
        for (SanPhamDTO sanPhamDTO : donhang.getProductList()) {
            ChiTietDonHangKey chiTietKey = new ChiTietDonHangKey();
            chiTietKey.setId(newDonHang.getIddonhang());
            chiTietKey.setProductId(sanPhamDTO.getProductId());

            ChiTietDonHang chiTiet = new ChiTietDonHang();
            chiTiet.setKey(chiTietKey);
            chiTiet.setQuantity(sanPhamDTO.getQuantity());
            chiTiet.setPrice(sanPhamDTO.getPrice());

            chitietdonhangRepo.save(chiTiet);
        }
        return newDonHang;
	}
}
