package app;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GD_TroGiup extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle, lblProfile, lblListTitle,lblF1, lblF2, lblF3, lblF4,
	lblF5, lblF6, lblF7, lblF8, lblCtrl_N, lblCtrl_M, lblCtrl_K, lblCtrl_J, lblCtrl_H,
	lblScreenFlowTitle, lblKeyWord, lblScreenFlow, lblSP, lblKH, lblNV, lblHD, lblDV, lblDS,
	lblVND, lblSX;
	public GD_TroGiup() {
		setBackground(Color.decode("#FAFAFF"));
		setLayout(null);
//		Styling header
		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(Color.decode("#B5E6FB"));
		pnNorth.setBounds(0, 0, 1080, 60);
		pnNorth.setLayout(null);
		lblTitle = new JLabel("TRỢ GIÚP");
		lblTitle.setBounds(501, 15, 200, 30);
		lblTitle.setForeground(Color.blue);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		pnNorth.add(lblTitle);
		lblProfile = new JLabel("");
		lblProfile.setBackground(new Color(255, 165, 0));
		lblProfile.setIcon(new ImageIcon("icon\\icon_profile.png"));
		lblProfile.setBounds(1020, 7, 45, 45);
		ImageIcon iconProfile = new ImageIcon("icon\\icon_profile.png");
		iconProfile = new ImageIcon(iconProfile.getImage().getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH));
		lblProfile.setIcon(iconProfile);
		pnNorth.add(lblProfile);
		add(pnNorth);
		
//		Styling Content
		JPanel pnContent = new JPanel();
		pnContent.setBackground(Color.decode("#F4F2FF"));
		pnContent.setBounds(0, 60, 1080, 706);
		pnContent.setLayout(null);
		pnContent.add(lblListTitle = new JLabel("DANH SÁCH CÁC PHÍM TẮT"));
		lblListTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblListTitle.setBounds(32, 18, 400, 50);
		
//		First introduce box
		JPanel pnBoxWrapperFirst = new JPanel();
		pnBoxWrapperFirst.setBounds(32, 68, 214, 293);
		pnBoxWrapperFirst.setBackground(Color.decode("#B5E6FB"));
		pnBoxWrapperFirst.setLayout(null);
		pnBoxWrapperFirst.setPreferredSize(new Dimension(214, 293));
		pnBoxWrapperFirst.add(lblF1 = new JLabel("F1: Đặt phòng"));
		lblF1.setBounds(20, 20, 200, 50);
		pnBoxWrapperFirst.add(lblF2 = new JLabel("F2: Danh sách phòng"));
		lblF2.setBounds(20, 70, 200, 50);
		pnBoxWrapperFirst.add(lblF3 = new JLabel("F3: Nhân viên"));
		lblF3.setBounds(20, 120, 200, 50);
		pnBoxWrapperFirst.add(lblF4 = new JLabel("F4: Khách hàng"));
		lblF4.setBounds(20, 170, 200, 50);
		pnBoxWrapperFirst.add(lblF1);
		pnBoxWrapperFirst.add(lblF2);
		pnBoxWrapperFirst.add(lblF3);
		pnBoxWrapperFirst.add(lblF4);
		
//		Second introduce box
		JPanel pnBoxWrapperSecond = new JPanel();
		pnBoxWrapperSecond.setBounds(278, 68, 214, 293);
		pnBoxWrapperSecond.setBackground(Color.decode("#B5E6FB"));
		pnBoxWrapperSecond.setLayout(null);
		pnBoxWrapperSecond.setPreferredSize(new Dimension(214, 293));
		pnBoxWrapperSecond.add(lblF5 = new JLabel("F5: Sản phẩm"));
		lblF5.setBounds(20, 20, 200, 50);
		pnBoxWrapperSecond.add(lblF6 = new JLabel("F6: Hóa đơn"));
		lblF6.setBounds(20, 70, 200, 50);
		pnBoxWrapperSecond.add(lblF7 = new JLabel("F7: Thống kê"));
		lblF7.setBounds(20, 120, 200, 50);
		pnBoxWrapperSecond.add(lblF8 = new JLabel("F8: Tàì khoản"));
		lblF8.setBounds(20, 170, 200, 50);
		pnBoxWrapperSecond.add(lblF5);
		pnBoxWrapperSecond.add(lblF6);
		pnBoxWrapperSecond.add(lblF7);
		pnBoxWrapperSecond.add(lblF8);
		
