import java.util.List;
import java.util.Map;

public class MainApplication {
    public static void main(String[] args) {
        try {
            // Đường dẫn tới file dữ liệu
            String inputFile = "C:\\xampp2\\htdocs\\CNPM\\Lab3\\data\\bank_statements.csv"; 

            // Lựa chọn parser phù hợp
            TransactionParser parser;
            if (inputFile.endsWith(".csv")) {
                parser = new CSVParser();
            } else if (inputFile.endsWith(".json")) {
                parser = new JSONParser();
            } else if (inputFile.endsWith(".xml")) {
                parser = new XMLParser();
            } else {
                throw new IllegalArgumentException("Unsupported file format.");
            }

            // Phân tích dữ liệu
            List<BankTransaction> transactions = parser.parse(inputFile);

            // Xử lý giao dịch
            BankTransactionProcessor processor = new BankTransactionProcessor(transactions);

            System.out.println("1. Tong loi nhuan va lo: " + processor.calculateTotalAmount());
            System.out.println("2. So lan giao dich cua tung thang trong cac nam:");
                Map<String, Long> transactionCounts = processor.transactionsCountByMonth();
                transactionCounts.forEach((monthYear, count) -> System.out.println(monthYear + ": " + count + " transactions"));
            System.out.println("3. Top 10 chi tieu lon nhat:");
                processor.topExpenses(10).forEach(System.out::println);     
            System.out.println("4. Giao dich nhieu nhat: " + processor.mostSpentCategory());


            ResultExporter exporter = new ResultExporter();

            // Xuất kết quả ra file HTML
            exporter.exportToHTML(transactions, "output.html");

            // Thông báo thành công
            System.out.println("Ket qua đa xuat ra file HTML.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
