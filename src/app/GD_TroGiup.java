package app;
import java.awt.BorderLayout;
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
		JPanel pnContainer = new JPanel();
		pnContainer.setBackground(Color.decode("#FAFAFF"));
		pnContainer.setLayout(new BorderLayout());
//		Styling header
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BorderLayout());
		pnNorth.setPreferredSize(new Dimension(1080, 60));
		JPanel pnHeaderCenter = new JPanel();
		pnHeaderCenter.setBackground(Color.decode("#B5E6FB"));
		lblTitle = new JLabel("TRỢ GIÚP");
		lblTitle.setForeground(Color.blue);
		lblTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		pnHeaderCenter.add(lblTitle);
		JPanel pnHeaderRight = new JPanel();
		pnHeaderRight.setBackground(Color.decode("#B5E6FB"));
		lblProfile = new JLabel("");
		lblProfile.setBackground(new Color(255, 165, 0));
		lblProfile.setIcon(new ImageIcon("icon\\icon_profile.png"));
		lblProfile.setBounds(0, 10, 45, 45);
		ImageIcon iconProfile = new ImageIcon("icon\\icon_profile.png");
		iconProfile = new ImageIcon(iconProfile.getImage().getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH));
		lblProfile.setIcon(iconProfile);
		pnHeaderRight.add(lblProfile);
		pnNorth.add(pnHeaderCenter, BorderLayout.CENTER);
		pnNorth.add(pnHeaderRight, BorderLayout.EAST);
		pnContainer.add(pnNorth, BorderLayout.NORTH);
		
//		Styling Content
		JPanel pnContent = new JPanel();
		pnContent.setBackground(Color.decode("#F4F2FF"));
		pnContent.setPreferredSize(new Dimension(1080, 706));
		pnContent.setLayout(null);
		pnContent.add(lblListTitle = new JLabel("DANH SÁCH CÁC PHÍM TẮT"));
		lblListTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		lblListTitle.setBounds(32, 18, 400, 50);
		
