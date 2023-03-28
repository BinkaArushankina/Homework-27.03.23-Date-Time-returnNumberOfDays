package Homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Homework {
    //Получить и вывести на экран:
    //-текущую дату
    //-текущий год, месяц и день
    //Создать дату , например день рождения и вывести на экран
    //Создать две даты и проверить на равенство
    //Получить и вывести на экран текущее время
    //текущее время + 3 часа
    //Создать дату на неделю позже сегодняшней
    //Создать дату, которая была на год раньше сегодняшней используя метод minus
    //Создать дату на год позже сегодняшней используя plus метод
    //Создать даты tomorrow и yesterday и проверить находятся ли они до или после сегодняшней
    //*Написать метод, принимающий лист из нескольких дат типа LocalDate
    // и возвращающий количество дней между самой ранней и поздней датами
    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println(now);//2023-03-27

        System.out.println(LocalDate.parse("2023-03-27").getDayOfMonth());//27

        LocalDate of=LocalDate.of(2023,03,27);
        System.out.println(of);//2023-03-27

        LocalDate weddingAnniversary=LocalDate.of(2014,07,19);
        System.out.println(weddingAnniversary);//2014-07-19

        LocalDate one = LocalDate.now();
        LocalDate two = LocalDate.parse("2023-03-26");
        System.out.println(one.equals(two));//false

        LocalTime now1 = LocalTime.now();
        System.out.println(now1);//21:29:25.792291

        System.out.println(now1.plusHours(3));//00:30:08.059304400

        LocalDate weekLater = LocalDate.now().plusWeeks(1);
        System.out.println(weekLater);//2023-04-03

        LocalDate minus1year = LocalDate.now().minus(1, ChronoUnit.YEARS);
        System.out.println(minus1year);//2022-03-27

        LocalDate plus1year = LocalDate.now().plusYears(1);
        System.out.println(plus1year);//2024-03-27

        boolean yesterdayIsBefore = LocalDate.now().isBefore(LocalDate.parse("2023-03-26"));
        boolean yesterdayIsAfter = LocalDate.now().isAfter(LocalDate.parse("2023-03-26"));
        System.out.println(yesterdayIsBefore);//false
        System.out.println(yesterdayIsAfter);//true

        boolean tomorrowIsBefore = LocalDate.now().isBefore(LocalDate.of(2023,03,28));
        boolean tomorrowIsAfter = LocalDate.now().isAfter(LocalDate.of(2023,03,28));
        System.out.println(tomorrowIsBefore);//true
        System.out.println(tomorrowIsAfter);//false



        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusWeeks(1);
        System.out.println (end.toEpochDay()-start.toEpochDay());//7


        List<LocalDate> date = new LinkedList<>();
        Collections.addAll(date,
                LocalDate.now(),
                LocalDate.now().plusDays(10),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusWeeks(6),
                LocalDate.now().plusYears(1));

        System.out.println(daysInBetween(date));//366
        Collections.sort(date);
        System.out.println(date);
    }
    public static long daysInBetween(List<LocalDate> localDates){
        Collections.sort(localDates);
       return ChronoUnit.DAYS.between(localDates.get(0),localDates.get(localDates.size()-1));
    }

}
