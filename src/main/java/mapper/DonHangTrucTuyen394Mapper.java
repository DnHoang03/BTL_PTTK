package mapper;

import model.DonHangTrucTuyen394;
import model.MatHang394;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
public class DonHangTrucTuyen394Mapper implements RowMapper<DonHangTrucTuyen394>{
    @Override
    public DonHangTrucTuyen394 mapRow(ResultSet rs) {
        try {
            DonHangTrucTuyen394 donHangTrucTuyen394  =new DonHangTrucTuyen394();
            donHangTrucTuyen394.setId(rs.getInt("id"));
            donHangTrucTuyen394.setKhachHang394Id(rs.getInt("tblKhachHang394tblThanhVien394id"));
            donHangTrucTuyen394.setNgayTao(rs.getDate("ngayTao"));
            donHangTrucTuyen394.setTrangThai(rs.getString("trangThai"));
            return donHangTrucTuyen394;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
