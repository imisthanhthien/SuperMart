-------------------------------------------------------------------------------------
----------------------------------STORED PROCEDURE-----------------------------------
-------------------------------------------------------------------------------------

--DANH SÁCH NHÂN VIÊN
create proc DS_NhanVien
as
begin
		select MaNV, TenNV, Gioitinh, Email, Vaitro, Tinhtrang  from  NhanVien
end

go

--DANH SÁCH HÀNG HÓA
create proc DS_HangHoa
as

begin
	
	select   MaHH,TenHH, Tenloai, Mota,Soluong, Giaban from HangHoa,LoaiHangHoa
	where HangHoa.Maloai = LoaiHangHoa.Maloai
end

go

--THÊM HÀNG HÓA
create proc ThemHH
@tenhh nvarchar(50),
@maloai int,
@mota nvarchar(100),
@sl int,
@giaban float
as
begin
		insert into HangHoa(TenHH,Maloai,Mota,Soluong,Giaban) values(@tenhh,@maloai,@mota,@sl,@giaban)
end

go 

--SỬA HÀNG HÓA
create proc SuaHH
@mahh int,
@ten nvarchar(50),
@loai int,
@mota nvarchar(100),
@sl int,
@giaban float
as
begin
	update HangHoa set tenHH = @ten, Maloai = @loai, Mota = @mota, Soluong = @sl, Giaban = @giaban where MaHH = @mahh
end

go

--XÓA HÀNG HÓA
create proc XoaHH
@mahh int
as
	begin
		Delete from HangHoa where MaHH = @mahh
	end

go

---DANH SÁCH LOẠI SẢN PHẨM
create proc DS_LoaiSP
as
begin
	select *from LoaiHangHoa
end

go

--XÓA LOẠI HÀNG HÓA
create proc XoaLoaiHH
@maloai int
as
begin
		Delete from LoaiHangHoa where Maloai = @maloai
end

go
--THÊM LOẠI HÀNG HÓA
create proc ThemLoaiHH
@tenloai varchar(50)
as
begin 
	insert into LoaiHangHoa values(@tenloai)
end

go

--SỬA LOẠI HÀNG HÓA
create proc SuaLoaiHH
@maloai int,
@tenloai varchar(50)
as
begin
	update LoaiHangHoa set Tenloai = @tenloai where Maloai = @maloai
end

go

--THÔNG TIN NHÂN VIÊN
create proc thongtinnv
as
begin
	select Email,Matkhau  from NhanVien
end

go

--THÊM NHÂN VIÊN
create proc ThemNV
@tennv nvarchar(50),
@gioitinh nvarchar(3),
@email varchar(50),
@mk varchar(100)
as

begin
		insert into NhanVien(TenNV,Gioitinh,Email,Matkhau) values (@tennv,@gioitinh,@email,@mk)
end

go

--LOGIN
create proc login
@email VARCHAR(50), @password VARCHAR(100)
as

begin
	DECLARE @status BIT
	IF EXISTS(SELECT * FROM NHANVIEN WHERE Email = @email AND Matkhau= @password)
	SET @status = 1
ELSE
	SET @status = 0
SELECT @status
end

go
--THAY ĐỔI MẬT KHẨU
CREATE PROC thaydoimk
@email VARCHAR(50), @oldPassword VARCHAR(100), @newPassword VARCHAR(100)
AS BEGIN
DECLARE @password VARCHAR(100), @result bit
SELECT @password = Matkhau FROM NHANVIEN WHERE Email = @email
IF @password = @oldPassword
BEGIN
    UPDATE NHANVIEN SET Matkhau = @newPassword WHERE Email = @email
	SET @result = 1
END
ELSE SET @result = 0
SELECT @result
END

go
--GET THÔNG TIN NHÂN VIÊN
create proc thongtinnvedit
@email varchar(50)
as
begin
	select TenNV,Diachi,Email  from NhanVien where Email = @email
end

go

