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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class f3_charactofhotels {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_back;

    @FXML
    private Button button_showvariants;

    @FXML
    private ComboBox<String> field_food;

    @FXML
    private ComboBox<String> field_gym;

    @FXML
    private ComboBox<String> field_pool;

    @FXML
    private ComboBox<String> field_stars;


    city citydata=new city();
    constrjourney journey=new constrjourney();


    @FXML
    void initialize() {
            //количество звёзд у отеля
            field_stars.getItems().addAll(
                    "4",
                         "5"
            );
            field_stars.setEditable(false);
            field_stars.setValue("4");

            //наличие бассейна
            field_pool.getItems().addAll(
                    "Не важно",
                         "Есть"
            );
            field_pool.setEditable(false);
            field_pool.setValue("Не важно");

            //наличие спортзала
            field_gym.getItems().addAll(
                    "Не важно",
                         "Есть"
            );
            field_gym.setEditable(false);
            field_gym.setValue("Не важно");

            //тип питания
            field_food.getItems().addAll(
                    "Завтрак",
                    "Завтрак, ужин",
                    "Всё включено"
            );
            field_food.setEditable(false);
            field_food.setValue("Завтрак");


    }


    public void choosehotel()
    {
        boolean check_pool=false;
        boolean check_gym=false;

        if (field_pool.getValue().equals("Есть")) {check_pool=true;}
        if (field_gym.getValue().equals("Есть")) {check_gym=true;}

        int indexofhotelbycriteria=0;
        int indexfood=0;
        int minsumperday=citydata.get_costperday().get(0);

        for(int i =0; i<citydata.get_stars().size(); i++)
        {
            if (citydata.get_stars().get(i)==Integer.parseInt(field_stars.getValue())) {
                System.out.println("сравнение звезд");
                if (citydata.get_pool().get(i) == check_pool) {
                    System.out.println("сравнение бассейна");
                    System.out.println(check_pool);
                    if (citydata.get_gym().get(i) == check_gym) {
                        System.out.println("сравнение зала");
                        System.out.println(check_gym);
                        if (citydata.get_costperday().get(i)<=minsumperday)
                        {
                            System.out.println("сравнение цены");
                            indexofhotelbycriteria=i;
                            int razm;
                            razm=citydata.get_typeoffood().size()/citydata.get_stars().size();
                            for(int j=indexofhotelbycriteria*razm;j<indexofhotelbycriteria*razm+razm;j++)
                            {
                                if (citydata.get_typeoffood().get(j).equals(field_food.getValue()))
                                {
                                    indexfood=j;
                                    System.out.println(citydata.get_typeoffood().get(j));
                                    System.out.println(field_food.getValue());

                                }

                            }
                        }
                    }
                }
            }
        }


        journey.set_hotel_data(citydata.get_nameofhotel().get(indexofhotelbycriteria),
                citydata.get_stars().get(indexofhotelbycriteria),
                citydata.get_pool().get(indexofhotelbycriteria),
                citydata.get_gym().get(indexofhotelbycriteria),
                citydata.get_typeoffood().get(indexfood), citydata.get_pricefortypeoffood().get(indexfood),
                citydata.get_costperday().get(indexofhotelbycriteria),
                citydata.get_pricefortransfertohotel().get(indexofhotelbycriteria));



    }
    @FXML
    public void click_button_back(ActionEvent event)
    {

            button_back.getScene().getWindow().hide();

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
    public void click_button_showvariants(ActionEvent event)
    {
        choosehotel();
        System.out.println("запуск функции journey data из f3");
        journey.show_journey_data();

            button_showvariants.getScene().getWindow().hide();

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



}

