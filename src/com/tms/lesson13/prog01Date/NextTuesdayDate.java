package com.tms.lesson13.prog01Date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * 2. Получить дату следующего вторника
 */
public class NextTuesdayDate {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        TemporalAdjuster nextTuesday = TemporalAdjusters.next(DayOfWeek.TUESDAY);
        System.out.println("Next tuesday will be on " + now.with(nextTuesday));
    }
}
