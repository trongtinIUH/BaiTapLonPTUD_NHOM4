package app;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GD_NhanVien extends JPanel {
	public GD_NhanVien() {
		JLabel lblTitle;
		JPanel pnNorth = new JPanel();
		pnNorth.add(lblTitle = new JLabel("Nhân Viên"));
		add(pnNorth);
	}
}
