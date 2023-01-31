import java.util.ArrayList;
import java.util.Date;

public class Order {
    public String FilmName;
    public Date Session;
    public ArrayList<Integer> Seats = new ArrayList<>();

    private Integer price = 0;
    public Order(String filmName, Date session, ArrayList<Integer> seats){
        FilmName = filmName;
        Session = session;
        Seats = seats;
    }

    public String toString(){
        return String.format("Готово! \n Детали заказа: \n \t Фильм - %s \n \t Время сеанса - %s \n \t Места - %s",
                FilmName, Session.toString(), ArrayListToString(Seats));
    }

    private String ArrayListToString(ArrayList<Integer> array){
        ArrayList<Character> newArray = new ArrayList<Character>();
        StringBuilder stringB = new StringBuilder(new String());
        for (int v:array){
            stringB.append(Integer.toString(v));
            stringB.append(";");
        }
        return stringB.toString();
    }

    private int Price(){
        return Seats.size() * Admin.GetFilmPrice(FilmName);
    }

    public String GetOrderPriceString(){
        price = Price();
        return String.format("Сумма заказа составила %d рублей.", price);
    }
}