//		Third introduce box
		JPanel pnBoxWrapperThird = new JPanel();
		pnBoxWrapperThird.setBounds(524, 68, 214, 293);
		pnBoxWrapperThird.setBackground(Color.decode("#B5E6FB"));
		pnBoxWrapperThird.setLayout(null);
		pnBoxWrapperThird.setPreferredSize(new Dimension(214, 293));
		pnBoxWrapperThird.add(lblCtrl_N = new JLabel("CRTL + N:  thêm mới"));
		lblCtrl_N.setBounds(20, 20, 200, 50);
		pnBoxWrapperThird.add(lblCtrl_M = new JLabel("CRTL + M: nút hủy"));
		lblCtrl_M.setBounds(20, 70, 200, 50);
		pnBoxWrapperThird.add(lblCtrl_K = new JLabel("CTRL + K:  nút chuyển"));
		lblCtrl_K.setBounds(20, 120, 200, 50);
		pnBoxWrapperThird.add(lblCtrl_J = new JLabel("CTRL + J: nút nhận"));
		lblCtrl_J.setBounds(20, 170, 200, 50);
		pnBoxWrapperThird.add(lblCtrl_H = new JLabel("CTRL+ H: nút quay lại"));
		lblCtrl_H.setBounds(20, 220, 200, 50);
		pnBoxWrapperThird.add(lblCtrl_N);
		pnBoxWrapperThird.add(lblCtrl_M);
		pnBoxWrapperThird.add(lblCtrl_K);
		pnBoxWrapperThird.add(lblCtrl_J);
		pnBoxWrapperThird.add(lblCtrl_H);
		
//		Fourth introduce box
		JPanel pnBoxWrapperFourth = new JPanel();
		pnBoxWrapperFourth.setBounds(770, 68, 214, 293);
		pnBoxWrapperFourth.setBackground(Color.decode("#B5E6FB"));
		pnBoxWrapperFourth.setLayout(null);
		pnBoxWrapperFourth.setPreferredSize(new Dimension(214, 293));
		JLabel lblRow1, lblRow2, lblRow3, lblRow4, lblRow5, lblRow6, lblRow7,
		lblRow8, lblRow9, lblRow10;
		pnBoxWrapperFourth.add(lblRow1 = new JLabel("Delete:"));
		lblRow1.setBounds(20, 20, 200, 50);
		pnBoxWrapperFourth.add(lblRow2 = new JLabel("+ Nếu trong 1 dòng "));
		lblRow2.setBounds(20, 46, 200, 50);
		pnBoxWrapperFourth.add(lblRow3 = new JLabel("trong danh sách nhấn"));
		lblRow3.setBounds(20, 66, 200, 50);
		pnBoxWrapperFourth.add(lblRow4 = new JLabel("delete sẽ thực hiện"));
		lblRow4.setBounds(20, 86, 200, 50);
		pnBoxWrapperFourth.add(lblRow5 = new JLabel("chức năng xóa"));
		lblRow5.setBounds(20, 106, 200, 50);
		pnBoxWrapperFourth.add(lblRow6 = new JLabel("Enter:"));
		lblRow6.setBounds(20, 132, 200, 50);
		pnBoxWrapperFourth.add(lblRow7 = new JLabel("+ Nhập trong ô tìm "));
		lblRow7.setBounds(20, 158, 200, 50);
		pnBoxWrapperFourth.add(lblRow8 = new JLabel("kiếm sẽ thực hiện tìm"));
		lblRow8.setBounds(20, 184, 200, 50);
		pnBoxWrapperFourth.add(lblRow9 = new JLabel("+ Trong phần thêm ở ô"));
		lblRow9.setBounds(20, 210, 200, 50);
		pnBoxWrapperFourth.add(lblRow10 = new JLabel("cuối sẽ thực hiện thêm"));
		lblRow10.setBounds(20, 236, 200, 50);
		pnContent.add(pnBoxWrapperFirst);
		pnContent.add(pnBoxWrapperSecond);
		pnContent.add(pnBoxWrapperThird);
		pnContent.add(pnBoxWrapperFourth);
		
//		Styling ScreenFlow
		JPanel pnScreenFlowWrapper = new JPanel();
		pnScreenFlowWrapper.setBackground(Color.decode("#F4F2FF"));
		pnScreenFlowWrapper.setBounds(32, 356, 460, 310);
		pnScreenFlowWrapper.setPreferredSize(new Dimension(460, 256));
		pnScreenFlowWrapper.setLayout(null);
		pnScreenFlowWrapper.add(lblScreenFlowTitle = new JLabel("SƠ ĐỒ MÀN HÌNH"));
		lblScreenFlowTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblScreenFlowTitle.setBounds(0, 0, 400, 50);
		lblScreenFlow = new JLabel("");
		lblScreenFlow.setIcon(new ImageIcon("image\\gd_trogiup_screenflow.png"));
		lblScreenFlow.setBounds(0, 10, 460, 256);
		ImageIcon imageScreenFlow = new ImageIcon("image\\gd_trogiup_screenflow.png");
		imageScreenFlow = new ImageIcon(imageScreenFlow.getImage().getScaledInstance(460, 256, java.awt.Image.SCALE_SMOOTH));
		lblScreenFlow.setIcon(imageScreenFlow);
		pnScreenFlowWrapper.add(lblScreenFlow);
		lblScreenFlow.setBounds(0, 50, 460, 256);
		pnContent.add(pnScreenFlowWrapper);
