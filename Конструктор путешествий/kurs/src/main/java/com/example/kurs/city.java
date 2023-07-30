package com.example.kurs;

import java.util.ArrayList;

public class city
{
    //отели
    //private String nameofhotel; //название отеля
    static private ArrayList <String> nameofhotel = new ArrayList<String>(); //название отеля

   // private int stars; //количество звёзд у отеля
    static private ArrayList <Integer> stars = new ArrayList<Integer>(); //количество звёзд у отеля

    //private boolean pool; //наличие бассейна
    static private ArrayList <Boolean> pool = new ArrayList<Boolean>(); //наличие бассейна

   // private boolean gym; //наличие спортзала
    static private ArrayList <Boolean> gym = new ArrayList<Boolean>(); //наличие спортзала

    static private ArrayList<String> typeoffood = new ArrayList<String>(); //тип еды
    static private ArrayList <Integer> pricefortypeoffood = new ArrayList<Integer>(); //стоимость для типа еды
    //private int costperday; //стоимость за день
    static private ArrayList <Integer> costperday = new ArrayList<Integer>(); //стоимость за день

    //театры
    static private ArrayList <String> nameoftheatre= new ArrayList<String>(); //название театра
    static private ArrayList <Integer> ticketpriceoftheatre = new ArrayList<Integer>(); //стоимость билета в театр
    //музеи
    static private ArrayList <String> nameofmuseum= new ArrayList<String>(); //название музея
    static private ArrayList <Integer> ticketpriceofmuseum = new ArrayList<Integer>(); //стоимость билета в музей

    //самолёт
    static private ArrayList <String> nameofclassplane= new ArrayList<String>(); //название музея
    static private ArrayList <Integer> ticketpriceofplane= new ArrayList<Integer>(); //стоимость билета в музей

    static private ArrayList <Integer> pricefortransfertohotel = new ArrayList<Integer>();

    public city()
    {
        /*
        this.nameofhotel=nameofhotel;
        this.stars=stars;
        this.pool=pool;
        this.gym=gym;
        this.typeoffood=typeoffood;
        this.costperday=costperday;
*/

    }

    static public void set_nameofhotel(String namehotel)
    {
       nameofhotel.add(namehotel);
    }

    static public void set_stars(int st)
    {
        stars.add(st);
    }

    static public void set_pool(boolean p)
    {
        pool.add(p);
    }

    static public void set_gym(boolean g)
    {
        gym.add(g);
    }

    static public void set_costperday(int cost)
    {
        costperday.add(cost);
    }

    static public void set_nameoftheatre(String name)
    {
        nameoftheatre.add(name);
    }

    static public void set_ticketpriceoftheatre (int price)
    {
        ticketpriceoftheatre.add(price);
    }

    static public void set_nameofmuseum(String name)
    {
        nameofmuseum.add(name);
    }

    static public void set_ticketpriceofmuseum (int price)
    {
        ticketpriceofmuseum.add(price);
    }

    static public void set_nameofclassplane(String name)
    {
        nameofclassplane.add(name);
    }

    static public void set_ticketpriceofplane(int price)
    {
        ticketpriceofplane.add(price);
    }

    static public void set_typeoffood (String type) {typeoffood.add(type);}
    static public void set_pricefortypeoffood (int price) {pricefortypeoffood.add(price);}
    static public void set_pricefortransfertohotel (int price) {pricefortransfertohotel.add(price);}

    public ArrayList<String> get_nameofhotel()
    {
        return nameofhotel;
    }

    static public ArrayList<Integer> get_stars()
    {
        return stars;
    }

    static public ArrayList<Boolean> get_pool()
    {
        return pool;
    }

    static public ArrayList<Boolean> get_gym()
    {
        return gym;
    }

    static public ArrayList<Integer> get_costperday()
    {
        return costperday;
    }

    static public ArrayList<String> get_nameoftheatre()
    {
        return nameoftheatre;
    }
    static public ArrayList<Integer> get_ticketpriceoftheatre()
    {
        return ticketpriceoftheatre;
    }

    static public ArrayList<String> get_nameofmuseum()
    {
        return nameofmuseum;
    }

    static public ArrayList<Integer> get_ticketpriceofmuseum()
    {
        return ticketpriceofmuseum;
    }
    static public ArrayList<Integer> get_pricefortransfertohotel() {return pricefortransfertohotel;}
    static public ArrayList<String> get_typeoffood()
    {
        return typeoffood;
    }

    static public ArrayList<Integer> get_pricefortypeoffood()
    {
        return pricefortypeoffood;
    }

    static public int get_priceclassofplane(String classofplane)
    {
        int fixnumberofclassplane = 0;
    int count =0;
        for(String d: nameofclassplane)
        {
            if (classofplane.equals(d))
            {
                break;
            }
            fixnumberofclassplane++;
        }

        return ticketpriceofplane.get(fixnumberofclassplane);
    }


    static public void show_city_data()
    {
        System.out.print("Данные города");
        System.out.println("Название отеля");
        nameofhotel.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Количество звёзд");
        stars.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Наличие бассейна");
        pool.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Наличие спортзала");
        gym.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Стоимость за 1 день");
        costperday.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Названия музея");
        nameofmuseum.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Стоимость билетов в музей");
        ticketpriceofmuseum.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });




        System.out.println("Названия театра");
        nameoftheatre.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Стоимость билетов в театр");
        ticketpriceoftheatre.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Названия класса самолёта");
        nameofclassplane.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Стоимость билета на самолёт");
        ticketpriceofplane.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });

        System.out.println("Тип еды");
        typeoffood.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });
        System.out.println("Цена за еду");
        pricefortypeoffood.stream().forEach(d -> {
            System.out.print("'"+d+"'");

        });
    }

    static public void delete_city() //очистка данных в случае изменения города
    {
        nameofhotel.clear();
        stars.clear();
        pool.clear();
        gym.clear();
        costperday.clear();
        nameoftheatre.clear();
        ticketpriceoftheatre.clear();
        nameofmuseum.clear();
        ticketpriceofmuseum.clear();
        nameofclassplane.clear();
        ticketpriceofplane.clear();
        nameofclassplane.clear();
        ticketpriceofplane.clear();
        pricefortransfertohotel.clear();

    }

/*
    public int get_costperday()
    {
        //return costperday;
    }
*/

}
