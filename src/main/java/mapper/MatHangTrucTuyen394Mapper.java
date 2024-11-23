package mapper;

import model.DonHangTrucTuyen394;
import model.MatHang394;
import model.MatHangTrucTuyen394;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
public class MatHangTrucTuyen394Mapper implements RowMapper<MatHangTrucTuyen394>{
    @Override
    public MatHangTrucTuyen394 mapRow(ResultSet rs) {
        try {
            MatHangTrucTuyen394 matHangTrucTuyen394 = new MatHangTrucTuyen394();
            matHangTrucTuyen394.setId(rs.getInt("id"));
            matHangTrucTuyen394.setSoLuong(rs.getInt("soLuong"));
            MatHang394 matHang394 = new MatHang394();
            matHang394.setTenMH(rs.getString("tenMH"));
            matHang394.setLoaiMH(rs.getString("loaiMH"));
            matHang394.setGiaBan(rs.getFloat("giaBan"));
            matHangTrucTuyen394.setMatHang394(matHang394);
            DonHangTrucTuyen394 donHangTrucTuyen394 = new DonHangTrucTuyen394();
            donHangTrucTuyen394.setNgayTao(rs.getDate("ngayTao"));
            matHangTrucTuyen394.setDonHangTrucTuyen394(donHangTrucTuyen394);
            return matHangTrucTuyen394;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