//		First introduce box
		JPanel pnBoxWrapperFirst = new JPanel();
		pnBoxWrapperFirst.setBounds(32, 68, 214, 293);
		pnBoxWrapperFirst.setBackground(Color.decode("#B5E6FB"));
		pnBoxWrapperFirst.setLayout(null);
		pnBoxWrapperFirst.setPreferredSize(new Dimension(214, 293));
		pnBoxWrapperFirst.add(lblF1 = new JLabel("F1: Đặt phòng"));
		lblF1.setBounds(37, 20, 150, 50);
		pnBoxWrapperFirst.add(lblF2 = new JLabel("F2: Danh sách phòng"));
		lblF2.setBounds(37, 70, 150, 50);
		pnBoxWrapperFirst.add(lblF3 = new JLabel("F3: Nhân viên"));
		lblF3.setBounds(37, 120, 150, 50);
		pnBoxWrapperFirst.add(lblF4 = new JLabel("F4: Khách hàng"));
		lblF4.setBounds(37, 170, 150, 50);
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
		lblF5.setBounds(37, 20, 150, 50);
		pnBoxWrapperSecond.add(lblF6 = new JLabel("F6: Hóa đơn"));
		lblF6.setBounds(37, 70, 150, 50);
		pnBoxWrapperSecond.add(lblF7 = new JLabel("F7: Thống kê"));
		lblF7.setBounds(37, 120, 150, 50);
		pnBoxWrapperSecond.add(lblF8 = new JLabel("F8: Tàì khoản"));
		lblF8.setBounds(37, 170, 150, 50);
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
		lblCtrl_N.setBounds(37, 20, 150, 50);
		pnBoxWrapperThird.add(lblCtrl_M = new JLabel("CRTL + M: nút hủy"));
		lblCtrl_M.setBounds(37, 70, 150, 50);
		pnBoxWrapperThird.add(lblCtrl_K = new JLabel("CTRL + K:  nút chuyển"));
		lblCtrl_K.setBounds(37, 120, 150, 50);
		pnBoxWrapperThird.add(lblCtrl_J = new JLabel("CTRL + J: nút nhận"));
		lblCtrl_J.setBounds(37, 170, 150, 50);
		pnBoxWrapperThird.add(lblCtrl_H = new JLabel("CTRL+ H: nút quay lại"));
		lblCtrl_H.setBounds(37, 220, 150, 50);
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
		lblRow1.setBounds(37, 20, 150, 50);
		pnBoxWrapperFourth.add(lblRow2 = new JLabel("+ Nếu trong 1 dòng "));
		lblRow2.setBounds(37, 46, 150, 50);
		pnBoxWrapperFourth.add(lblRow3 = new JLabel("trong danh sách nhấn"));
		lblRow3.setBounds(37, 66, 150, 50);
		pnBoxWrapperFourth.add(lblRow4 = new JLabel("delete sẽ thực hiện"));
		lblRow4.setBounds(37, 86, 150, 50);
		pnBoxWrapperFourth.add(lblRow5 = new JLabel("chức năng xóa"));
		lblRow5.setBounds(37, 106, 150, 50);
		pnBoxWrapperFourth.add(lblRow6 = new JLabel("Enter:"));
		lblRow6.setBounds(37, 132, 150, 50);
		pnBoxWrapperFourth.add(lblRow7 = new JLabel("+ Nhập trong ô tìm "));
		lblRow7.setBounds(37, 158, 150, 50);
		pnBoxWrapperFourth.add(lblRow8 = new JLabel("kiếm sẽ thực hiện tìm"));
		lblRow8.setBounds(37, 184, 150, 50);
		pnBoxWrapperFourth.add(lblRow9 = new JLabel("+ Trong phần thêm ở ô"));
		lblRow9.setBounds(37, 210, 150, 50);
		pnBoxWrapperFourth.add(lblRow10 = new JLabel("cuối sẽ thực hiện thêm"));
		lblRow10.setBounds(37, 236, 150, 50);
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
		lblScreenFlowTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
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
		lblKeyWord.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		lblKeyWord.setBounds(0, 0, 400, 50);
		JPanel pnKeyWordContent = new JPanel();
		pnKeyWordContent.setBackground(Color.white);
		pnKeyWordContent.setLayout(null);
		pnKeyWordContent.setBounds(0, 50, 460, 256);
		pnKeyWordContent.add(lblSP = new JLabel("SP: SẢN PHẨM"));
		lblSP.setBounds(32, 25, 150, 35);
		pnKeyWordContent.add(lblSP = new JLabel("KH: KHÁCH HÀNG"));
		lblSP.setBounds(32, 75, 150, 35);
		pnKeyWordContent.add(lblSP = new JLabel("NV: NHÂN VIÊN"));
		lblSP.setBounds(32, 125, 150, 35);
		pnKeyWordContent.add(lblSP = new JLabel("HD: HÓA ĐƠN"));
		lblSP.setBounds(32, 175, 150, 35);
		pnKeyWordContent.add(lblSP = new JLabel("DV: DỊCH VỤ"));
		lblSP.setBounds(272, 25, 150, 35);
		pnKeyWordContent.add(lblSP = new JLabel("DS: DANH SÁCH"));
		lblSP.setBounds(272, 75, 150, 35);
		pnKeyWordContent.add(lblSP = new JLabel("VND: VIỆT NAM ĐỒNG"));
		lblSP.setBounds(272, 125, 150, 35);
		pnKeyWordContent.add(lblSP = new JLabel("SX: SẢN XUẤT"));
		lblSP.setBounds(272, 175, 150, 35);
		pnKeyWordWrapper.add(pnKeyWordContent);
		pnContent.add(pnKeyWordWrapper);
		pnContainer.add(pnContent, BorderLayout.CENTER);
		add(pnContainer);
	}
}
