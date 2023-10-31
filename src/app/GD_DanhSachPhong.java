package app;

import java.awt.Color;
import java.awt.Font;
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

public class GD_DanhSachPhong extends JPanel {
	Font font = new Font("Arial", Font.BOLD, 16); // khung tittle
	Font font2 = new Font("Arial", Font.BOLD, 18); // thuộc tính
	Font font3 = new Font("Arial", Font.PLAIN, 18); // jtexfield
	private String col[] = { "STT", "Mã phòng", "Loại phòng", "Trạng thái", "Sức chứa", "Đơn giá" };
	private JPanel pnNorth;
	private JLabel lblTitle;
	private JComboBox<String> cbLoaiTim;
	private JTextField txtTuKhoaTim;
	private JButton btnTimKiem;
	private JButton btnXuatExcel;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private JComboBox<String> cbLoaiPhong;
	private JComboBox<String> cbTrangThai;
	private JTextField txtSucChua;
	private JTextField txtDonGia;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;

	public GD_DanhSachPhong() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);

		pnNorth = new JPanel();
		pnNorth.setLayout(null);
		pnNorth.setBounds(0, 0, 1078, 60);
		pnNorth.setBackground(new Color(187, 231, 252));
		add(pnNorth);
		lblTitle = new JLabel("PHÒNG");
		pnNorth.add(lblTitle);

		// căn giữa title
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);

		// Đặt kích thước và tọa độ cho lblTitle
		int labelWidth = 500; // Thay đổi kích thước theo ý muốn
		int labelHeight = 40; // Thay đổi kích thước theo ý muốn
		int labelX = (pnNorth.getWidth() - labelWidth) / 2; // Căn giữa theo chiều ngang
		int labelY = (pnNorth.getHeight() - labelHeight) / 2; // Căn giữa theo chiều dọc
		lblTitle.setBounds(labelX, labelY, labelWidth, labelHeight);
		pnNorth.add(lblTitle);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));

		// Khung thông tin phòng
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(new Color(255, 255, 255));
		pnSouth.setBounds(7, 80, 690, 270);
		pnSouth.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), "Thông tin phòng",
						TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16), Color.blue));
		TitledBorder titlethongtin = (TitledBorder) pnSouth.getBorder();
		titlethongtin.setTitleColor(Color.blue);
		titlethongtin.setTitleFont(font);
		pnSouth.setLayout(null);
		add(pnSouth);

		JLabel lblMa = new JLabel("Mã phòng");
		pnSouth.add(lblMa);
		lblMa.setBounds(20, 20, 150, 100);
		lblMa.setFont(font2);

		int x = 160, y = 55, w = 180, h = 28;
		JTextField txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setBounds(x, y, w, h);
		pnSouth.add(txtMa);
		txtMa.setHorizontalAlignment(JTextField.RIGHT);
		txtMa.setFont(font3);

		JLabel lblLoaiPhong = new JLabel("Loại phòng");
		lblLoaiPhong.setBounds(20, 70, 120, 100);
		lblLoaiPhong.setFont(font2);
		pnSouth.add(lblLoaiPhong);

		cbLoaiPhong = new JComboBox<String>();
		cbLoaiPhong.setFont(font3);
		y += 50;
		cbLoaiPhong.setBounds(x, y, w, h);
		cbLoaiPhong.addItem("Phòng thường");
		cbLoaiPhong.addItem("Phòng VIP");
		pnSouth.add(cbLoaiPhong);

		JLabel lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setBounds(20, 120, 150, 100);
		lblTrangThai.setFont(font2);
		pnSouth.add(lblTrangThai);

		cbTrangThai = new JComboBox<String>();
		cbTrangThai.setFont(font3);
		y += 50;
		cbTrangThai.setBounds(x, y, w, h);
		cbTrangThai.addItem("Đang sử dụng");
		cbTrangThai.addItem("Trống");
		cbTrangThai.addItem("Đang sửa");
		cbTrangThai.addItem("Chờ");
		pnSouth.add(cbTrangThai);

		x = 380;
		y = 55;
		w = 100;
		h = 30;
		JLabel lblDonGia = new JLabel("Đơn giá");
		lblDonGia.setBounds(x, y, w, h);
		lblDonGia.setFont(font2);
		pnSouth.add(lblDonGia);

		txtDonGia = new JTextField();
		txtDonGia.setBounds(x + 110, y, w + 80, h);
		pnSouth.add(txtDonGia);
		txtDonGia.setHorizontalAlignment(JTextField.RIGHT);
		txtDonGia.setFont(font3);

		JLabel lblSucChua = new JLabel("Sức chứa");
		y += 50;
		lblSucChua.setBounds(x, y, w, h);
		lblSucChua.setFont(font2);
		pnSouth.add(lblSucChua);

		txtSucChua = new JTextField();
		txtSucChua.setBounds(x + 110, y, w + 80, h);
		pnSouth.add(txtSucChua);

		// Các nút
		pnSouth.add(btnThem = new JButton("THÊM", new ImageIcon("icon\\Add_icon.png")));
		btnThem.setFont(font);
		btnThem.setBounds(60, 220, 130, 35);
		btnThem.setBackground(new Color(109, 197, 112));
		pnSouth.add(btnXoa = new JButton("XÓA", new ImageIcon("icon\\Delete_icon.png")));
		btnXoa.setFont(font);
		btnXoa.setBounds(208, 220, 130, 35);
		btnXoa.setBackground(new Color(228, 50, 51));
		pnSouth.add(btnSua = new JButton("SỬA", new ImageIcon("icon\\Edit_icon.png")));
		btnSua.setFont(font);
		btnSua.setBounds(356, 220, 130, 35);
		btnSua.setBackground(new Color(74, 131, 215));
		pnSouth.add(btnLamMoi = new JButton("LÀM MỚI", new ImageIcon("icon\\Refresh_icon.png")));
		btnLamMoi.setFont(font);
		btnLamMoi.setBounds(504, 220, 130, 35);
		btnLamMoi.setBackground(new Color(104, 211, 211));

		// khung tìm kiếm
		JPanel pnEast = new JPanel();
		pnEast.setBackground(new Color(255, 255, 255));
		pnEast.setBounds(707, 80, 364, 270);
		pnEast.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Tìm kiếm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16), Color.blue));
		TitledBorder titleTimKiem = (TitledBorder) pnEast.getBorder();
		titleTimKiem.setTitleColor(Color.blue);
		titleTimKiem.setTitleFont(font);
		pnEast.setLayout(null);
		add(pnEast);

		JLabel lblLoaiTim = new JLabel("Tìm kiếm theo");
		lblLoaiTim.setFont(font2);
		pnEast.add(lblLoaiTim);
		lblLoaiTim.setBounds(30, 55, 130, 30);

		cbLoaiTim = new JComboBox<String>();
		cbLoaiTim.setFont(font3);
		cbLoaiTim.setBounds(170, 55, 170, 30);
		cbLoaiTim.addItem("Mã phòng");
		cbLoaiTim.addItem("Loại phòng");
		cbLoaiTim.addItem("Sức chứa");
		pnEast.add(cbLoaiTim);

		JLabel lblTuKhoaTim = new JLabel("Nhập từ khóa tìm kiếm");
		lblTuKhoaTim.setFont(font2);
		pnEast.add(lblTuKhoaTim);
		lblTuKhoaTim.setBounds(30, 105, 300, 30);

		txtTuKhoaTim = new JTextField();
		txtTuKhoaTim.setFont(font3);
		txtTuKhoaTim.setBounds(30, 135, 310, 30);
		pnEast.add(txtTuKhoaTim);

		btnTimKiem = new JButton("Tìm kiếm", new ImageIcon("icon\\Research_icon.png"));
		btnTimKiem.setFont(font);
		btnTimKiem.setBounds(112, 220, 140, 35);
		btnTimKiem.setBackground(new Color(238, 233, 233));
		pnEast.add(btnTimKiem);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(null);
		pnCenter.setBackground(new Color(246, 245, 255));
		pnCenter.setBounds(0, 350, 1078, 500);

		JLabel lblBang = new JLabel("DANH SÁCH PHÒNG");
		lblBang.setFont(new Font("Arial", Font.BOLD, 20));
		pnCenter.add(lblBang);
		lblBang.setForeground(Color.blue);
		lblBang.setBounds(20, 15, 500, 30);

		pnCenter.add(btnXuatExcel = new JButton("Xuất danh sách các phòng", new ImageIcon("icon\\Excel_icon.png")));
		btnXuatExcel.setFont(font);
		btnXuatExcel.setBounds(798, 14, 270, 30);
		add(pnCenter);

		model = new DefaultTableModel(col, 0);
		table = new JTable(model);
		table.setSelectionBackground(Color.pink);
		table.getTableHeader().setBackground(new Color(238, 233, 233));
		table.getColumnModel().getColumn(0).setMaxWidth(60);
		scroll = new JScrollPane(table);
		scroll.setBounds(9, 50, 1060, 320);
		pnCenter.add(scroll);
	}
}
