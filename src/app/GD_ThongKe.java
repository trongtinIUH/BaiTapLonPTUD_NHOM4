package app;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GD_ThongKe extends JPanel {
	public GD_ThongKe() {
		JLabel lblTitle;
		JPanel pnNorth = new JPanel();
		pnNorth.add(lblTitle = new JLabel("Thống kê"));
		add(pnNorth);
	}
}
