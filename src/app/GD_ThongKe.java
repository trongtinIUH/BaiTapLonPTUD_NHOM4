package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import dao.ChiTietDichVu_dao;
import dao.ChiTietHoaDon_dao;
import dao.HoaDonDatPhong_dao;
import dao.KhachHang_dao;
import dao.KhuyenMai_dao;
import dao.Phong_dao;
import dao.ThongKe_dao;
import entity.CurveLineChart;
import entity.DoanhThuLoaiPhong;
import entity.HoaDonDatPhong;
import entity.ModelChart;
import entity.ModelPieChart;
import entity.ModelThongKe;
import entity.PieChart;

public class GD_ThongKe extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String col[] = {"STT", "Mã hóa đơn","Ngày lập hóa đơn", "Tên khách hàng", 
			"Số điện thoại", "Khuyến mãi", "Tổng tiền", "Tên nhân viên"};
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	JLabel lblTitle, lblThongKe, lblLoaihinhTK, lblDate, lblTongDoanhThu, lblChartTitle,
	lblTongHoaDon, lblDoanhThuPhongThuong, lblDoanhThuPhongVIP, lblTongSoGioHat, lblDoanhThuDichVu, lblYearStart, lblYearEnd;
	JComboBox<String> cbThongKe, cbDate, cbYearStart, cbYearEnd, cbYear, cbMonth;
	JButton btnThongKe, btnLamMoi, btnInTK, btnProfile;
	private HoaDonDatPhong_dao hoadon_dao;
	private KhachHang_dao khachhang_dao;
	private Phong_dao phong_dao;
	private ChiTietDichVu_dao chitietdichvu_dao;
	private ChiTietHoaDon_dao chitiethoadon_dao;
	private KhuyenMai_dao khuyenmai_dao;
	private JPanel pnTable, pnContent, pnPieChart, pnCurveLineChart;
	private DecimalFormat df;
	private PieChart pieChart;
	private CurveLineChart lineChart;
	private ThongKe_dao thongke_dao;
	private Dialog_User dialog_user;

	private LocalDateTime now;
	private DateTimePicker dateTimePicker;
	private TimePickerSettings timeSettings;
	private DatePickerSettings dateSettings;
	public GD_ThongKe() {
		dialog_user = new Dialog_User();
		df = new DecimalFormat("#,###,### VNĐ");
		setLayout(null);
		setBackground(Color.decode("#FAFAFF"));
		hoadon_dao = new HoaDonDatPhong_dao();
		khachhang_dao = new KhachHang_dao();
		phong_dao = new Phong_dao();
		chitietdichvu_dao = new ChiTietDichVu_dao();
		khuyenmai_dao = new KhuyenMai_dao();
		chitiethoadon_dao = new ChiTietHoaDon_dao();
		thongke_dao = new ThongKe_dao();
		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(Color.decode("#B5E6FB"));
		pnNorth.setBounds(0, 0, 1080, 60);
		pnNorth.setLayout(null);
		lblTitle = new JLabel("Thống kê");
		lblTitle.setBounds(501, 15, 200, 30);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		pnNorth.add(lblTitle);
		btnProfile = new JButton();
		btnProfile.setBackground(Color.decode("#B5E6FB"));
		btnProfile.setBorderPainted(false);
		btnProfile.setIcon(new ImageIcon("icon\\icon_profile.png"));
		btnProfile.setBounds(1020, 7, 45, 45);
		ImageIcon iconProfile = new ImageIcon("icon\\icon_profile.png");
		iconProfile = new ImageIcon(iconProfile.getImage().getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH));
		btnProfile.setIcon(iconProfile);
		pnNorth.add(btnProfile);
		JPanel pnMenu = new JPanel();
		pnMenu.setLayout(null);
		pnMenu.setBounds(0, 60, 1080, 122);
		pnMenu.setBackground(Color.white);
		pnMenu.add(lblThongKe = new JLabel("Thống kê"));
		lblThongKe.setFont(new Font("Arial", Font.BOLD, 18));
		lblThongKe.setBounds(15, 25, 187, 24);
		pnMenu.add(cbThongKe = new JComboBox<String>());
		cbThongKe.addItem("Doanh thu");
		cbThongKe.addItem("Khách hàng");
		cbThongKe.setFont(new Font("Arial", Font.PLAIN, 18));
		cbThongKe.setBounds(222, 25, 187, 24);
		pnMenu.add(lblLoaihinhTK = new JLabel("Loại hình thống kê"));
		lblLoaihinhTK.setFont(new Font("Arial", Font.BOLD, 18));
		lblLoaihinhTK.setBounds(15, 85, 187, 24);
		pnMenu.add(cbDate = new JComboBox<String>());
		cbDate.addItem("Ngày");
		cbDate.addItem("Tháng");
		cbDate.addItem("Năm");
		cbDate.setFont(new Font("Arial", Font.PLAIN, 18));
		cbDate.setBounds(222, 85, 187, 24);
		
		pnMenu.add(lblYearStart = new JLabel("Năm bắt đầu"));
		lblYearStart.setFont(new Font("Arial", Font.BOLD, 18));
		lblYearStart.setBounds(430, 25, 120, 24);
		pnMenu.add(cbYearStart = new JComboBox<String>());
		cbYearStart.setFont(new Font("Arial", Font.PLAIN, 18));
		cbYearStart.setEnabled(false);
		cbYearStart.setBounds(560, 25, 80, 24);
		
		pnMenu.add(lblYearEnd = new JLabel("Năm kết thúc"));
		lblYearEnd.setFont(new Font("Arial", Font.BOLD, 18));
		lblYearEnd.setBounds(430, 85, 120, 24);
		pnMenu.add(cbYearEnd = new JComboBox<String>());
		cbYearEnd.setFont(new Font("Arial", Font.PLAIN, 18));
		cbYearEnd.setBounds(560, 85, 80, 24);
		cbYearEnd.setEnabled(false);
		pnMenu.add(btnThongKe = new JButton("Thống kê"));
		btnThongKe.setBounds(680, 15, 184, 42);
		btnThongKe.setBackground(Color.decode("#0D99FF"));
		btnThongKe.setForeground(Color.white);
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 18));
		btnThongKe.setIcon(new ImageIcon("icon\\ThongKe_icon.png"));
		btnThongKe.setBorder(new RoundedBorder(5));
		btnThongKe.setHorizontalTextPosition(SwingConstants.RIGHT); 
		btnThongKe.setIconTextGap(18);
		pnMenu.add(btnLamMoi = new JButton("Làm mới"));
		btnLamMoi.setBounds(880, 15, 184, 42);
		btnLamMoi.setBackground(Color.decode("#32BF26"));
		btnLamMoi.setForeground(Color.white);
		btnLamMoi.setFont(new Font("Arial", Font.BOLD, 18));
		btnLamMoi.setIcon(new ImageIcon("icon\\Refresh_icon.png"));
		btnLamMoi.setHorizontalTextPosition(SwingConstants.RIGHT); 
		btnLamMoi.setBorder(new RoundedBorder(5));
		btnLamMoi.setIconTextGap(18);
		pnMenu.add(btnInTK = new JButton("In báo cáo thống kê"));
		btnInTK.setBounds(680, 70, 383, 42);
		btnInTK.setBackground(Color.decode("#FFB400"));
		btnInTK.setForeground(Color.white);
		btnInTK.setFont(new Font("Arial", Font.BOLD, 18));
		btnInTK.setIcon(new ImageIcon("icon\\Print_icon.png"));
		btnInTK.setHorizontalTextPosition(SwingConstants.RIGHT); 
		btnInTK.setBorder(new RoundedBorder(5));
		btnInTK.setIconTextGap(18);
		add(pnMenu);
		pnContent = new JPanel();
		pnContent.setLayout(null);
		pnContent.setBounds(0, 192, 400, 535);
		pnContent.setBackground(Color.white);
		pnContent.add(lblDate = new JLabel("Chọn ngày"));
		lblDate.setFont(new Font("Arial", Font.BOLD, 18));
		lblDate.setBounds(15, 20, 120, 34);
		
		now = LocalDateTime.now();

        dateSettings = new DatePickerSettings();
        dateSettings.setLocale(new Locale("vi","VN")); // Set the locale to English
        dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd"); // Set the date format

        timeSettings = new TimePickerSettings();
        timeSettings.setDisplaySpinnerButtons(true);

	    dateTimePicker = new DateTimePicker(dateSettings, timeSettings);
	    dateTimePicker.getTimePicker().setVisible(false);
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
	    dateTimePicker.getTimePicker().setBackground(Color.white);
	    dateTimePicker.getDatePicker().setBounds(0, 0, 136, 25);
	    dateTimePicker.setDateTimePermissive(now);
	    dateTimePicker.setBackground(Color.white);
	    dateTimePicker.setBackground(Color.white);

	    // Add the DateTimePicker to your user interface, e.g. to a JPanel
	    // panel.add(dateTimePicker);
	    dateTimePicker.setBounds(208, 20, 164, 34);
	    pnContent.add(dateTimePicker);
	    
	    cbMonth = new JComboBox<String>();
	    cbMonth.setFont(new Font("Arial", Font.PLAIN, 18));
	    cbMonth.setVisible(false);
	    cbMonth.setBounds(208, 20, 80, 34);
	    pnContent.add(cbMonth);
	    
	    cbYear = new JComboBox<String>();
	    cbYear.setFont(new Font("Arial", Font.PLAIN, 18));
	    cbYear.setVisible(false);
	    cbYear.setBounds(308, 20, 84, 34);
	    pnContent.add(cbYear);
		
		JPanel pnLine = new JPanel();
		pnLine.setBounds(0, 71, 400, 2);
		pnLine.setBackground(Color.decode("#CCCCCC"));
		pnContent.add(pnLine);
		JLabel lblTotalRevenue = new JLabel("Tổng doanh thu:");
		JLabel lblTotalOrder = new JLabel("Tổng hóa đơn:");
		JLabel lblNormalRomRevenue = new JLabel("Doanh thu phòng thường:");
		JLabel lblVIPRomRevenue = new JLabel("Doanh thu phòng VIP:");
		JLabel lblTotalServiceRevenue = new JLabel("Doanh thu dịch vụ:");
		JLabel lblTotalHour = new JLabel("Tổng số giờ hát:");
		pnContent.add(lblTotalRevenue);
		lblTotalRevenue.setFont(new Font("Arial", Font.BOLD, 18));
		lblTotalRevenue.setBounds(15, 113, 210, 34);
		pnContent.add(lblTongDoanhThu = new JLabel("0 VNĐ"));
		lblTongDoanhThu.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTongDoanhThu.setBounds(260, 113, 210, 34);
		pnContent.add(lblTotalOrder);
		lblTotalOrder.setFont(new Font("Arial", Font.BOLD, 18));
		lblTotalOrder.setBounds(15, 189, 210, 34);
		pnContent.add(lblTongHoaDon = new JLabel("0"));
		lblTongHoaDon.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTongHoaDon.setBounds(260, 189, 210, 34);
		pnContent.add(lblNormalRomRevenue);
		lblNormalRomRevenue.setFont(new Font("Arial", Font.BOLD, 18));
		lblNormalRomRevenue.setBounds(15, 265, 240, 34);
		pnContent.add(lblDoanhThuPhongThuong = new JLabel("0 VNĐ"));
		lblDoanhThuPhongThuong.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDoanhThuPhongThuong.setBounds(260, 265, 210, 34);
		pnContent.add(lblVIPRomRevenue);
		lblVIPRomRevenue.setFont(new Font("Arial", Font.BOLD, 18));
		lblVIPRomRevenue.setBounds(15, 341, 240, 34);
		pnContent.add(lblDoanhThuPhongVIP = new JLabel("0 VNĐ"));
		lblDoanhThuPhongVIP.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDoanhThuPhongVIP.setBounds(260, 341, 210, 34);
		pnContent.add(lblTotalServiceRevenue);
		lblTotalServiceRevenue.setFont(new Font("Arial", Font.BOLD, 18));
		lblTotalServiceRevenue.setBounds(15, 417, 240, 34);
		pnContent.add(lblDoanhThuDichVu = new JLabel("0 VNĐ"));
		lblDoanhThuDichVu.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDoanhThuDichVu.setBounds(260, 417, 210, 34);
		pnContent.add(lblTotalHour);
		lblTotalHour.setFont(new Font("Arial", Font.BOLD, 18));
		lblTotalHour.setBounds(15, 493, 240, 34);
		pnContent.add(lblTongSoGioHat = new JLabel("0"));
		lblTongSoGioHat.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTongSoGioHat.setBounds(260, 493, 210, 34);
		pnTable = new JPanel();
		pnTable.setLayout(null);
		pnTable.setBounds(400, 192, 670, 535);
		model = new DefaultTableModel(col,0);
		table = new JTable(model);
		table.setSelectionBackground(Color.pink);
		table.getTableHeader().setBackground(new Color(238, 233, 233));
		table.getColumnModel().getColumn(0).setMaxWidth(40);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		table.getColumnModel().getColumn(3).setMaxWidth(100);
		table.getColumnModel().getColumn(4).setMaxWidth(80);
		table.getColumnModel().getColumn(5).setMaxWidth(70);
		table.getColumnModel().getColumn(6).setMaxWidth(80);
		table.getColumnModel().getColumn(7).setMaxWidth(100);
		scroll = new JScrollPane(table);
		scroll.setBounds(0,0,670,535);
		pnTable.add(scroll);
		add(pnTable);
		
		pnPieChart = new JPanel();
		pnPieChart.setLayout(null);
		pnPieChart.setBounds(400, 192, 670, 535);
		pnPieChart.add(lblChartTitle = new JLabel("BIỂU ĐỒ THỐNG KÊ DOANH THU THEO THÁNG"));
		lblChartTitle.setForeground(Color.blue);
		lblChartTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblChartTitle.setBounds(20, 0, 600, 34);
		pnPieChart.add(pieChart = new PieChart());
		pieChart.setBounds(100, 20, 500, 500);
		pieChart.setChartType(PieChart.PeiChartType.DEFAULT);
		pnPieChart.setVisible(false);
		add(pnPieChart);
		add(pnContent);
		pnCurveLineChart = new JPanel();
		pnCurveLineChart.setLayout(null);
		pnCurveLineChart.setBounds(0, 182, 1080, 548);
		pnCurveLineChart.add(lineChart = new CurveLineChart());
		lineChart.setBounds(0, 0, 1050, 535);
		lineChart.addLegend("Tổng doanh thu", Color.decode("#7b4397"), Color.decode("#dc2430"));
		lineChart.addLegend("Doanh thu phòng", Color.decode("#e65c00"), Color.decode("#F9D423"));
		lineChart.addLegend("Doanh thu dịch vụ", Color.decode("#0099F7"), Color.decode("#F11712"));
		pnCurveLineChart.setVisible(false);
		add(pnCurveLineChart);
		add(pnNorth);
		
		dateTimePicker.addDateTimeChangeListener(event -> {
		    clearDataDoanhThuTheoNgay();
		    loadDataDoanhThuTheoNgay(); 
		    try {
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // adjust this pattern to match your SQL Server date/time format
		        String formattedDateTime = dateTimePicker.getDateTimeStrict().format(formatter);

		        DoanhThuLoaiPhong dtlp = phong_dao.tinhTongDoanhThuLoaiPhongTheoNgay(formattedDateTime);
		        if(dtlp != null) {
		            lblDoanhThuPhongThuong.setText(df.format(dtlp.getDoanhThuPhongThuong()));
		            lblDoanhThuPhongVIP.setText(df.format(dtlp.getDoanhThuPhongVIP()));
		        }
		        lblTongSoGioHat.setText(chitiethoadon_dao.tinhSoGioHatTheoNgay(formattedDateTime)+"");
		    } catch (Exception e2) {
		        e2.printStackTrace();
		    }
		    if(model.getRowCount() <= 0) {
		    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		        String formattedDateTime = dateTimePicker.getDateTimeStrict().format(formatter);
		    	JOptionPane.showMessageDialog(this, "Không có dữ liệu thống kê của ngày: " + formattedDateTime);
		    }
		});
		btnThongKe.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnInTK.addActionListener(this);
		btnProfile.addActionListener(this);
		updateYearCbo();
		updateMonthYearCbo();
	}
	
	public void setCurveLineChartData() {
		String yearStart = cbYearStart.getSelectedItem().toString();
		String yearEnd = cbYearEnd.getSelectedItem().toString();
		for (ModelThongKe tk: thongke_dao.thongKeTheoNam(yearStart, yearEnd)) {
			lineChart.addData(new ModelChart(tk.getYear(), new double[]{tk.getTongDoanhThu(), tk.getDoanhThuPhong(), tk.getDoanhThuDichVu()}));
			
		}
		lineChart.start();
	}
	
	public void loadDataDoanhThuTheoNgay() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // adjust this pattern to match your SQL Server date/time format
		String formattedDateTime = dateTimePicker.getDateTimeStrict().format(formatter);
		double tongDoanhThu = 0;
		double doanhThuDV = 0;
		int i = 0;
		for (HoaDonDatPhong hd : hoadon_dao.getHoaDonTheoNgayLapHD(formattedDateTime)) {
			i++;
			tongDoanhThu += hd.tinhTongTienThanhToan(phong_dao.tinhTongTienPhongTheoMaHoaDon(hd.getMaHoaDon()), 
					chitietdichvu_dao.tinhTongTienDVTheoMaHoaDon(hd.getMaHoaDon()), 
					khuyenmai_dao.getPhanTramKhuyenMaiTheoMaKM(hd.getKhuyenMai().getMaKhuyenMai()));
			doanhThuDV += chitietdichvu_dao.tinhTongTienDVTheoMaHoaDon(hd.getMaHoaDon());
			Object[] row = { i, hd.getMaHoaDon(), 
			hd.getNgayLapHoaDon(),
			khachhang_dao.getKhachHangTheoMaKH(hd.getKhachHang().getMaKhachHang()).getHoTen(), 
			khachhang_dao.getKhachHangTheoMaKH(hd.getKhachHang().getMaKhachHang()).getSoDienThoai(),
			khuyenmai_dao.getPhanTramKhuyenMaiTheoMaKM(hd.getKhuyenMai().getMaKhuyenMai()),
			df.format(hd.tinhTongTienThanhToan(phong_dao.tinhTongTienPhongTheoMaHoaDon(hd.getMaHoaDon()), 
			chitietdichvu_dao.tinhTongTienDVTheoMaHoaDon(hd.getMaHoaDon()), 
			khuyenmai_dao.getPhanTramKhuyenMaiTheoMaKM(hd.getKhuyenMai().getMaKhuyenMai())
			)),
			hd.getNhanVien().getMaNhanVien(), hd.getNgayLapHoaDon(),
			};
			model.addRow(row);
		}
		lblTongDoanhThu.setText(df.format(tongDoanhThu));
		lblDoanhThuDichVu.setText(df.format(doanhThuDV));
		lblTongHoaDon.setText(i+"");
	}
	
	public void clearDataDoanhThuTheoNgay() {
		model.setRowCount(0);
	}
	
	private void ThongKeMonth() {
		pieChart.setSelectedIndex(-1);
		  pieChart.clearData();
		  String m = cbMonth.getSelectedItem().toString();
		  int year = Integer.parseInt(cbYear.getSelectedItem().toString());
		  double tongDoanhThu = 0;
		  double doanhThuDV = 0;
			int i = 0;
			for (HoaDonDatPhong hd : hoadon_dao.getHoaDonTheoThang(m, year)) {
				i++;
				tongDoanhThu += hd.tinhTongTienThanhToan(phong_dao.tinhTongTienPhongTheoMaHoaDon(hd.getMaHoaDon()), 
						chitietdichvu_dao.tinhTongTienDVTheoMaHoaDon(hd.getMaHoaDon()), 
						khuyenmai_dao.getPhanTramKhuyenMaiTheoMaKM(hd.getKhuyenMai().getMaKhuyenMai()));
				doanhThuDV += chitietdichvu_dao.tinhTongTienDVTheoMaHoaDon(hd.getMaHoaDon());
				Object[] row = { i, hd.getMaHoaDon(), 
				hd.getNgayLapHoaDon(),
				khachhang_dao.getKhachHangTheoMaKH(hd.getKhachHang().getMaKhachHang()).getHoTen(), 
				khachhang_dao.getKhachHangTheoMaKH(hd.getKhachHang().getMaKhachHang()).getSoDienThoai(),
				khuyenmai_dao.getPhanTramKhuyenMaiTheoMaKM(hd.getKhuyenMai().getMaKhuyenMai()),
				df.format(hd.tinhTongTienThanhToan(phong_dao.tinhTongTienPhongTheoMaHoaDon(hd.getMaHoaDon()), 
				chitietdichvu_dao.tinhTongTienDVTheoMaHoaDon(hd.getMaHoaDon()), 
				khuyenmai_dao.getPhanTramKhuyenMaiTheoMaKM(hd.getKhuyenMai().getMaKhuyenMai())
				)),
				hd.getNhanVien().getMaNhanVien(), hd.getNgayLapHoaDon(),
				};
				model.addRow(row);
			}
			lblTongDoanhThu.setText(df.format(tongDoanhThu));
			lblDoanhThuDichVu.setText(df.format(doanhThuDV));
			lblTongHoaDon.setText(i+"");
			try {
		    	DoanhThuLoaiPhong dtlp = phong_dao.tinhTongDoanhThuLoaiPhongTheoThang(m, year);
			    if(dtlp != null) {
			    	lblDoanhThuPhongThuong.setText(df.format(dtlp.getDoanhThuPhongThuong()));
				    lblDoanhThuPhongVIP.setText(df.format(dtlp.getDoanhThuPhongVIP()));
				    if(dtlp.getDoanhThuPhongThuong() > 0) {
				    	pieChart.addData(new ModelPieChart("Doanh thu phòng thường", dtlp.getDoanhThuPhongThuong(), new Color(23, 126, 238)));
				    }
					if(dtlp.getDoanhThuPhongVIP() > 0) {
						pieChart.addData(new ModelPieChart("Doanh thu phòng VIP", dtlp.getDoanhThuPhongVIP(), new Color(221, 65, 65)));
					}
			    }
			    lblTongSoGioHat.setText(chitiethoadon_dao.tinhSoGioHatTheoThang(m, year)+"");
		    } catch (Exception e2) {
		    	e2.printStackTrace();
			}
			if(doanhThuDV > 0) {
				pieChart.addData(new ModelPieChart("Doanh thu dịch vụ", doanhThuDV, new Color(47, 157, 64)));
			}
	}
	
	public void updateYearCbo() {
		for (ModelThongKe tk: thongke_dao.updateCboYear()) {
			cbYearStart.addItem(tk.getYear());
			cbYearEnd.addItem(tk.getYear());
			cbYear.addItem(tk.getYear());
		}
	}
	
	public void updateMonthYearCbo() {
		for (ModelThongKe tk: thongke_dao.updateCboMonth()) {
			cbMonth.addItem(tk.getMonth());
		}
	}
	
	public void resetField() {
		lblTongDoanhThu.setText("0 VNĐ");
		lblTongHoaDon.setText("0");
		lblDoanhThuPhongThuong.setText("0 VNĐ");
		lblDoanhThuPhongVIP.setText("0 VNĐ");
		lblDoanhThuDichVu.setText("0 VNĐ");
		lblTongSoGioHat.setText("0 VNĐ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThongKe)) {
			clearDataDoanhThuTheoNgay();
			if(cbDate.getSelectedItem().equals("Ngày")) {
				cbYearStart.setEnabled(false);
				cbYearEnd.setEnabled(false);
				pnContent.setVisible(true);
				pnCurveLineChart.setVisible(false);
				pnPieChart.setVisible(false);
				lblDate.setText("Chọn ngày");
				dateTimePicker.setVisible(true);
				cbMonth.setVisible(false);
				cbYear.setVisible(false);
				pnTable.setVisible(true);
				resetField();
				if(model.getRowCount() <= 0) {
			    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
			        String formattedDateTime = dateTimePicker.getDateTimeStrict().format(formatter);
			    	JOptionPane.showMessageDialog(this, "Không có dữ liệu thống kê của ngày: " + formattedDateTime);
			    }
			} else if (cbDate.getSelectedItem().equals("Tháng")) {
				pnContent.setVisible(true);
				cbYearStart.setEnabled(false);
				cbYearEnd.setEnabled(false);
				pnCurveLineChart.setVisible(false);
				pnPieChart.setVisible(true);
				lblDate.setText("Chọn tháng");
				cbMonth.setVisible(true);
				cbYear.setVisible(true);
				pnPieChart.setVisible(true);
				dateTimePicker.setVisible(false);
				pnTable.setVisible(false);
				resetField();
				ThongKeMonth();
				if(lblTongDoanhThu.getText().equals("0 VNĐ")) {
					JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê của tháng: "
					+ cbMonth.getSelectedItem() + " năm: " + cbYear.getSelectedItem()
					);
				}
			} else if(cbDate.getSelectedItem().equals("Năm")) {
				pnPieChart.setVisible(false);;
				cbYearStart.setEnabled(true);
				cbYearEnd.setEnabled(true);
				pnCurveLineChart.setVisible(true);
				pnContent.setVisible(false);
				pnTable.setVisible(false);
				if(Integer.valueOf(cbYearEnd.getSelectedItem().toString()) > Integer.valueOf(cbYearStart.getSelectedItem().toString())) {
					lineChart.clear();
					setCurveLineChartData();
				} else {
					JOptionPane.showMessageDialog(cbYearStart, "Năm kết thúc phải lớn hơn năm bắt đầu!");
				}
			}
		} else if(o.equals(btnLamMoi)) {
			cbThongKe.setSelectedItem("Doanh thu");
			cbDate.setSelectedItem("Ngày");
		} else if(o.equals(btnProfile)) {
			dialog_user.setVisible(true);
		}
	}
}
