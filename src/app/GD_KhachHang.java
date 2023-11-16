package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.KhachHang_dao;
import entity.KhachHang;
import entity.NhanVien;

public class GD_KhachHang extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("Arial", Font.BOLD, 16); // khung tittle
	Font font2 = new Font("Arial", Font.BOLD, 18); // thuộc tính
	Font font3 = new Font("Arial", Font.PLAIN, 18); // jtexfield
	private String col[] = { "STT", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Giới tính" };
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
	private KhachHang_dao kh_dao;
	private JTextField txtHoTen;
	private JTextField txtMa;
	private XSSFWorkbook wordbook;
	private Date ngayHienTai;
	private Date date;
	
	private JButton btnUser;
	private Dialog_User dialog_User= new Dialog_User();

	public GD_KhachHang() {
		setBackground(new Color(242, 240, 255));
		setLayout(null);
		font = new Font("Arial", Font.BOLD, 18);
		kh_dao = new KhachHang_dao();

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
		// ---nút user
		btnUser = new JButton("");
		btnUser.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\user.png"));
		btnUser.setBounds(1019, 5, 61, 45);
		btnUser.setBackground(new Color(181, 230, 251, 255));
		btnUser.setBorderPainted(false);
		pnNorth.add(btnUser);

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

		JLabel lblMa = new JLabel("Mã khách hàng");
		pnlThongTin.add(lblMa);
		lblMa.setBounds(20, 20, 150, 100);
		lblMa.setFont(font2);

		int x = 160, y = 55, w = 180, h = 28;
		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setBounds(x, y, w, h);
		pnlThongTin.add(txtMa);
		txtMa.setHorizontalAlignment(JTextField.RIGHT);
		txtMa.setFont(font3);
		
		loadMa();

		JLabel lblHoTen = new JLabel("Họ tên");
		lblHoTen.setBounds(20, 70, 100, 100);
		lblHoTen.setFont(font2);
		pnlThongTin.add(lblHoTen);

		txtHoTen = new JTextField();
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
//		txtSDT.setText(DataManager.getSoDienThoaiKHDat());
		Timer timerSDT = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(DataManager.isLoadSDT() == true) {
					txtSDT.setText(DataManager.getSoDienThoaiKHDat());
					DataManager.setLoadSDT(false);
//					System.out.println(txtSDT.getText());
					
				}
			}
		});
		timerSDT.start();
		

		pnlThongTin.add(btnThem = new JButton("THÊM", new ImageIcon("icon\\Add_icon.png")));
		btnThem.setFont(font);
		btnThem.setBounds(60, 180, 130, 35);
		btnThem.setBackground(new Color(109, 197, 112));
		btnThem.setBorder(new RoundedBorder(5));
		pnlThongTin.add(btnXoa = new JButton("XÓA", new ImageIcon("icon\\Delete_icon.png")));
		btnXoa.setFont(font);
		btnXoa.setBounds(208, 180, 130, 35);
		btnXoa.setBackground(new Color(228, 50, 51));
		btnXoa.setBorder(new RoundedBorder(5));
		pnlThongTin.add(btnSua = new JButton("SỬA", new ImageIcon("icon\\Edit_icon.png")));
		btnSua.setFont(font);
		btnSua.setBounds(356, 180, 130, 35);
		btnSua.setBackground(new Color(74, 131, 215));
		btnSua.setBorder(new RoundedBorder(5));
		pnlThongTin.add(btnLamMoi = new JButton("LÀM MỚI", new ImageIcon("icon\\Refresh_icon.png")));
		btnLamMoi.setFont(font);
		btnLamMoi.setBounds(504, 180, 130, 35);
		btnLamMoi.setBackground(new Color(104, 211, 211));
		btnLamMoi.setBorder(new RoundedBorder(5));
		pnlCenter.add(pnlThongTin);

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setLayout(null);
		pnlTimKiem.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Tìm kiếm", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16), Color.blue));
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
		btnTimKiem.setBorder(new RoundedBorder(5));
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
		btnXuatExcel.setBorder(new RoundedBorder(5));

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
		table.addMouseListener(this);
		btnUser.addActionListener(this);

		loadData();
	}

	//---- Mã khách hàng phát sinh tự động tăng dần bắt đầu từ 001
	private int ThuTuKhachHangTrongNgay() {
		int sl = 1;
		String maKH = "";
		for (KhachHang kh : kh_dao.getallKhachHangs()) {
			maKH = kh.getMaKhachHang(); //Chạy hết vòng for sẽ lấy được mã KH cuối danh sách
		}
		int ngayTrenMaKHCuoiDS = Integer.parseInt(maKH.substring(2, 8));
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd"); // Format yyMMdd sẽ so sánh ngày được
		ngayHienTai = new Date();
		int ngayHT = Integer.parseInt(dateFormat.format(ngayHienTai));
		if (ngayHT > ngayTrenMaKHCuoiDS) {
			sl = 1;
		} else if (ngayHT == ngayTrenMaKHCuoiDS) {
			sl = Integer.parseInt(maKH.substring(8, 11)) + 1;
		}
		return sl;
	}
	
	private String generateRandomCode() {
		String prefix = "KH";
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		date = new Date();
		String suffix = String.format("%03d", ThuTuKhachHangTrongNgay());
		return prefix + dateFormat.format(date) + suffix;
	}

	private void loadMa() {
		String code;
		code = generateRandomCode();
		txtMa.setText(code);
	}
	//---------------------------------------------------------

	public void loadData() {
		int i = 0;
		String gioiTinh = "";
		for (KhachHang kh : kh_dao.getallKhachHangs()) {
			i++;
			if (kh.isGioiTinh() == true) {
				gioiTinh = "Nam";
			} else {
				gioiTinh = "Nữ";
			}
			Object[] row = { i, kh.getMaKhachHang(), kh.getHoTen(), kh.getSoDienThoai(), gioiTinh };
			model.addRow(row);
		}
	}

	public void clearTable() {
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public void xoaTrang() {
		txtMa.setText("");
		txtHoTen.setText("");
		txtSDT.setText("");
		txtTimKiem.setText("");
		grSex.clearSelection();
	}

	public void them() {
		if (txtMa.getText().equals("") || txtHoTen.getText().equals("") || txtSDT.getText().equals("")
				|| (!radNam.isSelected() && !radNu.isSelected())) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!");
		} else {
			String ma = txtMa.getText().trim();
			String ten = txtHoTen.getText().trim();
			String sdt = txtSDT.getText().trim();
			Boolean gioiTinh;
			String hienThiGioiTinh;
			if (radNam.isSelected()) {
				gioiTinh = true;
			} else {
				gioiTinh = false;
			}
			KhachHang kh = new KhachHang(ma, ten, sdt, gioiTinh);
			if (kh_dao.addKhachHang(kh)) {
				if (gioiTinh == true) {
					hienThiGioiTinh = "Nam";
				} else
					hienThiGioiTinh = "Nữ";
				model.addRow(new Object[] { model.getRowCount() + 1, ma, ten, sdt, hienThiGioiTinh });
				DataManager.setSoDienThoaiKHDat(txtSDT.getText());
				JOptionPane.showMessageDialog(this, "Thêm thành công!!");
				xoaTrang();
				loadMa();
			} else {
				JOptionPane.showMessageDialog(null, "Trùng mã");
				xoaTrang();
				loadMa();
			}
		}
	}

	public void xoa() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa!!");
		} else if (table.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 khách hàng để xóa!!");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này không?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int row = table.getSelectedRow();
				kh_dao.deleteKhachHang(model.getValueAt(row, 1).toString());
				model.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa thành công!!");
			}
		}
	}

	public void sua() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để sửa!!");
		} else if (table.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 khách hàng để sửa!!");
		} else {
			String ma = txtMa.getText().trim();
			String ten = txtHoTen.getText().trim();
			String sdt = txtSDT.getText().trim();
			Boolean gioiTinh;
			if (radNam.isSelected()) {
				gioiTinh = true;
			} else {
				gioiTinh = false;
			}
			KhachHang kh = new KhachHang(ma, ten, sdt, gioiTinh);
			if (kh_dao.updateKhachHang(kh)) {
				clearTable();
				loadData();
				JOptionPane.showMessageDialog(null, "Sửa thành công!!");
			}
		}
	}

	public void tim() {
		int i = 0;
		String gioitinh="";
		if (btnTimKiem.getText().equals("Tìm kiếm")) {
			if (cbLoaiTimKiem.getSelectedItem().equals("Mã khách hàng")) {
				KhachHang kh = null;
				kh = kh_dao.getKhachHangTheoMaKH(txtTimKiem.getText());
				if (kh != null) {
					btnTimKiem.setText("Hủy tìm");
					clearTable();
					if(kh.isGioiTinh()==true)
					{
						gioitinh="Nam";
					}
					else gioitinh ="Nữ";
					Object[] row = { ++i, kh.getMaKhachHang(), kh.getHoTen(), kh.getSoDienThoai(),gioitinh };
					model.addRow(row);
				} else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!!");
				}
			} else if (cbLoaiTimKiem.getSelectedItem().equals("Tên khách hàng")) {
				ArrayList<KhachHang> dsKhachHang = kh_dao.getKhachHangTheoTenKH(txtTimKiem.getText());
				if (dsKhachHang != null) {
					btnTimKiem.setText("Hủy tìm");
					clearTable();
					for (KhachHang kh : dsKhachHang) {
						if(kh.isGioiTinh()==true)
						{
							gioitinh="Nam";
						}
						else gioitinh ="Nữ";
						Object[] row = { ++i, kh.getMaKhachHang(), kh.getHoTen(), kh.getSoDienThoai(),
								gioitinh };
						model.addRow(row);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!!");
				}
			} else if (cbLoaiTimKiem.getSelectedItem().equals("Số điện thoại")) {
				KhachHang kh = null;
				kh = kh_dao.getKhachHangTheoSDT(txtTimKiem.getText());
				if (kh != null) {
					if(kh.isGioiTinh()==true)
					{
						gioitinh="Nam";
					}
					else gioitinh ="Nữ";
					btnTimKiem.setText("Hủy tìm");
					clearTable();
					Object[] row = { ++i, kh.getMaKhachHang(), kh.getHoTen(), kh.getSoDienThoai(), gioitinh };
					model.addRow(row);
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
			XSSFSheet sheet = wordbook.createSheet("Danh sách khách hàng");

			XSSFRow row = null;
			Cell cell = null;
			row = sheet.createRow(2);// Tạo 2 dòng trống trong excel
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue("STT");
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("Mã khách hàng");
			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue("Tên khách hàng");
			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue("Số điện thoại");
			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue("Giới tính");

			for (int i = 0; i < kh_dao.getallKhachHangs().size(); i++) {
				row = sheet.createRow(3 + i); // Bỏ qua 2 dòng trống

				cell = row.createCell(0, CellType.NUMERIC);
				cell.setCellValue(i + 1);
				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue(kh_dao.getallKhachHangs().get(i).getMaKhachHang());
				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue(kh_dao.getallKhachHangs().get(i).getHoTen());
				cell = row.createCell(3, CellType.NUMERIC);
				cell.setCellValue(kh_dao.getallKhachHangs().get(i).getSoDienThoai());
				
				String gioiTinhInExcel = "";
				if(kh_dao.getallKhachHangs().get(i).isGioiTinh() == true) {
					gioiTinhInExcel = "Nam";
				}else
					gioiTinhInExcel = "Nữ";
				cell = row.createCell(4, CellType.STRING);
				cell.setCellValue(gioiTinhInExcel);
			}

			File file = new File("D:\\BaiTapLonPTUD_NHOM4\\LuuFile_Excel\\DanhSachKhachHang.xlsx");
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
		}
		else if(obj.equals(btnUser)) {
			dialog_User.setVisible(true);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMa.setText(model.getValueAt(row, 1).toString());
		txtHoTen.setText(model.getValueAt(row, 2).toString());
		txtSDT.setText(model.getValueAt(row, 3).toString());
		if (model.getValueAt(row, 4).toString().equals("Nam")) {
			radNam.setSelected(true);
		} else if (model.getValueAt(row, 4).toString().equals("Nữ")) {
			radNu.setSelected(true);
			;
		}
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
