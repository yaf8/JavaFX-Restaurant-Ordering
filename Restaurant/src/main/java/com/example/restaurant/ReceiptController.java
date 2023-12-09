package com.example.restaurant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ReceiptController implements Initializable, tax
{
    static String CEMAIL;
    @FXML
    private ImageView LOGO;
    @FXML
    private Label FA, FTP, EMAIL;
    @FXML
    private Label DA, DTP;
    @FXML
    private Label TAX, STP, TOTALPRICE;

    Image logo = new Image("RBackground.png");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        CEMAIL = HomePageController.Email;

        LOGO.setImage(logo);
        HomePageController hpc = new HomePageController();

        FA.setText("Total Price");
        DA.setText("Total Price");

        FTP.setText((hpc.getTFP()) + " birr");
        DTP.setText((hpc.getTDP()) + " birr");

        TAX.setText((tax * 100) + " %");
        STP.setText(hpc.getTotol() + " birr");

        double totalPrice = hpc.getTotol() + (hpc.getTotol() * tax);
        TOTALPRICE.setText(totalPrice + " birr");

    }
    public void ReturnBack(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Home Page");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
