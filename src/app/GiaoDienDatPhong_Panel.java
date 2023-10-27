package app;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.SwingConstants;


public class GiaoDienDatPhong_Panel extends JPanel implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnUser;
	private JComboBox<String> comboBox_TrangThai,comboBox_LoaiPhong;
	private JTextField txtSoNguoi;
	private JTextField txtMaPhong;
	private JButton btnTimKiemPDP;
	private JButton btnLamMoi;
	private JButton btnTimKiem;
	private JScrollPane scrollPane_Phong;
	private JPanel panel_3;
	private JPanel outerPanel;
	
	
	private JButton btnPhong101,btnPhong105,btnPhong102,btnPhong104,btnPhong103;
	private JButton btnPhong201,btnPhong205,btnPhong202,btnPhong204,btnPhong203;
	private JButton btnPhong301,btnPhong305,btnPhong302,btnPhong304,btnPhong303;
	private JButton btnPhong401,btnPhong405,btnPhong402,btnPhong404,btnPhong403;
	private JButton btnPhong501,btnPhong505,btnPhong502,btnPhong504,btnPhong503;
	private JLabel lbl_iconPhongVIP,lbl_iconPhongsuaChua,lbl_iconPhongCho,lbl_iconPhongTrong;


	/**
	 * Create the panel.
	 */
	public GiaoDienDatPhong_Panel() {
		this.setSize(1080, 730);
		setLayout(null);
		//---gốc chứa all panel con--------------------------********************************************************************
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1080, 730);
		panel.setBackground(Color.green);
		add(panel);
		panel.setLayout(null);
		//---gốc 1--------------------------***********************************************************************
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1080, 35);
		panel_1.setBackground(new Color(181,230,251,255));
		panel_1.setLayout(null);
		JLabel lblTieuDe = new JLabel("ĐẶT PHÒNG");
		lblTieuDe.setBounds(501, 5, 92, 30);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblTieuDe);
		panel.add(panel_1);
		//---nút user
		btnUser = new JButton("");
		btnUser.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\user.png"));
		btnUser.setBounds(1019, 0, 61, 35);
		btnUser.setBackground(new Color(181,230,251,255));
		panel_1.add(btnUser);
		
		//---gốc 2----------------------------------****************************************************************
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 35, 1080, 103);
		panel.add(panel_2);
		panel_2.setLayout(null);
		//--- lbl và combox trạng thái
		JLabel lblTrangThai = new JLabel("Trạng Thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTrangThai.setBounds(30, 10, 93, 25);
		panel_2.add(lblTrangThai);
		
		comboBox_TrangThai = new JComboBox<String>();
		comboBox_TrangThai.setBackground(Color.WHITE);
		comboBox_TrangThai.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_TrangThai.setModel(new DefaultComboBoxModel<String>(new String[] {"Trống", "Chờ", "Đang Sử Dụng", "Sửa Chửa"}));
		comboBox_TrangThai.setBounds(130, 10, 212, 30);
		panel_2.add(comboBox_TrangThai);
		
		JLabel lblLoiPhng = new JLabel("Loại Phòng");
		lblLoiPhng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLoiPhng.setBounds(30, 60, 93, 25);
		panel_2.add(lblLoiPhng);
		
		 comboBox_LoaiPhong = new JComboBox<String>();
		comboBox_LoaiPhong.setModel(new DefaultComboBoxModel<String>(new String[] {"Phòng Vip", "Phòng Thường"}));
		comboBox_LoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_LoaiPhong.setBackground(Color.WHITE);
		comboBox_LoaiPhong.setBounds(130, 60, 212, 30);
		panel_2.add(comboBox_LoaiPhong);
		
		//---lbl số người và mã phòng & txt
		JLabel lblSoNguoi = new JLabel("Số Người");
		lblSoNguoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoNguoi.setBounds(406, 10, 79, 25);
		panel_2.add(lblSoNguoi);
		
		JLabel lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaPhong.setBounds(406, 60, 79, 30);
		panel_2.add(lblMaPhong);
		
		txtSoNguoi = new JTextField();
		txtSoNguoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSoNguoi.setEditable(false);
		txtSoNguoi.setText("10");
		txtSoNguoi.setBounds(509, 10, 102, 30);
		panel_2.add(txtSoNguoi);
		txtSoNguoi.setColumns(10);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMaPhong.setText("101");
		txtMaPhong.setEditable(false);
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(509, 60, 102, 30);
		panel_2.add(txtMaPhong);
		
		//--- cuối góc phải là 3 nút jbutton
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTimKiem.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Research_icon.png"));
		btnTimKiem.setBounds(672, 10, 180, 35);
		btnTimKiem.setBackground(new Color(13,153,255,255));
		panel_2.add(btnTimKiem);
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Refresh_icon.png"));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLamMoi.setBounds(879, 10, 180, 35);
		btnLamMoi.setBackground(new Color(112,210,103,255));
		panel_2.add(btnLamMoi);
		
		btnTimKiemPDP = new JButton("Tìm Phiếu Đặt Phòng");
		btnTimKiemPDP.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Research_icon.png"));
		btnTimKiemPDP.setForeground(Color.WHITE);
		btnTimKiemPDP.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTimKiemPDP.setBounds(672, 55, 387, 35);
		btnTimKiemPDP.setBackground(new Color(255,180,0,255));
		
		panel_2.add(btnTimKiemPDP);
		
		//---gốc 3----------------------------------****************************************************************
		panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		panel_3.setBounds(0, 138, 1080, 500);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		scrollPane_Phong = new JScrollPane();
		scrollPane_Phong.setBounds(0, 0, 1080, 500);
		panel_3.add(scrollPane_Phong);
		
        // Tạo JPanel bên ngoài với kích thước cố định
        outerPanel = new JPanel();
        outerPanel.setPreferredSize(new Dimension(1080, 705));
        outerPanel.setLayout(null);
        

        JPanel panel_ChuaPhong = new JPanel();
        panel_ChuaPhong.setBackground(Color.WHITE);
        panel_ChuaPhong.setBounds(0, 0, 1080, 700);
        outerPanel.add(panel_ChuaPhong);
        panel_ChuaPhong.setLayout(null);
        
        //chỉnh sửa kích thước các icon thường______________________
      ImageIcon phongtrong = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\phongtrong.png");
      Image originalImage_phongtrong = phongtrong.getImage();
      Image resizedImage_phongtrong = originalImage_phongtrong.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
      ImageIcon resizedIcon_phongtrong = new ImageIcon(resizedImage_phongtrong);
      panel_ChuaPhong.setLayout(null);
      ImageIcon phongsd = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\phongsd.png");
      Image originalImage_phongsd = phongsd.getImage();
      Image resizedImage_phongsd = originalImage_phongsd.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
      ImageIcon resizedIcon_phongsd = new ImageIcon(resizedImage_phongsd);
      
      ImageIcon phongcho = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\phongcho.png");
      Image originalImage_phongcho = phongcho.getImage();
      Image resizedImage_phongcho = originalImage_phongcho.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
      ImageIcon resizedIcon_phongcho = new ImageIcon(resizedImage_phongcho);
      
      ImageIcon phongsua = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\phongsua.png");
      Image originalImage_phongsua = phongsua.getImage();
      Image resizedImage_phongsua = originalImage_phongsua.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
      ImageIcon resizedIcon_phongsua = new ImageIcon(resizedImage_phongsua);
      
      //chỉnh sửa kích thước các icon VIP_______________________________
      ImageIcon phongtrongvip = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\trong_vip.png");
      Image originalImage_phongtrongvip = phongtrongvip.getImage();
      Image resizedImage_phongtrongvip = originalImage_phongtrongvip.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
      ImageIcon resizedIcon_phongtrongvip = new ImageIcon(resizedImage_phongtrongvip);
     
      ImageIcon phongsdvip = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\sd_vip.png");
      Image originalImage_phongsdvip = phongsdvip.getImage();
      Image resizedImage_phongsdvip = originalImage_phongsdvip.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
      ImageIcon resizedIcon_phongsdvip = new ImageIcon(resizedImage_phongsdvip);
    
      ImageIcon phongchovip = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\cho_vip.png");
      Image originalImage_phongchovip = phongchovip.getImage();
      Image resizedImage_phongchovip = originalImage_phongchovip.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
      ImageIcon resizedIcon_phongchovip = new ImageIcon(resizedImage_phongchovip);
    
      ImageIcon phongsuavip = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\sua_vip.png");
      Image originalImage_phongsuavip = phongsuavip.getImage();
      Image resizedImage_phongsuavip = originalImage_phongsuavip.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
      ImageIcon resizedIcon_phongsuavip = new ImageIcon(resizedImage_phongsuavip);
    
//hàng 1
        //btn101
        btnPhong101 = new JButton("Phòng 101");
        btnPhong101.setBounds(40, 20, 160, 100);
        btnPhong101.setBackground(Color.WHITE);
        btnPhong101.setIcon(resizedIcon_phongtrongvip);
        btnPhong101.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong101);
        //btn102
        btnPhong102 = new JButton("Phòng 102");
        btnPhong102.setBounds(250, 20, 160, 100);
        btnPhong102.setBackground(Color.WHITE);
        btnPhong102.setIcon(resizedIcon_phongtrongvip);
        btnPhong102.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong102);
        //btn103
        btnPhong103 = new JButton("Phòng 103");
        btnPhong103.setBounds(450, 20, 160, 100);
        btnPhong103.setBackground(Color.WHITE);
        btnPhong103.setIcon(resizedIcon_phongcho);
        btnPhong103.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong103);
        //btn104
        btnPhong104 = new JButton("Phòng 104");
        btnPhong104.setBounds(650, 20, 150, 100);
        btnPhong104.setBackground(Color.WHITE);
        btnPhong104.setIcon(resizedIcon_phongsua);
        btnPhong104.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong104);
        //btn105
        btnPhong105 = new JButton("Phòng 105");
        btnPhong105.setBounds(850, 20, 160, 100);
        btnPhong105.setBackground(Color.WHITE);
        btnPhong105.setIcon(resizedIcon_phongsd);
        btnPhong105.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong105);
