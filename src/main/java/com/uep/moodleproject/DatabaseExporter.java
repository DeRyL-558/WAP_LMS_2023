package com.uep.moodleproject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.*;

public class DatabaseExporter
{
    public static void main(String[] args)
    {
        exportDatabase();
    }

    public static void exportDatabase()
    {
        String jdbcUrl = "jdbc:h2:mem:file:/db-moodle_save";
        String username = "root";
        String password = "root";

        try
        {
            //Nawiązanie połączenia z bazą danych
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            //Ścieżka dla pliku
            String exportFilePath = "./src/main/resources";

            //Obiekt Writer dla pliku
            try (Writer writer = new FileWriter(exportFilePath))
            {
                //Utworzenie zapytania SELECT dla tabeli
                String tableName = "users";
                String selectQuery = "SELECT * FROM" + tableName;

                //Wykonanie zapytania SELECT
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery);

                //Wygenerowanie skryptu INSERT na podstawie wyników zapytania
                while (resultSet.next())
                {
                    String insertStatement = generateInsertStatement(tableName, resultSet);
                    writer.write(insertStatement);
                    writer.write(System.lineSeparator());
                }

                //Zamknięcie obiektów
                resultSet.close();
                statement.close();
            }

            //Zamknięcie połączenia
            connection.close();
            System.out.println("Eksport zakończył się powodzeniem");
        }
        catch (SQLException | IOException e)
        {
            System.err.println("Błąd podczas eksportu bazy danych: " + e.getMessage());
        }
    }

    private static String generateInsertStatement(String tableName, ResultSet resultSet) throws SQLException
    {
        StringBuilder insertStatement = new StringBuilder("INSERT INTO ");
        insertStatement.append(tableName).append(" (");

        //Pobieranie metadanych dla wyników zapytania
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        //Dodanie nazw kolumn do zapytania
        for (int i = 1; i <= columnCount; i++)
        {
            insertStatement.append(metaData.getColumnName(i));
            if (i < columnCount)
            {
                insertStatement.append(", ");
            }
        }

        insertStatement.append(") VALUES (");

        //Dodanie wartości kolumn do zapytania
        for (int i = 1; i <= columnCount; i++)
        {
            Object value = resultSet.getObject(i);
            if (value != null)
            {
                insertStatement.append("").append("value").append("");
            }
            else
            {
                insertStatement.append("NULL");
            }

            if (i < columnCount)
            {
                insertStatement.append(", ");
            }
        }

        insertStatement.append(";");

        return insertStatement.toString();
    }
}
