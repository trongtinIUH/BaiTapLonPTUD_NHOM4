package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import dao.ChiTietDichVu_dao;
import dao.ChiTietHoaDon_dao;
import dao.HoaDon_dao;
import dao.KhachHang_dao;
import dao.KhuyenMai_dao;
import dao.Phong_dao;
import dao.SanPham_dao;
import entity.ChiTietDichVu;
import entity.ChiTietHoaDon;
import entity.DateLabelFormatter;
import entity.HoaDonDatPhong;



public class GD_HoaDon extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelOrderList, modelOrderDetail, modelServiceDetail;
	private JTable tableOrderList, tableOrderDetail, tableServiceDetail;
	private JScrollPane scrollOrderList, scrollOrderDetail, scrollServiceDetail;
	private String colOrderList[] = {"STT", "Mã hóa đơn", "Tên khách hàng","Mã nhân viên", 
	"Ngày lập hóa đơn", "Trạng thái", "Mã khuyến mãi", "Tổng tiền"};
	private String colOrderDetail[] = {"Mã hóa đơn", "Mã phòng", "Số giờ hát"};
	private String colServiceDetail[] = {"Mã hóa đơn", "Tên dịch vụ", "Đơn giá", "Số lượng"};
	private JLabel lblTitle, lblProfile, lblMaHD, lblTenKH, lblMaNV, lblNgayLapHD, lblTrangThai,
	lblKhuyenMai, lblTongTien, lblTimKiem, lblKeyword;
	private JButton btnXoa, btnSua, btnTimKiem, btnXuatDSHD;
	private JComboBox<String> cbTrangThai, cbTimKiem;
	private JTextField txtMaHD, txtTenKH, txtMaNV, txtKhuyenMai, txtTongTien, txtTimKiem;
	private SqlDateModel modelNgaylap;
	private Properties p;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private HoaDon_dao hoadon_dao;
	private KhachHang_dao khachhang_dao;
	private Phong_dao phong_dao;
	private ChiTietDichVu_dao chitietdichvu_dao;
	private KhuyenMai_dao khuyenmai_dao;
	private ChiTietHoaDon_dao chitiethoadon_dao;
	private SanPham_dao sanpham_dao;
	private XSSFWorkbook wordbook;
	public GD_HoaDon() {
		hoadon_dao = new HoaDon_dao();
		khachhang_dao = new KhachHang_dao();
		phong_dao = new Phong_dao();
		chitietdichvu_dao = new ChiTietDichVu_dao();
		khuyenmai_dao = new KhuyenMai_dao();
		chitiethoadon_dao = new ChiTietHoaDon_dao();
		sanpham_dao = new SanPham_dao();
		setBackground(Color.decode("#FAFAFF"));
		setLayout(null);
//		Styling header
		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(Color.decode("#B5E6FB"));
		pnNorth.setBounds(0, 0, 1080, 60);
		pnNorth.setLayout(null);
		lblTitle = new JLabel("Hóa Đơn");
		lblTitle.setBounds(501, 15, 200, 30);
		lblTitle.setForeground(Color.blue);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		pnNorth.add(lblTitle);
		lblProfile = new JLabel("");
		lblProfile.setBackground(new Color(255, 165, 0));
		lblProfile.setIcon(new ImageIcon("icon\\icon_profile.png"));
		lblProfile.setBounds(1020, 7, 45, 45);
		ImageIcon iconProfile = new ImageIcon("icon\\icon_profile.png");
		iconProfile = new ImageIcon(iconProfile.getImage().getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH));
		lblProfile.setIcon(iconProfile);
		pnNorth.add(lblProfile);
		add(pnNorth);
		
