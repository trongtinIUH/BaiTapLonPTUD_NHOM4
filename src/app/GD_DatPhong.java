package app;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import dao.Phong_dao;
import dao.TempDatPhong_dao;
import entity.Enum_TrangThai;
import entity.LoaiPhong;
import entity.Phong;
import entity.TempDatPhong;
import dao.LoaiPhong_dao;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GD_DatPhong extends JPanel implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnUser;
	private JComboBox<String> comboBox_TrangThai, comboBox_LoaiPhong;
	private JTextField txtSoNguoi;
	private JTextField txtMaPhong;
	private JButton btnTimKiemPDP;
	private JButton btnLamMoi;
	private JButton btnTimKiem;
	private JScrollPane scrollPane_Phong;
	private JPanel panel_3;
	private JPanel outerPanel;

	private JLabel lbl_iconPhongVIP, lbl_iconPhongsuaChua, lbl_iconPhongCho, lbl_iconPhongTrong;

	private Dialog_User dialog_user = new Dialog_User();
	private Dialog_HienThiPhong dialog_htPhong;
	private Dialog_PhongDangSD dialog_PhongDangSD;
	Phong_dao p_dao = new Phong_dao();
	LoaiPhong_dao lp_dao = new LoaiPhong_dao();
	private JButton btnPhong;
	ArrayList<JButton> btnPhongList = new ArrayList<>();
	private JButton btnBackToBook;
	private TempDatPhong_dao tmp_dao = new TempDatPhong_dao();
	private Dialog_DatPhongTrong_2 dialog_DatPhongTrong_2 = new Dialog_DatPhongTrong_2(getName(), null, null, ABORT);
	private JPanel panel_ChuaPhong;
	private int sizeDSTmp;

	/**
	 * Create the panel.
	 */

	public GD_DatPhong() {
		this.setSize(1080, 730);
		setLayout(null);
		// ---gốc chứa all panel
		// con--------------------------********************************************************************
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1080, 730);
		panel.setBackground(Color.decode("#FAFAFF"));
		add(panel);
		panel.setLayout(null);
		// ---gốc
		// 1--------------------------***********************************************************************
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1080, 60);
		panel_1.setBackground(new Color(181, 230, 251, 255));
		panel_1.setLayout(null);
		JLabel lblTieuDe = new JLabel("ĐẶT PHÒNG");
		lblTieuDe.setBounds(501, 10, 130, 30);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		panel_1.add(lblTieuDe);
		panel.add(panel_1);
		// ---nút user
		btnUser = new JButton("");
		btnUser.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\user.png"));
		btnUser.setBounds(1019, 5, 61, 45);
		btnUser.setBackground(new Color(181, 230, 251, 255));
		panel_1.add(btnUser);

		// ---gốc
		// 2----------------------------------****************************************************************
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(0, 60, 1080, 103);
		panel.add(panel_2);
		panel_2.setLayout(null);
		// --- lbl và combox trạng thái
		JLabel lblTrangThai = new JLabel("Trạng Thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTrangThai.setBounds(10, 10, 100, 25);
		panel_2.add(lblTrangThai);

		comboBox_TrangThai = new JComboBox<String>();
		comboBox_TrangThai.setBackground(Color.WHITE);
		comboBox_TrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_TrangThai.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Trống", "Chờ", "Đang Sử Dụng", "Sửa Chửa" }));
		comboBox_TrangThai.setBounds(130, 10, 212, 30);
		panel_2.add(comboBox_TrangThai);

		JLabel lblLoiPhng = new JLabel("Loại Phòng");
		lblLoiPhng.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLoiPhng.setBounds(10, 60, 150, 25);
		panel_2.add(lblLoiPhng);

		comboBox_LoaiPhong = new JComboBox<String>();
		comboBox_LoaiPhong.setModel(new DefaultComboBoxModel<String>(new String[] { "Phòng Vip", "Phòng Thường" }));
		comboBox_LoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_LoaiPhong.setBackground(Color.WHITE);
		comboBox_LoaiPhong.setBounds(130, 60, 212, 30);
		panel_2.add(comboBox_LoaiPhong);

		// ---lbl số người và mã phòng & txt
		JLabel lblSoNguoi = new JLabel("Số Người");
		lblSoNguoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSoNguoi.setBounds(380, 10, 100, 25);
		panel_2.add(lblSoNguoi);

		JLabel lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMaPhong.setBounds(380, 60, 100, 30);
		panel_2.add(lblMaPhong);

		txtSoNguoi = new JTextField();
		txtSoNguoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSoNguoi.setEditable(false);
		txtSoNguoi.setText("10");
		txtSoNguoi.setBounds(509, 10, 102, 30);
		panel_2.add(txtSoNguoi);
		txtSoNguoi.setColumns(10);

		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMaPhong.setText("101");
		txtMaPhong.setEditable(false);
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(509, 60, 102, 30);
		panel_2.add(txtMaPhong);

		// --- cuối góc phải là 3 nút jbutton
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimKiem.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Research_icon.png"));
		btnTimKiem.setBounds(672, 10, 180, 40);
		btnTimKiem.setBackground(new Color(13, 153, 255, 255));
		panel_2.add(btnTimKiem);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Refresh_icon.png"));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoi.setBounds(879, 10, 180, 40);
		btnLamMoi.setBackground(new Color(112, 210, 103, 255));
		panel_2.add(btnLamMoi);

		btnTimKiemPDP = new JButton("Tìm Phiếu Đặt Phòng");
		btnTimKiemPDP.setIcon(new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\Research_icon.png"));
		btnTimKiemPDP.setForeground(Color.WHITE);
		btnTimKiemPDP.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimKiemPDP.setBounds(672, 55, 387, 40);
		btnTimKiemPDP.setBackground(new Color(255, 180, 0, 255));

		panel_2.add(btnTimKiemPDP);

		// ---gốc
		// 3----------------------------------****************************************************************
		panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		panel_3.setBounds(0, 163, 1080, 500);
		panel.add(panel_3);
		panel_3.setLayout(null);

		scrollPane_Phong = new JScrollPane();
		scrollPane_Phong.setBounds(0, 0, 1080, 500);
		panel_3.add(scrollPane_Phong);

		// Tạo JPanel bên ngoài với kích thước cố định
		outerPanel = new JPanel();
		outerPanel.setPreferredSize(new Dimension(1040, calculateSize()));
		outerPanel.setLayout(null);

		panel_ChuaPhong = new JPanel();
		panel_ChuaPhong.setBounds(0, 0, 1059, calculateSize());
		panel_ChuaPhong.setBackground(new Color(244, 242, 255, 255));
		outerPanel.add(panel_ChuaPhong);
		panel_ChuaPhong.setLayout(null);

		loadData();
		setEnabledBtnDatPhong();
		// Tạo một Timer để gọi lại loadRoomList() mỗi 5000 milliseconds (5 giây)
		sizeDSTmp = tmp_dao.getAllTemp().size();
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sizeDSTmp !=  tmp_dao.getAllTemp().size()) {
					sizeDSTmp = tmp_dao.getAllTemp().size(); 
					setEnabledBtnDatPhong();
				}
			}
		});