//hàng 2
        //btn201
        btnPhong201 = new JButton("Phòng 201");
        btnPhong201.setBounds(40, 150, 160, 100);
        btnPhong201.setBackground(Color.WHITE);
        btnPhong201.setIcon(resizedIcon_phongtrongvip);
        btnPhong201.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong201);
        //btn202
        btnPhong202 = new JButton("Phòng 202");
        btnPhong202.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnPhong202.setBounds(250, 150, 160, 100);
        btnPhong202.setBackground(Color.WHITE);
        btnPhong202.setIcon(resizedIcon_phongtrongvip);
        btnPhong202.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong202);
        //btn203
        btnPhong203 = new JButton("Phòng 203");
        btnPhong203.setBounds(450, 150, 160, 100);
        btnPhong203.setBackground(Color.WHITE);
        btnPhong203.setIcon(resizedIcon_phongcho);
        btnPhong203.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong203);
        //btn204
        btnPhong204 = new JButton("Phòng 204");
        btnPhong204.setBounds(650, 150, 160, 100);
        btnPhong204.setBackground(Color.WHITE);
        btnPhong204.setIcon(resizedIcon_phongsua);
        btnPhong204.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong204);
        //btn205
        btnPhong205 = new JButton("Phòng 205");
        btnPhong205.setBounds(850, 150, 160, 100);
        btnPhong205.setBackground(Color.WHITE);
        btnPhong205.setIcon(resizedIcon_phongsd);
        btnPhong205.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong205);
