package com.example.restaurant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable
{
    @FXML
    private ImageView LOGO;
    static String UNAME = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label MESSAGE;

    @FXML
    private TextField EMAIL;

    @FXML
    private PasswordField PASSWORD;


    @FXML
    private void LoginAction(ActionEvent event) throws Exception
    {
        String email = EMAIL.getText();
        String pass = PASSWORD.getText();

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
        Statement stmt = con.createStatement();

        String SQL = "select count(1) from customer where Email = '" + email + "' and  Password = '" + pass + "'";
        //String SQL2 = "Select * from customer where Email = '" + email + "' and Password = '" + pass + "'";

        ResultSet rs = stmt.executeQuery(SQL);

        if(email.isEmpty() && pass.isEmpty())
        {
            MESSAGE.setTextFill(Color.RED);
            MESSAGE.setText("Please enter your Email and Password");
        }
        else if(email.isEmpty())
        {
            MESSAGE.setTextFill(Color.web("#ff2121"));
            MESSAGE.setText("Please enter your Email");
        }
        else if(pass.isEmpty())
        {
            MESSAGE.setTextFill(Color.web("#ff2121"));
            MESSAGE.setText("Please enter you Password");
        }
        else
        {
            while(rs.next())
            {
                //String e = rs.getString("Email");
                //String p = rs.getString("Password");
                //if(e.equals(email) && p.equals(pass))
                if(rs.getInt(1) == 1)
                {
                    UNAME = email;
                    MESSAGE.setTextFill(Color.web("#08ff1d"));
                    MESSAGE.setText("Login Successfully!");

                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.fxml")));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setTitle("Home Page");
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                else
                {
                    MESSAGE.setTextFill(Color.web("#ff2121"));
                    MESSAGE.setText("User not found!");
                }
            }
        }
        stmt.close();
    }

    public void GetRegisteredAction(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Registration.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Get registered");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    Image logo = new Image("LOGO.png");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LOGO.setImage(logo);
    }
}