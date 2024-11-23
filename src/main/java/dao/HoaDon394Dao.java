package dao;

import mapper.HoaDon394Mapper;
import model.HoaDon394;

import java.util.List;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
public class HoaDon394Dao extends DbContext<HoaDon394> {

    public HoaDon394 getHoaDonByHoaDonTrucTuyenId(int id) {
        String sql = "SELECT * FROM tblHoaDon394 WHERE id = ?";
        List<HoaDon394> hoaDon394s = query(sql, new HoaDon394Mapper(), id);
        return hoaDon394s.isEmpty() ? null : hoaDon394s.get(0);
    }
}