//		Styling Content
//		Styling Info
		JPanel pnContent = new JPanel();
		pnContent.setBackground(Color.decode("#F4F2FF"));
		pnContent.setBounds(0, 60, 1080, 706);
		pnContent.setLayout(null);
		JPanel pnOrderInfo = new JPanel();
		pnOrderInfo.setLayout(null);
		pnOrderInfo.setBorder(BorderFactory.createTitledBorder(
			    BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), 
			    "Thông tin hóa đơn",
			    TitledBorder.LEFT,
			    TitledBorder.DEFAULT_POSITION, 
			    new Font("Arial", Font.BOLD, 16), 
			    Color.blue)
			);
		pnOrderInfo.setBackground(Color.white);
		pnOrderInfo.setBounds(10, 20, 720, 297);
		pnOrderInfo.add(lblMaHD = new JLabel("Mã hóa đơn"));
		lblMaHD.setFont(new Font("Arial", Font.BOLD, 18));
		lblMaHD.setBounds(10, 25, 160, 34);
		pnOrderInfo.add(txtMaHD = new JTextField(20));
		txtMaHD.setBounds(187, 25, 164, 34);
		txtMaHD.setEditable(false);
		txtMaHD.setFont(new Font("Arial", Font.PLAIN, 18));
		pnOrderInfo.add(lblTenKH = new JLabel("Tên khách hàng"));
		lblTenKH.setFont(new Font("Arial", Font.BOLD, 18));
		lblTenKH.setBounds(10, 77, 160, 34);
		pnOrderInfo.add(txtTenKH = new JTextField(20));
		txtTenKH.setBounds(187, 77, 164, 34);
		txtTenKH.setFont(new Font("Arial", Font.PLAIN, 18));
		pnOrderInfo.add(lblMaNV = new JLabel("Mã nhân viên"));
		lblMaNV.setFont(new Font("Arial", Font.BOLD, 18));
		lblMaNV.setBounds(10, 129, 160, 34);
		pnOrderInfo.add(txtMaNV = new JTextField(20));
		txtMaNV.setBounds(187, 129, 164, 34);
		txtMaNV.setFont(new Font("Arial", Font.PLAIN, 18));
		txtMaNV.setHorizontalAlignment(JTextField.RIGHT);
		pnOrderInfo.add(lblNgayLapHD = new JLabel("Ngày lập hóa đơn"));
		lblNgayLapHD.setFont(new Font("Arial", Font.BOLD, 18));
		lblNgayLapHD.setBounds(10, 181, 170, 34);
		modelNgaylap = new SqlDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(modelNgaylap, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(187, 185, 164, 34);
		datePicker.setPreferredSize(new Dimension(164, 34));
		datePicker.setBackground(Color.white);
		datePicker.setToolTipText("Chọn ngày lập hóa đơn");
		modelNgaylap.setDate(2023, 26, 10);
		modelNgaylap.setSelected(true);
		pnOrderInfo.add(datePicker);
		pnContent.add(pnOrderInfo);
		add(pnContent);
		
		pnOrderInfo.add(lblTrangThai = new JLabel("Trạng thái"));
		lblTrangThai.setFont(new Font("Arial", Font.BOLD, 18));
		lblTrangThai.setBounds(371, 25, 160, 34);
		pnOrderInfo.add(cbTrangThai = new JComboBox<String>());
		cbTrangThai.addItem("Đã thanh toán");
		cbTrangThai.addItem("Chưa thanh toán");
		cbTrangThai.setBounds(510, 25, 200, 34);
		cbTrangThai.setFont(new Font("Arial", Font.PLAIN, 18));
		pnOrderInfo.add(lblKhuyenMai = new JLabel("Mã khuyến mãi"));
		lblKhuyenMai.setFont(new Font("Arial", Font.BOLD, 18));
		lblKhuyenMai.setBounds(371, 77, 160, 34);
		pnOrderInfo.add(txtKhuyenMai = new JTextField(20));
		txtKhuyenMai.setBounds(510, 77, 164, 34);
		txtKhuyenMai.setEditable(false);
		txtKhuyenMai.setFont(new Font("Arial", Font.PLAIN, 18));
		pnOrderInfo.add(lblTongTien = new JLabel("Tổng tiền"));
		lblTongTien.setFont(new Font("Arial", Font.BOLD, 18));
		lblTongTien.setBounds(371, 129, 160, 34);
		pnOrderInfo.add(txtTongTien = new JTextField(20));
		txtTongTien.setBounds(510, 129, 164, 34);
		txtTongTien.setEditable(false);
		txtTongTien.setFont(new Font("Arial", Font.PLAIN, 18));
		txtTongTien.setHorizontalAlignment(JTextField.RIGHT);
		
		pnOrderInfo.add(btnXoa = new JButton("Xóa"));
		btnXoa.setBounds(190, 237, 140, 40);
		btnXoa.setBackground(Color.decode("#EE1919"));
		btnXoa.setForeground(Color.white);
		btnXoa.setFont(new Font("Arial", Font.BOLD, 18));
		btnXoa.setIcon(new ImageIcon("icon\\Delete_icon.png"));
		btnXoa.setHorizontalTextPosition(SwingConstants.RIGHT); 
		btnXoa.setIconTextGap(18);
		
		pnOrderInfo.add(btnSua = new JButton("Sửa"));
		btnSua.setBounds(350, 237, 140, 40);
		btnSua.setBackground(Color.decode("#4A83D7"));
		btnSua.setForeground(Color.white);
		btnSua.setFont(new Font("Arial", Font.BOLD, 18));
		btnSua.setIcon(new ImageIcon("icon\\Edit_icon.png"));
		btnSua.setHorizontalTextPosition(SwingConstants.RIGHT); 
		btnSua.setIconTextGap(18);
		
		JPanel pnSearch = new JPanel();
		pnSearch.setBounds(740, 20, 330, 297);
		pnSearch.setLayout(null);
		pnSearch.setBorder(BorderFactory.createTitledBorder(
			    BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), 
			    "Tìm kiếm",
			    TitledBorder.LEFT,
			    TitledBorder.DEFAULT_POSITION, 
			    new Font("Arial", Font.BOLD, 16), 
			    Color.blue)
			);
		pnSearch.setBackground(Color.white);
		pnSearch.add(lblTimKiem = new JLabel("Tìm kiếm theo"));
		lblTimKiem.setFont(new Font("Arial", Font.BOLD, 18));
		lblTimKiem.setBounds(15, 30, 150, 30);
		pnSearch.add(cbTimKiem = new JComboBox<String>());
		cbTimKiem.addItem("Mã hóa đơn");
		cbTimKiem.addItem("Tên khách hàng");
		cbTimKiem.addItem("Mã nhân viên");
		cbTimKiem.addItem("Ngày lập");
		cbTimKiem.setBounds(150, 30, 170, 30);
		cbTimKiem.setFont(new Font("Arial", Font.BOLD, 18));
		pnSearch.add(lblKeyword = new JLabel("Nhập từ khóa tìm kiếm"));
		lblKeyword.setFont(new Font("Arial", Font.BOLD, 18));
		lblKeyword.setBounds(15, 90, 250, 30);
		pnSearch.add(txtTimKiem = new JTextField(20));
		txtTimKiem.setFont(new Font("Arial", Font.PLAIN, 18));
		txtTimKiem.setBounds(15, 150, 300, 30);
		pnSearch.add(btnTimKiem = new JButton("Tìm kiếm"));
		btnTimKiem.setBounds(100, 220, 160, 40);
		btnTimKiem.setBackground(Color.decode("#0D99FF"));
		btnTimKiem.setForeground(Color.white);
		btnTimKiem.setFont(new Font("Arial", Font.BOLD, 18));
		btnTimKiem.setIcon(new ImageIcon("icon\\Research_icon.png"));
		btnTimKiem.setHorizontalTextPosition(SwingConstants.RIGHT); 
		btnTimKiem.setIconTextGap(18);
		pnContent.add(pnSearch);

		pnContent.add(btnXuatDSHD = new JButton("XUẤT DANH SÁCH HÓA ĐƠN"));
		btnXuatDSHD.setBounds(740, 327, 330, 34);
		btnXuatDSHD.setBackground(Color.decode("#FBB5B5"));
		btnXuatDSHD.setForeground(Color.white);
		btnXuatDSHD.setFont(new Font("Arial", Font.BOLD, 16));
		btnXuatDSHD.setIcon(new ImageIcon("icon\\Excel_icon.png"));
		btnXuatDSHD.setHorizontalTextPosition(SwingConstants.RIGHT); 
		btnXuatDSHD.setIconTextGap(10);
		
