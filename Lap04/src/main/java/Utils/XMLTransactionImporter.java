package Utils;

import Model.Transaction;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class XMLTransactionImporter {

    public List<Transaction> importTransactions(File file) throws CustomException {
        List<Transaction> transactions = new ArrayList<>();

        try {
            // Tạo đối tượng DocumentBuilder để phân tích cú pháp XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Đọc file XML và tạo Document object
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            // Lấy tất cả các node <transaction>
            NodeList nodeList = document.getElementsByTagName("transaction");

            // Duyệt qua từng node <transaction>
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Lấy thông tin các phần tử trong node
                    String id = element.getElementsByTagName("id").item(0).getTextContent();
                    String description = element.getElementsByTagName("description").item(0).getTextContent();
                    double amount = Double.parseDouble(element.getElementsByTagName("amount").item(0).getTextContent());
                    String date = element.getElementsByTagName("date").item(0).getTextContent();
                    String Type = element.getElementsByTagName("type").item(0).getTextContent();
                    // Tạo đối tượng Transaction và thêm vào danh sách
                    transactions.add(new Transaction(id, amount, date,Type));
                }
            }

        } catch (Exception e) {
            throw new CustomException("Error reading XML file.", e);
        }

        return transactions;
    }
}
