package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class GD_KhachHang extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("Arial", Font.BOLD, 16); // khung tittle
	Font font2 = new Font("Arial", Font.BOLD, 18); // thuộc tính
	Font font3 = new Font("Arial", Font.PLAIN, 18); // jtexfield
	private String col[] = { "STT", "Mã khách hàng", "Tên khách hàng", "Giới tính", "Số điện thoại" };
	private JLabel lblTitle;
	private JTextField txtTimKiem;
	private JComboBox<String> cbLoaiTimKiem;
	private JButton btnTimKiem;
	private JLabel lblSDT;
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
	private JLabel lblGioiTinh;

	public GD_KhachHang() {
		setBackground(new Color(242, 240, 255));
		setLayout(null);
		font = new Font("Arial", Font.BOLD, 18);

		JPanel pnNorth = new JPanel();
		pnNorth.setBounds(0, 0, 1078, 60);
		pnNorth.setLayout(null);
		pnNorth.setBackground(new Color(181, 230, 251));
		add(pnNorth);

		lblTitle = new JLabel("KHÁCH HÀNG");

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

		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(null);
		pnlCenter.setBounds(0, 0, 1080, 760);
		pnlCenter.setBackground(getBackground());
		add(pnlCenter);

		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setLayout(null);
		pnlThongTin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Thông tin khách hàng", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),
				Color.blue));
		pnlThongTin.setBounds(7, 80, 690, 230);
		pnlThongTin.setBackground(Color.white);
		font = new Font("Arial", Font.BOLD, 14);

		JLabel lblMa = new JLabel("Mã nhân viên");
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

		JLabel lblHoTen = new JLabel("Họ tên");
		lblHoTen.setBounds(20, 70, 100, 100);
		lblHoTen.setFont(font2);
		pnlThongTin.add(lblHoTen);

		JTextField txtHoTen = new JTextField();
		pnlThongTin.add(txtHoTen);
		y += 50;
		txtHoTen.setBounds(x, y, w, h);
		txtHoTen.setFont(font3);

		pnlThongTin.add(lblGioiTinh = new JLabel("Giới tính"));
		lblGioiTinh.setFont(font2);
		lblGioiTinh.setBounds(380, 55, 100, 30);

		pnlThongTin.add(radNam = new JRadioButton("Nam"));
		pnlThongTin.add(radNu = new JRadioButton("Nữ"));
		grSex = new ButtonGroup();
		grSex.add(radNam);
		grSex.add(radNu);
		radNam.setFont(font3);
		radNu.setFont(font3);
		radNam.setBackground(Color.WHITE);
		radNu.setBackground(Color.WHITE);
		radNam.setBounds(530, 55, 85, 30);
		radNu.setBounds(615, 55, 65, 30);

		pnlThongTin.add(lblSDT = new JLabel("Số điện thoại"));
		lblSDT.setFont(font2);
		lblSDT.setBounds(380, 105, 120, 20);
		pnlThongTin.add(txtSDT = new JTextField());
		txtSDT.setFont(font2);
		txtSDT.setBounds(530, 105, 140, 28);

		pnlThongTin.add(btnThem = new JButton("THÊM", new ImageIcon("icon\\Add_icon.png")));
		btnThem.setFont(font);
		btnThem.setBounds(60, 180, 130, 35);
		btnThem.setBackground(new Color(109, 197, 112));
		pnlThongTin.add(btnXoa = new JButton("XÓA", new ImageIcon("icon\\Delete_icon.png")));
		btnXoa.setFont(font);
		btnXoa.setBounds(208, 180, 130, 35);
		btnXoa.setBackground(new Color(228, 50, 51));
		pnlThongTin.add(btnSua = new JButton("SỬA", new ImageIcon("icon\\Edit_icon.png")));
		btnSua.setFont(font);
		btnSua.setBounds(356, 180, 130, 35);
		btnSua.setBackground(new Color(74, 131, 215));
		pnlThongTin.add(btnLamMoi = new JButton("LÀM MỚI", new ImageIcon("icon\\Refresh_icon.png")));
		btnLamMoi.setFont(font);
		btnLamMoi.setBounds(504, 180, 130, 35);
		btnLamMoi.setBackground(new Color(104, 211, 211));
		pnlCenter.add(pnlThongTin);

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setLayout(null);
		pnlTimKiem.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Tìm kiếm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),
				Color.blue));
		pnlTimKiem.setBounds(707, 80, 364, 230);
		pnlTimKiem.setBackground(Color.white);

		JLabel lblLoaiTim = new JLabel("Tìm kiếm theo");
		lblLoaiTim.setFont(font2);
		pnlTimKiem.add(lblLoaiTim);
		lblLoaiTim.setBounds(30, 55, 130, 30);

		cbLoaiTimKiem = new JComboBox<String>();
		cbLoaiTimKiem.setFont(font3);
		cbLoaiTimKiem.setBounds(170, 55, 170, 30);
		cbLoaiTimKiem.addItem("Mã khách hàng");
		cbLoaiTimKiem.addItem("Tên khách hàng");
		cbLoaiTimKiem.addItem("Số điện thoại");
		pnlTimKiem.add(cbLoaiTimKiem);

		JLabel lblTuKhoaTim = new JLabel("Nhập từ khóa tìm kiếm");
		lblTuKhoaTim.setFont(font2);
		pnlTimKiem.add(lblTuKhoaTim);
		lblTuKhoaTim.setBounds(30, 105, 300, 30);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(font3);
		txtTimKiem.setBounds(30, 135, 310, 30);
		pnlTimKiem.add(txtTimKiem);

		btnTimKiem = new JButton("Tìm kiếm", new ImageIcon("icon\\Research_icon.png"));
		btnTimKiem.setFont(font);
		btnTimKiem.setBounds(112, 180, 140, 35);
		btnTimKiem.setBackground(new Color(238, 233, 233));
		pnlTimKiem.add(btnTimKiem);

		pnlCenter.add(pnlTimKiem);

		// Table
		JPanel pnlTable = new JPanel();
		pnlTable.setLayout(null);
		pnlTable.setBackground(new Color(242, 240, 255));
		pnlTable.setBounds(0, 310, 1078, 500);

		JLabel lblBang = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblBang.setFont(new Font("Arial", Font.BOLD, 20));
		pnlTable.add(lblBang);
		lblBang.setForeground(Color.blue);
		lblBang.setBounds(20, 15, 500, 30);

		pnlTable.add(btnXuatExcel = new JButton("Xuất danh sách khách hàng", new ImageIcon("icon\\Excel_icon.png")));
		btnXuatExcel.setFont(font);
		btnXuatExcel.setBounds(798, 14, 270, 30);

		model = new DefaultTableModel(col, 0);
		table = new JTable(model);
		table.setSelectionBackground(Color.pink);
		table.getTableHeader().setBackground(new Color(238, 233, 233));
		table.getColumnModel().getColumn(0).setMaxWidth(60);
		scroll = new JScrollPane(table);
		scroll.setBounds(9, 50, 1060, 360);
		pnlTable.add(scroll);

		pnlCenter.add(pnlTable);

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