//hàng 3
        //btn301
        btnPhong301 = new JButton("Phòng 301");
        btnPhong301.setBounds(40, 280, 160, 100);
        btnPhong301.setBackground(Color.WHITE);
        btnPhong301.setIcon(resizedIcon_phongtrongvip);
        btnPhong301.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong301);
        //btn302
        btnPhong302 = new JButton("Phòng 302");
        btnPhong302.setBounds(250, 280, 160, 100);
        btnPhong302.setBackground(Color.WHITE);
        btnPhong302.setIcon(resizedIcon_phongtrong);
        btnPhong302.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong302);
        //btn303
        btnPhong303 = new JButton("Phòng 303");
        btnPhong303.setBounds(450, 280, 160, 100);
        btnPhong303.setBackground(Color.WHITE);
        btnPhong303.setIcon(resizedIcon_phongchovip);
        btnPhong303.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong303);
        //btn304
        btnPhong304 = new JButton("Phòng 304");
        btnPhong304.setBounds(650, 280, 160, 100);
        btnPhong304.setBackground(Color.WHITE);
        btnPhong304.setIcon(resizedIcon_phongtrong);
        btnPhong304.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong304);
        //btn305
        btnPhong305 = new JButton("Phòng 305");
        btnPhong305.setBounds(850, 280, 160, 100);
        btnPhong305.setBackground(Color.WHITE);
        btnPhong305.setIcon(resizedIcon_phongsdvip);
        btnPhong305.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong305);
