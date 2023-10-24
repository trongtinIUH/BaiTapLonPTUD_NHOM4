package app;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GD_DanhSachPhong extends JPanel {
	public GD_DanhSachPhong() {
		JLabel lblTitle;
		JPanel pnNorth = new JPanel();
		pnNorth.add(lblTitle = new JLabel("Danh sách phòng"));
		add(pnNorth);
	}
}
