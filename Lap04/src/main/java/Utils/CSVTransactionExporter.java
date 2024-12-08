package Utils;

import java.util.List;

import Model.Transaction;

public class CSVTransactionExporter implements TransactionExporter {

    @Override
    public String exportTransactions(List<Transaction> transactions) throws CustomException {
        StringBuilder csvBuilder = new StringBuilder();

        // Thêm header
        csvBuilder.append("Description,Amount,Date,Type\n");

        // Thêm dữ liệu giao dịch
        for (Transaction transaction : transactions) {
            csvBuilder.append(transaction.getDescription()).append(",")
                    .append(transaction.getAmount()).append(",")
                    .append(transaction.getDate()).append(",")
                    .append(transaction.getType()).append("\n");

        }

        // Trả về chuỗi CSV
        return csvBuilder.toString();
    }
}
