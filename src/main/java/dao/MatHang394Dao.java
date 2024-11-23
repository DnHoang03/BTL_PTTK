package dao;

import mapper.MatHang394Maper;
import model.MatHang394;

import java.util.List;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
public class MatHang394Dao extends DbContext<MatHang394> {

    public List<MatHang394> getMatHangTheoTen(String tenMH) {
        String sql = "SELECT * FROM tblMatHang394 WHERE tenMH LIKE ?";
        List<MatHang394> matHang394s = query(sql, new MatHang394Maper(), "%"+tenMH+"%");
        return matHang394s.isEmpty()?null:matHang394s;
    }

    public MatHang394 getMatHangTheoId(int id) {
        String sql = "SELECT * FROM tblMatHang394 WHERE id = ?";
        List<MatHang394> matHang394s = query(sql, new MatHang394Maper(), id);
        return (!matHang394s.isEmpty()) ? matHang394s.get(0):null;
    }
}
