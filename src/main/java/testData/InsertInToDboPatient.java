package testData;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import conections.DB_conection;
import utils.DboPatient;

import java.sql.Connection;

public class InsertInToDboPatient {

    public void importCSVforPatient() {
        String query = "INSERT INTO PATIENT (ID_PATIENT, FIRST_NAME, LAST_NAME, AGE, GENDER, PHONE_NUMBER" + "VALUES (?, ?, ?, ?, ?, ?)";
        String selectQuery = "Select * from PATIENT";

        DB_conection db_conection = new DB_conection();
        Connection conn = db_conection.activeConnection();
        ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();

        strat.setType(DboPatient.class);
        String[] columns = new String[]{"ID_PATIENT", "FIRST_NAME", "LAST_NAME", "AGE", "GENDER, PHONE_NUMBER"};
        strat.setColumnMapping(columns);

    }
}
