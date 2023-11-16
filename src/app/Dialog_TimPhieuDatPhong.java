package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.KhachHang_dao;
import dao.PhieuDatPhong_dao;
import dao.Phong_dao;
import entity.Enum_TrangThai;
import entity.KhachHang;
import entity.PhieuDatPhong;
import entity.Phong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Window;

public class Dialog_TimPhieuDatPhong extends JDialog implements ActionListener, MouseListener {
	private JPanel panel;
	private JLabel lblTieuDe,lblTrangThai,lblMaPDP,lblSDTKhach;
	private Phong_dao p_dao = new Phong_dao();
	private JComboBox<String> comboBox_TrangThai;
	private JButton btnTimKiem,btnLamMoi,btn_XuatPhong,btn_XemPhong,btn_HuyPhong,btn_NhanPhong;
	
	private JTable tblPhieuDatPhong;
	private DefaultTableModel model;
	private String col[] = { "Mã PDP", "Phòng", "Mã NV", "Mã KH", "   Ngày Giờ Đặt   ","   Ngày Giờ Nhận   ","Số Người","Hình Thức"};
	private JButton btn_QuayLai;


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaPDP;
	private JTextField txtSDTKH;
	private PhieuDatPhong_dao pdp_dao= new PhieuDatPhong_dao();;
	private KhachHang_dao kh_dao= new KhachHang_dao();
	private KhachHang kh= new KhachHang();
	private PhieuDatPhong pdp= new PhieuDatPhong();
	private Phong p = new Phong();

	public Dialog_TimPhieuDatPhong() {
		//kích thước
		getContentPane().setBackground(Color.WHITE);
		setSize(820, 450);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//panel chứa tiêu đề-------------------------------------------------------------------------
		panel = new JPanel();
		panel.setBounds(0, 0, 804, 35);
		panel.setBackground(new Color(181,230,251,255));
		getContentPane().add(panel);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		lblTieuDe = new JLabel("Tìm Phiếu Đặt Phòng");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 803, 35);
		panel.add(lblTieuDe);
		