---CHỈNH SỬA THÔNG TIN CÁ NHÂN NHÂN VIÊN
create proc editprofile
@email  varchar(50),
@tennv nvarchar(50),
@diachi nvarchar(50)
as
begin
	Update NhanVien set TenNV = @tennv, Diachi = @diachi where Email =@email
end

go
--SỬA NHÂN VIÊN
create proc SuaNV
@manv int,
@tenNV nvarchar(50),
@gioitinh nvarchar(3),
@email nvarchar(50),
@vaitro bit
as
begin
	update NhanVien set TenNV = @tenNV, Gioitinh = @gioitinh, Email = @email, Vaitro = @vaitro where MaNV = @manv
end

go

---XÓA NHÂN VIÊN
create proc XoaNV
@manv int
as
begin
	delete from NhanVien where MaNV = @manv
end

go

--DANH SÁCH NHÀ CUNG CẤP
create proc DS_NCC
as
begin
		select *from NhaCungCap
end

go

--DANH SÁCH NHẬP HÀNG
create proc DS_Nhap
as
begin
		select MaPN,Ngaynhap,Lydonhap, NhanVien.TenNV, NhaCungCap.TenNCC,PhieuNhap.Thanhtien from PhieuNhap,NhanVien,NhaCungCap 
		where NhanVien.MaNV = PhieuNhap.MaNV and NhaCungCap.MaNCC = PhieuNhap.MaNCC
end

go

--DANH SÁCH XUẤT HÀNG
create proc DS_Xuat
as
begin
		select  MaPX,Ngayban,Lydoxuat,NhanVien.TenNV,KhachHang.TenKH,PhieuXuat.Thanhtien   from PhieuXuat ,NhanVien,KhachHang
		where NhanVien.MaNV = PhieuXuat.MaNV and KhachHang.MaKH = PhieuXuat.MaKH
end

go

--THÊM NHÀ CUNG CẤP
create proc ThemNCC 
@tenncc varchar(50),
@diachi varchar(50),
@email varchar(50),
@sdt varchar(10)
as
begin
	insert into NhaCungCap values(@tenncc,@diachi,@email,@sdt)
end

go
--THÊM PHIẾU NHẬP HÀNG
create proc ThemPN 
@lydo varchar(50),
@manv int,
@mancc int
as
begin
	insert into PhieuNhap(Lydonhap,MaNV,MaNCC) values(@lydo,@manv,@mancc)
end

go

--THÊM PHIẾU XUẤT HÀNG
create proc ThemPX 

@lydoban varchar(50),
@manv int,
@makh int
as
begin
	insert into PhieuXuat(Lydoxuat,MaNV,MaKH) values(@lydoban,@manv,@makh)
end

go
--KIỂM TRA QUYỀN NHÂN VIÊN
create proc QuyenNV
@email varchar(50)
as
begin
	select  MaNV from NhanVien where Email = @email
end
go

--DANH SÁCH KHÁCH HÀNG
create proc loadTableKH
as
begin
	select * from KhachHang
end
go

--XÓA KHÁCH HÀNG
create proc XoaKH
@makh int
as
begin
	delete from KhachHang where MaKH = @makh
end
go

-- THÊM KHÁCH HÀNG
create proc ThemKH
@ten nvarchar(50),
@diachi nvarchar(50),
@sdt varchar(10)
as
begin
	insert into KhachHang values (@ten,@diachi, @sdt)
end
go

--SỬA KHÁCH HÀNG
create proc SuaKH
@ma int,
@ten nvarchar(50),
@diachi nvarchar(50),
@sdt varchar(10)
as
begin
	update KhachHang set TenKH = @ten, Diachi = @diachi, Sdt = @sdt
	where MaKH = @ma
end
go


--DANH SÁCH CHI TIẾT HÓA ĐƠN
CREATE PROC DS_CTHoaDon
AS BEGIN
SELECT b.MaHH ,p.TenHH, b.Soluong, b.Giaban , b.Thanhtien  FROM CTHoaDon b, HangHoa p
WHERE b.MaHH = p.MaHH
END
go


go