//		 Bắt đầu Timer
		timer.start();

		// ---gốc
		// 4----------------------------------****************************************************************
		// set size icon cho gốc 4
		ImageIcon phongtrong4 = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\phongtrong.png");
		Image originalImage_phongtrong4 = phongtrong4.getImage();
		Image resizedImage_phongtrong4 = originalImage_phongtrong4.getScaledInstance(30, 30,
				java.awt.Image.SCALE_SMOOTH);
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
		Image resizedImage_phongvip = originalImage_phongvip.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedIcon_phongvip = new ImageIcon(resizedImage_phongvip);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 690, 1080, 40);
		panel.add(panel_4);
		panel_4.setLayout(null);
		// lbl & icon phòng trống
		lbl_iconPhongTrong = new JLabel("Phòng Trống");
		lbl_iconPhongTrong.setIcon(resizedIcon_phongtrong4);
		lbl_iconPhongTrong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_iconPhongTrong.setBounds(15, 0, 140, 35);
		panel_4.add(lbl_iconPhongTrong);
		// lbl & icon phòng chờ
		lbl_iconPhongCho = new JLabel("Phòng Chờ");
		lbl_iconPhongCho.setIcon(resizedIcon_phongcho4);
		lbl_iconPhongCho.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_iconPhongCho.setBounds(180, 0, 140, 35);
		panel_4.add(lbl_iconPhongCho);
		// lbl & icon phòng đang sử dụng
		JLabel lbl_iconPhongSD = new JLabel("Phòng đang sử dụng");
		lbl_iconPhongSD.setIcon(resizedIcon_phongsd4);
		lbl_iconPhongSD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_iconPhongSD.setBounds(340, 0, 200, 35);
		panel_4.add(lbl_iconPhongSD);
		// lbl & icon phòng sửa chữa
		lbl_iconPhongsuaChua = new JLabel("Phòng sửa chửa");
		lbl_iconPhongsuaChua.setIcon(resizedIcon_phongsua4);
		lbl_iconPhongsuaChua.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_iconPhongsuaChua.setBounds(560, 0, 170, 35);
		panel_4.add(lbl_iconPhongsuaChua);
		// lbl & icon phòng VIP
		lbl_iconPhongVIP = new JLabel("Phòng VIP");
		lbl_iconPhongVIP.setIcon(resizedIcon_phongvip);
		lbl_iconPhongVIP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_iconPhongVIP.setBounds(850, 0, 140, 35);
		panel_4.add(lbl_iconPhongVIP);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.activeCaption);
		panel_5.setBounds(0, 663, 1080, 27);
		panel.add(panel_5);
		panel_5.setLayout(null);

		btnBackToBook = new JButton("Quay về đặt phòng");
		btnBackToBook.setBorderPainted(false);
		btnBackToBook.setForeground(Color.RED);
		btnBackToBook.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnBackToBook.setBounds(760, 3, 200, 20);
		panel_5.add(btnBackToBook);

		// thêm sự kiện
		btnUser.addActionListener(this);
		btnUser.addMouseListener(this);
		btnTimKiemPDP.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);

		// add sự kiện cho nút
		btnBackToBook.addActionListener(this);
	}

	private void loadData() {
		// chỉnh sửa kích thước các icon thường______________________
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

		// chỉnh sửa kích thước các icon VIP_______________________________
		ImageIcon phongtrongvip = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\trong_vip.png");
		Image originalImage_phongtrongvip = phongtrongvip.getImage();
		Image resizedImage_phongtrongvip = originalImage_phongtrongvip.getScaledInstance(60, 60,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedIcon_phongtrongvip = new ImageIcon(resizedImage_phongtrongvip);

		ImageIcon phongsdvip = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\sd_vip.png");
		Image originalImage_phongsdvip = phongsdvip.getImage();
		Image resizedImage_phongsdvip = originalImage_phongsdvip.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedIcon_phongsdvip = new ImageIcon(resizedImage_phongsdvip);

		ImageIcon phongchovip = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\cho_vip.png");
		Image originalImage_phongchovip = phongchovip.getImage();
		Image resizedImage_phongchovip = originalImage_phongchovip.getScaledInstance(60, 60,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedIcon_phongchovip = new ImageIcon(resizedImage_phongchovip);

		ImageIcon phongsuavip = new ImageIcon("D:\\BaiTapLonPTUD_NHOM4\\icon\\sua_vip.png");
		Image originalImage_phongsuavip = phongsuavip.getImage();
		Image resizedImage_phongsuavip = originalImage_phongsuavip.getScaledInstance(60, 60,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedIcon_phongsuavip = new ImageIcon(resizedImage_phongsuavip);
		int i = 0;
		int x = 40;
		int y = -110;
		int w = 160;
		int h = 100;

		// Xóa sự kiện thêm trước đó
		for (JButton btn : btnPhongList) {
			btn.removeActionListener(this);
		}

		// Xóa phòng thêm trước đó
		panel_ChuaPhong.removeAll();
		panel_ChuaPhong.revalidate();
		panel_ChuaPhong.repaint();

		for (Phong p : p_dao.getallPhongs()) {
			boolean kiemTra = true;
//			for (TempDatPhong tmp : tmp_dao.getAllTemp()) {
//				if (p.getMaPhong().equals(tmp.getMaPhong())) {
//					kiemTra = false;
//				}
//			}
//			if (kiemTra == true) {
			if (i % 5 == 0) {
				y += 130;
				x = 40;
			}
			i++;

			btnPhong = new JButton("Phòng " + p.getMaPhong());
			btnPhongList.add(btnPhong);
			LoaiPhong lp = lp_dao.getLoaiPhongTheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());
			btnPhong.setBounds(x, y, w, h);
			x += 210;
			btnPhong.setBackground(new Color(181, 230, 251, 255));
			if (lp.getTenLoaiPhong().equals("Phòng VIP")) {
				if (p.getTrangThai() == Enum_TrangThai.Trống)
					btnPhong.setIcon(resizedIcon_phongtrongvip);
				if (p.getTrangThai() == Enum_TrangThai.Chờ)
					btnPhong.setIcon(resizedIcon_phongchovip);
				if (p.getTrangThai() == Enum_TrangThai.Đang_sử_dụng)
					btnPhong.setIcon(resizedIcon_phongsdvip);
				if (p.getTrangThai() == Enum_TrangThai.Đang_sửa_chữa)
					btnPhong.setIcon(resizedIcon_phongsuavip);
			}
			if (lp.getTenLoaiPhong().equals("Phòng thường")) {
				if (p.getTrangThai() == Enum_TrangThai.Trống)
					btnPhong.setIcon(resizedIcon_phongtrong);
				if (p.getTrangThai() == Enum_TrangThai.Chờ)
					btnPhong.setIcon(resizedIcon_phongcho);
				if (p.getTrangThai() == Enum_TrangThai.Đang_sử_dụng)
					btnPhong.setIcon(resizedIcon_phongsd);
				if (p.getTrangThai() == Enum_TrangThai.Đang_sửa_chữa)
					btnPhong.setIcon(resizedIcon_phongsua);
			}

			btnPhong.setVerticalTextPosition(SwingConstants.BOTTOM);
			panel_ChuaPhong.add(btnPhong);
		}
//		}

		// Thêm lại sự kiện cho các phòng
		for (JButton btn : btnPhongList) {
			btn.addActionListener(this);
		}

		// Hiển thị lại giao diện
		panel_ChuaPhong.revalidate();
		panel_ChuaPhong.repaint();
		scrollPane_Phong.setViewportView(outerPanel);
	}

	private void setEnabledBtnDatPhong() {
		for (JButton btn : btnPhongList) {
			boolean kiemTra = true;
			String soPhong = btn.getText().replace("Phòng ", "");
			for (TempDatPhong tmp : tmp_dao.getAllTemp()) {
				if (soPhong.equals(tmp.getMaPhong()))
					kiemTra = false;
			}
			if(kiemTra)
				btn.setEnabled(true);
			else
				btn.setEnabled(false);
		}
	}

	private int calculateSize() {
		int i = p_dao.getallPhongs().size();
//		for (Phong p : p_dao.getallPhongs()) {
//			boolean kiemTra = true;
//			for (TempDatPhong tmp : tmp_dao.getAllTemp()) {
//				if (p.getMaPhong().equals(tmp.getMaPhong()))
//					kiemTra = false;
//			}
//			if (kiemTra == true)
//				i++;
//		}
		if (i <= 15) {
			return 498;
		} else if (i <= 20) {
			return 540;
		} else {
			return 540 + (((i - 1) / 5) - 3) * 130;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnUser)) {
			dialog_user.setVisible(true);
		}
		if (o.equals(btnBackToBook)) {
			if (tmp_dao.getAllTemp().size() == 1) {
				JOptionPane.showMessageDialog(this, "Chưa phòng nào được thêm vào danh sách đặt");
			} else {
				loadData();
				dialog_DatPhongTrong_2 = new Dialog_DatPhongTrong_2(TOOL_TIP_TEXT_KEY, null, null, ABORT);
				dialog_DatPhongTrong_2.setVisible(true);
			}
		}
		if (o instanceof JButton) {
			JButton clickedButton = (JButton) o;
			for (JButton btn : btnPhongList) {
				if (btn == clickedButton) {
					String maPhong = clickedButton.getText().replace("Phòng ", "");
					Phong p = p_dao.getPhongTheoMaPhong(maPhong);
					if (p.getTrangThai() == Enum_TrangThai.Trống) {
						dialog_htPhong = new Dialog_HienThiPhong(maPhong);
						dialog_htPhong.setVisible(true);
						break;
					}
//					if (p.getTrangThai() == TrangThai.Chờ) {
//						dialog_htPhong = new Dialog_HienThiPhong(maPhong);
//						dialog_htPhong.setVisible(true);
//						break;
//					}
					if (p.getTrangThai() == Enum_TrangThai.Đang_sử_dụng) {
						dialog_PhongDangSD = new Dialog_PhongDangSD(maPhong);
						dialog_PhongDangSD.setVisible(true);
						break;
					}
					if (p.getTrangThai() == Enum_TrangThai.Đang_sửa_chữa) {
						dialog_htPhong = new Dialog_HienThiPhong(maPhong);
						dialog_htPhong.setVisible(true);
						break;
					}
					break;
				}
			}
		}
	}
}
