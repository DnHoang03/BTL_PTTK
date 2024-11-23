package model;

import java.util.Date;
import java.util.List;

/**
 * @author HoangTv
 * @created 11/22/2024
 */
public class DonHangTrucTuyen394 {
    private int id;
    private Date ngayTao;
    private String trangThai;
    private List<MatHangTrucTuyen394> matHang;
    private int nhanVienGiaoHang394Id;
    private int khachHang394Id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public List<MatHangTrucTuyen394> getMatHang() {
        return matHang;
    }

    public void setMatHang(List<MatHangTrucTuyen394> matHang) {
        this.matHang = matHang;
    }

    public int getNhanVienGiaoHang394Id() {
        return nhanVienGiaoHang394Id;
    }

    public void setNhanVienGiaoHang394Id(int nhanVienGiaoHang394Id) {
        this.nhanVienGiaoHang394Id = nhanVienGiaoHang394Id;
    }

    public int getKhachHang394Id() {
        return khachHang394Id;
    }

    public void setKhachHang394Id(int khachHang394Id) {
        this.khachHang394Id = khachHang394Id;
    }
}
