# Lab 3. Identify design elements
-Xác định các phần tử thiết kế của hệ thống “Payroll System”

1.Subsystem context diagrams
-Biểu đồ ngữ cảnh cho BankSystem
-![Diagram](https://www.planttext.com/api/plantuml/png/pLEnJiCm4Dqj-H-iCj0CKVSgYaeHGoI6YaoCnhYjXMD7lWiG0V-ExP8qRWipsvtzxkwzy_CAa3li6at9DRkr1ftreT0SWCqslFUfhdj0sSmO1vQSiA8GXugoP1-KCBPOC93cEU8QQP1L1j1r0fKrGCaN9M5CPL2wBHUI4ZM4h5fpyr9BzwfyKXGZPcZTEYiam4_ZEPzqPijXtkGm2qKxYJT2sCxWccjkX9nd7fmU1LmWNIFtccBlCVJWI6l8ir53tJt1OGaRPz_xSMKHVjpNCVMQOAnfGurNTdMlTdjyb5hRjtyfyywWmb7T-NYlIaP8MPw0l9UsoZNy5rHAxW8W8PJS1ruFKiVEi5UjDrPgopmlKpij_tHbwhpFF9-y6YMJ5mnzBwWxmvmk_kGwKKR9obEB_-yR "BankSystem")
-Giải thích các thành phần trong biểu đồ:
  + PayrollSystem (Control):
      Đây là thành phần điều khiển chịu trách nhiệm gửi yêu cầu thanh toán (Payment Instructions) đến giao diện ngân hàng (IBankService).
  + PaymentInstruction (Entity):
      Chứa thông tin giao dịch thanh toán, bao gồm:
      Số tài khoản người nhận.
      Số tiền cần thanh toán.
      Ngày thực hiện giao dịch.
  + IBankService (Interface):
      Là giao diện trung gian giữa hệ thống xử lý lương (PayrollSystem) và hệ thống ngân hàng (BankSystem).
  + BankSystem (Subsystem Proxy):
      Là hệ thống con thực hiện các tác vụ thực tế liên quan đến giao dịch ngân hàng.
  + PaymentConfirmation (Entity):
      Xác nhận giao dịch sau khi thanh toán được xử lý thành công.
  + AccountBalance (Entity):
      Lưu trữ thông tin số dư tài khoản hiện tại.
  + BankStatement (Entity):
    Là bản sao kê ngân hàng, chứa thông tin chi tiết về các giao dịch đã thực hiện.
-Biểu đồ ngữ cảnh cho PrintService:
-![diagram](https://www.planttext.com/api/plantuml/png/Z9DDRi8m48NtEOML5KWD1uYgYWLTP8UK4mpEG2qSEx8d4QZbP5rm9AvGvyUDGr2fLoFFyyoNDvFRztLj2GpLfOmgu4Su88lpUcVFbh1aMwDFvvXzHimTBi5QToKKvMWQmN58zATg4nlDwn8LBOeXI9c_UkaLQDA-1ffboXejYg06_q1-x3iGK6qNmvEiI5bEBZuiVT2zkaINQEH-LoJe3jTtdw1wkB5ioA1TnnPybjbhKy8yaIH986f0YW88Vvrmn3kj9O8QaE_DH3FtCVpa86SxLnuafEP0GgidSCzc54vawctMCks1exTN-0kM_NCbOFDW9xJQ_h4L7SEaV9AyZJDDMLmPpT5QjF5SvzrrihfJJ4bVlrQhwJexeIWhYMrn9r-ZAjeVumS00F__0m00)

-Giải thích các thành phần trong biểu đồ:
+ PrintService:
  Quản lý các yêu cầu in tài liệu và sử dụng máy in.
  Phương thức:
    printDocument: Thực hiện việc in tài liệu.
    checkPrintStatus: Kiểm tra trạng thái của máy in.
+ IPrintService (Interface):
  Giao diện cho phép các hệ thống khác giao tiếp với PrintService.
  Phương thức:
    printDocument: Yêu cầu PrintService in tài liệu.
+ Document (Entity):
    Đại diện cho tài liệu cần in, bao gồm thông tin như mã tài liệu, nội dung và định dạng.
    Phương thức:
      validateDocument: Kiểm tra tính hợp lệ của tài liệu.
+ Printer (Entity):
  Đại diện cho máy in, bao gồm các thông tin như trạng thái và vị trí.
  Phương thức:
  printDocument: Thực hiện việc in tài liệu.
 - Biểu đồ ngữ cảnh cho ProjectManagementDatabase subsystems:
 - ![diagram](https://www.planttext.com/api/plantuml/png/h5D1JiCm4Bpd5LPEhOJxW0YX7i8X1n1INx29jv71TY9xNQYWB-F0a_W2Jfg8H0u8fFfaxSxCUcVNd-yVMqTWoMkLj50zGOqitVdI7HsXPW-sUJccx3LXuLGAdEj2ZrZH7PY0rMWe1u8I70weywcH1c1Xzisg7UuYOpkoqjJhR1Jgw1EYRmKGJd8nzue52Cm4WjoXaQBNEIMdvBkNMqEIbbleYBD7HvNYt3reNCYMNeIECoOQNogS98Avv5t4u9mlcfKZWLHkjLweCNTc01fyplzkHc48xHug7FsGOu0L4u5BJBCl_FEkS7up6qF6Kej12m_eql_nphu4LjJ2zTjcyyk-1gxKhUg3WRv58xfly0K00F__0m00)
 - Giải thích các thành phần trong biểu đồ:
  - ProjectManagementDatabase:
    Cung cấp và cập nhật thông tin dự án.
  Phương thức:
    getProjectInfo: Lấy thông tin dự án.
    updateProjectData: Cập nhật thông tin dự án.
  - ProjectData (Entity):
    Lưu trữ thông tin dự án (mã dự án, tên dự án, ngân sách, trạng thái).
   Phương thức:
    getProjectDetails: Trả về chi tiết dự án.
    updateProjectDetails: Cập nhật thông tin dự án.
  - IProjectDatabase (Interface):
      Giao diện để các hệ thống truy vấn thông tin dự án từ ProjectManagementDatabase.
    Phương thức:
      getProjectInfo: Lấy thông tin dự án.
    
2.Analysis class to design element map

-ánh xạ các lớp phân tích đến các phần tử thiết kế:

---

| **Analysis Class**             | **Design Element**              |
|--------------------------------|---------------------------------|
| **LoginForm**                  | **LoginForm**                   |
| **MaintainTimecardForm**       | **MainEmployeeForm**            |
|                                | **TimecardForm**                |
|                                |  **MainApplicationForm**        |
| **TimecardController**         | **TimecardController**          |
| **SystemClockInterface**       | **SystemClockInterface**        |
| **PayrollController**          | **PayrollController**           |
| **Paycheck**                   | **Paycheck**                    |
| **PaymentInstruction**         | **PaymentInstruction**          |
| **Employee**                   | **Employee**                    |
| **IEmployeeRepository**        | **IEmployeeRepository**         |
| **IPaymentRepository**         | **IPaymentRepository**          |
| **BankSystem**                 | **BankSystem**                  |
| **IBankSystem**                | **IBankSystem**                 |
| **ProjectManagementDatabase**  | **ProjectManagementDatabase**   |
| **IProjectDatabase**           | **IProjectDatabase**            |
| **ProjectData**                | **ProjectData**                 |

---

3.Design element to owning package map

-Hãy ánh xạ các phần tử thiết kế vào các gói:

| **Design Element**        | **"Owning" Package**                        |
|---------------------------|--------------------------------------------|
| **UserInterface**          | Middleware::Presentation::GUI Framework    |
| **PayrollController**      | Applications::Payroll::BusinessLogic       |
| **TimecardController**     | Applications::Payroll::BusinessLogic       |
| **EmployeeRepository**     | DataAccess::Employee::Repository           |
| **PaymentRepository**      | DataAccess::Payment::Repository            |
| **Database**               | DataAccess::Database::Connection           |
| **Paycheck**               | BusinessServices::Payroll::Artifacts       |
| **PaymentInstruction**     | BusinessServices::Payroll::Artifacts       |
| **IEmployeeRepository**    | Interfaces::Employee::RepositoryInterface  |
| **IPaymentRepository**     | Interfaces::Payment::RepositoryInterface   |
| **IBankSystem**            | Interfaces::Bank::SystemInterface          |
| **IProjectDatabase**       | Interfaces::Project::DatabaseInterface     |
| **BankSystem**             | Subsystems::Bank::PaymentProcessing        |
| **ProjectManagementDatabase** | Subsystems::Project::DatabaseManagement |
| **ProjectData**            | BusinessServices::Project::DataArtifacts   |


4.Architectural layers and their dependencies

- ![PlanText](https://www.planttext.com/api/plantuml/png/X59BJiCm4Dtx54Cth7g1Bb1_4Pk0AW8769nfCNNioEDKYe2JiU18N04xAKb_KRsnv9dtbN-_VwRiqVcgqE8cfxKo14_9uddsU9yc83Ko2t4BotQYiIR7eaIvnGt1QEM8oNZqoXf8ut047mB2wJbMM3khzS8Q7szoualq3FEA0p4pf7QZv227KyPdv7PAqibeZcQRrUofECFOTvB-0KqGAeBB9NfyHQOZ_VW8CoaR2vV5awBKjgPJuP2BjIeZMzUF8zrqmM-gP76M7CRZpxkZC3215wR1rJxSbSN1i1tkKBIt4V0JoCZa37bimbjneDdi_SSFYq4b5aKCPMj33EjUmEvK7g4jfD6xXjztl0_HGPLPss0L96fPXSP9J4E4-8N_0000__y30000")
  





