package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GD_QuenMatKhau extends JFrame implements ActionListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblSDT,lblOTP,lblMatKhauMoi,lblNhapLaiMatKhauMoi;
	private JTextField txtSDT, txtPassword,txtPassword_New,txtOTP;
	private JLabel lblTitle;
	private JButton btnHuy,btnXacNhan,btnOTP;

	public  GD_QuenMatKhau() {
		setTitle("Quên Mật Khẩu");
		setSize(600, 350);
		setLocationRelativeTo(null);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		lblTitle = new JLabel("QUÊN MẬT KHẨU");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitle.setBounds(200, 5, 300, 45);
		lblTitle.setForeground(Color.white);
		panel.add(lblTitle);
		
		//SDT
		    lblSDT = new JLabel("Số Điện Thoại");
		    lblSDT.setFont(new Font("Arial", Font.BOLD, 12));
	        lblSDT.setBounds(10, 80, 80, 20);
	        lblSDT.setForeground(Color.white);
	        panel.add(lblSDT); 
	        
	        txtSDT = new JTextField(20);
	        txtSDT.setBounds(130, 80, 400, 20);
	        panel.add(txtSDT);
	        
		//OTP
		    lblOTP = new JLabel("Mã OTP");
		    lblOTP.setFont(new Font("Arial", Font.BOLD, 12));
		    lblOTP.setBounds(10, 110, 80, 20);
		    lblOTP.setForeground(Color.white);
	        panel.add(lblOTP); 
	        
	        txtOTP = new JTextField(20);
	        txtOTP.setBounds(130, 110, 300, 20);
	        panel.add(txtOTP);
	        
	        btnOTP = new JButton("Mã OTP");
	        btnOTP.setBounds(430, 110, 100, 20);
	        btnOTP.setFont(new Font("Arial", Font.BOLD, 12));
	        btnOTP.setForeground(Color.black);
	        btnOTP.setBackground(new Color(64,224,208));
			panel.add(btnOTP);
			
		//MK mới
		    lblMatKhauMoi = new JLabel("Nhập MK Mới");
		    lblMatKhauMoi.setFont(new Font("Arial", Font.BOLD, 12));
		    lblMatKhauMoi.setBounds(10, 140, 80, 20);
		    lblMatKhauMoi.setForeground(Color.white);
	        panel.add(lblMatKhauMoi); 
	        
	        txtPassword= new JTextField(20);
	        txtPassword.setBounds(130, 140, 300, 20);
	        panel.add(txtPassword);
			
		    lblNhapLaiMatKhauMoi = new JLabel("Nhập Lại MK");
		    lblNhapLaiMatKhauMoi.setFont(new Font("Arial", Font.BOLD, 12));
		    lblNhapLaiMatKhauMoi.setBounds(10, 170, 80, 20);
		    lblNhapLaiMatKhauMoi.setForeground(Color.white);
	        panel.add(lblNhapLaiMatKhauMoi); 
	        
	        txtPassword_New= new JTextField(20);
	        txtPassword_New.setBounds(130, 170, 300, 20);
	        panel.add(txtPassword_New);
	        
	       
	         btnXacNhan = new JButton("Xác Nhận");
	        btnXacNhan.setBounds(130, 210, 100, 30);
	        btnXacNhan.setFont(new Font("Arial", Font.BOLD, 13));
	        btnXacNhan.setForeground(Color.black);
	        btnXacNhan.setBackground(new Color(064,224,208));
			panel.add(btnXacNhan);
			
	         btnHuy = new JButton("Hủy");
	        btnHuy.setBounds(300, 210, 100, 30);
	        btnHuy.setFont(new Font("Arial", Font.BOLD, 13));
	        btnHuy.setForeground(Color.black);
	        btnHuy.setBackground(Color.white);
			panel.add(btnHuy);
	        
	        
			//hình nền
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("image\\quenmk.jpg"));
			label.setBounds(0, 0, 600, 400);
			ImageIcon hinhgt= new ImageIcon("image\\quenmk.jpg");
			Image image = hinhgt.getImage();
			Image newImage = image.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH);
			hinhgt = new ImageIcon(newImage);
			label.setIcon(hinhgt);
			panel.add(label);
			
	        
	        btnOTP.addActionListener(this);
	        btnHuy.addActionListener(this);
	        btnXacNhan.addActionListener(this);
	        this.add(panel);
	}
    public static void main(String[] args) {
    new GD_QuenMatKhau().setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnXacNhan)) {
			// thêm joption thông báo thành công rồi nhảy về trang đăng nhập//
			GD_TrangDangNhap dn= new GD_TrangDangNhap();
			dn.setVisible(true);	
			dispose();
		}
		else if(o.equals(btnHuy)) {
			// thêm joption thông báo rồi nhảy về trang đăng nhập//
			GD_TrangDangNhap dn= new GD_TrangDangNhap();
			dn.setVisible(true);	
			dispose();
		}
		else if (o.equals(btnOTP)) {
			// tự động nhập mã qua txt otp
		}
//		
	}


}
