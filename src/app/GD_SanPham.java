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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import entity.DateLabelFormatter;

public class GD_SanPham extends JPanel  implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private String col[] = {"STT", "Mã sản phẩm","Tên sản phẩm", "Loại", "Ngày sản xuất", "Số lượng tồn", "Đơn vị tính", "Đơn giá", "Hình ảnh"};
	private JLabel lblTitle;
	private JTextField txtTimKiem;
	private JLabel lblTimKiem;
	private JComboBox<String> cbLoaiTimKiem;
	private JLabel lblLoaiTK;
	private JButton btnTimKiem;
	private Font font;
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
		font = new Font("Arial", Font.BOLD, 14);
		
		JPanel pnNorth = new JPanel();
		pnNorth.setBounds(0,0,1080,80);
		pnNorth.setLayout(null);
		pnNorth.add(lblTitle = new JLabel("SẢN PHẨM"));
		lblTitle.setFont(new Font("Arial",Font.BOLD, 40));
		lblTitle.setBounds(400, 15, 350, 45);
		pnNorth.setBackground(new Color(181, 230, 251));
		add(pnNorth);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(null);
		pnlCenter.setBounds(5,90, 1070, 640);
		pnlCenter.setBackground(getBackground());
		add(pnlCenter);
		
		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setLayout(null);
		pnlThongTin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2), "Thông tin sản phẩm", 
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial",Font.BOLD,16), Color.blue));
		pnlThongTin.setBounds(10,10,730,210);
		pnlThongTin.setBackground(Color.white);
		font = new Font("Arial", Font.BOLD, 14);
		
		pnlThongTin.add(lblMa = new JLabel("Mã sản phẩm: "));
		lblMa.setFont(font);
		lblMa.setBounds(15,40,130,20);
		pnlThongTin.add(lblTen = new JLabel("Tên sản phẩm: "));
		lblTen.setFont(font);
		lblTen.setBounds(15,70,130,20);
		pnlThongTin.add(lblLoai = new JLabel("Loại: "));
		lblLoai.setFont(font);
		lblLoai.setBounds(15,100,130,20);
		pnlThongTin.add(lblNgaySX = new JLabel("Ngày sản xuất: "));
		lblNgaySX.setFont(font);
		lblNgaySX.setBounds(15,130,130,20);
		
		
		pnlThongTin.add(lblSoLuong = new JLabel("Số lượng: "));
		lblSoLuong.setFont(font);
		lblSoLuong.setBounds(390,40,110,20);
		pnlThongTin.add(lblDonGia = new JLabel("Đơn giá: "));
		lblDonGia.setFont(font);
		lblDonGia.setBounds(390,70,110,20);
		pnlThongTin.add(lblHinhAnh = new JLabel("Hình ảnh: "));
		lblHinhAnh.setFont(font);
		lblHinhAnh.setBounds(390,120,110,20);
		
		pnlThongTin.add(txtMa = new JTextField());
		txtMa.setFont(font);
		txtMa.setBounds(145,40,180,20);
