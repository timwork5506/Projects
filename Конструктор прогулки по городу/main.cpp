
#include <iostream>
#include <vector>
#include <string>
#include "gorod.h"
#include "streets.h"
#include "museums.h"
#include "theatres.h"
using namespace std;


string gorod::data;
float gorod::time_to_spend;
int gorod::kolchelprog;
float gorod::totaltime;
int gorod::transport;
float gorod::plata_for_transport;
int gorod::kolplat_for_transport;
int gorod::food;
float gorod::price_for_food;

    

bool gorod::operator>= (gorod provvr)
{
    if (time_to_spend>=provvr.get_dublir_totaltime()) 
    {
        return true;
    }
    else 
    {
        return false;
    }
}


bool check_data(vector <museums> museum) //проверка даты на существование
{
    if (museum[0].year < 0)
        return false;
 
    switch(museum[0].month)
    {
        case 1:  //Январь
        case 3:  //Март
        case 5:  //Май
        case 7:  //Июль
        case 8:  //Август
        case 10: //Октябрь
        case 12: //Декабрь
                if ((museum[0].day<1)||(museum[0].day>31)) {return false;}
                else {return true;}
            
        case 2: //Февраль
            if (museum[0].year % 4 == 0)
                {
                    if ((museum[0].day<1)||(museum[0].day>29)) {return false;}
                    else {return true;}
                }
            else 
            {
                if ((museum[0].day<1)||(museum[0].day>28)) {return false;}
                else {return true;}
            }
                
        case 4: //Апрель
        case 6: //Июнь
        case 9: //Сентябрь
        case 11: //Ноябрь
                if ((museum[0].day<1)||(museum[0].day>30)) {return false;}
                else {return true;}
        default:
            return false;
    }
}

void vichpm(vector <streets> street, vector <museums> museum, theatres theatre) //вычисление суммы, необходимой для осуществления прогулки
{
    float sum_to_pay; //сумма, необходимая для осуществления прогулки
    
    sum_to_pay=(museum[0].price+theatre.price+street[0].price_for_food)*theatre.kolchelprog+street[0].kolplat_for_transport*street[0].plata_for_transport;
    cout<<"_______________________________________________________"<<endl;
    cout<<"Сумма, необходимая для осуществления прогулки: "<<sum_to_pay<<" рублей"<<endl;
    cout<<"_______________________________________________________"<<endl;
}

 void vichpm(vector <streets> street) //вычисление суммарного расстояния прогулки
 {
     float totaldistance=0;
     for(int i=0; i<street.size(); i++)
     {
        totaldistance=totaldistance+street[i].distance;
     }
     cout<<"_______________________________________________________"<<endl;
     cout<<"Суммарное расстояние: "<<totaldistance<<" км"<<endl;
     cout<<"За все день на прогулку вы потратите: "<<street[0].totaltime<<" часов"<<endl;
     cout<<"_______________________________________________________"<<endl;
 }

