package com.example.kurs;


import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import static kotlin.io.ConsoleKt.readLine;

public class f2_plan {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_back;

    @FXML
    private Button button_paramhotels;

    @FXML
    private ComboBox<String> field_city;

    @FXML
    private ComboBox<String> field_classofplane;

    @FXML
    private DatePicker field_data;

    @FXML
    private TextField field_days;

    @FXML
    private TextField field_persons;


    city citydata=new city();
    constrjourney journey=new constrjourney();


    @FXML
    void initialize() {
        //город
        field_city.getItems().addAll(
                "Париж",
                "Рим",
                "Берлин"
        );
        field_city.setEditable(false);
        field_city.setValue("Париж");

        //класс самолёта
        field_classofplane.getItems().addAll(
                "Эконом класс",
                "Бизнес класс",
                "Первый класс"
        );
        field_classofplane.setEditable(false);
        field_classofplane.setValue("Эконом класс");


        //дата
        field_data.setEditable(false);
        LocalDate minDate = LocalDate.now();

        field_data.setDayCellFactory(d ->
                new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        setDisable(item.isBefore(minDate));
                    }
                });

        field_data.setValue(LocalDate.now()); //дата по умолчанию


    }

    public boolean check_field_days() {
        int days;
        boolean check_days = false;
        try {
            days = Integer.parseInt(field_days.getText());
            System.out.println(days);
            if (days > 2) {
                check_days = true;
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Ошибка");
                errorAlert.setContentText("Введено недопустимое количество дней \n" +
                        "Минимальное количество дней: 3");
                errorAlert.showAndWait();
            }
        } catch (Exception e) {
            System.out.println(e);
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Ошибка");
            errorAlert.setContentText("Данные в поле количество дней введены некорректно");
            errorAlert.showAndWait();
        }
        return check_days;
    }

    public boolean check_field_persons() {
        int persons;
        boolean check_persons = false;
        try {
            persons = Integer.parseInt(field_persons.getText());
            System.out.println(persons);
            if (persons > 0) {
                check_persons = true;
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Ошибка");
                errorAlert.setContentText("Введено недопустимое количество человек");
                errorAlert.showAndWait();
            }
        } catch (Exception e) {
            System.out.println(e);
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Ошибка");
            errorAlert.setContentText("Данные в поле количество человек введены некорректно");
            errorAlert.showAndWait();
        }

        return check_persons;
    }

    public void getdatafromfile() throws IOException {
        citydata.delete_city();
        File filehotels, filemuseums, filetheatres, filepriceticketsofplanes;


        // try {
        filehotels = new File("E:\\Курсовой проект\\cities\\Paris\\hotelsofparis.txt");
        filemuseums = new File("E:\\Курсовой проект\\cities\\Paris\\museumsofparis.txt");
        filetheatres = new File("E:\\Курсовой проект\\cities\\Paris\\theatresofparis.txt");
        filepriceticketsofplanes=new File("E:\\Курсовой проект\\cities\\Paris\\planesticketpriceofparis.txt");

        //    }
        //      catch (Exception e) {
        //        System.out.println("Файл не найден");
        //    }


        if (field_city.getValue() == "Берлин") {
            try {
                filehotels = new File("E:\\Курсовой проект\\cities\\Berlin\\hotelsofberlin.txt");
                filemuseums = new File("E:\\Курсовой проект\\cities\\Berlin\\museumsofberlin.txt");
                filetheatres = new File("E:\\Курсовой проект\\cities\\Berlin\\theatresofberlin.txt");
                filepriceticketsofplanes=new File("E:\\Курсовой проект\\cities\\Berlin\\planesticketpriceofberlin.txt");
            } catch (Exception e) {
                System.out.println("Файл не найден");
            }
        } else if (field_city.getValue() == "Рим") {
            try {
                filehotels = new File("E:\\Курсовой проект\\cities\\Rome\\hotelsofrome.txt");
                filemuseums = new File("E:\\Курсовой проект\\cities\\Rome\\museumsofrome.txt");
                filetheatres = new File("E:\\Курсовой проект\\cities\\Rome\\theatresofrome.txt");
                filepriceticketsofplanes=new File("E:\\Курсовой проект\\cities\\Rome\\planesticketpriceofrome.txt");
            } catch (Exception e) {
                System.out.println("Файл не найден");
            }
        }


        //импорт данных отелей
       BufferedReader inputhotels = new BufferedReader(new InputStreamReader(new FileInputStream(filehotels), "UTF-8"));


        char ch;
        int count = 0;
        int checkcount = 0;
        String stroka = "";

           while(inputhotels.ready())
            {
                stroka="";

                while ((ch = (char) inputhotels.read()) != ';') {
                    // System.out.println(ch);
                    stroka = stroka + String.valueOf(ch);

                }


                count++;
               // System.out.println("count: "+ count);
                checkcount++;
              //  System.out.println("checkcount: "+ checkcount);
                System.out.println(stroka);

                        if(count==1)
                        {
                            citydata.set_nameofhotel(stroka);
                        }
                        else if (count==2)
                        {
                            citydata.set_stars(Integer.parseInt(stroka));
                        }
                        else if (count==3)
                        {
                            boolean checkpool=false;
                            if (stroka.equals("Есть")) {checkpool=true;}
                            citydata.set_pool(checkpool);
                        }
                        else if (count==4)
                        {
                            boolean checkgym=false;
                            if (stroka.equals("Есть")) {checkgym=true;}
                            citydata.set_gym(checkgym);
                        }
                        else if (count==5)
                        {
                            citydata.set_costperday(Integer.parseInt(stroka));

                        }
                        else if (count ==6)
                        {
                            citydata.set_typeoffood(stroka);
                        }
                        else if (count==7)
                        {
                            citydata.set_pricefortypeoffood(Integer.parseInt(stroka));

                        }
                        else if (count ==8)
                        {
                            citydata.set_typeoffood(stroka);
                        }
                        else if (count==9)
                        {
                            citydata.set_pricefortypeoffood(Integer.parseInt(stroka));

                        }
                        else if (count ==10)
                        {
                            citydata.set_typeoffood(stroka);
                        }
                        else if (count==11)
                        {
                            citydata.set_pricefortypeoffood(Integer.parseInt(stroka));

                        }
                        else if (count==12)
                        {
                            citydata.set_pricefortransfertohotel(Integer.parseInt(stroka));
                            count=0;
                        }


            }
            inputhotels.close();

        //импорт данных типа класса в самолёте
        count = 0;
        BufferedReader inputticketpriceofplane = new BufferedReader(new InputStreamReader(new FileInputStream(filepriceticketsofplanes), "UTF-8"));
        while (inputticketpriceofplane.ready())
        {
            stroka = "";

            while ((ch = (char) inputticketpriceofplane.read()) != ';') {
                // System.out.println(ch);
                stroka = stroka + String.valueOf(ch);

            }
            count++;


            if (count==1)
            {
                citydata.set_nameofclassplane(stroka);
                System.out.println("Название класса самолёта");
                System.out.println(stroka);
            }
            else if (count==2)
            {

                count=0;
                citydata.set_ticketpriceofplane(Integer.parseInt(stroka));
                System.out.println("Стоимость билета на самолёт");
                System.out.println(stroka);
            }

        }
        inputticketpriceofplane.close();


        //импорт данных театров
        count = 0;
        BufferedReader inputtheatres = new BufferedReader(new InputStreamReader(new FileInputStream(filetheatres), "UTF-8"));

       while (inputtheatres.ready())
        {
            stroka = "";

            while ((ch = (char) inputtheatres.read()) != ';') {
                // System.out.println(ch);
                stroka = stroka + String.valueOf(ch);

            }
            count++;


                if (count==1)
                {
                   citydata.set_nameoftheatre(stroka);
                    System.out.println("Название театра");
                    System.out.println(stroka);
                }
                else if (count==2)
                {

                    count=0;
                    citydata.set_ticketpriceoftheatre(Integer.parseInt(stroka));
                    System.out.println("Стоимость билета");
                    System.out.println(stroka);
                }

        }
        inputtheatres.close();
            citydata.get_nameoftheatre();
            citydata.get_ticketpriceoftheatre();

            //импорт данных музеев
            count=0;
            BufferedReader inputmuseums = new BufferedReader(new InputStreamReader(new FileInputStream(filemuseums), "UTF-8"));
            while(inputmuseums.ready()) {
                stroka = "";

                while ((ch = (char) inputmuseums.read()) != ';') {
                    // System.out.println(ch);
                    stroka = stroka + String.valueOf(ch);

                }
                count++;
                System.out.println(stroka);
                if (count==1)
                {
                    citydata.set_nameofmuseum(stroka);
                }
                else if (count==2)
                {
                    citydata.set_ticketpriceofmuseum(Integer.parseInt(stroka));
                    count=0;
                }

            }

            inputmuseums.close();



    }


    public void setdataforjourney() //данные для поездки
    {
        LocalDate mydatebegin = field_data.getValue();
       // String my_format_datebegin = mydatebegin.format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));
        //System.out.println(my_format_datebegin);
        LocalDate mydateend = mydatebegin.plusDays(Integer.parseInt(field_days.getText()));
       // String my_format_dateend = mydatebegin.format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));

        //определение необходимого количества номеров в отеле
        int kolrooms;
        if (Integer.parseInt(field_persons.getText()) % 3==0)
        {
            kolrooms=Integer.parseInt(field_persons.getText()) / 3;
        }
        else
        {
            kolrooms=Integer.parseInt(field_persons.getText()) / 3+1;
        }

        journey = new constrjourney(field_city.getValue(), mydatebegin, mydateend,
                Integer.parseInt(field_days.getText()),
                Integer.parseInt(field_persons.getText()), kolrooms, field_classofplane.getValue(),
                citydata.get_priceclassofplane(field_classofplane.getValue()));
    }

    @FXML
    public void click_button_paramhotels(ActionEvent event) throws IOException {
        //==============

        LocalDate mydate = field_data.getValue();
        String my_format_date = mydate.format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));
        System.out.println(my_format_date);



        boolean check_days = check_field_days();
        boolean check_persons=check_field_persons();
        if ((check_days==true)&&(check_persons==true)) {
        //======
            getdatafromfile();
            citydata.show_city_data();
            setdataforjourney();
            journey.show_journey_data();

        //=================



            button_paramhotels.getScene().getWindow().hide();

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

    }

    @FXML
    public void click_button_back(ActionEvent event)
    {


            button_back.getScene().getWindow().hide();

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
