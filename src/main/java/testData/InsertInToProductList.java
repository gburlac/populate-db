package testData;


import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import conections.DB_conection;
import utils.ProductList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertInToProductList {
    public void importCSV() {
        String querryInsertProdList = "INSERT INTO Product_List (Product_ID, Name, Desctription, Cost" + "Values (?, ?, ?, ?)";

        DB_conection dbConection = new DB_conection();
        Connection conn = dbConection.activeConnection();
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(ProductList.class);
        String[] columns = new String[]{"Product_ID", "Name", "Description", "Cost"};
        strategy.setColumnMapping(columns);

        CsvToBean csv = new CsvToBean();
        String csvFilename = "ProductList";

        try {
            PreparedStatement statement = conn.prepareStatement(querryInsertProdList);
            final int batchSize = 1000;
            int count = 0;

            CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
            List list = csv.parse(strategy, csvReader);
            for (Object object : list) {
                ProductList productList = (ProductList) object;
                statement.setString(1, productList.getProduct_ID());
                statement.setString(2, productList.getName());
                statement.setString(3, productList.getDescription());
                statement.setString(4, productList.getCost());
                statement.addBatch();
                if (++count % batchSize == 0) {
                    statement.executeBatch();
                }
            }
            statement.executeBatch();
            System.out.println("Test data iported to ProductList...");
            statement.close();
            conn.close();

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        dbConection.dbClose();


    }
}
