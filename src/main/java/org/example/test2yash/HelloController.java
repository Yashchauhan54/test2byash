package org.example.test2yash;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public TableView<patient_record> producttable;
    public TableColumn<patient_record,Integer> RecordID;
    public TableColumn<patient_record, String> PatientName;
    public TableColumn<patient_record, String> Diagnosis;
    public TableColumn<patient_record, String> Treatment;
    public Label welcomeText;
    public TextField gid;
    public TextField gname;
    public TextField gdiag;
    public TextField gtreat;



    ObservableList<patient_record> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RecordID.setCellValueFactory(new
                PropertyValueFactory<patient_record, Integer>("RecordID"));
        PatientName.setCellValueFactory(new
                PropertyValueFactory<patient_record, String>("PatientName"));
        Diagnosis.setCellValueFactory(new
                PropertyValueFactory<patient_record, String>("Diagnosis"));
        Treatment.setCellValueFactory(new
                PropertyValueFactory<patient_record, String>("Treatment"));
        producttable.setItems(list);
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
        fetchdata();
    }

    private void fetchdata() {
        list.clear();
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/test2byash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM patient_record";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int RecordID = resultSet.getInt("RecordID");
                String PatientName = resultSet.getString("PatientName");
                String Diagnosis = resultSet.getString("Diagnosis");
                String Treatment = resultSet.getString("Treatment");
                producttable.getItems().add(new patient_record(RecordID,PatientName, Diagnosis, Treatment));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(ActionEvent actionEvent) {
        String PatientName = gname.getText();
        String Diagnosis = gdiag.getText();
        String Treatment = gtreat.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/test2byash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `patient_record`( `PatientName`, `Diagnosis`, `Treatment`) VALUES ('"+PatientName+"','"+Diagnosis+"','"+Treatment+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();



        }


    }

    public void update(ActionEvent actionEvent) {
        String RecordID = gid.getText();
        String PatientName = gname.getText();
        String Diagnosis = gdiag.getText();
        String Treatment = gtreat.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/test2byash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `patient_record` SET `PatientName`='"+PatientName+"',`Diagnosis`='"+Diagnosis+"',`Treatment`='"+Treatment+"' WHERE RecordID='"+RecordID+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Delete(ActionEvent actionEvent) {
        String RecordID = gid.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/test2byash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `patient_record` WHERE RecordID='"+RecordID+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loaddata(ActionEvent actionEvent) {
        String RecordID = gid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/test2byash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM patient_record WHERE RecordID='" + RecordID + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String PatientName = resultSet.getString("PatientName");
                String Diagnosis = resultSet.getString("Diagnosis");
                String Treatment = resultSet.getString("Treatment");

                gname.setText(PatientName);
                gdiag.setText(Diagnosis);
                gtreat.setText(Treatment);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void truncate(ActionEvent actionEvent) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/test2byash";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "Truncate patient_record";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();



        }

    }
}



