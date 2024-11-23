<%@ page import="model.ThanhVien394" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Arial', sans-serif;
        }
        .welcome-section {
            margin-top: 50px;
        }
        .action-buttons a {
            width: 250px;
        }
        .logout-button {
            position: fixed;
            bottom: 50px;
            right: 50px;
        }
    </style>
</head>
<body>
<%
    ThanhVien394 user = (ThanhVien394) request.getAttribute("user");
    if (user != null) {
%>
<div class="container welcome-section">
    <h3 class="mb-4">Chào mừng, <%= user.getHoten() %>!</h3>
    <% if ("warehouse".equals(user.getVaitro())) { %>
    <p class="fs-5 text-muted">Trang quản lý kho.</p>
    <div class="d-flex justify-content-center action-buttons mt-4">
        <a href="<%= request.getContextPath() %>/kho-hang/duyet-don" class="btn btn-primary me-3">Duyệt đơn và xuất kho</a>
    </div>
    <% } else if ("customer".equals(user.getVaitro())) { %>
    <p class="fs-5 text-muted">Trang khách hàng.</p>
    <div class="d-flex justify-content-center action-buttons mt-4">
        <a href="<%= request.getContextPath() %>/mat-hang/tim-kiem" class="btn btn-primary me-3">Tìm kiếm mặt hàng</a>
    </div>
    <% } else { %>
    <h2 class="text-danger">Thông tin không xác định</h2>
    <p class="text-muted">Bạn không có quyền truy cập vào trang này.</p>
    <% } %>
</div>
<%
} else {
%>
<div class="container text-center mt-5">
    <h2 class="text-danger">Người dùng không tồn tại!</h2>
    <p class="text-muted">Vui lòng đăng nhập lại để truy cập trang này.</p>
    <a href="index.jsp" class="btn btn-secondary mt-3">Quay lại trang đăng nhập</a>
</div>
<%
    }
%>
<div class="logout-button">
    <a href="index.jsp" class="btn btn-danger">Đăng xuất</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
