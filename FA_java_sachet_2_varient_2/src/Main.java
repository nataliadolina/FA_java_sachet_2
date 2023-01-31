import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean play = true;

        //здесь будем хранить все созданные заказы
        HashMap<String, ArrayList<Order>> orders = new HashMap<>();

        //инициализируем
        for (String filmName : Admin.Films){
            orders.put(filmName, new ArrayList<Order>());
        }

        //создаём админа - машину по составлению заказа
        Admin admin = new Admin();
        //Сканер нужен для считывания данных с консоли
        Scanner in = new Scanner(System.in);
        while (play){
            String filmName = admin.GetFilm();
            Date session = admin.ChooseSession(filmName);
            ArrayList<Integer> seats = admin.ChooseSeats(filmName);

            Order order = new Order(filmName, session, seats);

            //выводим данные заказа
            System.out.println(order.toString());
            //Выводим стоимость заказа
            System.out.println(order.GetOrderPriceString());

            System.out.println("Чтобы создать ещё один заказ, введите + \n Если введёте любое другое число, программа остановится.");
            String next = in.nextLine();

            //Если был введён плючик, то составляем ещё один заказ
            if (!Objects.equals(next, "+")){
                play = false;
            }
        }
    }
}