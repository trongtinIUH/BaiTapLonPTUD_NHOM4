package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Window;

public class Dialog_ThemDichVu extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel,panel_Phai,panel_Trai,panel_1,pn_dssp,pn_dssp_Phai;
	private JLabel lblMaSanPham,lblSoLuong;
	private JTextField txtMaSP,txtSoLuong,txtGiobatdauhat,txtPhong,txtKH,txtNV;
	private JButton btnTimKiem,btn_DongY,btn_Huy;


	// bảng trái
	private JTable tblThemDv_Trai,tblThemDv_Phai;
	private DefaultTableModel model_Trai,model_Phai;
	private JLabel lblNV;
	private String col_Trai[] = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá"};
	private String col_Phai[] = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá",};

	private JScrollPane sp_phai;

	private JScrollPane sp;
	private JButton btn_LamMoi;
	private JLabel lblTongTien;
	private JTextField txtTongTien;







	public Dialog_ThemDichVu() {
		getContentPane().setBackground(Color.WHITE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		//panel chứa tiêu đề--------------------------------------
		panel = new JPanel();
		panel.setBounds(0, 0, 784, 35);
		panel.setBackground(new Color(33,167,38,255));
		getContentPane().add(panel);
		panel.setLayout(null);
		getContentPane().add(panel);
		JLabel lblTieuDe = new JLabel("Thêm Dịch Vụ");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 790, 35);
		panel.add(lblTieuDe);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(0, 35, 784, 426);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		panel_Trai = new JPanel();
		panel_Trai.setBackground(SystemColor.menu);
		panel_Trai.setBounds(0, 0, 370, 375);
		panel_1.add(panel_Trai);
		panel_Trai.setLayout(null);
		
		panel_Phai = new JPanel();
		panel_Phai.setBackground(SystemColor.menu);
		panel_Phai.setLayout(null);
		panel_Phai.setBounds(390, 0, 394, 375);
		panel_1.add(panel_Phai);
		
		// lbl và các thành phần góc phải
		JLabel lblKH = new JLabel("KH");
		lblKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKH.setBounds(5, 10, 20, 25);
		panel_Phai.add(lblKH);
		
		JLabel lblPhong = new JLabel("Phòng");
		lblPhong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhong.setBounds(140, 10, 50, 25);
		panel_Phai.add(lblPhong);
		
		JLabel lblMaSanPham_4 = new JLabel("Giờ bắt đầu hát");
		lblMaSanPham_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaSanPham_4.setBounds(140, 50, 100, 25);
		panel_Phai.add(lblMaSanPham_4);
		
		lblNV = new JLabel("NV");
		lblNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNV.setBounds(5, 50, 20, 25);
		panel_Phai.add(lblNV);
		
		txtKH = new JTextField();
		txtKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtKH.setBounds(30, 10, 100, 25);
		panel_Phai.add(txtKH);
		txtKH.setColumns(20);
		
		txtNV = new JTextField();
		txtNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNV.setColumns(20);
		txtNV.setBounds(30, 50, 100, 25);
		panel_Phai.add(txtNV);
		
		txtPhong = new JTextField();
		txtPhong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPhong.setColumns(20);
		txtPhong.setBounds(214, 10, 171, 25);
		panel_Phai.add(txtPhong);
		
		txtGiobatdauhat = new JTextField();
		txtGiobatdauhat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtGiobatdauhat.setColumns(20);
		txtGiobatdauhat.setBounds(250, 50, 135, 25);
		panel_Phai.add(txtGiobatdauhat);
		
		
		 pn_dssp_Phai = new JPanel();
		 pn_dssp_Phai.setLayout(null);
		 pn_dssp_Phai.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray,1), "Dịch vụ hiện có", 
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial",Font.BOLD,13), Color.black));
		 pn_dssp_Phai.setBounds(0,90,393,242);
		 pn_dssp_Phai.setBackground(SystemColor.menu);
		 // bảng chuyển phòng phải
			model_Phai = new DefaultTableModel(col_Phai, 0);
			tblThemDv_Phai = new JTable(model_Phai);
			tblThemDv_Phai.setFont(new Font("Arial", Font.PLAIN, 12));
			tblThemDv_Phai.setBackground(Color.WHITE);
			sp_phai = new JScrollPane(tblThemDv_Phai);
			sp_phai.setBounds(4, 15, 385, 222);
			pn_dssp_Phai.add(sp_phai);
			pn_dssp_Phai.setPreferredSize(new Dimension(390, 200));
			panel_Phai.add(pn_dssp_Phai);
			
			btn_LamMoi = new JButton("Làm Mới");
			btn_LamMoi.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Refresh_icon.png"));
			btn_LamMoi.setFont(new Font("Arial", Font.BOLD, 12));
			btn_LamMoi.setBackground(new Color(252, 155, 78));
			btn_LamMoi.setBounds(5, 335, 110, 30);
			panel_Phai.add(btn_LamMoi);
			
			lblTongTien = new JLabel("Tổng Tiền DV:");
			lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTongTien.setBounds(130, 335, 105, 30);
			panel_Phai.add(lblTongTien);
			
			txtTongTien = new JTextField();
			txtTongTien.setFont(new Font("Arial", Font.PLAIN, 12));
			txtTongTien.setColumns(20);
			txtTongTien.setBounds(240, 335, 145, 30);
			panel_Phai.add(txtTongTien);

		
