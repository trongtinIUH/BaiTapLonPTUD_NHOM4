package app;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import dao.LoaiPhong_dao;
import dao.PhieuDatPhong_dao;
import dao.Phong_dao;
import entity.LoaiPhong;
import entity.PhieuDatPhong;
import entity.Phong;


public class Dialog_PhongDangSD extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPhong,lblGia,lblTrangThai, lblThoiGianHat, lblSoNguoi, lblLoai,lblLoai_1,lblPhong_1,lblgia_1,lbltrangthai_1,lblSoNguoi_1;
	private JButton btnThemDV,btnChuyenPhong,btnThanhToan;

	private Dialog_ChuyenPhong dialog_ChuyenPhong = new Dialog_ChuyenPhong();
	private Dialog_ThemDichVu dialog_ThemDichVu;
	private Dialog_ThanhToan dialog_ThanhToan = new Dialog_ThanhToan();
	private Phong_dao p_dao = new Phong_dao();
	private LoaiPhong_dao lp_dao = new LoaiPhong_dao();
	private PhieuDatPhong_dao pdp_dao = new PhieuDatPhong_dao();
	private Phong p;
	private LoaiPhong lp;
	private PhieuDatPhong pdp = new PhieuDatPhong();
	
	

	public Dialog_PhongDangSD(String maPhong) {
		//kích thước giao diện
		getContentPane().setBackground(Color.WHITE);
		setSize(320, 410);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//các lbl góc trái-----------------------------------------------------------------------
		lblPhong = new JLabel("Phòng:");
		lblPhong.setBounds(10, 10, 100, 30);
		lblPhong.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblPhong);
		
		lblLoai = new JLabel("Loại:");
		lblLoai.setBounds(10, 50, 100, 30);
		lblLoai.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblLoai);
		
		lblSoNguoi = new JLabel("Số người:");
		lblSoNguoi.setBounds(10, 90, 100, 30);
		lblSoNguoi.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblSoNguoi);
		
		lblThoiGianHat = new JLabel("Thời gian hát:");
		lblThoiGianHat.setBounds(10, 130, 125, 30);
		lblThoiGianHat.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblThoiGianHat);
		
		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setBounds(10, 170, 100, 30);
		lblTrangThai.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblTrangThai);
		
		lblGia = new JLabel("Giá phòng:");
		lblGia.setBounds(10, 210, 100, 30);
		lblGia.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblGia);
		
		//các lbl góc phải---------------------------------------------------------------------
		lblPhong_1 = new JLabel();
		lblPhong_1.setText(maPhong);
		lblPhong_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhong_1.setBounds(150, 10, 140, 30);
		getContentPane().add(lblPhong_1);
		
		p = p_dao.getPhongTheoMaPhong(maPhong);
		lp = lp_dao.getLoaiPhongTheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());
		pdp = pdp_dao.getPhieuDatPhongTheoMa(maPhong);
		
		lblLoai_1 = new JLabel();
		lblLoai_1.setText(lp.getTenLoaiPhong());
		lblLoai_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblLoai_1.setBounds(130, 50, 120, 30);
		getContentPane().add(lblLoai_1);
		
		lblSoNguoi_1 = new JLabel();
		lblSoNguoi_1.setText(lp.getSucChua() + "");
		lblSoNguoi_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblSoNguoi_1.setBounds(150, 90, 120, 30);
		getContentPane().add(lblSoNguoi_1);
		
		lblThoiGianHat = new JLabel();
		lblThoiGianHat.setText("40 phút");
		lblThoiGianHat.setFont(new Font("Arial", Font.BOLD, 15));
		lblThoiGianHat.setBounds(150, 130, 120, 30);
		getContentPane().add(lblThoiGianHat);
		
		lbltrangthai_1 = new JLabel();
		lbltrangthai_1.setText("Dùng");
		lbltrangthai_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbltrangthai_1.setBounds(150, 170, 120, 30);
		getContentPane().add(lbltrangthai_1);
		
		lblgia_1 = new JLabel();
		lblgia_1.setText("80,000 VNĐ");
		lblgia_1.setBackground(Color.WHITE);
		lblgia_1.setForeground(Color.RED);
		lblgia_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblgia_1.setBounds(150, 210, 140, 30);
		getContentPane().add(lblgia_1);
		
		//nút button---------------------------------------------------------------------------
		btnThemDV = new JButton("Thêm Dịch Vụ");
		btnThemDV.setBounds(25, 250, 250, 35);
		btnThemDV.setForeground(Color.WHITE);
		btnThemDV.setFont(new Font("Arial", Font.BOLD, 18));
		btnThemDV.setBackground(new Color(33,167,38,255));
		btnThemDV.setBorder(new RoundedBorder(60));
//		btnThemDV.setBorderPainted(false);
		getContentPane().add(btnThemDV);
		
		btnChuyenPhong = new JButton("Chuyển Phòng");
		btnChuyenPhong.setBounds(25, 290, 250, 35);
		btnChuyenPhong.setForeground(Color.WHITE);
		btnChuyenPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btnChuyenPhong.setBackground(new Color(26,147,216,255));
	  //btnChuyenPhong.setBorderPainted(false);
		btnChuyenPhong.setBorder(new RoundedBorder(60));
		getContentPane().add(btnChuyenPhong);
		
		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setBounds(25, 330, 250, 35);
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Arial", Font.BOLD, 18));
		btnThanhToan.setBorder(new RoundedBorder(60));
		btnThanhToan.setBackground(new Color(252,155,78,255));
	//	btnThanhToan.setBorderPainted(false);
		getContentPane().add(btnThanhToan);
		
		// thêm sự kiện  button
		btnChuyenPhong.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnThemDV.addActionListener(this);
	}



	//hàm cập nhật các Jlabel góc phải
	  public void updateLabel(String newText) {
	        lblPhong_1.setText(newText);
	    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnChuyenPhong)) {
		dialog_ChuyenPhong.setVisible(true);	
		}
		
		if(o.equals(btnThemDV)) {
			dialog_ThemDichVu.setVisible(true);	
			}
		if(o.equals(btnThanhToan)) {
			dialog_ThanhToan.setVisible(true);	
			}
	}

}
