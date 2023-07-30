package com.example.kurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class f1_mainmenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_begin;

    @FXML
    private Button button_finish;

    @FXML
    private Button button_inform;

    @FXML
    private ImageView field_picture;

    @FXML
    public void initialize() throws IOException {
        //добавление фото на форму
        File mainpicture= new File("E:\\Курсовой проект\\mainmenu.jpg");
        Image image = new Image(mainpicture.toURI().toString());
        field_picture.setImage(image);
    }
    @FXML
    public void click_button_begin(ActionEvent event)
    {

            button_begin.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("f2_plan.fxml"));
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
    public void click_button_inform(ActionEvent event)
    {

            button_inform.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("information.fxml"));
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
    public void click_button_finish(ActionEvent event)
    {

            button_finish.getScene().getWindow().hide();


    }


}

