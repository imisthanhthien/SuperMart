USE [QL_BanHang]
GO
/****** Object:  Table [dbo].[CTHoaDon]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTHoaDon](
	[MaHH] [int] NOT NULL,
	[MaHD] [int] NULL,
	[Soluong] [int] NULL,
	[Giaban] [float] NULL,
	[Thanhtien] [float] NULL,
 CONSTRAINT [PK_CTHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTPhieuNhap]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTPhieuNhap](
	[SoPN] [int] NULL,
	[MaHH] [int] NOT NULL,
	[SLNhap] [int] NULL,
	[GiaNhap] [float] NULL,
	[Thanhtien] [float] NULL,
 CONSTRAINT [PK_CTPhieuNhap] PRIMARY KEY CLUSTERED 
(
	[MaHH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTPhieuXuat]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTPhieuXuat](
	[SoPX] [int] NULL,
	[MaHH] [int] NOT NULL,
	[SLXuat] [int] NULL,
	[Giaxuat] [float] NULL,
	[Thanhtien] [float] NULL,
 CONSTRAINT [PK_CTPhieuXuat] PRIMARY KEY CLUSTERED 
(
	[MaHH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HangHoa]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangHoa](
	[MaHH] [int] IDENTITY(1,1) NOT NULL,
	[TenHH] [nvarchar](50) NOT NULL,
	[Maloai] [int] NOT NULL,
	[Mota] [nvarchar](100) NULL,
	[Giaban] [float] NULL,
	[Soluong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [int] IDENTITY(600,1) NOT NULL,
	[MaNV] [int] NOT NULL,
	[MaKH] [int] NOT NULL,
	[Ngaylap] [date] NULL,
	[Tongtien] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [int] IDENTITY(300,1) NOT NULL,
	[TenKH] [nvarchar](50) NOT NULL,
	[Diachi] [nvarchar](50) NULL,
	[Sdt] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiHangHoa]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiHangHoa](
	[Maloai] [int] IDENTITY(1000,1) NOT NULL,
	[Tenloai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Maloai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [int] IDENTITY(2000,1) NOT NULL,
	[TenNCC] [nvarchar](50) NOT NULL,
	[Diachi] [nvarchar](50) NULL,
	[Email] [varchar](50) NULL,
	[Sdt] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [int] IDENTITY(100,1) NOT NULL,
	[TenNV] [nvarchar](50) NOT NULL,
	[Diachi] [nvarchar](50) NULL,
	[Gioitinh] [nvarchar](3) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Vaitro] [bit] NULL,
	[Tinhtrang] [bit] NULL,
	[Matkhau] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[MaPN] [int] IDENTITY(200,1) NOT NULL,
	[Ngaynhap] [date] NULL,
	[Lydonhap] [nvarchar](100) NULL,
	[MaNV] [int] NOT NULL,
	[MaNCC] [int] NOT NULL,
	[ThanhTien] [float] NULL,
	[Trangthai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuXuat]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuXuat](
	[MaPX] [int] IDENTITY(500,1) NOT NULL,
	[Ngayban] [date] NULL,
	[Lydoxuat] [nvarchar](100) NULL,
	[MaNV] [int] NOT NULL,
	[MaKH] [int] NOT NULL,
	[ThanhTien] [float] NULL,
	[Trangthai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CTHoaDon] ([MaHH], [MaHD], [Soluong], [Giaban], [Thanhtien]) VALUES (12, NULL, 1, 6800000, 8280000)
GO
SET IDENTITY_INSERT [dbo].[HangHoa] ON 

INSERT [dbo].[HangHoa] ([MaHH], [TenHH], [Maloai], [Mota], [Giaban], [Soluong]) VALUES (2, N'Trà xanh không độ', 1004, N'Hạ nhiệt giải độc', 12000, 36)
INSERT [dbo].[HangHoa] ([MaHH], [TenHH], [Maloai], [Mota], [Giaban], [Soluong]) VALUES (4, N'Nồi cơm điện', 1009, N'Bửa ăn mỗi ngày', 125000, 206)
INSERT [dbo].[HangHoa] ([MaHH], [TenHH], [Maloai], [Mota], [Giaban], [Soluong]) VALUES (5, N'Áo yasuo', 1015, N'Mặt vào cân 5', 85000, 10)
INSERT [dbo].[HangHoa] ([MaHH], [TenHH], [Maloai], [Mota], [Giaban], [Soluong]) VALUES (6, N'Bia tiger', 1010, N'Zoooooooo', 11000, 500)
INSERT [dbo].[HangHoa] ([MaHH], [TenHH], [Maloai], [Mota], [Giaban], [Soluong]) VALUES (7, N'Nước hoa', 1005, N'Thơm nhứt nách', 286000, 46)
INSERT [dbo].[HangHoa] ([MaHH], [TenHH], [Maloai], [Mota], [Giaban], [Soluong]) VALUES (8, N'Xe điều khiển từ xa', 1013, N'Xe đồ chơi cho bé', 62000, 91)
INSERT [dbo].[HangHoa] ([MaHH], [TenHH], [Maloai], [Mota], [Giaban], [Soluong]) VALUES (9, N'Diana', 1001, N'Làm con gái thật tuyệt', 125000, 480)
INSERT [dbo].[HangHoa] ([MaHH], [TenHH], [Maloai], [Mota], [Giaban], [Soluong]) VALUES (10, N'Sữa ông thọ', 1012, N'Người đàn ông duy nhất có sữa', 15000, 256)
INSERT [dbo].[HangHoa] ([MaHH], [TenHH], [Maloai], [Mota], [Giaban], [Soluong]) VALUES (11, N'Quýt', 1002, N'Bổ sung vitamim C', 10000, 65)
INSERT [dbo].[HangHoa] ([MaHH], [TenHH], [Maloai], [Mota], [Giaban], [Soluong]) VALUES (12, N'Dầu ăn Neptune', 1011, N'Dầu ăn thượng hạng', 68000, 184)
INSERT [dbo].[HangHoa] ([MaHH], [TenHH], [Maloai], [Mota], [Giaban], [Soluong]) VALUES (13, N'Dầu gọi đầu X-MEN', 1003, N'Adu men', 65000, 150)
INSERT [dbo].[HangHoa] ([MaHH], [TenHH], [Maloai], [Mota], [Giaban], [Soluong]) VALUES (14, N'PS4', 1014, N'Đưa bạn lên mây', 8500000, 21)
SET IDENTITY_INSERT [dbo].[HangHoa] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [Ngaylap], [Tongtien]) VALUES (5001, 4003, 3001, CAST(N'2023-04-11' AS Date), 85000)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [Ngaylap], [Tongtien]) VALUES (5002, 4002, 3005, CAST(N'2023-04-12' AS Date), 8500000)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [Ngaylap], [Tongtien]) VALUES (5003, 4001, 3004, CAST(N'2023-04-13' AS Date), 572000)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [Ngaylap], [Tongtien]) VALUES (5004, 4002, 3006, CAST(N'2023-04-14' AS Date), 125000)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [Ngaylap], [Tongtien]) VALUES (5005, 4002, 3003, CAST(N'2023-04-15' AS Date), 275000)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [Ngaylap], [Tongtien]) VALUES (5006, 4001, 3006, CAST(N'2023-04-18' AS Date), 1500000)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [Ngaylap], [Tongtien]) VALUES (5007, 4001, 3005, CAST(N'2023-05-07' AS Date), 90000)
INSERT [dbo].[HoaDon] ([MaHD], [MaNV], [MaKH], [Ngaylap], [Tongtien]) VALUES (5008, 4001, 3001, CAST(N'2023-05-07' AS Date), 891000)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [Diachi], [Sdt]) VALUES (3001, N'Phạm Khánh Duy', N'Tây Ninh', N'0798658456')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [Diachi], [Sdt]) VALUES (3003, N'Nguyễn Văn Cảnh', N'Phú Thọ', N'0968785486')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [Diachi], [Sdt]) VALUES (3004, N'Phan Thị Bảo Trân', N'Nha Trang', N'0645789548')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [Diachi], [Sdt]) VALUES (3005, N'Lưu Văn Hoàng', N'Bắc Giang', N'0858782185')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [Diachi], [Sdt]) VALUES (3006, N'Nguyễn Thị Thúy Vy', N'TP.HCM', N'0458783145')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[LoaiHangHoa] ON 

INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1013, N'Đồ chơi')
INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1004, N'Đồ uống')
INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1014, N'Game')
INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1009, N'Gia dụng')
INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1001, N'Giấy - khăn ướt - băng vệ sinh')
INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1011, N'Hàng tiêu dùng thiết yếu')
INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1003, N'Hóa phẩm và chất tẩy rửa')
INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1010, N'Mặt hàng bia, rượu')
INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1006, N'Mẹ và bé')
INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1005, N'Mỹ phẩm')
INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1002, N'Rau củ, hoa quả')
INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1012, N'Sữa tươi, chua, kem')
INSERT [dbo].[LoaiHangHoa] ([Maloai], [Tenloai]) VALUES (1015, N'Thời Trang')
SET IDENTITY_INSERT [dbo].[LoaiHangHoa] OFF
GO
SET IDENTITY_INSERT [dbo].[NhaCungCap] ON 

INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [Diachi], [Email], [Sdt]) VALUES (2001, N' CPTM & XNK TINH HOA VIỆT', N'Hà Đông, Hà Nội', N'ctpmhn@gmail.com', N'0777778933')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [Diachi], [Email], [Sdt]) VALUES (2002, N'CÔNG TY TNHH THỜI TRANG ZENDA VIỆT NAM', N'Toàn quốc', N'belinga@gmail.com', N'0333335588')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [Diachi], [Email], [Sdt]) VALUES (2003, N'CÔNG TY TNHH KINH DOANH DỊCH VỤ KIM HUY', N'Toàn quốc', N'dulism2@gmail.com', N'0999998755')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [Diachi], [Email], [Sdt]) VALUES (2004, N'AVE GROUP', N'Toàn quốc', N'avefg@gmail.com', N'0454545869')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [Diachi], [Email], [Sdt]) VALUES (2005, N'CÔNG TY TNHH TM DV UP', N'Hà Nội', N'tnhhdvup@gmail.com', N'0666658789')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [Diachi], [Email], [Sdt]) VALUES (2006, N'DANH TRÀ BẠCH LIÊN', N'Xuân Lộc, Đồng Nai', N'trdlkk@gmail.com', N'0322225878')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [Diachi], [Email], [Sdt]) VALUES (2007, N'UK SUPPLIES DIRECT VIỆT NAM', N'Toàn quốc', N'siphujsu@gmail.com', N'0487878756')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [Diachi], [Email], [Sdt]) VALUES (2008, N'CÔNG TY CỔ PHẦN VIỄN THÔNG FPT', N'Ba Đình, Hà Nội', N'adjiah@gmail.com', N'0787562685')
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [Diachi], [Email], [Sdt]) VALUES (2009, N'GAMING', N'TP.HCM', N'gaming@gmail.com', N'0879556959')
SET IDENTITY_INSERT [dbo].[NhaCungCap] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [Diachi], [Gioitinh], [Email], [Vaitro], [Tinhtrang], [Matkhau]) VALUES (4001, N'Nguyễn Thành Thiện', N'Tây Ninh', N'Nam', N'imisthanhthien@gmail.com', 1, 1, N'123')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [Diachi], [Gioitinh], [Email], [Vaitro], [Tinhtrang], [Matkhau]) VALUES (4002, N'Nguyễn Ngọc Thiên', N'Nha Trang', N'Nam', N'thiennguyennt1012@gmail.com', 1, 1, N'123')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [Diachi], [Gioitinh], [Email], [Vaitro], [Tinhtrang], [Matkhau]) VALUES (4003, N'Huỳnh Nhật Hào', N'Tây Ninh', N'Nam', N'haobui@gmail.com', 0, 1, N'123')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [Diachi], [Gioitinh], [Email], [Vaitro], [Tinhtrang], [Matkhau]) VALUES (4004, N'Bảo Trân', N'Đà Lạt', N'Nữ', N'tranvivy@gmail.com', 0, 1, N'123')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [Diachi], [Gioitinh], [Email], [Vaitro], [Tinhtrang], [Matkhau]) VALUES (4005, N'Thùy Linh ', N'Hà Nội', N'Nữ', N'linhthuynta@gmail.com', 0, 1, N'123')
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[PhieuNhap] ON 

INSERT [dbo].[PhieuNhap] ([MaPN], [Ngaynhap], [Lydonhap], [MaNV], [MaNCC], [ThanhTien], [Trangthai]) VALUES (6001, CAST(N'2023-04-11' AS Date), N'Thiếu Hàng', 4001, 2001, 5600000, 1)
INSERT [dbo].[PhieuNhap] ([MaPN], [Ngaynhap], [Lydonhap], [MaNV], [MaNCC], [ThanhTien], [Trangthai]) VALUES (6002, CAST(N'2023-04-12' AS Date), N'Thiếu Hàng', 4002, 2001, 6750000, 1)
INSERT [dbo].[PhieuNhap] ([MaPN], [Ngaynhap], [Lydonhap], [MaNV], [MaNCC], [ThanhTien], [Trangthai]) VALUES (6003, CAST(N'2023-04-15' AS Date), N'Thiếu Hàng', 4003, 2006, 1780000, 1)
INSERT [dbo].[PhieuNhap] ([MaPN], [Ngaynhap], [Lydonhap], [MaNV], [MaNCC], [ThanhTien], [Trangthai]) VALUES (6004, CAST(N'2023-04-20' AS Date), N'Thiếu Hàng', 4004, 2001, 450000, 1)
INSERT [dbo].[PhieuNhap] ([MaPN], [Ngaynhap], [Lydonhap], [MaNV], [MaNCC], [ThanhTien], [Trangthai]) VALUES (6005, CAST(N'2023-05-07' AS Date), N'', 4001, 2006, 4500000, 1)
INSERT [dbo].[PhieuNhap] ([MaPN], [Ngaynhap], [Lydonhap], [MaNV], [MaNCC], [ThanhTien], [Trangthai]) VALUES (6006, CAST(N'2023-05-07' AS Date), N'', 4001, 2005, 8565000, 1)
INSERT [dbo].[PhieuNhap] ([MaPN], [Ngaynhap], [Lydonhap], [MaNV], [MaNCC], [ThanhTien], [Trangthai]) VALUES (6007, CAST(N'2023-05-07' AS Date), N'', 4001, 2004, 4530000, 1)
INSERT [dbo].[PhieuNhap] ([MaPN], [Ngaynhap], [Lydonhap], [MaNV], [MaNCC], [ThanhTien], [Trangthai]) VALUES (6008, CAST(N'2023-05-07' AS Date), N'', 4001, 2001, 580000, 1)
INSERT [dbo].[PhieuNhap] ([MaPN], [Ngaynhap], [Lydonhap], [MaNV], [MaNCC], [ThanhTien], [Trangthai]) VALUES (6009, CAST(N'2023-05-07' AS Date), N'Đang thiếu hàng', 4001, 2008, 2400000, 1)
SET IDENTITY_INSERT [dbo].[PhieuNhap] OFF
GO
SET IDENTITY_INSERT [dbo].[PhieuXuat] ON 

INSERT [dbo].[PhieuXuat] ([MaPX], [Ngayban], [Lydoxuat], [MaNV], [MaKH], [ThanhTien], [Trangthai]) VALUES (7001, CAST(N'2023-04-12' AS Date), N'KH cần', 4003, 3004, 2000000, 1)
INSERT [dbo].[PhieuXuat] ([MaPX], [Ngayban], [Lydoxuat], [MaNV], [MaKH], [ThanhTien], [Trangthai]) VALUES (7002, CAST(N'2023-04-13' AS Date), N'KH cần', 4002, 3003, 120000, 1)
INSERT [dbo].[PhieuXuat] ([MaPX], [Ngayban], [Lydoxuat], [MaNV], [MaKH], [ThanhTien], [Trangthai]) VALUES (7003, CAST(N'2023-04-18' AS Date), N'KH cần', 4001, 3005, 20000000, 1)
INSERT [dbo].[PhieuXuat] ([MaPX], [Ngayban], [Lydoxuat], [MaNV], [MaKH], [ThanhTien], [Trangthai]) VALUES (7004, CAST(N'2023-04-20' AS Date), N'KH Cần', 4001, 3001, 950000, 1)
INSERT [dbo].[PhieuXuat] ([MaPX], [Ngayban], [Lydoxuat], [MaNV], [MaKH], [ThanhTien], [Trangthai]) VALUES (7005, CAST(N'2023-05-07' AS Date), N'', 4001, 3004, 2500000, 1)
INSERT [dbo].[PhieuXuat] ([MaPX], [Ngayban], [Lydoxuat], [MaNV], [MaKH], [ThanhTien], [Trangthai]) VALUES (7006, CAST(N'2023-05-07' AS Date), N'', 4001, 3001, 2070000, 1)
INSERT [dbo].[PhieuXuat] ([MaPX], [Ngayban], [Lydoxuat], [MaNV], [MaKH], [ThanhTien], [Trangthai]) VALUES (7007, CAST(N'2023-05-07' AS Date), N'', 4001, 3001, 960000, 1)
SET IDENTITY_INSERT [dbo].[PhieuXuat] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UC_TenHH]    Script Date: 07/05/2023 8:34:13 PM ******/
ALTER TABLE [dbo].[HangHoa] ADD  CONSTRAINT [UC_TenHH] UNIQUE NONCLUSTERED 
(
	[TenHH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UC_SDT]    Script Date: 07/05/2023 8:34:13 PM ******/
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [UC_SDT] UNIQUE NONCLUSTERED 
(
	[Sdt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UC_TenLoai]    Script Date: 07/05/2023 8:34:13 PM ******/
ALTER TABLE [dbo].[LoaiHangHoa] ADD  CONSTRAINT [UC_TenLoai] UNIQUE NONCLUSTERED 
(
	[Tenloai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UC_sdtNCC]    Script Date: 07/05/2023 8:34:13 PM ******/
ALTER TABLE [dbo].[NhaCungCap] ADD  CONSTRAINT [UC_sdtNCC] UNIQUE NONCLUSTERED 
(
	[Sdt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UC_Tencc]    Script Date: 07/05/2023 8:34:13 PM ******/
ALTER TABLE [dbo].[NhaCungCap] ADD  CONSTRAINT [UC_Tencc] UNIQUE NONCLUSTERED 
(
	[TenNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UC_TenNCC]    Script Date: 07/05/2023 8:34:13 PM ******/
ALTER TABLE [dbo].[NhaCungCap] ADD  CONSTRAINT [UC_TenNCC] UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UC_Email]    Script Date: 07/05/2023 8:34:13 PM ******/
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [UC_Email] UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[HangHoa] ADD  CONSTRAINT [df_mota]  DEFAULT ('Không xác d?nh') FOR [Mota]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [df_ngaylap]  DEFAULT (getdate()) FOR [Ngaylap]
GO
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [df_tenkh]  DEFAULT ('?n danh') FOR [TenKH]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [df_tennv]  DEFAULT ('No name') FOR [TenNV]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [df_diachi]  DEFAULT ('Chua có d?a ch?') FOR [Diachi]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [df_TinhTrang]  DEFAULT ((1)) FOR [Tinhtrang]
GO
ALTER TABLE [dbo].[PhieuNhap] ADD  CONSTRAINT [df_ngaynhap]  DEFAULT (getdate()) FOR [Ngaynhap]
GO
ALTER TABLE [dbo].[PhieuNhap] ADD  CONSTRAINT [df_Lydonhap]  DEFAULT ('Thi?u Hàng') FOR [Lydonhap]
GO
ALTER TABLE [dbo].[PhieuNhap] ADD  CONSTRAINT [df_trangthainhap]  DEFAULT ((0)) FOR [Trangthai]
GO
ALTER TABLE [dbo].[PhieuXuat] ADD  CONSTRAINT [df_ngayban]  DEFAULT (getdate()) FOR [Ngayban]
GO
ALTER TABLE [dbo].[PhieuXuat] ADD  CONSTRAINT [df_Lydonxuat]  DEFAULT ('Khách hàng yêu c?u') FOR [Lydoxuat]
GO
ALTER TABLE [dbo].[PhieuXuat] ADD  CONSTRAINT [df_trangthaixuat]  DEFAULT ((0)) FOR [Trangthai]
GO
ALTER TABLE [dbo].[CTHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_CTHoaDon_HangHoa] FOREIGN KEY([MaHH])
REFERENCES [dbo].[HangHoa] ([MaHH])
GO
ALTER TABLE [dbo].[CTHoaDon] CHECK CONSTRAINT [FK_CTHoaDon_HangHoa]
GO
ALTER TABLE [dbo].[CTHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_CTHoaDon_HoaDon] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[CTHoaDon] CHECK CONSTRAINT [FK_CTHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[CTPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_CTPhieuNhap_HangHoa] FOREIGN KEY([MaHH])
REFERENCES [dbo].[HangHoa] ([MaHH])
GO
ALTER TABLE [dbo].[CTPhieuNhap] CHECK CONSTRAINT [FK_CTPhieuNhap_HangHoa]
GO
ALTER TABLE [dbo].[CTPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_CTPhieuNhap_PhieuNhap] FOREIGN KEY([SoPN])
REFERENCES [dbo].[PhieuNhap] ([MaPN])
GO
ALTER TABLE [dbo].[CTPhieuNhap] CHECK CONSTRAINT [FK_CTPhieuNhap_PhieuNhap]
GO
ALTER TABLE [dbo].[CTPhieuXuat]  WITH CHECK ADD  CONSTRAINT [FK_CTPhieuXuat_HangHoa] FOREIGN KEY([MaHH])
REFERENCES [dbo].[HangHoa] ([MaHH])
GO
ALTER TABLE [dbo].[CTPhieuXuat] CHECK CONSTRAINT [FK_CTPhieuXuat_HangHoa]
GO
ALTER TABLE [dbo].[CTPhieuXuat]  WITH CHECK ADD  CONSTRAINT [FK_CTPhieuXuat_PhieuXuat] FOREIGN KEY([SoPX])
REFERENCES [dbo].[PhieuXuat] ([MaPX])
GO
ALTER TABLE [dbo].[CTPhieuXuat] CHECK CONSTRAINT [FK_CTPhieuXuat_PhieuXuat]
GO
ALTER TABLE [dbo].[HangHoa]  WITH CHECK ADD  CONSTRAINT [FK_HangHoa_LoaiHangHoa] FOREIGN KEY([Maloai])
REFERENCES [dbo].[LoaiHangHoa] ([Maloai])
GO
ALTER TABLE [dbo].[HangHoa] CHECK CONSTRAINT [FK_HangHoa_LoaiHangHoa]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhanVien]
GO
ALTER TABLE [dbo].[PhieuXuat]  WITH CHECK ADD  CONSTRAINT [FK_PhieuXuat_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[PhieuXuat] CHECK CONSTRAINT [FK_PhieuXuat_KhachHang]
GO
ALTER TABLE [dbo].[PhieuXuat]  WITH CHECK ADD  CONSTRAINT [FK_PhieuXuat_NhanVien1] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuXuat] CHECK CONSTRAINT [FK_PhieuXuat_NhanVien1]
GO
ALTER TABLE [dbo].[CTHoaDon]  WITH CHECK ADD  CONSTRAINT [CHK_giabanhoadon] CHECK  (([Giaban]>(0)))
GO
ALTER TABLE [dbo].[CTHoaDon] CHECK CONSTRAINT [CHK_giabanhoadon]
GO
ALTER TABLE [dbo].[CTHoaDon]  WITH CHECK ADD  CONSTRAINT [CHK_soluongnhaphoadon] CHECK  (([Soluong]>(0)))
GO
ALTER TABLE [dbo].[CTHoaDon] CHECK CONSTRAINT [CHK_soluongnhaphoadon]
GO
ALTER TABLE [dbo].[CTPhieuNhap]  WITH CHECK ADD  CONSTRAINT [CHK_Gianhap] CHECK  (([Gianhap]>(0)))
GO
ALTER TABLE [dbo].[CTPhieuNhap] CHECK CONSTRAINT [CHK_Gianhap]
GO
ALTER TABLE [dbo].[CTPhieuNhap]  WITH CHECK ADD  CONSTRAINT [CHK_Soluongnhap] CHECK  (([SLNhap]>(0)))
GO
ALTER TABLE [dbo].[CTPhieuNhap] CHECK CONSTRAINT [CHK_Soluongnhap]
GO
ALTER TABLE [dbo].[CTPhieuXuat]  WITH CHECK ADD  CONSTRAINT [CHK_GiaXuat] CHECK  (([Giaxuat]>(0)))
GO
ALTER TABLE [dbo].[CTPhieuXuat] CHECK CONSTRAINT [CHK_GiaXuat]
GO
ALTER TABLE [dbo].[CTPhieuXuat]  WITH CHECK ADD  CONSTRAINT [CHK_Soluongxuat] CHECK  (([SLXuat]>(0)))
GO
ALTER TABLE [dbo].[CTPhieuXuat] CHECK CONSTRAINT [CHK_Soluongxuat]
GO
ALTER TABLE [dbo].[HangHoa]  WITH CHECK ADD  CONSTRAINT [CHK_giabanhang] CHECK  (([Giaban]>(0)))
GO
ALTER TABLE [dbo].[HangHoa] CHECK CONSTRAINT [CHK_giabanhang]
GO
ALTER TABLE [dbo].[HangHoa]  WITH CHECK ADD  CONSTRAINT [CHK_Soluong] CHECK  (([Soluong]>=(0)))
GO
ALTER TABLE [dbo].[HangHoa] CHECK CONSTRAINT [CHK_Soluong]
GO
/****** Object:  StoredProcedure [dbo].[Addphieunhap]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Addphieunhap]
@lydo nvarchar(100),
@manv int,
@mancc int,
@thanhtien float
as
begin 
	insert into PhieuNhap(Lydonhap,MaNV,MaNCC,ThanhTien) values(@lydo,@manv,@mancc,@thanhtien)
end
GO
/****** Object:  StoredProcedure [dbo].[Addphieuxuat]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Addphieuxuat]
@lydo nvarchar(100),
@manv int,
@mankh int,
@thanhtien float
as
begin 
	insert into PhieuXuat(Lydoxuat,MaNV,MaKH,ThanhTien) values(@lydo,@manv,@mankh,@thanhtien)
end
GO
/****** Object:  StoredProcedure [dbo].[CapNhapCTHD]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--CẬP NHẬP CHI TIẾT HÓA ĐƠN
create proc [dbo].[CapNhapCTHD]
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
GO
/****** Object:  StoredProcedure [dbo].[DS_CTHoaDon]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--DANH SÁCH CHI TIẾT HÓA ĐƠN
CREATE PROC [dbo].[DS_CTHoaDon]
AS BEGIN
SELECT b.MaHH ,p.TenHH, b.Soluong, b.Giaban , b.Thanhtien  FROM CTHoaDon b, HangHoa p
WHERE b.MaHH = p.MaHH
END
GO
/****** Object:  StoredProcedure [dbo].[DS_HangHoa]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[DS_HangHoa]
as

begin
	
	select   MaHH,TenHH, Tenloai, Mota,Soluong, Giaban from HangHoa,LoaiHangHoa
	where HangHoa.Maloai = LoaiHangHoa.Maloai
end
GO
/****** Object:  StoredProcedure [dbo].[DS_LoaiSP]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[DS_LoaiSP]
as
begin
	select *from LoaiHangHoa
end
GO
/****** Object:  StoredProcedure [dbo].[DS_NCC]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Danh sach Nha cung cap
create proc [dbo].[DS_NCC]
as
begin
		select *from NhaCungCap
end
GO
/****** Object:  StoredProcedure [dbo].[DS_NhanVien]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Danh sách nhân viên
create proc [dbo].[DS_NhanVien]
as
begin
		select MaNV, TenNV, Gioitinh, Email, Vaitro, Tinhtrang  from  NhanVien
end

GO
/****** Object:  StoredProcedure [dbo].[DS_Nhap]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[DS_Nhap]
as
begin
		select MaPN,Ngaynhap,Lydonhap, NhanVien.TenNV, NhaCungCap.TenNCC,PhieuNhap.Thanhtien from PhieuNhap,NhanVien,NhaCungCap 
		where NhanVien.MaNV = PhieuNhap.MaNV and NhaCungCap.MaNCC = PhieuNhap.MaNCC
end
GO
/****** Object:  StoredProcedure [dbo].[DS_Xuat]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[DS_Xuat]
as
begin
		select  MaPX,Ngayban,Lydoxuat,NhanVien.TenNV,KhachHang.TenKH,PhieuXuat.Thanhtien   from PhieuXuat ,NhanVien,KhachHang
		where NhanVien.MaNV = PhieuXuat.MaNV and KhachHang.MaKH = PhieuXuat.MaKH
end
GO
/****** Object:  StoredProcedure [dbo].[editprofile]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
---Chỉnh sửa thông tin cá nhân
create proc [dbo].[editprofile]
@email  varchar(50),
@tennv nvarchar(50),
@diachi nvarchar(50)

as

begin
	Update NhanVien set TenNV = @tennv, Diachi = @diachi where Email =@email
end
GO
/****** Object:  StoredProcedure [dbo].[LoadCTPhieuNHap]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[LoadCTPhieuNHap]
as
begin
	select    HangHoa.MaHH,HangHoa.TenHH,  CTPhieuNhap.SLNhap,CTPhieuNhap.GiaNhap,CTPhieuNhap.Thanhtien  from CTPhieuNhap,HangHoa
	where HangHoa.MaHH = CTPhieuNhap.MaHH

end
GO
/****** Object:  StoredProcedure [dbo].[LoadCTPhieuXuat]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[LoadCTPhieuXuat]
as
begin
	select    HangHoa.MaHH,HangHoa.TenHH,  CTPhieuXuat.SLXuat,CTPhieuXuat.Giaxuat,CTPhieuXuat.Thanhtien   from CTPhieuXuat,HangHoa
	where HangHoa.MaHH = CTPhieuXuat.MaHH
end

GO
/****** Object:  StoredProcedure [dbo].[LoadHoaDon]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--LoadHoadon
create proc [dbo].[LoadHoaDon]
as
begin
	select  MaHD, nv.TenNV, kh.TenKH,Ngaylap,Tongtien  from HoaDon hd, KhachHang kh, NhanVien nv
	where nv.MaNV = hd.MaNV and kh.MaKH = hd.MaKH
end
GO
/****** Object:  StoredProcedure [dbo].[LoadTableDanhThu]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
---Table danh thu 
create proc [dbo].[LoadTableDanhThu]
as
begin
	select  HD.MaHD , CONVERT(date,HD.Ngaylap), HD.Tongtien from  HoaDon HD
end
GO
/****** Object:  StoredProcedure [dbo].[LoadTableDanhThuNhap]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[LoadTableDanhThuNhap]
as
begin
	select  PN.MaPN , CONVERT(date,PN.Ngaynhap), PN.ThanhTien from  PhieuNhap PN
	where PN.Trangthai = 1
end
GO
/****** Object:  StoredProcedure [dbo].[LoadTableDanhThuXuat]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[LoadTableDanhThuXuat]
as
begin
	select  PX.MaPX , CONVERT(date,PX.Ngayban) as Ngayban, PX.ThanhTien from  PhieuXuat PX
	where PX.Trangthai = 1
end
GO
/****** Object:  StoredProcedure [dbo].[loadTableKH]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[loadTableKH]
as
begin
	select * from KhachHang
end
GO
/****** Object:  StoredProcedure [dbo].[login]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--Login
create proc [dbo].[login]
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
GO
/****** Object:  StoredProcedure [dbo].[QuyenNV]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--KiemtraquyenNhapHang
create proc [dbo].[QuyenNV]
@email varchar(50)
as
begin
	select  MaNV from NhanVien where Email = @email
end
GO
/****** Object:  StoredProcedure [dbo].[SuaHH]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[SuaHH]
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
GO
/****** Object:  StoredProcedure [dbo].[SuaKH]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Sửa khách khàng
create proc [dbo].[SuaKH]
@ma int,
@ten nvarchar(50),
@diachi nvarchar(50),
@sdt varchar(10)
as
begin
	update KhachHang set TenKH = @ten, Diachi = @diachi, Sdt = @sdt
	where MaKH = @ma
end
GO
/****** Object:  StoredProcedure [dbo].[SuaLoaiHH]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[SuaLoaiHH]
@maloai int,
@tenloai varchar(50)
as
begin
	update LoaiHangHoa set Tenloai = @tenloai where Maloai = @maloai
end
GO
/****** Object:  StoredProcedure [dbo].[SuaNV]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Update nhânvien
create proc [dbo].[SuaNV]
@manv int,
@tenNV nvarchar(50),
@gioitinh nvarchar(3),
@email nvarchar(50),
@vaitro bit
as
begin
	update NhanVien set TenNV = @tenNV, Gioitinh = @gioitinh, Email = @email, Vaitro = @vaitro where MaNV = @manv
end
GO
/****** Object:  StoredProcedure [dbo].[SuaPhieuNhap]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--SỬA PHIẾU NHẬP
create proc [dbo].[SuaPhieuNhap]
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
GO
/****** Object:  StoredProcedure [dbo].[SuaPhieuXuatCT]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[SuaPhieuXuatCT]
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
GO
/****** Object:  StoredProcedure [dbo].[thaydoimk]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Stored procedures
CREATE PROC [dbo].[thaydoimk]
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


GO
/****** Object:  StoredProcedure [dbo].[ThemCTHoaDon]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
---THÊM CHI TIẾT HÓA ĐƠN
create proc [dbo].[ThemCTHoaDon]
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
GO
/****** Object:  StoredProcedure [dbo].[ThemHH]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[ThemHH]
@tenhh nvarchar(50),
@maloai int,
@mota nvarchar(100),
@sl int,
@giaban float
as
begin
		insert into HangHoa(TenHH,Maloai,Mota,Soluong,Giaban) values(@tenhh,@maloai,@mota,@sl,@giaban)
end
GO
/****** Object:  StoredProcedure [dbo].[ThemHoaDon]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[ThemHoaDon]
@manv int ,
@makh int,
@tongtien float
as
begin
		insert into HoaDon(MaNV,MaKH,Tongtien) values (@manv,@makh,@tongtien)
end
GO
/****** Object:  StoredProcedure [dbo].[ThemKH]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[ThemKH]
@ten nvarchar(50),
@diachi nvarchar(50),
@sdt varchar(10)
as
begin
	insert into KhachHang values (@ten,@diachi, @sdt)
end
GO
/****** Object:  StoredProcedure [dbo].[ThemLoaiHH]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[ThemLoaiHH]
@tenloai varchar(50)
as
begin 
	insert into LoaiHangHoa values(@tenloai)
end
GO
/****** Object:  StoredProcedure [dbo].[ThemNCC]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[ThemNCC] 
@tenncc varchar(50),
@diachi varchar(50),
@email varchar(50),
@sdt varchar(10)
as
begin
	insert into NhaCungCap values(@tenncc,@diachi,@email,@sdt)
end
GO
/****** Object:  StoredProcedure [dbo].[ThemNV]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Thêm nhân viên
create proc [dbo].[ThemNV]
@tennv nvarchar(50),
@gioitinh nvarchar(3),
@email varchar(50),
@mk varchar(100)
as
begin
		insert into NhanVien(TenNV,Gioitinh,Email,Matkhau) values (@tennv,@gioitinh,@email,@mk)
end

GO
/****** Object:  StoredProcedure [dbo].[ThemPhieuNhap]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--ThemPhieuNhap
create proc [dbo].[ThemPhieuNhap]
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
GO
/****** Object:  StoredProcedure [dbo].[ThemPhieuXuat]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[ThemPhieuXuat]
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
GO
/****** Object:  StoredProcedure [dbo].[ThemPhieuXuatCT]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--ThemPhieuXuat
create proc [dbo].[ThemPhieuXuatCT]
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

GO
/****** Object:  StoredProcedure [dbo].[ThemPN]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--them phieu nhap
create proc [dbo].[ThemPN] 
@lydo varchar(50),
@manv int,
@mancc int
as
begin
	insert into PhieuNhap(Lydonhap,MaNV,MaNCC) values(@lydo,@manv,@mancc)
end
GO
/****** Object:  StoredProcedure [dbo].[ThemPX]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--them phieu xuat
create proc [dbo].[ThemPX] 

@lydoban varchar(50),
@manv int,
@makh int
as
begin
	insert into PhieuXuat(Lydoxuat,MaNV,MaKH) values(@lydoban,@manv,@makh)
end
GO
/****** Object:  StoredProcedure [dbo].[thongtinnv]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--Thongtinnv
create proc [dbo].[thongtinnv]
as
begin
	select Email,Matkhau  from NhanVien
end

GO
/****** Object:  StoredProcedure [dbo].[thongtinnvedit]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Lay thong tin nhân vien
create proc [dbo].[thongtinnvedit]
@email varchar(50)
as
begin
	select TenNV,Diachi,Email  from NhanVien where Email = @email
end

GO
/****** Object:  StoredProcedure [dbo].[TimKiemHoaDonNhapTheoNgay]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Tim kiem HoaDOnNHap theo ngay
create proc [dbo].[TimKiemHoaDonNhapTheoNgay]
@ngaylap date
as
begin
	select *from PhieuNhap where Ngaynhap like @ngaylap
end
GO
/****** Object:  StoredProcedure [dbo].[TimKiemHoaDonTheoNgay]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[TimKiemHoaDonTheoNgay]
@ngaylap date
as
begin
	select *from HoaDon where Ngaylap like @ngaylap
end

GO
/****** Object:  StoredProcedure [dbo].[TimKiemHoaDonXuatTheoNgay]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Tim kiem HoaDOnXuat theo ngay
create proc [dbo].[TimKiemHoaDonXuatTheoNgay]
@ngaylap date
as
begin
	select *from PhieuXuat where Ngayban like @ngaylap
end
GO
/****** Object:  StoredProcedure [dbo].[UpdateNCC]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[UpdateNCC]
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
GO
/****** Object:  StoredProcedure [dbo].[XoaCTHD]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--XÓA CHI TIẾT HÓA ĐƠN
create proc [dbo].[XoaCTHD]
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
GO
/****** Object:  StoredProcedure [dbo].[XoaHH]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--Xóa Hàng Hóa

create proc [dbo].[XoaHH]
@mahh int
as
	begin
		Delete from HangHoa where MaHH = @mahh
	end

GO
/****** Object:  StoredProcedure [dbo].[XoaHoaDonThanhToan]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[XoaHoaDonThanhToan]
as
begin
		delete from CTHoaDon
end
GO
/****** Object:  StoredProcedure [dbo].[XoaKH]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[XoaKH]
@makh int
as
begin
	delete from KhachHang where MaKH = @makh
end
GO
/****** Object:  StoredProcedure [dbo].[XoaLoaiHH]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[XoaLoaiHH]
@maloai int
as
begin
		Delete from LoaiHangHoa where Maloai = @maloai
end
GO
/****** Object:  StoredProcedure [dbo].[XoaNCC]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--XÓA NHÀ CUNG CẤP
create proc [dbo].[XoaNCC]
@ma int
as
begin
	delete from NhaCungCap where MaNCC = @ma
end
GO
/****** Object:  StoredProcedure [dbo].[XoaNV]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[XoaNV]
@manv int
as
begin
	delete from NhanVien where MaNV = @manv
end
GO
/****** Object:  StoredProcedure [dbo].[XoaPhieuNhap]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[XoaPhieuNhap]
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
GO
/****** Object:  StoredProcedure [dbo].[XoaPhieuNhapTT]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
---XÓA PHIẾU NHẬT ĐÃ THANH TOÁN
create proc [dbo].[XoaPhieuNhapTT]
as
begin
	Delete from CTPhieuNhap
end
GO
/****** Object:  StoredProcedure [dbo].[XoaPhieuXuatCT]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--xoaphieuxuat
create proc [dbo].[XoaPhieuXuatCT]
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
GO
/****** Object:  StoredProcedure [dbo].[XoaPhieuXuatTT]    Script Date: 07/05/2023 8:34:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--XÓA PHIẾU XUẤT ĐÃ THANH TOÁN
create proc [dbo].[XoaPhieuXuatTT]

as
begin
	Delete from CTPhieuXuat
end
GO
