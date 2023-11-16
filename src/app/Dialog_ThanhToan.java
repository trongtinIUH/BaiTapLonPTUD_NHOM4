package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import dao.ChiTietDichVu_dao;
import dao.ChiTietHoaDon_dao;
import dao.HoaDonDatPhong_dao;
import dao.KhachHang_dao;
import dao.KhuyenMai_dao;
import dao.LoaiPhong_dao;
import dao.NhanVien_dao;
import dao.Phong_dao;
import dao.SanPham_dao;
import entity.ChiTietDichVu;
import entity.ChiTietHoaDon;
import entity.Enum_TrangThai;
import entity.HoaDonDatPhong;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;
import entity.SanPham;

import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Dialog_ThanhToan extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblTieuDe;
	private JLabel lblSDTKhach;
	private JLabel lblTenKhach;
	private JLabel lblTenNV;
	private JLabel lblGioTraPhong;
	private JLabel lblTngThiLng;
	private JLabel lbl_sdtKH_1;
	private JLabel lbl_tenKH_1;
	private JLabel lbl_TenNV_1;
	private JLabel lbl_GioTraPhong_1;
	private JLabel lbl_TongThoiLuong_1;

	private JTable tblThanhToan;
	private DefaultTableModel model;
	private String col[] = { "STT", "Phòng / Tên SP", "Thời gian / SL", "Đơn Giá", "Đơn Vị Tính", "Thành tiền" };
	private JLabel lblTienDV;
	private JLabel lblTienPhong;
	private JLabel lblTongCong;
	private JLabel lblThu;
	private JLabel lbl_TongThanhTien;
	private JTextField txtMaGiamGia;
	private JTextField txtTienNhan;
	private JTextField txtTienThua;
	private JLabel lbl_TongThanhTien_1;
	private JLabel lblThu_1;
	private JLabel lblVn;
	private JLabel lblVn_1;
	private JLabel lblVn_2;
	private JButton btnThanhToan;
	private JButton btnQuayLai;
	private NhanVien_dao nv_dao;
	private ChiTietHoaDon_dao cthd_dao;
	private HoaDonDatPhong_dao hd_dao;
	private KhachHang_dao kh_dao;
	private JLabel lblMaHD;
	private JLabel lbl_MaHoaDon_1;
	private Date ngayTraPhong;
	private Phong_dao ph_dao;
	private LoaiPhong_dao loaiPhong_dao;
	private ChiTietDichVu_dao ctdv_dao;
	private SanPham_dao sp_dao;
	private int tongTienDichVu;
	private int tongTienPhong;
	private JCheckBox chckbx_XuatHoaDon;
	private Date tgHT;
	private Date gioHienTai;
	private Date phutHienTai;
	private int gioThua;
	private double phutChinhXac;
	private double tongSoGioHat;
	private double tongSoPhutHat;
	private double soGioHat_Item;
	private double soPhutHat_Item;
	private double thoiGian_Item;
	private KhuyenMai_dao km_dao;
	private JButton btnKiemTra;
	private int xacNhan;
	private JTextField txtPhanTramKM;
	private Date date_HT;
	private DecimalFormat f;

	public Dialog_ThanhToan(String maPhong) {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setSize(800, 550);
		setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon("icon\\icon_white.png");
	    this.setIconImage(icon.getImage());
	    
		nv_dao = new NhanVien_dao();
		cthd_dao = new ChiTietHoaDon_dao();
		ctdv_dao = new ChiTietDichVu_dao();
		hd_dao = new HoaDonDatPhong_dao();
		kh_dao = new KhachHang_dao();
		ph_dao = new Phong_dao();
		loaiPhong_dao = new LoaiPhong_dao();
		sp_dao = new SanPham_dao();
		km_dao = new KhuyenMai_dao();

		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				NhanVien nv = null;
				nv = nv_dao.getNhanVienTheoMa(DataManager.getUserName());
				lbl_TenNV_1.setText(nv.getHoTen());
			}
		});

		// panel chứa tiêu
		// đề-------------------------------------------------------------------------
		panel = new JPanel();
		panel.setBounds(0, 0, 784, 35);
		panel.setBackground(new Color(181, 230, 251, 255));
		getContentPane().add(panel);
		panel.setLayout(null);
		getContentPane().add(panel);

		lblTieuDe = new JLabel("Thanh Toán");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 790, 35);
		panel.add(lblTieuDe);

		// panel 1 chứa thông tin kh, nhân viên và bảng
		// table-------------------------------------------
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 34, 784, 256);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lblSDTKhach = new JLabel("SDT khách:");
		lblSDTKhach.setFont(new Font("Arial", Font.BOLD, 15));
		lblSDTKhach.setBounds(5, 5, 90, 20);
		panel_1.add(lblSDTKhach);

		lblTenKhach = new JLabel("Tên khách:");
		lblTenKhach.setFont(new Font("Arial", Font.BOLD, 15));
		lblTenKhach.setBounds(5, 35, 90, 20);
		panel_1.add(lblTenKhach);

		lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Arial", Font.BOLD, 15));
		lblTenNV.setBounds(5, 65, 130, 20);
		panel_1.add(lblTenNV);

		lblMaHD = new JLabel("Mã hóa đơn:");
		lblMaHD.setFont(new Font("Arial", Font.BOLD, 15));
		lblMaHD.setBounds(480, 5, 130, 20);
		panel_1.add(lblMaHD);

		lblGioTraPhong = new JLabel("Giờ trả phòng:");
		lblGioTraPhong.setFont(new Font("Arial", Font.BOLD, 15));
		lblGioTraPhong.setBounds(480, 35, 110, 20);
		panel_1.add(lblGioTraPhong);

		lblTngThiLng = new JLabel("Tổng thời lượng:");
		lblTngThiLng.setFont(new Font("Arial", Font.BOLD, 15));
		lblTngThiLng.setBounds(480, 65, 140, 20);
		panel_1.add(lblTngThiLng);

		ChiTietHoaDon cthd_hienTaiCuaPhong = null;
		ArrayList<ChiTietHoaDon> dsCTHD = cthd_dao.getChiTietHoaDonTheoMaPhong(maPhong);
		for (ChiTietHoaDon cthd : dsCTHD) {
			cthd_hienTaiCuaPhong = cthd;
		}

		HoaDonDatPhong hd = null;
		hd = hd_dao.getHoaDonTheoMaHoaDon(cthd_hienTaiCuaPhong.getHoaDon().getMaHoaDon());
		KhachHang kh = null;
		kh = kh_dao.getKhachHangTheoMaKH(hd.getKhachHang().getMaKhachHang());

		lbl_sdtKH_1 = new JLabel(kh.getSoDienThoai());
		lbl_sdtKH_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_sdtKH_1.setBounds(125, 5, 200, 20);
		panel_1.add(lbl_sdtKH_1);

		lbl_tenKH_1 = new JLabel(kh.getHoTen());
		lbl_tenKH_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_tenKH_1.setBounds(125, 35, 200, 20);
		panel_1.add(lbl_tenKH_1);

		lbl_TenNV_1 = new JLabel();
		lbl_TenNV_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_TenNV_1.setBounds(125, 65, 200, 20);
		panel_1.add(lbl_TenNV_1);

		lbl_MaHoaDon_1 = new JLabel(hd.getMaHoaDon());
		lbl_MaHoaDon_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_MaHoaDon_1.setBounds(620, 5, 250, 20);
		panel_1.add(lbl_MaHoaDon_1);

		DateFormat df = new SimpleDateFormat("HH:mm dd-MM-yyyy");
		ngayTraPhong = new Date();
		lbl_GioTraPhong_1 = new JLabel(df.format(ngayTraPhong));
		lbl_GioTraPhong_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_GioTraPhong_1.setBounds(620, 35, 250, 20);
		panel_1.add(lbl_GioTraPhong_1);

		lbl_TongThoiLuong_1 = new JLabel();
		lbl_TongThoiLuong_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_TongThoiLuong_1.setBounds(620, 65, 125, 20);
		panel_1.add(lbl_TongThoiLuong_1);

		// bảng thanh toán phòng------------------------------------------------------
		model = new DefaultTableModel(col, 0);
		tblThanhToan = new JTable(model);
		tblThanhToan.setFont(new Font("Arial", Font.PLAIN, 12));
		tblThanhToan.setBackground(Color.WHITE);
		JScrollPane sp = new JScrollPane(tblThanhToan);
		sp.setBounds(5, 90, 772, 160);
		panel_1.add(sp);
		panel_1.setPreferredSize(new Dimension(772, 160));
		getContentPane().add(panel_1);

		int i = 1;
		tongTienPhong = 0;
		for (ChiTietHoaDon cthd : cthd_dao.getChiTietHoaDonTheoMaHD(lbl_MaHoaDon_1.getText().trim())) {
			DateFormat dateFormatGio = new SimpleDateFormat("HH");
			gioHienTai = new Date();
			double gioHT = Double.parseDouble(dateFormatGio.format(gioHienTai));
			DateFormat dateFormatPhut = new SimpleDateFormat("mm");
			phutHienTai = new Date();
			double phutHT = Double.parseDouble(dateFormatPhut.format(phutHienTai));

			double gioNhanPhong = Double.parseDouble(dateFormatGio.format(cthd.getGioNhanPhong()));
			double phutNhanPhong = Double.parseDouble(dateFormatPhut.format(cthd.getGioNhanPhong()));

			if (gioHT >= gioNhanPhong && phutHT >= phutNhanPhong) {
				soGioHat_Item = gioHT - gioNhanPhong;
				soPhutHat_Item = phutHT - phutNhanPhong;
				thoiGian_Item = soGioHat_Item + soPhutHat_Item / 60;
			} else if (gioHT <= gioNhanPhong && phutHT >= phutNhanPhong) {
				soGioHat_Item = gioHT - gioNhanPhong + 24.0;
				soPhutHat_Item = phutHT - phutNhanPhong;
				thoiGian_Item = (soGioHat_Item + soPhutHat_Item / 60);
			} else if (gioHT >= gioNhanPhong && phutHT <= phutNhanPhong) {
				soGioHat_Item = gioHT - gioNhanPhong - 1;
				soPhutHat_Item = phutHT - phutNhanPhong + 60.0;
				thoiGian_Item = (soGioHat_Item + soPhutHat_Item / 60);
			} else if (gioHT <= gioNhanPhong && phutHT <= phutNhanPhong) {
				soGioHat_Item = gioHT - gioNhanPhong + 24.0 - 1.0;
				soPhutHat_Item = phutHT - phutNhanPhong + 60.0;
				thoiGian_Item = (soGioHat_Item + soPhutHat_Item / 60);
			}
			DecimalFormat df3 = new DecimalFormat("#.##");
			Phong ph = ph_dao.getPhongTheoMaPhong(cthd.getPhong().getMaPhong());
			LoaiPhong loaiPhong = loaiPhong_dao.getLoaiPhongTheoMaLoaiPhong(ph.getLoaiPhong().getMaLoaiPhong());
			if (cthd.getSoGioHat() != 0)
				thoiGian_Item = cthd.getSoGioHat();
			Object[] rowPhong = { i++, cthd.getPhong().getMaPhong(), df3.format(thoiGian_Item),
					loaiPhong.getDonGiaTheoGio(), "", df3.format(thoiGian_Item * loaiPhong.getDonGiaTheoGio()) };
			model.addRow(rowPhong);
			tongTienPhong += thoiGian_Item * loaiPhong.getDonGiaTheoGio();

			tongSoGioHat += soGioHat_Item;
			tongSoPhutHat += soPhutHat_Item;
		}
		gioThua = (int) (tongSoPhutHat / 60);
		phutChinhXac = tongSoPhutHat % 60;
		DecimalFormat df2 = new DecimalFormat("#.##");
		lbl_TongThoiLuong_1.setText(df2.format(tongSoGioHat + gioThua) + " giờ " + df2.format(phutChinhXac) + " phút");

		tongTienDichVu = 0;
		for (ChiTietDichVu ctdv : ctdv_dao.getChiTietDichVuTheoMaHD(lbl_MaHoaDon_1.getText().trim())) {
			SanPham spdv = sp_dao.getSanPhamTheoMaSP(ctdv.getSanPham().getMaSanPham());
			Object[] rowSanPham = { i++, spdv.getTenSanPham(), ctdv.getSoLuong(), ctdv.getGia(), spdv.getDonViTinh(),
					ctdv.getSoLuong() * ctdv.getGia() };
			model.addRow(rowSanPham);
			tongTienDichVu += ctdv.getSoLuong() * ctdv.getGia();
		}

		lblTienDV = new JLabel("Tiền DV:");
		lblTienDV.setFont(new Font("Arial", Font.BOLD, 15));
		lblTienDV.setBounds(5, 300, 90, 20);
		getContentPane().add(lblTienDV);

		lblTienPhong = new JLabel("Tiền phòng:");
		lblTienPhong.setFont(new Font("Arial", Font.BOLD, 15));
		lblTienPhong.setBounds(5, 325, 90, 20);
		getContentPane().add(lblTienPhong);

		lblTongCong = new JLabel("Tổng cộng:");
		lblTongCong.setFont(new Font("Arial", Font.BOLD, 15));
		lblTongCong.setBounds(5, 350, 90, 20);
		getContentPane().add(lblTongCong);

		lblThu = new JLabel("Thuế VAT:");
		lblThu.setFont(new Font("Arial", Font.BOLD, 15));
		lblThu.setBounds(5, 375, 90, 20);
		getContentPane().add(lblThu);

		lbl_TongThanhTien = new JLabel("Tổng thành tiền: ");
		lbl_TongThanhTien.setForeground(Color.RED);
		lbl_TongThanhTien.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_TongThanhTien.setBounds(5, 420, 135, 20);
		getContentPane().add(lbl_TongThanhTien);

		f = new DecimalFormat("###,###");
		lblVn_2 = new JLabel(f.format(tongTienDichVu) + " VNĐ");
		lblVn_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblVn_2.setBounds(150, 300, 150, 20);
		getContentPane().add(lblVn_2);

		lblVn_1 = new JLabel(f.format(tongTienPhong) + " VNĐ");
		lblVn_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblVn_1.setBounds(150, 325, 150, 20);
		getContentPane().add(lblVn_1);

		lblVn = new JLabel(f.format(tongTienDichVu + tongTienPhong) + " VNĐ");
		lblVn.setFont(new Font("Arial", Font.BOLD, 15));
		lblVn.setBounds(150, 350, 150, 20);
		getContentPane().add(lblVn);

		lblThu_1 = new JLabel("10%");
		lblThu_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblThu_1.setBounds(150, 375, 110, 20);
		getContentPane().add(lblThu_1);

		lbl_TongThanhTien_1 = new JLabel(
				f.format((tongTienDichVu + tongTienPhong) + 0.1 * (tongTienDichVu + tongTienPhong)) + " VNĐ");
		lbl_TongThanhTien_1.setForeground(Color.RED);
		lbl_TongThanhTien_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_TongThanhTien_1.setBounds(150, 420, 150, 20);
		getContentPane().add(lbl_TongThanhTien_1);

		chckbx_XuatHoaDon = new JCheckBox("Xuất Hóa Đơn");
		chckbx_XuatHoaDon.setFont(new Font("Arial", Font.BOLD, 12));
		chckbx_XuatHoaDon.setBounds(10, 445, 110, 20);
		getContentPane().add(chckbx_XuatHoaDon);

		JLabel lbl_MaGiamGia = new JLabel("Mã giảm giá:");
		lbl_MaGiamGia.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_MaGiamGia.setBounds(360, 300, 100, 25);
		getContentPane().add(lbl_MaGiamGia);

		JLabel lbl_PhanTtramKM = new JLabel("Phần trăm KM:");
		lbl_PhanTtramKM.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_PhanTtramKM.setBounds(360, 330, 105, 25);
		getContentPane().add(lbl_PhanTtramKM);

		JLabel lbl_TienNhan = new JLabel("Tiền nhận:");
		lbl_TienNhan.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_TienNhan.setBounds(360, 360, 90, 25);
		getContentPane().add(lbl_TienNhan);

		JLabel lbl_TienThua = new JLabel("Tiền thừa:");
		lbl_TienThua.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_TienThua.setBounds(360, 390, 90, 25);
		getContentPane().add(lbl_TienThua);

		txtMaGiamGia = new JTextField();
