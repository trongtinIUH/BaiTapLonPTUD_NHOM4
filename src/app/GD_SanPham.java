package app;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GD_SanPham extends JPanel {
	public GD_SanPham() {
		JLabel lblTitle;
		JPanel pnNorth = new JPanel();
		pnNorth.add(lblTitle = new JLabel("Sản phẩm"));
		add(pnNorth);
	}
}
