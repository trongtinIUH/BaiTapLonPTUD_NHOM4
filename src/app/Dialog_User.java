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

public class Dialog_User extends JDialog implements ActionListener{
	private JTextField txtTrnTn;
	private JButton btnThot;
	private Container btnChiTietNV;
	public Dialog_User() {
		setTitle("User");
		setSize(500, 400);
		setLocationRelativeTo(null);
		//setResizable(false);
		
	      ImageIcon phongtrong = new ImageIcon("image\\nhanvien.jpg");
	      Image originalImage_phongtrong = phongtrong.getImage();
	      Image resizedImage_phongtrong = originalImage_phongtrong.getScaledInstance(120, 100, java.awt.Image.SCALE_SMOOTH);
	      ImageIcon resizedIcon_phongtrong = new ImageIcon(resizedImage_phongtrong);
	      
		
		
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel hinhNV = new JLabel("");
		hinhNV.setIcon(resizedIcon_phongtrong);
		hinhNV.setBounds(0, 0, 159, 150);
		getContentPane().add(hinhNV);
		
		 btnChiTietNV = new JButton("Xem Chi Tiết");
		btnChiTietNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChiTietNV.setBounds(10, 161, 129, 36);
		getContentPane().add(btnChiTietNV);
		
		 btnThot = new JButton("Thoát");
		btnThot.setBounds(10, 227, 129, 23);
		getContentPane().add(btnThot);
		
		JLabel lblthongtinNV = new JLabel("Thông Tin Nhân Viên");
		lblthongtinNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblthongtinNV.setBounds(224, 0, 151, 29);
		getContentPane().add(lblthongtinNV);
		
		txtTrnTn = new JTextField();
		txtTrnTn.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTrnTn.setText("Trần Tín");
		txtTrnTn.setBounds(234, 43, 86, 20);
		getContentPane().add(txtTrnTn);
		txtTrnTn.setColumns(10);
		
		btnThot.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThot)) {
			this.setVisible(false);
			this.dispose();
		}
		
	}
}
