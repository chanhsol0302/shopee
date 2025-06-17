# API
## sanpham (http://localhost:8081)

- **Lấy toàn bộ sản phẩm**  
  `http://localhost:8081/api/sanpham`

- **Lấy sản phẩm theo id**  
  `http://localhost:8081/api/sanpham/sp_123`

- **Search tên sản phẩm**  
  `http://localhost:8081/api/sanpham/searchByTenSanPham?tenSanPham=Sách`

- **Filter theo danh mục**  
  `http://localhost:8081/api/sanpham/filterByDanhMuc?danhMuc=Sách`

- **Filter theo giá**  
  `http://localhost:8081/api/sanpham/filterByGia?minGia=10000&maxGia=100000`

- **Filter theo điểm đánh giá**  
  `http://localhost:8081/api/sanpham/filterByDiemDanhGia?diemDanhGia=4`
