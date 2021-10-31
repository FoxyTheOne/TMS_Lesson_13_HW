package com.tms.lesson13.prog00Date;
import java.time.LocalDate;

/**
 * 1. Получить день недели по дате
 */
public class DayOfWeekByDate {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2021, 11, 12);
        System.out.println(localDate + " will be on " + localDate.getDayOfWeek());
    }
}
