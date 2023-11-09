package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.UIManager;

public class Dialog_User extends JDialog implements ActionListener{
	private JTextField txt_HoTen;
	private JButton btnThot;
	private Container btnChiTietNV;
	private JLabel lbl_HoTen;
	private JLabel lbl_ChucVu;
	private JTextField txtQunL;
	private JLabel hinhNV;
	private JLabel lbl_nen;
	public Dialog_User() {
		setTitle("User");
		setSize(400, 300);
		setLocationRelativeTo(null);
		//setResizable(false);
		
	      ImageIcon phongtrong = new ImageIcon("image\\nv1.jpg");
	      Image originalImage_phongtrong = phongtrong.getImage();
	      Image resizedImage_phongtrong = originalImage_phongtrong.getScaledInstance(130, 150, java.awt.Image.SCALE_SMOOTH);
	      ImageIcon resizedIcon_phongtrong = new ImageIcon(resizedImage_phongtrong);
	      
		
		
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		hinhNV = new JLabel("");
		hinhNV.setBounds(0, 10, 120, 150);
		hinhNV.setIcon(resizedIcon_phongtrong);
		getContentPane().add(hinhNV);
		
		 btnChiTietNV = new JButton("Xem Chi Tiết");
		 btnChiTietNV.setBounds(10, 180, 130, 40);
		 btnChiTietNV.setBackground(SystemColor.info);
		btnChiTietNV.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(btnChiTietNV);
		
		 btnThot = new JButton("Đăng Xuất");
		 btnThot.setBounds(210, 180, 130, 40);
		 btnThot.setBackground(UIManager.getColor("Button.background"));
		 btnThot.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(btnThot);
		
		JLabel lblthongtinNV = new JLabel("Thông Tin Nhân Viên");
		lblthongtinNV.setBounds(150, 5, 200, 30);
		lblthongtinNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblthongtinNV.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblthongtinNV);
		
		txt_HoTen = new JTextField();
		txt_HoTen.setBackground(SystemColor.inactiveCaptionBorder);
		txt_HoTen.setBounds(210, 50, 160, 30);
		txt_HoTen.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_HoTen.setText("Trần Trọng Tín");
		getContentPane().add(txt_HoTen);
		txt_HoTen.setColumns(10);
		
		lbl_HoTen = new JLabel("Họ tên:");
		lbl_HoTen.setBounds(130, 50, 62, 30);
		lbl_HoTen.setFont(new Font("Arial", Font.BOLD, 15));
		getContentPane().add(lbl_HoTen);
		
		lbl_ChucVu = new JLabel("Chức vụ:");
		lbl_ChucVu.setBounds(130, 100, 70, 30);
		lbl_ChucVu.setFont(new Font("Arial", Font.BOLD, 15));
		getContentPane().add(lbl_ChucVu);
		
		txtQunL = new JTextField();
		txtQunL.setBackground(SystemColor.inactiveCaptionBorder);
		txtQunL.setBounds(210, 100, 160, 30);
		txtQunL.setText("Nhân viên quản lý");
		txtQunL.setFont(new Font("Arial", Font.PLAIN, 14));
		txtQunL.setColumns(10);
		getContentPane().add(txtQunL);
		
		lbl_nen = new JLabel("");
		lbl_nen.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\image\\nenUser.jpg"));
		lbl_nen.setBounds(0, 0, 384, 261);
		getContentPane().add(lbl_nen);
		
		btnThot.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThot)) {
			Window[] windows = Window.getWindows();
			for (Window window : windows) {
				window.dispose();
			}
			GD_TrangDangNhap dangNhap = new GD_TrangDangNhap();
			dangNhap.setVisible(true);
		}
	}}	
	

