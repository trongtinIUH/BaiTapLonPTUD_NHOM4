package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Dialog_ThanhToan extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblTieuDe;
	private JLabel lblSDTKhach;
	private JLabel lblTenKhach;
	private JLabel lblTenNV;
	private JLabel lblGioNhanPhong;
	private JLabel lblGioTraPhong;
	private JLabel lblTngThiLng;
	private JLabel lbl_sdtKH_1;
	private JLabel lbl_tenKH_1;
	private JLabel lbl_TenNV_1;
	private JLabel lbl_GioNhanPhong_1;
	private JLabel lbl_GioTraPhong_1;
	private JLabel lbl_TongThoiLuong_1;
	
	private JTable tblThanhToan;
	private DefaultTableModel model;
	private String col[] = { "STT", "Tên SP", "SL / Thời Gian", "Đơn Giá", "Đơn Vị Tính","Thành Phần" };
	private JLabel lblTienDV;
	private JLabel lblTienPhong;
	private JLabel lblTongCong;
	private JLabel lblThu;
	private JLabel lbl_TongThanhTien;
	private JTextField txtMaGiamGia;
	private JTextField txtChiecKhau;
	private JTextField txtTienNhan;
	private JTextField txtTienThua;
	private JButton btnNewButton;
	private JLabel lbl_TongThanhTien_1;
	private JLabel lblThu_1;
	private JLabel lblVn;
	private JLabel lblVn_1;
	private JLabel lblVn_2;
	private JButton btnThanhToan;
	private JButton btnQuayLai;
	
	
	public Dialog_ThanhToan() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setSize(800, 550);
		setLocationRelativeTo(null);
		
		
		//panel chứa tiêu đề-------------------------------------------------------------------------
		panel = new JPanel();
		panel.setBounds(0, 0, 784, 35);
		panel.setBackground(new Color(181,230,251,255));
		getContentPane().add(panel);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		lblTieuDe = new JLabel("Thanh Toán");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 790, 35);
		panel.add(lblTieuDe);
		
		// panel 1 chứa thông tin kh, nhân viên và bảng table-------------------------------------------
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 34, 784, 256);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblSDTKhach = new JLabel("SDT khách:");
		lblSDTKhach.setFont(new Font("Arial", Font.BOLD, 15));
		lblSDTKhach.setBounds(5, 5, 90, 20);
		panel_1.add(lblSDTKhach);
		
		lblTenKhach = new JLabel("Tên khách:");
		lblTenKhach.setFont(new Font("Arial", Font.BOLD, 15));
		lblTenKhach.setBounds(5, 35, 90, 20);
		panel_1.add(lblTenKhach);
		
		lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Arial", Font.BOLD, 15));
		lblTenNV.setBounds(5, 65, 110, 20);
		panel_1.add(lblTenNV);
		
		lblGioNhanPhong = new JLabel("Giờ nhận phòng:");
		lblGioNhanPhong.setFont(new Font("Arial", Font.BOLD, 15));
		lblGioNhanPhong.setBounds(380, 5, 120, 20);
		panel_1.add(lblGioNhanPhong);
		
		lblGioTraPhong = new JLabel("Giờ trả phòng:");
		lblGioTraPhong.setFont(new Font("Arial", Font.BOLD, 15));
		lblGioTraPhong.setBounds(380, 35, 110, 20);
		panel_1.add(lblGioTraPhong);
		
		lblTngThiLng = new JLabel("Tổng thời lượng:");
		lblTngThiLng.setFont(new Font("Arial", Font.BOLD, 15));
		lblTngThiLng.setBounds(380, 65, 125, 20);
		panel_1.add(lblTngThiLng);
		
		lbl_sdtKH_1 = new JLabel("0947677077");
		lbl_sdtKH_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_sdtKH_1.setBounds(125, 5, 200, 20);
		panel_1.add(lbl_sdtKH_1);
		
		lbl_tenKH_1 = new JLabel("Nguyễn Văn A");
		lbl_tenKH_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_tenKH_1.setBounds(125, 35, 200, 20);
		panel_1.add(lbl_tenKH_1);
		
		lbl_TenNV_1 = new JLabel("Trần Trọng Tín");
		lbl_TenNV_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_TenNV_1.setBounds(125, 65, 200, 20);
		panel_1.add(lbl_TenNV_1);
		
		lbl_GioNhanPhong_1 = new JLabel("8:00 AM 02/11/2023");
		lbl_GioNhanPhong_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_GioNhanPhong_1.setBounds(520, 5, 250, 20);
		panel_1.add(lbl_GioNhanPhong_1);
		
		lbl_GioTraPhong_1 = new JLabel("8:40 AM 01/11/2023");
		lbl_GioTraPhong_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_GioTraPhong_1.setBounds(520, 35, 250, 20);
		panel_1.add(lbl_GioTraPhong_1);
		
		lbl_TongThoiLuong_1 = new JLabel("40 phút");
		lbl_TongThoiLuong_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_TongThoiLuong_1.setBounds(520, 65, 125, 20);
		panel_1.add(lbl_TongThoiLuong_1);
		
		// bảng thanh toán phòng------------------------------------------------------
		model = new DefaultTableModel(col, 0);
		tblThanhToan = new JTable(model);
		tblThanhToan.setFont(new Font("Arial", Font.PLAIN, 12));
		tblThanhToan.setBackground(Color.WHITE);
		JScrollPane sp = new JScrollPane(tblThanhToan);
		sp.setBounds(5, 90, 772, 160);
		panel_1.add(sp);
		panel_1.setPreferredSize(new Dimension(772, 160));
		getContentPane().add(panel_1);
		
		lblTienDV = new JLabel("Tiền DV:");
		lblTienDV.setFont(new Font("Arial", Font.BOLD, 15));
		lblTienDV.setBounds(5, 300, 90, 20);
		getContentPane().add(lblTienDV);
		
		lblTienPhong = new JLabel("Tiền phòng:");
		lblTienPhong.setFont(new Font("Arial", Font.BOLD, 15));
		lblTienPhong.setBounds(5, 325, 90, 20);
		getContentPane().add(lblTienPhong);
		
		lblTongCong = new JLabel("Tổng cộng:");
		lblTongCong.setFont(new Font("Arial", Font.BOLD, 15));
		lblTongCong.setBounds(5, 350, 90, 20);
		getContentPane().add(lblTongCong);
		
		lblThu = new JLabel("Thuế VAT:");
		lblThu.setFont(new Font("Arial", Font.BOLD, 15));
		lblThu.setBounds(5, 375, 90, 20);
		getContentPane().add(lblThu);
		
		lbl_TongThanhTien = new JLabel("Tổng thành tiền: ");
		lbl_TongThanhTien.setForeground(Color.RED);
		lbl_TongThanhTien.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_TongThanhTien.setBounds(5, 420, 125, 20);
		getContentPane().add(lbl_TongThanhTien);
		
		JCheckBox chckbx_XuatHoaDon = new JCheckBox("Xuất Hóa Đơn");
		chckbx_XuatHoaDon.setFont(new Font("Arial", Font.BOLD, 12));
		chckbx_XuatHoaDon.setBounds(10, 445, 110, 20);
		getContentPane().add(chckbx_XuatHoaDon);
		
		JLabel lbl_MaGiamGia = new JLabel("Mã giảm giá:");
		lbl_MaGiamGia.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_MaGiamGia.setBounds(370, 300, 90, 25);
		getContentPane().add(lbl_MaGiamGia);
		
		JLabel lbl_ChiecKhau = new JLabel("Chiếc khấu:");
		lbl_ChiecKhau.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_ChiecKhau.setBounds(370, 330, 90, 25);
		getContentPane().add(lbl_ChiecKhau);
		
		JLabel lbl_TienNhan = new JLabel("Tiền nhận:");
		lbl_TienNhan.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_TienNhan.setBounds(370, 360, 90, 25);
		getContentPane().add(lbl_TienNhan);
		
		JLabel lbl_TienThua = new JLabel("Tiền thừa:");
		lbl_TienThua.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_TienThua.setBounds(370, 390, 90, 25);
		getContentPane().add(lbl_TienThua);
		
		txtMaGiamGia = new JTextField();
		txtMaGiamGia.setText("THANG11VUI");
		txtMaGiamGia.setFont(new Font("Arial", Font.BOLD, 15));
		txtMaGiamGia.setBounds(470, 300, 200, 25);
		getContentPane().add(txtMaGiamGia);
		txtMaGiamGia.setColumns(10);
		
		txtChiecKhau = new JTextField();
		txtChiecKhau.setFont(new Font("Arial", Font.BOLD, 15));
		txtChiecKhau.setEditable(false);
		txtChiecKhau.setColumns(10);
		txtChiecKhau.setBounds(470, 330, 100, 25);
		getContentPane().add(txtChiecKhau);
		
		txtTienNhan = new JTextField();
		txtTienNhan.setFont(new Font("Arial", Font.BOLD, 15));
		txtTienNhan.setColumns(10);
		txtTienNhan.setBounds(470, 360, 200, 25);
		getContentPane().add(txtTienNhan);
		
		txtTienThua = new JTextField();
		txtTienThua.setFont(new Font("Arial", Font.BOLD, 15));
		txtTienThua.setEditable(false);
		txtTienThua.setColumns(10);
		txtTienThua.setBounds(470, 390, 200, 25);
		getContentPane().add(txtTienThua);
		
		btnNewButton = new JButton("Kiểm tra");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(675, 300, 100, 30);
		getContentPane().add(btnNewButton);
		
		lbl_TongThanhTien_1 = new JLabel("700, 000 VNĐ");
		lbl_TongThanhTien_1.setForeground(Color.RED);
		lbl_TongThanhTien_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_TongThanhTien_1.setBounds(150, 420, 150, 20);
		getContentPane().add(lbl_TongThanhTien_1);
		
		lblThu_1 = new JLabel("10%");
		lblThu_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblThu_1.setBounds(150, 375, 110, 20);
		getContentPane().add(lblThu_1);
		
		lblVn = new JLabel("528, 000 VNĐ");
		lblVn.setFont(new Font("Arial", Font.BOLD, 15));
		lblVn.setBounds(150, 350, 150, 20);
		getContentPane().add(lblVn);
		
		lblVn_1 = new JLabel("80, 000 VNĐ");
		lblVn_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblVn_1.setBounds(150, 325, 150, 20);
		getContentPane().add(lblVn_1);
		
		lblVn_2 = new JLabel("350, 000 VNĐ");
		lblVn_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblVn_2.setBounds(150, 300, 150, 20);
		getContentPane().add(lblVn_2);
		
		// 2 nút jbutton cuối --------------------------------------------------------------------------------
		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setBounds(20, 470, 250, 35);
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Arial", Font.BOLD, 18));
		btnThanhToan.setBorder(new RoundedBorder(60));
		btnThanhToan.setBackground(new Color(252,155,78,255));
	//	btnThanhToan.setBorderPainted(false);
		getContentPane().add(btnThanhToan);
		
		btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Arial", Font.BOLD, 18));
		btnQuayLai.setBorder(new RoundedBorder(60));
		btnQuayLai.setBackground(new Color(13,153,255,255));
		btnQuayLai.setBounds(450, 470, 250, 35);
		getContentPane().add(btnQuayLai);
		
		
		// thêm sk 
		btnThanhToan.addActionListener(this);
		btnQuayLai.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThanhToan)) {
		JOptionPane.showMessageDialog(this, "Thanh Toán thành công");	

        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JDialog) {
                window.dispose();
            }
        }
    
		}
		if (o.equals(btnQuayLai)) {
			setVisible(false);
		}
	}
}
