package com.example.giohang.service;

import org.springframework.stereotype.Service;

import com.example.giohang.model.GioHang;
import com.example.giohang.model.SanPham;
import com.example.giohang.repository.GioHangRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GioHangService {
	@Autowired
	private GioHangRepository giohangRepo;
	
	public GioHang getGioHangByUserId(String userId) {
		return giohangRepo.findByUserId(userId)
				.orElseThrow(() -> new RuntimeException(
						"Không tìm thấy giỏ hàng của user: " + userId));
	}
	
	// Thêm sản phẩm vào giỏ hàng
	public GioHang addSanPhamToGioHang(String userId, SanPham sanpham) {
		Optional<GioHang> gioHang = giohangRepo.findByUserId(userId);
		if (gioHang.isPresent()) {
			GioHang gioHangHienTai = gioHang.get();
			List<SanPham> danhSachSanPham = gioHangHienTai.getSanpham();
			
			if (danhSachSanPham == null) {
				danhSachSanPham = new ArrayList<>();
				gioHangHienTai.setSanpham(danhSachSanPham);
			}
			
			boolean found = false;
			
			for (SanPham sp : danhSachSanPham) {
				if (sp.getId().equals(sanpham.getId())) {
					sp.setSoLuong(sp.getSoLuong() + sanpham.getSoLuong());
					found = true;
					break;
				}
			}
			
			if (found == false) {
				danhSachSanPham.add(sanpham);
			}
			
			gioHangHienTai.setNgayCapNhat(LocalDateTime.now());
			return giohangRepo.save(gioHangHienTai);
		}
		else
		{
			throw new RuntimeException("Không tìm thấy giỏ hàng của user : " + userId);
		}
	}
	
	// Xóa sản phẩm khỏi giỏ hàng
	public GioHang removeSanPhamFromGioHang(String userId, String productId) {
		Optional<GioHang> gioHang = giohangRepo.findByUserId(userId);
		if (gioHang.isPresent()) {
            GioHang gioHangHienTai = gioHang.get();
            List<SanPham> danhSachSanPham = gioHangHienTai.getSanpham();

            if (danhSachSanPham == null || danhSachSanPham.isEmpty()) {
                throw new RuntimeException("Giỏ hàng của người dùng " + userId + " không có sản phẩm nào để xóa.");
            }

            boolean kiemTra = false;
            
            List<SanPham> danhSachSanPhamMoi = new ArrayList<>();
            for (SanPham sp : danhSachSanPham) {
            	if (!sp.getId().equals(productId)) {
                    danhSachSanPhamMoi.add(sp);
                } else {
                    kiemTra = true;
                }
            }
            
            if (kiemTra == false) {
            	throw new RuntimeException("Không tìm thấy sản phẩm " + productId + " trong giỏ hàng của người dùng " + userId);
            }
            
            gioHangHienTai.setSanpham(danhSachSanPhamMoi);
            gioHangHienTai.setNgayCapNhat(LocalDateTime.now());
            
            return giohangRepo.save(gioHangHienTai);
        } else {
            throw new RuntimeException("Không tìm thấy giỏ hàng cho người dùng với ID: " + userId);
        }
	}
}