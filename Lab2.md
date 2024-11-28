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
### Sơ đồ tuần tự (Sequence Diagram) cho ca sử dụng Employee

   ![Diagram]((https://www.planttext.com/api/plantuml/png/T9B1JiGW48RlFCMa9pti2_HWTirwy61YDDdxB8m6CuK6Q3TzDWy-agyWfHJRjN8Wm_3D_3yJlZ-_zZwW2rt30cMm3gfd79nbXeDgjAa0_HI9Dc9QwXPDWEgXQTaEH4zey9rSmdAy1a_8Mc7GrhoIwxMaXEQilOAF6F2CdWuAsv2x7k_pQTj0OkQ34CagxEvcCpMWKlFr3ULWrBaL6HdfugU6VWeJSrLGADWj5Vhon1Vo7GU17FuaGVif9o2kXNHvNmtIKHJ-n-rOLjYr0KENCWAmvm-IOQqIuJIO-dTkurn8WU-a9E_VEkQX4iIUDfrhi-5zqVLnkeVPCiG66FiP9VPnYx_h1m00__y30000)
