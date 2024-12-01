import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLExporter extends ResultExporter {

    public void export(List<String> results) throws Exception {
        // Tạo file HTML
        File htmlFile = new File("results.html");

        // Nếu file không tồn tại, tạo mới file
        if (!htmlFile.exists()) {
            htmlFile.createNewFile();
        }

        // Ghi vào file HTML
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFile))) {
            // Viết phần đầu HTML
            writer.write("<html>");
            writer.write("<head><title>Bank Statement Analysis Results</title></head>");
            writer.write("<body>");
            writer.write("<h1>Analysis Results</h1>");

            // Viết kết quả vào file dưới dạng danh sách
            writer.write("<ul>");
            for (String result : results) {
                writer.write("<li>" + result + "</li>");
            }
            writer.write("</ul>");

            // Viết phần kết thúc HTML
            writer.write("</body>");
            writer.write("</html>");
        } catch (IOException e) {
            throw new Exception("Error writing to HTML file: " + e.getMessage());
        }

        System.out.println("Results have been exported to results.html");
    }
}
