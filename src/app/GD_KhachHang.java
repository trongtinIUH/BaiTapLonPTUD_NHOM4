package app;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GD_KhachHang extends JPanel {
	public GD_KhachHang() {
		JLabel lblTitle;
		JPanel pnNorth = new JPanel();
		pnNorth.add(lblTitle = new JLabel("Khách hàng"));
		add(pnNorth);
	}
}
