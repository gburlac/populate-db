package testData;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import conections.DB_conection;
import utils.DboPatient;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;

public class InsertInToDboPatient {


    String query = "INSERT INTO PATIENT (ID_PATIENT, FIRST_NAME, LAST_NAME, AGE, GENDER, PHONE_NUMBER" + "VALUES (?, ?, ?, ?, ?, ?)";
    String selectQuery = "Select * from PATIENT";

    DB_conection db_conection = new DB_conection();
    Connection conn = db_conection.activeConnection();
    ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();

      /*  strat.setType(DboPatient .class);
    String[] columns = new String[]{"ID_PATIENT", "FIRST_NAME", "LAST_NAME", "AGE", "GENDER, PHONE_NUMBER"};
        strat.setColumnMapping(columns);*/

    Statement stt;

    {
        try {
            stt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    CsvToBean csv = new CsvToBean();
    String csvFilename = "PATIENT.CSV";


    PreparedStatement statement;
    ResultSet rs;

    {
        try {
            rs = statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    final int batchSize = 1000;
    int count = 0;

    CSVReader csvReader;

    {
        try {
            csvReader = new CSVReader(new FileReader(csvFilename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*List list;for(Object object :list)

    {
        DboPatient dboPatient = (utils.DboPatient) object;
        try {
            statement.setString(1, dboPatient.getID_PATIENT());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(2, dboPatient.getFIRST_NAME());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(3, dboPatient.getLAST_NAME());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(4, dboPatient.getAGE());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(5, dboPatient.getGENDER());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(6, dboPatient.getPHONE_NUMBER());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (++count % batchSize == 0) {
            try {
                statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public InsertInToDboPatient() {
        list = csv.parse(strat, csvReader);
    }


        statement.executeBatch();
        System.out.println("Test data was imported to Patient ...");
        statement.close();
        conn.close();*/


}
