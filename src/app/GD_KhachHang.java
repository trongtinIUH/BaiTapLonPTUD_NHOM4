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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GD_KhachHang extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String col[] = {"STT", "Mã khách hàng","Tên khách hàng", "Giới tính", "Số điện thoại"};
	private JLabel lblTitle;
	private JTextField txtTimKiem;
	private JLabel lblTimKiem;
	private JComboBox<String> cbLoaiTimKiem;
	private JLabel lblLoaiTK;
	private JButton btnTimKiem;
	private Font font;
	private JLabel lblMa;
	private JLabel lblTen;
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
	private JLabel lblGioiTinh;

	public GD_KhachHang() {
		setBackground(new Color(242, 240, 255));
		setLayout(null);
		font = new Font("Arial", Font.BOLD, 14);
		
		JPanel pnNorth = new JPanel();
		pnNorth.setBounds(0,0,1080,80);
		pnNorth.setLayout(null);
		pnNorth.add(lblTitle = new JLabel("KHÁCH HÀNG"));
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
		pnlThongTin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2), "Thông tin khách hàng", 
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial",Font.BOLD,16), Color.blue));
		pnlThongTin.setBounds(10,10,730,210);
		pnlThongTin.setBackground(Color.white);
		font = new Font("Arial", Font.BOLD, 14);
		
		pnlThongTin.add(lblMa = new JLabel("Mã khách hàng: "));
		lblMa.setFont(font);
		lblMa.setBounds(15,40,130,20);
		pnlThongTin.add(lblTen = new JLabel("Tên khách hàng: "));
		lblTen.setFont(font);
		lblTen.setBounds(15,80,130,20);
		pnlThongTin.add(lblGioiTinh = new JLabel("Giới tính: "));
		lblGioiTinh.setFont(font);
		lblGioiTinh.setBounds(390,40,110,20);
		pnlThongTin.add(lblSDT = new JLabel("Số điện thoại: "));
		lblSDT.setFont(font);
		lblSDT.setBounds(390,80,110,20);
		
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
		txtTen.setBounds(145,80,180,20);
//		pnlThongTin.add(txtDiaChi = new JTextField());
//		txtDiaChi.setFont(font);
//		txtDiaChi.setBounds(500,40,200,20);
		pnlThongTin.add(radNam = new JRadioButton("Nam"));
		pnlThongTin.add(radNu = new JRadioButton("Nữ"));
		grSex = new ButtonGroup();
		grSex.add(radNam);
		grSex.add(radNu);
		radNam.setFont(font);radNu.setFont(font);
		radNam.setBounds(500,40,85,20);
		radNu.setBounds(610,40,85,20);
		pnlThongTin.add(txtSDT = new JTextField());
		txtSDT.setFont(font);
		txtSDT.setBounds(500,80,200,20);
		
		pnlThongTin.add(btnThem = new JButton("THÊM",new ImageIcon("icon\\Add_icon.png")));
		btnThem.setFont(font);
		btnThem.setBounds(110,145,130,35);
		btnThem.setBackground(new Color(109, 197, 112));
		pnlThongTin.add(btnXoa = new JButton("XÓA", new ImageIcon("icon\\Delete_icon.png")));
		btnXoa.setFont(font);
		btnXoa.setBounds(245,145,130,35);
		btnXoa.setBackground(new Color(240, 55, 55));
		pnlThongTin.add(btnSua = new JButton("SỬA", new ImageIcon("icon\\Edit_icon.png")));
		btnSua.setFont(font);
		btnSua.setBounds(380,145,130,35);
		btnSua.setBackground(new Color(74, 131, 215));
		pnlThongTin.add(btnLamMoi = new JButton("LÀM MỚI", new ImageIcon("icon\\Refresh_icon.png")));
		btnLamMoi.setFont(font);
		btnLamMoi.setBounds(515,145,130,35);
		btnLamMoi.setBackground(new Color(104, 211, 211));
		pnlCenter.add(pnlThongTin);
		
		
		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setLayout(null);
		pnlTimKiem.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,2), "Tìm kiếm khách hàng", 
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial",Font.BOLD,16), Color.blue));
		pnlTimKiem.setBounds(750,10,320,210);
		pnlTimKiem.setBackground(Color.white);
		
		pnlTimKiem.add(lblLoaiTK = new JLabel("Tìm kiếm theo: "));
		lblLoaiTK.setFont(font);
		lblLoaiTK.setBounds(30,40,120,25);
		cbLoaiTimKiem = new JComboBox<String>();
		cbLoaiTimKiem.setFont(font);
		cbLoaiTimKiem.setBounds(155,40,150,25);
		cbLoaiTimKiem.addItem("Mã khách hàng");
		cbLoaiTimKiem.addItem("Tên khách hàng");
		cbLoaiTimKiem.addItem("Số điện thoại");
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
		pnlTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(171, 174, 179),2), "Danh sách khách hàng", 
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
