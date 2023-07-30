package com.example.kurs;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class f5_museumsandtheatres {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_back;

    @FXML
    private Button button_finalsum;

    @FXML
    private CheckBox checkbox_1museum;

    @FXML
    private CheckBox checkbox_1theatre;

    @FXML
    private CheckBox checkbox_2museum;

    @FXML
    private CheckBox checkbox_2theatre;

    @FXML
    private CheckBox checkbox_3museum;

    @FXML
    private CheckBox checkbox_3theatre;


    city citydata = new city();
    constrjourney journey = new constrjourney();

    @FXML
    void initialize() {
        checkbox_1museum.setText(citydata.get_nameofmuseum().get(0));
        checkbox_2museum.setText(citydata.get_nameofmuseum().get(1));
        checkbox_3museum.setText(citydata.get_nameofmuseum().get(2));

        checkbox_1theatre.setText(citydata.get_nameoftheatre().get(0));
        checkbox_2theatre.setText(citydata.get_nameoftheatre().get(1));
        checkbox_3theatre.setText(citydata.get_nameoftheatre().get(2));
    }


    @FXML
    public void click_button_back(ActionEvent event)
    {

            button_back.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("f4_showhotel.fxml"));
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
    public void click_button_button_finalsum(ActionEvent event)
    {
            set_theatres_and_museums();
            journey.show_journey_data();
            button_finalsum.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("f6_finalsum.fxml"));
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

    public void set_theatres_and_museums()
    {

        if (checkbox_1theatre.isSelected())
        {
            journey.set_theatre(citydata.get_nameoftheatre().get(0), citydata.get_ticketpriceoftheatre().get(0),
                    journey.get_datebegintrip()

                    );

        }
        if (checkbox_2theatre.isSelected())
        {
            journey.set_theatre(citydata.get_nameoftheatre().get(1), citydata.get_ticketpriceoftheatre().get(1),
                    journey.get_datebegintrip().plusDays(1)
                    );
        }
        if (checkbox_3theatre.isSelected())
        {
            journey.set_theatre(citydata.get_nameoftheatre().get(2), citydata.get_ticketpriceoftheatre().get(2),
                    journey.get_datebegintrip().plusDays(2)
                    );
        }

        if (checkbox_1museum.isSelected())
        {
            journey.set_museum(citydata.get_nameofmuseum().get(0), citydata.get_ticketpriceofmuseum().get(0));
        }
        if (checkbox_2museum.isSelected())
        {
            journey.set_museum(citydata.get_nameofmuseum().get(1), citydata.get_ticketpriceofmuseum().get(1));
        }
        if (checkbox_3museum.isSelected())
        {
            journey.set_museum(citydata.get_nameofmuseum().get(2), citydata.get_ticketpriceofmuseum().get(2));
        }

    }

}
