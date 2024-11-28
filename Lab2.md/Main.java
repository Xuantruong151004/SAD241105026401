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
