package mapper;

import model.HoaDon394;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
public class HoaDon394Mapper implements RowMapper<HoaDon394> {
    @Override
    public HoaDon394 mapRow(ResultSet rs) {
        try {
            HoaDon394 hoaDon394 = new HoaDon394();
            hoaDon394.setId(rs.getInt("id"));
            hoaDon394.setNgayTao(rs.getDate("ngayTao"));
            hoaDon394.setTongTien(rs.getInt("tongTien"));
            return hoaDon394;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
