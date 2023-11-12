package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import dao.Phong_dao;
import dao.TempDatPhong_dao;
import entity.LoaiPhong;
import entity.Phong;
import entity.TempDatPhong;
import dao.LoaiPhong_dao;

public class Dialog_HienThiPhong extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPhong, lblLoai, lblSucChua, lblTrangThai, lblGia, lblLoai_1, lblSucChua_1, lbltrangthai_1,
			lblgia_1, lblPhong_1;
	private JButton btnDatPhong;
	private Phong_dao p_dao = new Phong_dao();
	private LoaiPhong_dao lp_dao = new LoaiPhong_dao();

	private Dialog_DatPhongTrong_2 dialog_DatPhongTrong_2;
	private Phong p;
	private LoaiPhong lp;
	private JLabel lblSoNguoi;
	private JTextField txtSoNguoi;
	private TempDatPhong_dao tmp_dao = new TempDatPhong_dao();

	public Dialog_HienThiPhong(String maPhong) {
		// kích thước
		// dialog--------------*****************************************************************
		getContentPane().setBackground(Color.WHITE);
		setSize(300, 340);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		// các
		// lbl-----------------------------------------------------------------------
		lblPhong = new JLabel("Phòng");
		lblPhong.setFont(new Font("Arial", Font.BOLD, 18));
		lblPhong.setBounds(20, 10, 100, 30);
		getContentPane().add(lblPhong);

		lblLoai = new JLabel("Loại");
		lblLoai.setFont(new Font("Arial", Font.BOLD, 18));
		lblLoai.setBounds(20, 50, 100, 30);
		getContentPane().add(lblLoai);

		lblSucChua = new JLabel("Sức chứa");
		lblSucChua.setFont(new Font("Arial", Font.BOLD, 18));
		lblSucChua.setBounds(20, 90, 100, 30);
		getContentPane().add(lblSucChua);

		lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setFont(new Font("Arial", Font.BOLD, 18));
		lblTrangThai.setBounds(20, 130, 100, 30);
		getContentPane().add(lblTrangThai);

		lblGia = new JLabel("Giá");
		lblGia.setFont(new Font("Arial", Font.BOLD, 18));
		lblGia.setBounds(20, 170, 100, 30);
		getContentPane().add(lblGia);

		// nút
		// button---------------------------------------------------------------------------
		btnDatPhong = new JButton("Đặt Phòng");
		btnDatPhong.setForeground(Color.WHITE);
		btnDatPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btnDatPhong.setBackground(new Color(33, 167, 38, 255));
		btnDatPhong.setBounds(40, 210, 200, 35);
		btnDatPhong.setBackground(new Color(33, 167, 38, 255));
		btnDatPhong.setBounds(40, 250, 200, 40);
		btnDatPhong.setBorderPainted(false);
		getContentPane().add(btnDatPhong);

		lblPhong_1 = new JLabel(maPhong);
		lblPhong_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhong_1.setBounds(130, 10, 120, 30);
		getContentPane().add(lblPhong_1);

		p = p_dao.getPhongTheoMaPhong(maPhong);
		lp = lp_dao.getLoaiPhongTheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());

		lblLoai_1 = new JLabel(lp.getTenLoaiPhong());
		lblLoai_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblLoai_1.setBounds(130, 50, 120, 30);
		getContentPane().add(lblLoai_1);

		lblSucChua_1 = new JLabel(lp.getSucChua() + "");
		lblSucChua_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblSucChua_1.setBounds(130, 90, 120, 30);
		getContentPane().add(lblSucChua_1);

		lbltrangthai_1 = new JLabel(p.getTrangThai() + "");
		lbltrangthai_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbltrangthai_1.setBounds(130, 130, 120, 30);
		getContentPane().add(lbltrangthai_1);

		lblgia_1 = new JLabel(lp.getDonGiaTheoGio() + "VNĐ");
		lblgia_1.setBackground(Color.WHITE);
		lblgia_1.setForeground(Color.RED);
		lblgia_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblgia_1.setBounds(130, 170, 120, 30);
		getContentPane().add(lblgia_1);

		lblSoNguoi = new JLabel("Số người");
		lblSoNguoi.setFont(new Font("Arial", Font.BOLD, 18));
		lblSoNguoi.setBounds(20, 210, 100, 30);
		getContentPane().add(lblSoNguoi);

		txtSoNguoi = new JTextField();
		txtSoNguoi.setFont(new Font("Arial", Font.BOLD, 15));
		txtSoNguoi.setBounds(130, 210, 100, 30);
		getContentPane().add(txtSoNguoi);
		txtSoNguoi.setColumns(10);
		// add sự kiện
		btnDatPhong.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnDatPhong)) {
			if (txtSoNguoi.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số người hát!");
			} else {
				if (Integer.parseInt(txtSoNguoi.getText()) <= lp.getSucChua()) {
					TempDatPhong tmp = new TempDatPhong(p.getMaPhong(), Integer.parseInt(txtSoNguoi.getText()));
					tmp_dao.addTemp(tmp);
					dialog_DatPhongTrong_2 = new Dialog_DatPhongTrong_2(lblPhong_1.getText(), p, lp,
							Integer.parseInt(txtSoNguoi.getText()));
					dispose();
					dialog_DatPhongTrong_2.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Số người hát không được vượt quá sức chứa!");
				}
			}
		}

	}
}
