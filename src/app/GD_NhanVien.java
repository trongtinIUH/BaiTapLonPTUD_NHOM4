package app;

import java.awt.Color;
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
import java.time.Year;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

import dao.NhanVien_dao;
import entity.DateLabelFormatter;
import entity.NhanVien;

public class GD_NhanVien extends JPanel implements ActionListener, MouseListener {
	Font font = new Font("Arial", Font.BOLD, 16); // khung tittle
	Font font2 = new Font("Arial", Font.BOLD, 18); // thuộc tính
	Font font3 = new Font("Arial", Font.PLAIN, 18); // jtexfield

	private String col[] = { "STT", "Mã nhân viên", "Họ tên", "Số điện thoại", "Giới tính", "Ngày sinh", "Chức vụ",
			"Ảnh", "Thông tin làm" };
	private JLabel lblTitle;
	private JPanel pnNorth;
	private SqlDateModel modelNgaySinh;
	private Properties p;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private JComboBox<String> cbChucVu;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JComboBox<String> cbLoaiTim;
	private JTextField txtTuKhoaTim;
	private JButton btnTimKiem;
	private JButton btnXuatExcel;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private NhanVien_dao nv_dao;
	private JTextField txtMa;
	private JTextField txtHoTen;
	private JTextField txtSDT;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JButton openButton;
	private JLabel imageLabel;
	private String absolutePath;
	private File selectedFile;
	private XSSFWorkbook wordbook;

