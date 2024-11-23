<%@ page import="model.*, dao.*"%>
<%@ page import="java.util.*, java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Nhân viên Giao hàng</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 30px;
        }
        .table th, .table td {
            text-align: center;
        }
        .button-container {
            display: flex;
            justify-content: flex-start;
            margin-top: 20px;
        }
        .btn-back {
            margin-top: 20px;
        }
        .btn-submit {
            width: 150px;
            background-color: #007bff;
            border: none;
            color: white;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .btn-submit:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>

<div class="container">
    <h2 class="text-center mb-4">Danh sách Nhân viên Giao hàng</h2>

    <%
        int id = Integer.parseInt(request.getParameter("donHangId"));
        int khachHangId = Integer.parseInt(request.getParameter("khachHangId"));
        List<ThanhVien394> listNhanVienGiaoHang = (List<ThanhVien394>)request.getAttribute("listNVGH");
    %>

    <!-- Form để chọn nhân viên giao hàng -->
    <form action="<%= request.getContextPath() %>/kho-hang/phan-cong" method="post">
        <%
            if (listNhanVienGiaoHang != null && listNhanVienGiaoHang.size() > 0) {
        %>
        <table class="table table-bordered table-striped">
            <thead class="table-light">
            <tr>
                <th>Chọn</th>
                <th>ID Nhân viên</th>
                <th>Tên</th>
                <th>Số điện thoại</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < listNhanVienGiaoHang.size(); i++) {
            %>
            <tr>
                <td>
                    <input type="radio" name="nhanVienId" value="<%= listNhanVienGiaoHang.get(i).getId() %>" required>
                    <input type="hidden" name="donHangId" value="<%= id %>">
                    <input type="hidden" name="khachHangId" value="<%= khachHangId %>">
                </td>
                <td><%= listNhanVienGiaoHang.get(i).getId()%></td>
                <td><%= listNhanVienGiaoHang.get(i).getHoten() %></td>
                <td><%= listNhanVienGiaoHang.get(i).getSdt()%></td>
                <td><%= listNhanVienGiaoHang.get(i).getEmail()%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <%
        } else {
        %>
        <div class="alert alert-warning" role="alert">
            Không có nhân viên giao hàng nào.
        </div>
        <%
            }
        %>

        <div class="button-container">
            <input type="submit" class="btn btn-submit" value="Duyệt đơn">
        </div>
    </form>

    <button type="button" class="btn btn-secondary btn-back" onclick="history.back()">Quay lại</button>
</div>

<!-- Bootstrap JS (Optional, for interactive components like modals, dropdowns, etc.) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


