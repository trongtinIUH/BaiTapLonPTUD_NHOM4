package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Properties;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.awt.Window;
import javax.swing.UIManager;

import entity.DateLabelFormatter;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.Phong;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.zinternaltools.DateTimeChangeEvent;

import dao.KhachHang_dao;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Dialog_DatPhongTrong_2 extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSDT;
	private JButton btn_KiemTraSDT, btn_ThemDV, btn_QuayLai, btn_DatPhong;
	private JPanel panel_1, panel_2;
	private JCheckBox checkBox_KH;
	private JLabel lbl_GioiTinh_1, lbl_SoNguoi_1, lbl_GiaTien_1, lbl_TenKH_1;
	private JTextArea txtThemDV;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtSoNguoi;
	private JButton btn_DatThemPhong;

	private JTable tblThemPhongMoi;
	private DefaultTableModel model;
	private String col[] = { "Mã Phòng", "Loại Phòng", "Số Người", "Đơn Giá", "Trạng Thái" };

	private Dialog_DatThemPhongTrong dialog_DatThemPhongTrong;
	private Dialog_ThemDichVu dialog_ThemDichVu ;
	private JLabel lbl_TrangThai, lbl_Loai, lbl_sdtKH, lbl_TenKH, lbl_GioiTinh, lbl_GiaTien, lbl_SoNguoi,lbl_LoaiKhachHang;

	
	private LocalDateTime now;
	private DateTimePicker dateTimePicker;
	private TimePickerSettings timeSettings;
	private DatePickerSettings dateSettings;
	private JButton btn_XoaPhongDat;
	private JCheckBox checkbox_GioTuDo;
	private JCheckBox checkbox_GioTuMacDinh;
	
	private KhachHang_dao khachHang_dao;
	public Dialog_DatPhongTrong_2(String maPhong, Phong p, LoaiPhong lp) {
		// màn
		// hình******************************************************************************
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setSize(800, 500);
		setLocationRelativeTo(null);

		// panel chứa tiêu đề--------------------------------------
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 35);
		panel.setBackground(new Color(181, 230, 251));
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTieuDe = new JLabel("Phòng " + maPhong);
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 790, 35);
		panel.add(lblTieuDe);

		// pane; chứa các phần còn lại---------------------------------
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 35, 784, 426);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lbl_TrangThai = new JLabel("Trạng thái:");
		lbl_TrangThai.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TrangThai.setBounds(10, 5, 100, 25);
		panel_1.add(lbl_TrangThai);

		JLabel lbl_Loai = new JLabel("Loại:");
		lbl_Loai.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_Loai.setBounds(10, 40, 60, 25);
		panel_1.add(lbl_Loai);

		JLabel lbl_LoaiKhachHang = new JLabel("Khách hàng mặc định:");
		lbl_LoaiKhachHang.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_LoaiKhachHang.setBounds(10, 70, 180, 25);
		panel_1.add(lbl_LoaiKhachHang);

		checkBox_KH = new JCheckBox("");
		checkBox_KH.setBackground(Color.WHITE);
		checkBox_KH.setHorizontalAlignment(SwingConstants.LEFT);
		checkBox_KH.setFont(new Font("Arial", Font.BOLD, 15));
		checkBox_KH.setBounds(210, 70, 30, 25);
		panel_1.add(checkBox_KH);

		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(10, 155, 760, 40);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lbl_sdtKH = new JLabel("SDT khách:");
		lbl_sdtKH.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sdtKH.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_sdtKH.setBounds(5, 5, 130, 30);
		panel_2.add(lbl_sdtKH);

		txtSDT = new JTextField();
		txtSDT.setHorizontalAlignment(SwingConstants.LEFT);
		txtSDT.setFont(new Font("Arial", Font.BOLD, 16));
		txtSDT.setText("0947677077");
		txtSDT.setBounds(140, 5, 300, 30);
		panel_2.add(txtSDT);
		txtSDT.setColumns(10);

		lbl_TenKH = new JLabel("Tên khách hàng:");
		lbl_TenKH.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TenKH.setBounds(10, 200, 135, 30);
		panel_1.add(lbl_TenKH);

		JLabel lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioiTinh.setBounds(450, 200, 77, 30);
		panel_1.add(lbl_GioiTinh);

		lbl_GioiTinh_1 = new JLabel("Nam");
		lbl_GioiTinh_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioiTinh_1.setBounds(550, 200, 100, 30);
		panel_1.add(lbl_GioiTinh_1);

		JLabel lbl_GiaTien = new JLabel("Giá tiền:");
		lbl_GiaTien.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GiaTien.setBounds(440, 40, 80, 25);
		panel_1.add(lbl_GiaTien);

		JLabel lbl_SoNguoi = new JLabel("Số người:");
		lbl_SoNguoi.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SoNguoi.setBounds(440, 5, 80, 25);
		panel_1.add(lbl_SoNguoi);

		txtSoNguoi = new JTextField();
		txtSoNguoi.setText(lp.getSucChua() + "");
		txtSoNguoi.setFont(new Font("Arial", Font.BOLD, 16));
		txtSoNguoi.setBounds(550, 5, 100, 25);
		panel_1.add(txtSoNguoi);

		lbl_GiaTien_1 = new JLabel(lp.getDonGiaTheoGio() + " VNĐ");
		lbl_GiaTien_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GiaTien_1.setBounds(550, 40, 200, 25);
		panel_1.add(lbl_GiaTien_1);

		lbl_TenKH_1 = new JLabel("Nguyễn Văn A");
		lbl_TenKH_1.setFont(new Font("Arial", Font.ITALIC, 17));
		lbl_TenKH_1.setBounds(165, 200, 180, 30);
		panel_1.add(lbl_TenKH_1);

		txtThemDV = new JTextArea();
		txtThemDV.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtThemDV.setEditable(false);
		txtThemDV.setText("bia, nước ngọt, bánh trung thu");
		txtThemDV.setBackground(SystemColor.control);
		txtThemDV.setBounds(150, 340, 625, 30);
		panel_1.add(txtThemDV);

		// các nút
		// jbutton-------------------------------------------------------------------
		btn_DatPhong = new JButton("Đặt Phòng");
		btn_DatPhong.setBackground(Color.GREEN);
		btn_DatPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_DatPhong.setBackground(new Color(33, 167, 38, 255));
		btn_DatPhong.setBounds(10, 380, 160, 40);
		panel_1.add(btn_DatPhong);

		btn_QuayLai = new JButton("Quay Lại");
		btn_QuayLai.setFont(new Font("Arial", Font.BOLD, 18));
		btn_QuayLai.setBackground(new Color(255, 83, 83, 255));
		btn_QuayLai.setBounds(605, 380, 170, 40);
		panel_1.add(btn_QuayLai);

		btn_ThemDV = new JButton("Thêm DV");
		btn_ThemDV.setBackground(Color.LIGHT_GRAY);
		btn_ThemDV.setFont(new Font("Arial", Font.BOLD, 15));
		btn_ThemDV.setBounds(10, 340, 120, 30);
		panel_1.add(btn_ThemDV);

		btn_KiemTraSDT = new JButton("Kiểm Tra");
		btn_KiemTraSDT.setBackground(UIManager.getColor("Button.background"));
		btn_KiemTraSDT.setFont(new Font("Arial", Font.BOLD, 17));
		btn_KiemTraSDT.setBounds(480, 5, 200, 30);
		panel_2.add(btn_KiemTraSDT);

		JLabel lbl_SoNguoi_1_1 = new JLabel(p.getTrangThai() + "");
		lbl_SoNguoi_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SoNguoi_1_1.setBounds(140, 5, 250, 25);
		panel_1.add(lbl_SoNguoi_1_1);

		JLabel lbl_SoNguoi_1_2 = new JLabel(lp.getTenLoaiPhong());
		lbl_SoNguoi_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SoNguoi_1_2.setBounds(140, 40, 200, 25);
		panel_1.add(lbl_SoNguoi_1_2);

		btn_DatThemPhong = new JButton("Đặt Thêm Phòng");
		btn_DatThemPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_DatThemPhong.setBackground(new Color(109, 197, 112));
		btn_DatThemPhong.setBounds(180, 380, 200, 40);
		panel_1.add(btn_DatThemPhong);

		// bảng thêm phòng mới
		model = new DefaultTableModel(col, 0);
		tblThemPhongMoi = new JTable(model);
		tblThemPhongMoi.setFont(new Font("Arial", Font.PLAIN, 12));
		tblThemPhongMoi.setBackground(Color.WHITE);
		JScrollPane sp = new JScrollPane(tblThemPhongMoi);
		sp.setBounds(10, 235, 765, 100);
		panel_1.add(sp);
		panel_1.setPreferredSize(new Dimension(800, 300));
		
		JLabel lbl_GioTraPhong = new JLabel("Giờ trả phòng mặc định:");
		lbl_GioTraPhong.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioTraPhong.setBounds(10, 110, 190, 25);
		panel_1.add(lbl_GioTraPhong);
		
		now = LocalDateTime.now();

 	        dateSettings = new DatePickerSettings();
	        dateSettings.setLocale(new Locale("vi","VN")); // Set the locale to English
	        dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd"); // Set the date format

	        timeSettings = new TimePickerSettings();
	        timeSettings.setDisplaySpinnerButtons(true);

	        dateTimePicker = new DateTimePicker(dateSettings, timeSettings);
	        dateTimePicker.getDatePicker().getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 12));
	        dateTimePicker.getTimePicker().getComponentTimeTextField().setFont(new Font("Tahoma", Font.PLAIN, 12));
	        dateTimePicker.getTimePicker().getComponentSpinnerPanel().setBounds(80, 0, 0, 25);
	        dateTimePicker.getTimePicker().getComponentToggleTimeMenuButton().setBounds(75, 0, 26, 25);
	        dateTimePicker.getTimePicker().getComponentTimeTextField().setBounds(0, 0, 70, 25);
	        dateTimePicker.getTimePicker().getComponentToggleTimeMenuButton().setFont(new Font("Tahoma", Font.BOLD, 12));
	        dateTimePicker.getDatePicker().getComponentToggleCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 12));
	        dateTimePicker.timePicker.setBounds(141, 0, 80, 25);
	        dateTimePicker.datePicker.setBounds(0, 0, 136, 25);
	        dateTimePicker.getTimePicker().setBounds(150, 0, 110, 25);
	        dateTimePicker.getTimePicker().setLayout(null);
	        dateTimePicker.getDatePicker().setBounds(0, 0, 136, 25);
	        dateTimePicker.setDateTimePermissive(now);

	        // Add the DateTimePicker to your user interface, e.g. to a JPanel
	        // panel.add(dateTimePicker);
	        dateTimePicker.setBounds(250, 110, 260, 25);
		panel_1.add(dateTimePicker);
		dateTimePicker.setLayout(null);
		
		JLabel lbl_GioTraPhongTuDo = new JLabel("Giờ trả phòng tự do:");
		lbl_GioTraPhongTuDo.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioTraPhongTuDo.setBounds(440, 70, 160, 25);
		panel_1.add(lbl_GioTraPhongTuDo);
		
		checkbox_GioTuDo = new JCheckBox("");
		checkbox_GioTuDo.setBackground(Color.WHITE);
		checkbox_GioTuDo.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkbox_GioTuDo.setBounds(606, 70, 37, 25);
		panel_1.add(checkbox_GioTuDo);
		
		checkbox_GioTuMacDinh = new JCheckBox("");
		checkbox_GioTuMacDinh.setBackground(Color.WHITE);
		checkbox_GioTuMacDinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkbox_GioTuMacDinh.setBounds(210, 110, 30, 25);
		panel_1.add(checkbox_GioTuMacDinh);
		
		btn_XoaPhongDat = new JButton("Xóa Phòng Đặt");
		btn_XoaPhongDat.setFont(new Font("Arial", Font.BOLD, 18));
		btn_XoaPhongDat.setBackground(new Color(234,234,114,255));
		btn_XoaPhongDat.setBounds(390, 380, 170, 40);
		panel_1.add(btn_XoaPhongDat);


		
		
		
		// thêm sự kiện button
		btn_DatPhong.addActionListener(this);
		btn_KiemTraSDT.addActionListener(this);
		btn_QuayLai.addActionListener(this);
		btn_ThemDV.addActionListener(this);
		btn_DatThemPhong.addActionListener(this);
		btn_XoaPhongDat.addActionListener(this);
		checkbox_GioTuDo.addActionListener(this);
		checkbox_GioTuMacDinh.addActionListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btn_QuayLai)) {
			setVisible(false);
		}
		if (o.equals(btn_ThemDV)) {
			
			dialog_ThemDichVu = new Dialog_ThemDichVu(lbl_TenKH_1.getText());
			dialog_ThemDichVu.setVisible(true);
		}
		if (o.equals(btn_DatPhong)) {
			JOptionPane.showMessageDialog(this, "Đặt phòng thành công, thời gian bắt đầu được tính !");
			setVisible(false);
	        Window[] windows = Window.getWindows();
	        for (Window window : windows) {
	            if (window instanceof JDialog) {
	                window.dispose();
	            }
	        }
	    }
		if (o.equals(btn_DatThemPhong)) {
			dialog_DatThemPhongTrong = new Dialog_DatThemPhongTrong(lbl_TenKH_1.getText());
			dialog_DatThemPhongTrong.setVisible(true);
		}
		//chọn nút checkbox mặc định giờ
		if(checkbox_GioTuMacDinh.isSelected()) {
		    checkbox_GioTuDo.setEnabled(false);
		}
		else {
		    checkbox_GioTuDo.setEnabled(true);
		}
		//chọn nút checkbox giờ tự do
		if(checkbox_GioTuDo.isSelected()) {
			dateTimePicker.setEnabled(false);
			checkbox_GioTuMacDinh.setEnabled(false);
		}
		else {
			checkbox_GioTuMacDinh.setEnabled(true);
			dateTimePicker.setEnabled(true);
		}
		//kiem tra khach hang
		if (o.equals(btn_KiemTraSDT)) {
			khachHang_dao = new KhachHang_dao();
			String sdt = txtSDT.getText();
			KhachHang khachHang = khachHang_dao.TimkiemSDT_KHachHang(sdt);
			if(khachHang != null){
				JOptionPane.showMessageDialog(this, "Khách hàng đã có trong hệ thống!");
				String hoTen = khachHang.getHoTen();
				boolean gioiTinh = khachHang.isGioiTinh();
				String gioiTinhStr = gioiTinh ? "Nam" : "Nữ";
				lbl_GioiTinh_1.setText(gioiTinhStr);
				lbl_TenKH_1.setText(hoTen);
			}
			else {
				JOptionPane.showConfirmDialog(this, "Khách hàng chưa có trên hệ thống! Bạn có muốn thêm khách hàng không?");
			}
		}

		
		
		
		}
	}
