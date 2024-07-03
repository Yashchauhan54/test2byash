package org.example.test2yash;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class loginController {

    public TextField pd;
    public TextField un;
    public Button lgbutton;
    public Label msg;

    public void loginClick(ActionEvent actionEvent) {
        String iname= un.getText();

        String ipassword= pd.getText();
        if (iname.isEmpty()&& ipassword.isEmpty()) {
            msg.setText("Please Provide username or password");
        }
        else{
            String jdbcUrl = "jdbc:mysql://localhost:3306/test2byash";
            String dbUser = "root";
            String dbPassword = "";
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                    dbPassword)) {
                // Execute a SQL query to retrieve data from the database
                String query = "SELECT * FROM user_login_details WHERE UserName='"+iname+"'AND Password='"+ipassword+"'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    try {
                        Parent secondScene = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

                        Stage secondStage = new Stage();

                        secondStage.setTitle("User Scene");

                        secondStage.setScene(new Scene(secondScene));

                        Stage firstSceneStage = (Stage) lgbutton.getScene().getWindow();
                        firstSceneStage.close();

                        secondStage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    msg.setText("Invalid Username or password");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }}
