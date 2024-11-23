package controller;

import dao.ThanhVien394Dao;
import model.ThanhVien394;

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
@WebServlet("/login")
public class LoginCtr extends HttpServlet {
    private static final long serialVersionUID = 2L;
    private ThanhVien394Dao thanhVien394Dao;

    public LoginCtr() {
        this.thanhVien394Dao = new ThanhVien394Dao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        ThanhVien394 thanhVien394 = thanhVien394Dao.validateThanhVien(username, password);
        if(thanhVien394 == null) {
            req.setAttribute("message", "Đăng nhập thất bại, vui lòng thử lại");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("GDChinh394.jsp");
            req.setAttribute("user", thanhVien394);
            dispatcher.forward(req, resp);
        }
    }
}
