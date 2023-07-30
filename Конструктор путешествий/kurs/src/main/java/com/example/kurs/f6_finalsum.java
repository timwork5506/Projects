package com.example.kurs;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class f6_finalsum {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_finish;

    @FXML
    private Button button_mainmenu;

    @FXML
    private TableView<classforoutput> field_table;
    @FXML
    private TableColumn<classforoutput, String> field_object;

    @FXML
    private TableColumn<classforoutput, String> field_data;



    @FXML
    private TableColumn<classforoutput, Integer> field_sum;



    constrjourney journey = new constrjourney();
    ObservableList<classforoutput> journey_data = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        final_sum();
        init_data();



        field_object.setCellValueFactory(new PropertyValueFactory<classforoutput, String>("ob"));
        field_data.setCellValueFactory(new PropertyValueFactory<classforoutput, String>("data"));
        field_sum.setCellValueFactory(new PropertyValueFactory<classforoutput, Integer>("sum"));

        field_table.setItems(journey_data);




    }
    void init_data()
    {

         String my_format_datebegin = journey.get_datebegintrip().format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));
         String my_format_dateend = journey.get_dateendtrip().format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));

        journey_data.add(new classforoutput("Самолёт (СПб-"+journey.get_city()+")",
                my_format_datebegin, journey.get_sumofticketsplane()));
        journey_data.add(new classforoutput("Самолёт ("+journey.get_city()+"-СПб)",
                my_format_dateend, journey.get_sumofticketsplane()));
        journey_data.add(new classforoutput("Трансфер (из аэропорта в отель)",
                my_format_datebegin, journey.get_sumfortranser()));
        journey_data.add(new classforoutput("Трансфер (из отеля в аэропорт)",
                my_format_dateend, journey.get_sumfortranser()));
        journey_data.add(new classforoutput("Отель '"+journey.get_nameofhotel()+"'"+
                "(количество номеров: "+journey.get_kolrooms()+")", "", journey.get_sumforhotel()));
        journey_data.add(new classforoutput("Стоимость еды в отеле", "", journey.get_sumforfood()));

        if (journey.get_nameofmuseum().isEmpty()==false)
        {

            for(int i =0; i<journey.get_nameofmuseum().size();i++)
            {
                journey_data.add(new classforoutput("Музей '"+journey.get_nameofmuseum().get(i)+"'",
                        "", journey.get_sumeachmuseum().get(i)));
            }

        }

        if (journey.get_nameoftheatre().isEmpty()==false)
        {

            for(int i =0; i<journey.get_nameoftheatre().size();i++)
            {
                String my_format_datevisittheatre = journey.get_dateofvisittheatre().get(i).format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));
                journey_data.add(new classforoutput("Театр '"+journey.get_nameoftheatre().get(i)+"'",
                        my_format_datevisittheatre, journey.get_sumeachtheatre().get(i)));
            }

        }
        journey_data.add(new classforoutput("Итоговая сумма", "", journey.get_sum_full()));


    }

    public void final_sum()
    {
       int csumofticketsplane, csumfortranser, csumforhotel, csumforfood, csum_full;
       int sumfortheatres=0;
       int sumformuseums=0;
       ArrayList <Integer> csumfortheatres= new ArrayList<Integer>();
       ArrayList <Integer> csumformuseums=new ArrayList<Integer>();
        csumofticketsplane=journey.get_kolperson()*journey.get_ticketpriceofplane();
        csumfortranser=journey.get_kolperson()*journey.get_pricefortransfertohotel();
        csumforhotel=journey.get_kolrooms()*journey.get_costperday()*journey.get_koldays();

        for(int i=0; i<journey.get_ticketpriceoftheatre().size();i++)
        {
            csumfortheatres.add(journey.get_ticketpriceoftheatre().get(i)*journey.get_kolperson());
            sumfortheatres=sumfortheatres+journey.get_ticketpriceoftheatre().get(i)*journey.get_kolperson();
        }

        for(int i =0; i<journey.get_ticketpriceofmuseum().size();i++)
        {
            csumformuseums.add(journey.get_ticketpriceofmuseum().get(i)*journey.get_kolperson());
            sumformuseums=sumformuseums+journey.get_ticketpriceofmuseum().get(i)*journey.get_kolperson();
        }
        csumforfood=journey.get_pricefortypeoffood()*journey.get_kolperson()*journey.get_koldays();
        csum_full=csumofticketsplane*2+csumfortranser*2+csumforhotel+csumforfood+sumfortheatres+sumformuseums;

        journey.set_sum(csumofticketsplane, csumfortranser, csumforhotel,
                csumforfood, sumformuseums, sumfortheatres, csum_full, csumfortheatres, csumformuseums);
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


    @FXML
    public void click_button_finish(ActionEvent event)
    {

            button_finish.getScene().getWindow().hide();


    }

}