	public GD_NhanVien() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);

		pnNorth = new JPanel();
		pnNorth.setLayout(null);
		pnNorth.setBounds(0, 0, 1078, 60);
		pnNorth.setBackground(new Color(187, 231, 252));
		add(pnNorth);
		lblTitle = new JLabel("NHÂN VIÊN");
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
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));

		// khung thông tin nhân viên
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(new Color(255, 255, 255));
		pnSouth.setBounds(7, 80, 690, 300);
		pnSouth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Thông tin nhân viên", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),
				Color.blue));
		TitledBorder titlethongtin = (TitledBorder) pnSouth.getBorder();
		titlethongtin.setTitleColor(Color.blue);
		titlethongtin.setTitleFont(font);
		pnSouth.setLayout(null);
		add(pnSouth);

		// Nội dung thông tin nhân viên

		JLabel lblMa = new JLabel("Mã nhân viên");
		pnSouth.add(lblMa);
		lblMa.setBounds(20, 20, 150, 100);
		lblMa.setFont(font2);

		int x = 160, y = 55, w = 180, h = 28;
		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setBounds(x, y, w, h);
		pnSouth.add(txtMa);
		txtMa.setHorizontalAlignment(JTextField.RIGHT);
		txtMa.setFont(font3);

		JLabel lblHoTen = new JLabel("Họ tên");
		lblHoTen.setBounds(20, 70, 100, 100);
		lblHoTen.setFont(font2);
		pnSouth.add(lblHoTen);

		txtHoTen = new JTextField();
		pnSouth.add(txtHoTen);
		y += 50;
		txtHoTen.setBounds(x, y, w, h);
		txtHoTen.setFont(font3);

		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setBounds(20, 120, 150, 100);
		lblSDT.setFont(font2);
		pnSouth.add(lblSDT);

		txtSDT = new JTextField();
		pnSouth.add(txtSDT);
		y += 50;
		txtSDT.setBounds(x, y, w, h);
		txtSDT.setFont(font3);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setBounds(20, 170, 100, 100);
		lblGioiTinh.setFont(font2);
		pnSouth.add(lblGioiTinh);

		rdoNam = new JRadioButton();
		pnSouth.add(rdoNam);
		rdoNam.setBackground(new Color(255, 255, 255));
		y += 50;
		rdoNam.setBounds(x, y, 30, 30);
		JLabel lblNam = new JLabel("Nam");
		pnSouth.add(lblNam);
		x += 30;
		lblNam.setBounds(x, y, 50, 30);
		lblNam.setFont(font2);

		rdoNu = new JRadioButton();
		pnSouth.add(rdoNu);
		rdoNu.setBackground(new Color(255, 255, 255));
		x += 80;
		rdoNu.setBounds(x, y, 30, 30);
		JLabel lblNu = new JLabel("Nữ");
		pnSouth.add(lblNu);
		x += 30;
		lblNu.setBounds(x, y, 50, 30);
		lblNu.setFont(font2);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdoNam);
		bg.add(rdoNu);

		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		x = 380;
		y = 55;
		w = 100;
		h = 30;
		lblNgaySinh.setBounds(x, y, w, h);
		lblNgaySinh.setFont(font2);
		pnSouth.add(lblNgaySinh);

		modelNgaySinh = new SqlDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(modelNgaySinh, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		modelNgaySinh.setSelected(true);
		datePicker.setBackground(new Color(255, 255, 255));
		datePicker.setBounds(x + 110, y, w + 80, h);
		pnSouth.add(datePicker);

		JLabel lblChucVu = new JLabel("Chức vụ");
		y += 50;
		lblChucVu.setBounds(x, y, w, h);
		lblChucVu.setFont(font2);
		pnSouth.add(lblChucVu);

		cbChucVu = new JComboBox<String>();
		cbChucVu.setFont(font3);
		cbChucVu.setBounds(x + 110, y, w + 80, h);
		cbChucVu.addItem("Nhân viên quản lý");
		cbChucVu.addItem("Nhân viên phục vụ");
		pnSouth.add(cbChucVu);

		JLabel lblAnh = new JLabel("Ảnh");
		pnSouth.add(lblAnh);
		lblAnh.setFont(font2);
		y += 50;
		lblAnh.setBounds(x, y, w + 20, h);

		pnSouth.add(openButton = new JButton("Chọn tệp"));
		openButton.setBounds(x + 45, y + 5, 87, 20);
		pnSouth.add(imageLabel = new JLabel());
		imageLabel.setBounds(x + 170, y - 5, 95, 90);

		// Các nút
		pnSouth.add(btnThem = new JButton("THÊM", new ImageIcon("icon\\Add_icon.png")));
		btnThem.setFont(font);
		btnThem.setBounds(60, 250, 130, 35);
		btnThem.setBackground(new Color(109, 197, 112));
		pnSouth.add(btnXoa = new JButton("XÓA", new ImageIcon("icon\\Delete_icon.png")));
		btnXoa.setFont(font);
		btnXoa.setBounds(208, 250, 130, 35);
		btnXoa.setBackground(new Color(228, 50, 51));
		pnSouth.add(btnSua = new JButton("SỬA", new ImageIcon("icon\\Edit_icon.png")));
		btnSua.setFont(font);
		btnSua.setBounds(356, 250, 130, 35);
		btnSua.setBackground(new Color(74, 131, 215));
		pnSouth.add(btnLamMoi = new JButton("LÀM MỚI", new ImageIcon("icon\\Refresh_icon.png")));
		btnLamMoi.setFont(font);
		btnLamMoi.setBounds(504, 250, 130, 35);
		btnLamMoi.setBackground(new Color(104, 211, 211));

		// khung tìm kiếm
		JPanel pnEast = new JPanel();
		pnEast.setBackground(new Color(255, 255, 255));
		pnEast.setBounds(707, 80, 364, 300);
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
		cbLoaiTim.addItem("Mã nhân viên");
		cbLoaiTim.addItem("Tên nhân viên");
		pnEast.add(cbLoaiTim);

		JLabel lblTuKhoaTim = new JLabel("Nhập từ khóa tìm kiếm");
		lblTuKhoaTim.setFont(font2);
		pnEast.add(lblTuKhoaTim);
		lblTuKhoaTim.setBounds(30, 105, 300, 30);

		txtTuKhoaTim = new JTextField();
		txtTuKhoaTim.setFont(font3);
		txtTuKhoaTim.setBounds(30, 160, 310, 30);
		pnEast.add(txtTuKhoaTim);

		btnTimKiem = new JButton("Tìm kiếm", new ImageIcon("icon\\Research_icon.png"));
		btnTimKiem.setFont(font);
		btnTimKiem.setBounds(112, 250, 140, 35);
		btnTimKiem.setBackground(new Color(238, 233, 233));
		pnEast.add(btnTimKiem);

		// Center
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(null);
		pnCenter.setBackground(new Color(246, 245, 255));
		pnCenter.setBounds(0, 380, 1078, 500);

		JLabel lblBang = new JLabel("DANH SÁCH NHÂN VIÊN");
		lblBang.setFont(new Font("Arial", Font.BOLD, 20));
		pnCenter.add(lblBang);
		lblBang.setForeground(Color.blue);
		lblBang.setBounds(20, 15, 500, 30);

		pnCenter.add(btnXuatExcel = new JButton("Xuất danh sách nhân viên", new ImageIcon("icon\\Excel_icon.png")));
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
		table.addMouseListener(this);
		openButton.addActionListener(this);

		loadData();
		loadMa();

	}

	private String getGT(NhanVien nv) {
		String gt = "";
		if (nv.isGioiTinh() == true)
			gt = "Nam";
		else
			gt = "Nữ";
		return gt;
	}

	private void loadData() {
		int i = 0;
		nv_dao = new NhanVien_dao();
		for (NhanVien nv : nv_dao.getAllNhanVien()) {
			i++;
			Object[] row = { i, nv.getMaNhanVien(), nv.getHoTen(), nv.getSoDienThoai(), getGT(nv), nv.getNgaySinh(),
					nv.getChucVu(), nv.getAnhDaiDien(), "Xem chi tiết" };
			model.addRow(row);
		}
	}

	private void xoaTrang() {
		txtMa.setText("YYDGXXX");
		txtHoTen.setText("");
		txtSDT.setText("");
		rdoNam.setSelected(false);
		rdoNu.setSelected(false);
	}

	private String thuTuNhanVienTrongNam() {
		int sl = 0;
		for (NhanVien nv : nv_dao.getAllNhanVien()) {
			if (nv.getMaNhanVien().substring(0, 2).equals("23"))
				sl++;
		}
		String slString = String.format("%03d", sl + 1);
		return slString;
	}

	private String generateRandomCode() {
		Year year = Year.now();
		String ma;
		int lastTwoDigitsOfYear = year.getValue() % 100;
		String lastTwoDigitsString = String.valueOf(lastTwoDigitsOfYear);

		ma = lastTwoDigitsString;
		if (rdoNam.isSelected())
			ma += "1";
		else
			ma += "0";
		if (cbChucVu.getSelectedIndex() == 0)
			ma += "1";
		else
			ma += "0";
		return ma + thuTuNhanVienTrongNam();
	}

	private void loadMa() {
		String code;
		code = generateRandomCode();
		txtMa.setText(code);
	}

	private void clearTable() {
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	private void them() {
		ImageIcon icon = (ImageIcon) imageLabel.getIcon();
		if (icon != null) {
			File imageFile = new File(icon.getDescription());
			absolutePath = imageFile.getAbsolutePath();
		}

		if (txtMa.getText().equals("") || txtHoTen.getText().equals("") || txtSDT.getText().equals("")
				|| icon == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!");
		} else {
			String ma = txtMa.getText();
			String hoTen = txtHoTen.getText();
			String sDT = txtSDT.getText();
			boolean gt;
			if (rdoNam.isSelected())
				gt = true;
			else
				gt = false;
			Date ngaySinh = (Date) datePicker.getModel().getValue();
			String chucVu = (String) cbChucVu.getSelectedItem();
			NhanVien nv = new NhanVien(ma, hoTen, sDT, gt, ngaySinh, chucVu, absolutePath);
			if (nv_dao.addNhanVien(nv)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công!!");
				clearTable();
				loadData();
				xoaTrang();
				loadMa();
			}
		}
	}

	public void xoa() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa!!");
		} else if (table.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 nhân viên để xóa!!");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này không?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int row = table.getSelectedRow();
				nv_dao.deleteNhanVien(model.getValueAt(row, 1).toString());
				model.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa thành công!!");
			}
		}
	}

	private void sua() {
		ImageIcon icon = (ImageIcon) imageLabel.getIcon();
		File imageFile = new File(icon.getDescription());
		absolutePath = imageFile.getAbsolutePath();
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để sửa!!");
		} else if (table.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 nhân viên để sửa!!");
		} else {
			String ma = txtMa.getText().trim();
			String ten = txtHoTen.getText().trim();
			String sDT = txtSDT.getText().trim();
			boolean gt;
			if (rdoNam.isSelected())
				gt = true;
			else
				gt = false;
			Date ngaySinh = (Date) datePicker.getModel().getValue();

			NhanVien nv = new NhanVien(ma, ten, sDT, gt, ngaySinh, (String) cbChucVu.getSelectedItem(), absolutePath);
			if (nv_dao.updateNhanVien(nv)) {
				clearTable();
				loadData();
				JOptionPane.showMessageDialog(null, "Sửa thành công!!");
			}
		}
	}

	public void tim() {
		int i = 1;
		if (btnTimKiem.getText().equals("Tìm kiếm")) {
			if (cbLoaiTim.getSelectedItem().equals("Mã nhân viên")) {
				NhanVien nv = null;
				nv = nv_dao.getNhanVienTheoMa(txtTuKhoaTim.getText());
				if (nv != null) {
					btnTimKiem.setText("Hủy tìm");
					clearTable();
					Object[] row = { i++, nv.getMaNhanVien(), nv.getHoTen(), nv.getSoDienThoai(), getGT(nv),
							nv.getNgaySinh(), nv.getChucVu(), nv.getAnhDaiDien(), "Xem chi tiết" };
					model.addRow(row);
				} else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!!");
				}
			} else if (cbLoaiTim.getSelectedItem().equals("Tên nhân viên")) {
				ArrayList<NhanVien> dsNhanVien = nv_dao.getNhanVienTheoTen(txtTuKhoaTim.getText());
				if (dsNhanVien != null) {
					btnTimKiem.setText("Hủy tìm");
					clearTable();
					for (NhanVien nv : dsNhanVien) {
						Object[] row = { i++, nv.getMaNhanVien(), nv.getHoTen(), nv.getSoDienThoai(), getGT(nv),
								nv.getNgaySinh(), nv.getChucVu(), nv.getAnhDaiDien(), "Xem chi tiết" };
						model.addRow(row);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!!");
				}
			}
		} else {
			clearTable();
			loadData();
			btnTimKiem.setText("Tìm kiếm");
		}
	}
	
	public void xuatExcel() {
		try {
			wordbook = new XSSFWorkbook();
			XSSFSheet sheet = wordbook.createSheet("Danh sách nhân viên");

			XSSFRow row = null;
			Cell cell = null;
			row = sheet.createRow(2);// Tạo 2 dòng trống trong excel
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue("STT");
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("Mã nhân viên");
			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue("Họ tên nhân viên");
			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue("Số điện thoại");
			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue("Giới tính");
			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue("Ngày sinh");
			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue("Chức vụ");
			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue("Hình ảnh");

			for (int i = 0; i < nv_dao.getAllNhanVien().size(); i++) {
				row = sheet.createRow(3 + i); // Bỏ qua 2 dòng trống

				cell = row.createCell(0, CellType.NUMERIC);
				cell.setCellValue(i + 1);
				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue(nv_dao.getAllNhanVien().get(i).getMaNhanVien());
				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue(nv_dao.getAllNhanVien().get(i).getHoTen());
				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue(nv_dao.getAllNhanVien().get(i).getSoDienThoai());
				
				String gioiTinhInExcel = "";
				if(nv_dao.getAllNhanVien().get(i).isGioiTinh() == true) {
					gioiTinhInExcel = "Nam";
				}else
					gioiTinhInExcel = "Nữ";
				cell = row.createCell(4, CellType.STRING);
				cell.setCellValue(gioiTinhInExcel);
				
				cell = row.createCell(5, CellType.STRING);
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String ngay = df.format(nv_dao.getAllNhanVien().get(i).getNgaySinh());
				cell.setCellValue(ngay);

				cell = row.createCell(6, CellType.STRING);
				cell.setCellValue(nv_dao.getAllNhanVien().get(i).getChucVu());
				cell = row.createCell(7, CellType.STRING);
				cell.setCellValue(nv_dao.getAllNhanVien().get(i).getAnhDaiDien());

			}

			File file = new File("D:\\BaiTapLonPTUD_NHOM4\\LuuFile_Excel\\DanhSachNhanVien.xlsx");
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

	private void chenAnh() {
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
			imageLabel.setIcon(icon);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnThem)) {
			them();
		} else if (obj.equals(btnXoa)) {
			xoa();
		} else if (obj.equals(btnSua)) {
			sua();
		} else if (obj.equals(btnLamMoi)) {
			xoaTrang();
			loadMa();
		} else if (obj.equals(btnTimKiem)) {
			tim();
		} else if (obj.equals(btnXuatExcel)) {
			xuatExcel();
		} else if (obj.equals(openButton)) {
			chenAnh();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMa.setText(model.getValueAt(row, 1).toString());
		txtHoTen.setText(model.getValueAt(row, 2).toString());
		txtSDT.setText(model.getValueAt(row, 3).toString());
		if (model.getValueAt(row, 4).toString().equals("Nam"))
			rdoNam.setSelected(true);
		else
			rdoNu.setSelected(true);

		try {
			modelNgaySinh.setValue((java.sql.Date) model.getValueAt(row, 5));
		} catch (Exception e2) {
			// TODO: handle exception
		}

		cbChucVu.setSelectedItem(model.getValueAt(row, 6));
		imageLabel.setIcon(new ImageIcon(model.getValueAt(row, 7).toString()));
		
		
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
