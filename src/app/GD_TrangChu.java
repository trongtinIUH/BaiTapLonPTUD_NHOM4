package app;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class GD_TrangChu extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel sidebarPanel;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private final JPanel panel_1 = new JPanel();
	private JButton btnDatPhong;
	private JButton btnDanhSachPhong;
	private JButton btnNhanVien;
	private JButton btnKhachHang;
	private JButton btnSanPham;
	private JButton btnHoaDon;
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JButton btnThongKe;
	private JButton btnTroGiup;
	private JLabel lblKaraoke;
	private JButton btnUser;
	private GD_TrangDangNhap trangDangNhap;

	GD_DatPhong datPhong = new GD_DatPhong();
	GD_DanhSachPhong danhSachPhong = new GD_DanhSachPhong();
	GD_NhanVien nhanVien = new GD_NhanVien();
	GD_KhachHang khachHang = new GD_KhachHang();
	GD_HoaDon hoaDon = new GD_HoaDon();
	GD_SanPham sanPham = new GD_SanPham();
	GD_ThongKe thongKe = new GD_ThongKe();
	GD_TroGiup troGiup = new GD_TroGiup();
	public GD_TrangChu() {
		super("Karaoke 4T");
		ImageIcon icon = new ImageIcon("icon\\icon_Karaoke3.jpg");
	    this.setIconImage(icon.getImage());
		initialize();
//		this.trangDangNhap = trangDangNhap;
	}

	public static void main(String[] args) {
		GD_TrangChu home = new GD_TrangChu();
		home.setVisible(true);
	}
	
	private void initialize() {
		
		// hiển thị full màn hình
		setBounds(0, 0, 1366, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel_1.setBorder(new CompoundBorder());
		panel_1.setBackground(Color.CYAN);
		
		this.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 8, 1));
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(217, 226, 231));
		panel_1.add(panel_2);
		
		//User
		 btnUser = new JButton("");
		 btnUser.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnUser.setForeground(Color.BLACK);
		 btnUser.setBackground(Color.white);
		 btnUser.setIcon(new ImageIcon("icon\\nhanvien.png"));
		 btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		 btnDatPhong = new JButton("ĐẶT PHÒNG");
		 btnDatPhong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnDatPhong.setForeground(Color.BLACK);
		 btnDatPhong.setBackground(Color.white);
		 btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		 btnDatPhong.setIconTextGap(25); //Tạo Khoảng cách giữa icon và Nội dung(text)
		 btnDatPhong.setIcon(new ImageIcon("icon\\icon_DatPhong.png"));
		 btnDatPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		 btnDanhSachPhong = new JButton("DANH SÁCH PHÒNG");
		 btnDanhSachPhong.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		 btnDanhSachPhong.setIconTextGap(10); //Tạo Khoảng cách giữa icon và Nội dung(text)
		 btnDanhSachPhong.setIcon(new ImageIcon("icon\\icon_DSPhong.png"));
		 btnDanhSachPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		 btnDanhSachPhong.setForeground(Color.BLACK);
		 btnDanhSachPhong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnDanhSachPhong.setBackground(Color.WHITE);
		
		btnNhanVien = new JButton("NHÂN VIÊN");
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		btnNhanVien.setIconTextGap(35); //Tạo Khoảng cách giữa icon và Nội dung(text)
		btnNhanVien.setIcon(new ImageIcon("icon\\icon_NhanVien.png"));
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNhanVien.setForeground(Color.BLACK);
		btnNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNhanVien.setBackground(Color.WHITE);
		
		btnKhachHang = new JButton("KHÁCH HÀNG");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		btnKhachHang.setIconTextGap(20); //Tạo Khoảng cách giữa icon và Nội dung(text)
		btnKhachHang.setIcon(new ImageIcon("icon\\icon_KhachHang.png"));
		btnKhachHang.setForeground(Color.BLACK);
		btnKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnKhachHang.setBackground(Color.WHITE);
		
		btnSanPham = new JButton("SẢN PHẨM");
		btnSanPham.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		btnSanPham.setIconTextGap(27); //Tạo Khoảng cách giữa icon và Nội dung(text)
		btnSanPham.setIcon(new ImageIcon("icon\\icon_SanPham.png"));
		btnSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSanPham.setForeground(Color.BLACK);
		btnSanPham.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSanPham.setBackground(Color.WHITE);
		
		/// Hóa đơn
		 btnHoaDon = new JButton("HÓA ĐƠN");
		 btnHoaDon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		 btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		 btnHoaDon.setIconTextGap(30); //Tạo Khoảng cách giữa icon và Nội dung(text)
		 btnHoaDon.setIcon(new ImageIcon("icon\\icon_HoaDon.png"));
		 btnHoaDon.setForeground(Color.BLACK);
		 btnHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnHoaDon.setBackground(Color.WHITE);
		 
		//thống kê 
		 btnThongKe = new JButton("THỐNG KÊ");
		 btnThongKe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		 btnThongKe.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		 btnThongKe.setIconTextGap(20); //Tạo Khoảng cách giữa icon và Nội dung(text)
		 btnThongKe.setIcon(new ImageIcon("icon\\icon_ThongKe.png"));
		 btnThongKe.setForeground(Color.BLACK);
		 btnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnThongKe.setBackground(Color.WHITE);
		
		//Trợ giúp
		 btnTroGiup = new JButton("TRỢ GIÚP");
		 btnTroGiup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		 btnTroGiup.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		 btnTroGiup.setIconTextGap(35); //Tạo Khoảng cách giữa icon và Nội dung(text)
		 btnTroGiup.setIcon(new ImageIcon("icon\\icon_TroGiup.png"));
		 btnTroGiup.setForeground(Color.BLACK);
		 btnTroGiup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnTroGiup.setBackground(Color.WHITE);
		 
		 //user