//		Styling Key word box
		JPanel pnKeyWordWrapper = new JPanel();
		pnKeyWordWrapper.setBackground(Color.decode("#F4F2FF"));
		pnKeyWordWrapper.setBounds(540, 356, 460, 310);
		pnKeyWordWrapper.setPreferredSize(new Dimension(460, 256));
		pnKeyWordWrapper.setLayout(null);
		pnKeyWordWrapper.add(lblKeyWord = new JLabel("DANH SÁCH CÁC TỪ KHÓA"));
		lblKeyWord.setFont(new Font("Arial", Font.BOLD, 20));
		lblKeyWord.setBounds(0, 0, 400, 50);
		JPanel pnKeyWordContent = new JPanel();
		pnKeyWordContent.setBackground(Color.white);
		pnKeyWordContent.setLayout(null);
		pnKeyWordContent.setBounds(0, 50, 460, 256);
		pnKeyWordContent.add(lblSP = new JLabel("SP: SẢN PHẨM"));
		lblSP.setBounds(32, 25, 200, 35);
		pnKeyWordContent.add(lblKH = new JLabel("KH: KHÁCH HÀNG"));
		lblKH.setBounds(32, 75, 200, 35);
		pnKeyWordContent.add(lblNV = new JLabel("NV: NHÂN VIÊN"));
		lblNV.setBounds(32, 125, 200, 35);
		pnKeyWordContent.add(lblHD = new JLabel("HD: HÓA ĐƠN"));
		lblHD.setBounds(32, 175, 200, 35);
		pnKeyWordContent.add(lblDV = new JLabel("DV: DỊCH VỤ"));
		lblDV.setBounds(272, 25, 200, 35);
		pnKeyWordContent.add(lblDS = new JLabel("DS: DANH SÁCH"));
		lblDS.setBounds(272, 75, 200, 35);
		pnKeyWordContent.add(lblVND = new JLabel("VND: VIỆT NAM ĐỒNG"));
		lblVND.setBounds(272, 125, 200, 35);
		pnKeyWordContent.add(lblSX = new JLabel("SX: SẢN XUẤT"));
		lblSX.setBounds(272, 175, 200, 35);
		pnKeyWordWrapper.add(pnKeyWordContent);
		pnContent.add(pnKeyWordWrapper);
		lblF1.setFont(new Font("Arial", Font.BOLD, 16));
		lblF2.setFont(new Font("Arial", Font.BOLD, 16));
		lblF3.setFont(new Font("Arial", Font.BOLD, 16));
		lblF4.setFont(new Font("Arial", Font.BOLD, 16));
		lblF5.setFont(new Font("Arial", Font.BOLD, 16));
		lblF6.setFont(new Font("Arial", Font.BOLD, 16));
		lblF7.setFont(new Font("Arial", Font.BOLD, 16));
		lblF8.setFont(new Font("Arial", Font.BOLD, 16));
		lblCtrl_N.setFont(new Font("Arial", Font.BOLD, 16));
		lblCtrl_M.setFont(new Font("Arial", Font.BOLD, 16));
		lblCtrl_K.setFont(new Font("Arial", Font.BOLD, 16));
		lblCtrl_J.setFont(new Font("Arial", Font.BOLD, 16));
		lblCtrl_H.setFont(new Font("Arial", Font.BOLD, 16));
		lblScreenFlowTitle.setFont(new Font("Arial", Font.BOLD, 16));
		lblKeyWord.setFont(new Font("Arial", Font.BOLD, 16));
		lblSP.setFont(new Font("Arial", Font.BOLD, 16));
		lblKH.setFont(new Font("Arial", Font.BOLD, 16));
		lblNV.setFont(new Font("Arial", Font.BOLD, 16));
		lblHD.setFont(new Font("Arial", Font.BOLD, 16));
		lblDV.setFont(new Font("Arial", Font.BOLD, 16));
		lblDS.setFont(new Font("Arial", Font.BOLD, 16));
		lblVND.setFont(new Font("Arial", Font.BOLD, 16));
		lblSX.setFont(new Font("Arial", Font.BOLD, 16));
		lblRow1.setFont(new Font("Arial", Font.BOLD, 16));
		lblRow2.setFont(new Font("Arial", Font.BOLD, 16));
		lblRow3.setFont(new Font("Arial", Font.BOLD, 16));
		lblRow4.setFont(new Font("Arial", Font.BOLD, 16));
		lblRow5.setFont(new Font("Arial", Font.BOLD, 16));
		lblRow6.setFont(new Font("Arial", Font.BOLD, 16));
		lblRow7.setFont(new Font("Arial", Font.BOLD, 16));
		lblRow8.setFont(new Font("Arial", Font.BOLD, 16));
		lblRow9.setFont(new Font("Arial", Font.BOLD, 16));
		lblRow10.setFont(new Font("Arial", Font.BOLD, 16));
		add(pnContent);
	}
}
