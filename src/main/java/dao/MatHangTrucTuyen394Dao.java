package dao;

import mapper.MatHangTrucTuyen394Mapper;
import model.MatHangTrucTuyen394;

import java.util.List;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
public class MatHangTrucTuyen394Dao extends DbContext<MatHangTrucTuyen394> {

    public List<MatHangTrucTuyen394> getMatHangTrucTuyenTheoDonHangId(int donHangId) {
        String sql = "SELECT mhtt394.id, soLuong, tblMatHang394id, tblDonHangTrucTuyen394id, " +
                "mh394.tenMH, mh394.loaiMH, mh394.giaBan,  " +
                "dhtt394.ngayTao " +
                "FROM `tblMatHangTrucTuyen394` mhtt394 " +
                "INNER JOIN `tblMatHang394` mh394 on mh394.id = mhtt394.tblMatHang394id " +
                "INNER JOIN `tblDonHangTrucTuyen394` dhtt394 on dhtt394.id = mhtt394.tblDonHangTrucTuyen394id " +
                "WHERE tblDonHangTrucTuyen394id = ?";
        List<MatHangTrucTuyen394> matHangTrucTuyen394s =
                query(sql, new MatHangTrucTuyen394Mapper(), donHangId);
        return matHangTrucTuyen394s.isEmpty()?null:matHangTrucTuyen394s;
    }
}
