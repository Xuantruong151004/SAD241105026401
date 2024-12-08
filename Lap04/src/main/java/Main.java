
import Utils.CSVTransactionImporter;
import Model.Transaction;
import Utils.CustomException;
import test.CSVTransactionImporterTest;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Đường dẫn tới file CSV
        File file = new File("D:/.net/BankStastementAnalyzerLap04/src/transactions.csv");
        // Tạo đối tượng CSVTransactionImporter để nhập dữ liệu
        CSVTransactionImporter importer = new CSVTransactionImporter();

        try {
            // Nhập các giao dịch từ file CSV
            List<Transaction> transactions = importer.importTransactions(file);

            // Hiển thị các giao dịch
            System.out.println("Danh sách các giao dịch:");
            for (Transaction transaction : transactions) {
                System.out.println("Ngày: " + transaction.getDate() +
                        ", Mô tả: " + transaction.getDescription() +
                        ", Số tiền: " + transaction.getAmount() +
                        ", Loại: " + transaction.getType());
            }

            // Tính tổng tiền giao dịch
            double totalAmount = calculateTotalAmount(transactions);
            System.out.println("\nTổng tiền giao dịch: " + totalAmount);

            // Tính tổng tiền giao dịch theo tháng
            double totalByMonth = calculateTotalAmountByMonth(transactions, "2024-12");
            System.out.println("Tổng tiền giao dịch tháng 12/2024: " + totalByMonth);

            // Tính tổng tiền giao dịch theo loại
            double totalIncome = calculateTotalAmountByType(transactions, "Income");
            double totalExpense = calculateTotalAmountByType(transactions, "Expense");
            System.out.println("Tổng tiền giao dịch theo loại Income: " + totalIncome);
            System.out.println("Tổng tiền giao dịch theo loại Expense: " + totalExpense);

        } catch (CustomException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }

    // Hàm tính tổng tiền giao dịch
    public static double calculateTotalAmount(List<Transaction> transactions) {
        double totalAmount = 0;
        for (Transaction transaction : transactions) {
            totalAmount += transaction.getAmount();
        }
        return totalAmount;
    }

    // Hàm tính tổng tiền giao dịch theo tháng
    public static double calculateTotalAmountByMonth(List<Transaction> transactions, String month) {
        double totalAmount = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getDate().startsWith(month)) {
                totalAmount += transaction.getAmount();
            }
        }
        return totalAmount;
    }

    // Hàm tính tổng tiền giao dịch theo loại
    public static double calculateTotalAmountByType(List<Transaction> transactions, String type) {
        double totalAmount = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase(type)) {
                totalAmount += transaction.getAmount();
            }
        }
        return totalAmount;
    }
}
