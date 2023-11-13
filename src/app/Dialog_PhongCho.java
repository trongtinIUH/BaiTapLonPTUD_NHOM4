package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import dao.KhachHang_dao;
import dao.LoaiPhong_dao;
import dao.PhieuDatPhong_dao;
import dao.Phong_dao;
import entity.Enum_TrangThai;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.PhieuDatPhong;
import entity.Phong;

public class Dialog_PhongCho extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPhong,lblGia,lblTrangThai, lblThoiGianHat, lblSoNguoi, lblLoai,lblLoai_1,lblPhong_1,lblgia_1;
	private JButton btnNhanPhong,btn_HuyPhong;
	
	private Phong_dao p_dao = new Phong_dao();
	private LoaiPhong_dao lp_dao = new LoaiPhong_dao();
	private PhieuDatPhong_dao pdp_dao = new PhieuDatPhong_dao();
	private KhachHang_dao kh_dao=new KhachHang_dao();
	private Phong p;
	private LoaiPhong lp;
	private PhieuDatPhong pdp ;
	private KhachHang kh;
	
	private JLabel lblThoiGianHat_1;
	
	private LocalDateTime now;
	private DateTimePicker dateTimePicker;
	private TimePickerSettings timeSettings;
	private DatePickerSettings dateSettings;
	private DatePickerSettings dateSettings_1;
	private LocalDateTime now1;
	private TimePickerSettings timeSettings_1;
	private DateTimePicker dateTimePicker_1;
	private JLabel lbl_KhachHang;
	private JLabel lbl_KhachHang_1;
	private JLabel lbl_SoNguoi_1;
	

	private LocalDateTime ngayGioDatPhong;
	private LocalDateTime ngayGioNhanPhong;
	
	private int songuoihat;
	private double dongia;
	private String donGiaFormatted,hotenKH;
	
	
	public Dialog_PhongCho(String maPhong) {
		//kích thước giao diện
		getContentPane().setBackground(Color.WHITE);
		setSize(400, 465);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		laydulieu(maPhong);
		
		
		//các lbl góc trái-----------------------------------------------------------------------
		lblPhong = new JLabel("Phòng:");
		lblPhong.setBounds(5, 10, 100, 30);
		lblPhong.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblPhong);
		
		lblLoai = new JLabel("Loại:");
		lblLoai.setBounds(5, 50, 100, 30);
		lblLoai.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblLoai);
		
		lblSoNguoi = new JLabel("Số người:");
		lblSoNguoi.setBounds(5, 90, 100, 30);
		lblSoNguoi.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblSoNguoi);
		
		lblThoiGianHat = new JLabel("Ngày đặt phòng:");
		lblThoiGianHat.setBounds(5, 130, 134, 30);
		lblThoiGianHat.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(lblThoiGianHat);
		
		lblGia = new JLabel("Giá phòng:");
		lblGia.setBounds(5, 210, 100, 30);
		lblGia.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblGia);
		
		//các lbl góc phải---------------------------------------------------------------------
		lblPhong_1 = new JLabel();
		lblPhong_1.setText(maPhong);
		lblPhong_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhong_1.setBounds(150, 10, 150, 30);
		getContentPane().add(lblPhong_1);

		
		lblLoai_1 = new JLabel();
		lblLoai_1.setText(lp.getTenLoaiPhong());
		lblLoai_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblLoai_1.setBounds(150, 50, 150, 30);
		getContentPane().add(lblLoai_1);
		
		lblgia_1 = new JLabel();
		lblgia_1.setText(donGiaFormatted);
		lblgia_1.setBackground(Color.WHITE);
		lblgia_1.setForeground(Color.RED);
		lblgia_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblgia_1.setBounds(150, 210, 140, 30);
		getContentPane().add(lblgia_1);
		
		//nút button---------------------------------------------------------------------------
		btnNhanPhong = new JButton("Nhận Phòng");
		btnNhanPhong.setBounds(40, 335, 300, 40);
		btnNhanPhong.setForeground(Color.WHITE);
		btnNhanPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btnNhanPhong.setBackground(new Color(33,167,38,255));
		btnNhanPhong.setBorder(new RoundedBorder(60));
