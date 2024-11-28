# phân tích các ca sử dụng trong hệ thống Payroll System.

## Employee
   -EmployeeManager:
      Quản lý các thao tác liên quan đến nhân viên, như thêm, cập nhật, hoặc xóa nhân viên.
      Cung cấp giao tiếp giữa tầng giao diện người dùng và cơ sở dữ liệu.
    -Employee:
      Đại diện cho một nhân viên, lưu trữ thông tin chi tiết như tên, ID, loại hình lương (hourly/salaried/commissioned), địa chỉ, và thông tin thanh toán.
    -PayrollService:
      Kết nối với EmployeeManager để tính lương cho nhân viên dựa trên thông tin của họ và xử lý các báo cáo liên quan.
    -DatabaseAdapter:
      Lớp trung gian để tương tác với cơ sở dữ liệu Employee, thực hiện các thao tác CRUD (Create, Read, Update, Delete).
    -ValidationService:
      Xác thực và kiểm tra tính hợp lệ của dữ liệu nhập vào như số ID nhân viên hoặc định dạng thông tin thanh toán.
