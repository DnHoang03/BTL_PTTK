package dao;

import mapper.HoaDonTrucTuyen394Mapper;
import model.HoaDon394;
import model.HoaDonTrucTuyen394;

import java.util.List;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
public class HoaDonTrucTuyen394Dao extends DbContext<HoaDon394> {
    public HoaDonTrucTuyen394 getHoaDonByDonHangTrucTuyenId(int id) {
        String sql = "SELECT * FROM tblHoaDonTrucTuyen394 WHERE tblDonHangTrucTuyen394id = ?";
        List<HoaDonTrucTuyen394> hoaDonTrucTuyen394s = query(sql, new HoaDonTrucTuyen394Mapper(), id);
        return hoaDonTrucTuyen394s.isEmpty()?null:hoaDonTrucTuyen394s.get(0);
    }
}
