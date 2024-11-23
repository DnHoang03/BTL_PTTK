<%@page import="dao.*, model.*" %>
<%@ page import="java.util.*, java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang tìm kiếm mặt hàng</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f6f9;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 30px;
        }
        .form-search {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }
        table {
            margin-top: 20px;
            width: 100%;
        }
        th, td {
            text-align: center;
            vertical-align: middle;
        }
        .btn-custom {
            background-color: #007bff;
            color: white;
            border: none;
        }
        .btn-custom:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="form-search">
        <h2 class="text-center">Tìm kiếm mặt hàng</h2>
        <form method="get" action="<%= request.getContextPath() %>/mat-hang/tim-kiem">
            <div class="form-group">
                <label for="tenMh">Nhập tên mặt hàng:</label>
                <input type="text" class="form-control" name="tenMH" id="tenMh" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Tìm kiếm</button>
        </form>
    </div>

    <%-- Hiển thị kết quả tìm kiếm --%>
    <%
        List<MatHang394> matHang394s = (List<MatHang394>) request.getAttribute("listMH");
        if (matHang394s != null && !matHang394s.isEmpty()) {
    %>
    <h3 class="text-center mt-4">Kết quả tìm kiếm:</h3>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên mặt hàng</th>
            <th>Giá</th>
            <th>Loại mặt hàng</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < matHang394s.size(); i++) {
        %>
        <tr>
            <td><%= matHang394s.get(i).getId() %></td>
            <td><%= matHang394s.get(i).getTenMH() %></td>
            <td><%= String.format("%,.2f", matHang394s.get(i).getGiaBan()) %></td>
            <td><%= matHang394s.get(i).getLoaiMH() %></td>
            <td>
                <form method="get" action="<%= request.getContextPath() %>/mat-hang/chi-tiet">
                    <input type="hidden" name="id" value="<%= matHang394s.get(i).getId() %>">
                    <button type="submit" class="btn btn-custom">Xem chi tiết</button>
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
        if (request.getParameter("tenMH") != null) {
    %>
    <div class="alert alert-warning text-center">
        Không tìm thấy mặt hàng nào với tên "<%= request.getParameter("tenMH") %>".
    </div>
    <%
            }
        }
    %>

    <button class="btn btn-secondary mt-3" onclick="history.back()">Quay lại</button>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