--DANH SÁCH HÓA ĐƠN
create proc LoadHoaDon
as
begin
	select  MaHD as N'Mã hóa đơn', nv.TenNV as N'Tên nhân viên', kh.TenKH as N'Tên khách hàng',Ngaylap as N'Ngày lập',Tongtien as N'Tổng tiền'  from HoaDon hd, KhachHang kh, NhanVien nv
	where nv.MaNV = hd.MaNV and kh.MaKH = hd.MaKH
end

go

---DOANH THU BÁN
create proc LoadTableDanhThu
as
begin
	select  HD.MaHD , CONVERT(date,HD.Ngaylap), HD.Tongtien from  HoaDon HD
end
go


---THÊM CHI TIẾT HÓA ĐƠN
create proc ThemCTHoaDon
@mahh int,
@sl int,
@giaban float,
@thanhtien float
as begin
	DECLARE @price FLOAT = @sl * @giaban
	UPDATE HangHoa
SET Soluong =Soluong - @sl
WHERE MaHH = @mahh
INSERT INTO CTHoaDon(MaHH, Soluong, Giaban, Thanhtien) VALUES
(@mahh, @sl,@giaban, @price)
END
go

--XÓA CHI TIẾT HÓA ĐƠN
create proc XoaCTHD
@ma int
as
begin
	declare @slhang int
	declare @slhangcthd int
	set @slhang = (select Soluong from HangHoa where MaHH = @ma)
	set @slhangcthd = (select SoLuong from CTHoaDon where MaHH = @ma)
	update HangHoa set Soluong = @slhang + @slhangcthd where MaHH = @ma
	delete from CTHoaDon where MaHH = @ma

end
go

--CẬP NHẬP CHI TIẾT HÓA ĐƠN
create proc CapNhapCTHD
@ma int,
@soluong int,
@giaban float
as
begin
	declare @slhang int
	declare @slbefore int
	declare @slafter int
	
	set @slhang = (select Soluong from HangHoa where MaHH = @ma)
	set @slbefore = (select SoLuong from CTHoaDon where MaHH = @ma)
	update CTHoaDon  set Soluong = @soluong, Giaban = @giaban, Thanhtien = @soluong*@giaban where MaHH = @ma
	set @slafter = (select SoLuong from CTHoaDon where MaHH = @ma)
	if(@slbefore < @slafter)
	begin
		update HangHoa set Soluong = @slHang - (@slafter - @slbefore) where MaHH = @ma
	end
	else
	begin
		update HangHoa set Soluong = @slHang + (@slbefore - @slafter) where MaHH = @ma
	end
end
go
go
--THÊM VÀO HÓA ĐƠN THANH TOÁN

create proc ThemHoaDon
@manv int ,
@makh int,
@tongtien float
as
begin
		insert into HoaDon(MaNV,MaKH,Tongtien) values (@manv,@makh,@tongtien)
end

go
--XÓA HÓA ĐƠN ĐÃ THANH TOÁN KHỎI CT HÓA ĐƠN

create proc XoaHoaDonThanhToan
as
begin
		delete from CTHoaDon
end

go

---DANH SÁCH PHIẾU NHẬP
create proc LoadCTPhieuNHap
as
begin
	select    HangHoa.MaHH,HangHoa.TenHH,  CTPhieuNhap.SLNhap,CTPhieuNhap.GiaNhap,CTPhieuNhap.Thanhtien 

	from CTPhieuNhap,HangHoa

	where HangHoa.MaHH = CTPhieuNhap.MaHH

end
go

---DANH SÁCH PHIẾU XUẤT
create proc LoadCTPhieuXuat
as
begin
	select    HangHoa.MaHH,HangHoa.TenHH,  CTPhieuXuat.SLXuat,CTPhieuXuat.Giaxuat,CTPhieuXuat.Thanhtien   from CTPhieuXuat,HangHoa
	where HangHoa.MaHH = CTPhieuXuat.MaHH
end

go

