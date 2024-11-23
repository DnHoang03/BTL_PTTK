package dao;

import mapper.DonHangTrucTuyen394Mapper;
import model.DonHangTrucTuyen394;

import java.util.List;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
public class DonHangTrucTuyen394Dao extends DbContext<DonHangTrucTuyen394> {

    public List<DonHangTrucTuyen394> getHoaDonTheoTrangThai(String trangThai) {
        String sql = "SELECT * FROM tblDonHangTrucTuyen394 WHERE trangThai = ?";
        List<DonHangTrucTuyen394> donHangTrucTuyen394s =
                query(sql, new DonHangTrucTuyen394Mapper(), trangThai);
        return donHangTrucTuyen394s.isEmpty()?null:donHangTrucTuyen394s;
    }

    public void updateNhanVienGiaoHangVaTrangThaiDonHangTheoId(int id, int idNVGH) {
        String sql = "UPDATE tblDonHangTrucTuyen394 " +
                "SET tblNhanVienGiaoHang394tblThanhVien394id = ?, trangThai = 'Đã duyệt' " +
                "WHERE id = ? ";
        update(sql, idNVGH, id);
    }
}
