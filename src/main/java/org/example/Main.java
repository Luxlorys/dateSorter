package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        // separate month without 'r' to another collection
        // sorting two collection and then merge them
        // (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)


        IDateSorter ds = new DateRepository();

        List<LocalDate> ls = List.of(
                LocalDate.of(2005, 6, 21), // June
                LocalDate.of(2005, 7, 26), // July
                LocalDate.of(2005, 1, 14),
                LocalDate.of(2005, 9, 21),
                LocalDate.of(2002, 9, 20),
                LocalDate.of(2007, 3, 15)
        );

//        ls.stream().forEach(System.out::println);
        DateRepository dr = new DateRepository();
        dr.sortDates(ls).forEach(System.out::println);
    }
}