--THÊM PHIẾU NHẬP
create proc ThemPhieuNhap
@mahh int,
@sl int,
@gianhap float,
@thanhtien float
as begin
	DECLARE @price FLOAT = @sl * @gianhap
	set @thanhtien = @price
	UPDATE HangHoa
SET Soluong =Soluong + @sl
WHERE MaHH = @mahh
INSERT INTO CTPhieuNhap(MaHH, SLNhap, GiaNhap,Thanhtien) VALUES
(@mahh, @sl, @gianhap,@thanhtien)
END

go

--SỬA PHIẾU NHẬP
create proc SuaPhieuNhap
@mahh int,
@sl int,
@gianhap float,
@thanhtien float
as begin
	DECLARE @price FLOAT = @sl * @gianhap
	DECLARE @sl2 int
	set @sl2 = (select SLNhap from CTPhieuNhap where MaHH =@mahh)

	update CTPhieuNhap set SLNhap = @sl, GiaNhap = @gianhap, Thanhtien = @price
	where MaHH = @mahh

	if(@sl > @sl2)
		begin
			update HangHoa set Soluong = Soluong + (@sl - @sl2)
			where MaHH = @mahh
		end
	else
		begin
			update HangHoa set Soluong = Soluong - (@sl2 - @sl)
			where MaHH = @mahh
		end
END

go

--XÓA PHIẾU NHẬP
create proc XoaPhieuNhap
@mahh int
as
begin
	DECLARE @sl int, @sl2 int
	set @sl = (select Soluong from HangHoa where MaHH = @mahh)
	set @sl2 = (select  SLNhap from CTPhieuNhap where MaHH = @mahh)
	Declare @slhienhanh int
	set @slhienhanh = @sl2
	Delete from CTPhieuNhap where MaHH = @mahh
	
	if not exists(select  SLNhap from CTPhieuNhap where MaHH = @mahh)
		begin
			update HangHoa set Soluong = @sl - @slhienhanh where MaHH = @mahh
		end
end

go

--THÊM PHIẾU XUẤT
create proc ThemPhieuXuat
@mahh int,
@sl int,
@giaxuat float,
@thanhtien float
as begin
	DECLARE @price FLOAT = @sl * @giaxuat
	set @thanhtien = @price
	UPDATE HangHoa
SET Soluong =Soluong - @sl
WHERE MaHH = @mahh
INSERT INTO CTPhieuXuat(MaHH, SLXuat, Giaxuat,Thanhtien) VALUES
(@mahh, @sl, @giaxuat,@thanhtien)
END

go
---THANH TOÁN PHIẾU NHẬP
create proc Addphieunhap
@lydo nvarchar(100),
@manv int,
@mancc int,
@thanhtien float
as
begin 
	insert into PhieuNhap(Lydonhap,MaNV,MaNCC,ThanhTien) values(@lydo,@manv,@mancc,@thanhtien)
end

go

---XÓA PHIẾU NHẬT ĐÃ THANH TOÁN
create proc XoaPhieuNhapTT
as
begin
	Delete from CTPhieuNhap
end

go

--THÊM PHIẾU XUẤT
create proc ThemPhieuXuatCT
@mahh int,
@sl int,
@giaxuat float,
@thanhtien float
as begin
	DECLARE @price FLOAT = @sl * @giaxuat
	set @thanhtien = @price
	UPDATE HangHoa
SET Soluong =Soluong - @sl
WHERE MaHH = @mahh
INSERT INTO CTPhieuXuat(MaHH, SLXuat, Giaxuat,Thanhtien) VALUES
(@mahh, @sl, @giaxuat,@thanhtien)
END


go

--SỬA PHIẾU XUẤT
create proc SuaPhieuXuatCT
@mahh int,
@sl int,
@giaxuat float,
@thanhtien float
as begin
	DECLARE @price FLOAT = @sl * @giaxuat 
	DECLARE @sl2 int
	set @sl2 = (select SLXuat from CTPhieuXuat where MaHH =@mahh)

	update CTPhieuXuat set SLXuat = @sl, Giaxuat = @giaxuat , Thanhtien = @price
	where MaHH = @mahh

	if(@sl > @sl2)
		begin
			update HangHoa set Soluong = Soluong - (@sl - @sl2)
			where MaHH = @mahh
		end
	else
		begin
			update HangHoa set Soluong = Soluong + (@sl2 - @sl)
			where MaHH = @mahh
		end
