package mapper;

import model.MatHang394;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
public class MatHang394Maper implements RowMapper<MatHang394> {

    @Override
    public MatHang394 mapRow(ResultSet rs) {
        try {
            MatHang394 matHang394 = new MatHang394();
            matHang394.setId(rs.getInt("id"));
            matHang394.setGiaBan(rs.getFloat("giaBan"));
            matHang394.setLoaiMH(rs.getString("loaiMH"));
            matHang394.setMoTa(rs.getString("moTa"));
            matHang394.setTenMH(rs.getString("tenMH"));
            return matHang394;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
