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

public class GiaoDienDatPhong_Panel extends JPanel implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnUser;

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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 35, 1080, 130);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trạng Thái");
		lblNewLabel.setBounds(45, 11, 130, 14);
		panel_2.add(lblNewLabel);
		
		
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
