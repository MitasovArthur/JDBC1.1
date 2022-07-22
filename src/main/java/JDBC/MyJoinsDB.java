package JDBC;

import JDBC.entity.Info;
import JDBC.entity.SelectWorkers;
import JDBC.entity.Statements;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyJoinsDB {
    private final String URL = "jdbc:mysql://127.0.0.1:3306/MyJoinsDB";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    public MyJoinsDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Info> getAllInfo() {
        Connection connection = null;
        Statement statement = null;
        List<Info> infos = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM info");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int number = resultSet.getInt("number");
                Info info = new Info(id, name, number);
                infos.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return infos;
    }

    public List<Statements> getAllStatements() {
        Connection connection = null;
        Statement statement = null;
        List<Statements> stat = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM statements");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int workers_id = resultSet.getInt("workers_id");
                String placeOfResidence = resultSet.getString("place_of_residence");
                Date dataOfBieth = resultSet.getDate("data_of_bieth");
                String maritalStatus = resultSet.getString("marital_status");
                Statements statement1 = new Statements(id, workers_id, placeOfResidence, dataOfBieth, maritalStatus);
                stat.add(statement1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return stat;
    }



    public List<SelectWorkers> getInfoWorkers() {
        Connection connection = null;
        Statement statement = null;
        List<SelectWorkers> infoWorkers = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select statements.data_of_bieth, info.number\n" +
                    "from statements inner join info\n" +
                    "on statements.id=info.id\n" +
                    "where statements.marital_status='unmarried'");

            while (resultSet.next()) {
                Date dataOfBieth = resultSet.getDate("data_of_bieth");
                int number = resultSet.getInt("number");
                SelectWorkers sw= new SelectWorkers(dataOfBieth,number);
                infoWorkers.add(sw);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return infoWorkers;
    }
}

