package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.SanPham_dao;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;
import entity.SanPham;

import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Window;
import javax.swing.UIManager;

public class Dialog_ThemDichVu extends JDialog implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel,panel_Phai,panel_Trai,panel_1,pn_dssp,pn_dssp_Phai;
	private JLabel lblMaSanPham,lblSoLuong;
	private JTextField txtMaSP,txtSoLuong,txtPhong,txtKH,txtNV;
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
	private SanPham_dao sp_dao;;
	private JButton btn_XoaDV;
	private JButton btn_Them;





	public Dialog_ThemDichVu(String hoten) {
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
		lblPhong.setBounds(230, 10, 50, 25);
		panel_Phai.add(lblPhong);
		
		lblNV = new JLabel("NV");
		lblNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNV.setBounds(5, 50, 20, 25);
		panel_Phai.add(lblNV);
		
		txtKH = new JTextField(hoten);
		txtKH.setFont(new Font("Arial", Font.ITALIC, 14));
		txtKH.setBounds(30, 10, 180, 25);
		panel_Phai.add(txtKH);
		txtKH.setColumns(20);
		
		txtNV = new JTextField();
		txtNV.setFont(new Font("Arial", Font.ITALIC, 14));
		txtNV.setColumns(20);
		txtNV.setBounds(30, 50, 180, 25);
		panel_Phai.add(txtNV);
		
		txtPhong = new JTextField();
		txtPhong.setFont(new Font("Arial", Font.BOLD, 18));
		txtPhong.setColumns(20);
		txtPhong.setBounds(285, 10, 100, 25);
		panel_Phai.add(txtPhong);
		
		
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
			
			btn_XoaDV = new JButton("Xóa");
			btn_XoaDV.setFont(new Font("Arial", Font.BOLD, 18));
			btn_XoaDV.setBackground(SystemColor.controlHighlight);
			btn_XoaDV.setBounds(250, 50, 100, 30);
			panel_Phai.add(btn_XoaDV);

		
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
			
			btn_Them = new JButton("Thêm");
			btn_Them.setFont(new Font("Arial", Font.BOLD, 18));
			btn_Them.setBackground(UIManager.getColor("Button.light"));
			btn_Them.setBounds(10, 340, 100, 30);
			panel_Trai.add(btn_Them);
			
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
			btn_XoaDV.addActionListener(this);


			Object[] selectedRowData = new Object[model_Trai.getColumnCount() + 1];

			// Cập nhật dữ liệu khi chọn một hàng mới từ bảng
			tblThemDv_Trai.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent e) {
			        int selectedRow = tblThemDv_Trai.getSelectedRow();    // Lấy hàng được chọn

			        // Lấy dữ liệu từ hàng được chọn
			        for (int i = 0; i < model_Trai.getColumnCount(); i++) {
			            selectedRowData[i] = model_Trai.getValueAt(selectedRow, i);
			        }
			    }
			});

			// Xóa tất cả ActionListener hiện có từ nút 'btnThem'
			for (ActionListener act : btn_Them.getActionListeners()) {
			    btn_Them.removeActionListener(act);
			}

			// Thêm ActionListener vào nút 'btnThem'
			btn_Them.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        // Lấy số lượng từ 'txtSoLuong'
			        int soLuong = Integer.parseInt(txtSoLuong.getText());

			        // Thay đổi số lượng trong dữ liệu
			        selectedRowData[selectedRowData.length - 3] = soLuong;

			        // Thêm dữ liệu vào bảng phía bên phải
			        model_Phai.addRow(selectedRowData);
			        capNhatTongTien();
			    }
			});



			 loadData();
		
	}
	public void loadData() {
		sp_dao = new SanPham_dao();
		for (SanPham x : sp_dao.getallSp()) {
			Object[] row = { x.getMaSanPham(), x.getTenSanPham(), x.getSoLuongTon(), x.getDonGia()};
			model_Trai.addRow(row);

		}
	}

	private void xoa() throws SQLException {
		// TODO Auto-generated method stub
		int row = tblThemDv_Phai.getSelectedRow();
		if (row != -1) {
			int tb = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?", "Delete", JOptionPane.YES_NO_OPTION);
			if (tb == JOptionPane.YES_OPTION) {
				model_Phai.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xoá thành công");
			}
		} else {
			JOptionPane.showMessageDialog(null, "chưa chọn dòng xóa!");
		}

	}
	
	//tổng tiền dịch vụ
	public void capNhatTongTien() {
	    double tongTien = 0;

	    // Giả sử cột đơn giá nằm ở vị trí 3 và cột số lượng nằm ở vị trí 2
	    for (int i = 0; i < model_Phai.getRowCount(); i++) {
	        double donGia = Double.parseDouble(model_Phai.getValueAt(i, 3).toString());
	        int soLuong = Integer.parseInt(model_Phai.getValueAt(i, 2).toString());
	        tongTien += donGia * soLuong;
	    }

	    // Đặt tổng tiền vào txtTongTien
	    txtTongTien.setText(String.valueOf(tongTien));
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
		if(o.equals(btn_XoaDV)) {
				try {
					xoa();
					capNhatTongTien();
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
	


}
