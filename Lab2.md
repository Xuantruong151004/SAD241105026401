# Phân tích các ca sử dụng trong hệ thống Payroll System.

1.Employee
- EmployeeManager:
    Quản lý các thao tác liên quan đến nhân viên, như thêm, cập nhật, hoặc xóa nhân viên.
    Cung cấp giao tiếp giữa tầng giao diện người dùng và cơ sở dữ liệu.
- Employee:
    Đại diện cho một nhân viên, lưu trữ thông tin chi tiết như tên, ID, loại hình lương (hourly/salaried/commissioned), địa chỉ, và thông tin thanh toán.
- PayrollService:
   Kết nối với EmployeeManager để tính lương cho nhân viên dựa trên thông tin của họ và xử lý các báo cáo liên quan.
- DatabaseAdapter:
   Lớp trung gian để tương tác với cơ sở dữ liệu Employee, thực hiện các thao tác CRUD (Create, Read, Update, Delete).
- ValidationService:
    Xác thực và kiểm tra tính hợp lệ của dữ liệu nhập vào như số ID nhân viên hoặc định dạng thông tin thanh toán.
- Sơ đồ tuần tự (Sequence Diagram) cho ca sử dụng Employee:
- ![Diagram](https://www.planttext.com/api/plantuml/png/T9B1JiGW48RlFCMa9pti2_HWTirwy61YDDdxB8m6CuK6Q3TzDWy-agyWfHJRjN8Wm_3D_3yJlZ-_zZwW2rt30cMm3gfd79nbXeDgjAa0_HI9Dc9QwXPDWEgXQTaEH4zey9rSmdAy1a_8Mc7GrhoIwxMaXEQilOAF6F2CdWuAsv2x7k_pQTj0OkQ34CagxEvcCpMWKlFr3ULWrBaL6HdfugU6VWeJSrLGADWj5Vhon1Vo7GU17FuaGVif9o2kXNHvNmtIKHJ-n-rOLjYr0KENCWAmvm-IOQqIuJIO-dTkurn8WU-a9E_VEkQX4iIUDfrhi-5zqVLnkeVPCiG66FiP9VPnYx_h1m00__y30000)
2.Paycheck
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
   - Sơ đồ tuần tự (Sequence Diagram) cho ca sử dụng Employee:
   - ![Diagram](https://www.planttext.com/api/plantuml/png/R9DHJiCm38RVUmfhJvq45wW46ctX2GJITW4lzLXOcaH9Dgbduu4ZSGNIfDcMZZvKTVpvzsz7_Vt-MLc7nXrxKI1poi1YFLX7FJH2iSC2qCQlGdkACwvHEbXyu62K46io9yueKDDtphNeS8kMdZhKZam0spfdddijr41HnGTvTiDxOcYwaDqqDpROdYQRASYH6kNXkliO5qKO2UuVa-iAp55EGvNBOZeTWRQku9DSCcbVbF6SduiyrzPmVor24_NAhIk4KXfsVgE4R0z9e03_tEgdCKlFBGCprqx4NC0NLC1GiAFmfjOeq0pbfeaYFfchs91loI4NTYwLDkZr37cn59TPrHre77gIxetSNdMnKKBpRkdqVVj5p0KGXSlhuG5QRdmQMjBAyeZDd8stLe4sYf6r4P_eCk-nF5UF9RcRBbOqIkwuwT5n9GDDmj9_JI_hq8PBTzv6x47ovYh6kxHukknjxcsiMVcN_zl-0000__y30000)
3.Timecard
   -PurchaseOrderManager:
     Quản lý toàn bộ quá trình thêm, cập nhật hoặc xóa đơn hàng (Purchase Order).
     Điều phối giữa các lớp khác để xử lý logic nghiệp vụ và lưu trữ dữ liệu.
   -CommissionedEmployee:
     Đại diện cho nhân viên được nhận hoa hồng từ đơn hàng.
     Lưu trữ thông tin cá nhân và tỷ lệ hoa hồng.
   -PurchaseOrder:
     Đại diện cho một đơn hàng, lưu trữ chi tiết như: khách hàng, sản phẩm, số tiền, ngày mua hàng.
   -ValidationService:
     Kiểm tra tính hợp lệ của thông tin đơn hàng như: thông tin khách hàng, định dạng ngày, số tiền.
   -DatabaseAdapter:
     Kết nối với cơ sở dữ liệu để lưu, truy xuất, hoặc xóa đơn hàng.
  - Sơ đồ tuần tự (Sequence Diagram) cho ca sử dụng Timecard:
-![Diagram](https://www.planttext.com/api/plantuml/png/V98zJiGm48LxdsAK2egzG0gqX51Gh1A1H3zh3s3a_CZZHDgpKN0ahe0T9r4SLhYmxD7ttfkn_FFrVMI7rWsD4IXTPo5xw9f6C-kk9GMFJM-w2r46oEj5z5wXfUwnTP3LWvKVo5HPHVQ4BRwJdV3vdDAlQBH2vzrVo8vQHkUvsktW4XsUlVMzmjxDhcNnJ_n4r9KGIwjmk5lwo45QGaU9uAOBUyYv5JCN96i_EOpn6F40RYKh1uTjqBWE-Kmy62VGk3z5q1nh0lpQXDVLqkesAa1rbUOaerJdJv9kRrOMEJ2Ekwcl26D2MQG9F4X9pAch1vRtpI6RFEQ6rI9u6uovP88CqzN1TNjbzDJtAI8mlG5u0_H-hH97luNl-Wi00F__0m00)
4.BankSystem
-PaymentProcessor:Điều phối quy trình xử lý thanh toán qua BankSystem.Đóng vai trò giao tiếp chính với các lớp khác để xác nhận hoặc ghi nhận lỗi giao dịch.
-Paycheck:Đại diện cho phiếu lương của nhân viên, lưu thông tin như số tiền thanh toán, nhân viên nhận lương, và phương thức thanh toán.
-BankAdapter:Kết nối và giao tiếp với hệ thống ngân hàng, thực hiện gửi yêu cầu giao dịch và nhận phản hồi.
-BankSystem:Hệ thống ngân hàng bên ngoài, chịu trách nhiệm xử lý giao dịch thanh toán (Direct Deposit).Trả về trạng thái giao dịch (thành công hoặc thất bại).
-DatabaseAdapter:Lưu trữ kết quả giao dịch thanh toán và cập nhật trạng thái phiếu lương vào cơ sở dữ liệu.
- Sơ đồ tuần tự (Sequence Diagram) cho ca sử dụng BankSystem:
- 
- ![diagram](https://www.planttext.com/api/plantuml/png/d9DHQiCm38RVVGgHfnRQ2mGskX0AUolBBg0v2WjrxCoM1ptR7dQaNM59xQH94nZC3y4oto_zKkoVh--3OxJi6oLGih6GdF1YZL85sSzQKWBe81w9jYDhMRUe-SerfFbaZIJdZ0ta4CtP3FNvgSIMAM2JU0aM5yVKZDmSo97n3HrDi-NPmfby9taUl5y38M8Ni7-ysKoX3TlOpQQD-5QCJ2-O64x1aIuZ_q8VdjnKDY47uLZarQ9stPXhepSefV6QdtLbTe1DlmzYsD_NuvkiO6JlvaNc_InXLBmyXGTmNlOY0TsQDPjdAVYsHAPXU44pThdhProNoVQgpRDx3q5ShEVlqV0dql4IGMGhhn91oj6guGfhvItzp_2n4zDVbe_h5LOjnuIYkmpYq7tw9_GB003__mC0)
5.Purchase Order
- Nhân viên gửi yêu cầu mua hàng.
- Hệ thống kiểm tra tính hợp lệ của yêu cầu.
-Xử lý và gửi yêu cầu đến bộ phận tài chính.
- Employee: Gửi yêu cầu.
- PurchaseOrder: Lưu thông tin đơn hàng.
- Sơ đồ tuần tự (Sequence Diagram) cho ca sử dụng Purchase Order:
- ![Diagram](https://planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bTYSab-aO9hRa5EVcLgAbS1K3WpERCWCQz48Q2qA3aZiJZLloWbjSWbiIGn2SZXueAfLT2rmwv4mKf1oRaeDR4aLQ40Ag-G3rAWn8LTFJw3WXFBC8qXoWcX1IcOJb00Uhoaj9WSbuGK9IPdOpZ58JKl1HIEN000003__mC0)
6.View Project Details
  1. Hệ thống hiển thị danh sách dự án.
2. Người dùng chọn dự án để xem chi tiết.
3. Hiển thị các thông tin như mã dự án, tiến độ, và nhân viên tham gia.
- ProjectManagementDatabase: Cung cấp thông tin dự án.
- Sơ đồ tuần tự (Sequence Diagram) cho ca sử dụng Purchase Order:
- ![diagram](https://www.planttext.com/api/plantuml/png/UhzxlsjkGKv-PMggWgwTGa1HVbPgSeblObvYUcfkQbw9Is99Ob9YSQg2bK9GQc5fQd69GW54ZK9AQabYPaun5suzG0FXXbif1AVcfS0rvsGMbm00003__mC0)
# Mô phỏng Java cho ca sử dụng Maintain Timecard*

```java
import java.util.Map;
import java.util.*;

public class Timecard {
    private String employeeId;
    private Date startDate;
    private Date endDate;
    private Map<String, Double> hoursWorked; // Charge number -> Hours worked
    private boolean submitted;

    public Timecard(String employeeId, Date startDate, Date endDate) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hoursWorked = new HashMap<>();
        this.submitted = false;
    }

    public void addHours(String chargeNumber, double hours) {
        if (submitted) {
            throw new IllegalStateException("Cannot modify a submitted timecard.");
        }
        if (hours > 24 || hours < 0) {
            throw new IllegalArgumentException("Invalid number of hours. Must be between 0 and 24.");
        }
        hoursWorked.put(chargeNumber, hoursWorked.getOrDefault(chargeNumber, 0.0) + hours);
    }

    public void removeHours(String chargeNumber) {
        if (submitted) {
            throw new IllegalStateException("Cannot modify a submitted timecard.");
        }
        hoursWorked.remove(chargeNumber);
    }

    public void submit() {
        if (submitted) {
            throw new IllegalStateException("Timecard has already been submitted.");
        }
        this.submitted = true;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Map<String, Double> getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return "Timecard{" +
                "employeeId='" + employeeId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", hoursWorked=" + hoursWorked +
                ", submitted=" + submitted +
                '}';
    }
}
import java.util.HashMap;
import java.util.Map;

public class TimecardManager {
    private Map<String, Timecard> timecards; // EmployeeId -> Timecard

    public TimecardManager() {
        this.timecards = new HashMap<>();
    }

    public Timecard createTimecard(String employeeId, java.util.Date startDate, java.util.Date endDate) {
        if (timecards.containsKey(employeeId) && !timecards.get(employeeId).isSubmitted()) {
            throw new IllegalStateException("An unsubmitted timecard already exists for this employee.");
        }
        Timecard newTimecard = new Timecard(employeeId, startDate, endDate);
        timecards.put(employeeId, newTimecard);
        return newTimecard;
    }

    public Timecard getTimecard(String employeeId) {
        return timecards.get(employeeId);
    }

    public void submitTimecard(String employeeId) {
        Timecard timecard = timecards.get(employeeId);
        if (timecard == null) {
            throw new IllegalArgumentException("No timecard found for employee: " + employeeId);
        }
        timecard.submit();
        System.out.println("Timecard submitted for employee: " + employeeId);
    }

    public void printTimecards() {
        for (Timecard timecard : timecards.values()) {
            System.out.println(timecard);
        }
    }
}
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
     public static void main(String[] args) {
        try {
            TimecardManager manager = new TimecardManager();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Tạo timecard cho nhân viên
            Date startDate = sdf.parse("2024-10-01");
            Date endDate = sdf.parse("2024-1-07");
             Timecard timecard = manager.createTimecard("E001", startDate, endDate);

            // Thêm giờ làm vào timecard
            timecard.addHours("ProjectA", 8);
            timecard.addHours("ProjectB", 5);
            System.out.println("Updated Timecard: " + timecard);

            // Gửi timecard
            manager.submitTimecard("E001");

            // Cố gắng sửa sau khi đã gửi (sẽ báo lỗi)
            // timecard.addHours("ProjectC", 3); // Uncomment dòng này để kiểm tra lỗi

            // In danh sách tất cả timecards
            manager.printTimecards();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




   
      
