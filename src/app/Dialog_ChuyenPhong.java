package app;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Dialog_ChuyenPhong extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox_TrangThai,comboBox_LoaiPhong;
	private JTextField txtSoNguoi;
	private JTextField txtMaPhong;
	private JButton btnTimKiem,btnLamMoi;
	private JPanel panel_1,panel_2,panel;
	
	public Dialog_ChuyenPhong() {
		getContentPane().setBackground(Color.WHITE);
		setSize(750, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//panel chứa tiêu đề--------------------------------------
		panel = new JPanel();
		panel.setBounds(0, 0, 784, 35);
		panel.setBackground(new Color(181, 230, 251));
		getContentPane().add(panel);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		JLabel lblTieuDe = new JLabel("Chuyển Phòng");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 790, 35);
		panel.add(lblTieuDe);

	}

	
}
