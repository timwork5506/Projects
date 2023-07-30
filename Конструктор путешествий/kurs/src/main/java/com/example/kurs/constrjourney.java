package com.example.kurs;

import java.time.LocalDate;
import java.util.ArrayList;

public class constrjourney
{
    //основные данные
    static private String city; //город назначения
    static private LocalDate datebegintrip; //дата начала поездки
    static private LocalDate dateendtrip; //дата завершения поездки
    static private int koldays; //количество дней поездки
    static private int kolperson; //количество человек, участвующих в поездке
    static private int kolrooms; //необходимое количество номеров

    //данные отеля
    static private String nameofhotel; //название отеля
    static private int stars; //количество звёзд у отеля
    static private boolean pool; //наличие бассейна
    static private boolean gym; //наличие спортзала
    static private String typeoffood; //тип еды
    static private int pricefortypeoffood;//стоимость еды
    static private int costperday; //стоимость 1 номера за день
    static private int pricefortransfertohotel; //стоимость трансфера от аэропорта до отеля

    //данные самолёта
    static private String typeofclassplane; //тип класса
    static private int ticketpriceofplane; //стоимость билета в 1 сторону за 1 человека

    //театры
    static private ArrayList<String> nameoftheatre= new ArrayList<String>(); //название театра
    static private ArrayList <Integer> ticketpriceoftheatre = new ArrayList<Integer>(); //стоимость билета в театр
    static private ArrayList <LocalDate> dateofvisittheatre = new ArrayList<LocalDate>();
    //музеи
    static private ArrayList <String> nameofmuseum= new ArrayList<String>(); //название музея
    static private ArrayList <Integer> ticketpriceofmuseum = new ArrayList<Integer>(); //стоимость билета в музей

    //итоги
    static private int sumofticketsplane;
    static private int sumfortranser;
    static private int sumforhotel;
    static private int sumforfood;
    static private int sumformuseums;
    static private int sumfortheatres;
    static private int sum_full;
    static private ArrayList <Integer> sumeachtheatre=new ArrayList<Integer>();
    static private ArrayList <Integer> sumeachmuseum=new ArrayList<Integer>();
    public constrjourney(String city, LocalDate dbegin, LocalDate dend, int koldays, int kolperson, int kolrooms, String typeofclassplane, int ticketpriceofplane)
    {
        this.city=city;
        this.datebegintrip=dbegin;
        this.dateendtrip=dend;
        this.koldays=koldays;
        this.kolperson=kolperson;
        this.kolrooms=kolrooms;
        this.typeofclassplane=typeofclassplane;
        this.ticketpriceofplane=ticketpriceofplane;
    }
public constrjourney()
{

}
    static public void set_hotel_data(String cnameofhotel, int cstars, boolean cpool, boolean cgym,
                                      String ctypeoffood, int cpricefortypeoffood, int ccostperday, int cpricefortransfertohotel)
{
    nameofhotel=cnameofhotel;
    stars=cstars;
    pool=cpool;
    gym=cgym;
    typeoffood=ctypeoffood;
    pricefortypeoffood=cpricefortypeoffood;
    costperday=ccostperday;
    pricefortransfertohotel=cpricefortransfertohotel;
}

    static public void set_theatre(String name, int cost, LocalDate dat)
    {
        nameoftheatre.add(name);
        ticketpriceoftheatre.add(cost);
        dateofvisittheatre.add(dat);
    }

    static public void set_museum(String name, int cost)
    {
        nameofmuseum.add(name);
        ticketpriceofmuseum.add(cost);
    }

    static public void set_sum(int csumofticketsplane, int csumfortranser, int csumforhotel,
                               int csumforfood, int csumformuseums, int csumfortheatres, int csum_full,
                               ArrayList <Integer> sumeverytheatre, ArrayList <Integer> sumeverymuseum)
    {
        sumofticketsplane=csumofticketsplane;
        sumfortranser=csumfortranser;
        sumforhotel=csumforhotel;
        sumforfood=csumforfood;
        sumformuseums=csumformuseums;
        sumfortheatres=csumfortheatres;
        sum_full=csum_full;
        sumeachtheatre=sumeverytheatre;
        sumeachmuseum=sumeverymuseum;

    }
    static public void show_journey_data()
    {
        System.out.print("Данные поездки");

        System.out.println("Название города");
        System.out.println(city);



        System.out.println("количество дней");
        System.out.println(koldays);

        System.out.println("количество человек");
        System.out.println(kolperson);

        System.out.println("количество комнат");
        System.out.println(kolrooms);

        System.out.println("тип класса самолёта");
        System.out.println(typeofclassplane);

        System.out.println("Стоимость билета");
        System.out.println(ticketpriceofplane);

        System.out.println("Название отеля");
        System.out.println(nameofhotel);

        System.out.println("Количество звёзд");
        System.out.println(stars);

        System.out.println("Наличие бассейна");
        System.out.println(pool);

        System.out.println("Наличие спортзала");
        System.out.println(gym);

        System.out.println("Тип еды");
        System.out.println(typeoffood);

        System.out.println("Стоимость еды");
        System.out.println(pricefortypeoffood);

        System.out.println("Стоимость за день");
        System.out.println(costperday);

        System.out.println("Название театра");
        nameoftheatre.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Стоимость билетов в театр");
        ticketpriceoftheatre.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Название музея");
        nameofmuseum.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Стоимость билетов в музей");
        ticketpriceofmuseum.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Стоимость трансфера до отеля");
        System.out.println(pricefortransfertohotel);

    }


    static public String get_city()
    {
        return city;
    }
    static public String get_nameofhotel()
    {
        return nameofhotel;
    }

    static public int get_stars()
    {
        return stars;
    }

    static public boolean get_pool()
    {
        return pool;
    }

    static public boolean get_gym()
    {
        return gym;
    }

    static public String get_typeoffood()
    {
        return typeoffood;
    }

    static public int get_costperday()
    {
        return costperday;
    }

    static public int get_koldays()
    {
        return koldays;
    }

    static public int get_kolperson()
    {
        return kolperson;
    }
    static public int get_ticketpriceofplane() {return ticketpriceofplane;}

    static public int get_pricefortransfertohotel() {return pricefortransfertohotel;}
    static public int get_kolrooms () {return kolrooms;}
    static public LocalDate get_datebegintrip() {return datebegintrip;}
    static public LocalDate get_dateendtrip() {return dateendtrip;}
   static public ArrayList<String> get_nameoftheatre() {return nameoftheatre;}
    static public ArrayList<Integer> get_ticketpriceoftheatre() {return ticketpriceoftheatre;}
    static public ArrayList<LocalDate> get_dateofvisittheatre() {return dateofvisittheatre;}
    static public ArrayList<String> get_nameofmuseum() {return nameofmuseum;}

    static public ArrayList<Integer> get_ticketpriceofmuseum() {return ticketpriceofmuseum;}
    static public int get_pricefortypeoffood() {return pricefortypeoffood;}


    static public int get_sumofticketsplane() {return sumofticketsplane;}
    static public int get_sumfortranser() {return sumfortranser;}
    static public int get_sumforhotel() {return sumforhotel;}
    static public int get_sumforfood() {return sumforfood;}
    static public int get_sumformuseums() {return sumformuseums;}
    static public int get_sumfortheatres() {return sumfortheatres;}
    static public int get_sum_full() {return sum_full;}
    static public ArrayList<Integer> get_sumeachtheatre() {return sumeachtheatre;}
    static public ArrayList<Integer> get_sumeachmuseum() {return sumeachmuseum;}


}
