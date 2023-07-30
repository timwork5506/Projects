package com.example.kurs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class information {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_mainmenu;



    @FXML
    void initialize() {

    }

    @FXML
    public void click_button_mainmenu(ActionEvent event)
    {

            button_mainmenu.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("f1_mainmenu.fxml"));
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