int main()
{
    
    int vybor_menu=0;
    
    while(vybor_menu!=3)
{   
    cout<<"---------------------------------"<<endl;
    cout<<"Программа: 'Прогулка по городу'"<<endl;
    cout<<"Для запуска программы, нажмите 1"<<endl;
    cout<<"Для справки, нажмите 2"<<endl;
    cout<<"Для завершения, нажмите 3"<<endl;
    cout<<"---------------------------------"<<endl;
    cin>>vybor_menu;

    while((vybor_menu<1)||(vybor_menu>3))
    {
        cout<<"Введён несуществующий пункт меню. Повторите ввод"<<endl;
        cin>>vybor_menu;
        
    }
    

    
    if (vybor_menu==1)
{
    int nomerulits; //номер улицы для посещения
    vector <streets> street(1); //вектор улиц
    vector <museums> museum(1); //вектор музей
    gorod prvr; //объект для проверки превышения на время и демонстрации перегрузки оператора сравнения
    streets dobavvvect;
    
    theatres theatre; //объект театр
    
    string data; //дата
    
    float planvrpotr; //продолжительность прогулки (в часах)
    int kolchelgo;
    int fixnvichul; //фиксация номера элемента при котором было превышено суммарное время прогулки 
                    //(для последующего удаления всех превышающих продолжительность прогулки элементов)
    
    string th[3]; //варианты театров для посещения
    string mus[3]; //варианты музеев для посещения
    float price_th[3]; //цены в театр
    float price_mus[3];//цены в музей
    int check_for_theatre;
    int check_for_museum;
    int nomertheatre;
    int nomermuseum;
    int check_for_transport;
    int transport;
    int tekdl; //для свига элементов vector (улицы)
    int type_eda;
    float mintime;
    int kolulits; //количество улиц для посещения
    int moreinformation;
    bool check; //для проверки на повторяемость улиц
    bool checkelemdata=false;
    string ul[8]={"Невский проспект", "улица Рубинштейна", "Садовая улица", "улица Правды", 
    "Миллионная улица", "улица зодчего Росси", "улица Чайковского", "улица Фурштатская"}; //варианты улиц для прогулки
    float distance_ul[8]={4.5, 0.76, 4.4, 0.6, 1, 0.22, 1.7, 1}; //протяжённость каждой улицы (в км)
    float vremprog_ul[8]={0.75, 0.13, 0.73, 0.1, 0.17, 0.04, 0.28, 0.17}; //врямя прогулки по каждой улице (в ч)
    
    mintime=0.04;
    int day, month, year;
    bool checkexistdata=false;
    cout<<"Введите дату в формате: число месяц год"<<endl;
    cin>>day>>month>>year;
    
    museum[0].setelemdata(day, month, year);
    
    while(checkexistdata==false) //проверка даты на существование
    {
        checkexistdata=check_data(museum);
        
        if (checkexistdata==false)
        {
           cout<<"Введена несуществующая дата. Повторите ввод"<<endl;
           cin>>day>>month>>year;
           museum[0].setelemdata(day, month, year);
        }
    }
    
    if (checkexistdata==true)
    {
        data=to_string(museum[0].get_day())+'.'+to_string(museum[0].get_month())+'.'+to_string(museum[0].get_year());
    }
    
    
    
    if (museum[0].get_day()%2==0) //если день даты чётный, то один список театров и музеев для посещения
    {
        th[0]="Мариинский театр"; //варианты театров для посещения
        th[1]="Александринский театр";
        th[2]="Большой драматический театр";
        mus[0]="Эрмитаж"; //варианты музеев для посещения
        mus[1]="Музей Фаберже";
        mus[2]="Русский Этнографический музей";
        price_th[0]=1500; //цены в театр
        price_th[1]=1000;
        price_th[2]=500;
        price_mus[0]=1000;//цены в музей
        price_mus[1]=500;
        price_mus[2]=1500;
        
       
       
    }
    else //если день даты нечётный, то другой список театров и музеев для посещения
    {
        th[0]="Малый драматический театр"; //варианты театров для посещения
        th[1]="Эрмитажный театр";
        th[2]="Михайловский театр";
        mus[0]="Русский музей"; //варианты музеев для посещения
        mus[1]="Зоологический музей";
        mus[2]="Кунсткамера";
        price_th[0]=1000; //цены в театр
        price_th[1]=2000;
        price_th[2]=500;
        price_mus[0]=1500; //цены в музей
        price_mus[1]=1000;
        price_mus[2]=500;
        
    }
    
    float time_for_th=2; //продолжительность пребывания в театре (2 часа)
    float time_for_mus=2; //продолжительность пребывания в музее (1 час)
    
    
    cout<<"Введите сколько времени вы готовы выделить на прогулку (в часах): "<<endl;
    cin>>planvrpotr;
    //проверка ввода данных
    while((planvrpotr<mintime)||(planvrpotr>20))
    {
        cout<<"Введено недопустимое количество часов. Повторите ввод"<<endl;
        cin>>planvrpotr;
    }
    //=================
    cout<<"Сколько человек участвует в прогулке"<<endl;
    cin>>kolchelgo;
    //проверка ввода данных
    while(kolchelgo<=0)
    {
        cout<<"Введено недопустимое количество человек. Повторите ввод"<<endl;
        cin>>kolchelgo;
    }
    //=================
    museum[0]=museums(data, planvrpotr, kolchelgo);
    
    
    //улицы
        cout<<"____________________________"<<endl;
        cout<<"Самые интересные улицы для прогулки:"<<endl;
        for(int i=0; i<8; i++)
        {
            cout<<i<<"-"<<ul[i]<<endl;
        }
        cout<<"____________________________"<<endl;
        
        
        
        cout<<"Введите номера улиц, которые вы хотите посетить (в порядке приоритетности)"<<endl;
        cout<<"Для завершения ввода введите -1"<<endl;

        
        prvr=street[0];
        bool pervoevhozhd=false;
        while(nomerulits!=-1)
        {
            check=false; //для проверки на повторяемость улиц
            cin>>nomerulits;
            //проверка ввода данных
            while((nomerulits<-1)||(nomerulits>7))
            {
                cout<<"Введены несуществующие номера улиц. Повторите ввод"<<endl;
                cin>>nomerulits;
            }
            
                
            if (pervoevhozhd==true)
            {
                if (nomerulits!=-1)
                {
                    for(int i=0; i<street.size(); i++)
                    {
                        if (ul[nomerulits]==street[i].get_nazv())
                        {
                            break;
                        }
                        else if (i==(street.size()-1))
                        {
                            check=true;
                        }
                    }
                    
                    while(check==false)
                    {
                        cout<<"Вы уже выбирали "<<ul[nomerulits]<<endl;
                        cout<<"Выберите другую улицу или завершите ввод. Для завершения ввода нажмите -1."<<endl;
                        cin>>nomerulits;
                        while((nomerulits<-1)||(nomerulits>7))
                        {
                            cout<<"Введены несуществующие номера улиц. Повторите ввод"<<endl;
                            cin>>nomerulits;
                        }
                        if (nomerulits==-1) {check=true;}
                        else
                        {
                                for(int i=0; i<street.size(); i++)
                                {
                                    if (ul[nomerulits]==street[i].get_nazv())
                                    {
                                        break;
                                    }
                                    else if (i==(street.size()-1))
                                    {
                                        check=true;
                                    }
                                }
                        }
                    
                    }
                }
            }
                if (nomerulits!=-1)
                {
                    prvr=street[0]; //для обнуления переменной, в которой хранится дублирующее время обнуляется весь объект
                    prvr.set_dublir_totaltime(vremprog_ul[nomerulits]);
                
            
                    if (street[0]>=prvr)
                    {
                
                        if (pervoevhozhd==false) 
                        {
                            street[0]=streets(ul[nomerulits], distance_ul[nomerulits], vremprog_ul[nomerulits]);
                            pervoevhozhd=true;
                        }
                        else
                        {
                            street.push_back(streets(ul[nomerulits], distance_ul[nomerulits], vremprog_ul[nomerulits]));
                        }
                    }
                    else 
                    {
                        cout<<"____________________________"<<endl;
                        cout<<"Времени на посещение "<<ul[nomerulits]<<" нет"<<endl;
                
                    }
                }
            
        }
            
            cout<<"____________________________"<<endl;
            cout<<"Улицы, которые вы сможете посетить"<<endl; 
            
            for(int i=0; i<street.size(); i++)
            {
                cout<<street[i].get_nazv()<<endl;
            }
            cout<<"____________________________"<<endl;
            //=========================================
    //============
    
    
    
    //театры
    
    prvr=theatre;
    prvr.set_dublir_totaltime(time_for_th);
    if (theatre>=prvr)
    {
        cout<<"____________________________"<<endl;
        cout<<"Хотите ли вы посетить театр?"<<endl;
        cout<<"Если хотите - введите 1, если нет - введите 0"<<endl;
        cout<<"____________________________"<<endl;
        cin>>check_for_theatre;
        //проверка ввода данных
        while((check_for_theatre<0)||(check_for_theatre>1))
        {
            cout<<"Введены неверные числа. Повторите ввод"<<endl;
            cin>>check_for_theatre;
        }
        //=================
        
        if (check_for_theatre==1)
        {
            cout<<"____________________________"<<endl;
            cout<<"Выберите театр для посещения"<<endl;
            cout<<"Для этого введите число, которое соответствует выбранному вами театру"<<endl;
            for(int i=0; i<3; i++)
            {
                cout<<i<<"-"<<th[i]<<", стоимость билета: "<<price_th[i]<<" рублей"<<endl;
            }
            cout<<"____________________________"<<endl;
            cin>>nomertheatre;
            //проверка ввода данных
            while((nomertheatre<0)||(nomertheatre>2))
            {
                cout<<"Введён неверный номер театра. Повторите ввод"<<endl;
                cin>>nomertheatre;
            }
            //=================
            theatre=theatres(th[nomertheatre], time_for_th);
            theatre.set_price(price_th[nomertheatre]); //сохранение цены билета в театр в производном классе (перегрузка функции set_price())
        }
    } 
    else
    {
        cout<<"Театр не предлагается для посещения, так как у вас не хватит времени посетить его"<<endl;
    }
    
    
    //===========================
    
    //музеи
    prvr=museum[0];
    prvr.set_dublir_totaltime(time_for_mus);
    if (museum[0]>=prvr)
    {
        cout<<"____________________________"<<endl;
        cout<<"Хотите ли вы посетить музей?"<<endl;
        cout<<"Если хотите - введите 1, если нет - введите 0"<<endl;
        cout<<"____________________________"<<endl;
        cin>>check_for_museum;
        //проверка ввода данных
        while((check_for_museum<0)||(check_for_museum>1))
        {
            cout<<"Введены неверные числа. Повторите ввод"<<endl;
            cin>>check_for_museum;
        }
        //=================
        if (check_for_museum==1)
        {
            cout<<"____________________________"<<endl;
            cout<<"Выберите музей для посещения"<<endl;
            cout<<"Для этого введите число, которое соответствует выбранному вами музею"<<endl;
            for(int i=0; i<3; i++)
            {
                cout<<i<<"-"<<mus[i]<<", стоимость билета: "<<price_mus[i]<<" рублей"<<endl;
            }
            cout<<"____________________________"<<endl;
            cin>>nomermuseum;
            //проверка ввода данных
            while((nomermuseum<0)||(nomermuseum>2))
            {
                cout<<"Введён неверный номер музея. Повторите ввод"<<endl;
                cin>>nomermuseum;
            }
            //=================
            museum[0]=museums(mus[nomermuseum], time_for_mus);
            museum[0].set_price(price_mus[nomermuseum]); //сохранение цены билета в музей в производном классе (перегрузка функции set_price())
        }      
    }
    else
    {
        cout<<"Музей не предлагается для посещения, так как у вас не хватит времени посетить его"<<endl;
    }
    
    cout<<"____________________________"<<endl;
    cout<<"Планируете ли вы использовать транспорт при передвижении по городу?"<<endl;
    cout<<"Если да, введите 1. Если нет, введите 0"<<endl;
    cout<<"____________________________"<<endl;
    cin>>check_for_transport;
    //проверка ввода данных
    while((check_for_transport<0)||(check_for_transport>1))
    {
        cout<<"Введены неверные числа. Повторите ввод"<<endl;
        cin>>check_for_transport;
    }
    //=================
    if (check_for_transport==1)
    {
        cout<<"____________________________"<<endl;
        cout<<"Каким транспортом вы хотите воспользоваться?"<<endl;
        cout<<"Если такси (быстрее, но дороже) - 500 рублей на всех, введите 1"<<endl;
        cout<<"Если общественный транспорт (медленнее, но дешевле) - 50 рублей за человека, введите 2"<<endl;
        cout<<"____________________________"<<endl;
        cin>>transport;
        //проверка ввода данных
        while((transport<1)||(transport>2))
        {
            cout<<"Введены неверные числа. Повторите ввод"<<endl;
            cin>>transport;
        }
        
        street[0].set_transport(transport);
        //=================
    }
    
    cout<<"____________________________"<<endl;
    cout<<"Где вы планируете есть?"<<endl;
    cout<<"Если в ресторане (1500 руб. за человека), введите 1. Если фастфуд (500 руб. за человека), введите 2"<<endl;
    cout<<"____________________________"<<endl;
    cin>>type_eda;
    //проверка ввода данных
    while((type_eda<1)||(type_eda>2))
    {
        cout<<"Введены неверные числа. Повторите ввод"<<endl;
        cin>>type_eda;
    }
    //=================
    street[0].set_food(type_eda);
    
    
    //общие сведения об используемых объектах
    cout<<"____________________________"<<endl;
    cout<<"Хотите ли вы узнать информацию о каждом объекте?"<<endl;
    cout<<"Если да, нажмите 1. Если нет, нажмите 0"<<endl;
    cout<<"____________________________"<<endl;
    cin>>moreinformation;
    //проверка ввода данных
    while((moreinformation<0)||(moreinformation>1))
    {
        cout<<"Введены неверные числа. Повторите ввод"<<endl;
        cin>>moreinformation;
    }
    //=================
    if (moreinformation==1)
    {
        if(street[0].get_nazv()!="") //проверка на то была ли добалена хотя бы 1 улица
        {
            cout<<"Улицы, которые вы посетите: "<<endl;
            for(int i=0; i<street.size(); i++)
            {
                street[i].func(); //используется виртуальная функция (перегрузка функций)
            }
        }
        
        if (theatre.get_nazv()!="")
        {
        cout<<"____________________________"<<endl;
        cout<<"Театр, который вы посетите: "<<endl;
        theatre.func();
        }
        
        if (museum[0].get_nazv()!="")
        {
        cout<<"____________________________"<<endl;
        cout<<"Музей, который вы посетите: "<<endl;
        museum[0].func(); //используется виртуальная функция (перегрузка функций)
        }
        
    }
    vichpm(street, museum, theatre); //вычисление суммы к оплате за прогулку (перегрузка функции, определяющей вычисляемый показатель)
    vichpm(street); //вычисление суммарного расстояния прогулки (перегрузка функции, определяющей вычисляемый показатель)
    street.clear(); //очистка вектора (улицы)
    museum.clear();  //очистка вектора (музей)
    vybor_menu=3;
}   
    else if (vybor_menu==2)
    {
    cout<<"__________________________________________________________________________________________________________________________________"<<endl;
    cout<<"Данная программа позволяет расчитать маршрут прогулки по городу с учётом потребностей пользователя."<<endl;
    cout<<"В начале программы пользователь вводит дату и количество часов, которое он готов выделить для прогулки"<<endl;
    cout<<"Затем пользователь вводит количество человек, участвующих в прогулке и выбирает улицы, которые хочет посетить."<<endl;
    cout<<"Далее пользователю предлагается зайти в музей и театр."<<endl;
    cout<<"Затем у пользователя уточняется хочет ли он воспользоваться общественным транспортом для перемещения по городу. Если да, то каким."<<endl;
    cout<<"Далее пользователю задаётся вопрос о том, где он хочет поесть."<<endl;
    cout<<"Далее пользователю предлагается узнать информацию о всех объектах маршрута."<<endl;
    cout<<"В итоге пользователю выводится сумма (в рублях), которую ему следует выделить для осуществления запланированной им прогулки по городу"<<endl;
    cout<<"Также пользователю выводится суммарное расстояние (в км), которое он пройдёт по маршруту и время (в часах), которое он затратит на прогулку"<<endl;
    cout<<"__________________________________________________________________________________________________________________________________"<<endl;
    }
    
    else 
    {
        break;
        
    }
    
} 
}




