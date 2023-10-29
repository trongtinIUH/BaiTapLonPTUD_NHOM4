package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import entity.DateLabelFormatter;

//import entity.DateLabelFormatter;

public class GD_HoaDon extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelOrderList, modelOrderDetail, modelServiceDetail;
	private JTable tableOrderList, tableOrderDetail, tableServiceDetail;
	private JScrollPane scrollOrderList, scrollOrderDetail, scrollServiceDetail;
	private String colOrderList[] = {"STT", "Mã hóa đơn", "Tên khách hàng","Mã nhân viên", 
	"Ngày lập hóa đơn", "Trạng thái", "Khuyến mãi", "Tổng tiền"};
	private String colOrderDetail[] = {"Mã hóa đơn", "Mã phòng", "Số giờ hát"};
	private String colServiceDetail[] = {"Mã hóa đơn", "Tên dịch vụ", "Đơn giá", "Số lượng"};
	private JLabel lblTitle, lblProfile, lblMaHD, lblMaKH, lblMaNV, lblNgayLapHD, lblTrangThai,
	lblKhuyenMai, lblTongTien, lblTimKiem, lblKeyword;
	private JButton btnXoa, btnSua, btnTimKiem, btnXuatDSHD;
	private JComboBox<String> cbTrangThai, cbTimKiem;
	private JTextField txtMaHD, txtMaKH, txtMaNV, txtKhuyenMai, txtTongTien, txtTimKiem;
	private SqlDateModel modelNgaylap;
	private Properties p;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	public GD_HoaDon() {
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
		pnOrderInfo.setBounds(10, 20, 705, 297);
		pnOrderInfo.add(lblMaHD = new JLabel("Mã hóa đơn"));
		lblMaHD.setFont(new Font("Arial", Font.BOLD, 18));
		lblMaHD.setBounds(10, 25, 160, 34);
		pnOrderInfo.add(txtMaHD = new JTextField(20));
		txtMaHD.setBounds(187, 25, 164, 34);
		txtMaHD.setFont(new Font("Arial", Font.PLAIN, 18));
		pnOrderInfo.add(lblMaKH = new JLabel("Mã khách hàng"));
		lblMaKH.setFont(new Font("Arial", Font.BOLD, 18));
		lblMaKH.setBounds(10, 77, 160, 34);
		pnOrderInfo.add(txtMaKH = new JTextField(20));
		txtMaKH.setBounds(187, 77, 164, 34);
		txtMaKH.setFont(new Font("Arial", Font.PLAIN, 18));
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
		cbTrangThai.setBounds(490, 25, 200, 34);
		cbTrangThai.setFont(new Font("Arial", Font.PLAIN, 18));
		pnOrderInfo.add(lblKhuyenMai = new JLabel("Khuyến mãi"));
		lblKhuyenMai.setFont(new Font("Arial", Font.BOLD, 18));
		lblKhuyenMai.setBounds(371, 77, 160, 34);
		pnOrderInfo.add(txtKhuyenMai = new JTextField(20));
		txtKhuyenMai.setBounds(490, 77, 164, 34);
		txtKhuyenMai.setFont(new Font("Arial", Font.PLAIN, 18));
		txtKhuyenMai.setHorizontalAlignment(JTextField.RIGHT);
		pnOrderInfo.add(lblTongTien = new JLabel("Tổng tiền"));
		lblTongTien.setFont(new Font("Arial", Font.BOLD, 18));
		lblTongTien.setBounds(371, 129, 160, 34);
		pnOrderInfo.add(txtTongTien = new JTextField(20));
		txtTongTien.setBounds(490, 129, 164, 34);
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
		pnSearch.setBounds(730, 20, 330, 297);
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
		cbTimKiem.addItem("Mã khách hàng");
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
		btnXuatDSHD.setBounds(730, 327, 330, 34);
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
		pnTableOrderList.setBounds(10, 396, 711, 270);
		modelOrderList = new DefaultTableModel(colOrderList,0);
		tableOrderList = new JTable(modelOrderList);
		tableOrderList.setSelectionBackground(Color.pink);
		tableOrderList.getTableHeader().setBackground(new Color(238, 233, 233));
		tableOrderList.getColumnModel().getColumn(0).setMaxWidth(50);
		tableOrderList.getColumnModel().getColumn(1).setMaxWidth(100);
		tableOrderList.getColumnModel().getColumn(2).setMaxWidth(100);
		tableOrderList.getColumnModel().getColumn(3).setMaxWidth(80);
		tableOrderList.getColumnModel().getColumn(4).setMaxWidth(100);
		tableOrderList.getColumnModel().getColumn(5).setMaxWidth(100);
		tableOrderList.getColumnModel().getColumn(6).setMaxWidth(80);
		tableOrderList.getColumnModel().getColumn(7).setMaxWidth(100);
		scrollOrderList = new JScrollPane(tableOrderList);
		scrollOrderList.setBounds(0,0,711,270);
		pnTableOrderList.add(scrollOrderList);
		pnContent.add(pnTableOrderList);
		
//		OrderDetail
		JLabel lblOrderDetail = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblOrderDetail.setForeground(Color.blue);
		lblOrderDetail.setFont(new Font("Arial", Font.BOLD, 25));
		lblOrderDetail.setBounds(730, 365, 400, 30);
		pnContent.add(lblOrderDetail);
		JPanel pnTableOrderDetail = new JPanel();
		pnTableOrderDetail.setLayout(null);
		pnTableOrderDetail.setBounds(730, 396, 325, 120);
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
		lblServiceDetail.setBounds(730, 516, 400, 30);
		pnContent.add(lblServiceDetail);
		JPanel pnTableServiceDetail = new JPanel();
		pnTableServiceDetail.setLayout(null);
		pnTableServiceDetail.setBounds(730, 546, 325, 120);
		modelServiceDetail = new DefaultTableModel(colServiceDetail,0);
		tableServiceDetail = new JTable(modelServiceDetail);
		tableServiceDetail.setSelectionBackground(Color.pink);
		tableServiceDetail.getTableHeader().setBackground(new Color(238, 233, 233));
		tableServiceDetail.getColumnModel().getColumn(0).setMaxWidth(100);
		tableServiceDetail.getColumnModel().getColumn(1).setMaxWidth(100);
		tableServiceDetail.getColumnModel().getColumn(2).setMaxWidth(100);
		tableServiceDetail.getColumnModel().getColumn(2).setMaxWidth(50);
		scrollServiceDetail = new JScrollPane(tableServiceDetail);
		scrollServiceDetail.setBounds(0,0,325,120);
		pnTableServiceDetail.add(scrollServiceDetail);
		pnContent.add(pnTableServiceDetail);
		btnSua.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXuatDSHD.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
