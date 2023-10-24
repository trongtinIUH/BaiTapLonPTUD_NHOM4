package app;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GD_DatPhong extends JPanel {
	public GD_DatPhong() {
		JLabel lblTitle;
		JPanel pnNorth = new JPanel();
		pnNorth.add(lblTitle = new JLabel("Đặt phòng"));
		add(pnNorth);
	}
}