//		btnThemDV.setBorderPainted(false);
		getContentPane().add(btnNhanPhong);
		
		btn_HuyPhong = new JButton("Hủy Phòng");
		btn_HuyPhong.setBounds(40, 380, 300, 40);
		btn_HuyPhong.setForeground(Color.WHITE);
		btn_HuyPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_HuyPhong.setBackground(new Color(26,147,216,255));
	  //btnChuyenPhong.setBorderPainted(false);
		btn_HuyPhong.setBorder(new RoundedBorder(60));
		getContentPane().add(btn_HuyPhong);
		
		lbl_SoNguoi_1 = new JLabel();
		lbl_SoNguoi_1.setText(String.valueOf(songuoihat));
		lbl_SoNguoi_1.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_SoNguoi_1.setBounds(150, 90, 120, 30);
		getContentPane().add(lbl_SoNguoi_1);
		
		lblThoiGianHat_1 = new JLabel("Ngày nhận phòng:");
		lblThoiGianHat_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblThoiGianHat_1.setBounds(5, 170, 143, 30);
		getContentPane().add(lblThoiGianHat_1);
		
		// hiển thị thời gian đặt phòng chờ
		now = LocalDateTime.now();

	    dateSettings = new DatePickerSettings();
        dateSettings.setLocale(new Locale("vi","VN")); // Set the locale to English
        dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd"); // Set the date format

        timeSettings = new TimePickerSettings();
        timeSettings.setDisplaySpinnerButtons(true);

        dateTimePicker = new DateTimePicker(dateSettings, timeSettings);
        dateTimePicker.setDateTimePermissive(ngayGioDatPhong);
        dateTimePicker.getTimePicker().getComponentSpinnerPanel().setBounds(80, 0, 0, 25);
        dateTimePicker.getTimePicker().getComponentToggleTimeMenuButton().setBounds(65, 0, 30, 30);
        dateTimePicker.getTimePicker().getComponentTimeTextField().setBounds(0, 0, 64, 30);
        dateTimePicker.getDatePicker().getComponentToggleCalendarButton().setBounds(103, 0, 30, 30);
        dateTimePicker.getDatePicker().getComponentDateTextField().setBounds(0, 0, 104, 30);
        dateTimePicker.setSize(230, 30);
        dateTimePicker.setLocation(150, 130);
        dateTimePicker.getDatePicker().getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 12));
        dateTimePicker.getTimePicker().getComponentTimeTextField().setFont(new Font("Tahoma", Font.PLAIN, 12));
        dateTimePicker.getTimePicker().getComponentToggleTimeMenuButton().setFont(new Font("Tahoma", Font.BOLD, 12));
        dateTimePicker.getDatePicker().getComponentToggleCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 12));
        dateTimePicker.timePicker.setBounds(148, 0, 86, 30);
        dateTimePicker.datePicker.setBounds(0, 0, 143, 30);
        dateTimePicker.getTimePicker().setBounds(135, 0, 99, 30);
        dateTimePicker.getTimePicker().setLayout(null);
        dateTimePicker.getDatePicker().setBounds(0, 0, 134, 30);
        dateTimePicker.getDatePicker().setLayout(null);
        getContentPane().add(dateTimePicker);
        dateTimePicker.setLayout(null);
		// hiển thị thời gian nhận phòng chờ
		now1 = LocalDateTime.now();

	    dateSettings_1 = new DatePickerSettings();
	    dateSettings_1.setLocale(new Locale("vi","VN")); // Set the locale to English
	    dateSettings_1.setFormatForDatesCommonEra("yyyy-MM-dd"); // Set the date format
        timeSettings_1 = new TimePickerSettings();
        timeSettings_1.setDisplaySpinnerButtons(true);

        dateTimePicker_1 = new DateTimePicker(dateSettings_1, timeSettings_1);
        dateTimePicker_1.setDateTimePermissive(ngayGioNhanPhong);
        dateTimePicker_1.getTimePicker().getComponentSpinnerPanel().setBounds(80, 0, 0, 25);
        dateTimePicker_1.getTimePicker().getComponentToggleTimeMenuButton().setBounds(65, 0, 30, 30);
        dateTimePicker_1.getTimePicker().getComponentTimeTextField().setBounds(0, 0, 64, 30);
        dateTimePicker_1.getDatePicker().getComponentToggleCalendarButton().setBounds(103, 0, 30, 30);
        dateTimePicker_1.getDatePicker().getComponentDateTextField().setBounds(0, 0, 104, 30);
        dateTimePicker_1.setSize(230, 30);
        dateTimePicker_1.setLocation(150, 170);
        dateTimePicker_1.getDatePicker().getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 12));
        dateTimePicker_1.getTimePicker().getComponentTimeTextField().setFont(new Font("Tahoma", Font.PLAIN, 12));
        dateTimePicker_1.getTimePicker().getComponentToggleTimeMenuButton().setFont(new Font("Tahoma", Font.BOLD, 12));
        dateTimePicker_1.getDatePicker().getComponentToggleCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 12));
        dateTimePicker_1.timePicker.setBounds(148, 0, 86, 30);
        dateTimePicker_1.datePicker.setBounds(0, 0, 143, 30);
        dateTimePicker_1.getTimePicker().setBounds(135, 0, 99, 30);
        dateTimePicker_1.getTimePicker().setLayout(null);
        dateTimePicker_1.getDatePicker().setBounds(0, 0, 134, 30);
        dateTimePicker_1.getDatePicker().setLayout(null);
       
  
        getContentPane().add(dateTimePicker_1);
        dateTimePicker_1.setLayout(null);
        
        lbl_KhachHang = new JLabel("Khách hàng:");
        lbl_KhachHang.setFont(new Font("Arial", Font.BOLD, 18));
        lbl_KhachHang.setBounds(5, 250, 110, 30);
        getContentPane().add(lbl_KhachHang);
        
        lbl_KhachHang_1 = new JLabel();
        lbl_KhachHang_1.setText(hotenKH);
        lbl_KhachHang_1.setFont(new Font("Arial", Font.BOLD, 15));
        lbl_KhachHang_1.setBounds(150, 250, 150, 30);
        getContentPane().add(lbl_KhachHang_1);
        
		// thêm sự kiện  button
		btn_HuyPhong.addActionListener(this);
		btnNhanPhong.addActionListener(this);
		
	
	}



	