//------------------------------------------------------------------------------------------------------------------
		//--- các thành phần  panel trái
		lblMaSanPham = new JLabel("Mã sản phẩm");
		lblMaSanPham.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaSanPham.setBounds(5, 5, 100, 30);
		panel_Trai.add(lblMaSanPham);
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(110, 5, 130, 30);
		panel_Trai.add(txtMaSP);
		txtMaSP.setColumns(20);
		
        ImageIcon iconTimKiem = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Research_icon.png");
        Image originalImage_iconTimKiem = iconTimKiem.getImage();
        Image resizedImage_iconTimKiem = originalImage_iconTimKiem.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIcon_iconTimKiem = new ImageIcon(resizedImage_iconTimKiem);
        
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimKiem.setIcon(resizedIcon_iconTimKiem);
		btnTimKiem.setBounds(250, 5, 115, 30);
		btnTimKiem.setBackground(new Color(13,153,255,255));
		panel_Trai.add(btnTimKiem);
		
		 pn_dssp = new JPanel();
		 pn_dssp.setLayout(null);
		 pn_dssp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray,1), "Danh sách sản phẩm", 
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial",Font.BOLD,13), Color.black));
		 pn_dssp.setBounds(0,40,370,297);
		 pn_dssp.setBackground(SystemColor.menu);
		 // bảng chuyển phòng
			model_Trai = new DefaultTableModel(col_Trai, 0);
			tblThemDv_Trai = new JTable(model_Trai);
			tblThemDv_Trai.setFont(new Font("Arial", Font.PLAIN, 12));
			tblThemDv_Trai.setBackground(Color.WHITE);
			sp = new JScrollPane(tblThemDv_Trai);
			sp.setBounds(5, 15, 360, 277);
			pn_dssp.add(sp);
			pn_dssp.setPreferredSize(new Dimension(370, 280));
			panel_Trai.add(pn_dssp);
			
			lblSoLuong = new JLabel("Nhập số lượng:");
			lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblSoLuong.setBounds(180, 340, 115, 25);
			panel_Trai.add(lblSoLuong);
			
			txtSoLuong = new JTextField();
			txtSoLuong.setColumns(20);
			txtSoLuong.setBounds(300, 340, 65, 25);
			panel_Trai.add(txtSoLuong);
			
			btn_DongY = new JButton("Đồng Ý");
			btn_DongY.setFont(new Font("Arial", Font.BOLD, 18));
			btn_DongY.setBackground(new Color(33,167,38,255));
			btn_DongY.setBounds(100, 380, 250, 40);
			panel_1.add(btn_DongY);
			
			btn_Huy = new JButton("Hủy");
			btn_Huy.setFont(new Font("Arial", Font.BOLD, 18));
			btn_Huy.setBackground(new Color(255, 83, 83));
			btn_Huy.setBounds(420, 380, 250, 40);
			panel_1.add(btn_Huy);
		
	
			
			// thêm sự kiện
			btn_DongY.addActionListener(this);
			btn_Huy.addActionListener(this);
			btn_LamMoi.addActionListener(this);
			btnTimKiem.addActionListener(this);
			
	}


	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		 if(o.equals(btn_Huy)) {
			 setVisible(false);
		 }
//		        Window[] windows = Window.getWindows();
//		        for (Window window : windows) {
//		            if (window instanceof JDialog) {
//		                window.dispose();
//		            }
//		        }
//		    }
		if(o.equals(btn_DongY)) {
			
		}
		
	}
}
