package app;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GD_HoaDon extends JPanel {
	public GD_HoaDon() {
		JLabel lblTitle;
		JPanel pnNorth = new JPanel();
		pnNorth.add(lblTitle = new JLabel("Hóa đơn"));
		add(pnNorth);
	}
}
