package app;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class GiaoDienDatPhong_Panel extends JPanel implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnUser;
	private JComboBox comboBox_;
	private JComboBox comboBox_TrangThai;
	private JTextField txtSoNguoi;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public GiaoDienDatPhong_Panel() {
		this.setSize(1080, 730);
		setLayout(null);
		//---gốc chứa all panel con
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1080, 730);
		panel.setBackground(Color.green);
		add(panel);
		panel.setLayout(null);
		//---gốc 1
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1080, 35);
		panel_1.setBackground(new Color(181,230,251,255));
		panel_1.setLayout(null);
		JLabel lblTieuDe = new JLabel("ĐẶT PHÒNG");
		lblTieuDe.setBounds(501, 5, 92, 30);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblTieuDe);
		panel.add(panel_1);
		//---nút user
		btnUser = new JButton("");
		btnUser.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\user.png"));
		btnUser.setBounds(1019, 0, 61, 35);
		btnUser.setBackground(new Color(181,230,251,255));
		panel_1.add(btnUser);
		//---gốc 2
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 35, 1080, 130);
		panel.add(panel_2);
		panel_2.setLayout(null);
		//--- lbl và combox trạng thái
		JLabel lblTrangThai = new JLabel("Trạng Thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTrangThai.setBounds(30, 10, 93, 25);
		panel_2.add(lblTrangThai);
		
		comboBox_TrangThai = new JComboBox();
		comboBox_TrangThai.setBackground(Color.WHITE);
		comboBox_TrangThai.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox_TrangThai.setModel(new DefaultComboBoxModel(new String[] {"Trống", "Chờ", "Đang Sử Dụng", "Sửa Chửa"}));
		comboBox_TrangThai.setBounds(130, 10, 185, 25);
		panel_2.add(comboBox_TrangThai);
		
		JLabel lblLoiPhng = new JLabel("Loại Phòng");
		lblLoiPhng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLoiPhng.setBounds(30, 62, 93, 25);
		panel_2.add(lblLoiPhng);
		
		JComboBox comboBox_LoaiPhong = new JComboBox();
		comboBox_LoaiPhong.setModel(new DefaultComboBoxModel(new String[] {"Phòng Vip", "Phòng Thường"}));
		comboBox_LoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox_LoaiPhong.setBackground(Color.WHITE);
		comboBox_LoaiPhong.setBounds(130, 62, 185, 25);
		panel_2.add(comboBox_LoaiPhong);
		
		JLabel lblSoNguoi = new JLabel("Số Người");
		lblSoNguoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoNguoi.setBounds(406, 14, 79, 25);
		panel_2.add(lblSoNguoi);
		
		JLabel lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaPhong.setBounds(406, 62, 79, 25);
		panel_2.add(lblMaPhong);
		
		txtSoNguoi = new JTextField();
		txtSoNguoi.setEditable(false);
		txtSoNguoi.setText("10");
		txtSoNguoi.setBounds(509, 14, 102, 25);
		panel_2.add(txtSoNguoi);
		txtSoNguoi.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(509, 62, 102, 25);
		panel_2.add(textField);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setBounds(694, 16, 89, 23);
		panel_2.add(btnTimKiem);
		
		
		//thêm sự kiện
		btnUser.addActionListener(this);
		btnUser.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		btnUser.setBackground(Color.WHITE);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		btnUser.setBackground(new Color(181,230,251,255));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
