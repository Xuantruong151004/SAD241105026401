import java.util.List;

public class ConsoleExporter extends  ResultExporter {
    public void export(List<String> results) {
        results.forEach(System.out::println);
    }
}