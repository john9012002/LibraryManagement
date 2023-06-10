import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class QuanLyThuVien {
    private ArrayList<TheMuon> danhSachTheMuon;
    private JFrame frame;
    private JTable table;

    public QuanLyThuVien() {
        danhSachTheMuon = new ArrayList<>();

        frame = new JFrame("Quản lý thư viện");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo bảng để hiển thị danh sách thẻ mượn
        String[] columnNames = {"Mã phiếu mượn", "Ngày mượn", "Hạn trả", "Số hiệu sách", "Họ tên", "Tuổi", "Lớp"};
        Object[][] data = {};

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        // Tạo các components: textfields, buttons
        JTextField tfMaPhieuMuon = new JTextField(10);
        JTextField tfNgayMuon = new JTextField(10);
        JTextField tfHanTra = new JTextField(10);
        JTextField tfSoHieuSach = new JTextField(10);
        JTextField tfHoTen = new JTextField(10);
        JTextField tfTuoi = new JTextField(10);
        JTextField tfLop = new JTextField(10);

        JButton btnThem = new JButton("Thêm");
        JButton btnXoa = new JButton("Xóa");
        JButton btnHienThi = new JButton("Hiển thị");

        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridLayout(8, 2));
        panelInput.add(new JLabel("Mã phiếu mượn: "));
        panelInput.add(tfMaPhieuMuon);
        panelInput.add(new JLabel("Ngày mượn (yyyy-MM-dd): "));
        panelInput.add(tfNgayMuon);
        panelInput.add(new JLabel("Hạn trả (yyyy-MM-dd): "));
        panelInput.add(tfHanTra);
        panelInput.add(new JLabel("Số hiệu sách: "));
        panelInput.add(tfSoHieuSach);
        panelInput.add(new JLabel("Họ tên: "));
        panelInput.add(tfHoTen);
        panelInput.add(new JLabel("Tuổi: "));
        panelInput.add(tfTuoi);
        panelInput.add(new JLabel("Lớp: "));
        panelInput.add(tfLop);
        panelInput.add(btnThem);
        panelInput.add(btnXoa);

        JPanel panelOutput = new JPanel();
        panelOutput.setLayout(new BoxLayout(panelOutput, BoxLayout.PAGE_AXIS));
        panelOutput.add(scrollPane);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelButtons.add(btnHienThi);

        // Add các components vào frame
        frame.add(panelInput, BorderLayout.WEST);
        frame.add(panelOutput, BorderLayout.CENTER);
        frame.add(panelButtons, BorderLayout.SOUTH);

        // Set preferred size cho frame và hiển thị frame
        frame.setPreferredSize(new Dimension(800, 400));
        frame.pack();
        frame.setVisible(true);

        // Sự kiện khi click vào nút Thêm
        btnThem.addActionListener(e -> {
            String maPhieuMuon = tfMaPhieuMuon.getText();
            LocalDate ngayMuon = LocalDate.parse(tfNgayMuon.getText());
            LocalDate hanTra = LocalDate.parse(tfHanTra.getText());
            String soHieuSach = tfSoHieuSach.getText();
            String hoTen = tfHoTen.getText();
            int tuoi = Integer.parseInt(tfTuoi.getText());
            String lop = tfLop.getText();

            SinhVien sinhVien = new SinhVien(hoTen, tuoi, lop);
            TheMuon theMuon = new TheMuon(maPhieuMuon, ngayMuon, hanTra, soHieuSach, sinhVien);

            danhSachTheMuon.add(theMuon);
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        });

        // Sự kiện khi click vào nút Xóa
        btnXoa.addActionListener(e -> {
            String maPhieuMuon = tfMaPhieuMuon.getText();

            danhSachTheMuon.removeIf(theMuon -> theMuon.getMaPhieuMuon().equals(maPhieuMuon));
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        });

        // Sự kiện khi click vào nút Hiển thị
        btnHienThi.addActionListener(e -> {
            Object[][] dataOut = new Object[danhSachTheMuon.size()][];
            for (int i = 0; i < danhSachTheMuon.size(); i++) {
                TheMuon theMuon = danhSachTheMuon.get(i);
                String[] row = {theMuon.getMaPhieuMuon(), theMuon.getNgayMuon().toString(), theMuon.getHanTra().toString(),
                        theMuon.getSoHieuSach(), theMuon.getSinhVienMuonSach().getHoTen(),
                        String.valueOf(theMuon.getSinhVienMuonSach().getTuoi()), theMuon.getSinhVienMuonSach().getLop()};
                dataOut[i] = row;
            }
            table.setModel(new javax.swing.table.DefaultTableModel(dataOut, columnNames));
        });
    }

    public static void main(String[] args) {
        new QuanLyThuVien();
    }
}

