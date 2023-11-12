package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import dao.KhachHang_dao;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.Phong;

public class Dialog_DatPhongCho extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtSDT;
	private JButton btn_KiemTraSDT, btn_QuayLai, btn_DatPhong;
	private JPanel panel_1, panel_2;
	private JCheckBox checkBox_KH;
	private JLabel lbl_GioiTinh_1, lbl_GiaTien_1, lbl_TenKH_1, lbl_sdtKH,lbl_GioiTinh;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtSoNguoi;
	private String col[] = { "Mã Phòng", "Loại Phòng", "Số Người", "Đơn Giá", "Trạng Thái" };
	private JLabel lbl_TenKH;
	private LocalDateTime now;
	private DateTimePicker dateTimePicker;
	private TimePickerSettings timeSettings;
	private DatePickerSettings dateSettings;
	
	private KhachHang_dao khachHang_dao;

	private JLabel lbl_Phong;
	private LocalDateTime now1;
	private DatePickerSettings dateSettings_1;
	private TimePickerSettings timeSettings_1;
	private DateTimePicker dateTimePicker_1;
	private JLabel lbl_TrangThai;
	private JLabel lbl_Loai;
	private JLabel lbl_LoaiKhachHang;
	private JLabel lblTieuDe;
	private JLabel lbl_GiaTien;
	private JLabel lbl_SoNguoi;
	private JLabel lbl_TrangThai_1;
	private JLabel lbl_loai_1;
	private JLabel lbl_NgayDatPhong;
	private JLabel lbl_NgayNhanPhong;
	public Dialog_DatPhongCho(String maPhong, Phong p, LoaiPhong lp) {
		// màn
		// hình******************************************************************************
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setSize(800, 400);
		setLocationRelativeTo(null);

		// panel chứa tiêu đề--------------------------------------
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 35);
		panel.setBackground(new Color(181, 230, 251));
		getContentPane().add(panel);
		panel.setLayout(null);

		lblTieuDe = new JLabel("Đặt Phòng Chờ");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 784, 35);
		panel.add(lblTieuDe);

		// pane; chứa các phần còn lại---------------------------------
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 35, 784, 426);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lbl_TrangThai = new JLabel("Trạng thái:");
		lbl_TrangThai.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TrangThai.setBounds(10, 5, 100, 25);
		panel_1.add(lbl_TrangThai);

		lbl_Loai = new JLabel("Loại:");
		lbl_Loai.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_Loai.setBounds(10, 40, 60, 25);
		panel_1.add(lbl_Loai);

		lbl_LoaiKhachHang = new JLabel("Khách hàng mặc định:");
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
		panel_2.setBounds(10, 100, 760, 40);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		lbl_sdtKH = new JLabel("SDT khách:");
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
		lbl_TenKH.setBounds(10, 150, 135, 30);
		panel_1.add(lbl_TenKH);

		lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioiTinh.setBounds(450, 150, 77, 30);
		panel_1.add(lbl_GioiTinh);

		lbl_GioiTinh_1 = new JLabel("Nam");
		lbl_GioiTinh_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioiTinh_1.setBounds(550, 150, 100, 30);
		panel_1.add(lbl_GioiTinh_1);

		lbl_GiaTien = new JLabel("Giá tiền:");
		lbl_GiaTien.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GiaTien.setBounds(440, 40, 80, 25);
		panel_1.add(lbl_GiaTien);

		lbl_SoNguoi = new JLabel("Số người:");
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
		lbl_TenKH_1.setBounds(165, 150, 180, 30);
		panel_1.add(lbl_TenKH_1);

		// các nút
		// jbutton-------------------------------------------------------------------
		btn_DatPhong = new JButton("Đặt Phòng");
		btn_DatPhong.setBackground(Color.GREEN);
		btn_DatPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_DatPhong.setBackground(new Color(33, 167, 38, 255));
		btn_DatPhong.setBounds(10, 280, 160, 40);
		panel_1.add(btn_DatPhong);

		btn_QuayLai = new JButton("Quay Lại");
		btn_QuayLai.setFont(new Font("Arial", Font.BOLD, 18));
		btn_QuayLai.setBackground(new Color(255, 83, 83, 255));
		btn_QuayLai.setBounds(605, 280, 170, 40);
		panel_1.add(btn_QuayLai);

		btn_KiemTraSDT = new JButton("Kiểm Tra");
		btn_KiemTraSDT.setBackground(UIManager.getColor("Button.background"));
		btn_KiemTraSDT.setFont(new Font("Arial", Font.BOLD, 17));
		btn_KiemTraSDT.setBounds(480, 5, 200, 30);
		panel_2.add(btn_KiemTraSDT);

		lbl_TrangThai_1 = new JLabel(p.getTrangThai() + "");
		lbl_TrangThai_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TrangThai_1.setBounds(140, 5, 250, 25);
		panel_1.add(lbl_TrangThai_1);

		lbl_loai_1 = new JLabel(lp.getTenLoaiPhong());
		lbl_loai_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_loai_1.setBounds(140, 40, 200, 25);
		panel_1.add(lbl_loai_1);

		
		lbl_NgayDatPhong = new JLabel("Ngày đặt  phòng:");
		lbl_NgayDatPhong.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_NgayDatPhong.setBounds(10, 190, 135, 25);
		panel_1.add(lbl_NgayDatPhong);
		
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
	        dateTimePicker.setBounds(200, 190, 260, 25);
		panel_1.add(dateTimePicker);
		dateTimePicker.setLayout(null);
		
		lbl_NgayNhanPhong = new JLabel("Ngày nhận phòng:");
		lbl_NgayNhanPhong.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_NgayNhanPhong.setBounds(10, 230, 180, 25);
		panel_1.add(lbl_NgayNhanPhong);
		
		lbl_Phong = new JLabel("Phòng " + maPhong);
		lbl_Phong.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_Phong.setForeground(Color.BLACK);
		lbl_Phong.setBounds(440, 70, 210, 25);
		panel_1.add(lbl_Phong);
		
		now1 = LocalDateTime.now();

	    dateSettings_1 = new DatePickerSettings();
	    dateSettings_1.setLocale(new Locale("vi","VN")); // Set the locale to English
	    dateSettings_1.setFormatForDatesCommonEra("yyyy-MM-dd"); // Set the date format

        timeSettings_1 = new TimePickerSettings();
        timeSettings_1.setDisplaySpinnerButtons(true);

        dateTimePicker_1 = new DateTimePicker(dateSettings_1, timeSettings_1);
        dateTimePicker_1.getDatePicker().getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 12));
        dateTimePicker_1.getTimePicker().getComponentTimeTextField().setFont(new Font("Tahoma", Font.PLAIN, 12));
        dateTimePicker_1.getTimePicker().getComponentSpinnerPanel().setBounds(80, 0, 0, 25);
        dateTimePicker_1.getTimePicker().getComponentToggleTimeMenuButton().setBounds(75, 0, 26, 25);
        dateTimePicker_1.getTimePicker().getComponentTimeTextField().setBounds(0, 0, 70, 25);
        dateTimePicker_1.getTimePicker().getComponentToggleTimeMenuButton().setFont(new Font("Tahoma", Font.BOLD, 12));
        dateTimePicker_1.getDatePicker().getComponentToggleCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 12));
        dateTimePicker_1.timePicker.setBounds(141, 0, 80, 25);
        dateTimePicker_1.datePicker.setBounds(0, 0, 136, 25);
        dateTimePicker_1.getTimePicker().setBounds(150, 0, 110, 25);
        dateTimePicker_1.getTimePicker().setLayout(null);
        dateTimePicker_1.getDatePicker().setBounds(0, 0, 136, 25);
        dateTimePicker_1.setDateTimePermissive(now1);
        dateTimePicker_1.setBounds(200, 230, 260, 25);
    	panel_1.add(dateTimePicker_1);
    	dateTimePicker_1.setLayout(null);
	
		
		
		// thêm sự kiện button
		btn_DatPhong.addActionListener(this);
		btn_KiemTraSDT.addActionListener(this);
		btn_QuayLai.addActionListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btn_QuayLai)) {
			setVisible(false);
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
