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

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomePageController implements Initializable
{
    static String Email;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label MESSAGE;
    @FXML
    private ImageView IVF1, IVF2, IVF3, IVF4, IVF5, IVF6, LOGO;
    @FXML
    private ImageView IVD1, IVD2, IVD3, IVD4, IVD5, IVD6;
    @FXML
    private Label F1N, F2N, F3N, F4N, F5N, F6N;
    @FXML
    private Label F1P, F2P, F3P, F4P, F5P, F6P;
    @FXML
    private Label D1N, D2N, D3N, D4N, D5N, D6N;
    @FXML
    private Label D1P, D2P, D3P, D4P, D5P, D6P;
    @FXML
    private Label CEMAIL, TOTAL;

    @FXML
    private Spinner<Integer> F1S, F2S, F3S, F4S, F5S, F6S;
    @FXML
    private Spinner<Integer> D1S, D2S, D3S, D4S, D5S, D6S;

    @FXML
    private Label TOTALFOOD, TOTALFOODPRICE, TOTALDRINK, TOTALDRINKPRICE;
    private static int totf, totfp, totd, totdp;
    private int F1A, F2A, F3A, F4A, F5A, F6A, FA;
    private int D1A, D2A, D3A, D4A, D5A, D6A, DA;
    private final double FP1 = 229.0, FP2 = 210.0, FP3 = 210.0, FP4 = 255.0, FP5 = 157.0, FP6 = 560.0;
    private final double DP1 = 20.0, DP2 = 15.0, DP3 = 35.0, DP4 = 27.0, DP5 = 65.0, DP6 = 30.0;
    private double fp1, fp2, fp3, fp4, fp5, fp6;
    private double dp1, dp2, dp3, dp4, dp5, dp6;
    private final int max = 20;
    private int tf1, tf2, tf3, tf4, tf5, tf6;
    private int td1, td2, td3, td4, td5, td6;

    SpinnerValueFactory<Integer> F1AF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max);
    SpinnerValueFactory<Integer> F2AF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max);
    SpinnerValueFactory<Integer> F3AF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max);
    SpinnerValueFactory<Integer> F4AF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max);
    SpinnerValueFactory<Integer> F5AF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max);
    SpinnerValueFactory<Integer> F6AF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max);

    SpinnerValueFactory<Integer> D1AF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max);
    SpinnerValueFactory<Integer> D2AF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max);
    SpinnerValueFactory<Integer> D3AF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max);
    SpinnerValueFactory<Integer> D4AF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max);
    SpinnerValueFactory<Integer> D5AF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max);
    SpinnerValueFactory<Integer> D6AF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max);

    Image FI1 = new Image("FBurger.jpg"), FI2 = new Image("FPizza.jpg"), FI3 = new Image("FSalad.jpg"), FI4 = new Image("FSandwich.jpg"), FI5 = new Image("FNoodle.jpg"), FI6 = new Image("FChicken.jpg");
    Image DI1 = new Image("DCoffee.jpg"), DI2 = new Image("DTea.jpg"), DI3 = new Image("DSoftDrinks.jpg"), DI4 = new Image("DMakiato.jpg"), DI5 = new Image("DJuice.jpg"), DI6 = new Image("DMilk.jpg");
    Image logo = new Image("LOGO.png");



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        if(RegistrationController.UNAME != null){
            Email = RegistrationController.UNAME;
            CEMAIL.setText(Email);
        }
        else if(LoginController.UNAME != null){
            Email = LoginController.UNAME;
            CEMAIL.setText(Email);
        }
        else if(ReceiptController.CEMAIL != null)
        {
            Email = RegistrationController.UNAME;
        }

        
        IVF1.setImage(FI1); IVF2.setImage(FI2); IVF3.setImage(FI3); IVF4.setImage(FI4); IVF5.setImage(FI5); IVF6.setImage(FI6);
        IVD1.setImage(DI1); IVD2.setImage(DI2); IVD3.setImage(DI3); IVD4.setImage(DI4); IVD5.setImage(DI5); IVD6.setImage(DI6);
        LOGO.setImage(logo);

        F1P.setText(Double.toString(FP1)); F2P.setText(Double.toString(FP2)); F3P.setText(Double.toString(FP3)); F4P.setText(Double.toString(FP4)); F5P.setText(Double.toString(FP5)); F6P.setText(Double.toString(FP6));
        D1P.setText(Double.toString(DP1)); D2P.setText(Double.toString(DP2)); D3P.setText(Double.toString(DP3)); D4P.setText(Double.toString(DP4)); D5P.setText(Double.toString(DP5)); D6P.setText(Double.toString(DP6));

        F1S.setValueFactory(F1AF); F2S.setValueFactory(F2AF); F3S.setValueFactory(F3AF); F4S.setValueFactory(F4AF); F5S.setValueFactory(F5AF); F6S.setValueFactory(F6AF);
        D1S.setValueFactory(D1AF); D2S.setValueFactory(D2AF); D3S.setValueFactory(D3AF); D4S.setValueFactory(D4AF); D5S.setValueFactory(D5AF); D6S.setValueFactory(D6AF);

        F1A = F1S.getValue(); F2A = F2S.getValue(); F3A = F3S.getValue(); F4A = F4S.getValue(); F5A = F5S.getValue(); F6A = F6S.getValue();
        D1A = D1S.getValue(); D2A = D2S.getValue(); D3A = D3S.getValue(); D4A = D4S.getValue(); D5A = D5S.getValue(); D6A = D6S.getValue();


        F1S.valueProperty().addListener((observableValue, integer, t1) -> {
            tf1++;
            fp1 = F1A = tf1;
        });

        F2S.valueProperty().addListener((observableValue, integer, t1) -> {
            tf2++;
            fp2 = F2A = tf2;
        });
        F3S.valueProperty().addListener((observableValue, integer, t1) -> {
            tf3++;
            fp3 = F3A = tf3;
        });
        F4S.valueProperty().addListener((observableValue, integer, t1) -> {
            tf4++;
            fp4 = F4A = tf4;
        });
        F5S.valueProperty().addListener((observableValue, integer, t1) -> {
            tf5++;
            fp5 = F5A = tf5;
        });
        F6S.valueProperty().addListener((observableValue, integer, t1) -> {
            tf6++;
            fp6 = F6A = tf6;
        });

        ////////////////////////////////////////////////////////////////////
        D1S.valueProperty().addListener((observableValue, integer, t1) -> {
            td1++;
            dp1 = D1A = td1;
        });
        D2S.valueProperty().addListener((observableValue, integer, t1) -> {
            td2++;
            dp2 = D2A = td1;
        });
        D3S.valueProperty().addListener((observableValue, integer, t1) -> {
            td3++;
            dp3 = D3A = td3;
        });
        D4S.valueProperty().addListener((observableValue, integer, t1) -> {
            td4++;
            dp4 = D4A = td4;
        });
        D5S.valueProperty().addListener((observableValue, integer, t1) -> {
            td5++;
            dp5 = D5A = td5;
        });
        D6S.valueProperty().addListener((observableValue, integer, t1) -> {
            td6++;
            dp6 = D6A = td6;
        });


    }


    public void AF1(ActionEvent event)
    {
        totf=totf+tf1;
        TOTALFOOD.setText(Integer.toString(totf));
        fp1 = FP1 * tf1;
        totfp=(int) (totfp+fp1);
        TOTALFOODPRICE.setText(Double.toString(totfp));
        TOTAL.setText(Double.toString(totfp + totdp));

        F1AF.setValue(0);
        tf1 = 0;
    }
    public void AF2(ActionEvent event)
    {
        totf=totf+tf2;
        TOTALFOOD.setText(Integer.toString(totf));
        fp2 = FP2 * tf2;
        totfp=(int) (totfp+fp2);
        TOTALFOODPRICE.setText(Double.toString(totfp));
        TOTAL.setText(Double.toString(totfp + totdp));

        F2AF.setValue(0);
        tf2 = 0;
    }
    public void AF3(ActionEvent event)
    {
        totf=totf+tf3;
        TOTALFOOD.setText(Integer.toString(totf));
        fp3 = FP3 * tf3;
        totfp=(int) (totfp+fp3);
        TOTALFOODPRICE.setText(Double.toString(totfp));
        TOTAL.setText(Double.toString(totfp + totdp));

        F3AF.setValue(0);
        tf3 = 0;
    }
    public void AF4(ActionEvent event)
    {
        totf=totf+tf4;
        TOTALFOOD.setText(Integer.toString(totf));
        fp4 = FP4 * tf4;
        totfp=(int) (totfp+fp4);
        TOTALFOODPRICE.setText(Double.toString(totfp));
        TOTAL.setText(Double.toString(totfp + totdp));

        F4AF.setValue(0);
        tf4 = 0;
    }
    public void AF5(ActionEvent event)
    {
        totf=totf+tf5;
        TOTALFOOD.setText(Integer.toString(totf));
        fp5 = FP5 * tf5;
        totfp=(int) (totfp+fp5);
        TOTALFOODPRICE.setText(Double.toString(totfp));
        TOTAL.setText(Double.toString(totfp + totdp));

        F5AF.setValue(0);
        tf5 = 0;
    }
    public void AF6(ActionEvent event)
    {
        totf = totf + tf6;
        TOTALFOOD.setText(Integer.toString(totf));
        fp6 = FP6 * tf6;
        totfp=(int) (totfp+fp6);
        TOTALFOODPRICE.setText(Double.toString(totfp));
        TOTAL.setText(Double.toString(totfp + totdp));

        F6AF.setValue(0);
        tf6 = 0;
    }

    /////////////////////////////////////////////////////
    public void AD1(ActionEvent event)
    {
        totd = totd+td1;
        TOTALDRINK.setText(Integer.toString(totd));
        dp1 = DP1 * td1;
        totdp = (int) (totdp + dp1);
        TOTALDRINKPRICE.setText(Double.toString(totdp));
        TOTAL.setText(Double.toString(totdp + totfp));

        D1AF.setValue(0);
        td1 = 0;
    }
    public void AD2(ActionEvent event)
    {
        totd = totd+td2;
        TOTALDRINK.setText(Integer.toString(totd));
        dp2 = DP2 * td2;
        totdp = (int) (totdp + dp2);
        TOTALDRINKPRICE.setText(Double.toString(totdp));
        TOTAL.setText(Double.toString(totdp + totfp));

        D2AF.setValue(0);
        td2 = 0;
    }
    public void AD3(ActionEvent event)
    {
        totd = totd+td3;
        TOTALDRINK.setText(Integer.toString(totd));
        dp3 = DP3 * td3;
        totdp = (int) (totdp + dp3);
        TOTALDRINKPRICE.setText(Double.toString(totdp));
        TOTAL.setText(Double.toString(totdp + totfp));

        D3AF.setValue(0);
        td3 = 0;
    }
    public void AD4(ActionEvent event)
    {
        totd = totd+td4;
        TOTALDRINK.setText(Integer.toString(totd));
        dp4 = DP4 * td4;
        totdp = (int) (totdp + dp4);
        TOTALDRINKPRICE.setText(Double.toString(totdp));
        TOTAL.setText(Double.toString(totdp + totfp));

        D4AF.setValue(0);
        td4 = 0;
    }
    public void AD5(ActionEvent event)
    {
        totd = totd+td5;
        TOTALDRINK.setText(Integer.toString(totd));
        dp5 = DP5 * td5;
        totdp = (int) (totdp + dp5);
        TOTALDRINKPRICE.setText(Double.toString(totdp));
        TOTAL.setText(Double.toString(totdp + totfp));

        D5AF.setValue(0);
        td5 = 0;
    }
    public void AD6(ActionEvent event)
    {
        totd = totd+td6;
        TOTALDRINK.setText(Integer.toString(totd));
        dp6 = DP6 * td6;
        totdp = (int) (totdp + dp6);
        TOTALDRINKPRICE.setText(Double.toString(totdp));
        TOTAL.setText(Double.toString(totdp + totfp));

        D6AF.setValue(0);
        td6 = 0;
    }

    public void LogoutAction(ActionEvent event) throws Exception
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        //alert.set
        alert.setHeaderText("Are you sure you want to Logout!");

        if(alert.showAndWait().get() == ButtonType.OK)
        {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Login");
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        Email = null;
    }
    public void ClearAction(ActionEvent event)
    {
        TOTALFOOD.setText("0"); TOTALFOODPRICE.setText("0.00");
        TOTALDRINK.setText("0"); TOTALDRINKPRICE.setText("0.00");
        TOTAL.setText("0.00");

        fp1 = fp2 = fp3 = fp4 = fp5 = fp6 = 0;
        dp1 = dp2 = dp3 = dp4 = dp5 = dp6 = 0;

        F1A = F2A = F3A = F4A = F5A = F6A = 0;
        D1A = D2A = D3A = D4A = D5A = D6A = 0;

        F1AF.setValue(0); F2AF.setValue(0); F3AF.setValue(0); F4AF.setValue(0); F5AF.setValue(0); F6AF.setValue(0);
        D1AF.setValue(0); D2AF.setValue(0); D3AF.setValue(0); D4AF.setValue(0); D5AF.setValue(0); D6AF.setValue(0);

        totfp = 0; totdp = 0; totf = 0; totd = 0;
    }
