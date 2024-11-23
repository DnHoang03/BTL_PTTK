package controller;

import dao.MatHang394Dao;

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

@WebServlet("/mat-hang/*")
public class TimKiemMH394Ctr extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private MatHang394Dao matHang394Dao;

    public TimKiemMH394Ctr() {
        super();
        this.matHang394Dao = new MatHang394Dao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/tim-kiem":
                getMatHangTheoTen(req, resp);
                break;
            case "/chi-tiet":
                getMatHangChiTiet(req, resp);
                break;
        }
    }

    private void getMatHangTheoTen(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String tenMh = (String) req.getParameter("tenMH");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/GDTimKiemMatHang394.jsp");
        req.setAttribute("listMH", matHang394Dao.getMatHangTheoTen(tenMh));
        dispatcher.forward(req, resp);
    }

    private void getMatHangChiTiet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/GDChiTietMatHang394.jsp");
        req.setAttribute("chiTietMH", matHang394Dao.getMatHangTheoId(id));
        dispatcher.forward(req, resp);
    }
}
