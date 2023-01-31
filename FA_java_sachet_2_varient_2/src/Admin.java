//Вариант 2

//Реализовать консольный терминал кассира и администратора кинотеатра

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import java.util.Scanner;

//Пользователь может выбрать фильм,
// выбрать сеанс фильма,
// выбрать одно или несколько свободных мест для покупки.
// Также пользователь может вывести денежную сумму проданных билетов на все сеансы фильма
// или на конкретный сеанс
/**
 * Класс, который хранит данные о кинотеатре и позволяет выбирать фильм, сеанс и свободные места.
 */
public class Admin {
    public static ArrayList<String> Films = new ArrayList<>(Arrays.asList("Бегущий по лезвию",
            "Бегущий в лабиринте",
            "Мечтатели"
        )
    );
    public static ArrayList<Integer> Money = new ArrayList<>(Arrays.asList(300,
            350,
            200
    ));
    public static ArrayList<ArrayList<Date>> AvailableDates = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FreeSeats = new ArrayList<>();

    Scanner in = new Scanner(System.in);

    public Admin()
    {
        ArrayList<Date> v1 = new ArrayList<>(Arrays.asList(new Date(123, Calendar.FEBRUARY, 7, 20, 0),
                new Date(123, Calendar.FEBRUARY, 7, 21, 0),
                new Date(123, Calendar.FEBRUARY, 7, 22, 0)
        )
        );
        ArrayList<Date> v2 = new ArrayList<>(Arrays.asList(new Date(123, Calendar.MARCH, 7, 20, 0),
                new Date(123, Calendar.MARCH, 7, 21, 0),
                new Date(123, Calendar.MARCH, 7, 22, 0)
        )
        );
        ArrayList<Date> v3 = new ArrayList<>(Arrays.asList(new Date(123, Calendar.APRIL, 7, 20, 0),
                new Date(123, Calendar.APRIL, 7, 21, 0),
                new Date(123, Calendar.APRIL, 7, 22, 0)
        )
        );

        ArrayList<Integer> f1 = new ArrayList<>(Arrays.asList(10, 34, 10));
        ArrayList<Integer> f2 = new ArrayList<>(Arrays.asList(17, 18, 19));
        ArrayList<Integer> f3 = new ArrayList<>(Arrays.asList(44, 14, 1));

        FreeSeats.add(f1);
        FreeSeats.add(f2);
        FreeSeats.add(f3);

        AvailableDates.add(v1);
        AvailableDates.add(v2);
        AvailableDates.add(v3);
    }
    public String GetFilm()
    {
        System.out.println("Ведите название фильма (введите его порядковый номер, отсчёт начинается с 1): ");
        for (String film : Films) {
            System.out.println(film);
        }
        int num = in.nextInt() - 1;
        return Films.get(num);
    }

    public Date ChooseSession(String filmName)
    {
        System.out.println("Выберети один из сеансов (введите его порядковый номер, отсчёт начинается с 1): ");
        int num_session = Films.indexOf(filmName);
        ArrayList<Date> sessions = AvailableDates.get(num_session);
        for (Date session : sessions) {
            System.out.println(session.toString());
        }
        int num = in.nextInt() - 1;
        Date date = sessions.get(num);
        return date;
    }

    public ArrayList<Integer> ChooseSeats(String filmName){
        System.out.println("Сколько мест вы хотите забронировать?");
        int numSeats = in.nextInt();
        System.out.println(String.format("Выберете %d мест из предложенных, введя их порядковый номер (начиная с 1)" +
                " \n Внимание! Если номер места = 0, значит оно занято", numSeats));
        int num_Seats = Films.indexOf(filmName);
        ArrayList<Integer> seats = FreeSeats.get(num_Seats);
        for (Integer seat : seats) {
            System.out.println(seat.toString());
        }
        ArrayList<Integer> chosen_seats = new ArrayList<>();
        for (int i = 0; i < numSeats; i++){
            int seatNum = in.nextInt() - 1;
            Integer s = seats.get(seatNum);
            chosen_seats.add(s);
            FreeSeats.get(num_Seats).set(seatNum, 0);
        }
        return chosen_seats;
    }

    public static Integer GetFilmPrice(String filmName){
        int index = Films.indexOf(filmName);
        return Money.get(index);
    }
}
