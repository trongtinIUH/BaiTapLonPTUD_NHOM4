package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Dialog_ChuyenPhong extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox_TrangThai,comboBox_LoaiPhong;
	private JTextField txtSoNguoi,txtMaPhong;
	private JButton btnTimKiem,btnLamMoi,btn_ChuyenPhong,btn_QuayLai;
	private JPanel panel_2,panel,panel_3;
	private JTable tblChuyenPhong;
	private DefaultTableModel model;
	private String col[] = { "Mã Phòng", "Loại Phòng", "Sức Chứa", "Đơn Giá", "Trạng Thái" };


	
	public Dialog_ChuyenPhong() {
		getContentPane().setBackground(Color.WHITE);
		setSize(800, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//panel chứa tiêu đề--------------------------------------
		panel = new JPanel();
		panel.setBounds(0, 0, 784, 35);
		panel.setBackground(new Color(181, 230, 251));
		getContentPane().add(panel);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		JLabel lblTieuDe = new JLabel("Chuyển  Phòng");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 790, 35);
		panel.add(lblTieuDe);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 34, 784, 98);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		

		//--- lbl và combox trạng thái
		JLabel lblTrangThai = new JLabel("Trạng Thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrangThai.setBounds(10, 10, 90, 25);
		panel_2.add(lblTrangThai);
	
		comboBox_TrangThai = new JComboBox<String>();
		comboBox_TrangThai.setBackground(Color.WHITE);
		comboBox_TrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_TrangThai.setModel(new DefaultComboBoxModel<String>(new String[] {"Trống", "Chờ", "Đang Sử Dụng", "Sửa Chửa"}));
		comboBox_TrangThai.setBounds(110, 10, 200, 30);
		panel_2.add(comboBox_TrangThai);
	
		JLabel lblLoiPhng = new JLabel("Loại Phòng");
		lblLoiPhng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoiPhng.setBounds(10, 60, 90, 25);
		panel_2.add(lblLoiPhng);
		
		 comboBox_LoaiPhong = new JComboBox<String>();
		comboBox_LoaiPhong.setModel(new DefaultComboBoxModel<String>(new String[] {"Phòng Vip", "Phòng Thường"}));
		comboBox_LoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_LoaiPhong.setBackground(Color.WHITE);
		comboBox_LoaiPhong.setBounds(110, 60, 200, 30);
		panel_2.add(comboBox_LoaiPhong);
		
		//---lbl số người và mã phòng & txt
		JLabel lblSoNguoi = new JLabel("Số Người");
		lblSoNguoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoNguoi.setBounds(330, 10, 80, 25);
		panel_2.add(lblSoNguoi);
	
		JLabel lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaPhong.setBounds(330, 60, 80, 30);
		panel_2.add(lblMaPhong);
		
		txtSoNguoi = new JTextField();
		txtSoNguoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSoNguoi.setEditable(false);
		txtSoNguoi.setText("10");
		txtSoNguoi.setBounds(420, 10, 100, 30);
		panel_2.add(txtSoNguoi);
		txtSoNguoi.setColumns(10);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMaPhong.setText("101");
		txtMaPhong.setEditable(false);
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(420, 60, 100, 30);
		panel_2.add(txtMaPhong);
		
		//--- cuối góc phải là 3 nút jbutton
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimKiem.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Research_icon.png"));
		btnTimKiem.setBounds(570, 10, 200, 35);
		btnTimKiem.setBackground(new Color(13,153,255,255));
		panel_2.add(btnTimKiem);
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Refresh_icon.png"));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoi.setBounds(570, 55, 200, 35);
		btnLamMoi.setBackground(new Color(112,210,103,255));
		panel_2.add(btnLamMoi);
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 130, 784, 231);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		// bảng chuyển phòng
		model = new DefaultTableModel(col, 0);
		tblChuyenPhong = new JTable(model);
		tblChuyenPhong.setFont(new Font("Arial", Font.PLAIN, 12));
		tblChuyenPhong.setBackground(Color.WHITE);
		JScrollPane sp = new JScrollPane(tblChuyenPhong);
		sp.setBounds(0, 0, 784, 140);
		panel_3.add(sp);
		panel_3.setPreferredSize(new Dimension(800, 300));
		getContentPane().add(panel_3);
		
		JLabel lblPhongHienTai = new JLabel("Phòng hiện tại:");
		lblPhongHienTai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhongHienTai.setBounds(5, 145, 105, 20);
		panel_3.add(lblPhongHienTai);
		
		JLabel lblPhongHienTai_1 = new JLabel("301");
		lblPhongHienTai_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhongHienTai_1.setBounds(115, 145, 30, 20);
		panel_3.add(lblPhongHienTai_1);
		
		JLabel lblChuyenDen = new JLabel("--->");
		lblChuyenDen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChuyenDen.setBounds(155, 145, 40, 20);
		panel_3.add(lblChuyenDen);
		
		JLabel lblPhongHienTai_1_1 = new JLabel("...");
		lblPhongHienTai_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhongHienTai_1_1.setBounds(200, 145, 30, 20);
		panel_3.add(lblPhongHienTai_1_1);
		
		// các nút jbutton-------------------------------------------------------------------
		btn_ChuyenPhong = new JButton("Chuyển Phòng");
		btn_ChuyenPhong.setBackground(Color.GREEN);
		btn_ChuyenPhong.setForeground(Color.WHITE);
		btn_ChuyenPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_ChuyenPhong.setBackground(new Color(33,167,38,255));
		btn_ChuyenPhong.setBounds(33, 176, 250, 40);
		panel_3.add(btn_ChuyenPhong);
		
		btn_QuayLai = new JButton("Quay Lại");
		btn_QuayLai.setForeground(Color.WHITE);
		btn_QuayLai.setFont(new Font("Arial", Font.BOLD, 18));
		btn_QuayLai.setBackground(new Color(255,83,83,255));
		btn_QuayLai.setBounds(500, 180, 250, 40);
		panel_3.add(btn_QuayLai);
	
		//thêm sự kiện
		btnTimKiem.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btn_ChuyenPhong.addActionListener(this);
		btn_QuayLai.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btn_QuayLai)) {
		setVisible(false);	
		}
		
	}
}
