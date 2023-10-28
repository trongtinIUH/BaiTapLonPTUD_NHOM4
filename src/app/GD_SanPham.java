package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

public class GD_SanPham extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	Font font = new Font("Arial", Font.BOLD, 16); // khung tittle
	Font font2 = new Font("Arial", Font.BOLD, 18); // thuộc tính
	Font font3 = new Font("Arial", Font.PLAIN, 18); // jtexfield
	private String col[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Loại", "Ngày sản xuất", "Số lượng tồn",
			"Đơn vị tính", "Đơn giá", "Hình ảnh" };
	private JLabel lblTitle;
	private JTextField txtTimKiem;
	private JLabel lblTimKiem;
	private JComboBox<String> cbLoaiTimKiem;
	private JLabel lblLoaiTK;
	private JButton btnTimKiem;
	private JLabel lblMa;
	private JLabel lblTen;
	private JLabel lblDiaChi;
	private JLabel lblSDT;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private JButton btnXuatExcel;
	private JRadioButton radNam;
	private ButtonGroup grSex;
	private JRadioButton radNu;
	private JButton btnThem;
	private JLabel lblLoai;
	private JLabel lblNgaySX;
	private JLabel lblLoaiSP;
	private JComboBox<String> cbLoaiSanPham;
	private SqlDateModel modelNgaylap;
	private JDatePanelImpl datePanel;
	private Properties p;
	private JDatePickerImpl datePicker;
	private JTextField txtSoLuong;
	private JComboBox<String> cbDonViTinh;
	private JTextField txtDonGia;
	private JLabel lblSoLuong;
	private JLabel lblDonGia;
	private JLabel lblHinhAnh;

	public GD_SanPham() {
		setBackground(new Color(242, 240, 255));
		setLayout(null);

		JPanel pnNorth = new JPanel();
		pnNorth.setBounds(0, 0, 1078, 60);
		pnNorth.setLayout(null);
		pnNorth.setBackground(new Color(181, 230, 251));
		add(pnNorth);

		lblTitle = new JLabel("SẢN PHẨM");

		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);

		// Đặt kích thước và tọa độ cho lblTitle
		int labelWidth = 500; // Thay đổi kích thước theo ý muốn
		int labelHeight = 40; // Thay đổi kích thước theo ý muốn
		int labelX = (pnNorth.getWidth() - labelWidth) / 2; // Căn giữa theo chiều ngang
		int labelY = (pnNorth.getHeight() - labelHeight) / 2; // Căn giữa theo chiều dọc
		lblTitle.setBounds(labelX, labelY, labelWidth, labelHeight);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		pnNorth.add(lblTitle);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(null);
		pnlCenter.setBounds(0, 0, 1070, 380);
		pnlCenter.setBackground(getBackground());
		add(pnlCenter);

		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setLayout(null);
		pnlThongTin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Thông tin sản phẩm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),
				Color.blue));
		pnlThongTin.setBounds(7, 80, 690, 300);
		pnlThongTin.setBackground(Color.white);
		font = new Font("Arial", Font.BOLD, 14);

		JLabel lblMa = new JLabel("Mã sản phẩm");
		pnlThongTin.add(lblMa);
		lblMa.setBounds(20, 20, 150, 100);
		lblMa.setFont(font2);

		int x = 160, y = 55, w = 180, h = 28;
		JTextField txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setBounds(x, y, w, h);
		pnlThongTin.add(txtMa);
		txtMa.setHorizontalAlignment(JTextField.RIGHT);
		txtMa.setFont(font3);

		JLabel lblTen = new JLabel("Tên sản phẩm");
		lblTen.setBounds(20, 70, 130, 100);
		lblTen.setFont(font2);
		pnlThongTin.add(lblTen);

		JTextField txtTen = new JTextField();
		pnlThongTin.add(txtTen);
		y += 50;
		txtTen.setBounds(x, y, w, h);
		txtTen.setFont(font3);

		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setBounds(20, 120, 150, 100);
		lblSoLuong.setFont(font2);
		pnlThongTin.add(lblSoLuong);

		JTextField txtSoLuong = new JTextField();
		pnlThongTin.add(txtSoLuong);
		y += 50;
		txtSoLuong.setBounds(x, y, w - 95, h);
		txtSoLuong.setFont(font3);

		cbDonViTinh = new JComboBox<String>();
		cbDonViTinh.setFont(font);
		cbDonViTinh.setBounds(x + 95, y, 85, h);
		pnlThongTin.add(cbDonViTinh);

		JLabel lblDonGia = new JLabel("Đơn giá");
		lblDonGia.setBounds(20, 170, 100, 100);
		lblDonGia.setFont(font2);
		pnlThongTin.add(lblDonGia);

		JTextField txtDonGia = new JTextField();
		pnlThongTin.add(txtDonGia);
		y += 50;
		txtDonGia.setBounds(x, y, w, h);
		txtDonGia.setFont(font3);

		JLabel lblNgaySX = new JLabel("Ngày sản xuất");
		x = 380;
		y = 55;
		w = 100;
		h = 30;
		lblNgaySX.setBounds(x, y, w + 30, h);
		lblNgaySX.setFont(font2);
		pnlThongTin.add(lblNgaySX);

		modelNgaylap = new SqlDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(modelNgaylap, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		modelNgaylap.setSelected(true);
		datePicker.setBackground(new Color(255, 255, 255));
		datePicker.setBounds(x + 140, y, w + 50, h);
		pnlThongTin.add(datePicker);

		JLabel lblChucVu = new JLabel("Chức vụ");
		y += 50;
		lblChucVu.setBounds(x, y, w, h);
		lblChucVu.setFont(font2);
		pnlThongTin.add(lblChucVu);

		cbLoaiSanPham = new JComboBox<String>();
		cbLoaiSanPham.setFont(font3);
		cbLoaiSanPham.setBounds(x + 140, y, w + 50, h);
		cbLoaiSanPham.addItem("Nước ngọt");
		cbLoaiSanPham.addItem("Bia");
		cbLoaiSanPham.addItem("Đồ ăn");
		cbLoaiSanPham.addItem("Trái cây");
		pnlThongTin.add(cbLoaiSanPham);

		JLabel lblAnh = new JLabel("Ảnh");
		pnlThongTin.add(lblAnh);
		lblAnh.setFont(font2);
		y += 50;
		lblAnh.setBounds(x, y, w + 20, h);

		// Các nút
		pnlThongTin.add(btnThem = new JButton("THÊM", new ImageIcon("icon\\Add_icon.png")));
		btnThem.setFont(font);
		btnThem.setBounds(60, 250, 130, 35);
		btnThem.setBackground(new Color(109, 197, 112));
		pnlThongTin.add(btnXoa = new JButton("XÓA", new ImageIcon("icon\\Delete_icon.png")));
		btnXoa.setFont(font);
		btnXoa.setBounds(208, 250, 130, 35);
		btnXoa.setBackground(new Color(228, 50, 51));
		pnlThongTin.add(btnSua = new JButton("SỬA", new ImageIcon("icon\\Edit_icon.png")));
		btnSua.setFont(font);
		btnSua.setBounds(356, 250, 130, 35);
		btnSua.setBackground(new Color(74, 131, 215));
		pnlThongTin.add(btnLamMoi = new JButton("LÀM MỚI", new ImageIcon("icon\\Refresh_icon.png")));
		btnLamMoi.setFont(font);
		btnLamMoi.setBounds(504, 250, 130, 35);
		btnLamMoi.setBackground(new Color(104, 211, 211));
		pnlCenter.add(pnlThongTin);

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setLayout(null);
		pnlTimKiem.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Tìm kiếm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16), Color.blue));
		pnlTimKiem.setBounds(707, 80, 364, 300);
		pnlTimKiem.setBackground(Color.white);

		JLabel lblLoaiTim = new JLabel("Tìm kiếm theo");
		lblLoaiTim.setFont(font2);
		pnlTimKiem.add(lblLoaiTim);
		lblLoaiTim.setBounds(30, 55, 130, 30);

		cbLoaiTimKiem = new JComboBox<String>();
		cbLoaiTimKiem.setFont(font3);
		cbLoaiTimKiem.setBounds(170, 55, 170, 30);
		cbLoaiTimKiem.addItem("Mã sản phẩm");
		cbLoaiTimKiem.addItem("Tên sản phẩm");
		cbLoaiTimKiem.addItem("Loại sản phẩm");
		pnlTimKiem.add(cbLoaiTimKiem);

		JLabel lblTuKhoaTim = new JLabel("Nhập từ khóa tìm kiếm");
		lblTuKhoaTim.setFont(font2);
		pnlTimKiem.add(lblTuKhoaTim);
		lblTuKhoaTim.setBounds(30, 105, 300, 30);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(font3);
		txtTimKiem.setBounds(30, 160, 310, 30);
		pnlTimKiem.add(txtTimKiem);

		btnTimKiem = new JButton("Tìm kiếm", new ImageIcon("icon\\Research_icon.png"));
		btnTimKiem.setFont(font);
		btnTimKiem.setBounds(112, 250, 140, 35);
		btnTimKiem.setBackground(new Color(238, 233, 233));
		pnlTimKiem.add(btnTimKiem);
		pnlCenter.add(pnlTimKiem);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(null);
		pnCenter.setBackground(new Color(246, 245, 255));
		pnCenter.setBounds(0, 380, 1078, 500);

		JLabel lblBang = new JLabel("DANH SÁCH SẢN PHẨM");
		lblBang.setFont(new Font("Arial", Font.BOLD, 20));
		pnCenter.add(lblBang);
		lblBang.setForeground(Color.blue);
		lblBang.setBounds(20, 15, 500, 30);

		pnCenter.add(btnXuatExcel = new JButton("Xuất danh sách sản phẩm", new ImageIcon("icon\\Excel_icon.png")));
		btnXuatExcel.setFont(font);
		btnXuatExcel.setBounds(798, 14, 270, 30);
		add(pnCenter);

		model = new DefaultTableModel(col, 0);
		table = new JTable(model);
		table.setSelectionBackground(Color.pink);
		table.getTableHeader().setBackground(new Color(238, 233, 233));
		table.getColumnModel().getColumn(0).setMaxWidth(60);
		scroll = new JScrollPane(table);
		scroll.setBounds(9, 50, 1060, 290);
		pnCenter.add(scroll);

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnXuatExcel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnThem)) {

		} else if (obj.equals(btnXoa)) {

		} else if (obj.equals(btnSua)) {

		} else if (obj.equals(btnLamMoi)) {

		} else if (obj.equals(btnTimKiem)) {

		} else if (obj.equals(btnLamMoi)) {

		}
	}
}
