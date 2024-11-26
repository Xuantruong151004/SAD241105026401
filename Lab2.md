1.Phân tích ca sử dụng Employee
  A. Xác định các lớp phân tích
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
    B. Biểu đồ Sequence cho"Employee"
  ![Diagram](https://www.planttext.com/api/plantuml/png/T9B1JiGW48RlFCMa9pti2_HWTirwy61YDDdxB8m6CuK6Q3TzDWy-agyWfHJRjN8Wm_3D_3yJlZ-_zZwW2rt30cMm3gfd79nbXeDgjAa0_HI9Dc9QwXPDWEgXQTaEH4zey9rSmdAy1a_8Mc7GrhoIwxMaXEQilOAF6F2CdWuAsv2x7k_pQTj0OkQ34CagxEvcCpMWKlFr3ULWrBaL6HdfugU6VWeJSrLGADWj5Vhon1Vo7GU17FuaGVif9o2kXNHvNmtIKHJ-n-rOLjYr0KENCWAmvm-IOQqIuJIO-dTkurn8WU-a9E_VEkQX4iIUDfrhi-5zqVLnkeVPCiG66FiP9VPnYx_h1m00__y30000)
    C.Nhiệm vụ của từng lớp:
      Payroll Admin:Khởi tạo yêu cầu thêm nhân viên mới bằng cách nhập thông tin nhân viên vào hệ thống.Nhận phản hồi từ hệ thống về kết quả của thao tác (thành công hoặc lỗi).
      EmployeeManager:Điều phối quá trình thêm nhân viên bằng cách xử lý yêu cầu từ Payroll Admin.Gửi dữ liệu đến ValidationService để kiểm tra tính hợp lệ.Nếu dữ liệu hợp lệ, gửi yêu cầu đến DatabaseAdapter để lưu thông tin nhân viên.Trả về kết quả cuối cùng (thành công hoặc lỗi) cho Payroll Admin.
       ValidationService:Kiểm tra tính hợp lệ của thông tin nhân viên, bao gồm:Dữ liệu bắt buộc (tên, ID, loại hình thanh toán) có đầy đủ không.Định dạng dữ liệu (ví dụ: email, số điện thoại, mã số thuế).Tránh trùng lặp ID nhân viên trong hệ thống.Trả về kết quả xác thực (hợp lệ hoặc lỗi) cho EmployeeManager.
       DatabaseAdapter:Kết nối với cơ sở dữ liệu để thêm bản ghi nhân viên mới.Lưu thông tin của nhân viên vào cơ sở dữ liệu (CRUD - Create, Read, Update, Delete).Trả về đối tượng Employee đã được lưu trong cơ sở dữ liệu.
       Employee:Là đối tượng đại diện cho một nhân viên trong hệ thống.Lưu trữ thông tin nhân viên (tên, ID, phương thức thanh toán, loại lương, v.v.).
2.Phân tích ca sử dụng Paycheck
  A.Xác định các lớp phân tích
    -PayrollService:
      Xử lý chính trong việc tính toán lương, tạo Paycheck.
      Tích hợp với dữ liệu Timecard và thông tin nhân viên từ Database.
    -Employee:
      Đại diện cho nhân viên cần nhận lương, bao gồm thông tin cá nhân và phương thức thanh toán.
    -Timecard:
      Lưu trữ thông tin thời gian làm việc của nhân viên (giờ làm, dự án liên quan).
    -Paycheck:
      Đối tượng chứa thông tin về lương của nhân viên, bao gồm số tiền, ngày trả lương và phương thức thanh toán.
    -BankAdapter:
      Xử lý giao dịch ngân hàng cho các phương thức thanh toán Direct Deposit.
    -DatabaseAdapter:
      Truy xuất thông tin nhân viên, Timecard và lưu Paycheck vào cơ sở dữ liệu.
  B.Biểu đồ sequence cho"Paycheck"
    ![Diagram](https://www.planttext.com/api/plantuml/png/R9DHJiCm38RVUmfhJvq45wW46ctX2GJITW4lzLXOcaH9Dgbduu4ZSGNIfDcMZZvKTVpvzsz7_Vt-MLc7nXrxKI1poi1YFLX7FJH2iSC2qCQlGdkACwvHEbXyu62K46io9yueKDDtphNeS8kMdZhKZam0spfdddijr41HnGTvTiDxOcYwaDqqDpROdYQRASYH6kNXkliO5qKO2UuVa-iAp55EGvNBOZeTWRQku9DSCcbVbF6SduiyrzPmVor24_NAhIk4KXfsVgE4R0z9e03_tEgdCKlFBGCprqx4NC0NLC1GiAFmfjOeq0pbfeaYFfchs91loI4NTYwLDkZr37cn59TPrHre77gIxetSNdMnKKBpRkdqVVj5p0KGXSlhuG5QRdmQMjBAyeZDd8stLe4sYf6r4P_eCk-nF5UF9RcRBbOqIkwuwT5n9GDDmj9_JI_hq8PBTzv6x47ovYh6kxHukknjxcsiMVcN_zl-0000__y30000)
  C.Nhiệm vụ của từng lớp:
    -System Clock:Tự động kích hoạt quy trình trả lương vào các ngày cố định (thứ Sáu hoặc cuối tháng).Gửi tín hiệu đến lớp PayrollService để bắt đầu quá trình tính toán và trả lương.
    -PayrollService:Điều phối toàn bộ quy trình tính toán và xử lý lương.Gọi các phương thức từ DatabaseAdapter để lấy danh sách nhân viên và Timecard.Kết hợp thông tin từ Employee và Timecard để tính toán chi tiết lương.Tạo đối tượng Paycheck dựa trên thông tin đã tính toán.Gửi yêu cầu thanh toán qua BankAdapter (nếu phương thức là Direct Deposit) hoặc yêu cầu in phiếu lương.Lưu thông tin Paycheck vào cơ sở dữ liệu.
    - DatabaseAdapter:Truy xuất thông tin cần thiết từ cơ sở dữ liệu, bao gồm danh sách nhân viên và Timecard của từng nhân viên.Lưu thông tin Paycheck vào cơ sở dữ liệu sau khi xử lý xong.
    -Employee:Cung cấp thông tin cá nhân và phương thức thanh toán cho quá trình tính lương.Tính toán chi tiết lương dựa trên giờ làm (Timecard), loại lương (hourly/salaried/commissioned), và các khoản khấu trừ.Trả về chi tiết lương để tạo Paycheck.
     Timecard:Lưu trữ dữ liệu về giờ làm việc, dự án liên quan, và số giờ làm thêm (nếu có).Cung cấp thông tin để lớp Employee tính toán chi tiết lương.
     -Paycheck:Đại diện cho phiếu lương của nhân viên, lưu trữ thông tin như:Số tiền lương được trả.Ngày trả lương.Phương thức thanh toán (Direct Deposit, Mail, Pick-up).In phiếu lương (nếu phương thức không phải Direct Deposit).
     BankAdapter:Gửi giao dịch thanh toán qua Direct Deposit đến ngân hàng.Trả về xác nhận giao dịch thành công hoặc thất bại.Nếu giao dịch thất bại, thông báo lại để PayrollService xử lý lại sau.
3.Phân tích ca sử dụng Timecard:

      
