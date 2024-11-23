package controller;

import dao.*;
import model.HoaDonTrucTuyen394;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HoangTv
 * @created 11/23/2024
 */
@WebServlet("/kho-hang/*")
public class DuyetDonXuatKho394Ctr extends HttpServlet {
    private static final long serialVersionUID = 3L;
    private DonHangTrucTuyen394Dao donHangTrucTuyen394Dao;
    private ThanhVien394Dao thanhVien394Dao;
    private MatHangTrucTuyen394Dao matHangTrucTuyen394Dao;
    private HoaDon394Dao hoaDon394Dao;
    private HoaDonTrucTuyen394Dao hoaDonTrucTuyen394Dao;

    public DuyetDonXuatKho394Ctr() {
        this.donHangTrucTuyen394Dao = new DonHangTrucTuyen394Dao();
        this.thanhVien394Dao = new ThanhVien394Dao();
        this.matHangTrucTuyen394Dao = new MatHangTrucTuyen394Dao();
        this.hoaDon394Dao = new HoaDon394Dao();
        this.hoaDonTrucTuyen394Dao = new HoaDonTrucTuyen394Dao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getPathInfo();
        switch (path) {
            case "/duyet-don":
                getDonHangChuaDuyet(req, resp);
                break;
            case "/giao-hang":
                getNhanVienGiaoHang(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getPathInfo();
        switch (path) {
            case "/phan-cong":
                updateNguoiGiaoHang(req, resp);
                break;
        }
    }

    private void getDonHangChuaDuyet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/GDDuyetDon394.jsp");
        req.setAttribute("listDonHang", donHangTrucTuyen394Dao.getHoaDonTheoTrangThai("Chưa duyệt"));
        dispatcher.forward(req, resp);
    }

    private void getNhanVienGiaoHang(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/GDNhanVienGiaoHang394.jsp");
        req.setAttribute("listNVGH", thanhVien394Dao.getAllNhanVienGiaoHang());
        dispatcher.forward(req, resp);
    }

    private void updateNguoiGiaoHang(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int nhanVienId = Integer.parseInt(req.getParameter("nhanVienId"));
        int donHangId = Integer.parseInt(req.getParameter("donHangId"));
        int khachHangId = Integer.parseInt(req.getParameter("khachHangId"));
        donHangTrucTuyen394Dao.updateNhanVienGiaoHangVaTrangThaiDonHangTheoId(donHangId, nhanVienId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/GDHoaDon394.jsp");
        req.setAttribute("listMatHangTT", matHangTrucTuyen394Dao.getMatHangTrucTuyenTheoDonHangId(donHangId));
        req.setAttribute("khachHang", thanhVien394Dao.getThanhVienById(khachHangId));
        req.setAttribute("nvGiaoHang", thanhVien394Dao.getThanhVienById(nhanVienId));
        req.setAttribute("donHangId", donHangId);
        HoaDonTrucTuyen394 hoaDonTrucTuyen394 = hoaDonTrucTuyen394Dao.getHoaDonByDonHangTrucTuyenId(donHangId);
        req.setAttribute("hoaDon", hoaDon394Dao.getHoaDonByHoaDonTrucTuyenId(hoaDonTrucTuyen394.getHoaDon394Id()));
        dispatcher.forward(req, resp);
    }
}