//		txtMaGiamGia.setText("");
		txtMaGiamGia.setFont(new Font("Arial", Font.BOLD, 15));
		txtMaGiamGia.setBounds(470, 300, 200, 25);
		getContentPane().add(txtMaGiamGia);
		txtMaGiamGia.setColumns(10);

		txtPhanTramKM = new JTextField();
		txtPhanTramKM.setFont(new Font("Arial", Font.BOLD, 15));
		txtPhanTramKM.setEditable(false);
		txtPhanTramKM.setColumns(10);
		txtPhanTramKM.setBounds(470, 330, 100, 25);
		getContentPane().add(txtPhanTramKM);

		txtTienNhan = new JTextField();
		txtTienNhan.setFont(new Font("Arial", Font.BOLD, 15));
		txtTienNhan.setColumns(10);
		txtTienNhan.setBounds(470, 360, 200, 25);
		getContentPane().add(txtTienNhan);

		txtTienThua = new JTextField();
		txtTienThua.setFont(new Font("Arial", Font.BOLD, 15));
		txtTienThua.setEditable(false);
		txtTienThua.setColumns(10);
		txtTienThua.setBounds(470, 390, 200, 25);
		getContentPane().add(txtTienThua);

		DocumentListener documentListener = new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				updateTxtTienThua();
			}

			public void removeUpdate(DocumentEvent e) {
				updateTxtTienThua();
			}

			public void changedUpdate(DocumentEvent e) {
				updateTxtTienThua();
			}

			public void updateTxtTienThua() {
				try {
					// Lấy giá trị từ txtTienNhan
					String tienNhan = txtTienNhan.getText();

					// Thực hiện công thức
					String tongTien = lbl_TongThanhTien_1.getText().replaceAll(" VNĐ", "").replaceAll(",", "");
					double tienThua = Double.parseDouble(tienNhan) - Double.parseDouble(tongTien);

					// Đặt giá trị vào txtTienThua
					txtTienThua.setText(f.format((tienThua)) + " VNĐ");
				} catch (NumberFormatException ex) {
					// Xử lý ngoại lệ khi nhập không phải là số
					txtTienThua.setText(""); // Hoặc xử lý khác tùy thuộc vào yêu cầu của bạn
				}
			}
		};

		btnKiemTra = new JButton("Kiểm tra");
		btnKiemTra.setFont(new Font("Arial", Font.BOLD, 15));
		btnKiemTra.setBounds(675, 300, 100, 30);
		getContentPane().add(btnKiemTra);

		// 2 nút jbutton cuối
		// --------------------------------------------------------------------------------
		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setBounds(20, 470, 250, 35);
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Arial", Font.BOLD, 18));
		btnThanhToan.setBorder(new RoundedBorder(60));
		btnThanhToan.setBackground(new Color(252, 155, 78, 255));
		// btnThanhToan.setBorderPainted(false);
		getContentPane().add(btnThanhToan);

		btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Arial", Font.BOLD, 18));
		btnQuayLai.setBorder(new RoundedBorder(60));
		btnQuayLai.setBackground(new Color(13, 153, 255, 255));
		btnQuayLai.setBounds(450, 470, 250, 35);
		getContentPane().add(btnQuayLai);

		// thêm sk
		btnKiemTra.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnQuayLai.addActionListener(this);
		txtTienNhan.getDocument().addDocumentListener(documentListener);
	}

	private void inHoaDon(String path) {
		path = "D:\\BaiTapLonPTUD_NHOM4\\LuuFile_PDF\\" + path + ".pdf";
		if (!path.matches("(.)+(\\.pdf)$")) {
			path += ".pdf";
		}
		Container content = this.getContentPane();
		int height = content.getHeight();
		int width = content.getHeight();
		BufferedImage img = new BufferedImage(content.getWidth(), content.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		content.printAll(g2d);
		g2d.dispose();
		try {
			Document d = new Document();
			PdfWriter writer = PdfWriter.getInstance(d, new FileOutputStream(path));
			d.open();

			PdfContentByte contentByte = writer.getDirectContent();
			Image image = Image.getInstance(contentByte, scaleImage(520, height, img), 1);

			PdfTemplate template = contentByte.createTemplate(width, height);
			image.setAbsolutePosition(0, 0);
			template.addImage(image);
			contentByte.addTemplate(template, 0, 100);
			d.close();

			if (xacNhan == JOptionPane.YES_OPTION)
				Desktop.getDesktop().open(new File(path));
			else {
				JOptionPane.showMessageDialog(this, "Xuất hóa đơn " + lbl_MaHoaDon_1.getText() + " Thành công");
			}
		} catch (IOException | DocumentException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Không thành công");
		}
		setVisible(false);
		dispose();
	}

	public BufferedImage scaleImage(int WIDTH, int HEIGHT, BufferedImage img) {
		BufferedImage bi = null;
		try {
			ImageIcon ii = new ImageIcon(img);
			bi = new BufferedImage(WIDTH + 210, HEIGHT - 73, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = (Graphics2D) bi.createGraphics();
			g2d.addRenderingHints(
					new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
			g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bi;
	}

	private void thanhToan() {
		double tienThua = -1;
		try {
			tienThua = Double.parseDouble(txtTienThua.getText().replaceAll(" VNĐ", "").replaceAll(",", ""));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (txtTienNhan.getText().trim().equals("") || tienThua < 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập tiền nhận từ khách hàng hoặc tiền thừa đang âm!!");
		} else {
			if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thanh toán hóa đơn này", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (kiemTra()) {

					// Update Phòng
					for (int row = 0; row < tblThanhToan.getRowCount(); row++) {
						String maPhong_Item = model.getValueAt(row, 1).toString();
						Enum_TrangThai trangThaiPhong = Enum_TrangThai.Trống;
						Phong phong = new Phong(maPhong_Item, trangThaiPhong);
						ph_dao.updatePhong(phong, maPhong_Item);
					}

					// Update lại hóa đơn
					String maHD = lbl_MaHoaDon_1.getText().trim();
					KhachHang kh = kh_dao.getKhachHangTheoSDT(lbl_sdtKH_1.getText().trim());
					String maKH = kh.getMaKhachHang();
					KhachHang kh_update = new KhachHang(maKH);
					String maNV = DataManager.getUserName();
					NhanVien nv = new NhanVien(maNV);
					java.sql.Date ngayLap = new java.sql.Date(System.currentTimeMillis());
					Boolean trangThai_ThanhToan = true;
					KhuyenMai km = null;
					KhuyenMai km2 = null;
					String maKhuyenMai = "";
					double tienKhachDua = Double.parseDouble(txtTienNhan.getText().trim());

					if (txtMaGiamGia.getText().trim().equals("")) {
						@SuppressWarnings("deprecation")
						java.sql.Date ngayCoDinh = new java.sql.Date(2020, 10, 10);
						km = new KhuyenMai("NULL", "NULL", ngayCoDinh, ngayCoDinh, 0);
						km_dao.addKhuyenMai(km);
						HoaDonDatPhong hd_update1 = new HoaDonDatPhong(maHD, kh_update, nv, ngayLap,
								trangThai_ThanhToan, km, tienKhachDua);
						hd_dao.updateHoaDon2(hd_update1);

					} else {
						maKhuyenMai = txtMaGiamGia.getText();
						km2 = new KhuyenMai(maKhuyenMai);
						HoaDonDatPhong hd_update2 = new HoaDonDatPhong(maHD, kh_update, nv, ngayLap,
								trangThai_ThanhToan, km2, tienKhachDua);
						hd_dao.updateHoaDon3(hd_update2);
					}

					// Update giờ trả, số giờ hát của chi tiết hóa đơn
					for (int row = 0; row < tblThanhToan.getRowCount(); row++) {
						tgHT = new Date();
						Timestamp ngayGioTraPhong = new Timestamp(tgHT.getTime());
						double thoiGianHat = Double.parseDouble(model.getValueAt(row, 2).toString());

						String maCT = lbl_MaHoaDon_1.getText().trim();
						String maPhong = model.getValueAt(row, 1).toString();

						Timestamp ngayGioNhanPhong = new Timestamp(tgHT.getTime()); // Giờ ảo

						HoaDonDatPhong hd = new HoaDonDatPhong(maCT);
						Phong ph = new Phong(maPhong);
						ChiTietHoaDon cthd_Item = new ChiTietHoaDon(hd, ph, ngayGioNhanPhong, ngayGioTraPhong,
								thoiGianHat);
						cthd_dao.UpdateChiTietHD_ChuyenPhong(cthd_Item);
					}

					JOptionPane.showMessageDialog(this, "Thanh Toán thành công");
					DataManager.setThanhToan(true);

					if (chckbx_XuatHoaDon.isSelected()) {
						inHoaDon(lbl_MaHoaDon_1.getText());
					}

					Window[] windows = Window.getWindows();
					for (Window window : windows) {
						if (window instanceof JDialog) {
							window.dispose();
						}
					}
				}
			}
		}
	}

	public boolean kiemTra() {
		String maKhuyenMai = txtMaGiamGia.getText().trim();
		KhuyenMai km = null;
		km = km_dao.getKhuyenMaiTheoMaKhuyenMai(maKhuyenMai);
		if (km != null) {
			DateFormat df_KM = new SimpleDateFormat("dd");
			date_HT = new Date();
			Double ngayHT = Double.parseDouble(df_KM.format(date_HT));
			Double ngayKM_BatDau = Double.parseDouble(df_KM.format(km.getNgayBatDau()));
			Double ngayKM_KetThuc = Double.parseDouble(df_KM.format(km.getNgayKetThuc()));
			if (ngayHT > ngayKM_KetThuc || ngayHT < ngayKM_BatDau) {
				JOptionPane.showMessageDialog(null, "Mã khuyến mãi không nằm trong thời gian khuyến mãi!!");
				txtMaGiamGia.setText("");
				return false;
			} else {
//				JOptionPane.showMessageDialog(this, "Thêm mã khuyến mãi thành công!!");
				DecimalFormat ddd = new DecimalFormat("#.#");
				lbl_TongThanhTien_1.setText(ddd.format((Double
						.parseDouble(lbl_TongThanhTien_1.getText().replaceAll(" VNĐ", "").replaceAll(",", ""))
						- Double.parseDouble(lbl_TongThanhTien_1.getText().replaceAll(" VNĐ", "").replaceAll(",", ""))
								* km.getPhanTramKhuyenMai()))
						+ " VNĐ");
				txtPhanTramKM.setText(km.getPhanTramKhuyenMai() + "");
				return true;
			}
		} else if (maKhuyenMai.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Không tồn tại mã khuyến mãi bạn vừa nhập!!");
			txtMaGiamGia.setText("");
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThanhToan)) {
			thanhToan();

		} else if (o.equals(btnQuayLai)) {
			setVisible(false);
		} else if (o.equals(btnKiemTra)) {
			kiemTra();
		}
	}
}
