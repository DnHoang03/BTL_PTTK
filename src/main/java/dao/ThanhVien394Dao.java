package dao;

import mapper.ThanhVien394Mapper;
import model.ThanhVien394;

import java.util.List;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
public class ThanhVien394Dao extends DbContext<ThanhVien394> {

    public ThanhVien394 validateThanhVien(String username, String password) {
        String sql = "SELECT * FROM tblThanhVien394 WHERE tenDangNhap = ? AND password = ?";
        List<ThanhVien394> thanhVien394s = query(sql, new ThanhVien394Mapper(), username, password);
        return (thanhVien394s.isEmpty()) ? null : thanhVien394s.get(0);
    }

    public List<ThanhVien394> getAllNhanVienGiaoHang() {
        String sql = "SELECT * FROM tblThanhVien394 WHERE vaitro = 'shipper'";
        List<ThanhVien394> thanhVien394s = query(sql, new ThanhVien394Mapper());
        return (thanhVien394s.isEmpty()) ? null : thanhVien394s;
    }

    public ThanhVien394 getThanhVienById(int id) {
        String sql = "SELECT * FROM tblThanhVien394 WHERE id = ?";
        List<ThanhVien394> thanhVien394s = query(sql, new ThanhVien394Mapper(), id);
        return thanhVien394s.isEmpty()?null:thanhVien394s.get(0);
    }
}
