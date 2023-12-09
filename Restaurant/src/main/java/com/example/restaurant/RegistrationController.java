package com.example.restaurant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable
{
    @FXML
    private ImageView LOGO;
    static String UNAME = null;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField FNAME;
    @FXML
    private TextField LNAME;
    @FXML
    private TextField EMAIL;
    @FXML
    private TextField PHONE;
    @FXML
    private RadioButton MALE, FEMALE;
    @FXML
    private TextField SUBCITY;
    @FXML
    private TextField WOREDA;
    @FXML
    private TextField HOUSE;
    @FXML
    private PasswordField PASSWORD;
    @FXML
    private PasswordField RE_PASSWORD;
    @FXML
    private Label MESSAGE;
    @FXML
    private CheckBox TERMANDCONDITION;

    public void TermAndConditions(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TermAndCondition.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void LoginAction(ActionEvent event) throws IOException
    {
        //System.out.println("Register Now");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void RegisterNowAction(ActionEvent event) throws Exception
    {
        //System.out.println("Login Action");
        String fname = FNAME.getText();
        String lname = LNAME.getText();
        String email = EMAIL.getText();
        String Phone = PHONE.getText();
        String phone = "+251" + Phone;
        String gender = "M";
        if (MALE.isSelected())
            gender = "M";
        else if (FEMALE.isSelected())
            gender = "F";
        String subcity = SUBCITY.getText();
        String woreda = WOREDA.getText();
        String house = HOUSE.getText();
        String password = PASSWORD.getText();
        String re_password = RE_PASSWORD.getText();


        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || Phone.isEmpty() || subcity.isEmpty() || woreda.isEmpty() || house.isEmpty() || password.isEmpty() || re_password.isEmpty())
        {
            MESSAGE.setTextFill(Color.web("#ff2121"));
            MESSAGE.setText("Please Fill out the form Correctly!");
        } else if (!(TERMANDCONDITION.isSelected()))
        {
            MESSAGE.setTextFill(Color.web("#ff2121"));
            MESSAGE.setText("Agree with the TERM AND CONDITIONS!");
        }
        else
        {
            if(!(password.equals(re_password)))
            {
                MESSAGE.setTextFill(Color.web("#ff2121"));
                MESSAGE.setText("Password doesn't Match!");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");

                Statement stmt = con.createStatement();

                String registerDB = "INSERT INTO `customer` (`ID`, `Fname`, `Lname`, `Email`, `Phone`, `Gender`, `Subcity`, `Woreda`, `HouseNO`, `Password`) VALUES (NULL, '"+fname+"', '"+lname+"', '"+email+"', '"+phone+"', '"+gender+"', '"+subcity+"', '"+woreda+"', '"+house+"', '"+password+"');";
                stmt.execute(registerDB);

                UNAME = email;
                MESSAGE.setTextFill(Color.GREEN);
                MESSAGE.setText("Registered Successfully!");

                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.fxml")));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setTitle("Home Page");
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
        }
    }

    Image logo = new Image("LOGO.png");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LOGO.setImage(logo);
    }
}
