package com.example.kurs;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class f4_showhotel {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_back;

    @FXML
    private Button button_museums_and_theatres;

    @FXML
    private Text field_gym;

    @FXML
    private Text field_typeoffood;

    @FXML
    private Text field_hotelname;

    @FXML
    private ImageView field_picture;

    @FXML
    private Text field_pool;

    @FXML
    private Text field_costperday;

    constrjourney journey = new constrjourney();


    @FXML
    void initialize() {
        field_hotelname.setText(journey.get_nameofhotel());
        String pool="Нет";
        String gym="Нет";
        if (journey.get_pool()==true) {pool="Есть";}
        if (journey.get_gym()==true) {gym="Есть";}
        field_pool.setText(pool);
        field_gym.setText(gym);
        field_typeoffood.setText(journey.get_typeoffood());
        field_costperday.setText(Integer.toString(journey.get_costperday())+" руб.");

        String pathtophotoofhotel="E:\\Курсовой проект\\cities\\";
        if (journey.get_city().equals("Париж"))
        {
            pathtophotoofhotel=pathtophotoofhotel+"Paris\\picturesofhotelsofparis\\"+journey.get_nameofhotel()+".jpg";
        }
        else if (journey.get_city().equals("Рим"))
        {
            pathtophotoofhotel=pathtophotoofhotel+"Rome\\picturesofhotelsofrome\\"+journey.get_nameofhotel()+".jpg";
        }
        else
        {
            pathtophotoofhotel=pathtophotoofhotel+"Berlin\\picturesofhotelsofberlin\\"+journey.get_nameofhotel()+".jpg";
        }
        File hotelpicture= new File(pathtophotoofhotel);
        Image image = new Image(hotelpicture.toURI().toString());
        field_picture.setImage(image);


    }

    @FXML
    public void click_button_back(ActionEvent event)
    {

            button_back.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("f3_charactofhotels.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Конструктор путешествий");
            stage.setScene(new Scene(root));
            stage.show();

    }

    @FXML
    public void click_button_museums_and_theatres(ActionEvent event)
    {

            button_museums_and_theatres.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("f5_museumsandtheatres.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Конструктор путешествий");
            stage.setScene(new Scene(root));
            stage.show();

    }

}


