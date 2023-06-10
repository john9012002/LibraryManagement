import java.time.LocalDate;

public class TheMuon {
    private String maPhieuMuon;
    private LocalDate ngayMuon;
    private LocalDate hanTra;
    private String soHieuSach;
    private SinhVien sinhVienMuonSach;

    public TheMuon(String maPhieuMuon, LocalDate ngayMuon, LocalDate hanTra, String soHieuSach, SinhVien sinhVienMuonSach) {
        this.maPhieuMuon = maPhieuMuon;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.soHieuSach = soHieuSach;
        this.sinhVienMuonSach = sinhVienMuonSach;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public LocalDate getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(LocalDate ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public LocalDate getHanTra() {
        return hanTra;
    }

    public void setHanTra(LocalDate hanTra) {
        this.hanTra = hanTra;
    }

    public String getSoHieuSach() {
        return soHieuSach;
    }

    public void setSoHieuSach(String soHieuSach) {
        this.soHieuSach = soHieuSach;
    }

    public SinhVien getSinhVienMuonSach() {
        return sinhVienMuonSach;
    }

    public void setSinhVienMuonSach(SinhVien sinhVienMuonSach) {
        this.sinhVienMuonSach = sinhVienMuonSach;
    }
}

