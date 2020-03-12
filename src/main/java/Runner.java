import testData.CSV_generator_for_import;
import testData.InsertInToProductList;

public class Runner {
    public static void main(String[] args) {
        int rowNum = 10;
        CSV_generator_for_import csvGeneratorForImport = new CSV_generator_for_import();
        csvGeneratorForImport.createCSVforProxy(rowNum);
        InsertInToProductList test_import = new InsertInToProductList();
        test_import.importCSV();
    }
}
