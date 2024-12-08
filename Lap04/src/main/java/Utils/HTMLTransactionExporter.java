package Utils;

import java.util.List;

import Model.Transaction;

public class HTMLTransactionExporter implements TransactionExporter {

    @Override
    public String exportTransactions(List<Transaction> transactions) throws CustomException {
        StringBuilder htmlBuilder = new StringBuilder();

        // Tạo phần đầu trang HTML
        htmlBuilder.append("<html><body>");
        htmlBuilder.append("<h1>Transaction Report</h1>");
        htmlBuilder.append("<table border='1'>");
        htmlBuilder.append("<tr><th>Description</th><th>Amount</th><th>Date</th></tr>");

        // Thêm dữ liệu giao dịch vào bảng
        for (Transaction transaction : transactions) {
            htmlBuilder.append("<tr>");
            htmlBuilder.append("<td>").append(transaction.getDescription()).append("</td>");
            htmlBuilder.append("<td>").append(transaction.getAmount()).append("</td>");
            htmlBuilder.append("<td>").append(transaction.getDate()).append("</td>");
            htmlBuilder.append("<td>").append(transaction.getType()).append("</td>");
            htmlBuilder.append("</tr>");
        }

        // Đóng bảng và body HTML
        htmlBuilder.append("</table>");
        htmlBuilder.append("</body></html>");

        // Trả về chuỗi HTML
        return htmlBuilder.toString();
    }
}
