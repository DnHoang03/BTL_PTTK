<%@ page import="model.MatHang394" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết mặt hàng</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f6f9;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 30px;
        }
        .product-details {
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
        .back-btn {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="product-details">
        <h2 class="text-center">Chi tiết mặt hàng</h2>

        <%
            // Lấy đối tượng MatHang394 từ request (vì bạn chuyển nó qua với `request.setAttribute`)
            MatHang394 matHang = (MatHang394) request.getAttribute("chiTietMH");

            if (matHang == null) {
                // Nếu không tìm thấy mặt hàng trong request, chuyển hướng về trang tìm kiếm
                response.sendRedirect("GDTimKiemMatHang048.jsp");
            } else {
        %>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Tên mặt hàng</th>
                <th>Giá bán</th>
                <th>Loại mặt hàng</th>
                <th>Chi tiết mặt hàng</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%= matHang.getId() %></td>
                <td><%= matHang.getTenMH() %></td>
                <td><%= String.format("%,.2f", matHang.getGiaBan()) %> VNĐ</td>
                <td><%= matHang.getLoaiMH() %></td>
                <td><%= matHang.getMoTa() %></td>
            </tr>
            </tbody>
        </table>
        <%
            }
        %>

        <button class="btn btn-secondary back-btn" onclick="history.back()">Quay lại</button>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