//hàng 4
        //btn401
        btnPhong401 = new JButton("Phòng 401");
        btnPhong401.setBounds(40, 410, 160, 100);
        btnPhong401.setBackground(Color.WHITE);
        btnPhong401.setIcon(resizedIcon_phongtrongvip);
        btnPhong401.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong401);
        //btn402
        btnPhong402 = new JButton("Phòng 402");
        btnPhong402.setBounds(250, 410, 160, 100);
        btnPhong402.setBackground(Color.WHITE);
        btnPhong402.setIcon(resizedIcon_phongtrong);
        btnPhong402.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong402);
        //btn403
        btnPhong403 = new JButton("Phòng 403");
        btnPhong403.setBounds(450, 410, 160, 100);
        btnPhong403.setBackground(Color.WHITE);
        btnPhong403.setIcon(resizedIcon_phongchovip);
        btnPhong403.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong403);
        //btn404
        btnPhong404 = new JButton("Phòng 404");
        btnPhong404.setBounds(650, 410, 160, 100);
        btnPhong404.setBackground(Color.WHITE);
        btnPhong404.setIcon(resizedIcon_phongtrong);
        btnPhong404.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong404);
        //btn405
        btnPhong405 = new JButton("Phòng 405");
        btnPhong405.setBounds(850, 410, 160, 100);
        btnPhong405.setBackground(Color.WHITE);
        btnPhong405.setIcon(resizedIcon_phongsdvip);
        btnPhong405.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong405);
