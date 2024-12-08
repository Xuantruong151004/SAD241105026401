package Utils;

import java.util.List;

import Model.Transaction;

public interface TransactionExporter {
    String exportTransactions(List<Transaction> transactions) throws CustomException;
}