END



go
--XÓA PHIẾU XUẤT
create proc XoaPhieuXuatCT
@mahh int
as
begin
	DECLARE @sl int, @sl2 int
	set @sl = (select Soluong from HangHoa where MaHH = @mahh)
	set @sl2 = (select  SLXuat from CTPhieuXuat where MaHH = @mahh)
	Declare @slhienhanh int
	set @slhienhanh = @sl2
	Delete from CTPhieuXuat where MaHH = @mahh
	
	if not exists(select  SLXuat from CTPhieuXuat where MaHH = @mahh)
		begin
			update HangHoa set Soluong = @sl + @slhienhanh where MaHH = @mahh
		end
end

go
---THANH TOÁN PHIẾU XUẤT
create proc Addphieuxuat
@lydo nvarchar(100),
@manv int,
@mankh int,
@thanhtien float
as
begin 
	insert into PhieuXuat(Lydoxuat,MaNV,MaKH,ThanhTien) values(@lydo,@manv,@mankh,@thanhtien)
end

go

--XÓA PHIẾU XUẤT ĐÃ THANH TOÁN
create proc XoaPhieuXuatTT

as
begin
	Delete from CTPhieuXuat
end

go


---DANH THU BẢNG XUẤT
create proc LoadTableDanhThuXuat
as
begin
	select  PX.MaPX , CONVERT(date,PX.Ngayban) as Ngayban, PX.ThanhTien from  PhieuXuat PX
	where PX.Trangthai = 1
end

go


---DOANH THU BẢNG NHẬP
create proc LoadTableDanhThuNhap
as
begin
	select  PN.MaPN , CONVERT(date,PN.Ngaynhap), PN.ThanhTien from  PhieuNhap PN
	where PN.Trangthai = 1
end
go

--TÌM KIẾM HÓA ĐƠN THEO NGÀY
create proc TimKiemHoaDonTheoNgay
@ngaylap date
as
begin
	select *from HoaDon where Ngaylap like @ngaylap
end

go


--TÌM KIẾM HÓA ĐƠN PHIẾU NHẬP THEO NGÀY
create proc TimKiemHoaDonNhapTheoNgay
@ngaylap date
as
begin
	select *from PhieuNhap where Ngaynhap like @ngaylap
end
go

--TÌM KIẾM HÓA ĐƠN PHIẾU XUẤT THEO NGÀY
create proc TimKiemHoaDonXuatTheoNgay
@ngaylap date
as
begin
	select *from PhieuXuat where Ngayban like @ngaylap
end

go

--XÓA NHÀ CUNG CẤP
create proc XoaNCC
@ma int
as
begin
	delete from NhaCungCap where MaNCC = @ma
end
go


--SỬA NHÀ CUNG CẤP
create proc UpdateNCC
@ma int,
@ten nvarchar(50),
@diachi nvarchar(50),
@sdt varchar(50),
@email varchar(50)
as
begin
	update NhaCungCap
	set TenNCC = @ten,
		Diachi = @diachi,
		Sdt = @sdt,
		Email = @email
	where MaNCC = @ma
end
go

Select 
		 CTHoaDon.MaHD as CTHD_maCTHoaDOn


from 
 HoaDon INNER JOIN  CTHoaDon ON HoaDon.MaHD = CTHoaDon.MaHD
     INNER JOIN KhachHang ON HoaDon.MaKH = KhachHang.MaKH
     INNER JOIN NhanVien ON HoaDon.MaNV = NhanVien.MaNV
     INNER JOIN HangHoa ON CTHoaDon.MaHH = HangHoa.MaHH

 WHERE
     HoaDon.MaHD = CTHoaDon.MaHD 