package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Dialog_HienThiPhong extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPhong, lblLoai, lblSucChua, lblTrangThai, lblGia,lblLoai_1,lblSucChua_1,lbltrangthai_1,lblgia_1,lblPhong_1;
	private JButton btnDatPhong;
	 
	private Dialog_DatPhongTrong_2 dialog_DatPhongTrong_2= new Dialog_DatPhongTrong_2();
	
	public Dialog_HienThiPhong() {
		//kích thước dialog--------------*****************************************************************
		getContentPane().setBackground(Color.WHITE);
		setSize(300, 290);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//các lbl-----------------------------------------------------------------------
		lblPhong = new JLabel("Phòng:");
		lblPhong.setFont(new Font("Arial", Font.BOLD, 18));
		lblPhong.setBounds(20, 10, 100, 30);
		getContentPane().add(lblPhong);
		
		lblLoai = new JLabel("Loại:");
		lblLoai.setFont(new Font("Arial", Font.BOLD, 18));
		lblLoai.setBounds(20, 50, 100, 30);
		getContentPane().add(lblLoai);
		
		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setFont(new Font("Arial", Font.BOLD, 18));
		lblSucChua.setBounds(20, 90, 100, 30);
		getContentPane().add(lblSucChua);
		
		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Arial", Font.BOLD, 18));
		lblTrangThai.setBounds(20, 130, 100, 30);
		getContentPane().add(lblTrangThai);
		
		lblGia = new JLabel("Giá:");
		lblGia.setFont(new Font("Arial", Font.BOLD, 18));
		lblGia.setBounds(20, 170, 100, 30);
		getContentPane().add(lblGia);

		//nút button---------------------------------------------------------------------------
		btnDatPhong = new JButton("Đặt Phòng");
		btnDatPhong.setForeground(Color.WHITE);
		btnDatPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btnDatPhong.setBackground(new Color(33,167,38,255));
		btnDatPhong.setBounds(40, 210, 200, 35);
		btnDatPhong.setBorderPainted(false);
		getContentPane().add(btnDatPhong);
		
		lblPhong_1 = new JLabel("301");
		lblPhong_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhong_1.setBounds(130, 10, 120, 30);
		getContentPane().add(lblPhong_1);
		
		lblLoai_1 = new JLabel("Thường");
		lblLoai_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblLoai_1.setBounds(130, 50, 120, 30);
		getContentPane().add(lblLoai_1);
		
		lblSucChua_1 = new JLabel("10");
		lblSucChua_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblSucChua_1.setBounds(130, 90, 120, 30);
		getContentPane().add(lblSucChua_1);
		
		lbltrangthai_1 = new JLabel("Trống");
		lbltrangthai_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbltrangthai_1.setBounds(130, 130, 120, 30);
		getContentPane().add(lbltrangthai_1);
		
		lblgia_1 = new JLabel("80,000 VNĐ");
		lblgia_1.setBackground(Color.WHITE);
		lblgia_1.setForeground(Color.RED);
		lblgia_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblgia_1.setBounds(130, 170, 120, 30);
		getContentPane().add(lblgia_1);
		//add sự kiện
		btnDatPhong.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDatPhong)) {
			dialog_DatPhongTrong_2.setVisible(true);
		
		}
		
	}
}
