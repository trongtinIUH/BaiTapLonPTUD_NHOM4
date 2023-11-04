package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class Dialog_TimPhieuDatPhong extends JDialog implements ActionListener {
	private JPanel panel;
	private JLabel lblTieuDe,lblTrangThai,lblMaPDP,lblSDTKhach;

	private JComboBox<String> comboBox_TrangThai;
	private JButton btnTimKiem,btnLamMoi,btn_XuatPhong,btn_XemPhong,btn_HuyPhong,btn_NhanPhong;
	
	private JTable tblPhieuDatPhong;
	private DefaultTableModel model;
	private String col[] = { "Mã PDP", "Phòng", "SDT KH", "Nhân Viên", "Ngày Giờ Đặt","Số Người Hát","Trạng Thái" };
	private JButton btn_QuayLai;


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaPDP;
	private JTextField txtSDTKH;
	


	public Dialog_TimPhieuDatPhong() {
		//kích thước
		getContentPane().setBackground(Color.WHITE);
		setSize(800, 450);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//panel chứa tiêu đề-------------------------------------------------------------------------
		panel = new JPanel();
		panel.setBounds(0, 0, 784, 35);
		panel.setBackground(new Color(181,230,251,255));
		getContentPane().add(panel);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		lblTieuDe = new JLabel("Tìm Phiếu Đặt Phòng");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 790, 35);
		panel.add(lblTieuDe);
		
		// panel 1 chứa thông tin kh, nhân viên và bảng table-------------------------------------------
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 34, 784, 380);
		panel_1.setBackground(SystemColor.menu);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblMaPDP = new JLabel("Mã phiếu đặt:");
		lblMaPDP.setFont(new Font("Arial", Font.BOLD, 15));
		lblMaPDP.setBounds(5, 5, 100, 30);
		panel_1.add(lblMaPDP);
		
		lblSDTKhach = new JLabel("SDT khách:");
		lblSDTKhach.setFont(new Font("Arial", Font.BOLD, 15));
		lblSDTKhach.setBounds(5, 45, 100, 30);
		panel_1.add(lblSDTKhach);
		
		txtMaPDP = new JTextField();
		txtMaPDP.setFont(new Font("Arial", Font.BOLD, 14));
		txtMaPDP.setBounds(110, 5, 220, 30);
		panel_1.add(txtMaPDP);
		txtMaPDP.setColumns(10);
		
		txtSDTKH = new JTextField();
		txtSDTKH.setFont(new Font("Arial", Font.BOLD, 14));
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(110, 45, 220, 30);
		panel_1.add(txtSDTKH);
		
		//--- lbl và combox trạng thái
		lblTrangThai = new JLabel("Trạng Thái:");
		lblTrangThai.setFont(new Font("Arial", Font.BOLD, 15));
		lblTrangThai.setBounds(345, 5, 85, 30);
		panel_1.add(lblTrangThai);
		comboBox_TrangThai = new JComboBox<String>();
		comboBox_TrangThai.setBackground(Color.WHITE);
		comboBox_TrangThai.setFont(new Font("Arial", Font.BOLD, 15));
		comboBox_TrangThai.setModel(new DefaultComboBoxModel<String>(new String[] {"Chưa Thanh Toán", "Đã Thanh Toán"}));
		comboBox_TrangThai.setBounds(440, 5, 200, 30);
		panel_1.add(comboBox_TrangThai);
		
		//--- cuối góc phải là 3 nút jbutton
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Arial", Font.BOLD, 15));
		btnTimKiem.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Research_icon.png"));
		btnTimKiem.setBounds(350, 45, 290, 30);
		btnTimKiem.setBackground(new Color(13,153,255,255));
		btnTimKiem.setBorder(new RoundedBorder(20));
		panel_1.add(btnTimKiem);
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Refresh_icon.png"));
		btnLamMoi.setFont(new Font("Arial", Font.BOLD, 15));
		btnLamMoi.setBounds(650, 5, 125, 30);
		btnLamMoi.setBackground(new Color(112,210,103,255));
		btnLamMoi.setBorder(new RoundedBorder(10));
		panel_1.add(btnLamMoi);
		
		
		// bảng Phiếu ĐẶt Phòng
		model = new DefaultTableModel(col, 0);
		tblPhieuDatPhong = new JTable(model);
		tblPhieuDatPhong.setFont(new Font("Arial", Font.PLAIN, 12));
		tblPhieuDatPhong.setBackground(Color.WHITE);
		JScrollPane sp = new JScrollPane(tblPhieuDatPhong);
		sp.setBounds(5, 90, 770, 210);
		panel_1.add(sp);
		panel_1.setPreferredSize(new Dimension(800, 300));
		
		// các nút jbutton-------------------------------------------------------------------
		btn_NhanPhong = new JButton("Nhận Phòng");
		btn_NhanPhong.setBackground(Color.GREEN);
		btn_NhanPhong.setForeground(Color.WHITE);
		btn_NhanPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_NhanPhong.setBackground(new Color(33,167,38,255));
		btn_NhanPhong.setBorder(new RoundedBorder(20));
		btn_NhanPhong.setBounds(10, 330, 150, 40);
		panel_1.add(btn_NhanPhong);
		
		btn_HuyPhong = new JButton("Hủy Phòng");
		btn_HuyPhong.setForeground(Color.WHITE);
		btn_HuyPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_HuyPhong.setBackground(new Color(236,52,52,255));
		btn_HuyPhong.setBounds(170, 330, 150, 40);
		btn_HuyPhong.setBorder(new RoundedBorder(20));
		panel_1.add(btn_HuyPhong);
		
		btn_XemPhong = new JButton("Xem Phòng");
		btn_XemPhong.setForeground(Color.WHITE);
		btn_XemPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_XemPhong.setBackground(new Color(13,153,255,255));
		btn_XemPhong.setBorder(new RoundedBorder(20));
		btn_XemPhong.setBounds(330, 330, 150, 40);
		panel_1.add(btn_XemPhong);
		
		btn_XuatPhong = new JButton("Xuất PDF");
		btn_XuatPhong.setForeground(Color.WHITE);
		btn_XuatPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_XuatPhong.setBackground(new Color(13,153,255,255));
		btn_XuatPhong.setBorder(new RoundedBorder(20));
		btn_XuatPhong.setBounds(575, 330, 200, 40);
		panel_1.add(btn_XuatPhong);
		
		btn_QuayLai = new JButton("Quay Lại");
		btn_QuayLai.setForeground(Color.WHITE);
		btn_QuayLai.setFont(new Font("Arial", Font.BOLD, 15));
		btn_QuayLai.setBackground(new Color(236,52,52,255));
		btn_QuayLai.setBorder(new RoundedBorder(20));
		btn_QuayLai.setBounds(650, 45, 125, 30);
		panel_1.add(btn_QuayLai);
		
		//add sự kiện
		btn_HuyPhong.addActionListener(this);
		btn_NhanPhong.addActionListener(this);
		btn_QuayLai.addActionListener(this);
		btn_XemPhong.addActionListener(this);
		btn_XuatPhong.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
	}


	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btn_QuayLai)) {
		setVisible(false);	
		}
		
	}
}
