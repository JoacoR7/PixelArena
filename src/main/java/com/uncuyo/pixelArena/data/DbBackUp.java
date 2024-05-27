package com.uncuyo.pixelArena.data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DbBackUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DbBackUp main = new DbBackUp();
        //main.exportTableToCSV("empresa", "C:\\Users\\joaqu\\Documents\\empresa.csv");
        //main.importTableFromCSV("C:\\Users\\joaqu\\Documents\\empresa.csv", "empresa");

    }

    public void importDataFromCSV() {
        importTableFromCSV("ruta_cliente.csv", "cliente");
        importTableFromCSV("ruta_reserva.csv", "reserva");
    }

    public void importTableFromCSV(String tableName, String filePath) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pixelarena", "postgres", "root"); FileReader fileReader = new FileReader(filePath); CSVReader csvReader = new CSVReader(fileReader)) {
            String[] nextRecord;
            // Ignorar la primera fila (encabezados de columna)
            csvReader.skip(1);
            while ((nextRecord = csvReader.readNext()) != null) {
                // Generar la sentencia SQL para insertar datos en la tabla
                String sqlQuery = generateInsertQuery(tableName, nextRecord);
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sqlQuery);
                }
            }
        } catch (SQLException | IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public String generateInsertQuery(String tableName, String[] values) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("INSERT INTO ").append(tableName).append(" VALUES (");
        for (int i = 0; i < values.length; i++) {
            queryBuilder.append("'").append(values[i]).append("'");
            if (i < values.length - 1) {
                queryBuilder.append(",");
            }
        }
        queryBuilder.append(")");
        return queryBuilder.toString();
    }

    public void exportTableToCSV(String tableName, String filePath) {
        String sqlQuery = "SELECT * FROM " + tableName;
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pixelarena", "postgres", "root"); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sqlQuery); FileWriter writer = new FileWriter(filePath)) {
            // Escribir encabezados de columna
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                writer.append(metaData.getColumnName(i));
                if (i < columnCount) {
                    writer.append(",");
                }
            }
            writer.append("\n");

            // Escribir datos
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    writer.append(resultSet.getString(i));
                    if (i < columnCount) {
                        writer.append(",");
                    }
                }
                writer.append("\n");
            }
            writer.flush();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}


