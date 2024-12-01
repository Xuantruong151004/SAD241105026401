import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ResultExporter {

    public void exportToHTML(List<BankTransaction> transactions, String outputFile) throws IOException {
        StringBuilder html = new StringBuilder();
        
        // Thêm CSS để cải thiện giao diện
        html.append("<html><head>");
        html.append("<style>");
        html.append("body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; color: #333; }");
        html.append("h1 { text-align: center; color: #4CAF50; }");
        html.append("h2 { color: #333; margin-top: 30px; }");
        html.append("ul { list-style-type: none; padding-left: 0; }");
        html.append("li { padding: 8px; border-bottom: 1px solid #ddd; }");
        html.append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        html.append("th, td { padding: 10px; text-align: left; border: 1px solid #ddd; }");
        html.append("th { background-color: #4CAF50; color: white; }");
        html.append("tr:nth-child(even) { background-color: #f2f2f2; }");
        html.append("</style>");
        html.append("</head><body>");

        // Tiêu đề chính
        html.append("<h1>Bank Statement Analysis Results</h1>");

        // Tổng lợi nhuận và lỗ
        double totalAmount = transactions.stream().mapToDouble(BankTransaction::getAmount).sum();
        html.append("<p><strong>Total Profit and Loss: </strong>")
            .append(String.format("%.2f", totalAmount))
            .append("</p>");

        // Số lượng giao dịch theo tháng
        html.append("<h2>Transactions Count by Month</h2><ul>");
        Map<String, Long> transactionCounts = new BankTransactionProcessor(transactions).transactionsCountByMonth();
        transactionCounts.forEach((monthYear, count) -> {
            html.append("<li><strong>").append(monthYear).append("</strong>: ").append(count).append(" transactions</li>");
        });
        html.append("</ul>");

        // Top 10 chi tiêu lớn nhất
        html.append("<h2>Top 10 Expenses</h2>");
        html.append("<table>");
        html.append("<tr><th>Date</th><th>Amount</th><th>Description</th></tr>");
        List<BankTransaction> topExpenses = new BankTransactionProcessor(transactions).topExpenses(10);
        topExpenses.forEach(transaction -> {
            html.append("<tr><td>").append(transaction.getDate()).append("</td><td>")
                .append(String.format("%.2f", transaction.getAmount())).append("</td><td>")
                .append(transaction.getDescription()).append("</td></tr>");
        });
        html.append("</table>");

        // Giao dịch nhiều nhất theo danh mục
        String mostSpentCategory = new BankTransactionProcessor(transactions).mostSpentCategory();
        html.append("<h2>Most Spent Category</h2><p>").append(mostSpentCategory).append("</p>");

        html.append("</body></html>");

        // Ghi vào file HTML
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(html.toString());
        }
    }
}
