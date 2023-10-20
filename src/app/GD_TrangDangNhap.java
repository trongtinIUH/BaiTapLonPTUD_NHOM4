package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GD_TrangDangNhap extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle, lblUsername, lblPassword;
    private JTextField txtUsername, txtPassword;
    private JButton btnLogin, btnExit;
    private String user="123";
	private String pass= "123";
	private JLabel lblQuenMatKhau;

	public GD_TrangDangNhap() {
		setTitle("đăng nhập");
		setSize(720, 400);
		setLocationRelativeTo(null);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 240, 240));
		
		lblTitle = new JLabel("KARAOKE 4T");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 32));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(5, 30, 300, 45);
		lblTitle.setForeground(Color.black);
		panel.add(lblTitle);



		txtUsername = new JTextField(20);
		txtUsername.setBounds(60, 95, 200, 25);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setText("Tên đăng nhập");
		panel.add(txtUsername);



		txtPassword = new JPasswordField(20);
		txtPassword.setBounds(60, 135, 200, 25);
		txtPassword.setText("123");
		panel.add(txtPassword);

		btnLogin = new JButton("Đăng Nhập");
		btnLogin.setBounds(60, 175, 200, 35);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 18));
		btnLogin.setForeground(Color.white);
		btnLogin.setBackground(Color.black);
		panel.add(btnLogin);

		lblQuenMatKhau= new JLabel("Quên Mật Khẩu?");
		lblQuenMatKhau.setBounds(115, 205, 200, 35);
		lblQuenMatKhau.setFont(new Font("Arial", Font.BOLD, 12));
		lblQuenMatKhau.setForeground(Color.black);
		panel.add(lblQuenMatKhau);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("image\\hinh_trangdangnhap.jpg"));
		label.setBounds(300, 10, 370, 350);
		ImageIcon hinhgt= new ImageIcon("image\\hinh_trangdangnhap.jpg");
		Image image = hinhgt.getImage();
		Image newImage = image.getScaledInstance(370, 350, java.awt.Image.SCALE_SMOOTH);
		hinhgt = new ImageIcon(newImage);
		label.setIcon(hinhgt);
		panel.add(label);
		this.add(panel);
		

		
	}
	public static void main(String[] args) {
		new GD_TrangDangNhap().setVisible(true);
	}
}
