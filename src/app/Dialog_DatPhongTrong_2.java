package app;

import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Dialog_DatPhongTrong_2 extends JDialog implements ActionListener{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSDT;
	private JButton btn_KiemTraSDT,btn_ThemDV, btn_QuayLai, btn_DatPhong;
	private JPanel panel_1,panel_2;
	private JCheckBox checkBox_KH;
	private JLabel lbl_GioiTinh_1,lbl_SoNguoi_1,lbl_GiaTien_1,lbl_TenKH_1;
	private JTextArea txtThemDV;
	private JButton btn_DatThemPhong;
	private JComboBox<String> comboBox_TrangThai,comboBox_LoaiPhong;
	
	private JTable tblThemPhongMoi;
	private DefaultTableModel model;
	private String col[] = { "Mã Phòng", "Loại Phòng", "Số Người", "Đơn Giá", "Trạng Thái" };

	private Dialog_DatThemPhongTrong dialog_DatThemPhongTrong = new Dialog_DatThemPhongTrong();
	private Dialog_ThemDichVu dialog_ThemDichVu= new Dialog_ThemDichVu();
	private JLabel lbl_TrangThai,lbl_Loai,lbl_sdtKH,lbl_TenKH,lbl_GioiTinh,lbl_GiaTien,lbl_SoNguoi,lbl_LoaiKhachHang;

	
	public Dialog_DatPhongTrong_2() {
		//màn hình******************************************************************************
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setSize(800, 500);
		setLocationRelativeTo(null);

		
		//panel chứa tiêu đề--------------------------------------
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 35);
		panel.setBackground(new Color(181, 230, 251));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Đặt Phòng");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 790, 35);
		panel.add(lblTieuDe);
		
		//pane; chứa các phần còn lại---------------------------------
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 35, 784, 426);
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
		
		lbl_LoaiKhachHang = new JLabel("Khách hàng mặc định:");
		lbl_LoaiKhachHang.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_LoaiKhachHang.setBounds(20, 70, 180, 25);
		panel_1.add(lbl_LoaiKhachHang);
		
		checkBox_KH = new JCheckBox("");
		checkBox_KH.setBackground(Color.WHITE);
		checkBox_KH.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_KH.setFont(new Font("Arial", Font.BOLD, 15));
		checkBox_KH.setBounds(205, 70, 37, 30);
		panel_1.add(checkBox_KH);
		
		panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setBounds(15, 100, 760, 40);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		lbl_sdtKH = new JLabel("SDT khách:");
		lbl_sdtKH.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sdtKH.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_sdtKH.setBounds(5, 5, 130, 30);
		panel_2.add(lbl_sdtKH);
		
		txtSDT = new JTextField();
		txtSDT.setHorizontalAlignment(SwingConstants.LEFT);
		txtSDT.setFont(new Font("Arial", Font.BOLD, 16));
		txtSDT.setText("0947677077");
		txtSDT.setBounds(140, 5, 300, 30);
		panel_2.add(txtSDT);
		txtSDT.setColumns(10);

		lbl_TenKH = new JLabel("Tên khách hàng:");
		lbl_TenKH.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TenKH.setBounds(20, 145, 135, 30);
		panel_1.add(lbl_TenKH);
		
		lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioiTinh.setBounds(450, 145, 77, 30);
		panel_1.add(lbl_GioiTinh);
		
		lbl_GioiTinh_1 = new JLabel("Nam");
		lbl_GioiTinh_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioiTinh_1.setBounds(550, 145, 100, 30);
		panel_1.add(lbl_GioiTinh_1);
		
		lbl_GiaTien = new JLabel("Giá tiền:");
		lbl_GiaTien.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GiaTien.setBounds(440, 35, 80, 25);
		panel_1.add(lbl_GiaTien);
		
		lbl_SoNguoi = new JLabel("Số người:");
		lbl_SoNguoi.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SoNguoi.setBounds(440, 5, 80, 25);
		panel_1.add(lbl_SoNguoi);
		
		lbl_SoNguoi_1 = new JLabel("7");
		lbl_SoNguoi_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SoNguoi_1.setBounds(550, 5, 100, 25);
		panel_1.add(lbl_SoNguoi_1);
		
		lbl_GiaTien_1 = new JLabel("80,000 VNĐ");
		lbl_GiaTien_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GiaTien_1.setBounds(550, 35, 200, 25);
		panel_1.add(lbl_GiaTien_1);
		
		lbl_TenKH_1 = new JLabel("Nguyễn Văn A");
		lbl_TenKH_1.setFont(new Font("Arial", Font.ITALIC, 17));
		lbl_TenKH_1.setBounds(165, 145, 180, 30);
		panel_1.add(lbl_TenKH_1);
		
		 txtThemDV = new JTextArea();
		 txtThemDV.setFont(new Font("Monospaced", Font.BOLD, 13));
		 txtThemDV.setEditable(false);
		 txtThemDV.setText("bia, nước ngọt, bánh trung thu");
		 txtThemDV.setBackground(SystemColor.control);
		 txtThemDV.setBounds(175, 340, 600, 30);
		 panel_1.add(txtThemDV);
		
		// các nút jbutton-------------------------------------------------------------------
		btn_DatPhong = new JButton("Đặt Phòng");
		btn_DatPhong.setBackground(Color.GREEN);
		btn_DatPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_DatPhong.setBackground(new Color(33,167,38,255));
		btn_DatPhong.setBounds(20, 380, 200, 40);
		panel_1.add(btn_DatPhong);
		
		btn_QuayLai = new JButton("Quay Lại");
		btn_QuayLai.setFont(new Font("Arial", Font.BOLD, 18));
		btn_QuayLai.setBackground(new Color(255,83,83,255));
		btn_QuayLai.setBounds(560, 380, 200, 40);
		panel_1.add(btn_QuayLai);
		
		btn_ThemDV = new JButton("Thêm DV");
		btn_ThemDV.setBackground(Color.LIGHT_GRAY);
		btn_ThemDV.setFont(new Font("Arial", Font.BOLD, 15));
		btn_ThemDV.setBounds(20, 340, 120, 30);
		panel_1.add(btn_ThemDV);
		
		btn_KiemTraSDT = new JButton("Kiểm Tra");
		btn_KiemTraSDT.setBackground(new Color(0, 255, 0));
		btn_KiemTraSDT.setFont(new Font("Arial", Font.BOLD, 17));
		btn_KiemTraSDT.setBounds(480, 5, 200, 30);
		panel_2.add(btn_KiemTraSDT);
				
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
		
		btn_DatThemPhong = new JButton("Đặt Thêm Phòng");
		btn_DatThemPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_DatThemPhong.setBackground(Color.GREEN);
		btn_DatThemPhong.setBounds(265, 380, 250, 40);
		panel_1.add(btn_DatThemPhong);
		
		// bảng thêm phòng mới
		model = new DefaultTableModel(col, 0);
		tblThemPhongMoi = new JTable(model);
		tblThemPhongMoi.setFont(new Font("Arial", Font.PLAIN, 12));
		tblThemPhongMoi.setBackground(Color.WHITE);
		JScrollPane sp = new JScrollPane(tblThemPhongMoi);
		sp.setBounds(10, 190, 765, 140);
		panel_1.add(sp);
		panel_1.setPreferredSize(new Dimension(800, 300));

		//thêm sự kiện button
		btn_DatPhong.addActionListener(this);
		btn_KiemTraSDT.addActionListener(this);
		btn_QuayLai.addActionListener(this);
		btn_ThemDV.addActionListener(this);
		btn_DatThemPhong.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btn_QuayLai)) {
		setVisible(false);	
		}
		if(o.equals(btn_ThemDV)) {
		dialog_ThemDichVu.setVisible(true);	
		}
		if(o.equals(btn_DatThemPhong)) {
			dialog_DatThemPhongTrong.setVisible(true);	
			}
		if(o.equals(btn_DatPhong)) {
			JOptionPane.showMessageDialog(this, "Đặt thành công, thời gian sử dụng bắt đầu ghi nhận !");
			setVisible(false);
			
			
			//đóng toàn bộ dialog ra ngoài màn hình chính
	        Window[] windows = Window.getWindows();
	        for (Window window : windows) {
	            if (window instanceof JDialog) {
	                window.dispose();
	            }
	        }
			}
	}
}
