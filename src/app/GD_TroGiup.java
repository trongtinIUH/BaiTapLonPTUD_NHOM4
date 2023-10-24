package app;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GD_TroGiup extends JPanel {
	public GD_TroGiup() {
		JLabel lblTitle;
		JPanel pnNorth = new JPanel();
		pnNorth.add(lblTitle = new JLabel("Trợ giúp"));
		add(pnNorth);
	}
}
