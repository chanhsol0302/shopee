package com.example.sanpham.service;

import org.springframework.stereotype.Service;

import org.springframework.data.redis.core.RedisTemplate;
import com.example.sanpham.model.SanPham;
import com.example.sanpham.repository.SanPhamRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class SanPhamService {
	@Autowired
	private SanPhamRepository sanphamRepo;
	
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String CACHE_KEY_PREFIX = "product:";
    private static final String SEARCH_CACHE_PREFIX = "search:";

	
	@SuppressWarnings("unchecked")
	public List<SanPham> getAllSanPham() {
        String cacheKey = CACHE_KEY_PREFIX + "all";
	    List<SanPham> cachedList = (List<SanPham>) redisTemplate.opsForValue().get(cacheKey);
	    if (cachedList != null) {
	        return cachedList;
	    }
	    List<SanPham> sanPhams = sanphamRepo.findAll();
	    
	    redisTemplate.opsForValue().set(cacheKey, sanPhams, 1, TimeUnit.HOURS);

	    return sanPhams;
	}
	
	public SanPham getSanPhamById(String id) {
		return sanphamRepo.findById(id)
				.orElseThrow(() -> new RuntimeException(
						"No SanPham is found for ID: " + id));
	}
	
	public List<SanPham> searchByTenSanPham(String tenSanPham) {
		 return sanphamRepo.findByTenSanPhamContainingIgnoreCase(tenSanPham);
	}
	

	@SuppressWarnings("unchecked")
	public List<SanPham> filterByDanhMuc(String danhMuc) {
	    String cacheKey = SEARCH_CACHE_PREFIX + danhMuc;

	    List<SanPham> cachedList = (List<SanPham>) redisTemplate.opsForValue().get(cacheKey);
	    if (cachedList != null) {
	        return cachedList;
	    }

	    List<SanPham> sanPhams = sanphamRepo.findByDanhMuc(danhMuc);

	    redisTemplate.opsForValue().set(cacheKey, sanPhams, 1, TimeUnit.HOURS);

	    return sanPhams;
	}

	
	public List<SanPham> filterByGia(double minGia, double maxGia) {
		return sanphamRepo.findByGiaBetween(minGia, maxGia);
	}
	
	public List<SanPham> filterByDiemDanhGia(double diemDanhGia) {
		return sanphamRepo.findByDiemDanhGiaGreaterThanEqual(diemDanhGia);
	}
}