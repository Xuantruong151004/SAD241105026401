package Utils;

import java.io.File;
import java.util.List;
import Model.Transaction;

public interface TransactionImporter {
    /**
     * Nhập danh sách giao dịch từ file.
     *
     * @param file File đầu vào chứa dữ liệu giao dịch.
     * @return Danh sách các giao dịch.
     * @throws CustomException Nếu có lỗi khi xử lý file.
     */
    List<Transaction> importTransactions(File file) throws CustomException;
}