//		 btnUser.setIcon(new ImageIcon("icon\\icon_User.png"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(217, 226, 231));
		
		JPanel pnMargin = new JPanel();
		pnMargin.setPreferredSize(new Dimension(300, 20));
		pnMargin.setBackground(new Color(217, 226, 231));
		panel_3.add(pnMargin);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 165, 0));
		lblNewLabel_1.setIcon(new ImageIcon("image\\hinh_trangdangnhap.jpg"));
		lblNewLabel_1.setBounds(0, 100, 100, 100);
		ImageIcon hinhgt1= new ImageIcon("image\\hinh_trangdangnhap.jpg");
		Image image1 = hinhgt1.getImage();
		Image newImage1 = image1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		hinhgt1 = new ImageIcon(newImage1);
		lblNewLabel_1.setIcon(hinhgt1);
		panel_3.add(lblNewLabel_1);
		
		lblKaraoke= new JLabel("KARAOKE 4T");
		lblKaraoke.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaraoke.setBounds(0, 100, 100, 30);
		lblKaraoke.setFont(new Font("Arial", Font.BOLD, 14));
		lblKaraoke.setForeground(Color.black);
		panel_3.add(lblKaraoke);
		 
		 
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnDatPhong, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnDanhSachPhong, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnNhanVien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnKhachHang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnSanPham, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnHoaDon, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnThongKe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addComponent(btnTroGiup, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236,Short.MAX_VALUE)
								.addComponent(btnUser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236,Short.MAX_VALUE)
									)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addGap(15) // Thêm khoảng cách 10 pixel
						.addComponent(btnDatPhong, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(15) // Thêm khoảng cách 10 pixel
						.addComponent(btnDanhSachPhong, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(15) // Thêm khoảng cách 10 pixel
						.addComponent(btnNhanVien, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(15) // Thêm khoảng cách 10 pixel
						.addComponent(btnKhachHang, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(15) // Thêm khoảng cách 10 pixel
						.addComponent(btnSanPham, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(15) // Thêm khoảng cách 10 pixel
						.addComponent(btnHoaDon, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(15) // Thêm khoảng cách 10 pixel
						.addComponent(btnThongKe, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(15) // Thêm khoảng cách 10 pixel
						.addComponent(btnTroGiup, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(60)
						.addComponent(btnUser, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						
						.addGap(235))
			);
		panel_2.setLayout(gl_panel_2);
		
		sidebarPanel = new JPanel();
		cardPanel = new JPanel();
	    cardLayout = new CardLayout();
	    cardPanel.setLayout(cardLayout);
	    JPanel trangChu = new JPanel();
	    trangChu.setBackground(Color.black);
	    JLabel lblNewLabel_2 = new JLabel("");
	    lblNewLabel_2.setIcon(new ImageIcon("image\\TrangChu.jpg"));
	    lblNewLabel_2.setBounds(0, 100, 1080, 730);
		ImageIcon hinhgt= new ImageIcon("image\\TrangChu.jpg");
		Image image = hinhgt.getImage();
		Image newImage = image.getScaledInstance(1080, 730, java.awt.Image.SCALE_SMOOTH);
		hinhgt = new ImageIcon(newImage);
		lblNewLabel_2.setIcon(hinhgt);
		trangChu.add(lblNewLabel_2);
	    cardPanel.add(trangChu, "TrangChu");
	    cardPanel.add(datPhong, "DatPhong");
	    cardPanel.add(danhSachPhong, "DanhSachPhong");  
	    cardPanel.add(nhanVien, "NhanVien");  
	    cardPanel.add(khachHang, "KhachHang");  
	    cardPanel.add(hoaDon, "HoaDon");  
	    cardPanel.add(sanPham, "SanPham");  
	    cardPanel.add(thongKe, "ThongKe");  
	    cardPanel.add(troGiup, "TroGiup");  
		getContentPane().add(cardPanel, BorderLayout.CENTER);
		
		btnDatPhong.addActionListener(this);
		btnDanhSachPhong.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnSanPham.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnTroGiup.addActionListener(this);
		btnUser.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		Object o = e.getSource();
		if(o.equals(btnDatPhong)) {
			cardLayout.show(cardPanel, "DatPhong");
		} else if(o.equals(btnDanhSachPhong)) {
			cardLayout.show(cardPanel, "DanhSachPhong");
		} else if(o.equals(btnNhanVien)) {
			cardLayout.show(cardPanel, "NhanVien");
		}else if(o.equals(btnKhachHang)) {
			cardLayout.show(cardPanel, "KhachHang");
		}else if(o.equals(btnHoaDon)) {
			cardLayout.show(cardPanel, "HoaDon");
		}else if(o.equals(btnSanPham)) {
			cardLayout.show(cardPanel, "SanPham");
		}else if(o.equals(btnThongKe)) {
			cardLayout.show(cardPanel, "ThongKe");
		} else if(o.equals(btnTroGiup)) {
			cardLayout.show(cardPanel, "TroGiup");
		}
	}
}