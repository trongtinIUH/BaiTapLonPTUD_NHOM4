package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.DangNhap_dao;


public class GD_TrangDangNhap extends JFrame  implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
    private JTextField txtUsername, txtPassword;
    private JButton btnLogin, btnQuenMatKhau;
	private JLabel lblKaeaoke;
	private DangNhap_dao dangNhap_dao= new DangNhap_dao();
	private GD_TrangChu gd_TrangChu = new GD_TrangChu();
	private String username;

	public GD_TrangDangNhap() {
		setTitle("Đăng Nhập KARAOKE 4T");
		setSize(720, 400);
		setLocationRelativeTo(null);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon("image\\\\hinh_trangdangnhap.jpg");
	    this.setIconImage(icon.getImage());
		

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255,255,255,255));
		
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

		btnQuenMatKhau = new JButton("Quên Mật Khẩu?");
		btnQuenMatKhau.setBounds(90, 220, 130, 20);
		btnQuenMatKhau.setFont(new Font("Arial", Font.PLAIN, 10));
		btnQuenMatKhau.setForeground(Color.black);
		btnQuenMatKhau.setBackground(Color.white);
		panel.add(btnQuenMatKhau);

		
		lblKaeaoke= new JLabel("KARAOKE 4T");
		lblKaeaoke.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaeaoke.setBounds(30, 330, 250, 30);
		lblKaeaoke.setFont(new Font("Arial", Font.BOLD, 18));
		lblKaeaoke.setForeground(Color.black);
		panel.add(lblKaeaoke);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("image\\hinh_trangdangnhap.jpg"));
		label.setBounds(300, 10, 370, 350);
		ImageIcon hinhgt= new ImageIcon("image\\hinh_trangdangnhap.jpg");
		Image image = hinhgt.getImage();
		Image newImage = image.getScaledInstance(370, 350, java.awt.Image.SCALE_SMOOTH);
		hinhgt = new ImageIcon(newImage);
		label.setIcon(hinhgt);
		panel.add(label);
		
		JLabel label1 = new JLabel("");
		label1.setIcon(new ImageIcon("image\\hinh_trangDN1.jpg"));
		label1.setBounds(0, 260, 50, 50);
		ImageIcon hinhgt1= new ImageIcon("image\\hinh_trangDN1.jpg");
		Image image1 = hinhgt1.getImage();
		Image newImage1 = image1.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		hinhgt1 = new ImageIcon(newImage1);
		label1.setIcon(hinhgt1);
		panel.add(label1);
		this.add(panel);
		// nhấp nháy 
        txtUsername.addFocusListener(new FocusListener() { // Thêm FocusListener
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUsername.getText().equals("Tên đăng nhập")) {
                    txtUsername.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtUsername.getText().isEmpty()) {
                    txtUsername.setText("Tên đăng nhập");
                }
            }
        });
        
//        DataManager.setUserName(txtUsername.getText());
		
        btnLogin.addActionListener(this);
        btnQuenMatKhau.addActionListener(this);
        
	}
	
	public static void main(String[] args) {
		ImageIcon img = new ImageIcon("icon\\icon_Karaoke3.jpg");
		GD_TrangDangNhap trangDangNhap = new GD_TrangDangNhap();
		trangDangNhap.setVisible(true);
		trangDangNhap.setIconImage(img.getImage());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		DataManager.setUserName(txtUsername.getText());
		Object o = e.getSource();
		if (o.equals(btnLogin)) {
			username = txtUsername.getText();
			char[] mk = ((JPasswordField) txtPassword).getPassword();
			String mkstr=new String(mk);
			if(dangNhap_dao.Timkiem(username, mkstr)==true){
				gd_TrangChu.setVisible(true);	
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu!");
			}

		}
		else if (o.equals(btnQuenMatKhau)) {
			GD_QuenMatKhau quenmk= new GD_QuenMatKhau();
			quenmk.setVisible(true);	
			dispose();
		}
	}	
}


