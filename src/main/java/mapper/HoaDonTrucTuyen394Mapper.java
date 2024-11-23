package mapper;

import model.HoaDonTrucTuyen394;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
public class HoaDonTrucTuyen394Mapper implements RowMapper<HoaDonTrucTuyen394> {
    @Override
    public HoaDonTrucTuyen394 mapRow(ResultSet rs) {
        try {
            HoaDonTrucTuyen394 hoaDonTrucTuyen394 = new HoaDonTrucTuyen394();
            hoaDonTrucTuyen394.setHoaDon394Id(rs.getInt("tblHoaDon394id"));
            hoaDonTrucTuyen394.setDonHangTrucTuyen394Id(rs.getInt("tblDonHangTrucTuyen394id"));
            return hoaDonTrucTuyen394;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
