package restaurantreceiver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.FXMLLoader;

import java.io.DataInputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;


public class ReceiverController implements Initializable
{    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView LOGO;
    @FXML
    private Label LF, LD, TP, EMAIL;
    @FXML
    private CheckBox C;
    
    private static String UserEmail;
    private static String Freceive, Dreceive;
    private static double Fprice, Dprice, totalPrice;
    private static String Food, Drink;


    Image logo = new Image("LOGO.png");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        LOGO.setImage(logo);
        try{

            Socket socket = new Socket("127.4.3.2", 5001);

            DataInputStream din = new DataInputStream(socket.getInputStream());

            UserEmail = din.readUTF();
            Freceive = din.readUTF();
            Fprice = din.readDouble();
            Dreceive = din.readUTF();
            Dprice = din.readDouble();
            totalPrice = din.readDouble();

            Food = Freceive + "Total Food Price |      " + Fprice + " birr";
            Drink = Dreceive + "Total Drink Price |     " + Dprice + "  birr";

            LF.setText(Food);
            LD.setText(Drink);
            TP.setText("Total Price : " + (totalPrice + (totalPrice * 0.15)) + " birr");
            EMAIL.setText(UserEmail);
        
        }catch(Exception e)
        {}     
    }
    public void check(ActionEvent event)
    {
        if(C.isSelected())
        {
            LF.setTextFill(Color.LIGHTGRAY);
            LD.setTextFill(Color.LIGHTGRAY);
            TP.setTextFill(Color.LIGHTGRAY);
        }
        if(!(C.isSelected()))
        {
            LF.setTextFill(Color.BLACK);
            LD.setTextFill(Color.BLACK);
            TP.setTextFill(Color.BLACK);
        }
    }
    
    public void Refresh(ActionEvent event) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("Receiver.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Receiver");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

