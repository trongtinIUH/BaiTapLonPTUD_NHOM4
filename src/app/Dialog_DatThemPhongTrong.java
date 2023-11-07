package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Dialog_DatThemPhongTrong extends JDialog implements ActionListener{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn_ThemDV, btn_QuayLai, btn_DatPhong;
	private JPanel panel_1;
	private JLabel lbl_SucChua_1,lbl_GiaTien_1;
	private JComboBox<String> comboBox_TrangThai,comboBox_LoaiPhong;
	
	private JTable tblThemPhongMoi;
	private DefaultTableModel model;
	private String col[] = { "Mã Phòng", "Loại Phòng", "Sức Chứa", "Đơn Giá", "Trạng Thái" };
	private JLabel lbl_SoNguoi;
	private JTextField txt_SoNguoi;
	private JTextArea txtThemDV;
	private JButton btn_LamMoi;

	private Dialog_ThemDichVu dialog_ThemDichVu=new Dialog_ThemDichVu();
	private JLabel lbl_TrangThai;
	private JLabel lbl_Loai;
	private JLabel lbl_GiaTien;
	private JLabel lbl_SucChua;
	
	public Dialog_DatThemPhongTrong() {
		//màn hình******************************************************************************
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setSize(800, 400);
		setLocationRelativeTo(null);

		
		//panel chứa tiêu đề--------------------------------------
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 35);
		panel.setBackground(new Color(181, 230, 251));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Đặt Thêm Phòng");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 790, 35);
		panel.add(lblTieuDe);
		
		//pane; chứa các phần còn lại---------------------------------
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 35, 784, 326);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lbl_TrangThai = new JLabel("Trạng thái:");
		lbl_TrangThai.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TrangThai.setBounds(20, 5, 100, 25);
		panel_1.add(lbl_TrangThai);
		
		lbl_Loai = new JLabel("Loại:");
		lbl_Loai.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_Loai.setBounds(20, 35, 60, 25);
		panel_1.add(lbl_Loai);
		
		lbl_GiaTien = new JLabel("Giá tiền:");
		lbl_GiaTien.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GiaTien.setBounds(440, 35, 80, 25);
		panel_1.add(lbl_GiaTien);
		
		lbl_SucChua = new JLabel("Sức chứa:");
		lbl_SucChua.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SucChua.setBounds(440, 5, 90, 25);
		panel_1.add(lbl_SucChua);
		
		lbl_SucChua_1 = new JLabel("10");
		lbl_SucChua_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SucChua_1.setBounds(550, 5, 100, 25);
		panel_1.add(lbl_SucChua_1);
		
		lbl_GiaTien_1 = new JLabel("80,000 VNĐ");
		lbl_GiaTien_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GiaTien_1.setBounds(550, 35, 200, 25);
		panel_1.add(lbl_GiaTien_1);
		
		// các nút jbutton-------------------------------------------------------------------
		btn_DatPhong = new JButton("Đặt Phòng ");
		btn_DatPhong.setBackground(Color.GREEN);
		btn_DatPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_DatPhong.setBackground(new Color(33,167,38,255));
		btn_DatPhong.setBounds(20, 280, 200, 40);
		panel_1.add(btn_DatPhong);
		
		btn_QuayLai = new JButton("Quay Lại");
		btn_QuayLai.setFont(new Font("Arial", Font.BOLD, 18));
		btn_QuayLai.setBackground(new Color(255,83,83,255));
		btn_QuayLai.setBounds(560, 280, 200, 40);
		panel_1.add(btn_QuayLai);
				
		comboBox_TrangThai = new JComboBox<String>();
		comboBox_TrangThai.setBackground(Color.WHITE);
		comboBox_TrangThai.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox_TrangThai.setModel(new DefaultComboBoxModel<String>(new String[] {"Trống", "Chờ", "Đang Sử Dụng", "Sửa Chửa"}));
		comboBox_TrangThai.setBounds(142, 5, 250, 25);
		panel_1.add(comboBox_TrangThai);

		comboBox_LoaiPhong = new JComboBox<String>();
		comboBox_LoaiPhong.setModel(new DefaultComboBoxModel<String>(new String[] {"Phòng Vip", "Phòng Thường"}));
		comboBox_LoaiPhong.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox_LoaiPhong.setBackground(Color.WHITE);
		comboBox_LoaiPhong.setBounds(142, 35, 200, 25);
		panel_1.add(comboBox_LoaiPhong);
		
		// bảng thêm phòng mới
		model = new DefaultTableModel(col, 0);
		tblThemPhongMoi = new JTable(model);
		tblThemPhongMoi.setFont(new Font("Arial", Font.PLAIN, 12));
		tblThemPhongMoi.setBackground(Color.WHITE);
		JScrollPane sp = new JScrollPane(tblThemPhongMoi);
		sp.setBounds(10, 70, 765, 140);
		panel_1.add(sp);
		panel_1.setPreferredSize(new Dimension(800, 300));
		
		lbl_SoNguoi = new JLabel("Số người:");
		lbl_SoNguoi.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SoNguoi.setBounds(10, 220, 80, 30);
		panel_1.add(lbl_SoNguoi);
		
		txt_SoNguoi = new JTextField();
		txt_SoNguoi.setText("8");
		txt_SoNguoi.setFont(new Font("Arial", Font.BOLD, 18));
		txt_SoNguoi.setBounds(100, 220, 50, 30);
		panel_1.add(txt_SoNguoi);
		txt_SoNguoi.setColumns(10);
		
		txtThemDV = new JTextArea();
		txtThemDV.setRows(2);
		txtThemDV.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtThemDV.setEditable(false);
		txtThemDV.setText("bia, nước ngọt, bánh trung thu");
		txtThemDV.setBackground(SystemColor.control);
		txtThemDV.setBounds(299, 220, 476, 50);
		panel_1.add(txtThemDV);
		 
		btn_ThemDV = new JButton("Thêm DV");
		btn_ThemDV.setBackground(Color.LIGHT_GRAY);
		btn_ThemDV.setFont(new Font("Arial", Font.BOLD, 18));
		btn_ThemDV.setBounds(169, 220, 120, 30);
		panel_1.add(btn_ThemDV);
		
		btn_LamMoi = new JButton("Làm Mới");
		btn_LamMoi.setFont(new Font("Arial", Font.BOLD, 18));
		btn_LamMoi.setBackground(Color.GREEN);
		btn_LamMoi.setBounds(241, 280, 200, 40);
		panel_1.add(btn_LamMoi);

		//thêm sự kiện button
		btn_DatPhong.addActionListener(this);
		btn_QuayLai.addActionListener(this);
		btn_ThemDV.addActionListener(this);
		btn_LamMoi.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btn_QuayLai)) {
		setVisible(false);	
		}
		if(o.equals(btn_DatPhong)) {
		JOptionPane.showMessageDialog(this, "Đặt thêm phòng mới thành công !");	
		}
		if(o.equals(btn_LamMoi)) {
		lbl_GiaTien_1.setText("");
		lbl_SucChua_1.setText("");
		txt_SoNguoi.setText("");
		txtThemDV.setText("");
		txt_SoNguoi.requestFocus();
		}
		if(o.equals(btn_ThemDV)) {
			dialog_ThemDichVu.setVisible(true);
			}
		
		
	}
}
