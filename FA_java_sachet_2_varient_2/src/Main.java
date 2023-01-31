import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean play = true;
        //System.out.println("Чтобы остановить работу программу, введите '0'");
        Admin admin = new Admin();
        Scanner in = new Scanner(System.in);
        while (play){
            String filmName = admin.GetFilm();
            Date session = admin.ChooseSession(filmName);
            ArrayList<Integer> seats = admin.ChooseSeats(filmName);
            Order order = new Order(filmName, session, seats);
            System.out.println(order.toString());
            System.out.println(order.GetOrderPriceString());
            System.out.println("Чтобы создать ещё один заказ, введите + \n Если введёте любое другое число, программа остановится.");
            String next = in.nextLine();
            if (!Objects.equals(next, "+")){
                play = false;
            }
        }
    }
}