package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Stream;

public class DateRepository  implements IDateSorter{
    private static final List<Month> PATTERN_WITHOUT_R = Arrays.asList(Month.AUGUST, Month.JULY, Month.JUNE, Month.MAY);
    private  static  final List<Month> PATTERN_WITH_R = Arrays.asList(Month.APRIL, Month.DECEMBER, Month.FEBRUARY,
            Month.JANUARY, Month.MARCH, Month.NOVEMBER,
            Month.OCTOBER, Month.SEPTEMBER);

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        // adding to a new collection and revers sorting months without R in the name
        Collection<LocalDate> listOfMonthWithoutR = unsortedDates
                .stream().
                filter(month -> PATTERN_WITHOUT_R.contains(month.getMonth()))
                .sorted(Comparator.reverseOrder())
                .toList();


        // adding to a new collection and sorting months with R in the name
        Collection<LocalDate> listOfMonthWithR = unsortedDates
                .stream()
                .filter(month -> PATTERN_WITH_R.contains(month.getMonth())).sorted().toList();


        return Stream.of(listOfMonthWithR, listOfMonthWithoutR)
                .flatMap(Collection::stream)
                .toList();
    }
}
