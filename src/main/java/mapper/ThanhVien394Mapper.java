package mapper;

import model.ThanhVien394;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
public class ThanhVien394Mapper implements RowMapper<ThanhVien394>{
    @Override
    public ThanhVien394 mapRow(ResultSet rs) {
        try {
            ThanhVien394 thanhVien394 = new ThanhVien394();
            thanhVien394.setTenDangNhap(rs.getString("tenDangNhap"));
            thanhVien394.setPassword(rs.getString("password"));
            thanhVien394.setHoten(rs.getString("hoten"));
            thanhVien394.setDiachi(rs.getString("diachi"));
            thanhVien394.setNgaysinh(rs.getDate("ngaysinh"));
            thanhVien394.setEmail(rs.getString("email"));
            thanhVien394.setSdt(rs.getString("sdt"));
            thanhVien394.setVaitro(rs.getString("vaitro"));
            thanhVien394.setId(rs.getInt("id"));
            return thanhVien394;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
