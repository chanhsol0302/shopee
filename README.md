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
## giohang (http://localhost:8082)

- **Lấy giỏ hàng theo id người dùng**  
  `http://localhost:8082/api/giohang/userId/user_001`

- **Thêm sản phẩm vào giỏ hàng**  
  `http://localhost:8082/api/giohang/addSanPham/user_001`  

  JSON:
  ```json
  {
    "idSanPham": "sp_1201",
    "soLuong": 1,
    "giaLucThem": 12000
  }

- **Xóa sản phẩm khỏi giỏ hàng**  
  `http://localhost:8082/api/giohang/removeSanPham?userId=user_001&productId=sp_1201`  

## danhgia (http://localhost:8083)  

- **Lấy đánh giá theo id sản phẩm**  
  `http://localhost:8083/api/danhgia/{sanphamId}`  

- **Thêm đánh giá cho sản phẩm**  
  `http://localhost:8083/api/danhgia`  

  JSON:  
  ```json  
  {
    "userId": " ",
    "sanphamId": " ",
    "diem": 4.3,
    "binhLuan": " "
  }  

- **Xóa đánh giá**  
  `http://localhost:8083/api/danhgia?userId=&sanphamId=`  
  