//		Set<String> generatedCodes = new HashSet<>();
//		String code;
//		PhatSinhMa_dao ps_ma = new PhatSinhMa_dao();
//		do {
//			code = ps_ma.generateRandomKH();
//		} while (generatedCodes.contains(code));
//		generatedCodes.add(code);
//		txtMa.setText(code);
		pnlThongTin.add(txtTen = new JTextField());
		txtTen.setFont(font);
		txtTen.setBounds(145,70,180,20);
		
		cbLoaiSanPham = new JComboBox<String>();
		cbLoaiSanPham.setFont(font);
		cbLoaiSanPham.setBounds(145,100,180,20);
		pnlThongTin.add(cbLoaiSanPham);
		
		modelNgaylap = new SqlDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(modelNgaylap, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		modelNgaylap.setDate(2023, 9, 25);
		modelNgaylap.setSelected(true);
		datePicker.setBackground(new Color(0, 0, 0));
		datePicker.setToolTipText("Chọn ngày lập");
		datePicker.setFont(font);
		datePicker.setBounds(145,130,182,25);
		pnlThongTin.add(datePicker);
		
		pnlThongTin.add(txtSoLuong = new JTextField());
		txtSoLuong.setFont(font);
		txtSoLuong.setBounds(500,40,85,20);
		
		cbDonViTinh = new JComboBox<String>();
		cbDonViTinh.setFont(font);
		cbDonViTinh.setBounds(610,40,85,20);
		pnlThongTin.add(cbDonViTinh);
		
		pnlThongTin.add(txtDonGia = new JTextField());
		txtDonGia.setFont(font);
		txtDonGia.setBounds(500,70,196,20);
		
		pnlThongTin.add(btnThem = new JButton("THÊM",new ImageIcon("icon\\Add_icon.png")));
		btnThem.setFont(font);
		btnThem.setBounds(110,165,130,35);
		btnThem.setBackground(new Color(109, 197, 112));
		pnlThongTin.add(btnXoa = new JButton("XÓA", new ImageIcon("icon\\Delete_icon.png")));
		btnXoa.setFont(font);
		btnXoa.setBounds(245,165,130,35);
		btnXoa.setBackground(new Color(240, 55, 55));
		pnlThongTin.add(btnSua = new JButton("SỬA", new ImageIcon("icon\\Edit_icon.png")));
		btnSua.setFont(font);
		btnSua.setBounds(380,165,130,35);
		btnSua.setBackground(new Color(74, 131, 215));
		pnlThongTin.add(btnLamMoi = new JButton("LÀM MỚI", new ImageIcon("icon\\Refresh_icon.png")));
		btnLamMoi.setFont(font);
		btnLamMoi.setBounds(515,165,130,35);
		btnLamMoi.setBackground(new Color(104, 211, 211));
		pnlCenter.add(pnlThongTin);
		
		
		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setLayout(null);
		pnlTimKiem.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2), "Tìm kiếm sản phẩm", 
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial",Font.BOLD,16), Color.blue));
		pnlTimKiem.setBounds(750,10,320,210);
		pnlTimKiem.setBackground(Color.white);
		
		pnlTimKiem.add(lblLoaiTK = new JLabel("Tìm kiếm theo: "));
		lblLoaiTK.setFont(font);
		lblLoaiTK.setBounds(30,40,120,25);
		cbLoaiTimKiem = new JComboBox<String>();
		cbLoaiTimKiem.setFont(font);
		cbLoaiTimKiem.setBounds(155,40,150,25);
		cbLoaiTimKiem.addItem("Mã sản phẩm");
		cbLoaiTimKiem.addItem("Tên sản phẩm");
		pnlTimKiem.add(cbLoaiTimKiem);
		pnlTimKiem.add(lblTimKiem = new JLabel("Nhập từ khóa tìm kiếm:"));
		lblTimKiem.setFont(font);
		lblTimKiem.setBounds(30,80,200,20);
		pnlTimKiem.add(txtTimKiem = new JTextField());
		txtTimKiem.setFont(font);
		txtTimKiem.setBounds(30,100,262,25);
		pnlTimKiem.add(btnTimKiem = new JButton("Tìm kiếm", new ImageIcon("icon\\Research_icon.png")));
		btnTimKiem.setFont(font);
		btnTimKiem.setBounds(150,150,140,30);
		btnTimKiem.setBackground(new Color(238, 233, 233));
		pnlCenter.add(pnlTimKiem);
		
		JPanel pnlTable = new JPanel();
		pnlTable.setLayout(null);
		pnlTable.setBackground(Color.white);
		pnlTable.setBounds(10,260,1060,310);
		pnlTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(171, 174, 179),2), "Danh sách sản phẩm", 
				TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial",Font.BOLD,15), Color.BLUE));
		model = new DefaultTableModel(col,0);
		table = new JTable(model);
		table.setSelectionBackground(Color.pink);
		table.getTableHeader().setBackground(new Color(238, 233, 233));
		table.getColumnModel().getColumn(0).setMaxWidth(60);
		scroll = new JScrollPane(table);
		scroll.setBounds(8,20,1045,310);
		pnlTable.add(scroll);
		pnlCenter.add(pnlTable);
		
		pnlCenter.add(btnXuatExcel= new JButton("Xuất biểu mẫu", new ImageIcon("icon\\Excel_icon.png")));
		btnXuatExcel.setFont(font);
		btnXuatExcel.setBounds(905,220,165,35);
		pnlCenter.add(btnXuatExcel);
		
		
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
		if(obj.equals(btnThem)) {
			
		}else if(obj.equals(btnXoa)) {
			
		}else if(obj.equals(btnSua)) {
			
		}else if(obj.equals(btnLamMoi)){
		
		}else if(obj.equals(btnTimKiem)) {
		
		} else if(obj.equals(btnLamMoi)) {
			
		}
	}
}