//hàng 5
        //btn501
        btnPhong501 = new JButton("Phòng 501");
        btnPhong501.setBounds(40, 520, 160, 100);
        btnPhong501.setBackground(Color.WHITE);
        btnPhong501.setIcon(resizedIcon_phongtrongvip);
        btnPhong501.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong501);
        //btn502
        btnPhong502 = new JButton("Phòng 502");
        btnPhong502.setBounds(250, 520, 160, 100);
        btnPhong502.setBackground(Color.WHITE);
        btnPhong502.setIcon(resizedIcon_phongtrong);
        btnPhong502.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong502);
        //btn503
        btnPhong503 = new JButton("Phòng 503");
        btnPhong503.setBounds(450, 520, 160, 100);
        btnPhong503.setBackground(Color.WHITE);
        btnPhong503.setIcon(resizedIcon_phongchovip);
        btnPhong503.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong503);
        //btn504
        btnPhong504 = new JButton("Phòng 504");
        btnPhong504.setBounds(650, 520, 160, 100);
        btnPhong504.setBackground(Color.WHITE);
        btnPhong504.setIcon(resizedIcon_phongtrong);
        btnPhong504.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong504);
        //btn505
        btnPhong505 = new JButton("Phòng 505");
        btnPhong505.setBounds(850, 520, 160, 100);
        btnPhong505.setBackground(Color.WHITE);
        btnPhong505.setIcon(resizedIcon_phongsdvip);
        btnPhong505.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel_ChuaPhong.add(btnPhong505);
        
        
        
        
        
        scrollPane_Phong.setViewportView(outerPanel); 
        
		//---gốc 4----------------------------------****************************************************************
        		//set size icon cho gốc 4
        ImageIcon phongtrong4 = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\phongtrong.png");
        Image originalImage_phongtrong4 = phongtrong4.getImage();
        Image resizedImage_phongtrong4 = originalImage_phongtrong4.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIcon_phongtrong4 = new ImageIcon(resizedImage_phongtrong4);
        panel_ChuaPhong.setLayout(null);
        ImageIcon phongsd4 = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\phongsd.png");
        Image originalImage_phongsd4 = phongsd4.getImage();
        Image resizedImage_phongsd4 = originalImage_phongsd4.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIcon_phongsd4 = new ImageIcon(resizedImage_phongsd4);
        
        ImageIcon phongcho4 = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\phongcho.png");
        Image originalImage_phongcho4 = phongcho4.getImage();
        Image resizedImage_phongcho4 = originalImage_phongcho4.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIcon_phongcho4 = new ImageIcon(resizedImage_phongcho4);
        
        ImageIcon phongsua4 = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\phongsua.png");
        Image originalImage_phongsua4 = phongsua4.getImage();
        Image resizedImage_phongsua4 = originalImage_phongsua4.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIcon_phongsua4 = new ImageIcon(resizedImage_phongsua4);
        
        ImageIcon phongvip = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\phongvip.png");
        Image originalImage_phongvip = phongvip.getImage();
        Image resizedImage_phongvip= originalImage_phongvip.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIcon_phongvip = new ImageIcon(resizedImage_phongvip);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(Color.WHITE);
        panel_4.setBounds(0, 638, 1080, 92);
        panel.add(panel_4);
        panel_4.setLayout(null);
        //lbl & icon phòng trống
         lbl_iconPhongTrong = new JLabel("Phòng Trống");
        lbl_iconPhongTrong.setIcon(resizedIcon_phongtrong4);
        lbl_iconPhongTrong.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_iconPhongTrong.setBounds(15, 5, 140, 35);
        panel_4.add(lbl_iconPhongTrong);
        //lbl & icon phòng chờ
         lbl_iconPhongCho = new JLabel("Phòng Chờ");
         lbl_iconPhongCho.setIcon(resizedIcon_phongcho4);
         lbl_iconPhongCho.setFont(new Font("Tahoma", Font.BOLD, 15));
         lbl_iconPhongCho.setBounds(180, 5, 140, 35);
        panel_4.add(lbl_iconPhongCho);
        //lbl & icon phòng đang sử dụng
        JLabel lbl_iconPhongSD = new JLabel("Phòng đang sử dụng");
        lbl_iconPhongSD.setIcon(resizedIcon_phongsd4);
        lbl_iconPhongSD.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_iconPhongSD.setBounds(340, 5, 200, 35);
        panel_4.add(lbl_iconPhongSD);
        //lbl & icon phòng sửa chữa
         lbl_iconPhongsuaChua = new JLabel("Phòng sửa chửa");
         lbl_iconPhongsuaChua.setIcon(resizedIcon_phongsua4);
         lbl_iconPhongsuaChua.setFont(new Font("Tahoma", Font.BOLD, 15));
         lbl_iconPhongsuaChua.setBounds(560, 5, 170, 35);
        panel_4.add(lbl_iconPhongsuaChua);
        //lbl & icon phòng VIP
         lbl_iconPhongVIP = new JLabel("Phòng VIP");
        lbl_iconPhongVIP.setIcon(resizedIcon_phongvip);
        lbl_iconPhongVIP.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl_iconPhongVIP.setBounds(850, 5, 140, 35);
        panel_4.add(lbl_iconPhongVIP);
        
        
		//thêm sự kiện
		btnUser.addActionListener(this);
		btnUser.addMouseListener(this);
		btnTimKiemPDP.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		btnUser.setBackground(Color.WHITE);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		btnUser.setBackground(new Color(181,230,251,255));
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