//		Styling List
		
//		OrderList
		JLabel lblListOrder = new JLabel("DANH SÁCH HÓA ĐƠN");
		lblListOrder.setForeground(Color.blue);
		lblListOrder.setFont(new Font("Arial", Font.BOLD, 25));
		lblListOrder.setBounds(10, 365, 400, 30);
		pnContent.add(lblListOrder);
		JPanel pnTableOrderList = new JPanel();
		pnTableOrderList.setLayout(null);
		pnTableOrderList.setBounds(10, 396, 720, 270);
		modelOrderList = new DefaultTableModel(colOrderList,0);
		tableOrderList = new JTable(modelOrderList);
		tableOrderList.setSelectionBackground(Color.pink);
		tableOrderList.getTableHeader().setBackground(new Color(238, 233, 233));
		tableOrderList.getColumnModel().getColumn(0).setMaxWidth(40);
		tableOrderList.getColumnModel().getColumn(1).setMaxWidth(90);
		tableOrderList.getColumnModel().getColumn(2).setMaxWidth(130);
		tableOrderList.getColumnModel().getColumn(3).setMaxWidth(80);
		tableOrderList.getColumnModel().getColumn(4).setMaxWidth(100);
		tableOrderList.getColumnModel().getColumn(5).setMaxWidth(90);
		tableOrderList.getColumnModel().getColumn(6).setMaxWidth(89);
		tableOrderList.getColumnModel().getColumn(7).setMaxWidth(100);
		scrollOrderList = new JScrollPane(tableOrderList);
		scrollOrderList.setBounds(0,0,720,270);
		pnTableOrderList.add(scrollOrderList);
		pnContent.add(pnTableOrderList);
		
