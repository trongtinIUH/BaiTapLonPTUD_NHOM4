package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.UIManager;

import entity.LoaiPhong;
import entity.Phong;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Dialog_DatPhongTrong_2 extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSDT;
	private JButton btn_KiemTraSDT, btn_ThemDV, btn_QuayLai, btn_DatPhong;
	private JPanel panel_1, panel_2;
	private JCheckBox checkBox_KH;
	private JLabel lbl_GioiTinh_1, lbl_SoNguoi_1, lbl_GiaTien_1, lbl_TenKH_1;
	private JTextArea txtThemDV;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtSoNguoi;

	public Dialog_DatPhongTrong_2(String maPhong, Phong p, LoaiPhong lp) {
		// màn
		// hình******************************************************************************
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setSize(750, 400);
		setLocationRelativeTo(null);

		// panel chứa tiêu đề--------------------------------------
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 35);
		panel.setBackground(new Color(181, 230, 251));
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTieuDe = new JLabel("Phòng " + maPhong);
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 790, 35);
		panel.add(lblTieuDe);

		// pane; chứa các phần còn lại---------------------------------
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 35, 784, 326);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lbl_TrangThai = new JLabel("Trạng thái:");
		lbl_TrangThai.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TrangThai.setBounds(20, 10, 100, 25);
		panel_1.add(lbl_TrangThai);

		JLabel lbl_Loai = new JLabel("Loại:");
		lbl_Loai.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_Loai.setBounds(20, 45, 60, 25);
		panel_1.add(lbl_Loai);

		JLabel lbl_LoaiKhachHang = new JLabel("Khách hàng mặc định:");
		lbl_LoaiKhachHang.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_LoaiKhachHang.setBounds(20, 85, 180, 25);
		panel_1.add(lbl_LoaiKhachHang);

		checkBox_KH = new JCheckBox("");
		checkBox_KH.setBackground(Color.WHITE);
		checkBox_KH.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_KH.setFont(new Font("Arial", Font.BOLD, 15));
		checkBox_KH.setBounds(205, 82, 37, 30);
		panel_1.add(checkBox_KH);

		panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setBounds(15, 120, 662, 40);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lbl_sdtKH = new JLabel("SDT khách:");
		lbl_sdtKH.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sdtKH.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_sdtKH.setBounds(5, 5, 130, 30);
		panel_2.add(lbl_sdtKH);

		txtSDT = new JTextField();
		txtSDT.setHorizontalAlignment(SwingConstants.CENTER);
		txtSDT.setFont(new Font("Arial", Font.BOLD, 16));
		txtSDT.setText("0947677077");
		txtSDT.setBounds(140, 5, 250, 30);
		panel_2.add(txtSDT);
		txtSDT.setColumns(10);

		JLabel lbl_TenKH = new JLabel("Tên khách hàng:");
		lbl_TenKH.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TenKH.setBounds(20, 170, 135, 30);
		panel_1.add(lbl_TenKH);

		JLabel lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioiTinh.setBounds(450, 170, 77, 30);
		panel_1.add(lbl_GioiTinh);

		lbl_GioiTinh_1 = new JLabel("Nam");
		lbl_GioiTinh_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioiTinh_1.setBounds(550, 170, 100, 30);
		panel_1.add(lbl_GioiTinh_1);

		JLabel lbl_GiaTien = new JLabel("Giá tiền:");
		lbl_GiaTien.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GiaTien.setBounds(450, 45, 80, 25);
		panel_1.add(lbl_GiaTien);

		JLabel lbl_SoNguoi = new JLabel("Số người:");
		lbl_SoNguoi.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SoNguoi.setBounds(450, 10, 80, 25);
		panel_1.add(lbl_SoNguoi);

		txtSoNguoi = new JTextField();
		txtSoNguoi.setText(lp.getSucChua() + "");
		txtSoNguoi.setFont(new Font("Arial", Font.BOLD, 16));
		txtSoNguoi.setBounds(550, 10, 100, 25);
		panel_1.add(txtSoNguoi);

		lbl_GiaTien_1 = new JLabel(lp.getDonGiaTheoGio() + " VNĐ");
		lbl_GiaTien_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GiaTien_1.setBounds(550, 45, 150, 25);
		panel_1.add(lbl_GiaTien_1);

		lbl_TenKH_1 = new JLabel("Nguyễn Văn A");
		lbl_TenKH_1.setFont(new Font("Arial", Font.ITALIC, 17));
		lbl_TenKH_1.setBounds(165, 170, 180, 30);
		panel_1.add(lbl_TenKH_1);

		txtThemDV = new JTextArea();
		txtThemDV.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtThemDV.setEditable(false);
		txtThemDV.setText("bia, nước ngọt, bánh trung thu");
		txtThemDV.setBackground(SystemColor.control);
		txtThemDV.setBounds(175, 210, 450, 25);
		panel_1.add(txtThemDV);

		// các nút
		// jbutton-------------------------------------------------------------------
		btn_DatPhong = new JButton("Đặt Phòng");
		btn_DatPhong.setBackground(Color.GREEN);
		btn_DatPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_DatPhong.setBackground(new Color(33, 167, 38, 255));
		btn_DatPhong.setBounds(20, 260, 300, 40);
		panel_1.add(btn_DatPhong);

		btn_QuayLai = new JButton("Quay Lại");
		btn_QuayLai.setFont(new Font("Arial", Font.BOLD, 18));
		btn_QuayLai.setBackground(new Color(255, 83, 83, 255));
		btn_QuayLai.setBounds(400, 260, 300, 40);
		panel_1.add(btn_QuayLai);

		btn_ThemDV = new JButton("Thêm DV");
		btn_ThemDV.setBackground(Color.LIGHT_GRAY);
		btn_ThemDV.setFont(new Font("Arial", Font.BOLD, 15));
		btn_ThemDV.setBounds(20, 210, 120, 23);
		panel_1.add(btn_ThemDV);

		btn_KiemTraSDT = new JButton("Kiểm Tra");
		btn_KiemTraSDT.setBackground(new Color(0, 255, 0));
		btn_KiemTraSDT.setFont(new Font("Arial", Font.BOLD, 16));
		btn_KiemTraSDT.setBounds(400, 5, 150, 30);
		panel_2.add(btn_KiemTraSDT);

		JLabel lbl_SoNguoi_1_1 = new JLabel(p.getTrangThai() + "");
		lbl_SoNguoi_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SoNguoi_1_1.setBounds(142, 10, 250, 25);
		panel_1.add(lbl_SoNguoi_1_1);

		JLabel lbl_SoNguoi_1_2 = new JLabel(lp.getTenLoaiPhong());
		lbl_SoNguoi_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SoNguoi_1_2.setBounds(142, 45, 200, 25);
		panel_1.add(lbl_SoNguoi_1_2);

		btn_DatPhong.addActionListener(this);
		btn_KiemTraSDT.addActionListener(this);
		btn_QuayLai.addActionListener(this);
		btn_ThemDV.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btn_QuayLai)) {
			setVisible(false);
		}

	}
}