		// panel 1 chứa thông tin kh, nhân viên và bảng table-------------------------------------------
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 34, 804, 380);
		panel_1.setBackground(SystemColor.menu);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblMaPDP = new JLabel("Mã phiếu đặt:");
		lblMaPDP.setFont(new Font("Arial", Font.BOLD, 15));
		lblMaPDP.setBounds(5, 5, 100, 30);
		panel_1.add(lblMaPDP);
		
		lblSDTKhach = new JLabel("SDT khách:");
		lblSDTKhach.setFont(new Font("Arial", Font.BOLD, 15));
		lblSDTKhach.setBounds(5, 45, 100, 30);
		panel_1.add(lblSDTKhach);
		
		txtMaPDP = new JTextField();
		txtMaPDP.setFont(new Font("Arial", Font.BOLD, 14));
		txtMaPDP.setBounds(110, 5, 220, 30);
		panel_1.add(txtMaPDP);
		txtMaPDP.setColumns(10);
		
		txtSDTKH = new JTextField();
		txtSDTKH.setFont(new Font("Arial", Font.BOLD, 14));
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(110, 45, 220, 30);
		panel_1.add(txtSDTKH);
		
		//--- lbl và combox trạng thái
		lblTrangThai = new JLabel("Trạng Thái:");
		lblTrangThai.setFont(new Font("Arial", Font.BOLD, 15));
		lblTrangThai.setBounds(345, 5, 85, 30);
		panel_1.add(lblTrangThai);
		comboBox_TrangThai = new JComboBox<String>();
		comboBox_TrangThai.setBackground(Color.WHITE);
		comboBox_TrangThai.setFont(new Font("Arial", Font.BOLD, 15));
		comboBox_TrangThai.setModel(new DefaultComboBoxModel<String>(new String[] {"Chưa Thanh Toán", "Đã Thanh Toán"}));
		comboBox_TrangThai.setBounds(440, 5, 200, 30);
		panel_1.add(comboBox_TrangThai);
		
		//--- cuối góc phải là 3 nút jbutton
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Arial", Font.BOLD, 15));
		btnTimKiem.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Research_icon.png"));
		btnTimKiem.setBounds(350, 45, 290, 30);
		btnTimKiem.setBackground(new Color(13,153,255,255));
		btnTimKiem.setBorder(new RoundedBorder(20));
		panel_1.add(btnTimKiem);
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Refresh_icon.png"));
		btnLamMoi.setFont(new Font("Arial", Font.BOLD, 15));
		btnLamMoi.setBounds(660, 5, 125, 30);
		btnLamMoi.setBackground(new Color(112,210,103,255));
		btnLamMoi.setBorder(new RoundedBorder(10));
		panel_1.add(btnLamMoi);
		
		
		// bảng Phiếu ĐẶt Phòng
		model = new DefaultTableModel(col, 0);
		tblPhieuDatPhong = new JTable(model);
		tblPhieuDatPhong.setFont(new Font("Arial", Font.PLAIN, 12));
		tblPhieuDatPhong.setBackground(Color.WHITE);
		tblPhieuDatPhong.getColumnModel().getColumn(4).setMinWidth(100);
		tblPhieuDatPhong.getColumnModel().getColumn(5).setMinWidth(100);
		tblPhieuDatPhong.getColumnModel().getColumn(6).setMaxWidth(70);;
		
		JScrollPane sp = new JScrollPane(tblPhieuDatPhong);
		sp.setBounds(0, 90, 804, 210);
		panel_1.add(sp);
		panel_1.setPreferredSize(new Dimension(800, 300));
		
		// các nút jbutton-------------------------------------------------------------------
		btn_NhanPhong = new JButton("Nhận Phòng");
		btn_NhanPhong.setBackground(Color.GREEN);
		btn_NhanPhong.setForeground(Color.WHITE);
		btn_NhanPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_NhanPhong.setBackground(new Color(33,167,38,255));
		btn_NhanPhong.setBorder(new RoundedBorder(5));
		btn_NhanPhong.setBounds(10, 330, 150, 40);
		panel_1.add(btn_NhanPhong);
		
		btn_HuyPhong = new JButton("Hủy Phòng");
		btn_HuyPhong.setForeground(Color.WHITE);
		btn_HuyPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_HuyPhong.setBackground(new Color(236,52,52,255));
		btn_HuyPhong.setBounds(170, 330, 150, 40);
		btn_HuyPhong.setBorder(new RoundedBorder(5));
		panel_1.add(btn_HuyPhong);
		
		btn_XemPhong = new JButton("Xem Phòng");
		btn_XemPhong.setForeground(Color.WHITE);
		btn_XemPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_XemPhong.setBackground(new Color(13,153,255,255));
		btn_XemPhong.setBorder(new RoundedBorder(5));
		btn_XemPhong.setBounds(330, 330, 150, 40);
		panel_1.add(btn_XemPhong);
		
		btn_XuatPhong = new JButton("Xuất PDF");
		btn_XuatPhong.setForeground(Color.WHITE);
		btn_XuatPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_XuatPhong.setBackground(new Color(13,153,255,255));
		btn_XuatPhong.setBorder(new RoundedBorder(5));
		btn_XuatPhong.setBounds(590, 330, 200, 40);
		panel_1.add(btn_XuatPhong);
		
		btn_QuayLai = new JButton("Quay Lại");
		btn_QuayLai.setForeground(Color.WHITE);
		btn_QuayLai.setFont(new Font("Arial", Font.BOLD, 15));
		btn_QuayLai.setBackground(new Color(236,52,52,255));
		btn_QuayLai.setBorder(new RoundedBorder(5));
		btn_QuayLai.setBounds(660, 45, 125, 30);
		panel_1.add(btn_QuayLai);
		
		//add sự kiện
		btn_HuyPhong.addActionListener(this);
		btn_NhanPhong.addActionListener(this);
		btn_QuayLai.addActionListener(this);
		btn_XemPhong.addActionListener(this);
		btn_XuatPhong.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
				
			loadData();
			MyTable(model, tblPhieuDatPhong);
	}

	// hàm căn giữa nội dung trong bảng
    public void MyTable(DefaultTableModel model, JTable table) {
        this.model = model;
        this.tblPhieuDatPhong = table;
    }
    class CenterRenderer extends DefaultTableCellRenderer {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CenterRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }
    }
    public void Canh_Deu_Bang() {
		CenterRenderer centerRenderer = new CenterRenderer();
	    for (int i = 0; i < tblPhieuDatPhong.getColumnCount(); i++) {
	    	tblPhieuDatPhong.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    }
    }
    

 
    //hàm load sữ liệu
    public void loadData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm");
        String hinhthuc="";
        // Lấy tất cả phiếu đặt phòng
        ArrayList<PhieuDatPhong> allPhieuDatPhong = pdp_dao.getAllsPhieuDatPhong();
        
        // Sắp xếp danh sách theo ngày giờ đặt phòng
        Collections.sort(allPhieuDatPhong, Comparator.comparing(PhieuDatPhong::getNgayGioDatPhong));
        
        for (PhieuDatPhong x : allPhieuDatPhong) {
            String ngayGioDat = x.getNgayGioDatPhong().format(formatter);
            String ngayGioNhan = x.getNgayGioNhanPhong().format(formatter);
            if(!x.getNgayGioDatPhong().isEqual(x.getNgayGioNhanPhong())) {
                hinhthuc="Đặt trước";
            }
            else hinhthuc="Đặt trực tiếp";
            String mp=x.getMaPhieu();
            pdp=pdp_dao.getPhieuDatPhongTheoMaPDP(mp);
            p=pdp.getPhong();
            Object[] row = {x.getMaPhieu(),p.getMaPhong(),x.getNhanVien().getMaNhanVien(),x.getKhachHang().getMaKhachHang(),ngayGioDat,ngayGioNhan,x.getSoNguoiHat(),hinhthuc};
            model.addRow(row);
        }
        Canh_Deu_Bang();
    }