//		OrderDetail
		JLabel lblOrderDetail = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblOrderDetail.setForeground(Color.blue);
		lblOrderDetail.setFont(new Font("Arial", Font.BOLD, 25));
		lblOrderDetail.setBounds(740, 365, 400, 30);
		pnContent.add(lblOrderDetail);
		JPanel pnTableOrderDetail = new JPanel();
		pnTableOrderDetail.setLayout(null);
		pnTableOrderDetail.setBounds(740, 396, 325, 120);
		modelOrderDetail = new DefaultTableModel(colOrderDetail,0);
		tableOrderDetail = new JTable(modelOrderDetail);
		tableOrderDetail.setSelectionBackground(Color.pink);
		tableOrderDetail.getTableHeader().setBackground(new Color(238, 233, 233));
		tableOrderDetail.getColumnModel().getColumn(0).setMaxWidth(150);
		tableOrderDetail.getColumnModel().getColumn(1).setMaxWidth(100);
		tableOrderDetail.getColumnModel().getColumn(2).setMaxWidth(100);
		scrollOrderDetail = new JScrollPane(tableOrderDetail);
		scrollOrderDetail.setBounds(0,0,325,120);
		pnTableOrderDetail.add(scrollOrderDetail);
		pnContent.add(pnTableOrderDetail);
		