//------------------------------------------------------------------------------------------------------------------

    public int getFA()
    {
        return FA;
    }
    public int getDA()
    {
        return DA;
    }
    public double getTFP()
    {
        return totfp;
    }
    public double getTDP()
    {
        return totdp;
    }
    public double getTotol()
    {
        return totfp + totdp;
    }


//------------------------------------------------------------------------------------------------------------------


    public void ConformOrderAction(ActionEvent event) throws Exception
    {
        MESSAGE.setTextFill(Color.BLACK);
        MESSAGE.setText("Requesting...");

        ServerSocket server = new ServerSocket(5001);
        System.out.println("Server Start");

        Socket socket = server.accept();

        MESSAGE.setTextFill(Color.LIGHTGREEN);
        MESSAGE.setText("Request Accepted");

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String FNP1 = "", FNP2 = "", FNP3 = "", FNP4 = "", FNP5 = "", FNP6 = "", FNP;
        String DNP1 = "", DNP2 = "", DNP3 = "", DNP4 = "", DNP5 = "", DNP6 = "", DNP;
        double Fprice, Dprice, Tprice;

        if(F1A!=0)
        {
            FNP1 = " FOOD : " + F1N.getText() + "                  Amount :  " + F1A + "\n";
        }
        if (F2A!=0)
        {
            FNP2 = " FOOD : " + F2N.getText() + "                  Amount :  " + F2A + "\n";
        }
        if (F3A!=0)
        {
            FNP3 = " FOOD : " + F3N.getText() + "                  Amount :  " + F3A + "\n";
        }
        if (F4A!=0)
        {
            FNP4 = " FOOD : " + F4N.getText() + "                  Amount :  " + F4A + "\n";
        }
        if (F5A!=0)
        {
            FNP5 = " FOOD : " + F5N.getText() + "                  Amount :  " + F5A + "\n";
        }
        if (F6A!=0)
        {
            FNP6 = " FOOD : " + F6N.getText() + "                  Amount :  " + F6A + "\n";
        }


        if(D1A!=0)
        {
            DNP1 = " Drink : " + D1N.getText() + "                 Amount :  " + D1A + "\n";
        }
        if (D2A!=0)
        {
            DNP2 = " Drink : " + D2N.getText() + "                 Amount :  " + D2A + "\n";
        }
        if (D3A!=0)
        {
            DNP3 = " Drink : " + D3N.getText() + "                 Amount :  " + D3A + "\n";
        }
        if (D4A!=0)
        {
            DNP4 = " Drink : " + D4N.getText() + "                 Amount :  " + D4A + "\n";
        }
        if (D5A!=0)
        {
            DNP5 = " Drink : " + D5N.getText() + "                 Amount :  " + D5A + "\n";
        }
        if (D6A!=0)
        {
            DNP6 = " Drink : " + D6N.getText() + "                 Amount :  " + D6A + "\n";
        }

        FA = F1A + F2A + F3A + F4A + F5A + F6A;
        DA = D1A + D2A + D3A + D4A + D5A + D6A;

        FNP = FNP1 + FNP2 + FNP3 + FNP4 + FNP5 + FNP6;
        Fprice =  totfp;

        DNP = DNP1 + DNP2 + DNP3 + DNP4 + DNP5 + DNP6;
        Dprice =  totdp;

        Tprice = (totfp + totdp);

        dos.writeUTF(Email);
        dos.writeUTF(FNP);
        dos.writeDouble(Fprice);
        dos.writeUTF(DNP);
        dos.writeDouble(Dprice);
        dos.writeDouble(Tprice);


        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Receipt.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Receipt");
        scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        TOTALFOOD.setText("0"); TOTALFOODPRICE.setText("0.00");
        TOTALDRINK.setText("0"); TOTALDRINKPRICE.setText("0.00");
        TOTAL.setText("0.00");

        fp1 = fp2 = fp3 = fp4 = fp5 = fp6 = 0;
        dp1 = dp2 = dp3 = dp4 = dp5 = dp6 = 0;

        F1A = F2A = F3A = F4A = F5A = F6A = 0;
        D1A = D2A = D3A = D4A = D5A = D6A = 0;

        F1AF.setValue(0); F2AF.setValue(0); F3AF.setValue(0); F4AF.setValue(0); F5AF.setValue(0); F6AF.setValue(0);
        D1AF.setValue(0); D2AF.setValue(0); D3AF.setValue(0); D4AF.setValue(0); D5AF.setValue(0); D6AF.setValue(0);

        totfp = 0; totdp = 0; totf = 0; totd = 0;

    }


}