//clear bảng
	public void clearTable() {
		while (tblPhieuDatPhong.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	//hàm tìm 
	public void tim() {
	    String maPhieu = txtMaPDP.getText();
	    String sdt = txtSDTKH.getText();

	    if (!maPhieu.isEmpty() && !sdt.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Chỉ nhập vào 1 ô tìm kiếm!");
	        return;
	    }
	    if (maPhieu.isEmpty() && sdt.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Chỉ nhập vào 1 ô tìm kiếm!");
	        return;
	    }
	    if (!maPhieu.isEmpty()) {
	        // Tìm kiếm theo mã phiếu
	        pdp = pdp_dao.getPhieuDatPhongTheoMaPDP(maPhieu);
	        if (pdp != null) {
	            btnTimKiem.setText("Hủy tìm");
	            clearTable();
	            Object[] row = {pdp.getMaPhieu(),pdp.getPhong().getMaPhong(),pdp.getNhanVien().getMaNhanVien(),pdp.getKhachHang().getMaKhachHang(),pdp.getNgayGioDatPhong(),pdp.getNgayGioNhanPhong(),pdp.getSoNguoiHat()};
	            model.addRow(row);
	            Canh_Deu_Bang();
	        } else {
	            JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!!");
	        }
	    } else if (!sdt.isEmpty()) {
	        // Tìm kiếm theo số điện thoại
	        kh = kh_dao.getKhachHangTheoSDT(sdt);
	        if (kh != null) {
	            pdp = pdp_dao.getPhieuDatPhongTheoMaKH(kh.getMaKhachHang());
	            if (pdp != null) {
	                btnTimKiem.setText("Hủy tìm");
	                clearTable();
	                Object[] row = {pdp.getMaPhieu(),pdp.getPhong().getMaPhong(),pdp.getNhanVien().getMaNhanVien(),pdp.getKhachHang().getMaKhachHang(),pdp.getNgayGioDatPhong(),pdp.getNgayGioNhanPhong(),pdp.getSoNguoiHat()};
	                model.addRow(row);
	                Canh_Deu_Bang();
	            } else {
	                JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!!");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!!");
	        }
	    } else {
	        clearTable();
	        loadData();
	        btnTimKiem.setText("Tìm kiếm");
	        Canh_Deu_Bang();
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btn_QuayLai)) {
		setVisible(false);	
		}
		if(o.equals(btnTimKiem)) {
			tim();
		}
		if(o.equals(btnLamMoi)){
			txtMaPDP.setText("");
			txtSDTKH.setText("");
			txtMaPDP.requestFocus();
			clearTable();
			loadData();
		}
		if(o.equals(btn_HuyPhong)) {
			try {
				HuyPhieu();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void HuyPhieu() throws SQLException {
		int row = tblPhieuDatPhong.getSelectedRow();
		String maphong = (String) tblPhieuDatPhong.getValueAt(row, 1);
		if (row != -1) {
			int tb = JOptionPane.showConfirmDialog(null, "Bạn có hủy phòng?", "Hủy phòng chờ", JOptionPane.YES_NO_OPTION);
			if (tb == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, "Phòng hủy thành công!");
				pdp_dao.xoaPhieuDatPhongTheoMa(maphong);
				DataManager.setDatPhongCho(true);
				Enum_TrangThai trangThai = Enum_TrangThai.Trống;
				Phong phong = new Phong(maphong, trangThai);
				p_dao.updatePhong(phong, maphong);
				model.removeRow(row);
				setVisible(false);	
			}
		} else {
			JOptionPane.showMessageDialog(null, "chưa chọn dòng xóa!");
		}

		
	}
	
}