//		ServiceDetail
		JLabel lblServiceDetail = new JLabel("CHI TIẾT DỊCH VỤ");
		lblServiceDetail.setForeground(Color.blue);
		lblServiceDetail.setFont(new Font("Arial", Font.BOLD, 25));
		lblServiceDetail.setBounds(740, 516, 400, 30);
		pnContent.add(lblServiceDetail);
		JPanel pnTableServiceDetail = new JPanel();
		pnTableServiceDetail.setLayout(null);
		pnTableServiceDetail.setBounds(740, 546, 325, 120);
		modelServiceDetail = new DefaultTableModel(colServiceDetail,0);
		tableServiceDetail = new JTable(modelServiceDetail);
		tableServiceDetail.setSelectionBackground(Color.pink);
		tableServiceDetail.getTableHeader().setBackground(new Color(238, 233, 233));
		tableServiceDetail.getColumnModel().getColumn(0).setMaxWidth(100);
		tableServiceDetail.getColumnModel().getColumn(1).setMaxWidth(100);
		tableServiceDetail.getColumnModel().getColumn(2).setMaxWidth(100);
		tableServiceDetail.getColumnModel().getColumn(3).setMaxWidth(50);
		scrollServiceDetail = new JScrollPane(tableServiceDetail);
		scrollServiceDetail.setBounds(0,0,325,120);
		pnTableServiceDetail.add(scrollServiceDetail);
		pnContent.add(pnTableServiceDetail);
		btnSua.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXuatDSHD.addActionListener(this);
		loadOrderListData();
		tableOrderList.addMouseListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnTimKiem)) {
			tim();
		} else if(obj.equals(btnXuatDSHD)) {
			xuatExcel();
		} else if(obj.equals(btnSua)) {
			sua();
		} else if(obj.equals(btnXoa)) {
			xoa();
		}
	}
	
	public void clearTableOrderList() {
		while (tableOrderList.getRowCount() > 0) {
			modelOrderList.removeRow(0);
		}
	}
	public void clearTableOrderDetail() {
		modelOrderDetail.setRowCount(0);
	}
	public void clearTableServiceDetail() {
		modelServiceDetail.setRowCount(0);
	}
	
	public void loadOrderDetailData(String maHD) {
		for (ChiTietHoaDon cthd : chitiethoadon_dao.getChiTietHoaDonTheoMaHD(maHD)) {
			Object[] row = {cthd.getHoaDon().getMaHoaDon(), cthd.getPhong().getMaPhong(),
			cthd.getSoGioHat()};
			modelOrderDetail.addRow(row);
		}
	}
	
	public void loadServiceDetailData(String maHD) {
		for (ChiTietDichVu ctdv : chitietdichvu_dao.getChiTietDichVuTheoMaHD(maHD)) {
			Object[] row = { ctdv.getHoaDon().getMaHoaDon(), 
			sanpham_dao.getSanPhamTheoMaSP(ctdv.getSanPham().getMaSanPham()).getTenSanPham(),
			ctdv.getGia(), ctdv.getSoLuong()};
			modelServiceDetail.addRow(row);
		}
	}
	
	public void sua() {
		if (tableOrderList.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để sửa!");
		} else if (tableOrderList.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 Sản phẩm để sửa!");
		} else {
			String maHD = txtMaHD.getText().trim();
			Date ngayLapHD = (Date) datePicker.getModel().getValue();
			String trangThai = (String) cbTrangThai.getSelectedItem();
			Boolean status = false;
			if(trangThai.equals("Đã thanh toán")) {
				status = true;
			}
			if(trangThai.equals("Chưa thanh toán")) {
				status = false;
			}
			String maNV = txtMaNV.getText().trim();
			if (hoadon_dao.updateHoaDon(maHD, ngayLapHD, status, maNV)) {
				clearTableOrderList();
				loadOrderListData();
				JOptionPane.showMessageDialog(null, "Sửa thành công!");
			}
		}
	}
	
	public void xoa() {
		if (tableOrderList.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa!");
		} else if (tableOrderList.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 Sản phẩm để xóa!");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa Sản phẩm này không?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int row = tableOrderList.getSelectedRow();
				hoadon_dao.deleteHoaDon(modelOrderList.getValueAt(row, 1).toString());
				modelOrderList.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa thành công!");
			}
		}
	}
	
	public void tim() {
		String searchTitle = txtTimKiem.getText();
		if(searchTitle.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập vào từ khóa tìm kiếm!");
		} else {
			if (btnTimKiem.getText().equals("Tìm kiếm")) {
				if (cbTimKiem.getSelectedItem().equals("Mã hóa đơn")) {
					ArrayList<HoaDonDatPhong> dsHoaDonMaHD = hoadon_dao.getHoaDonDatPhongTheoMaHD(searchTitle);
					if(!dsHoaDonMaHD.isEmpty()) {
						btnTimKiem.setText("Hủy tìm");
						int i = 0;
						clearTableOrderList();
						for(HoaDonDatPhong hd : dsHoaDonMaHD) {
							i++;
							Object[] row = { i, hd.getMaHoaDon(), 
							khachhang_dao.getKhachHangTheoMaKH(hd.getKhachHang().getMaKhachHang()).getHoTen(), 
							hd.getNhanVien().getMaNhanVien(), hd.getNgayLapHoaDon(), 
							hd.isTrangThai() ? "Đã thanh toán" : "Chưa thanh toán", 
							hd.getKhuyenMai().getMaKhuyenMai(),
							hd.tinhTongTienThanhToan(phong_dao.tinhTongTienPhongTheoMaHoaDon(hd.getMaHoaDon()), 
							chitietdichvu_dao.tinhTongTienDVTheoMaHoaDon(hd.getMaHoaDon()), 
							khuyenmai_dao.getPhanTramKhuyenMaiTheoMaKM(hd.getKhuyenMai().getMaKhuyenMai())
							)
							};
							modelOrderList.addRow(row);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn!");
					}
				} else if (cbTimKiem.getSelectedItem().equals("Tên khách hàng")) {
					ArrayList<HoaDonDatPhong> dsHoaDonTenKH = hoadon_dao.getHoaDonDatPhongTheoTenKH(searchTitle);
					if(!dsHoaDonTenKH.isEmpty()) {
						btnTimKiem.setText("Hủy tìm");
						int i = 0;
						clearTableOrderList();
						for(HoaDonDatPhong hd : dsHoaDonTenKH) {
							i++;
							Object[] row = { i, hd.getMaHoaDon(), 
							khachhang_dao.getKhachHangTheoMaKH(hd.getKhachHang().getMaKhachHang()).getHoTen(), 
							hd.getNhanVien().getMaNhanVien(), hd.getNgayLapHoaDon(), 
							hd.isTrangThai() ? "Đã thanh toán" : "Chưa thanh toán", 
							hd.getKhuyenMai().getMaKhuyenMai(),
							hd.tinhTongTienThanhToan(phong_dao.tinhTongTienPhongTheoMaHoaDon(hd.getMaHoaDon()), 
							chitietdichvu_dao.tinhTongTienDVTheoMaHoaDon(hd.getMaHoaDon()), 
							khuyenmai_dao.getPhanTramKhuyenMaiTheoMaKM(hd.getKhuyenMai().getMaKhuyenMai())
							)
							};
							modelOrderList.addRow(row);
						}
					} else JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn!");
				} else if (cbTimKiem.getSelectedItem().equals("Mã nhân viên")) { 
					ArrayList<HoaDonDatPhong> dsHoaDonMaNV = hoadon_dao.getHoaDonDatPhongTheoMaNV(searchTitle);
					if(!dsHoaDonMaNV.isEmpty()) {
						btnTimKiem.setText("Hủy tìm");
						int i = 0;
						clearTableOrderList();
						for(HoaDonDatPhong hd : dsHoaDonMaNV) {
							i++;
							Object[] row = { i, hd.getMaHoaDon(), 
							khachhang_dao.getKhachHangTheoMaKH(hd.getKhachHang().getMaKhachHang()).getHoTen(), 
							hd.getNhanVien().getMaNhanVien(), hd.getNgayLapHoaDon(), 
							hd.isTrangThai() ? "Đã thanh toán" : "Chưa thanh toán", 
							hd.getKhuyenMai().getMaKhuyenMai(),
							hd.tinhTongTienThanhToan(phong_dao.tinhTongTienPhongTheoMaHoaDon(hd.getMaHoaDon()), 
							chitietdichvu_dao.tinhTongTienDVTheoMaHoaDon(hd.getMaHoaDon()), 
							khuyenmai_dao.getPhanTramKhuyenMaiTheoMaKM(hd.getKhuyenMai().getMaKhuyenMai())
							)
							};
							modelOrderList.addRow(row);
						}
					} else JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn!");
				} else if (cbTimKiem.getSelectedItem().equals("Ngày lập")) {
					ArrayList<HoaDonDatPhong> dsHoaDonNgayLap = hoadon_dao.getHoaDonTheoNgayLapHD(searchTitle);
					if(!dsHoaDonNgayLap.isEmpty()) {
						btnTimKiem.setText("Hủy tìm");
						int i = 0;
						clearTableOrderList();
						for(HoaDonDatPhong hd : dsHoaDonNgayLap) {
							i++;
							Object[] row = { i, hd.getMaHoaDon(), 
							khachhang_dao.getKhachHangTheoMaKH(hd.getKhachHang().getMaKhachHang()).getHoTen(), 
							hd.getNhanVien().getMaNhanVien(), hd.getNgayLapHoaDon(), 
							hd.isTrangThai() ? "Đã thanh toán" : "Chưa thanh toán", 
							hd.getKhuyenMai().getMaKhuyenMai(),
							hd.tinhTongTienThanhToan(phong_dao.tinhTongTienPhongTheoMaHoaDon(hd.getMaHoaDon()), 
							chitietdichvu_dao.tinhTongTienDVTheoMaHoaDon(hd.getMaHoaDon()), 
							khuyenmai_dao.getPhanTramKhuyenMaiTheoMaKM(hd.getKhuyenMai().getMaKhuyenMai())
							)
							};
							modelOrderList.addRow(row);
						}
					} else JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn!");
				}
			} else {
				clearTableOrderList();
				loadOrderListData();
				btnTimKiem.setText("Tìm kiếm");
			}
		}
	}
	
	public void xuatExcel() {
		try {
			wordbook = new XSSFWorkbook();
			XSSFSheet sheet = wordbook.createSheet("Danh sách Hóa đơn");

			XSSFRow row = null;
			Cell cell = null;
			row = sheet.createRow(2);// Tạo 2 dòng trống trong excel
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue("STT");
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("Mã hóa đơn");
			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue("Tên khách hàng");
			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue("Mã nhân viên");
			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue("Ngày lập hóa đơn");
			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue("Trạng thái");
			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue("Mã khuyến mãi");
			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("Tổng tiền");

			for (int i = 0; i < hoadon_dao.getAllHoaDonDatPhong().size(); i++) {
				row = sheet.createRow(3 + i); // Bỏ qua 2 dòng trống

				cell = row.createCell(0, CellType.NUMERIC);
				cell.setCellValue(i + 1);
				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue(hoadon_dao.getAllHoaDonDatPhong().get(i).getMaHoaDon());
				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue(khachhang_dao.getKhachHangTheoMaKH(hoadon_dao.getAllHoaDonDatPhong().get(i).getKhachHang().getMaKhachHang()).getHoTen());
				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue(hoadon_dao.getAllHoaDonDatPhong().get(i).getNhanVien().getMaNhanVien());
				
				cell = row.createCell(4, CellType.STRING);
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String ngay = df.format(hoadon_dao.getAllHoaDonDatPhong().get(i).getNgayLapHoaDon());
				cell.setCellValue(ngay);
				
				cell = row.createCell(5, CellType.STRING);
				cell.setCellValue(hoadon_dao.getAllHoaDonDatPhong().get(i).isTrangThai() ? "Đã thanh toán" : "Chưa thanh toán");
				cell = row.createCell(6, CellType.STRING);
				cell.setCellValue(hoadon_dao.getAllHoaDonDatPhong().get(i).getKhuyenMai().getMaKhuyenMai());
				cell = row.createCell(7, CellType.NUMERIC);
				cell.setCellValue(hoadon_dao.getAllHoaDonDatPhong().get(i).tinhTongTienThanhToan(phong_dao.tinhTongTienPhongTheoMaHoaDon(hoadon_dao.getAllHoaDonDatPhong().get(i).getMaHoaDon()), 
						chitietdichvu_dao.tinhTongTienDVTheoMaHoaDon(hoadon_dao.getAllHoaDonDatPhong().get(i).getMaHoaDon()), 
						khuyenmai_dao.getPhanTramKhuyenMaiTheoMaKM(hoadon_dao.getAllHoaDonDatPhong().get(i).getKhuyenMai().getMaKhuyenMai())
						));

			}

			File file = new File("D:\\BaiTapLonPTUD_NHOM4\\LuuFile_Excel\\DanhSachHoaDon.xlsx");
			try {
				FileOutputStream file_out = new FileOutputStream(file);
				wordbook.write(file_out);
				file_out.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			JOptionPane.showMessageDialog(this, "In file danh sách thành công!!");
		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Không in được");
		}
	}
	
	public void loadOrderListData() {
		int i = 0;
		for (HoaDonDatPhong hd : hoadon_dao.getAllHoaDonDatPhong()) {
			i++;
			Object[] row = { i, hd.getMaHoaDon(), 
			khachhang_dao.getKhachHangTheoMaKH(hd.getKhachHang().getMaKhachHang()).getHoTen(), 
			hd.getNhanVien().getMaNhanVien(), hd.getNgayLapHoaDon(), 
			hd.isTrangThai() ? "Đã thanh toán" : "Chưa thanh toán", 
			hd.getKhuyenMai().getMaKhuyenMai(),
			hd.tinhTongTienThanhToan(phong_dao.tinhTongTienPhongTheoMaHoaDon(hd.getMaHoaDon()), 
			chitietdichvu_dao.tinhTongTienDVTheoMaHoaDon(hd.getMaHoaDon()), 
			khuyenmai_dao.getPhanTramKhuyenMaiTheoMaKM(hd.getKhuyenMai().getMaKhuyenMai())
			)
			};
			modelOrderList.addRow(row);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableOrderList.getSelectedRow();
		if(row >= 0) {
			txtMaHD.setText(modelOrderList.getValueAt(row, 1).toString());
			txtTenKH.setText(modelOrderList.getValueAt(row, 2).toString());
			txtMaNV.setText(modelOrderList.getValueAt(row, 3).toString());
			try {
				modelNgaylap.setValue((java.sql.Date) modelOrderList.getValueAt(row, 4));
			} catch (Exception e2) {
				// TODO: handle exception
			}
			cbTrangThai.setSelectedItem(modelOrderList.getValueAt(row, 5));
			txtKhuyenMai.setText(modelOrderList.getValueAt(row, 6).toString());
			txtTongTien.setText(modelOrderList.getValueAt(row, 7).toString());
		}
		clearTableOrderDetail(); 
		clearTableServiceDetail();
		loadOrderDetailData(modelOrderList.getValueAt(row, 1).toString());
		loadServiceDetailData(modelOrderList.getValueAt(row, 1).toString());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
