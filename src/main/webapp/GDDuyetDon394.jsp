<%@ page import="dao.*, model.*" %>
<%@ page import="java.util.*, java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách Đơn hàng Chưa xuất</title>
    <!-- Link to Bootstrap for styling -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Arial', sans-serif;
        }

        .container {
            margin-top: 30px;
        }

        table {
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            text-align: center;
            padding: 12px;
        }

        .btn-submit {
            width: 100%;
        }

        .back-button {
            margin-top: 20px;
        }

        .no-data {
            text-align: center;
            color: #6c757d;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="text-center">Danh sách Đơn hàng Chưa xuất</h2>

    <%
        List<DonHangTrucTuyen394> donHangTrucTuyen394s = (List<DonHangTrucTuyen394>) request.getAttribute("listDonHang");
    %>

    <%
        if (donHangTrucTuyen394s != null && !donHangTrucTuyen394s.isEmpty()) {
    %>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID Đơn hàng</th>
            <th>Trạng thái</th>
            <th>Ngày tạo</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < donHangTrucTuyen394s.size(); i++) {
        %>
        <tr>
            <td><%= donHangTrucTuyen394s.get(i).getId() %></td>
            <td><%= donHangTrucTuyen394s.get(i).getTrangThai() %></td>
            <td><%= donHangTrucTuyen394s.get(i).getNgayTao() %></td>
            <td>
                <form method="get" action="<%= request.getContextPath() %>/kho-hang/giao-hang">
                    <input type="hidden" name="donHangId" value="<%= donHangTrucTuyen394s.get(i).getId() %>">
                    <input type="hidden" name="khachHangId" value="<%= donHangTrucTuyen394s.get(i).getKhachHang394Id() %>">
                    <input type="submit" class="btn btn-primary btn-submit" value="Duyệt đơn">
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
    } else {
    %>
    <div class="no-data">
        <p><strong>Không có đơn hàng chưa được xuất kho.</strong></p>
    </div>
    <%
        }
    %>

    <div class="back-button text-center">
        <button onclick="history.back()" class="btn btn-secondary">Quay lại</button>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