public void laydulieu(String maPhong) {
	pdp = pdp_dao.getPhieuDatPhongTheoMa(maPhong);
	p = p_dao.getPhongTheoMaPhong(maPhong);
	lp = lp_dao.getLoaiPhongTheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());
	kh=kh_dao.getKhachHangTheoMaKH(pdp.getKhachHang().getMaKhachHang());

	if (pdp != null) {
	    // Thực hiện các thao tác trên pdp
	     songuoihat = pdp.getSoNguoiHat();
	     dongia = lp.getDonGiaTheoGio();
	  // Định dạng đơn giá theo định dạng tiền tệ Việt Nam
	     NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	     donGiaFormatted = currencyFormat.format(dongia);
	     
	    ngayGioDatPhong =  pdp.getNgayGioDatPhong();
	    ngayGioNhanPhong = pdp.getNgayGioNhanPhong();
	      
	      hotenKH=kh.getHoTen();
	    
	    // ...
	} else {
	    // Xử lý trường hợp không tìm thấy phiếu đặt phòng
		JOptionPane.showMessageDialog(this, "không tìm thấy mã");
	}
}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnNhanPhong)) {
			// nhận phòng chuyển qua 
		}
		
		else if(o.equals(btn_HuyPhong)) {
			int tb = JOptionPane.showConfirmDialog(null, "Bạn có muốn Hủy Phòng chờ?", "Hủy phòng chờ", JOptionPane.YES_NO_OPTION);
			if (tb == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(this, "Phòng hủy thành công!");
				pdp_dao.xoaPhieuDatPhongTheoMa(lblPhong_1.getText());
				DataManager.setDatPhongCho(true);
				Enum_TrangThai trangThai = Enum_TrangThai.Trống;
				Phong phong = new Phong(lblPhong_1.getText(), trangThai);
				p_dao.updatePhong(phong, lblPhong_1.getText());
				setVisible(false);	
				
				
		        Window[] windows = Window.getWindows();
		        for (Window window : windows) {
		            if (window instanceof JDialog) {
		                window.dispose();
		            }
		        }
			}
			
		}

		
	}
}
