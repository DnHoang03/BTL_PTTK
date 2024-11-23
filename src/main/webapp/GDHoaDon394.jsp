<%@ page import="model.MatHangTrucTuyen394" %>
<%@ page import="java.util.List" %>
<%@ page import="model.HoaDon394" %>
<%@ page import="model.ThanhVien394" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thông Tin Đơn Hàng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-top: 20px;
            font-size: 24px;
        }

        table {
            width: 70%;
            margin: 30px auto;
            border-collapse: collapse;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 15px;
            text-align: left;
            font-size: 16px;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        td {
            background-color: #f9f9f9;
            border-bottom: 1px solid #ddd;
        }

        td ul {
            list-style-type: none;
            padding-left: 0;
        }

        td ul li {
            padding: 5px 0;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            margin: 10px;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease;
        }

        button:hover {
            background-color: #45a049;
            box-shadow: 0 6px 8px rgba(0, 0, 0, 0.2);
        }

        .button-container {
            text-align: center;
            margin-top: 20px;
        }

        .button-container button {
            margin: 0 10px;
        }

    </style>
</head>

<%
    HoaDon394 hoaDon394 = (HoaDon394) request.getAttribute("hoaDon");
    ThanhVien394 khachHang = (ThanhVien394) request.getAttribute("khachHang");
    ThanhVien394 nvGH = (ThanhVien394) request.getAttribute("nvGiaoHang");
    int donHangId = (Integer) request.getAttribute("donHangId");
    List<MatHangTrucTuyen394> matHangTrucTuyen394List = (List<MatHangTrucTuyen394>)request.getAttribute("listMatHangTT");
%>
<body>
<h2>Thông Tin Đơn Hàng</h2>
<table>
    <tr>
        <th>Mã Hóa Đơn</th>
        <td><%= hoaDon394.getId() %></td>
    </tr>
    <tr>
        <th>Ngày Tạo Hóa Đơn</th>
        <td><%= hoaDon394.getNgayTao() %></td>
    </tr>
    <tr>
        <th>Mã Đơn Hàng</th>
        <td><%= donHangId %></td>
    </tr>
    <tr>
        <th>Tên Khách Hàng</th>
        <td><%= khachHang.getHoten() %></td>
    </tr>
    <tr>
        <th>Nhân Viên Giao Hàng</th>
        <td><%=  nvGH.getHoten()%></td>
    </tr>
    <tr>
        <th>Mặt Hàng</th>
        <td>
            <ul>
                <%
                    for (MatHangTrucTuyen394 matHang : matHangTrucTuyen394List) {
                %>
                <li><%= matHang.getMatHang394().getTenMH() %> - Số lượng: <%= matHang.getSoLuong() %> - Giá: <%= String.format("%,.2f", matHang.getMatHang394().getGiaBan()) %></li>
                <%
                    }
                %>
            </ul>
        </td>
    </tr>
    <tr>
        <th>Tổng Tiền</th>
        <td><%= String.format("%,.2f", hoaDon394.getTongTien()) %></td>
    </tr>
</table>

<div class="button-container">
    <button onclick="window.print()">In Đơn Hàng</button>
    <button onclick="history.back()">Quay Lại</button>
</div>

</body>
</html>
